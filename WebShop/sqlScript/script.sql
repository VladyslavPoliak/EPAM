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

create table `order` (
  id         bigint                     NOT NULL AUTO_INCREMENT primary key,
  id_account integer                    NOT NULL references users (id_user)
    ON UPDATE RESTRICT
    ON DELETE CASCADE,
  created    timestamp(0) default now() NOT NULL,
  order_status varchar(25) NOT null,
  status_description varchar(45) NOT null
);

create table order_item (
  id       bigint  NOT NULL AUTO_INCREMENT primary key,
  id_order bigint  NOT NULL references `order` (id)
    ON UPDATE RESTRICT
    ON DELETE CASCADE,
  id_car   int(11) references car (id_car)
    ON UPDATE RESTRICT
    ON DELETE CASCADE,
  days     integer not null
);

insert into car
values (default, 'Santa Fe Special', 'HYUNDAI', 'J', 700, '/img/cars/1.jpg');
insert into car
values (default, 'Sonata', 'HYUNDAI', 'E', 1100, '/img/cars/2.jpg');
 insert into car
values (default, 'Elantra Comfort', 'HYUNDAI', 'C', 900, '/img/cars/3.jpg');
 insert into car
values (default, 'Passat', 'VOLKSWAGEN', 'C', 1000, '/img/cars/4.jpg');
 insert into car
values (default, 'Spark', 'CHEVROLET', 'A', 500, '/img/cars/5.jpg');
 insert into car
 values (default, 'Espace', 'RENAULT', 'C', 1050, '/img/cars/6.jpg');

  insert into car
 values (default, 'Espace', 'RENAULT', 'C', 1050, '/img/cars/6.jpg');
 insert into car
 values (default, 'Prius', 'TOYOTA', 'E', 1500, '/img/cars/1.jpg');
 insert into car
 values (default, 'Prado', 'TOYOTA', 'J', 1400, '/img/cars/2.jpg');
 insert into car
 values (default, 'Venza', 'TOYOTA', 'E', 1200, '/img/cars/3.jpg');
 insert into car
 values (default, 'Auris', 'TOYOTA', 'E', 1300, '/img/cars/4.jpg');
 insert into car
 values (default, 'RAV4', 'TOYOTA', 'J', 1300, '/img/cars/5.jpg');
 insert into car
 values (default, 'Camry', 'TOYOTA', 'J', 1700, '/img/cars/6.jpg');
 insert into car
 values (default, 'GLE 43 AMG 4MATIC Coupe', 'MERCEDES', 'J', 1670, '/img/cars/2.jpg');
 insert into car
 values (default, '5-series X-Drive', 'BMW', 'E', 1550, '/img/cars/1.jpg');
 insert into car
 values (default, 'Captiva', 'CHEVROLET', 'J', 1050, '/img/cars/1.jpg');
 insert into car
 values (default, 'X5 F15 xDrive 25d', 'BMW', 'J', 1350, '/img/cars/2.jpg');
 insert into car
 values (default, 'E-Class', 'MERCEDES', 'E', 1630, '/img/cars/3.jpg');
 insert into car
 values (default, 'CX-7', 'MAZDA', 'C', 870, '/img/cars/3.jpg');
 insert into car
 values (default, '3-series 318D F31', 'BMW', 'E', 1650, '/img/cars/3.jpg');
 insert into car
 values (default, '6', 'MAZDA', 'C', 1070, '/img/cars/3.jpg');
 insert into car
 values (default, 'Lacetti', 'CHEVROLET', 'C', 870, '/img/cars/3.jpg');
 insert into car
 values (default, '5', 'MAZDA', 'C', 1070, '/img/cars/3.jpg');
 insert into car
 values (default, 'Aveo', 'CHEVROLET', 'C', 880, '/img/cars/3.jpg');
 insert into car
 values (default, '3', 'MAZDA', 'E', 1470, '/img/cars/3.jpg');
 insert into car
 values (default, 'CX-7', 'MAZDA', 'C', 870, '/img/cars/3.jpg');
 insert into car
 values (default, 'CX-7', 'FORD', 'C', 870, '/img/cars/3.jpg');



