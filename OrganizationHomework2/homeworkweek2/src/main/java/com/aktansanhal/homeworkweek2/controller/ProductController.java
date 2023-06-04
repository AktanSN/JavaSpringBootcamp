package com.aktansanhal.homeworkweek2.controller;


import com.aktansanhal.homeworkweek2.controller.contract.ProductControllerContract;
import com.aktansanhal.homeworkweek2.dto.request.ProductRequestDTO;
import com.aktansanhal.homeworkweek2.dto.request.ProductUpdateDTO;
import com.aktansanhal.homeworkweek2.dto.response.ProductResponseDTO;
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
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductControllerContract productControllerContract;


    @PostMapping
    public ResponseEntity<DataResult<ProductResponseDTO>> saveProduct(@RequestBody ProductRequestDTO product){
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessDataResult<>("Kaydedildi", productControllerContract.saveProduct(product)));
    }

    @GetMapping
    public ResponseEntity<DataResult<List<ProductResponseDTO>>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi", productControllerContract.getProducts()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteProduct(@PathVariable Long id){
        productControllerContract.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResult("Silme Başarılı"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<ProductResponseDTO>> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDTO productUpdateDTO){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Güncelleme başarılı", productControllerContract.updateProduct(id, productUpdateDTO)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<ProductResponseDTO>> getProductById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("Listelendi", productControllerContract.getProductById(id)));
    }



}
