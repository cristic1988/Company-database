

CREATE TABLE IF NOT EXISTS employees
( id INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(256) NOT NULL,
  age INTEGER NOT NULL,
  position VARCHAR(128) NOT NULL,
  salary DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (id)
);