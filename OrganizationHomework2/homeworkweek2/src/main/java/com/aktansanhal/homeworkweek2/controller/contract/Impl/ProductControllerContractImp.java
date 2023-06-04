package com.aktansanhal.homeworkweek2.controller.contract.Impl;


import com.aktansanhal.homeworkweek2.controller.contract.ProductControllerContract;
import com.aktansanhal.homeworkweek2.dto.request.ProductRequestDTO;
import com.aktansanhal.homeworkweek2.dto.request.ProductUpdateDTO;
import com.aktansanhal.homeworkweek2.dto.response.ProductResponseDTO;
import com.aktansanhal.homeworkweek2.entity.Product;
import com.aktansanhal.homeworkweek2.exception.exceptions.MyException;
import com.aktansanhal.homeworkweek2.mapper.ProductMapper;
import com.aktansanhal.homeworkweek2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductControllerContractImp implements ProductControllerContract {

    private final ProductService productService;
    private final ProductMapper productMapper;



    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) {
        Product product = productService.save(productMapper.toProduct(productRequestDTO));


        ProductResponseDTO productResponseDTO = productMapper.toResponseDTO(product);


        return productResponseDTO;
    }

    @Override
    public List<ProductResponseDTO> getProducts() {
        List<ProductResponseDTO> productResponseDTOS = productService.findAll().stream().map(productMapper::toResponseDTO).collect(java.util.stream.Collectors.toList());
        return productResponseDTOS;
    }

    @Override
    public void deleteProduct(Long id) {
         productService.deleteProduct(id);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductUpdateDTO productUpdateDTO) {
        Product product = productService.updateProduct(productUpdateDTO.price(), id);
        ProductResponseDTO productResponseDTO = productMapper.toResponseDTO(product);
        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new MyException("Bulunamadı")); //hata
        ProductResponseDTO productResponseDTO = productMapper.toResponseDTO(product);
        return productResponseDTO;
    }
}
