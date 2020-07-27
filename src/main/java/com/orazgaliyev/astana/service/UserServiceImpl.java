package com.orazgaliyev.astana.service;

import com.orazgaliyev.astana.entity.user.UserEntity;
import com.orazgaliyev.astana.model.user.Role;
import com.orazgaliyev.astana.model.user.UserDTO;
import com.orazgaliyev.astana.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByLogin(String login) {
        return userRepository.findByLogin(login)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userRepository.save(mapToEntity(userDTO));
    }

    @Override
    public void deleteUser(String login) {
        userRepository.deleteByLogin(login)
                .map(this::mapToDTO);
    }

    private UserEntity mapToEntity(UserDTO userDTO) {
        String login = userDTO.getLogin();
        UserEntity userEntity =
                userRepository.findByLogin(login)
                        .orElseGet(()->{
                            UserEntity entity = new UserEntity();
                            entity.setLogin(login);
                            return entity;
                        });
        userEntity.setRole(Role.byRole(userDTO.getRole()));
        userEntity.setName(userDTO.getName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setLogin(login);
        userEntity.setCreateDate(userDTO.getCreateDate());
        userEntity.setUpdateDate(userDTO.getUpdateDate());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
        userEntity.setPhoto(userDTO.getPhoto());
        return userEntity;
    }

    private UserDTO mapToDTO(UserEntity entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setRole(Role.byId(entity.getRole()));
        userDTO.setName(entity.getName());
        userDTO.setLastName(entity.getLastName());
        userDTO.setLogin(entity.getLogin());
        userDTO.setCreateDate(entity.getCreateDate());
        userDTO.setUpdateDate(entity.getUpdateDate());
        userDTO.setEmail(entity.getEmail());
        userDTO.setPhoneNumber(entity.getPhoneNumber());
        userDTO.setPhoto(entity.getPhoto());
        return userDTO;
    }
}
