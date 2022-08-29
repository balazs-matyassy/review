package hu.progmatic.review.service;

import hu.progmatic.review.model.Product;
import hu.progmatic.review.model.Review;
import hu.progmatic.review.repository.ProductRepository;
import hu.progmatic.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// magasabb szintű funkciók
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public ProductService(ProductRepository productRepository, ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    public void createTestData() {
        Product product = new Product("Product1", "Hello World", 5000);
        Review review1 = new Review(product,":)", LocalDateTime.now());
        Review review2 = new Review(product,":)", LocalDateTime.now());

        productRepository.save(product);

        /* if (true) {
            throw new RuntimeException();
        } */

        reviewRepository.save(review1);
        reviewRepository.save(review2);
    }

}
