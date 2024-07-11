package tz.ac.udsm.ECom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tz.ac.udsm.ECom.model.Category;
import tz.ac.udsm.ECom.model.Order;

@Repository
public interface OrderRepository extends ListPagingAndSortingRepository<Order,Long>,CrudRepository<Order,Long> {

}
