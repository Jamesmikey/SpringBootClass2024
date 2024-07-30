package tz.ac.udsm.ECom.controller;


import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tz.ac.udsm.ECom.dto.auth.LoginRequest;
import tz.ac.udsm.ECom.dto.auth.LoginResponse;
import tz.ac.udsm.ECom.model.User;
import tz.ac.udsm.ECom.security.JwtService;
import tz.ac.udsm.ECom.service.AuthenticationService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    private final ModelMapper modelMapper;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService, ModelMapper modelMapper) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.modelMapper = modelMapper;
    }

//    @PostMapping("/signup")
//    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
//        User registeredUser = authenticationService.signup(registerUserDto);
//
//        return ResponseEntity.ok(registeredUser);
//    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody @Valid LoginRequest loginRequest) {

        User user=new User();
        user.setEmail(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());

        User authenticatedUser = authenticationService.authenticate(user);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setUsername(authenticatedUser.getUsername());
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}