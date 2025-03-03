package product;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String description;
    private BigDecimal price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Product() {}

    public Product(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
