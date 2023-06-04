package com.aktansanhal.homeworkweek2.service;


import com.aktansanhal.homeworkweek2.entity.Comment;
import com.aktansanhal.homeworkweek2.entity.User;
import com.aktansanhal.homeworkweek2.general.BaseEntityService;
import com.aktansanhal.homeworkweek2.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CommentService extends BaseEntityService<Comment, CommentRepository> {

    @Autowired
    private CommentRepository commentRepository;


    public CommentService(CommentRepository repository) {
        super(repository);
    }

    public List<Comment> findAllByUserId(Long userId) {

        return commentRepository.findAllByUserId(userId);
    }

    public List<Comment> findAllByProductId(Long productId) {
        return commentRepository.findAllByProductId(productId);
    }

    public void deleteCommentsByUser(User user) {
        commentRepository.deleteByUser(user);
    }
}
