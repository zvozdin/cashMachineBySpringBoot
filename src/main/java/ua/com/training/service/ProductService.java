package ua.com.training.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.training.dao.ProductRepository;
import ua.com.training.model.Product;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public void updateQuantity(String code, Integer quantity) {
        productRepository.updateQuantityProductByCode(code, quantity);
    }
}
