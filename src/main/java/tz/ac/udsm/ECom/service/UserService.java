package tz.ac.udsm.ECom.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.User;
import tz.ac.udsm.ECom.repository.CategoryRepository;
import tz.ac.udsm.ECom.repository.UserRepository;

@Service
public class UserService {


    private final UserRepository repository;

    private final CategoryRepository categoryRepository;

    public UserService(UserRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public User save(User user) throws DataNotFoundException {

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

}
