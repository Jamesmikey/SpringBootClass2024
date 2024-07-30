package tz.ac.udsm.ECom.dto.auth;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginResponse {

    private String token;

    private String username;

    private long expiresIn;
}
