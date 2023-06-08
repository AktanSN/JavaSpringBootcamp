package com.aktansanhal.weatherfinalcase.auth;

import com.aktansanhal.weatherfinalcase.configuration.WeatherAppUserDetails;
import com.aktansanhal.weatherfinalcase.entity.User;
import com.aktansanhal.weatherfinalcase.kafka.ProducerService;
import com.aktansanhal.weatherfinalcase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin
public class AuthController {

    private static final Logger logger = Logger.getLogger(AuthController.class.getName());

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private UserRepository userRepository;

    @Autowired
    private ProducerService producerService;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/api/1.0/auth")
    public ResponseEntity<?> handleAuthentication() {
        //log.info("AuthController handleAuthentication method called");
        String record = String.format("[%s:%d] AuthController handleAuthentication method called", getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getLineNumber());
        producerService.sendMessage(record, "info");

        WeatherAppUserDetails weatherAppUserDetails = (WeatherAppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = weatherAppUserDetails.getUsername();

        User inDB = userRepository.findByUsername(username);
        //log.info("AuthController handleAuthentication method called with username: {}", username);
        record = String.format("[%s:%d] AuthController handleAuthentication method called with username: %s", getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getLineNumber(), username);
        producerService.sendMessage(record, "info");
        return ResponseEntity.ok(inDB);

        }

}
