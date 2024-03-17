package com.unitseven.springboot.controller;
import com.unitseven.springboot.Entity.user;
import com.unitseven.springboot.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class usersController {
    @Autowired
    private UsersService userService;

    @PostMapping("/create")
    public user createUser(@RequestBody user User) {
        return userService.saveUser(User);
    }

    @GetMapping("/{userId}")
    public Optional<user> getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/all")
    public List<user> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}