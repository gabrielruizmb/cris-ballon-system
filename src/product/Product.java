package product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import system.CreationDate;

public class Product extends CreationDate{
    private String name;
    private BigDecimal price;
    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public Product() {}

    public Product(String name, String description, BigDecimal price, LocalDateTime creationDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        setCreationDate(creationDate);
    }
}
