package com.aktansanhal.homeworkweek2.dto.request;

import com.aktansanhal.homeworkweek2.dto.response.CommentResponseDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ProductRequestDTO(
        @NotBlank String productName,
        Integer price
) {


    /**
     *     private Long id;
     *
     *     private String productName;
     *
     *     private Integer price;
     *
     *     private List<Comment> comments;
     */
}
