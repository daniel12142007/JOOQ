package com.example.jooq.service;

import com.example.jooq.response.FriendResponse;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.jooq.table.Friends.FRIENDS;

@Service
@RequiredArgsConstructor
@Transactional
public class FriendService {
    private final DSLContext dslContext;

    public List<FriendResponse> findAll() {
        return dslContext.selectFrom(FRIENDS)
                .fetchInto(FriendResponse.class);
    }

    public FriendResponse createFriend(Long userOne,
                                       Long userTwo) {
        dslContext.insertInto(FRIENDS)
                .values(userOne, userTwo)
                .execute();
        return findByIds(userOne, userTwo);
    }

    public FriendResponse findByIds(Long userOne,
                                    Long userTwo) {
        return dslContext.selectFrom(FRIENDS)
                .where(FRIENDS.USER_ONE.eq(userOne))
                .and(FRIENDS.USER_TWO.eq(userTwo))
                .fetchOneInto(FriendResponse.class);
    }
}