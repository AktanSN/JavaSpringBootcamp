package com.aktansanhal.weatherfinalcase.mapper;


import com.aktansanhal.weatherfinalcase.dto.requests.UserRequestDTO;
import com.aktansanhal.weatherfinalcase.dto.responses.UserResponseDTO;
import com.aktansanhal.weatherfinalcase.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserRequestDTO userRequestDTO);
    UserRequestDTO toUserRequestDTO(User user);

    User toUser(UserResponseDTO userResponseDTO);
    UserResponseDTO toUserResponseDTO(User user);
}
