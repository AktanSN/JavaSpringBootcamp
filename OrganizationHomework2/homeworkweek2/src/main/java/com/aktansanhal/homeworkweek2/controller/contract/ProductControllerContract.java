package com.aktansanhal.homeworkweek2.controller.contract;

import com.aktansanhal.homeworkweek2.dto.request.ProductRequestDTO;
import com.aktansanhal.homeworkweek2.dto.request.ProductUpdateDTO;
import com.aktansanhal.homeworkweek2.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductControllerContract {

    ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO);

    List<ProductResponseDTO> getProducts();

    void deleteProduct(Long id);

    ProductResponseDTO updateProduct(Long id, ProductUpdateDTO productUpdateDTO);

    ProductResponseDTO getProductById(Long id);
}
