package com.ithub.sberdnevnik.repository;

import com.ithub.sberdnevnik.models.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    Optional<Diary> findByDiaryId(long id);
}
