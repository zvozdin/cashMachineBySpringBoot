package ua.com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.training.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();

    @Override
    Product save(Product entity);

    @Modifying
    @Query("UPDATE Product p SET p.quantity = :quantity WHERE p.code = :code")
    int updateQuantityProductByCode(@Param(value = "code") String code,
                                        @Param(value = "quantity") int quantity);
}
