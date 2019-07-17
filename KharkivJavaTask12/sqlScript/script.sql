SET GLOBAL time_zone = '+2:00';
DROP DATABASE IF EXISTS task12db;
CREATE DATABASE task12db;
ALTER DATABASE task12db CHARACTER SET = utf8mb4  COLLATE = utf8mb4_unicode_ci;
USE task12db;

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(25)  NOT NULL,
    sur_name VARCHAR(25)  NOT NULL,
    login VARCHAR(45) UNIQUE NOT NULL,
    password VARCHAR(45) NOT NULL,
    image_url VARCHAR(45) UNIQUE
);

CREATE TABLE car (
    id_car INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    mark VARCHAR(25) NOT NULL,
    class VARCHAR(10) NOT NULL,
    cost INTEGER(11) NOT NULL,
    image VARCHAR(50) NOT NULL
);

INSERT INTO user
VALUES (default, "admin", "admin","admin@gmail.com","123123123","");
insert into car
values (default, 'Santa Fe Special', 'HYUNDAI', 'J', 700,  '/media/1.jpg');
 insert into car
values (default, 'Sonata', 'HYUNDAI', 'E', 1100, '/media/2.jpg');
