package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class RoomDaoCustomImpl implements RoomDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findRoomByName(String name) {
        String jpql = "select r from Room r where r.name = :name";
        return em.createQuery(jpql, Room.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Room> findRoomByBuildingId(Long buildingId) {
        String jpql = "select r from Room r where r.building.id = :buildingId";
        return em.createQuery(jpql, Room.class)
                .setParameter("buildingId", buildingId)
                .getResultList();
    }
}
