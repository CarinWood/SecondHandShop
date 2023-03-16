CREATE TABLE Cathegory(
ID Long AUTO_INCREMENT PRIMARY KEY,
name varchar
);

CREATE TABLE Product(
ID Long AUTO_INCREMENT Primary Key,
name varchar, price int, image VARCHAR,
description VARCHAR, cathegory_id REFERENCES Cathegory(ID)
);


CREATE TABLE ProductCat (
ID BIGINT AUTO_INCREMENT PRIMARY KEY,
cathegory_id BIGINT NOT NULL,
product_id Long NOT NULL
);

ALTER TABLE ProductCat ADD FOREIGN KEY (cathegory_id) REFERENCES Cathegory(ID);
ALTER TABLE ProductCat ADD FOREIGN KEY (product_id) REFERENCES Product(ID);
