package com.myproject.humbleproject.services.interfaces;

import com.myproject.humbleproject.pojo.UserDTO;
import com.myproject.humbleproject.entities.User;

import java.util.List;

public interface UserServiceMapper {
    UserDTO toDto(User user);
    User fromDto(UserDTO userDto);
    List<UserDTO> toDtoList(List<User> userList);
    List<User> fromDtoList(List<UserDTO> userDtoList);

    void updateEntityFromDto(UserDTO userDto, User user);

    User updateEntityFromDto(UserDTO userDto);

    UserDTO toPartialDto(User user);
}