DROP TABLE people IF EXISTS;
DROP TABLE family IF EXISTS;

CREATE TABLE `people` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `people_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (people_id) REFERENCES family (family_id) ON DELETE CASCADE
);

CREATE TABLE `family` (
  `family_id` INT NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `zip` INT NULL,
  PRIMARY KEY (`id`)
  
);
