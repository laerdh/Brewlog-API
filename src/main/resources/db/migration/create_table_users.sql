CREATE SCHEMA brewlog;
USE brewlog;

CREATE TABLE users
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(80) NOT NULL,
  last_name VARCHAR(80) NOT NULL,
  initials VARCHAR(5),
  email VARCHAR(120) NOT NULL
);