package tz.ac.udsm.ECom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.User;
import tz.ac.udsm.ECom.repository.CategoryRepository;
import tz.ac.udsm.ECom.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {


    private final UserRepository repository;

    private final CategoryRepository categoryRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, CategoryRepository categoryRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user) throws DataNotFoundException {

        String encodedPass= passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPass);

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
