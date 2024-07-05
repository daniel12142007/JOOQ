package com.example.jooq.api;

import com.example.jooq.model.User;
import com.example.jooq.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("find/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("save")
    public void createUser(@RequestParam String username,
                           @RequestParam String email,
                           @RequestParam Integer age) {
        userService.createUser(username, email, age);
    }

    @PutMapping("/{userId}")
    public void updateUserEmail(@PathVariable int userId,
                                @RequestParam String email,
                                @RequestParam Integer age) {
        userService.updateUserEmail(userId, email, age);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}
