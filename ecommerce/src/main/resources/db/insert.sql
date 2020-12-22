SET FOREIGN_KEY_CHECKS = 0;

truncate table pet;
truncate table store;

INSERT into `user`(`id`, `firstName`, `lastName`, `password`)
VALUES(2, 'theHub', 'Sabo', 'somePassword'),
(3, 'thePlace', 'Abuja', 'password'),
(4, 'semicolon', 'Yaba', 'blablabla'),
(5, 'pets', 'VI', 'myname');