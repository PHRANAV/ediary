@Controller
public class DiaryController {

    @Autowired
    private DiaryEntryRepository diaryEntryRepository;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/diary-entries")
    public String diaryEntries(Model model) {
        List<DiaryEntry> entries = diaryEntryRepository.findAll();
        model.addAttribute("entries", entries);
        return "diary-entries";
    }

    @GetMapping("/diary-entry")
    public String diaryEntryForm(Model model) {
        model.addAttribute("diaryEntry", new DiaryEntry());
        return "diary-entry";
    }

    @GetMapping("/diary-entry/{id}")
    public String editDiaryEntryForm(@PathVariable Long id, Model model) {
        DiaryEntry entry = diaryEntryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid entry id: " + id));
        model.addAttribute("diaryEntry", entry);
        return "diary-entry";
    }

    @PostMapping("/diary-entry")
    public String saveDiaryEntry(@ModelAttribute("diaryEntry") DiaryEntry entry) {
        diaryEntryRepository.save(entry);
        return "redirect:/diary-entries";
    }

    @GetMapping("/delete-diary-entry/{id}")
    public String deleteDiaryEntry(@PathVariable Long id) {
        DiaryEntry entry = diaryEntryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid entry id: " + id));
        diaryEntryRepository.delete(entry);
        return "redirect:/diary-entries";
    }
}
