--Table ROLES
INSERT INTO `test`.`roles`
(`id`,`description`,`order`,`visible`)
VALUES
(1,'ROLE_ADMIN','1',true);

INSERT INTO `test`.`roles`
(`id`,`description`,`order`,`visible`)
VALUES
(2,'ROLE_USER','2',true);


-- Table USERS
INSERT INTO `test`.`users`
(`id`,`username`,`password`,`enable`,`role`)
VALUES
(1,'test','$2a$10$IIY0OJd24KC23BhXDDyCfOXUrPF6bOwnDafJA6Cflc8vMTVjSY48S',true,1);

--Table CLIENTS
INSERT INTO `test`.`clients`
(`id`,`client_id`,`client_secret`,`scopes`,`resource_ids`,`authorized_grant_types`,`redirect_uri`,`authorities`,`access_token_validity`,`refresh_token_validity`)
VALUES
(1,'six','$2a$10$NzTPjSyWaEzZxcNdyQKTz.bEUD8PQyR5dh3FlYrNlXzmbeTmIvl8C','read,write,trust','','password,authorization_code,refresh_token,implicit','','ROLE_USER','900','900');