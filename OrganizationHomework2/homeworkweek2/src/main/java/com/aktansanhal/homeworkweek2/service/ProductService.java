package com.aktansanhal.homeworkweek2.service;


import com.aktansanhal.homeworkweek2.entity.Comment;
import com.aktansanhal.homeworkweek2.entity.Product;
import com.aktansanhal.homeworkweek2.general.BaseEntityService;
import com.aktansanhal.homeworkweek2.repository.CommentRepository;
import com.aktansanhal.homeworkweek2.repository.ProductRepository;
import com.aktansanhal.homeworkweek2.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseEntityService<Product, ProductRepository> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    public ProductService(ProductRepository repository) {
        super(repository);
    }

    public Product updateProduct(Integer price, Long id) {
        Product product1 = productRepository.findById(id).orElseThrow(); //hata
        product1.setPrice(price);
        return save(product1);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        List<Comment> comments = commentRepository.findAllByProductId(productId);
        for (Comment comment : comments) {
            comment.setProduct(null);
            commentRepository.save(comment);
            commentRepository.deleteById(comment.getId());
        }

        productRepository.deleteById(productId);
    }


}
