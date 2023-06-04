package com.aktansanhal.homeworkweek2.dto.response;

import com.aktansanhal.homeworkweek2.entity.Product;
import com.aktansanhal.homeworkweek2.entity.User;

public record CommentResponseDTO(
        Long id,
        String commentText,
        Product product,
        User user
) {
}
