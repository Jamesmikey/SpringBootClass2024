package tz.ac.udsm.ECom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tz.ac.udsm.ECom.model.Order;
import tz.ac.udsm.ECom.model.OrderLine;

@Repository
public interface OrderLineRepository extends ListPagingAndSortingRepository<OrderLine,Long>,CrudRepository<OrderLine,Long> {

}
