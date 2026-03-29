package com.budget.budget.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="add_client")
public class AddClient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String state;
    private String brand;
    private String product;


    public AddClient() {
    }

    //GETTER

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public String getBrand(){
        return brand;
    }
    public String getProduct(){
        return product;
    }

    //SETTER

    public void setName(String name) {
        this.name = name;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setProduct(String product) {
        this.product = product;
    }


}
