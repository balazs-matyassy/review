package hu.progmatic.review.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // hosszú szövegek tárolása,
    // rövid szövegnél nem szükséges
    @Lob
    private String description;

    private int price;

    // one product to many reviews
    // CascadeType.ALL
    // A csomagok is automatikusan felszállnak és leszállnak a repülőről.
    // orphanRemoval = true -> csomagot nem lehet "eladni", nem lehet új tulajdonosa
    // review.setProduct(newProduct) törli a reviewt -> nem tud gazdát cserélni
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
