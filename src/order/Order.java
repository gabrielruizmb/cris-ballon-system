package order;

import java.time.LocalDateTime;

import system.CreationDate;

// Herdando atributos e métodos da classe CreationDate
public class Order extends CreationDate {
    private int clientNumber;
    private String description;
    private String status;
    //LocalDateTime creationDate;       <-- Agora herdamos este atributo e os 
    //                                      métodos da classe CreationDate.
    private LocalDateTime closingDate;

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }
    
    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        if(description.isBlank())
            return false;
            
        this.description = description;
        return true;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*  Métodos herdados de CreationDate

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    } 
    */

    public LocalDateTime getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDateTime closingDate) {
        this.closingDate = closingDate;
    }

    public Order() {}
    
    public Order(int clientNumber, String description, String status, 
                 LocalDateTime creationDate) {
        this.clientNumber = clientNumber;
        this.description = description;
        this.status = status;
        setCreationDate(creationDate);
    }
}
