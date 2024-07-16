package tz.ac.udsm.ECom.dto.order;

import lombok.Data;
import tz.ac.udsm.ECom.dto.category.CategoryDetailDTO;
import tz.ac.udsm.ECom.dto.user.UserDetailDTO;
import tz.ac.udsm.ECom.dto.user.UserRefDTO;
import tz.ac.udsm.ECom.model.User;


@Data
public class OrderDetailDTO {

    private Long id;

    private UserDetailDTO customer;
    
}
