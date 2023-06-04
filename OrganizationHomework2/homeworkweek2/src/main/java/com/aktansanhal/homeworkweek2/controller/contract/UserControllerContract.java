package com.aktansanhal.homeworkweek2.controller.contract;

import com.aktansanhal.homeworkweek2.dto.request.UserRequestDTO;
import com.aktansanhal.homeworkweek2.dto.response.UserResponseDTO;

import java.util.List;

public interface UserControllerContract {

    UserResponseDTO saveUser(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> getUsers();

    void deleteUser(Long id, String username, String phoneNumber);

    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO); //özelleştir

    UserResponseDTO getUserById(Long id);

    UserResponseDTO getUserByUsername(String username);
}
