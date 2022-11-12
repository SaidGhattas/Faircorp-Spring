package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
public class Heater {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    private Long power;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Room room;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private HeaterStatus heater_status;

    public Heater(String name, Long power, Room room, HeaterStatus heater_status) {

        this.name = name;
        this.power = power;
        this.room = room;
        this.heater_status = heater_status;
    }

    public Heater(String name, Room room, HeaterStatus status) {
        this.name = name;
        this.room = room;
        heater_status = status;
    }

    public HeaterStatus getHeater_status() {
        return heater_status;
    }

    public void setHeater_status(HeaterStatus heater_status) {
        this.heater_status = heater_status;
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

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getHeaterStatus() {
        return heater_status;
    }

    public void setHeaterStatus(HeaterStatus heater_status) {
        this.heater_status = heater_status;
    }

    public Heater() {
    }

}
