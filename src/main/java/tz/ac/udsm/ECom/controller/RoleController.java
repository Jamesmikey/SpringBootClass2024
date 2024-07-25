package tz.ac.udsm.ECom.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.ECom.dto.role.CreateRoleDTO;
import tz.ac.udsm.ECom.dto.role.FetchListRoleDTO;
import tz.ac.udsm.ECom.dto.role.UpdateRoleDTO;
import tz.ac.udsm.ECom.dto.role.RoleDetailDTO;
import tz.ac.udsm.ECom.exception.DataNotFoundException;
import tz.ac.udsm.ECom.model.Role;
import tz.ac.udsm.ECom.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {


    private final RoleService service;

    private final ModelMapper modelMapper;

    public RoleController(RoleService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public RoleDetailDTO create(@RequestBody @Valid CreateRoleDTO createRoleDTO) throws DataNotFoundException {

        Role role=modelMapper.map(createRoleDTO,Role.class);

        return modelMapper.map(service.save(role),RoleDetailDTO.class);
    }

    @GetMapping
    public Page<FetchListRoleDTO> findAll(Pageable pageable){

        Page<Role> roles= service.findAll(pageable);

        return roles.map(category -> modelMapper.map(category, FetchListRoleDTO.class));

    }

    @PutMapping("/{id}")
    public String edit(@PathVariable Long id, @RequestBody @Valid UpdateRoleDTO updateRoleDTO) throws DataNotFoundException {

        Role role=modelMapper.map(updateRoleDTO,Role.class);

        service.update(id,role);

        return "Role updated successfully";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws DataNotFoundException {
       service.delete(id);
       return "Role deleted successfully";
    }

    @GetMapping("/{id}")
    public RoleDetailDTO findOne(@PathVariable Long id) throws DataNotFoundException {
        return modelMapper.map(service.findById(id),RoleDetailDTO.class);
    }

}
