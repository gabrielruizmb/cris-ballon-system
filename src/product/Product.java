package product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import system.CreationDate;

public class Product extends CreationDate{
    private String name;
    private BigDecimal price;
    private String description;

    public boolean setName(String name) {
        if (name.isBlank())
            return false;
            
        this.name = name;
        return true;
    }

    public String getName() {
        return this.name;
    }

    public boolean setPrice(String price) {
        try {
            this.price = new BigDecimal(price);
            return true;
        } catch(Exception exception) {
            return false;
        }
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public boolean setDescription(String description) {
        if(description.isBlank())
            return false;

        this.description = description;
        return true;
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
