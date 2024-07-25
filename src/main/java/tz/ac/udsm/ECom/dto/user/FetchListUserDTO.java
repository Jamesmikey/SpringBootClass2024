package tz.ac.udsm.ECom.dto.user;

import lombok.Data;
import tz.ac.udsm.ECom.dto.category.CategoryDetailDTO;
import tz.ac.udsm.ECom.enums.UserType;
import tz.ac.udsm.ECom.model.Role;

import java.util.List;


@Data
public class FetchListUserDTO {

    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    private UserType type;

    private List<Role> roles;
}
