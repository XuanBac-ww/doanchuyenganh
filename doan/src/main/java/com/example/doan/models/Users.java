package com.example.doan.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {
    public Users() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String roles;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Authorities> authorities;


    public Users(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.roles = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
