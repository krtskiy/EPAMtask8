DROP DATABASE practice8db;

CREATE DATABASE practice8db;

USE practice8db;

CREATE TABLE users
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(10) UNIQUE NOT NULL
);

CREATE TABLE teams
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10) UNIQUE NOT NULL
);

CREATE TABLE users_teams
(
    user_id INTEGER REFERENCES users (id),
    team_id INTEGER REFERENCES teams (id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, team_id)
);

INSERT INTO users
VALUES (DEFAULT, 'ivanov');

INSERT INTO teams
VALUES (DEFAULT, 'teamA');

SELECT u.login, ' in ', g.name
FROM users_teams ug
         JOIN users u ON ug.user_id = u.id
         JOIN teams g ON ug.team_id = g.id;

