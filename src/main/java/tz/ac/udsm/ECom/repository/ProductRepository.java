package tz.ac.udsm.ECom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tz.ac.udsm.ECom.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

}