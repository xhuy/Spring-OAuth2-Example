CREATE TABLE `test`.`roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) NOT NULL,
  `order` int(3) NOT NULL,
  `visible` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`,`description`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `test`.`users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(70) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`,`username`),
  KEY `IX_USERNAME` (`username`),
  CONSTRAINT `FK_USERS_ROLES`
  FOREIGN KEY (`role`)
  REFERENCES `test`.`roles`(`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `test`.`clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(45) NOT NULL,
  `client_secret` varchar(70) NOT NULL,
  `scopes` varchar(70) NOT NULL,
  `resource_ids` varchar(70) NOT NULL,
  `authorized_grant_types` varchar(70) NOT NULL,
  `redirect_uri` varchar(70) NOT NULL,
  `authorities` varchar(70) NOT NULL,
  `access_token_validity` varchar(70) NOT NULL,
  `refresh_token_validity` varchar(70) NOT NULL,
  PRIMARY KEY (`id`,`client_id`),
  KEY `IX_USERNAME` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE TABLE `test`.`oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `test`.`oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `test`.`oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;