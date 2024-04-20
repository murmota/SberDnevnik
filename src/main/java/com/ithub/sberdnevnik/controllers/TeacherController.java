package com.ithub.sberdnevnik.controllers;

import com.ithub.sberdnevnik.SberDnevnikApplication;
import com.ithub.sberdnevnik.models.Diary;
import com.ithub.sberdnevnik.models.Student;
import com.ithub.sberdnevnik.repository.DiaryRepository;
import com.ithub.sberdnevnik.repository.StudentRepository;
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
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/newDiary")
    public ResponseEntity newDiaryColumn(@RequestBody Diary diary) {
        if (!Objects.equals(SberDnevnikApplication.currentUser, null) && SberDnevnikApplication.currentUser.getRole().contains("TEACHER")) {
            diaryRepository.save(diary);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("/newStudent")
    public ResponseEntity newStudent(@RequestBody Student student) {
        if (!Objects.equals(SberDnevnikApplication.currentUser, null) && SberDnevnikApplication.currentUser.getRole().contains("TEACHER")) {
            studentRepository.save(student);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
