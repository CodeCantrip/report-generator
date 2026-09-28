package io.github.codecantrip.reportgenerator.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class AppUser {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID userId;
    private String username;
    private String password;
    private String role;


    public AppUser(){

    }

    public AppUser(String username, String password, String role){
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
