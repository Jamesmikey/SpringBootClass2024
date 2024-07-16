package tz.ac.udsm.ECom.dto.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tz.ac.udsm.ECom.dto.category.CategoryRefDTO;


@Data
public class UpdateUserDTO {

    @NotEmpty(message = "Must provide name")
    private String name;

    @NotEmpty(message = "Must provide phone number")
    private String phoneNumber;

    @NotEmpty(message = "Must provide email")
    private String email;


}
