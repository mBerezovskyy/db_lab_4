DROP DATABASE IF EXISTS `fixbus_db`;
CREATE DATABASE IF NOT EXISTS `fixbus_db`;
USE `fixbus_db` ;


CREATE TABLE IF NOT EXISTS `Manufacturer` (
  `name` VARCHAR(30) NOT NULL,
  `phone_number` VARCHAR(13) NOT NULL,
  `office_adress` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;

INSERT INTO `Manufacturer` (`name`, `phone_number`, `office_adress`) VALUES
('Man', '+380679877411', 'vul. Shevchenka 20a'),
('LAZ', '+380679877412', 'vul. Shevchenka 21a'),
('Ikarus', '+380679877413', 'vul. Shevchenka 22'),
('Otokar', '+380679877414', 'vul. Shevchenka 23a'),
('Scania', '+380679877415', 'vul. Shevchenka 24'),
('Sanos', '+380679877416', 'vul. Shevchenka 25a'),
('Daewoo', '+380679877417', 'vul. Shevchenka 26c'),
('Ikarbus', '+380671877418', 'vul. Shevchenka 27a'),
('Setra', '+380672877419', 'vul. Shevchenka 28d'),
('Solbus', '+380673877410', 'vul. Shevchenka 29d'),
('Volvo', '+380674877311', 'vul. Shevchenka 31'),
('Unic', '+380675877211', 'vul. Shevchenka 32a'),
('Neoplan', '+380679877111', 'vul. Shevchenka 33a'),
('Irisbus', '+380678877611', 'vul. Shevchenka 34a'),
('Materfer', '+380677877711', 'vul. Shevchenka 35b');


CREATE TABLE IF NOT EXISTS `Bus` (
  `number_sign` VARCHAR(8) NOT NULL,
  `age` INT NOT NULL,
  `capacity` INT NOT NULL,
  `mileage` INT NOT NULL,
  `Manufacturer_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`number_sign`),
  CONSTRAINT `fk_Bus_Manufacturer`
    FOREIGN KEY (`Manufacturer_name`)
    REFERENCES `fixbus_db`.`Manufacturer` (`name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO `Bus` (`number_sign`, `age`, `capacity`, `mileage`, `Manufacturer_name`) VALUES
('BC0001BT', 15, 40, 14, 'LAZ'),
('BC0002BT', 14, 35, 13, 'Daewoo'),
('BC0003BT', 13, 40, 12, 'LAZ'),
('BC0004BT', 12, 35, 11, 'Scania'),
('BC0005BT', 11, 30, 10, 'LAZ'),
('BC0006BT', 10, 35, 9, 'Neoplan'),
('BC0007BT', 9, 40, 8, 'LAZ'),
('BC0008BT', 8, 40, 7, 'LAZ'),
('BC0009BT', 7, 35, 6, 'Daewoo'),
('BC0010BT', 6, 40, 5, 'Unic'),
('BC0011BT', 5, 40, 4, 'LAZ'),
('BC0012BT', 4, 35, 3, 'Daewoo'),
('BC0013BT', 3, 35, 2, 'LAZ'),
('BC0014BT', 2, 30, 1, 'Scania'),
('BC0015BT', 1, 30, 0, 'Unic');

CREATE INDEX number_sign ON Bus(number_sign);

CREATE TABLE IF NOT EXISTS `Stop` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `district` VARCHAR(45) NOT NULL,
  `street_name` VARCHAR(45) NOT NULL,
  `street_number` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `Stop` (`district`, `street_name`, `street_number`) VALUES
('Lychakivskyi','Lysenka', '12'),
('Shevchenkivskyi','Shevchenka', '356a'),
('Zaliznychnyj','Lublinska', '10b'),
('Sykhiv','Drahana', '117'),
('Tsentr','Doroshenka', '50'),
('Lychakivskyi','Lisna', '5a'),
('Shevchenkivskyi','Riasnenska', '87'),
('Zaliznychnyj','Levandivska', '3c'),
('Levandivka','Siajvo', '22'),
('Shevchenkivskyi','Zamarstynivska', '67'),
('Sykhiv','Chervonoyi Kalyny', '132'),
('Lychakivskyi','Dzhordzha Vashyngtona', '21'),
('Lychakivskyi','Pasichna', '2'),
('Sykhiv','Dovzhenka', '45b'),
('Shevchenkivskyi','Zavodska', '12a');

CREATE TABLE IF NOT EXISTS `Route` (
  `number` INT NOT NULL,
  `total_fare` INT NOT NULL,
  `starting_stop_id` INT NOT NULL,
  `end_stop_id` INT NOT NULL,
  PRIMARY KEY (`number`),
  CONSTRAINT `fk_Route_Stop1`
    FOREIGN KEY (`starting_stop_id`)
    REFERENCES `fixbus_db`.`Stop` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Route_Stop2`
    FOREIGN KEY (`end_stop_id`)
    REFERENCES `fixbus_db`.`Stop` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX number ON Route(number);

INSERT INTO `Route` (`number`, `total_fare`, `starting_stop_id`, `end_stop_id`) VALUES
(17, 7, 1, 2),
(18, 5, 2, 3),
(19, 10, 3, 4),
(20, 7, 4, 5),
(21, 10, 5, 6),
(22, 7, 6, 7),
(23, 5, 7, 8),
(24, 7, 8, 9),
(25, 10, 9, 10),
(26, 7, 10, 11),
(27, 5, 11, 12),
(28, 7, 12, 13),
(29, 10, 13, 14),
(30, 5, 14, 15),
(31, 7, 1, 3);

CREATE TABLE IF NOT EXISTS `Driver` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birthday` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `Driver` (`name`, `surname`, `birthday`) VALUES
('Petro', 'Popov', '1988-12-1'),
('Stepan', 'Petrov', '1988-11-2'),
('Ivan', 'Popov', '1988-10-3'),
('Stepan', 'Stepanov', '1988-9-4'),
('Petro', 'Ivanov', '1988-8-5'),
('Pavlo', 'Antonov', '1988-7-6'),
('Petro', 'Ivanov', '1988-6-7'),
('Pavlo', 'Petrov', '1988-5-8'),
('Ivan', 'Antonov', '1988-4-9'),
('Stepan', 'Popov', '1988-3-10'),
('Ivan', 'Ivanov', '1988-2-11'),
('Pavlo', 'Popov', '1988-1-12'),
('Petro', 'Ivanov', '1988-12-13'),
('Ivan', 'Stepanov', '1988-11-14'),
('Stepan', 'Petrov', '1988-10-15');


CREATE TABLE IF NOT EXISTS `Route_has_Bus` (
  `Route_number` INT NOT NULL,
  `Bus_number_sign` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`Route_number`, `Bus_number_sign`),
  CONSTRAINT `fk_Route_has_Bus_Route1`
    FOREIGN KEY (`Route_number`)
    REFERENCES `fixbus_db`.`Route` (`number`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Route_has_Bus_Bus1`
    FOREIGN KEY (`Bus_number_sign`)
    REFERENCES `fixbus_db`.`Bus` (`number_sign`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO `Route_has_Bus` (`Route_number`, `Bus_number_sign`) VALUES
(17, 'BC0001BT'),
(18, 'BC0002BT'),
(19, 'BC0003BT'),
(20, 'BC0004BT'),
(21, 'BC0005BT'),
(22, 'BC0006BT'),
(23, 'BC0007BT'),
(24, 'BC0008BT'),
(25, 'BC0009BT'),
(26, 'BC0010BT'),
(27, 'BC0011BT'),
(28, 'BC0012BT'),
(29, 'BC0013BT'),
(30, 'BC0014BT'),
(31, 'BC0015BT');

CREATE TABLE IF NOT EXISTS `Driver_has_Route` (
  `Driver_id` INT NOT NULL,
  `Route_number` INT NOT NULL,
  PRIMARY KEY (`Driver_id`, `Route_number`),
  CONSTRAINT `fk_Driver_has_Route_Driver1`
    FOREIGN KEY (`Driver_id`)
    REFERENCES `fixbus_db`.`Driver` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Driver_has_Route_Route1`
    FOREIGN KEY (`Route_number`)
    REFERENCES `fixbus_db`.`Route` (`number`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO `Driver_has_Route` (`Driver_id`, `Route_number`) VALUES
(1, 17),
(2, 18),
(3, 19),
(4, 20),
(5, 21),
(6, 19),
(7, 21),
(8, 19),
(9, 18),
(10, 17),
(11, 21),
(12, 18),
(13, 21),
(14, 20),
(15, 21);


CREATE TABLE IF NOT EXISTS `Driver_has_Bus` (
  `Driver_id` INT NOT NULL,
  `Bus_number_sign` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`Driver_id`, `Bus_number_sign`),
  CONSTRAINT `fk_Driver_has_Bus_Driver1`
    FOREIGN KEY (`Driver_id`)
    REFERENCES `fixbus_db`.`Driver` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Driver_has_Bus_Bus1`
    FOREIGN KEY (`Bus_number_sign`)
    REFERENCES `fixbus_db`.`Bus` (`number_sign`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

INSERT INTO Driver_has_Bus (`Driver_id`, `Bus_number_sign`) VALUES
(1, 'BC0001BT'),
(2, 'BC0002BT'),
(3, 'BC0003BT'),
(4, 'BC0004BT'),
(5, 'BC0005BT'),
(6, 'BC0006BT'),
(7, 'BC0007BT'),
(8, 'BC0008BT'),
(9, 'BC0009BT'),
(10, 'BC0010BT'),
(11, 'BC0011BT'),
(12, 'BC0012BT'),
(13, 'BC0013BT'),
(14, 'BC0014BT'),
(15, 'BC0015BT');