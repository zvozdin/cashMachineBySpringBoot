package ua.com.training;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.training.dao.ProductRepository;
import ua.com.training.model.Product;
import ua.com.training.model.Size;

import java.util.List;

@Controller
public class MainController {

    private final ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/hello")
    @Transactional
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                        Model model) {
        model.addAttribute("name", name);

        System.out.println(productRepository.getClass());


        productRepository.save(generateProduct());

        List<Product> products = productRepository.findAll();

        int update = productRepository.updateQuantityProductByCode(products.get(2).getCode(), 1111);

        return "hello";
    }

    private Product generateProduct() {
        Product product = new Product();
        product.setCode(String.valueOf((int)(Math.random()*9000)+1000));
        product.setName("test");
        product.setName_UA("ua_test");
        product.setSize(Size.M);
        product.setPrice(100d);
        product.setQuantity(100);
        return product;
    }
}