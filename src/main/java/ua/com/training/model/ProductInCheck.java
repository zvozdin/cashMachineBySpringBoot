package ua.com.training.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode(of = {"check", "product"})
@Getter
@Setter
@Entity
@Table(name = "orders")
public class ProductInCheck {

    @EmbeddedId
    private ProductInCheckKey id;

    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Double bill;

    @ManyToOne
    @MapsId("checkId")
    @JoinColumn(name = "check_id")
    private Check check;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductInCheck() {
    }

    public ProductInCheck(Check check, Product product) {
        this.check = check;
        this.product = product;
        this.id = new ProductInCheckKey(check.getId(), product.getId());
    }
}
