package ua.com.training.model;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public enum Roles {

    SENIOR_CASHIER(Set.of(
            Permission.SENIOR_WRITE,
            Permission.SENIOR_READ,
            Permission.PRODUCTS_READ)),

    CASHIER(Set.of(
            Permission.SENIOR_READ,
            Permission.CASHIER_READ,
            Permission.CASHIER_WRITE)),

    COMMODITY_EXPERT(Set.of(
            Permission.PRODUCTS_WRITE,
            Permission.PRODUCTS_READ));

    private final Set<Permission> permissions;

    Roles(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(toSet());
    }
}