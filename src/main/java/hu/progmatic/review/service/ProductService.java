package hu.progmatic.review.service;

import hu.progmatic.review.model.Product;
import hu.progmatic.review.model.Review;
import hu.progmatic.review.repository.ProductRepository;
import hu.progmatic.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// magasabb szintű funkciók
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public ProductService(ProductRepository productRepository, ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    // mindent vagy semmit művelet
    // https://www.baeldung.com/transaction-configuration-with-jpa-and-spring
    // https://www.baeldung.com/spring-transactional-propagation-isolation (kiegészítő anyag)
    // ROLLBACK -> eredeti állapot visszaállítása
    // COMMIT -> módosítások véglegesítése
    @Transactional
    public void createTestData() {
        Product product1 = new Product("Product1", "Hello World", 5000);
        Review review1 = new Review(product1,"Nagyon jó! :)", LocalDateTime.now());
        Review review2 = new Review(product1,"Szuper :)", LocalDateTime.now());

        Product product2 = new Product("Product2", "I <3 Java!", 15000);
        Product product3 = new Product("Product3", "Java is cool!", 25000);
        Product product4 = new Product("Product4", "C++ vs Java!", 8500);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);

        /* if (true) {
            throw new RuntimeException();
        } */

        reviewRepository.save(review1);
        reviewRepository.save(review2);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        // Optional<Product> result = productRepository.findByName("aaa");
        // Product product = result.orElseThrow(); // nem kell if
        // Product product = result.orElse(new Product()); // nem kell if

        // return (List<Product>) productRepository.findAll();
        return productRepository.findByOrderByNameDesc();
    }

    public List<Product> getExpensiveProducts() {
        return productRepository.findByPriceGreaterThanEqualOrderByPriceDesc(10000);
    }

}
