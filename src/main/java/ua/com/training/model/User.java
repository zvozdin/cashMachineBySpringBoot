package ua.com.training.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;

    // todo make as FK
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "role_id", nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles role;

    // todo make as FK
    @Column(nullable = false, columnDefinition = "ACTIVE")
    @Enumerated(EnumType.STRING)
    private Status status;


    @Setter(value = AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Check> checks = new ArrayList<>();

    public void addCheck(Check check) {
        checks.add(check);
        check.setUser(this);
    }

    public void removeCheck(Check check) {
        checks.remove(check);
        check.setUser(null);
    }
}
