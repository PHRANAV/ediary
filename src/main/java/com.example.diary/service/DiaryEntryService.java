package com.example.diary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diary.model.DiaryEntry;
import com.example.diary.repository.DiaryEntryRepository;

@Service
public class DiaryEntryService {

    private DiaryEntryRepository diaryEntryRepository;

    @Autowired
    public DiaryEntryService(DiaryEntryRepository diaryEntryRepository) {
        this.diaryEntryRepository = diaryEntryRepository;
    }

    public List<DiaryEntry> getAllEntries() {
        return diaryEntryRepository.findAll();
    }

    public Optional<DiaryEntry> getEntryById(Long id) {
        return diaryEntryRepository.findById(id);
    }

    public DiaryEntry saveEntry(DiaryEntry entry) {
        return diaryEntryRepository.save(entry);
    }

    public void deleteEntryById(Long id) {
        diaryEntryRepository.deleteById(id);
    }

    public List<DiaryEntry> getAllEntriesByUserId(Long userId) {
        return diaryEntryRepository.findByUserId(userId);
    }

}
