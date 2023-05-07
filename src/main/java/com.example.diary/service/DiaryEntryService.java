package com.example.diary.service;

import com.example.diary.model.DiaryEntry;
import com.example.diary.repository.DiaryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryEntryService {

    @Autowired
    private DiaryEntryRepository diaryEntryRepository;

    public List<DiaryEntry> getAllDiaryEntries() {
        return diaryEntryRepository.findAll();
    }

    public DiaryEntry getDiaryEntryById(Long id) {
        return diaryEntryRepository.findById(id).orElse(null);
    }

    public DiaryEntry saveDiaryEntry(DiaryEntry diaryEntry) {
        return diaryEntryRepository.save(diaryEntry);
    }

    public void deleteDiaryEntry(Long id) {
        diaryEntryRepository.deleteById(id);
    }

}
