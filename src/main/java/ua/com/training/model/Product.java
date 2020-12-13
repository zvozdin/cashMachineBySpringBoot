package ua.com.training.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@EqualsAndHashCode(of = "code")
@Getter
@Setter
@Entity
@Table(name = "stock")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String name_UA;
    @Enumerated(EnumType.STRING)
    private Size size;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Integer quantity;

//    @Setter(value = AccessLevel.PRIVATE)
//    @OneToMany(mappedBy = "product")
//    private List<ProductInCheck> checks= new ArrayList<>();
}
