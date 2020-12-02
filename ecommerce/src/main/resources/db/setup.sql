drop user if exists 'ecommerce'@'localhost';
create user'ecommerce'@'localhost' identified by 'ecommerce123';
grant all privileges on ecommercedb.* to 'ecommerce'@'localhost';
flush privileges;

drop database if exists ecommercedb;
create database ecommercedb;
