package com.example.demoapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "sa_user")
public class User {
    @Id
    private String id;
    @Field("username")
    private String username;
    @Field("password")
    private String password;
    @Field("cart")
    private List<ProductCart> cart;

    public List<ProductCart> getCart() {
        return cart;
    }

    public void setCart(List<ProductCart> cart) {
        this.cart = cart;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
