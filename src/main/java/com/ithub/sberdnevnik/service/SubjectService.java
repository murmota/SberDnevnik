package com.ithub.sberdnevnik.service;

import com.ithub.sberdnevnik.models.Diary;
import com.ithub.sberdnevnik.models.Subject;
import com.ithub.sberdnevnik.repository.DiaryRepository;
import com.ithub.sberdnevnik.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    public Subject loadSubjectByName(String name) throws Exception {
        Optional<Subject> subject = subjectRepository.findBySubjectName(name);
        if (subject.isPresent()) {
            return subject.get();
        }
        else {
            throw new Exception("Предмет не найден");
        }
    }
}
