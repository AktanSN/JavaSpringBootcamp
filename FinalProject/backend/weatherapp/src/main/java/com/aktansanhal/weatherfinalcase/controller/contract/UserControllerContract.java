package com.aktansanhal.weatherfinalcase.controller.contract;

import com.aktansanhal.weatherfinalcase.dto.requests.UserRequestDTO;
import com.aktansanhal.weatherfinalcase.dto.responses.UserResponseDTO;

import java.util.List;

public interface UserControllerContract {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> getUsers();

    UserResponseDTO getUserById(Long id);

    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);

    void deleteUser(Long id);

    List<UserResponseDTO> getUsersPage(int pageNumber, int pageSize);

    List<UserResponseDTO> getByUsernameStartsWith(String username);

    List<UserResponseDTO> getByUsernameContaining(String username);

    List<UserResponseDTO> getAllByOrderByUsernameAsc();
}
