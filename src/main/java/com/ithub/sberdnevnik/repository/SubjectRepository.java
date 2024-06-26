package com.ithub.sberdnevnik.repository;

import com.ithub.sberdnevnik.models.Diary;
import com.ithub.sberdnevnik.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Optional<Subject> findBySubjectName(String name);
    List<Subject> findAll();
}
