INSERT INTO RBUILDING(id, name, address,zipCode) VALUES(-10, 'Building1', 'Address1',40000);
INSERT INTO RBUILDING(id, name, address,zipCode) VALUES(1, 'Building2', 'Address2',42100);


INSERT INTO RROOM(id, name, building_Id, current_temperature, target_temperature) VALUES(-10, 'Room1', 1, 22.3, 20.0);
INSERT INTO RROOM(id, building_Id, name) VALUES(-9, -10, 'Room2');


INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-10, 'ON', 'Heater1', 2000, -10);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-9, 'ON', 'Heater2', 1000, -9);

INSERT INTO RWINDOW(id, WINDOW_STATUS , name, room_id) VALUES(-10, 'CLOSED', 'Window 1', -10);
INSERT INTO RWINDOW(id, WINDOW_STATUS , name, room_id) VALUES(-9, 'CLOSED', 'Window 2', -10);
INSERT INTO RWINDOW(id, WINDOW_STATUS , name, room_id) VALUES(-8, 'OPEN', 'Window 1', -9);
INSERT INTO RWINDOW(id, WINDOW_STATUS , name, room_id) VALUES(-7, 'CLOSED', 'Window 2', -9);

