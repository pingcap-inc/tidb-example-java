SET sql_safe_updates = FALSE;

USE test;
DROP DATABASE IF EXISTS game;
CREATE DATABASE IF NOT EXISTS game;

USE game;

CREATE TABLE player (
    `id` VARCHAR(36),
    `coins` INTEGER,
    `goods` INTEGER,
	PRIMARY KEY (`id`)
);