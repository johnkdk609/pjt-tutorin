-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `nickname` VARCHAR(20) NOT NULL,
  `phone_num` VARCHAR(11) NOT NULL,
  `image` BLOB NULL,
  `mentee_intro` TEXT NULL,
  `status` ENUM('1', '2') NULL DEFAULT '1',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`mentor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`mentor` (
  `id` VARCHAR(20) NOT NULL,
  `status` ENUM('1', '2') NOT NULL DEFAULT '1',
  `mentor_intro` TEXT NULL,
  `account_num` BIGINT NOT NULL,
  `account_fee` INT NOT NULL,
  `review_num` INT NULL DEFAULT 0,
  `review_grade` FLOAT NULL DEFAULT 0,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mentor_user_idx` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_mentor_user`
    FOREIGN KEY (`id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`counsel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`counsel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mentee_id` VARCHAR(20) NOT NULL,
  `mentor_id` VARCHAR(20) NOT NULL,
  `status` INT NOT NULL DEFAULT 0,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `video` VARCHAR(200) NULL,
  `answer_content` TEXT NULL,
  `answer_video` VARCHAR(200) NULL,
  `question1` TEXT(200) NULL,
  `answer1` TEXT(200) NULL,
  `question2` TEXT(200) NULL,
  `answer2` TEXT(200) NULL,
  `question3` TEXT(200) NULL,
  `answer3` TEXT(200) NULL,
  `review_star` INT NULL,
  `review_content` TEXT(50) NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  `accept_time` TIMESTAMP NULL,
  `answer_time` TIMESTAMP NULL,
  `feedback_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`, `mentee_id`, `mentor_id`),
  INDEX `fk_counsel_user1_idx` (`mentor_id` ASC) VISIBLE,
  INDEX `fk_counsel_user2_idx` (`mentee_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_counsel_user1`
    FOREIGN KEY (`mentor_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_counsel_user2`
    FOREIGN KEY (`mentee_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mentor_id` VARCHAR(20) NOT NULL,
  `view_cnt` VARCHAR(45) NOT NULL DEFAULT 0,
  `good_cnt` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `link` VARCHAR(200) NOT NULL,
  `content` VARCHAR(45) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`, `mentor_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_video_mentor1_idx` (`mentor_id` ASC) VISIBLE,
  CONSTRAINT `fk_video_mentor1`
    FOREIGN KEY (`mentor_id`)
    REFERENCES `mydb`.`mentor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
