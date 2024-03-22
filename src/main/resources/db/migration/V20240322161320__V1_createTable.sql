CREATE TABLE new_table (
  `task_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(225) NULL,
  `deadline` DATE NULL,
  `is_done` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`task_id`),
  UNIQUE INDEX `task_id_UNIQUE` (`task_id` ASC) VISIBLE);