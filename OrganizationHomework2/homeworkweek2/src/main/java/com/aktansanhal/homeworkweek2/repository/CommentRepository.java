package com.aktansanhal.homeworkweek2.repository;


import com.aktansanhal.homeworkweek2.entity.Comment;
import com.aktansanhal.homeworkweek2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findAllByUserId(Long userId);

    List<Comment> findAllByProductId(Long productId);

    void deleteByUser(User user);
}
