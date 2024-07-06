package com.example.jooq.response;

public record UserResponse(Long id,
                           String username,
                           String email,
                           Short age) {
}