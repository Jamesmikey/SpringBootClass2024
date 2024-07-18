package tz.ac.udsm.ECom.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private  PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();


    @GetMapping("/password-encoder")
    public String testPasswordEcoder(@RequestParam String password){
            String hashedPassword=passwordEncoder.encode(password);
            return hashedPassword;
    }

    @GetMapping("/password-match")
    public boolean match(@RequestParam String password){
        String dbPassword="{bcrpt}$2a$16$9V0xpCjVaNfmGyrqML9oGe5/lFzeRYky22pAvMdtUv/W1Y.ZbUrWm";
        boolean isEqual=passwordEncoder.matches(password,dbPassword);
        return isEqual;
    }
}
