package com.ithub.sberdnevnik.service;

import com.ithub.sberdnevnik.models.Diary;
import com.ithub.sberdnevnik.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaryService{
    @Autowired
    private DiaryRepository diaryRepository;
    public Diary loadDiaryByDiaryId(long id) throws Exception {
        Optional<Diary> diary = diaryRepository.findByDiaryId(id);
        if (diary.isPresent()) {
            return diary.get();
        }
        else {
            throw new Exception("Запись не найдена");
        }
    }
    public List<Diary> loadDiaries() {
        return diaryRepository.findAll();
    }
}
