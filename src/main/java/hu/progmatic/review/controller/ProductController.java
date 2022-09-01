package hu.progmatic.review.controller;

import hu.progmatic.review.model.Product;
import hu.progmatic.review.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/expensive")
    public String expensivePage(Model model) {
        List<Product> products = productService.getExpensiveProducts();
        model.addAttribute("products", products);

        return "products";
    }

}
