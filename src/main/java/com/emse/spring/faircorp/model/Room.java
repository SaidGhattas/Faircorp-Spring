package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RROOM")
public class Room {
    public Room() {
    }

    public Room(Building building, String name) {
        this.building = building;
        this.name = name;
    }
    public Room(Long id, Building building, String name) {
        this.id = id;
        this.building = building;
        this.name = name;
    }

    public Room(Long id, String name, Double current_temperature, Double target_temperature, Building building) {
        this.id = id;
        this.name = name;
        this.current_temperature = current_temperature;
        this.target_temperature = target_temperature;
        this.building = building;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    private Double current_temperature;
    private Double target_temperature;

    @OneToMany(mappedBy = "room")
    private List<Heater> heaterList ;

    @ManyToOne(optional = false)
    private Building building;
    @OneToMany(mappedBy = "room")
    private List<Window> windowList ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Building getBuilding() {return building;}
    public void setBuilding(Building building) {this.building = building;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrent_temperature() {
        return current_temperature;
    }

    public void setCurrent_temperature(Double current_temperature) {
        this.current_temperature = current_temperature;
    }

    public Double getTarget_temperature() {
        return target_temperature;
    }

    public void setTarget_temperature(Double target_temperature) {
        this.target_temperature = target_temperature;
    }

    public List<Heater> getHeaterList() {
        return heaterList;
    }

    public void setHeaterList(List<Heater> heaterList) {
        this.heaterList = heaterList;
    }

    public List<Window> getWindowList() {
        return windowList;
    }

    public void setWindowList(List<Window> windowList) {
        this.windowList = windowList;
    }
}
