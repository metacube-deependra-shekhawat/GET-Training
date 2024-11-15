-- Creation of state table
CREATE TABLE state(
    name VARCHAR(20) PRIMARY KEY
);

-- Creation of city table
CREATE TABLE city(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    stateName VARCHAR(20) NOT NULL,
    FOREIGN KEY (stateName) REFERENCES state(name)
);

-- Creation of zipcode table
CREATE TABLE zipcode(
    zipcode VARCHAR(30) PRIMARY KEY,
    cityID  int NOT NULL,
    FOREIGN KEY (cityID) REFERENCES city(id)
);

INSERT INTO state VALUES("State 1");
INSERT INTO state VALUES("State 2");
INSERT INTO state VALUES("State 3");
INSERT INTO state VALUES("State 4");
INSERT INTO state VALUES("State 5");
INSERT INTO state VALUES("State 6");

INSERT INTO city(name,stateName) VALUES ("City 1","State 1");
INSERT INTO city(name,stateName) VALUES ("City 2","State 1");
INSERT INTO city(name,stateName) VALUES ("City 3","State 1");
INSERT INTO city(name,stateName) VALUES ("City 1","State 2");
INSERT INTO city(name,stateName) VALUES ("City 2","State 2");
INSERT INTO city(name,stateName) VALUES ("City 1","State 3");
INSERT INTO city(name,stateName) VALUES ("City 2","State 3");
INSERT INTO city(name,stateName) VALUES ("City 3","State 3");
INSERT INTO city(name,stateName) VALUES ("City 1","State 4");
INSERT INTO city(name,stateName) VALUES ("City 2","State 4");
INSERT INTO city(name,stateName) VALUES ("City 1","State 5");
INSERT INTO city(name,stateName) VALUES ("City 2","State 5");
INSERT INTO city(name,stateName) VALUES ("City 3","State 5");
INSERT INTO city(name,stateName) VALUES ("City 4","State 5");
INSERT INTO city(name,stateName) VALUES ("City 1","State 6");
INSERT INTO city(name,stateName) VALUES ("City 2","State 6");
INSERT INTO city(name,stateName) VALUES ("City 3","State 6");

INSERT INTO zipcode VALUES ("100001",1);
INSERT INTO zipcode VALUES ("100002",2);
INSERT INTO zipcode VALUES ("100003",3);
INSERT INTO zipcode VALUES ("100004",4);
INSERT INTO zipcode VALUES ("100005",5);
INSERT INTO zipcode VALUES ("100006",6);
INSERT INTO zipcode VALUES ("100007",7);
INSERT INTO zipcode VALUES ("100008",8);
INSERT INTO zipcode VALUES ("100009",9);
INSERT INTO zipcode VALUES ("100011",10);
INSERT INTO zipcode VALUES ("100012",11);
INSERT INTO zipcode VALUES ("100013",12);
INSERT INTO zipcode VALUES ("100014",13);
INSERT INTO zipcode VALUES ("100015",14);
INSERT INTO zipcode VALUES ("100016",15);
INSERT INTO zipcode VALUES ("100017",16);
INSERT INTO zipcode VALUES ("100018",17);


SELECT z.zipcode as ZipCode, c.name as CityName, s.name as StateName FROM zipcode z
JOIN city c ON c.id = z.cityID
JOIN state s ON s.name = c.stateName
ORDER BY s.name, c.name;