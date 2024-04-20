package com.ithub.sberdnevnik.service;

import com.ithub.sberdnevnik.models.Student;
import com.ithub.sberdnevnik.models.Subject;
import com.ithub.sberdnevnik.repository.StudentRepository;
import com.ithub.sberdnevnik.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public Student loadStudentByName(String name) throws Exception {
        Optional<Student> student = studentRepository.findByStudentName(name);
        if (student.isPresent()) {
            return student.get();
        }
        else {
            throw new Exception("Студент не найден");
        }
    }
}
