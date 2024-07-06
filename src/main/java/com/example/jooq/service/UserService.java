package com.example.jooq.service;

import com.example.jooq.expetion.AlreadyName;
import com.example.jooq.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.jooq.table.Users.USERS;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final DSLContext dslContext;

    @Transactional(readOnly = true)
    public List<UserResponse> getAllUsers() {
        return dslContext.selectFrom(USERS)
                .fetchInto(UserResponse.class);
    }

    public UserResponse createUser(String username, String email, Short age) {
        if (findByUsername(username) != null)
            throw new AlreadyName("Username found. The email address must be unique!");
        if (findByEmail(email) != null)
            throw new AlreadyName("Email found. The email address must be unique!");
        dslContext.insertInto(USERS, USERS.USERNAME, USERS.EMAIL, USERS.AGE)
                .values(username, email, age)
                .execute();
        return findByUsername(username);
    }

    public UserResponse updateUserEmail(Long userId, String newEmail, Short age) {
        if (findByEmail(newEmail) != null)
            throw new AlreadyName("Email found. The email address must be unique!");
        dslContext.update(USERS)
                .set(USERS.EMAIL, newEmail)
                .set(USERS.AGE, age)
                .where(USERS.ID.eq(userId))
                .execute();
        return findById(userId);
    }

    public UserResponse deleteUser(Long userId) {
        UserResponse user = findById(userId);
        dslContext.deleteFrom(USERS)
                .where(USERS.ID.eq(userId))
                .execute();
        return user;
    }

    public UserResponse findById(Long id) {
        return dslContext.selectFrom(USERS)
                .where(USERS.ID.eq(id))
                .fetchOneInto(UserResponse.class);
    }

    public UserResponse findByUsername(String username) {
        return dslContext.selectFrom(USERS)
                .where(USERS.USERNAME.eq(username))
                .fetchOneInto(UserResponse.class);
    }

    private UserResponse findByEmail(String email) {
        return dslContext.selectFrom(USERS)
                .where(USERS.EMAIL.eq(email))
                .fetchOneInto(UserResponse.class);
    }
}