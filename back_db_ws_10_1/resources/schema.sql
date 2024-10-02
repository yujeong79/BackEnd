CREATE TABLE `car` (
	`vin` varchar(45) NOT NULL PRIMARY KEY,
    `modelname` varchar(40) NOT NULL,
    `color` VARCHAR(45) NOT NULL,
    `mileage` int NOT NULL
)ENGINE=InnoDB;


INSERT INTO `car` (vin, modelname, color, mileage)
VALUES 
('KMHXX00XXXX000000', '소나타', 'white', 20000),
('KMHXX00XXXX000001', '아반떼', 'blue', 1000),
('KNHXX00XXXX000000', 'K-5' ,'red', 35000),
('KNHXX00XXXX000001', '쏘렌토','black', 100000),
('1G1ZE5ST1HF199624', '말리부','silver', 5000);