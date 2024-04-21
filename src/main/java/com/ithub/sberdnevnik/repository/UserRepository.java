package com.ithub.sberdnevnik.repository;

import com.ithub.sberdnevnik.models.AppUser;
import com.ithub.sberdnevnik.models.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    List<AppUser> findAll();
}
