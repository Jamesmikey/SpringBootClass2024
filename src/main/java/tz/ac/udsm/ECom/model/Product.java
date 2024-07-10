package tz.ac.udsm.ECom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String name;

    private double price;

    private String expiryDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cat_id",nullable = false)
    private Category category;
    
}
