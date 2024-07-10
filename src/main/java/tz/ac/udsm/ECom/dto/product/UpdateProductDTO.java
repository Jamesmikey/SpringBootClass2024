package tz.ac.udsm.ECom.dto.product;

import lombok.Data;
import tz.ac.udsm.ECom.dto.category.CategoryRefDTO;
import tz.ac.udsm.ECom.model.Category;


@Data
public class UpdateProductDTO {

    private String name;

    private double price;

    private String expiryDate;
    
    private CategoryRefDTO category;
    
}
