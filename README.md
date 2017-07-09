"# SpringDemoAdmin" 

----Database:
Authentication
CREATE TABLE `user` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `email` varchar(255) NOT NULL,
 `password` varchar(60) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `role` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(255) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `user_role` (
 `user_id` int(11) NOT NULL,
 `role_id` int(11) NOT NULL,
 PRIMARY KEY (`user_id`,`role_id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8

data
CREATE TABLE `contact` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(50) NOT NULL,
 `email` varchar(50) NULL,
 `phone` varchar(20) NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

