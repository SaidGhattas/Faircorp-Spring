package com.emse.spring.faircorp.controller;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.RoomDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
public class RoomControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuildingDao buildingDao;

    @MockBean
    private RoomDao roomDao;

    @Test
    public void shouldLoadAllRooms () throws Exception {
        mockMvc.perform(get("/api/rooms"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldLoadAllRoomsByBuilding () throws Exception {
        mockMvc.perform(get("/api/rooms/{id}/building/1"))
                .andExpect(status().isOk());
    }

   @Test
    public void shouldCreateRoom () throws Exception {
        mockMvc.perform(post("/api/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \\\"buildingId\\\": 1, \\\"id\\\": 0, \\\"name\\\": \\\"Room 4\\\" \\\"current_temperature\\\":20, \\\"target_temperature\\\":21}"))
                .andExpect(status().isOk());
    }

}
