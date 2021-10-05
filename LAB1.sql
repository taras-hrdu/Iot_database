-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lab1db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lab1db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab1db` DEFAULT CHARACTER SET utf8 ;
USE `lab1db` ;

-- -----------------------------------------------------
-- Table `lab1db`.`type_of_equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`type_of_equipment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` ENUM("frezer_machine", "3d_printer", "3d_scaner") NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `obj_4_UNIQUE` ON `lab1db`.`type_of_equipment` (`type` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`equipment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `inventory_numbers` VARCHAR(5) NOT NULL,
  `color` VARCHAR(20) NULL,
  `body_material` VARCHAR(45) NULL,
  `condition_of_equipment` VARCHAR(45) NOT NULL,
  `type_of_equipment_id` INT NOT NULL,
  PRIMARY KEY (`id`, `type_of_equipment_id`),
  CONSTRAINT `fk_equipment_type_of_equipment1`
    FOREIGN KEY (`type_of_equipment_id`)
    REFERENCES `lab1db`.`type_of_equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `inventory_numbers_UNIQUE` ON `lab1db`.`equipment` (`inventory_numbers` ASC) VISIBLE;

CREATE INDEX `fk_equipment_type_of_equipment1_idx` ON `lab1db`.`equipment` (`type_of_equipment_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `surname` VARCHAR(30) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `student_number` NVARCHAR(10) NOT NULL,
  `zip` VARCHAR(5) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `surname_UNIQUE` ON `lab1db`.`user` (`surname` ASC) VISIBLE;

CREATE UNIQUE INDEX `student_number_UNIQUE` ON `lab1db`.`user` (`student_number` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`equipment_transfer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`equipment_transfer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL,
  `start_data` DATE NULL,
  `end_data` DATE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `time_UNIQUE` ON `lab1db`.`equipment_transfer` (`time` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`repairs_worker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`repairs_worker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `surname_UNIQUE` ON `lab1db`.`repairs_worker` (`surname` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`repair`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`repair` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time` DATETIME NOT NULL,
  `start_data` DATE NULL,
  `end_data` DATE NULL,
  `repairs_worker_id` INT NULL,
  `equipment_id` INT NULL,
  `repairs_worker_id1` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_repair_repairs_worker1`
    FOREIGN KEY (`repairs_worker_id1`)
    REFERENCES `lab1db`.`repairs_worker` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `time_UNIQUE` ON `lab1db`.`repair` (`time` ASC) VISIBLE;

CREATE INDEX `fk_repair_repairs_worker1_idx` ON `lab1db`.`repair` (`repairs_worker_id1` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`laser_cutter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`laser_cutter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `time_using` DATETIME NOT NULL,
  `start_data` DATE NULL,
  `end_data` DATE NULL,
  `equipment_id` INT NOT NULL,
  PRIMARY KEY (`id`, `equipment_id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `time_using_UNIQUE` ON `lab1db`.`laser_cutter` (`time_using` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`equipment_has_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`equipment_has_users` (
  `equipment_id` INT NOT NULL,
  `users_id` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_equipment_has_users_equipment`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `lab1db`.`equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipment_has_users_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `lab1db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_equipment_has_users_users1_idx` ON `lab1db`.`equipment_has_users` (`users_id` ASC) VISIBLE;

CREATE INDEX `fk_equipment_has_users_equipment_idx` ON `lab1db`.`equipment_has_users` (`equipment_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`equipment_has_equipment_transfer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`equipment_has_equipment_transfer` (
  `equipment_id` INT NOT NULL,
  `equipment_transfer_id` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_equipment_has_equipment_transfer_equipment1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `lab1db`.`equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipment_has_equipment_transfer_equipment_transfer1`
    FOREIGN KEY (`equipment_transfer_id`)
    REFERENCES `lab1db`.`equipment_transfer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_equipment_has_equipment_transfer_equipment_transfer1_idx` ON `lab1db`.`equipment_has_equipment_transfer` (`equipment_transfer_id` ASC) VISIBLE;

CREATE INDEX `fk_equipment_has_equipment_transfer_equipment1_idx` ON `lab1db`.`equipment_has_equipment_transfer` (`equipment_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`equipment_has_repairs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`equipment_has_repairs` (
  `equipment_id` INT NOT NULL,
  `repairs_id` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_equipment_has_repairs_equipment1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `lab1db`.`equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipment_has_repairs_repairs1`
    FOREIGN KEY (`repairs_id`)
    REFERENCES `lab1db`.`repair` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_equipment_has_repairs_repairs1_idx` ON `lab1db`.`equipment_has_repairs` (`repairs_id` ASC) VISIBLE;

CREATE INDEX `fk_equipment_has_repairs_equipment1_idx` ON `lab1db`.`equipment_has_repairs` (`equipment_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`user_has_laser_cutter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`user_has_laser_cutter` (
  `user_id` INT NOT NULL,
  `laser_cutter_id` INT NOT NULL,
  `laser_cutter_equipment_id` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_has_laser_cutter_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `lab1db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_laser_cutter_laser_cutter1`
    FOREIGN KEY (`laser_cutter_id` , `laser_cutter_equipment_id`)
    REFERENCES `lab1db`.`laser_cutter` (`id` , `equipment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_user_has_laser_cutter_laser_cutter1_idx` ON `lab1db`.`user_has_laser_cutter` (`laser_cutter_id` ASC, `laser_cutter_equipment_id` ASC) VISIBLE;

CREATE INDEX `fk_user_has_laser_cutter_user1_idx` ON `lab1db`.`user_has_laser_cutter` (`user_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `lab1db`.`laser_cutter_has_repair`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab1db`.`laser_cutter_has_repair` (
  `laser_cutter_id` INT NOT NULL,
  `laser_cutter_equipment_id` INT NOT NULL,
  `repair_id` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_laser_cutter_has_repair_laser_cutter1`
    FOREIGN KEY (`laser_cutter_id` , `laser_cutter_equipment_id`)
    REFERENCES `lab1db`.`laser_cutter` (`id` , `equipment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_laser_cutter_has_repair_repair1`
    FOREIGN KEY (`repair_id`)
    REFERENCES `lab1db`.`repair` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_laser_cutter_has_repair_repair1_idx` ON `lab1db`.`laser_cutter_has_repair` (`repair_id` ASC) VISIBLE;

CREATE INDEX `fk_laser_cutter_has_repair_laser_cutter1_idx` ON `lab1db`.`laser_cutter_has_repair` (`laser_cutter_id` ASC, `laser_cutter_equipment_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
