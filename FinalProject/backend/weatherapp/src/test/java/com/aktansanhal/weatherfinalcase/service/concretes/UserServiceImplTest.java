package com.aktansanhal.weatherfinalcase.service.concretes;

import com.aktansanhal.weatherfinalcase.entity.User;
import com.aktansanhal.weatherfinalcase.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        // Test verileri
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpassword");

        // Beklenen sonuç
        User expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setUsername("testuser");
        expectedUser.setPassword("encodedpassword");

        // Mock PasswordEncoder'nin davranışını ayarla
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedpassword");

        // Mock UserRepository'nin davranışını ayarla
        when(userRepository.save(user)).thenReturn(expectedUser);

        // Metodu çağır ve sonucu kontrol et
        User savedUser = userService.save(user);
        assertNotNull(savedUser);
        assertEquals(expectedUser.getUsername(), savedUser.getUsername());
        assertEquals(expectedUser.getPassword(), savedUser.getPassword());

        // UserRepository.save() metodu çağrıldı mı?
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testGetUsersPage() {
        // Test verileri
        int pageNumber = 0;
        int pageSize = 10;
        List<User> expectedUsers = Arrays.asList(
                new User(1L, "user1", "password1",null),
                new User(2L, "user2", "password2",null),
                new User(3L, "user3", "password3",null)
        );
        Page<User> page = new PageImpl<>(expectedUsers);

        // Mock UserRepository'nin davranışını ayarla
        when(userRepository.findAll(any(Pageable.class))).thenReturn(page);

        // Metodu çağır ve sonucu kontrol et
        List<User> users = userService.getUsersPage(pageNumber, pageSize);
        assertNotNull(users);
        assertEquals(expectedUsers.size(), users.size());

        // UserRepository.findAll() metodu çağrıldı mı?
        verify(userRepository, times(1)).findAll(any(Pageable.class));
    }

    @Test
    public void testGetByUsernameStartsWith() {
        // Test verileri
        String username = "user";
        List<User> expectedUsers = Arrays.asList(
                new User(1L, "user1", "password1" ,null),
                new User(2L, "user2", "password2" ,null),
                new User(3L, "user3", "password3" ,null)
        );

        // Mock UserRepository'nin davranışını ayarla
        when(userRepository.getByUsernameStartsWith(username)).thenReturn(expectedUsers);

        // Metodu çağır ve sonucu kontrol et
        List<User> users = userService.getByUsernameStartsWith(username);
        assertNotNull(users);
        assertEquals(expectedUsers.size(), users.size());

        // UserRepository.getByUsernameStartsWith() metodu çağrıldı mı?
        verify(userRepository, times(1)).getByUsernameStartsWith(username);
    }

    @Test
    public void testGetByUsernameContaining() {
        // Test verileri
        String username = "user";
        List<User> expectedUsers = Arrays.asList(
                new User(1L, "user1", "password1" ,null),
                new User(2L, "user2", "password2" ,null),
                new User(3L, "user3", "password3" ,null)
        );

        // Mock UserRepository'nin davranışını ayarla
        when(userRepository.getByUsernameContaining(username)).thenReturn(expectedUsers);

        // Metodu çağır ve sonucu kontrol et
        List<User> users = userService.getByUsernameContaining(username);
        assertNotNull(users);
        assertEquals(expectedUsers.size(), users.size());

        // UserRepository.getByUsernameContaining() metodu çağrıldı mı?
        verify(userRepository, times(1)).getByUsernameContaining(username);
    }

    @Test
    public void testGetAllByOrderByUsernameAsc() {
        // Test verileri
        List<User> expectedUsers = Arrays.asList(
                new User(1L, "user1", "password1" ,null),
                new User(2L, "user2", "password2" ,null),
                new User(3L, "user3", "password3" ,null)
        );

        // Mock UserRepository'nin davranışını ayarla
        when(userRepository.getAllByOrderByUsernameAsc()).thenReturn(expectedUsers);

        // Metodu çağır ve sonucu kontrol et
        List<User> users = userService.getAllByOrderByUsernameAsc();
        assertNotNull(users);
        assertEquals(expectedUsers.size(), users.size());

        // UserRepository.getAllByOrderByUsernameAsc() metodu çağrıldı mı?
        verify(userRepository, times(1)).getAllByOrderByUsernameAsc();
    }
}