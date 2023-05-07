@RunWith(MockitoJUnitRunner.class)
public class DiaryEntryServiceTests {

    @Mock
    private DiaryEntryRepository diaryEntryRepository;

    @InjectMocks
    private DiaryEntryService diaryEntryService;

    @Test
    public void testGetAllDiaryEntries() {
        List<DiaryEntry> entries = new ArrayList<>();
        entries.add(new DiaryEntry("Entry 1", "This is entry 1"));
        entries.add(new DiaryEntry("Entry 2", "This is entry 2"));

        when(diaryEntryRepository.findAll()).thenReturn(entries);

        List<DiaryEntry> result = diaryEntryService.getAllDiaryEntries();

        assertEquals(2, result.size());
    }

    @Test
    public void testSaveDiaryEntry() {
        DiaryEntry entry = new DiaryEntry("New Entry", "This is a new entry");

        when(diaryEntryRepository.save(entry)).thenReturn(entry);

        DiaryEntry result = diaryEntryService.saveDiaryEntry(entry);

        assertNotNull(result);
        assertEquals("New Entry", result.getTitle());
    }

    // more tests...
}
