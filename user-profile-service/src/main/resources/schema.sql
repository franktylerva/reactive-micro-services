CREATE TABLE USER_PROFILE (
  id INTEGER NOT NULL AUTO_INCREMENT,
  username VARCHAR(128) NOT NULL,
  email VARCHAR(128) NOT NULL,
  birth_date DATE,
  PRIMARY KEY (id)
);