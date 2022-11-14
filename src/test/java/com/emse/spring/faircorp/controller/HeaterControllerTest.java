package com.emse.spring.faircorp.controller;


import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import java.util.Arrays;
import java.util.Optional;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HeaterController.class)
public class HeaterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HeaterDao heaterDao;

    @MockBean
    private RoomDao roomDao;

    @Test
    public void shouldLoadAllHeaters () throws Exception {
        given(heaterDao.findAll()).willReturn(Arrays.asList(
                new Heater("Heater 1", 10L, new Room(new Building(), "Room 1"),HeaterStatus.ON),
                new Heater( "Heater 2", 10L, new Room(new Building(), "Room 1"), HeaterStatus.ON)
        ));
        mockMvc.perform(get("/api/heaters"))
                .andExpect(jsonPath("[*].name").value(Arrays.asList("Heater 1", "Heater 2")));
    }

    @Test
    public void shouldLoadAHeater () throws Exception {
        given(heaterDao.findById(1L)).willReturn(Optional.of(new Heater("Heater 1", 10L, new Room(new Building(), "Room 1"),HeaterStatus.ON)));
        mockMvc.perform(get("/api/heaters/1"))
                .andExpect(jsonPath("name").value("Heater 1"));
    }

    @Test
    public void shouldLoadAHeaterAndReturnNullIfNotFound () throws Exception {
        given(heaterDao.findById(999L)).willReturn(Optional.empty());
        mockMvc.perform(get("/api/heaters/999"))
                .andExpect(jsonPath("name").doesNotExist());
    }
    @Test
    public void shouldCreateAHeater () throws Exception {
        given(roomDao.findById(1L)).willReturn(Optional.of(new Room(new Building(), "Room 1")));
        mockMvc.perform(post("/api/heaters")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Heater 1\", \"power\": 10, \"roomId\": 1, \"status\": \"ON\"}"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("name").value("Heater 1"))
                .andExpect(jsonPath("power").value(10))
                .andExpect(jsonPath("roomId").value(1))
                .andExpect(jsonPath("status").value("ON"));
    }


}

