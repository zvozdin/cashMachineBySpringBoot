package ua.com.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "stock")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String name_UA;
    @Enumerated(EnumType.STRING)
    private Size size;
    private Double price;
    private Integer quantity;
//    private Double bill;
}
