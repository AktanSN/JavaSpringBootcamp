package com.aktansanhal.homeworkweek2.controller.contract.Impl;


import com.aktansanhal.homeworkweek2.controller.contract.CommentControllerContract;
import com.aktansanhal.homeworkweek2.dto.request.CommentRequestDTO;
import com.aktansanhal.homeworkweek2.dto.response.CommentResponseDTO;
import com.aktansanhal.homeworkweek2.entity.Comment;
import com.aktansanhal.homeworkweek2.entity.Product;
import com.aktansanhal.homeworkweek2.entity.User;
import com.aktansanhal.homeworkweek2.exception.exceptions.MyException;
import com.aktansanhal.homeworkweek2.mapper.CommentMapper;
import com.aktansanhal.homeworkweek2.service.CommentService;
import com.aktansanhal.homeworkweek2.service.ProductService;
import com.aktansanhal.homeworkweek2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentControllerContract {

    private final CommentService commentService;
    private final CommentMapper commentMapper;
    private final UserService userService;

    private final ProductService productService;

    @Override
    public CommentResponseDTO saveComment(CommentRequestDTO commentRequestDTO) {
        Optional<Product> product = productService.findById(commentRequestDTO.productId());
        Optional<User> user = userService.findById(commentRequestDTO.userId());

        Comment savedComment = null;
        if (product.isPresent() && user.isPresent()) {
            Comment comment = commentMapper.toComment(commentRequestDTO);
            comment.setProduct(product.get());
            comment.setUser(user.get());
            savedComment = commentService.save(comment);
        }else {
            throw new MyException("Başarısız");
        }
        CommentResponseDTO commentResponseDTO = commentMapper.toResponseDTO(savedComment);
        return commentResponseDTO;
    }

    @Override
    public List<CommentResponseDTO> getComments() {
        List<CommentResponseDTO> commentResponseDTOS = commentService.findAll().stream().map(commentMapper::toResponseDTO).collect(java.util.stream.Collectors.toList());
        if(commentResponseDTOS.isEmpty()){
            throw new MyException("Henüz bir yorum yazılmamıştır");
        }
        return commentResponseDTOS;
    }

    @Override
    public void deleteComment(Long id) {
        Optional<Comment> comment = commentService.findById(id);

        if(comment.isPresent()){
            commentService.delete(comment.get());
        }else {
            throw new MyException("Bulunamadı");
        }
    }

    @Override
    public List<CommentResponseDTO> getCommentsByProductId(Long id) {

        List<Comment> product = commentService.findAllByProductId(id);
        List<CommentResponseDTO> commentResponseDTOS = product.stream().map(commentMapper::toResponseDTO).toList();

        if (commentResponseDTOS.isEmpty()){
            throw new MyException("Ürüne henüz bir yorum yazılmamıştır");
        }
        return commentResponseDTOS;
    }

    @Override
    public List<CommentResponseDTO> getCommentsByUserId(Long id) {
        List<Comment> user = commentService.findAllByUserId(id);
        List<CommentResponseDTO> commentResponseDTOS = user.stream().map(commentMapper::toResponseDTO).toList();
        if (commentResponseDTOS.isEmpty()){
            throw new MyException("Kullanıcı adına henüz bir yorum yazılmamıştır");
        }
        return commentResponseDTOS;
    }
}
