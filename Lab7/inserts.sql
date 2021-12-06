USE pharmacy_db;


INSERT INTO street (name) VALUES ('Oxford '),
('Abbey '), ('Bond '),  ( 'Piccadilly'),( 'Baker '),
( 'Savile '),('Carnaby '), ('Regent '), ('Jermyn '),( 'Downing ');

INSERT INTO post ( name) VALUES ( 'nurse'),
('doctor'),('military'),('dean'),('teacher'),
('director'),('academic'),('instructor');

INSERT INTO pharmacy (id, name,street_id, building_number, web_adress, work_time_open, 
work_time_close, is_open_saturday, is_open_sunday)
VALUES ('1', 'Gould','1', '23', 'www.gouldeffect_zone.com', '9:00', '18:00', '1', '1'),
('2', 'click','4', '12', 'www.click.ua', '00:00', '00:00', '1', '1'),
('3', 'health','8', '1', 'www.health.com', '10:00', '21:00', '0', '0'),
('4', 'audley','4', '4', 'www.audley.org', '6:00', '22:00', '0', '1'),
('5', 'Harrods','1', '5', 'www.harrods.ua', '9:00', '17:00', '0', '0'),
('6', 'Mayfair','7', '32', 'www.mayfair.com', '13:00', '18:00', '1', '0'),
('7', 'Baban','1', '13', 'www.baban.com', '10:00', '16:00', '0', '1'),
('8', 'Chel Pharmacy', '4','21', 'www.chel.com', '8:30', '00:00', '1', '1'),
('9', 'Portmans pharmacy','3', '1', 'www.portmans.ua', '10:00', '17:00', '1', '0'),
('10', 'drugs', '2','42', 'www.drugstore.ua', '9:45', '21:45', '0', '0');


INSERT INTO effect_zone (name) VALUES ('lungs'),
('knee'), ('bones'),('neck'), ('back'),
('stomach'),('liver'),('tooth'),('eyes'), ('ears');


INSERT INTO employee (name, surname, middle_name, identity_number, passport_data, experience, birth_date, post_id, pharmacy_id) VALUES 
('Taras', 'Romeo', 'Tarasovych', '1234342674', 'fn2123111', '2 ', '2002-12-12', '1', '1'),
('Andriy', 'Igor', 'Igor', '1213423100', 'af1901930', '0 ', '2000-11-07', '3', '1'),
('Lewis', 'Ihor', 'Misha', '3221213400', 'at3003291', '4 ', '2003-09-15', '5', '4'),
('Yura', 'Sidney', 'Oleg', '4233909400', 'gr3020392', '15 ', '1980-07-28', '7', '2'),
('Yaroslav', 'Mircha', 'Roman', '1000000000', 'ui2039029', '12', '1991-09-09', '6', '9'),
('Roman', 'Leo', 'Kit', '2329310900', 're4039404', '6.5', '2000-01-01', '4', '3'),
('Kit', 'Donatello', 'Lesia', '9999999999', 'ps1337220', '9', '2003-05-15', '6', '6'),
('Misha', 'Rafael', 'Linda', '2930293092', 'rt3949392', '13', '1840-03-09', '8', '8'),
('Oleg', 'Mike', 'Rivaldo', '3209302940', 'po093094', '5', '1876-05-07', '2', '4'),
('Yulia', 'Sergio', 'Ricardio', '2930290392', 'uy309403', '4', '1856-08-27', '3', '1');


INSERT INTO medicine_list (name, ministry_code, require_recipe, is_narcotic, is_psychtropic) VALUES ('Nimesyl', '324', '1', '0', '0'),
('Natrol', '789', '0', '0', '0'),
('Omega 3', '123', '0', '0', '0'),
('Foods', '324', '0', '0', '0'),
('Ibuprom', '789', '0', '0', '1'),
('NimesylidNalgezin', '176', '1', '0', '0'),
('Vitamin C', '300', '0', '0', '0'),
('Nalgezin', '993', '0', '1', '0'),
('Ameolin', '993', '1', '0', '1'),
('Ibuprofen', '346', '0', '0', '0');


INSERT INTO pharmaсy_has_medicine (pharmacy_id, medicine_id) VALUES (1, 3),
(3, 2),
(6, 6),
(1, 7),
(2, 5),
(3, 8),
(4, 4),
(10, 10),
(8, 1),
(7, 6);


INSERT INTO medicine_zone (medicine_id, zone_id) VALUES 
(1, 3),
(2, 5),
(3, 4),
(5, 1),
(7, 2),
(10, 4),
(4, 6),
(6, 7),
(9, 2),
(3, 8);