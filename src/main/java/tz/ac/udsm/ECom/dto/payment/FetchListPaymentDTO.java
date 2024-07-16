package tz.ac.udsm.ECom.dto.payment;

import lombok.Data;
import tz.ac.udsm.ECom.dto.order.OrderDetailDTO;
import tz.ac.udsm.ECom.dto.order.OrderRefDTO;
import tz.ac.udsm.ECom.model.User;


@Data
public class FetchListPaymentDTO {

    private Long id;

    private OrderDetailDTO order;

    private double amount;
    
}
