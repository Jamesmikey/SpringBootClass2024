package tz.ac.udsm.ECom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tz.ac.udsm.ECom.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {

}
