package tz.ac.udsm.ECom.dto.orderLine;

import lombok.Data;
import tz.ac.udsm.ECom.dto.category.CategoryDetailDTO;
import tz.ac.udsm.ECom.dto.product.ProductDetailDTO;


@Data
public class FetchListOrderLineDTO {

    private Long id;

    private double price;

    private double quantity;

    private ProductDetailDTO product;

    
}
