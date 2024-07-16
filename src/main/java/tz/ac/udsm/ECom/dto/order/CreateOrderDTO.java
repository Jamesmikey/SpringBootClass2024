package tz.ac.udsm.ECom.dto.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tz.ac.udsm.ECom.dto.category.CategoryRefDTO;
import tz.ac.udsm.ECom.dto.product.ProductRefDTO;
import tz.ac.udsm.ECom.dto.user.UserRefDTO;
import tz.ac.udsm.ECom.model.User;

import java.util.List;


@Data
public class CreateOrderDTO {

    @NotEmpty(message = "Must provide at least one product")
    List<ProductRefDTO> products;

    @NotNull(message = "Must provide customer")
    @Valid
    private UserRefDTO customer;
    
}
