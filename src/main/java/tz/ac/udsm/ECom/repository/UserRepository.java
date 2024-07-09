package tz.ac.udsm.ECom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tz.ac.udsm.ECom.model.Product;
import tz.ac.udsm.ECom.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
