package com.example.jooq.api;

import com.example.jooq.response.UserResponse;
import com.example.jooq.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserApi {

    private final UserService userService;

    @GetMapping("find/all")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("find/by/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("find/by/username/{username}")
    public UserResponse findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping("save")
    public UserResponse createUser(@RequestParam String username,
                                   @RequestParam String email,
                                   @RequestParam Short age) {
        return userService.createUser(username, email, age);
    }

    @PutMapping("/{userId}")
    public UserResponse updateUserEmail(@PathVariable Long userId,
                                        @RequestParam String email,
                                        @RequestParam Short age) {
        return userService.updateUserEmail(userId, email, age);
    }

    @DeleteMapping("/{userId}")
    public UserResponse deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}