package ua.com.training.model;

public enum Permission {

    SENIOR_READ("senior:read"),
    SENIOR_WRITE("senior:write"),
    CASHIER_READ("cashier:read"),
    CASHIER_WRITE("cashier:write"),
    PRODUCTS_READ("products:read"),
    PRODUCTS_WRITE("products:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
