package ua.com.training.rest;

import org.springframework.web.bind.annotation.*;
import ua.com.training.model.Developer;
import ua.com.training.service.UserService;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/senior-cashiers")
public class SeniorCashierRestController {

    private final UserService userService;

    public SeniorCashierRestController(UserService userService) {
        this.userService = userService;
    }

    private final List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L,"Ivan", "SENIOR"),
            new Developer(2L,"Sergey", "SENIOR"),
            new Developer(3L,"Petr", "SENIOR")
    ).collect(toList());

    @GetMapping
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
