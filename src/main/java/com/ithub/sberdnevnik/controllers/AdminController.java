package com.ithub.sberdnevnik.controllers;

import com.ithub.sberdnevnik.SberDnevnikApplication;
import com.ithub.sberdnevnik.models.StudentClass;
import com.ithub.sberdnevnik.models.Subject;
import com.ithub.sberdnevnik.repository.StudentClassRepository;
import com.ithub.sberdnevnik.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StudentClassRepository studentClassRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @PostMapping("/newClass")
    public ResponseEntity newClass(@RequestBody StudentClass studentClass) {
        if (!Objects.equals(SberDnevnikApplication.currentUser, null) && SberDnevnikApplication.currentUser.getRole().contains("ADMIN")) {
            studentClassRepository.save(studentClass);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("/newSubject")
    public ResponseEntity newSubject(@RequestBody Subject subject) {
        if (!Objects.equals(SberDnevnikApplication.currentUser, null) && SberDnevnikApplication.currentUser.getRole().contains("ADMIN")) {
            subjectRepository.save(subject);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
