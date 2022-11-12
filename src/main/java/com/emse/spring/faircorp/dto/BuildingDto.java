package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Building;

public class BuildingDto {
    private Long id;
    private String name;
    private String address;
    private String city;
    private Integer zipCode;

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.address = building.getAddress();
        this.city = building.getCity();
        this.zipCode = building.getZipCode();

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
