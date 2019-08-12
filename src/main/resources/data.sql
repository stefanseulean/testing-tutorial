DROP TABLE IF EXISTS blueprint;

CREATE TABLE blueprint (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              name VARCHAR(250) NOT NULL,
                              uuid VARCHAR(250) NOT NULL

);

INSERT INTO blueprint (name,uuid) VALUES
('First UUID','d5d5523c-bc82-11e9-9cb5-2a2ae2dbcce4');
