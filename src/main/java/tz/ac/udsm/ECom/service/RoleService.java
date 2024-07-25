package tz.ac.udsm.ECom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.Role;
import tz.ac.udsm.ECom.repository.RoleRepository;

@Service
public class RoleService {


    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role save(Role role) throws DataNotFoundException {
        return repository.save(role);
    }

    public Page<Role> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public void update(Long id, Role updateRole) throws DataNotFoundException {
        //Find role by id
        Role role=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Role not found"));

        role.setName(updateRole.getName());

        repository.save(role);
    }


    public void delete(Long id) throws DataNotFoundException {
        //Find role by id
        Role role=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Role not found"));

        repository.delete(role);
    }

    public Role findById(Long id) throws DataNotFoundException {
        //Fetch existing category by id;
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("Role not found"));
    }

}
