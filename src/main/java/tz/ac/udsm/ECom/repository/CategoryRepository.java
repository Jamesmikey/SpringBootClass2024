package tz.ac.udsm.ECom.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import tz.ac.udsm.ECom.model.Category;

import java.util.List;


public interface CategoryRepository extends ListPagingAndSortingRepository<Category,Long>, CrudRepository<Category,Long> {

    Page<Category> findAllByName(String name, Pageable pageable);

    boolean existsByName(String name);



}
