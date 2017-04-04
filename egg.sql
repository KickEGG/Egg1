CREATE DATABASE `egg` DEFAULT CHARACTER
SET utf8 COLLATE utf8_general_ci;

USE egg;

CREATE TABLE `customer` (
	`id` BIGINT (20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR (255) DEFAULT NULL,
	`contact` VARCHAR (255) DEFAULT NULL,
	`telephone` VARCHAR (255) DEFAULT NULL,
	`email` VARCHAR (255) DEFAULT NULL,
	`remark` text,
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

TRUNCATE customer;

INSERT INTO customer (
	NAME,
	contact,
	telephone,
	email,
	remark
)
VALUES
	(
		'customer1',
		'Jack',
		'13512345678',
		'jack@gmail.com',
		NULL
	);

INSERT INTO customer (
	NAME,
	contact,
	telephone,
	email,
	remark
)
VALUES
	(
		'customer2',
		'Rose',
		'13623456789',
		'rose@gmail.com',
		NULL
	);
