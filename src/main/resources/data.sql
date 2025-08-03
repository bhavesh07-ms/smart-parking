INSERT INTO vehicle (license_plate, type) VALUES ('MH12AB1234', 'CAR');
INSERT INTO vehicle (license_plate, type) VALUES ('MH14XY5678', 'MOTORCYCLE');
INSERT INTO vehicle (license_plate, type) VALUES ('DL01CD4321', 'BUS');


INSERT INTO rate_card (id, type, rate_per_hour) VALUES (1, 'CAR', 20.0);
INSERT INTO rate_card (id, type, rate_per_hour) VALUES (2, 'MOTORCYCLE', 10.0);
INSERT INTO rate_card (id, type, rate_per_hour) VALUES (3, 'BUS', 50.0);

INSERT INTO parking_floor (id, floor_number) VALUES (1, 1);
INSERT INTO parking_floor (id, floor_number) VALUES (2, 2);


INSERT INTO parking_spot (id, allowed_type, occupied, floor_id) VALUES (1, 'CAR', false, 1);
INSERT INTO parking_spot (id, allowed_type, occupied, floor_id) VALUES (2, 'MOTORCYCLE', false, 1);
INSERT INTO parking_spot (id, allowed_type, occupied, floor_id) VALUES (3, 'BUS', false, 1);
INSERT INTO parking_spot (id, allowed_type, occupied, floor_id) VALUES (4, 'CAR', true, 2);
INSERT INTO parking_spot (id, allowed_type, occupied, floor_id) VALUES (5, 'MOTORCYCLE', false, 2);

