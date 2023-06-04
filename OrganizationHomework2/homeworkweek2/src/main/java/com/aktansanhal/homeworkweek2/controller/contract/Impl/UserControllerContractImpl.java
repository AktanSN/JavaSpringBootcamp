package com.aktansanhal.homeworkweek2.controller.contract.Impl;

import com.aktansanhal.homeworkweek2.controller.contract.UserControllerContract;
import com.aktansanhal.homeworkweek2.dto.request.UserRequestDTO;
import com.aktansanhal.homeworkweek2.dto.response.UserResponseDTO;
import com.aktansanhal.homeworkweek2.entity.User;
import com.aktansanhal.homeworkweek2.exception.exceptions.MyException;
import com.aktansanhal.homeworkweek2.mapper.UserMapper;
import com.aktansanhal.homeworkweek2.service.CommentService;
import com.aktansanhal.homeworkweek2.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final UserMapper userMapper;
    private final UserService userService;

    private final CommentService commentService;

    @Override
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        User user = userService.save(userMapper.toUser(userRequestDTO));
        UserResponseDTO userResponseDTO = userMapper.toResponseDTO(user);
        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> getUsers() {
        List<UserResponseDTO> userResponseDTOS = userService.findAll().stream().map(userMapper::toResponseDTO).collect(java.util.stream.Collectors.toList());
        return userResponseDTOS;
    }

    @Transactional
    @Override
    public void deleteUser(Long id, String username, String phoneNumber) {
        User user = userService.findById(id).orElseThrow(() -> new MyException("Silme Yapılamadı"));

        if (!user.getUsername().equals(username) || !user.getPhoneNumber().equals(phoneNumber)) {
            throw new MyException("Kullanıcı adı ile Telefon bilgileri uyuşmamaktadır");
        }


        deleteCommentsByUser(user);


        userService.delete(user);
    }

    private void deleteCommentsByUser(User user) {

        commentService.deleteCommentsByUser(user);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userService.findById(id).orElseThrow(() -> new MyException("Güncelleme Yapılamadı"));
        user.setUsername(userRequestDTO.username());
        user.setPhoneNumber(userRequestDTO.phoneNumber());
        user.setEmail(userRequestDTO.email());
        user.setUserType(userRequestDTO.userType());
        user.setPassword(userRequestDTO.password());
        UserResponseDTO userResponseDTO = userMapper.toResponseDTO(userService.save(user));

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userService.findById(id).orElseThrow(() -> new MyException("Bulunamadı"));
        UserResponseDTO userResponseDTO = userMapper.toResponseDTO(user);

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO getUserByUsername(String username) {
        User user = userService.findByUsername(username);
        UserResponseDTO userResponseDTO = userMapper.toResponseDTO(user);

        return userResponseDTO;
    }
}
