package ua.com.training.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = {"checkId", "productId"})
@Embeddable
public class ProductInCheckKey implements Serializable {

    @Column(name = "check_id")
    private Long checkId;

    @Column(name = "product_id")
    private Long productId;

    public ProductInCheckKey() {
    }

    public ProductInCheckKey(Long checkId, Long productId) {
        this.checkId = checkId;
        this.productId = productId;
    }
}
