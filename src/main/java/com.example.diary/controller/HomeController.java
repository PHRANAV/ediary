@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/diary-entry")
    public String diaryEntry(Model model) {
        model.addAttribute("diaryEntry", new DiaryEntry());
        return "diary-entry";
    }

    @PostMapping("/diary-entry")
    public String saveDiaryEntry(@ModelAttribute("diaryEntry") DiaryEntry diaryEntry, Model model, Principal principal) {
        // Save the diary entry to the database
        diaryEntry.setCreatedDate(LocalDateTime.now());
        User currentUser = userService.findByUsername(principal.getName());
        diaryEntry.setUser(currentUser);
        diaryEntryRepository.save(diaryEntry);

        return "redirect:/diary-entries";
    }

    @GetMapping("/diary-entries")
    public String diaryEntries(Model model, Principal principal) {
        User currentUser = userService.findByUsername(principal.getName());
        List<DiaryEntry> diaryEntries = diaryEntryRepository.findByUser(currentUser);
        model.addAttribute("diaryEntries", diaryEntries);
        return "diary-entries";
    }
}
