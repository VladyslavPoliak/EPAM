SET GLOBAL time_zone = '+2:00';
DROP DATABASE IF EXISTS task12db;
CREATE DATABASE task12db;
ALTER DATABASE task12db CHARACTER SET = utf8mb4  COLLATE = utf8mb4_unicode_ci;
USE task12db;

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(25)  NOT NULL,
    sur_name VARCHAR(25)  NOT NULL,
    login VARCHAR(25) UNIQUE NOT NULL,
    password VARCHAR(45) NOT NULL

);

INSERT INTO user
VALUES (default, "admin", "admin","admin@gmail.com","123123123");
INSERT INTO user
VALUES (default, "user2", "user2", "user2@gmail.com","123123123");
INSERT INTO user
VALUES (default, "user1","user1", "user1@gmail.com","123123123" );

SELECT * FROM user;