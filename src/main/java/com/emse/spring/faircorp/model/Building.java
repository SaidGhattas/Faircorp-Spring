package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name = "RBUILDING")
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    private String address;
    private String city;
    private Integer zipCode;

    public Building() {
    }
    public Building(String name) {
        this.name = name;
    }

    public Building(String name, String address, String city, Integer zipCode) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Building(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}
