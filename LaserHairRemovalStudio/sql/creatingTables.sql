CREATE TABLE IF NOT EXISTS user (id BIGINT AUTO_INCREMENT,
                    name VARCHAR(20) NOT NULL ,
                    surname VARCHAR(20) NOT NULL,
                    login VARCHAR(20) NOT NULL ,
                    password VARCHAR(20) NOT NULL ,
                    phone_number BIGINT NOT NULL ,
                    role TINYINT NOT NULL,
                    PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS service (id BIGINT AUTO_INCREMENT,
                    zone_name VARCHAR(50) NOT NULL ,
                    price DECIMAL(20) NOT NULL ,
                    PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS appointment (id BIGINT AUTO_INCREMENT,
                   service_id BIGINT NOT NULL ,
                   user_id BIGINT NOT NULL ,
                   date DATE NOT NULL ,
                   time TIME NOT NULL ,
                   PRIMARY KEY (id),
                   FOREIGN KEY (service_id) REFERENCES service(id),
                   FOREIGN KEY (user_id) REFERENCES user(id));
