package customer;

import java.time.LocalDateTime;

import system.CreationDate;

public class Customer extends CreationDate{
    private String name;
    private String phone;
    private String address;

    public boolean setName(String name) {
        if(name.isBlank())
            return false;

        this.name = name;
        return true;
    }

    public String getName() {
        return this.name;
    }

    public boolean setPhone(String phone) {
        if(phone.isBlank())
            return false;

        this.phone = phone;
        return true;
    }

    public String getPhone() {
        return this.phone;
    }

    public boolean setAddress(String address) {
        if(address.isBlank())
            return false;
        
        this.address = address;
        return true;
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