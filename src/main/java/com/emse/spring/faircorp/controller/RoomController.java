package com.emse.spring.faircorp.controller;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {
    private final RoomDao roomDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;

    private final BuildingDao buildingDao;


    public RoomController(RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao,BuildingDao buildingDao) {
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
        this.buildingDao = buildingDao;
    }
    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }
    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }
    @PostMapping
    public RoomDto create(@RequestBody RoomDto dto) {
        Room room = null;
        Building building= buildingDao.getReferenceById(dto.getBuildingId());
        // On creation id is not defined
        if (dto.getId() == null) {
            room = roomDao.save(new Room( building,dto.getName()));
        }
        else {
            room = roomDao.getReferenceById(dto.getId());
            room.setName(dto.getName());
            room.setBuilding(building);
        }
        return new RoomDto(room);
    }
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }

    @PutMapping(path = "/{id}/switch-windows")
    @Transactional
    public void switchWindows(@PathVariable Long id) {
        Room room = roomDao.getReferenceById(id);
        for (Window window : windowDao.findWindowsRoomName(id)) {
            window.setWindowStatus(window.getWindowStatus());
        }
    }

    @DeleteMapping(path = "/{id}/windows")
    @Transactional
public void deleteWindows(@PathVariable Long id) {
        Room room = roomDao.getReferenceById(id);
        for (Window window : windowDao.findWindowsRoomName(id)) {
            windowDao.delete(window);
        }
    }

    @GetMapping(path = "/{id}/building/{buildingId}")
    public List<RoomDto> findByBuildingId( @PathVariable Long buildingId) {
        return roomDao.findRoomByBuildingId(buildingId).stream().map(RoomDto::new).collect(Collectors.toList());
    }

}
