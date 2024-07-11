package tz.ac.udsm.ECom.dto.category;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRefDTO {
    @NotNull(message = "Must provide category ID")
    private Long id;
}
