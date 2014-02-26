SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `votemeup` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `votemeup` ;

-- -----------------------------------------------------
-- Table `votemeup`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `surname` VARCHAR(40) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `role` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_user_type1_idx` (`role` ASC),
  CONSTRAINT `fk_user_user_type1`
    FOREIGN KEY (`role`)
    REFERENCES `votemeup`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`attachment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`attachment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url` TEXT NULL,
  `path` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`proposal_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`proposal_category` (
  `id_proposal` INT NOT NULL,
  `id_category` INT NOT NULL,
  PRIMARY KEY (`id_proposal`, `id_category`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`proposal_tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`proposal_tag` (
  `id_proposal` INT NOT NULL,
  `id_tag` INT NOT NULL,
  PRIMARY KEY (`id_proposal`, `id_tag`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`proposal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`proposal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` TEXT NOT NULL,
  `content` TEXT NOT NULL,
  `author` INT NOT NULL,
  `publication_date` DATE NOT NULL,
  `due_date` DATE NOT NULL,
  `attachment` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_proposal_user_idx` (`author` ASC),
  INDEX `fk_proposal_attachment1_idx` (`attachment` ASC),
  CONSTRAINT `fk_proposal_user`
    FOREIGN KEY (`author`)
    REFERENCES `votemeup`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proposal_attachment1`
    FOREIGN KEY (`attachment`)
    REFERENCES `votemeup`.`attachment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proposal_proposal_category1`
    FOREIGN KEY (`id`)
    REFERENCES `votemeup`.`proposal_category` (`id_proposal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proposal_proposal_tag1`
    FOREIGN KEY (`id`)
    REFERENCES `votemeup`.`proposal_tag` (`id_proposal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_category_proposal_category1`
    FOREIGN KEY (`id`)
    REFERENCES `votemeup`.`proposal_category` (`id_category`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`tag` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tag_proposal_tag1`
    FOREIGN KEY (`id`)
    REFERENCES `votemeup`.`proposal_tag` (`id_tag`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `proposal_id` INT NOT NULL,
  `content` TEXT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`, `user_id`, `proposal_id`),
  INDEX `fk_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_comment_proposal1_idx` (`proposal_id` ASC),
  CONSTRAINT `fk_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `votemeup`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_proposal1`
    FOREIGN KEY (`proposal_id`)
    REFERENCES `votemeup`.`proposal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`vote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`vote` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `proposal_id` INT NOT NULL,
  `date` DATE NOT NULL,
  INDEX `fk_vote_user1_idx` (`user_id` ASC),
  INDEX `fk_vote_proposal1_idx` (`proposal_id` ASC),
  PRIMARY KEY (`id`, `user_id`, `proposal_id`),
  CONSTRAINT `fk_vote_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `votemeup`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vote_proposal1`
    FOREIGN KEY (`proposal_id`)
    REFERENCES `votemeup`.`proposal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`document` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `discription` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
