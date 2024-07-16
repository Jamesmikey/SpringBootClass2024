package tz.ac.udsm.ECom.dto.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tz.ac.udsm.ECom.dto.orderLine.CreateOrderLineDTO;
import tz.ac.udsm.ECom.dto.user.UserRefDTO;

import java.util.List;


@Data
public class CreateOrderDTO {

    @NotEmpty(message = "Must provide at least one order line")
    @Valid
    List<CreateOrderLineDTO> orderLines;

    @NotNull(message = "Must provide customer")
    @Valid
    private UserRefDTO customer;

}
