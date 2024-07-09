package tz.ac.udsm.ECom.model;

import jakarta.persistence.*;
import lombok.Data;
import tz.ac.udsm.ECom.enums.UserType;

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
    
}
