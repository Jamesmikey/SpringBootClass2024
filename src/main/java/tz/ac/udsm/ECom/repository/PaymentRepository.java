package tz.ac.udsm.ECom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tz.ac.udsm.ECom.model.Order;
import tz.ac.udsm.ECom.model.Payment;
import tz.ac.udsm.ECom.model.Product;

@Repository
public interface PaymentRepository extends ListPagingAndSortingRepository<Payment,Long>,CrudRepository<Payment,Long> {

}
