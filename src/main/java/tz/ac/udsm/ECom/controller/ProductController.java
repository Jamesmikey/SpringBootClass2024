package tz.ac.udsm.ECom.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.ECom.dto.category.CategoryDetailDTO;
import tz.ac.udsm.ECom.dto.category.FetchListCategoryDTO;
import tz.ac.udsm.ECom.dto.product.CreateProductDTO;
import tz.ac.udsm.ECom.dto.product.FetchListProductDTO;
import tz.ac.udsm.ECom.dto.product.ProductDetailDTO;
import tz.ac.udsm.ECom.dto.product.UpdateProductDTO;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.Category;
import tz.ac.udsm.ECom.model.Product;
import tz.ac.udsm.ECom.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService service;

    private final ModelMapper modelMapper;

    public ProductController(ProductService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ProductDetailDTO create(@RequestBody @Valid CreateProductDTO createProductDTO) throws DataNotFoundException {

        Product product=modelMapper.map(createProductDTO,Product.class);

        return modelMapper.map(service.save(product),ProductDetailDTO.class);
    }

    @GetMapping
    public Iterable<FetchListProductDTO> findAll(){

        Iterable<Product> products= service.findAll();

        List<FetchListProductDTO> newList=new ArrayList<>();

        for(Product product:products){
            newList.add(modelMapper.map(product,FetchListProductDTO.class));
        }

        return newList;
//        return Stream.of(service.findAll()).map((p)-> modelMapper.map(p,FetchListProductDTO.class)).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public String edit(@PathVariable Long id, @RequestBody @Valid UpdateProductDTO updateProductDTO) throws DataNotFoundException {

        Product product=modelMapper.map(updateProductDTO,Product.class);

        service.update(id,product);

        return "Product updated successfully";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws DataNotFoundException {
       service.delete(id);
       return "Product deleted successfully";
    }

    @GetMapping("/{id}")
    public ProductDetailDTO findOne(@PathVariable Long id) throws DataNotFoundException {
        return modelMapper.map(service.findById(id),ProductDetailDTO.class);
    }

}
