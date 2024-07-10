package tz.ac.udsm.ECom.dto.product;

import lombok.Data;
import tz.ac.udsm.ECom.dto.category.CategoryDetailDTO;
import tz.ac.udsm.ECom.model.Category;


@Data
public class ProductDetailDTO {

    private Long id;

    private String name;

    private double price;

    private String expiryDate;

    private CategoryDetailDTO category;
    
}
