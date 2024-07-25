package tz.ac.udsm.ECom.dto.role;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class CreateRoleDTO {

    @NotEmpty(message = "Must provide name")
    private String name;
}
