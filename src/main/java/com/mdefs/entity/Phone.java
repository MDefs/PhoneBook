package com.mdefs.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @NotEmpty(message = "is required")
    @Length(min = 4, message = "length mus be at least 4 symbols")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "is required")
    @Length(min = 4, message = "length mus be at least 4 symbols")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "is required")
    @Length(min = 4, message = "length mus be at least 4 symbols")
    @Column(name = "middle_name")
    private String middleName;

    @NotEmpty(message = "is required")
    @Pattern(regexp = "^\\+380\\d{3}\\d{2}\\d{2}\\d{2}$", message = "format must much +380*********")
    @Column(name = "mobile_phone")
    private String mobilePhone ;

    @Column(name = "home_phone")
    private String homePhone ;

    @Column(name = "address")
    private String address ;

//    @Pattern(regexp = "/.+@.+\\..+/i", message = "invalid email")
    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
