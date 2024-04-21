package com.ithub.sberdnevnik.repository;

import com.ithub.sberdnevnik.models.Diary;
import com.ithub.sberdnevnik.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentName(String name);
    List<Student> findAll();
}
