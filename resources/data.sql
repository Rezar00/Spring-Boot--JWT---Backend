DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_role;

CREATE TABLE user
(
    id         NUMBER AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    username   VARCHAR(250) DEFAULT NULL,
    password   VARCHAR(512) DEFAULT NULL
);

CREATE TABLE user_role
(
    id    NUMBER AUTO_INCREMENT PRIMARY KEY,
    user_id NUMBER,
    title VARCHAR(250) NOT NULL,
    role  VARCHAR(250) NOT NULL,
);
