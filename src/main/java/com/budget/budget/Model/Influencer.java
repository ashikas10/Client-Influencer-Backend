package com.budget.budget.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Influencer")
public class Influencer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String mobile;
    private String gender;
    private String platform;
    private String instauser;
    private String followers;
    private String budget;
    private String product;
    private String others;
    // default constructor
    public Influencer() {}

    // getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public String getGender() {
        return gender;
    }

    public String getPlatform() {
        return platform;
    }

    public String getInstauser() {
        return instauser;
    }

    public String getFollowers() {
        return followers;
    }

    public String getBudget() {
        return budget;
    }

    public String getProduct() {
        return product;
    }
    
    public String getOthers() {
        return others;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setInstauser(String instauser) {
        this.instauser = instauser;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    
    public void setOthers(String others) {
        this.others = others;
    }

}

