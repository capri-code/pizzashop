CREATE TABLE IF NOT EXISTS pizza (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    size VARCHAR(100) NOT NULL,
    cheesyCrust BOOLEAN,
    timeToDeliever TIME
);

CREATE TABLE IF NOT EXISTS topping (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    pizzaId INTEGER REFERENCES pizza(id)
);

INSERT INTO pizza (size, cheesyCrust, timeToDeliever) VALUES ('M', TRUE, '12:12');
INSERT INTO pizza (size, cheesyCrust, timeToDeliever) VALUES ('S', FALSE, '13:30');
INSERT INTO pizza (size, cheesyCrust, timeToDeliever) VALUES ('L', FALSE, '16:10');

INSERT INTO topping (name, pizzaId) VALUES ('mushrooms', 1);
INSERT INTO topping (name, pizzaId) VALUES ('ham', 2);
INSERT INTO topping (name, pizzaId) VALUES ('ananas', 3);
