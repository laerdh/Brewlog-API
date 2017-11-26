USE brewlog;

CREATE TABLE beers
(
  batch_number BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80) NOT NULL,
  type VARCHAR(80) NOT NULL,
  size DOUBLE NOT NULL,
  volume_remaining DOUBLE NOT NULL,
  original_gravity DOUBLE NOT NULL,
  final_gravity DOUBLE,
  alcohol DOUBLE,
  date DATETIME NOT NULL,
  brewer INT NOT NULL,
  comment VARCHAR(500),
  CONSTRAINT FK_Brewer_UserId FOREIGN KEY (brewer) REFERENCES users(id)
);