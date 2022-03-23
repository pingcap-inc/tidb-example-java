SET sql_safe_updates = FALSE;

USE test;
DROP TABLE IF EXISTS player;

CREATE TABLE player (
    `id` VARCHAR(36),
    `coins` INTEGER,
    `goods` INTEGER,
	PRIMARY KEY (`id`)
);