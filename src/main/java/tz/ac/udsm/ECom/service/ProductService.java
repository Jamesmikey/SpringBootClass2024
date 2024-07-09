package tz.ac.udsm.ECom.service;

import org.springframework.stereotype.Service;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.Category;
import tz.ac.udsm.ECom.model.Product;
import tz.ac.udsm.ECom.repository.CategoryRepository;
import tz.ac.udsm.ECom.repository.ProductRepository;

@Service
public class ProductService {


    private final ProductRepository repository;

    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public Product save(Product product) throws DataNotFoundException {

        if(product.getCategory()==null){
           throw new UnsupportedOperationException("Can not insert product without category");
        }

        Category category=categoryRepository.findById(product.getCategory().getId()).orElseThrow(() -> new DataNotFoundException("Catgory not found"));

        product.setCategory(category);

        return repository.save(product);
    }

    public Iterable<Product> findAll(){
        return repository.findAll();
    }

    public void update(Long id, Product updateProduct) throws DataNotFoundException {
        //Find product by id
        Product product=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Product not found"));

        product.setName(updateProduct.getName());

        product.setPrice(updateProduct.getPrice());

        product.setExpiryDate(updateProduct.getExpiryDate());

        product.setCategory(updateProduct.getCategory());

        repository.save(product);
    }


    public void delete(Long id) throws DataNotFoundException {
        //Find product by id
        Product product=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Product not found"));

        repository.delete(product);
    }

}
