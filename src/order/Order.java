package order;

import java.time.LocalDateTime;

public class Order {
    int clientNumber;
    String description;
    String status;
    LocalDateTime date;
    
    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Order() {}
    
    public Order(int clientNumber, String description, String status, LocalDateTime date) {
        this.clientNumber = clientNumber;
        this.description = description;
        this.status = status;
        this.date = date;
    }
}
