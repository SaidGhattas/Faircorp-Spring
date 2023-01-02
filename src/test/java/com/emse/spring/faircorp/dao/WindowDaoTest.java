package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;


/**
    * This class is used to test the WindowDao class
    * It includes 4 tests
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
class WindowDaoTest {
    @Autowired
    private WindowDao windowDao;
    private static Logger logger = LogManager.getLogger(WindowDaoTest.class);


    /**
        * This test is used to test the findWindowById method
        * @param id the id of the window
        * @return the window with the given id
     */
    @Test
    public void shouldFindAWindow() {
        Window window = windowDao.getReferenceById(-10L);
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.CLOSED);
        logger.info("shouldFindAWindow test worked");
    }

    @Test
    public void shouldFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(-9L);
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id", "windowStatus")
                .containsExactly(Tuple.tuple(-8L, WindowStatus.OPEN));
    }

    @Test
    public void shouldNotFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(-10L);
        Assertions.assertThat(result).isEmpty();
    }
    @Test
    public void shouldDeleteAllWindows() {
        windowDao.deleteAllWindows();
        Assertions.assertThat(windowDao.findAll()).isEmpty();
    }
}