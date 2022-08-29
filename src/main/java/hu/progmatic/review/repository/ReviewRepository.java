package hu.progmatic.review.repository;

import hu.progmatic.review.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
