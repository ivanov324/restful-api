package com.orazgaliyev.astana.controller;

import com.orazgaliyev.astana.model.user.UserDTO;
import com.orazgaliyev.astana.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String allUsers() {
        userService.getAll();
        return "userList";
    }

    @GetMapping("/users/id")
    public String getUser(String username) {
        userService.getUserByLogin(username);
        return "user";
    }

    @PostMapping("/users/id")
    public String createUser(UserDTO newUserDTO) {
        userService.createUser(newUserDTO);
        return "userCreated";
    }

    @DeleteMapping("/users/id")
    public String deleteUser(String login) {
        userService.deleteUser(login);
        return "userDeleted";
    }
}
