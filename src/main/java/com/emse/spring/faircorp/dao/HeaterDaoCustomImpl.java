package com.emse.spring.faircorp.dao;


import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HeaterDaoCustomImpl implements HeaterDaoCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void deleteAllHeaters(Long id) {
        String jpql = "delete from Heater h where h.room.id = :id";
        em.createQuery(jpql).setParameter("id", id).executeUpdate();
    }


    @Override
    public Heater findHeaterById(Long id) {
        String jpql = "select h from Heater h where h.id = :id";
        return em.createQuery(jpql, Heater.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Heater> findByRoomId(Room room) {
        String jpql = "select h from Heater h where h.room.id = :id";
        return em.createQuery(jpql, Heater.class).setParameter("id", room.getId()).getResultList();
    }


}
