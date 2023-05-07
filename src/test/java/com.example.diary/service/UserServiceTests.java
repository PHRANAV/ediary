@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserByUsername() {
        User user = new User("testuser", "password", "Test User");
        when(userRepository.findByUsername("testuser")).thenReturn(user);

        User result = userService.getUserByUsername("testuser");

        assertNotNull(result);
        assertEquals("Test User", result.getFullName());
    }

    @Test
    public void testCreateUser() {
        User user = new User("newuser", "password", "New User");
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.createUser(user);

        assertNotNull(result);
        assertEquals("newuser", result.getUsername());
    }

    // more tests...
}
