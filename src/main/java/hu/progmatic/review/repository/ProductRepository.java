package hu.progmatic.review.repository;

import hu.progmatic.review.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
