package ua.com.training.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.training.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {

    @Modifying
    @Query("UPDATE Product p SET p.quantity = :quantity WHERE p.code = :code")
    int updateQuantityProductByCode(@Param(value = "code") String code,
                                        @Param(value = "quantity") int quantity);
}
