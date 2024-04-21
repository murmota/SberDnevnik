package com.ithub.sberdnevnik.repository;

import com.ithub.sberdnevnik.models.Diary;
import com.ithub.sberdnevnik.models.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {
    Optional<StudentClass> findByStudentClassNumber(String name);
    List<StudentClass> findAll();
}
