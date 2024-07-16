package tz.ac.udsm.ECom.model;

import jakarta.persistence.*;
import lombok.Data;
import tz.ac.udsm.ECom.enums.UserType;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    private String password;

    private UserType type;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Order> orders;
    
}
