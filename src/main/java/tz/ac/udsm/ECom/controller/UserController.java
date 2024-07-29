package tz.ac.udsm.ECom.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.ECom.dto.user.CreateUserDTO;
import tz.ac.udsm.ECom.dto.user.FetchListUserDTO;
import tz.ac.udsm.ECom.dto.user.UserDetailDTO;
import tz.ac.udsm.ECom.dto.user.UpdateUserDTO;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.User;
import tz.ac.udsm.ECom.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService service;

    private final ModelMapper modelMapper;

    public UserController(UserService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public UserDetailDTO create(@RequestBody @Valid CreateUserDTO createUserDTO) throws DataNotFoundException {

        User user=modelMapper.map(createUserDTO,User.class);

        return modelMapper.map(service.save(user),UserDetailDTO.class);
    }

    @GetMapping
    public Page<FetchListUserDTO> findAll(Pageable pageable){

        Page<User> users= service.findAll(pageable);

        return users.map(category -> modelMapper.map(category, FetchListUserDTO.class));

    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String edit(@PathVariable Long id, @RequestBody @Valid UpdateUserDTO updateUserDTO) throws DataNotFoundException {

        User user=modelMapper.map(updateUserDTO,User.class);

        service.update(id,user);

        return "User updated successfully";
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String delete(@PathVariable Long id) throws DataNotFoundException {
       service.delete(id);
       return "User deleted successfully";
    }

    @GetMapping("/{id}")
    public UserDetailDTO findOne(@PathVariable Long id) throws DataNotFoundException {
        return modelMapper.map(service.findById(id),UserDetailDTO.class);
    }

}
