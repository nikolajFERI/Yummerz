package com.yummerz.yummerz.user;

import com.yummerz.yummerz.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class UserAuthController {

    @Autowired private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder encoder;
    @Autowired private JwtUtils jwtUtils;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        User dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (encoder.matches(user.getPassword(), dbUser.getPassword())) {
            String token = jwtUtils.generateToken(dbUser.getUsername());
            return Map.of("token", token);
        }
        throw new RuntimeException("Invalid credentials");
    }
}