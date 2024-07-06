package com.example.jooq.api;

import com.example.jooq.response.FriendResponse;
import com.example.jooq.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/friend")
public class FriendApi {
    private final FriendService friendService;

    @GetMapping("find/all")
    public List<FriendResponse> findAll() {
        return friendService.findAll();
    }

    @PostMapping("created")
    public FriendResponse createFriendShip(@RequestParam Long idOne,
                                           @RequestParam Long idTwo) {
        return friendService.createFriend(idOne,
                idTwo);
    }

    @GetMapping("find/by/ids/{one}/{two}")
    public FriendResponse findByIds(@PathVariable Long one,
                                    @PathVariable Long two) {
        return friendService.findByIds(one, two);
    }
}