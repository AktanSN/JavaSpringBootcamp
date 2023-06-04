package com.aktansanhal.homeworkweek2.mapper;


import com.aktansanhal.homeworkweek2.dto.request.CommentRequestDTO;
import com.aktansanhal.homeworkweek2.dto.response.CommentResponseDTO;
import com.aktansanhal.homeworkweek2.entity.Comment;
import com.aktansanhal.homeworkweek2.entity.Product;
import com.aktansanhal.homeworkweek2.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment toComment(CommentResponseDTO commentResponseDTO);



    CommentResponseDTO toResponseDTO(Comment comment);

    Comment toComment(CommentRequestDTO commentRequestDTO);
    CommentRequestDTO toRequestDTO(Comment comment);


}
