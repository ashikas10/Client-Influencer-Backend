package com.budget.budget.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="add_influencer")
public class AddInfluencer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String state;
    private String instaUserName;
    private String budget;
    private String product;


    public AddInfluencer() {
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
    public String getInstaUserName(){
        return instaUserName;
    }
    public String getBudget(){
        return budget;
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
    public void setInstaUserName(String instaUserName) {
        this.instaUserName = instaUserName;
    }
    public void setBudget(String budget) {
        this.budget = budget;
    }
    public void setProduct(String product) {
        this.product = product;
    }
}

