package com.ithub.sberdnevnik;

import com.ithub.sberdnevnik.models.AppUser;
import com.ithub.sberdnevnik.models.UserDetailsImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SberDnevnikApplication {
    public static UserDetailsImpl currentUser;
    public static void main(String[] args) {
        SpringApplication.run(SberDnevnikApplication.class, args);
    }

}
