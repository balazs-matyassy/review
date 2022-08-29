package hu.progmatic.review.command;

import hu.progmatic.review.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitCommand implements CommandLineRunner {
    private final ProductService productService;

    public InitCommand(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating test data...");
        productService.createTestData();
        System.out.println("Test data created...");
    }
}
