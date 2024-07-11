package tz.ac.udsm.ECom.dto.product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tz.ac.udsm.ECom.dto.category.CategoryRefDTO;
import tz.ac.udsm.ECom.model.Category;


@Data
public class UpdateProductDTO {

    @NotEmpty(message = "Must provide name")
    private String name;

    @Max(value = 1000)
    private double price;

    private String expiryDate;

    @NotNull
    @Valid
    private CategoryRefDTO category;
    
}
