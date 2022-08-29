package hu.progmatic.review.repository;

import hu.progmatic.review.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // https://www.baeldung.com/spring-data-derived-queries
    // SELECT * FROM product WHERE name = :name;
    Optional<Product> findByName(String name);
    // Product findByName(String name);

    // SELECT * FROM product WHERE name LIKE '%:name%' ORDER BY name;
    List<Product> findByNameContainingOrderByName(String name);

}
