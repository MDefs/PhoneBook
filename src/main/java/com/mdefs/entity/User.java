package com.mdefs.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.*;

@Entity
@Table(name = "account")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @Pattern(regexp = "([a-zA-Z0-9])+", message = "Must include capital or small letters and numbers")
    @Length(min = 3, message = "length mus be at least 3 symbols")
    private String username;

    @Transient
    @Length(min = 5, message = "length mus be at least 5 symbols")
    @Pattern(regexp = "([a-zA-Z0-9])+", message = "must contain capital or small letters and numbers")
    private String password;

    @Column(name = "password")
    private String encodePassword;

    @Column(name = "fio")
    @Length(min = 5, message = "length mus be at least 5 symbols")
    private String fio;

    @Transient
    private String confirmPassword;



    public String getEncodePassword() {
        return encodePassword;
    }

    public void setEncodePassword(String encodePassword) {
        this.encodePassword = encodePassword;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
