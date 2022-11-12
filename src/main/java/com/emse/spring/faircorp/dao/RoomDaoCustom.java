package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomDaoCustom {
    List<Room> findRoomByName(String name);

    List<Room> findRoomByBuildingId(Long buildingId);
}
