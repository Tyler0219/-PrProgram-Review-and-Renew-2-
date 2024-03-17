package com.unitseven.springboot;


import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.unitseven.springboot.UserService;
import com.unitseven.springboot.entity.User;
import com.unitseven.springboot.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
public void whenSaveUser_thenReturnsUser() {
    User user = new User();
    user.setId(1);
    user.setName("Test User");
    
    when(userRepository.save(any(User.class))).thenReturn(user);
    
    User savedUser = userService.saveUser(user);
    
    assertEquals(user.getName(), savedUser.getName());
    verify(userRepository).save(user);
}
    @Test
public void whenValidUserId_thenUserShouldBeFound() {
    Integer userId = 1;
    Optional<User> expectedUser = Optional.of(new User());
    
    
    when(userRepository.findById(userId)).thenReturn(expectedUser);
    
    Optional<User> foundUser = userService.getUserById(userId);
    
    assertTrue(foundUser.isPresent());
    assertEquals(expectedUser, foundUser);
}
    @Test
public void whenGetAllUsers_thenReturnsListOfUsers() {
    List<User> userList = Arrays.asList(new User(), new User());
    
    
    when(userRepository.findAll()).thenReturn(userList);
    
    List<User> retrievedUsers = userService.getAllUsers();
    
    assertEquals(2, retrievedUsers.size());
}
    @Test
public void whenDeleteUser_thenVerifyMethodCalled() {
    Integer userId = 1;
    
    userService.deleteUser(userId);
    
    verify(userRepository).deleteById(userId);
}
    @Test
public void whenSaveUserWithNullUser_thenThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> userService.saveUser(null));
}
    @Test
public void whenSaveUserWithNullUser_thenReturnsNull() {
    User result = userService.saveUser(null);
    assertNull(result);
}
    @Test
public void whenGetUserByNonExistentId_thenEmptyResult() {
    Integer userId = Integer.MAX_VALUE; 
    when(userRepository.findById(userId)).thenReturn(Optional.empty());
    
    Optional<User> result = userService.getUserById(userId);
    
    assertFalse(result.isPresent());
}
    @Test
public void whenGetUserByExtremeId_thenEmptyResult() {
    Integer userId = -1; 
    when(userRepository.findById(userId)).thenReturn(Optional.empty());
    
    Optional<User> result = userService.getUserById(userId);
    
    assertFalse(result.isPresent());
}


}
