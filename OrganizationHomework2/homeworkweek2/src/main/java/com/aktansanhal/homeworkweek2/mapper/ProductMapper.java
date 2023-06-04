package com.aktansanhal.homeworkweek2.mapper;


import com.aktansanhal.homeworkweek2.dto.request.ProductRequestDTO;
import com.aktansanhal.homeworkweek2.dto.request.ProductUpdateDTO;
import com.aktansanhal.homeworkweek2.dto.response.ProductResponseDTO;
import com.aktansanhal.homeworkweek2.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductRequestDTO productRequestDTO);
    ProductRequestDTO toRequestDTO(Product product);

    Product toProduct(ProductResponseDTO productResponseDTO);
    ProductResponseDTO toResponseDTO(Product product);

    Product toProduct(ProductUpdateDTO productUpdateDTO);
    ProductUpdateDTO toUpdateDTO(Product product);
}
