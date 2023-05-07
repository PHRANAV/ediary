package com.example.diary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diary.model.DiaryEntry;
import com.example.diary.model.User;

@Repository
public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Long> {
    
    List<DiaryEntry> findAllByUserOrderByDateDesc(User user);

}
