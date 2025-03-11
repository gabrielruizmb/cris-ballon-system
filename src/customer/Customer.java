package customer;

import java.time.LocalDateTime;

import system.CreationDate;

public class Customer extends CreationDate{
    private String name;
    private String phone;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public Customer() {}

    public Customer(String name, String phone, String address, LocalDateTime creationDate) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        setCreationDate(creationDate);
    }
}