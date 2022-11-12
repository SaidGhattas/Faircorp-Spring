package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;

import java.util.Arrays;
import java.util.List;

public interface WindowDaoCustom {
    List<Window> findRoomOpenWindows(Long id);
    List<Window> findWindowsRoomName(Long id);
    void deleteAllWindows();

    List<Window> findByRoomId(Long roomId);
}
