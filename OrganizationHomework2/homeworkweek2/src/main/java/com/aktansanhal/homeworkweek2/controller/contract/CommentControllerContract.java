package com.aktansanhal.homeworkweek2.controller.contract;

import com.aktansanhal.homeworkweek2.dto.request.CommentRequestDTO;
import com.aktansanhal.homeworkweek2.dto.response.CommentResponseDTO;
import com.aktansanhal.homeworkweek2.dto.response.ProductResponseDTO;

import java.util.List;

public interface CommentControllerContract {

    CommentResponseDTO saveComment(CommentRequestDTO commentRequestDTO);
    List<CommentResponseDTO> getComments();

    void deleteComment(Long id);

    List<CommentResponseDTO> getCommentsByProductId(Long id);

    List<CommentResponseDTO> getCommentsByUserId(Long id);
}
