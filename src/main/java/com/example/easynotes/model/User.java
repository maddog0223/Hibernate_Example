package com.example.easynotes.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdate", "updatedate"}, allowGetters = true)
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank = Not Null
    @NotBlank
    private String fname;

    @NotBlank
    private String lname;

    @NotBlank
    private String favorite_drink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFavorite_drink() {
        return favorite_drink;
    }

    public void setFavorite_drink(String favorite_drink) {
        this.favorite_drink = favorite_drink;
    }
}
