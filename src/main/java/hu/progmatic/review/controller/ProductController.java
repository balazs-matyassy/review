package hu.progmatic.review.controller;

import hu.progmatic.review.model.Product;
import hu.progmatic.review.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    // 1. űrlap megjelenítése
    @GetMapping("/product/create")
    public String newProductPage(Model model) {
        // Product product = new Product(); // üres default
        // űrlapnak vannak kezdőértékei
        Product product = new Product("aaa", "bbb", 100);
        model.addAttribute("product", product);

        return "create";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);

        return "redirect:/";
    }

}
