CREATE TABLE IF NOT EXISTS user (id bigint AUTO_INCREMENT,
                    name VARCHAR(20) NOT NULL ,
                    surname VARCHAR(20) NOT NULL,
                    login VARCHAR(20) NOT NULL ,
                    password VARCHAR(20) NOT NULL ,
                    phone_number VARCHAR(20) NOT NULL ,
                    role tinyint NOT NULL,
                    PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS service (id bigint AUTO_INCREMENT,
                    zone_name VARCHAR(50) NOT NULL ,
                    price decimal(20) NOT NULL ,
                    PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS appointment (id bigint AUTO_INCREMENT,
                   service_id bigint NOT NULL ,
                   user_id bigint NOT NULL ,
                   date DATE NOT NULL ,
                   time TIME NOT NULL ,
                   PRIMARY KEY (id),
                   FOREIGN KEY (service_id) REFERENCES service(id),
                   FOREIGN KEY (user_id) REFERENCES user(id));
