package com.aktansanhal.homeworkweek2.mapper;


import com.aktansanhal.homeworkweek2.dto.request.UserRequestDTO;
import com.aktansanhal.homeworkweek2.dto.response.UserResponseDTO;
import com.aktansanhal.homeworkweek2.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserRequestDTO userRequestDTO);
    UserRequestDTO toRequestDTO(User user);

    User toUser(UserResponseDTO userResponseDTO);
    UserResponseDTO toResponseDTO(User user);


}
