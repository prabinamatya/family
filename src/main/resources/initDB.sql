DROP TABLE people IF EXISTS;
DROP TABLE family IF EXISTS;

CREATE TABLE `family` (
  `family_id` int(11) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` int(11) DEFAULT NULL,
  PRIMARY KEY (`family_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `people` (
  `people_id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `family_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`people_id`),
  KEY `family_id_idx` (`family_id`),
  CONSTRAINT `family_id` FOREIGN KEY (`family_id`) REFERENCES `family` (`family_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

