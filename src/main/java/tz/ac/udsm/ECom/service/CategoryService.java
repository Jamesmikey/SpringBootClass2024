package tz.ac.udsm.ECom.service;

import org.springframework.stereotype.Service;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.Category;
import tz.ac.udsm.ECom.repository.CategoryRepository;

@Service
public class CategoryService {


    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Iterable<Category> findAll() {
        return repository.findAll();
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public void update(Long id, Category categoryUpdate) throws DataNotFoundException {

        //Fetch existing category by id;
        Category category = repository.findById(id).orElseThrow(()->new DataNotFoundException("Category not found"));

        //Update name of category
        category.setName(categoryUpdate.getName());

        //Save category
        repository.save(category);


//        //Fetch existing category by id;
//        Optional<Category> optionalCategory=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Category not found"));
//
//        if(optionalCategory.isPresent()){
//            //Get category which is from database
//            Category category=optionalCategory.get();
//
//            //Update name of category
//            category.setName(categoryUpdate.getName());
//
//            //Save category
//            repository.save(category);
//        }else{
//            //Throw an exception if data not found
//            throw new DataNotFoundException("Category not found");
//        }
    }


    public void delete(Long id) throws DataNotFoundException {
        //Fetch existing category by id;
        Category category = repository.findById(id).orElseThrow(() -> new DataNotFoundException("Category not found"));

        repository.delete(category);

    }

}
