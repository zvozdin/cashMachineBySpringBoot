package ua.com.training.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.com.training.model.Product;
import ua.com.training.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('products:read')")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PatchMapping("/{code}")
    @PreAuthorize("hasAuthority('products:write')")
    public String updateQuantity(@PathVariable String code, @RequestParam Integer quantity) {
        productService.updateQuantity(code, quantity);
        return "ok";
    }
}