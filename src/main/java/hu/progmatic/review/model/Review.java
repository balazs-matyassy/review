package hu.progmatic.review.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    // many reviews to one product
    @ManyToOne
    private Product product;

    @Lob
    private String description;

    private LocalDateTime createdAt;

    public Review() {
    }

    public Review(String description, LocalDateTime createdAt) {
        this.description = description;
        this.createdAt = createdAt;
    }

    public Review(Product product, String description, LocalDateTime createdAt) {
        this.product = product;
        this.description = description;
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", product=" + product +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
