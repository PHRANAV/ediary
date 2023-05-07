package com.example.diary.controller;

import com.example.diary.model.DiaryEntry;
import com.example.diary.service.DiaryEntryService;
import com.example.diary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    private DiaryEntryService diaryEntryService;
    private UserService userService;

    @Autowired
    public DiaryController(DiaryEntryService diaryEntryService, UserService userService) {
        this.diaryEntryService = diaryEntryService;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listDiaryEntries(Model model, Principal principal) {
        String username = principal.getName();
        List<DiaryEntry> diaryEntries = diaryEntryService.findAllByUsername(username);
        model.addAttribute("diaryEntries", diaryEntries);
        return "list-diary-entries";
    }

    @GetMapping("/add")
    public String addDiaryEntry(Model model) {
        model.addAttribute("diaryEntry", new DiaryEntry());
        return "diary-entry";
    }

    @PostMapping("/save")
    public String saveDiaryEntry(@ModelAttribute DiaryEntry diaryEntry, Principal principal) {
        String username = principal.getName();
        diaryEntry.setUsername(username);
        diaryEntryService.save(diaryEntry);
        return "redirect:/diary/list";
    }

    @GetMapping("/update/{id}")
    public String updateDiaryEntry(@PathVariable Long id, Model model) {
        DiaryEntry diaryEntry = diaryEntryService.findById(id);
        model.addAttribute("diaryEntry", diaryEntry);
        return "diary-entry";
    }

    @GetMapping("/delete/{id}")
    public String deleteDiaryEntry(@PathVariable Long id) {
        diaryEntryService.deleteById(id);
        return "redirect:/diary/list";
    }
}
