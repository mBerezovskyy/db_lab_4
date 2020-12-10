DROP DATABASE `fixbus_db`;
CREATE DATABASE IF NOT EXISTS `fixbus_db`;
USE `fixbus_db`;

CREATE TABLE IF NOT EXISTS `fixbus_db`.`manufacturer`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(30) NOT NULL,
    `phone_number`  VARCHAR(13) NOT NULL,
    `office_adress` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

INSERT INTO `Manufacturer` (`name`, `phone_number`, `office_adress`)
VALUES ('Man', '+380679877411', 'vul. Shevchenka 20a'),
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

CREATE TABLE IF NOT EXISTS `fixbus_db`.`bus`
(
    `id`              INT        NOT NULL AUTO_INCREMENT,
    `number_sign`     VARCHAR(8) NOT NULL,
    `age`             INT        NOT NULL,
    `capacity`        INT        NOT NULL,
    `mileage`         INT        NOT NULL,
    `manufacturer_id` INT        NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `number_sign` (`number_sign` ASC) VISIBLE,
    INDEX `fk_bus_manufacturer1_idx` (`manufacturer_id` ASC) VISIBLE,
    CONSTRAINT `fk_bus_manufacturer1`
        FOREIGN KEY (`manufacturer_id`)
            REFERENCES `fixbus_db`.`manufacturer` (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

INSERT INTO `bus` (`number_sign`, `age`, `capacity`, `mileage`, `manufacturer_id`)
VALUES ('BC0001BT', 15, 40, 14, 1),
       ('BC0002BT', 14, 35, 13, 2),
       ('BC0003BT', 13, 40, 12, 3),
       ('BC0004BT', 12, 35, 11, 4),
       ('BC0005BT', 11, 30, 10, 5),
       ('BC0006BT', 10, 35, 9, 6),
       ('BC0007BT', 9, 40, 8, 7),
       ('BC0008BT', 8, 40, 7, 8),
       ('BC0009BT', 7, 35, 6, 9),
       ('BC0010BT', 6, 40, 5, 10),
       ('BC0011BT', 5, 40, 4, 11),
       ('BC0012BT', 4, 35, 3, 12),
       ('BC0013BT', 3, 35, 2, 13),
       ('BC0014BT', 2, 30, 1, 14),
       ('BC0015BT', 1, 30, 0, 15);

CREATE TABLE IF NOT EXISTS `fixbus_db`.`driver`
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(45) NOT NULL,
    `surname` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;

INSERT INTO `driver` (`name`, `surname`)
VALUES ('Petro', 'Popov'),
       ('Stepan', 'Petrov'),
       ('Ivan', 'Popov',),
       ('Stepan', 'Stepanov'),
       ('Petro', 'Ivanov'),
       ('Pavlo', 'Antonov'),
       ('Petro', 'Ivanov'),
       ('Pavlo', 'Petrov'),
       ('Ivan', 'Antonov'),
       ('Stepan', 'Popov'),
       ('Ivan', 'Ivanov'),
       ('Pavlo', 'Popov'),
       ('Petro', 'Ivanov'),
       ('Ivan', 'Stepanov'),
       ('Stepan', 'Petrov');

CREATE TABLE IF NOT EXISTS `fixbus_db`.`driver_has_bus`
(
    `id`        INT NOT NULL AUTO_INCREMENT,
    `driver_id` INT NOT NULL,
    `bus_id`    INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_driver_has_bus_bus1_idx` (`bus_id` ASC) VISIBLE,
    INDEX `fk_driver_has_bus_driver1_idx` (`driver_id` ASC) VISIBLE,
    CONSTRAINT `fk_driver_has_bus_bus1`
        FOREIGN KEY (`bus_id`)
            REFERENCES `fixbus_db`.`bus` (`id`),
    CONSTRAINT `fk_driver_has_bus_driver1`
        FOREIGN KEY (`driver_id`)
            REFERENCES `fixbus_db`.`driver` (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


INSERT INTO driver_has_bus (`driver_id`, `bus_id`)
VALUES (1, 15),
       (2, 14),
       (3, 13),
       (4, 12),
       (5, 11),
       (6, 10),
       (7, 9),
       (8, 8),
       (9, 7),
       (10, 6),
       (11, 5),
       (12, 4),
       (13, 3),
       (14, 2),
       (15, 1);

CREATE TABLE IF NOT EXISTS `fixbus_db`.`stop`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `district`      VARCHAR(45) NOT NULL,
    `street_name`   VARCHAR(45) NOT NULL,
    `street_number` VARCHAR(4)  NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


INSERT INTO `Stop` (`district`, `street_name`, `street_number`)
VALUES ('Lychakivskyi', 'Lysenka', '12'),
       ('Shevchenkivskyi', 'Shevchenka', '356a'),
       ('Zaliznychnyj', 'Lublinska', '10b'),
       ('Sykhiv', 'Drahana', '117'),
       ('Tsentr', 'Doroshenka', '50'),
       ('Lychakivskyi', 'Lisna', '5a'),
       ('Shevchenkivskyi', 'Riasnenska', '87'),
       ('Zaliznychnyj', 'Levandivska', '3c'),
       ('Levandivka', 'Siajvo', '22'),
       ('Shevchenkivskyi', 'Zamarstynivska', '67'),
       ('Sykhiv', 'Chervonoyi Kalyny', '132'),
       ('Lychakivskyi', 'Dzhordzha Vashyngtona', '21'),
       ('Lychakivskyi', 'Pasichna', '2'),
       ('Sykhiv', 'Dovzhenka', '45b'),
       ('Shevchenkivskyi', 'Zavodska', '12a');


CREATE TABLE IF NOT EXISTS `fixbus_db`.`route`
(
    `id`               INT NOT NULL AUTO_INCREMENT,
    `total_fare`       INT NOT NULL,
    `starting_stop_id` INT NOT NULL,
    `end_stop_id`      INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_Route_Stop1` (`starting_stop_id` ASC) VISIBLE,
    INDEX `fk_Route_Stop2` (`end_stop_id` ASC) VISIBLE,
    INDEX `number` (`id` ASC) VISIBLE,
    CONSTRAINT `fk_Route_Stop1`
        FOREIGN KEY (`starting_stop_id`)
            REFERENCES `fixbus_db`.`stop` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `fk_Route_Stop2`
        FOREIGN KEY (`end_stop_id`)
            REFERENCES `fixbus_db`.`stop` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


INSERT INTO `Route` (`total_fare`, `starting_stop_id`, `end_stop_id`)
VALUES (7, 1, 2),
       (5, 2, 3),
       (10, 3, 4),
       (7, 4, 5),
       (10, 5, 6),
       (7, 6, 7),
       (5, 7, 8),
       (7, 8, 9),
       (10, 9, 10),
       (7, 10, 11),
       (5, 11, 12),
       (7, 12, 13),
       (10, 13, 14),
       (5, 14, 15),
       (7, 1, 3);



CREATE TABLE IF NOT EXISTS `fixbus_db`.`driver_has_route`
(
    `id`        INT NOT NULL AUTO_INCREMENT,
    `Driver_id` INT NOT NULL,
    `Route_id`  INT NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_Driver_has_Route_Route1` (`Route_id` ASC) VISIBLE,
    INDEX `fk_Driver_has_Route_Driver1` (`Driver_id` ASC) VISIBLE,
    CONSTRAINT `fk_Driver_has_Route_Driver1`
        FOREIGN KEY (`Driver_id`)
            REFERENCES `fixbus_db`.`driver` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `fk_Driver_has_Route_Route1`
        FOREIGN KEY (`Route_id`)
            REFERENCES `fixbus_db`.`route` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 1;


INSERT INTO `driver_has_route` (`Driver_id`, `Route_id`)
VALUES (1, 17),
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

