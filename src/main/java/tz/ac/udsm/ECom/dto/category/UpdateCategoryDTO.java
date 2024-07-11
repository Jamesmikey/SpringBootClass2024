package tz.ac.udsm.ECom.dto.category;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateCategoryDTO {

    @NotEmpty(message = "Must provide name")
    private String name;

}
