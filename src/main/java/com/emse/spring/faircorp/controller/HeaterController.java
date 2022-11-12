package com.emse.spring.faircorp.controller;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/heaters")
@Transactional
public class HeaterController {
    private final HeaterDao heaterDao;
    private final RoomDao roomDao;
public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }
    @GetMapping
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());
    }
    @GetMapping(path = "/{id}")
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null);
    }
    @PutMapping(path = "/{id}/switch")
    public HeaterDto switchStatus(@PathVariable Long id) {
        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        return new HeaterDto(heater);
    }
    @GetMapping(path = "/{id}/room")
    public List<HeaterDto> findByRoomId(@RequestParam Long roomId) {
        Room room = roomDao.getReferenceById(roomId);
        return heaterDao.findByRoomId(room).stream().map(HeaterDto::new).collect(Collectors.toList());
    }
    @PostMapping
    public HeaterDto create(@RequestBody HeaterDto dto) {
        // HeaterDto must always contain the heater room
        Room room = roomDao.getReferenceById(dto.getRoomId());
        Heater heater = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            heater = heaterDao.save(new Heater(dto.getName(), room, dto.getHeaterStatus()));
        }
        else {
            heater = heaterDao.getReferenceById(dto.getId());
            heater.setHeaterStatus(dto.getHeaterStatus());
            heater.setPower(dto.getPower());
            heater.setName(dto.getName());
        }
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }


}
