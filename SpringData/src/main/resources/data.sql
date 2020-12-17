DROP TABLE IF EXISTS car;

CREATE TABLE car (
                     id INT AUTO_INCREMENT  PRIMARY KEY,
                     car_number VARCHAR(250) NOT NULL,
                     model VARCHAR(250) NOT NULL
);
INSERT INTO car (car_number, model) VALUES
('A111AA', 'BWM'),
('O343OH', 'TOYOTA'),
('A001MP', 'MERCEDES'),
('C896HA', 'LADA'),
('K098PO', 'BMW');
