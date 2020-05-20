DROP DATABASE IF EXISTS mystore_boot;
CREATE DATABASE mystore_boot;
USE mystore_boot;

DROP TABLE IF EXISTS product;
CREATE TABLE `product` (
  `code` INTEGER NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `inventory` int NOT NULL,
  `price` decimal(5,2) NOT NULL,
  `category` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS user_profile;
CREATE TABLE `user_profile` (
  `id` int AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
id integer auto_increment primary key,
user_id integer not null
);

DROP TABLE IF EXISTS order_details;
CREATE TABLE order_details(
id integer auto_increment primary key,
order_id integer not null,
product_code integer not null,
quantity integer not null
);

DROP TABLE IF EXISTS cart;
CREATE TABLE cart(
id integer auto_increment primary key,
user_id integer not null
);

DROP TABLE IF EXISTS cart_details;
CREATE TABLE cart_details(
id integer auto_increment primary key,
cart_id integer not null,
product_code integer not null,
quantity integer not null
);

DROP TABLE IF EXISTS wishlist;
CREATE TABLE wishlist(
id integer auto_increment primary key,
user_id integer not null,
product_code integer not null
);