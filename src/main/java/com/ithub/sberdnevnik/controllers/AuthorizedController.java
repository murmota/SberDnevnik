package com.ithub.sberdnevnik.controllers;

import com.ithub.sberdnevnik.models.Diary;
import com.ithub.sberdnevnik.models.Student;
import com.ithub.sberdnevnik.models.StudentClass;
import com.ithub.sberdnevnik.models.Subject;
import com.ithub.sberdnevnik.repository.DiaryRepository;
import com.ithub.sberdnevnik.repository.StudentClassRepository;
import com.ithub.sberdnevnik.repository.StudentRepository;
import com.ithub.sberdnevnik.repository.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/authorized")
public class AuthorizedController {
    @Autowired
    private DiaryRepository diaryRepository;
    @GetMapping("/findDiary/{id}")
    public ResponseEntity<Optional<Diary>> getDiaryColumn(@PathVariable("id") long id) {
        return ResponseEntity.ok(diaryRepository.findByDiaryId(id));
    }
    @Autowired
    private StudentClassRepository studentClassRepository;
    @GetMapping("/findClass/{name}")
    public ResponseEntity<Optional<StudentClass>> getClass(@PathVariable("name") String name) {
        return ResponseEntity.ok(studentClassRepository.findByStudentClassNumber(name));
    }
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/findStudent/{name}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable("name") String name) {
        return ResponseEntity.ok(studentRepository.findByStudentName(name));
    }
    @Autowired
    private SubjectRepository subjectRepository;
    @GetMapping("/findSubject/{name}")
    public ResponseEntity<Optional<Subject>> getSubject(@PathVariable("name") String name) {
        return ResponseEntity.ok(subjectRepository.findBySubjectName(name));
    }
}
