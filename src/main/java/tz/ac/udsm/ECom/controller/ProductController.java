package tz.ac.udsm.ECom.controller;

import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.Product;
import tz.ac.udsm.ECom.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody Product product) throws DataNotFoundException {
        service.save(product);
        return "Data saved to the Database";
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public String edit(@PathVariable Long id, @RequestBody Product updateProduct) throws DataNotFoundException {
        service.update(id,updateProduct);
        return "Product updated successfully";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws DataNotFoundException {
       service.delete(id);
       return "Product deleted successfully";
    }

}
