USE test;
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS auto_player;

CREATE TABLE player (
    `id` VARCHAR(36),
    `coins` INTEGER,
    `goods` INTEGER,
	PRIMARY KEY (`id`)
);

CREATE TABLE auto_player (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `coins` INTEGER,
    `goods` INTEGER
);