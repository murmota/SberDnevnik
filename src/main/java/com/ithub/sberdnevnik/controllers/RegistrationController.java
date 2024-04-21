package com.ithub.sberdnevnik.controllers;

import com.ithub.sberdnevnik.SberDnevnikApplication;
import com.ithub.sberdnevnik.models.AppUser;
import com.ithub.sberdnevnik.models.SigninRequest;
import com.ithub.sberdnevnik.models.UserDetailsImpl;
import com.ithub.sberdnevnik.repository.UserRepository;
import com.ithub.sberdnevnik.security.JwtCore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@Slf4j
public class RegistrationController {
    @Autowired
    private UserRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtCore jwtCore;
    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<AppUser> userExists = myUserRepository.findByUsername(user.getUsername());
        if (userExists.isEmpty()) return ResponseEntity.ok(myUserRepository.save(user));
        return ResponseEntity.ok("Такой пользователь уже существует");

    }
    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody SigninRequest request) {
        if (myUserRepository.findByUsername(request.getUsername()).isPresent()) {
            UserDetailsImpl user = UserDetailsImpl.build(myUserRepository.findByUsername(request.getUsername()).get());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            String jwt = jwtCore.generateToken(user);
            SberDnevnikApplication.currentUser = user;
            return ResponseEntity.ok(jwt);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
