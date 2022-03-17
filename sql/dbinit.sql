SET sql_safe_updates = FALSE;

USE mysql;
DROP DATABASE IF EXISTS bank;
CREATE DATABASE IF NOT EXISTS bank;

USE bank;

CREATE TABLE accounts (
    `id` VARCHAR(36),
    `balance` INTEGER,
	PRIMARY KEY (`id`)
);