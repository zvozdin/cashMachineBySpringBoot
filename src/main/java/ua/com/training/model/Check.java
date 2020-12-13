package ua.com.training.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(of = "checkCode")
@Getter
@Setter
@Entity
@Table(name = "checks")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataTime", nullable = false)
    private Timestamp date;

    @Column(name = "check_code", unique = true)
    private int checkCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Setter(value = AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "check", orphanRemoval = true)
    private List<ProductInCheck> products = new ArrayList<>();

//    public void addProduct(Product product) {
//        ProductInCheck productInCheck = new ProductInCheck(this, product);
//
//        products.add(productInCheck);
//        product.getChecks().add(productInCheck);
//    }
//
//    public void removeProduct(Product product) {
//        Iterator<ProductInCheck> iterator = products.iterator();
//        while (iterator.hasNext()) {
//            ProductInCheck productInCheck = iterator.next();
//            if (productInCheck.getCheck().equals(this)
//                    && productInCheck.getProduct().equals(product)) {
//                iterator.remove();
//                productInCheck.getProduct().getChecks().remove(productInCheck);
//                productInCheck.setCheck(null);
//                productInCheck.setProduct(null);
//            }
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Objects.equals(id, check.id) &&
                Objects.equals(date, check.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }
}
