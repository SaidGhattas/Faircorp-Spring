package com.emse.spring.faircorp.controller;

import com.emse.spring.faircorp.dao.BuildingDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BuildingController.class)
public class BuildingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private static Logger logger = LogManager.getLogger(BuildingControllerTest.class);

    @MockBean
    private BuildingDao buildingDao;

    @Test
    public void shouldLoadAllBuildings () throws Exception {
        try {
            mockMvc.perform(get("/api/buildings")).andExpect(status().isOk());
        } catch (Exception e) {
            logger.error("Error caught: ",e);
        }
    }




}
