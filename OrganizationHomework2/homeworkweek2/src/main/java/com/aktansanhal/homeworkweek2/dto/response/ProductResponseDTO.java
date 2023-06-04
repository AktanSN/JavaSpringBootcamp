package com.aktansanhal.homeworkweek2.dto.response;

import java.util.List;

public record ProductResponseDTO(
        Long id,
        String productName,
        Integer price
) {
}
