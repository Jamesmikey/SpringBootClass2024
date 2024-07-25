package tz.ac.udsm.ECom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.Role;
import tz.ac.udsm.ECom.model.User;
import tz.ac.udsm.ECom.repository.CategoryRepository;
import tz.ac.udsm.ECom.repository.RoleRepository;
import tz.ac.udsm.ECom.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {


    private final UserRepository repository;

    private final CategoryRepository categoryRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, CategoryRepository categoryRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user) throws DataNotFoundException {

        String encodedPass= passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPass);

        //Validate roles
        List<Role> tempRoles=new ArrayList<>();
        for(Role role:user.getRoles()){
            Role dbRole=roleRepository.findById(role.getId()).orElseThrow(() -> new DataNotFoundException("Role not found"));
            tempRoles.add(dbRole);
        }

        user.setRoles(tempRoles);

        return repository.save(user);
    }

    public Page<User> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public void update(Long id, User updateUser) throws DataNotFoundException {
        //Find user by id
        User user=repository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));

        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
        user.setPhoneNumber(updateUser.getPhoneNumber());

        //Validate roles
        List<Role> tempRoles=new ArrayList<>();
        for(Role role:user.getRoles()){
            Role dbRole=roleRepository.findById(role.getId()).orElseThrow(() -> new DataNotFoundException("Role not found"));
            tempRoles.add(dbRole);
        }

        user.setRoles(tempRoles);

        repository.save(user);
    }


    public void delete(Long id) throws DataNotFoundException {
        //Find user by id
        User user=repository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));

        repository.delete(user);
    }

    public User findById(Long id) throws DataNotFoundException {
        //Fetch existing category by id;
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
