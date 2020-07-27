package com.orazgaliyev.astana.service;

import com.orazgaliyev.astana.model.user.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAll();

    UserDTO getUserByLogin(String login);

    void createUser(UserDTO userDTO);

    void deleteUser(String login);

}
