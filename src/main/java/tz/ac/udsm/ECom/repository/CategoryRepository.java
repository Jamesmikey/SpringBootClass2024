package tz.ac.udsm.ECom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tz.ac.udsm.ECom.model.Category;
import tz.ac.udsm.ECom.model.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

}
