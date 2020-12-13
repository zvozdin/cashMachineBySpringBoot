package ua.com.training.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ua.com.training.model.Developer;
import ua.com.training.service.ProductService;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/experts")
public class ExpertRestController {

    private final ProductService productService;

    public ExpertRestController(ProductService productService) {
        this.productService = productService;
    }

    private final List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "Ivan", "EXPERT"),
            new Developer(2L, "Sergey", "EXPERT"),
            new Developer(3L, "Petr", "EXPERT")
    ).collect(toList());

    @GetMapping
    @PreAuthorize("hasAuthority('products:read')")
    public List<Developer> getAll() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
}