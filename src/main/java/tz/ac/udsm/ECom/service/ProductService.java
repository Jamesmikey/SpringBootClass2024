package tz.ac.udsm.ECom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

        Category category=categoryRepository.findById(product.getCategory().getId()).orElseThrow(() -> new DataNotFoundException("Catgory not found"));

        product.setCategory(category);

        return repository.save(product);
    }

    public Page<Product> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public void update(Long id, Product updateProduct) throws DataNotFoundException {
        //Find product by id
        Product product=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Product not found"));

        product.setName(updateProduct.getName());

        product.setPrice(updateProduct.getPrice());

        product.setExpiryDate(updateProduct.getExpiryDate());

        Category category=categoryRepository.findById(updateProduct.getCategory().getId()).orElseThrow(() -> new DataNotFoundException("Catgory not found"));

        product.setCategory(category);

        repository.save(product);
    }


    public void delete(Long id) throws DataNotFoundException {
        //Find product by id
        Product product=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Product not found"));

        repository.delete(product);
    }

    public Product findById(Long id) throws DataNotFoundException {
        //Fetch existing category by id;
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("Product not found"));
    }

}
