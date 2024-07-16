package tz.ac.udsm.ECom.dto.payment;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tz.ac.udsm.ECom.dto.order.OrderRefDTO;


@Data
public class CreatePaymentDTO {

    @NotNull(message = "Must specify order")
    private OrderRefDTO order;

    private double amount;
    
}
