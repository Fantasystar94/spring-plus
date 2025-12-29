package org.example.expert.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.annotation.Auth;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.user.dto.request.UserChangePasswordRequest;
<<<<<<< HEAD
import org.example.expert.domain.user.dto.request.UserNicknameUpdate;
=======
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PutMapping("/users")
    public void changePassword(@Auth AuthUser authUser, @RequestBody UserChangePasswordRequest userChangePasswordRequest) {
        userService.changePassword(authUser.getId(), userChangePasswordRequest);
    }
<<<<<<< HEAD

    @PutMapping("/users/nickname")
    public  void updateNickname(@Auth AuthUser authUser, @RequestBody UserNicknameUpdate userNicknameUpdate) {
        userService.updateNickname(authUser.getId(), userNicknameUpdate);
    }

    @GetMapping("/users/nickname/{nickname}")
    public ResponseEntity<UserResponse> getUserByNickname(@PathVariable String nickname) {
        return ResponseEntity.ok(userService.getUserByNickname(nickname));
    }
=======
>>>>>>> 8b7a4b7afb803fe3e3fc6c824d72746769f30079
}
