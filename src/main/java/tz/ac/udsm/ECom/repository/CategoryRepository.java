package tz.ac.udsm.ECom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import tz.ac.udsm.ECom.model.Category;

import java.util.List;


public interface CategoryRepository extends ListPagingAndSortingRepository<Category,Long>, CrudRepository<Category,Long> {

}
