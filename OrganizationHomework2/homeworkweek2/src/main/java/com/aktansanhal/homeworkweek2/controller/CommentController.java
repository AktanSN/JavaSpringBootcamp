package com.aktansanhal.homeworkweek2.controller;


import com.aktansanhal.homeworkweek2.controller.contract.CommentControllerContract;
import com.aktansanhal.homeworkweek2.dto.request.CommentRequestDTO;
import com.aktansanhal.homeworkweek2.dto.response.CommentResponseDTO;
import com.aktansanhal.homeworkweek2.error.DataResult;
import com.aktansanhal.homeworkweek2.error.Result;
import com.aktansanhal.homeworkweek2.error.SuccessDataResult;
import com.aktansanhal.homeworkweek2.error.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentControllerContract commentControllerContract;


    @PostMapping
    public ResponseEntity<DataResult<CommentResponseDTO>> saveComment(@RequestBody CommentRequestDTO comment){
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessDataResult<>("Listelendi",commentControllerContract.saveComment(comment)));
    }

    @GetMapping
    public ResponseEntity<DataResult<List<CommentResponseDTO>>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi",commentControllerContract.getComments()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteComment(@PathVariable Long id){
        commentControllerContract.deleteComment(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResult("Silme Başarılı"));
    }

    @GetMapping("/byProduct/{productId}")
    public ResponseEntity<DataResult<List<CommentResponseDTO>>> getCommentsByProductId(@PathVariable Long productId){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi",commentControllerContract.getCommentsByProductId(productId)));
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<DataResult<List<CommentResponseDTO>>> getCommentsByUserId(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi",commentControllerContract.getCommentsByUserId(userId)));
    }



}
