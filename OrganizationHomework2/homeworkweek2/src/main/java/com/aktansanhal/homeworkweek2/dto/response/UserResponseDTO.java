package com.aktansanhal.homeworkweek2.dto.response;

import com.aktansanhal.homeworkweek2.enums.UserType;

import java.util.List;

public record UserResponseDTO(
        Long id,
        String username,
        String phoneNumber,
        String email,
        UserType userType
) {
}
