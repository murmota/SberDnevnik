package com.ithub.sberdnevnik.service;

import com.ithub.sberdnevnik.models.Student;
import com.ithub.sberdnevnik.models.StudentClass;
import com.ithub.sberdnevnik.repository.DiaryRepository;
import com.ithub.sberdnevnik.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentClassService {
    @Autowired
    private StudentClassRepository studentClassRepository;
    public StudentClass loadStudentClassByName(String name) throws Exception {
        Optional<StudentClass> studentClass = studentClassRepository.findByStudentClassNumber(name);
        if (studentClass.isPresent()) {
            return studentClass.get();
        }
        else {
            throw new Exception("Класс не найден");
        }
    }
}
