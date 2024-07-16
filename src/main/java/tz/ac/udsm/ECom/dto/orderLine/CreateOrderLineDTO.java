package tz.ac.udsm.ECom.dto.orderLine;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tz.ac.udsm.ECom.dto.product.ProductRefDTO;
import tz.ac.udsm.ECom.dto.user.UserRefDTO;

import java.util.List;


@Data
public class CreateOrderLineDTO {

    @NotNull(message = "Must specify product")
    private ProductRefDTO product;

    private double price;

    private double quantity;
    
}
