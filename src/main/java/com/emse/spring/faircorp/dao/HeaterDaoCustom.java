package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;

import java.util.Arrays;
import java.util.List;

public interface HeaterDaoCustom {

    //delete all heaters by id room
    void deleteAllHeaters(Long id);



    //find heater by id
    Heater findHeaterById(Long id);

    List<Heater> findByRoomId(Room room);

}
