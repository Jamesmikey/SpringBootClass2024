package tz.ac.udsm.ECom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tz.ac.udsm.ECom.model.Order;
import tz.ac.udsm.ECom.model.Product;
import tz.ac.udsm.ECom.model.User;

@Repository
public interface UserRepository extends ListPagingAndSortingRepository<User,Long>,CrudRepository<User,Long> {

}
