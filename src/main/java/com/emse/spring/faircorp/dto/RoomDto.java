package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Room;

public class RoomDto {
    private Long id;
    private String name;
    private Long buildingId;

    private Double current_temperature;
    private Double target_temperature;



    public RoomDto() {
    }
    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.buildingId = room.getBuilding().getId();
        this.current_temperature = room.getCurrent_temperature();
        this.target_temperature = room.getTarget_temperature();
    }
    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getBuildingId() {
        return buildingId;
    }
    public void setBuildingId(Long buildingId) {this.buildingId = buildingId;}


}
