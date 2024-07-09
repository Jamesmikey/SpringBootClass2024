package tz.ac.udsm.ECom.controller;

import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.Category;
import tz.ac.udsm.ECom.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category save(@RequestBody Category category){
        return service.save(category);
    }

    @GetMapping
    public Iterable<Category> findAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public String edit(@PathVariable  Long id,@RequestBody Category categoryUpdate) throws DataNotFoundException {
        service.update(id,categoryUpdate);

        return "Category saved successfully..";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws DataNotFoundException {
        service.delete(id);
        return "Category deleted successfully..";
    }

}
