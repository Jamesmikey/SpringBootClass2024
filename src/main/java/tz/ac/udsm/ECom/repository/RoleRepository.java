package tz.ac.udsm.ECom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tz.ac.udsm.ECom.model.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends ListPagingAndSortingRepository<Role,Long>,CrudRepository<Role,Long> {
}
