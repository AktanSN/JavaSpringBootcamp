package com.aktansanhal.homeworkweek2.dto.request;

import com.aktansanhal.homeworkweek2.entity.Product;
import com.aktansanhal.homeworkweek2.entity.User;

public record CommentRequestDTO(
        String commentText,
        Long productId,
        Long userId
) {


    /**
     *
     *     private Long id;
     *
     *     private String commentText;
     *
     *     private Product product;
     *
     *     private User user;
     */
}
