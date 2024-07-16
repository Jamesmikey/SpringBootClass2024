package tz.ac.udsm.ECom.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.ECom.dto.category.CategoryDetailDTO;
import tz.ac.udsm.ECom.dto.category.CreateCategoryDTO;
import tz.ac.udsm.ECom.dto.category.FetchListCategoryDTO;
import tz.ac.udsm.ECom.dto.category.UpdateCategoryDTO;
import tz.ac.udsm.ECom.dto.product.FetchListProductDTO;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.Category;
import tz.ac.udsm.ECom.model.Product;
import tz.ac.udsm.ECom.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    private final ModelMapper modelMapper;

    public CategoryController(CategoryService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public CategoryDetailDTO save(@RequestBody @Valid CreateCategoryDTO categoryDTO){

        Category category=modelMapper.map(categoryDTO,Category.class);

        return modelMapper.map(service.save(category),CategoryDetailDTO.class);
    }

    @GetMapping
    public Page<FetchListCategoryDTO> findAll(@RequestParam(required = false,defaultValue = "Cars") String name,Pageable pageable){

        Page<Category> categories= service.findAll(name,pageable);

        return categories.map(category -> modelMapper.map(category, FetchListCategoryDTO.class));

    }

    @GetMapping("/{id}/products")
    public List<FetchListProductDTO> findAllProducts(@PathVariable Long id) throws DataNotFoundException {

        List<Product> products= service.findAllProducts(id);

        return products.stream().map(product -> modelMapper.map(product, FetchListProductDTO.class)).collect(Collectors.toList());

    }

    @PutMapping("/{id}")
    public String edit(@PathVariable  Long id,@RequestBody @Valid UpdateCategoryDTO updateCategoryDTO) throws DataNotFoundException {

        Category category=modelMapper.map(updateCategoryDTO,Category.class);

        service.update(id,category);

        return "Category saved successfully..";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws DataNotFoundException {
        service.delete(id);
        return "Category deleted successfully..";
    }

    @GetMapping("/{id}")
    public CategoryDetailDTO findOne(@PathVariable Long id) throws DataNotFoundException {
       return modelMapper.map(service.findById(id),CategoryDetailDTO.class);
    }

}
