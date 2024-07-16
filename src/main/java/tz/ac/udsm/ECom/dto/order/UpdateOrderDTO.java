package tz.ac.udsm.ECom.dto.order;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import tz.ac.udsm.ECom.dto.product.ProductRefDTO;

import java.util.List;


@Data
public class UpdateOrderDTO {

    @NotEmpty(message = "Must provide at least one product")
    private List<ProductRefDTO> products;
    
}
