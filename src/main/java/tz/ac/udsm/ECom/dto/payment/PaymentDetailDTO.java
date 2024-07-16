package tz.ac.udsm.ECom.dto.payment;

import lombok.Data;
import tz.ac.udsm.ECom.dto.order.OrderRefDTO;
import tz.ac.udsm.ECom.model.User;


@Data
public class PaymentDetailDTO {

    private Long id;

    private OrderRefDTO order;

    private double amount;
    
}
