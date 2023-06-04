package com.aktansanhal.homeworkweek2.dto.request;

import com.aktansanhal.homeworkweek2.dto.response.CommentResponseDTO;
import com.aktansanhal.homeworkweek2.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UserRequestDTO(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank String phoneNumber,
        @Email String email,
        UserType userType
) {

    /**
     *
     *
     *
     *     private String username;
     *
     *     private String password;
     *
     *     private String phoneNumber;
     *
     *     private String email;
     *
     *     private UserType userType;
     *
     *     private List<Comment> comments;
     */
}
