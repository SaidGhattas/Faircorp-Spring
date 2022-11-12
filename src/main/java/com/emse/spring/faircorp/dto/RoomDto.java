package com.emse.spring.faircorp.dto;
import com.emse.spring.faircorp.model.Room;

public class RoomDto {
    private Long id;
    private String name;
    private Long buildingId;



    public RoomDto() {
    }
    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.buildingId = room.getBuilding().getId();
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
    public Long getBuildingId() {
        return buildingId;
    }
    public void setBuildingId(Long buildingId) {this.buildingId = buildingId;}


}
