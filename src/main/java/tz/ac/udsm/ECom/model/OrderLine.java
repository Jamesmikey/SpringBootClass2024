package tz.ac.udsm.ECom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_lines")
@Data
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;


    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

    private double price;

    private double quantity;


}
