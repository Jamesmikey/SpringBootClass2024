package tz.ac.udsm.ECom.dto.user;

import lombok.Data;
import tz.ac.udsm.ECom.dto.category.CategoryDetailDTO;
import tz.ac.udsm.ECom.enums.UserType;


@Data
public class UserDetailDTO {

    private Long id;


    private String name;

    private String phoneNumber;

    private String email;

    private UserType type;
}
