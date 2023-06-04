package com.aktansanhal.homeworkweek2.controller;


import com.aktansanhal.homeworkweek2.controller.contract.UserControllerContract;
import com.aktansanhal.homeworkweek2.dto.request.UserRequestDTO;
import com.aktansanhal.homeworkweek2.dto.response.UserResponseDTO;
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
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerContract userControllerContract;


    @PostMapping
    public ResponseEntity<DataResult<UserResponseDTO>> saveUser(@RequestBody UserRequestDTO user){
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessDataResult<>("Kayıt Başarılı", userControllerContract.saveUser(user)));
    }

    @GetMapping
    public ResponseEntity<DataResult<List<UserResponseDTO>>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi", userControllerContract.getUsers()));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteUser(@PathVariable Long id, @RequestParam String username, @RequestParam String phoneNumber){
        userControllerContract.deleteUser(id, username, phoneNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResult("Silindi"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<UserResponseDTO>> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Güncellendi", userControllerContract.updateUser(id, userRequestDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<UserResponseDTO>> getUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi", userControllerContract.getUserById(id)));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<DataResult<UserResponseDTO>> getUserByUsername(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi", userControllerContract.getUserByUsername(username)));
    }


}
