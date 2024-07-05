package com.example.jooq.service;

import com.example.jooq.model.User;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static com.example.jooq.generated.Users.USERS;

@Service
public class UserService {

    @Autowired
    private DSLContext dslContext;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return dslContext.selectFrom(USERS)
                .fetchInto(User.class);
    }

    @Transactional
    public void createUser(String username, String email, Integer age) {
        dslContext.insertInto(USERS, USERS.USERNAME, USERS.EMAIL, USERS.AGE)
                .values(username, email, age)
                .execute();
    }

    @Transactional
    public void updateUserEmail(int userId, String newEmail, Integer age) {
        dslContext.update(USERS)
                .set(USERS.EMAIL, newEmail)
                .set(USERS.AGE, age)
                .where(USERS.ID.eq(userId))
                .execute();
    }

    @Transactional
    public void deleteUser(int userId) {
        dslContext.deleteFrom(USERS)
                .where(USERS.ID.eq(userId))
                .execute();
    }
}