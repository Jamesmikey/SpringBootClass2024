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


}