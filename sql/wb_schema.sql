SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `votemeup` ;
CREATE SCHEMA IF NOT EXISTS `votemeup` CHARACTER SET utf8;
USE `votemeup` ;

-- -----------------------------------------------------
-- Table `votemeup`.`proposal_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`proposal_status` (
  `proposal_status_id` BIGINT NOT NULL AUTO_INCREMENT,
  `proposal_status` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`proposal_status_id`));


-- -----------------------------------------------------
-- Table `votemeup`.`proposal_level`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`proposal_level` (
  `proposal_level_id` BIGINT NOT NULL AUTO_INCREMENT,
  `proposal_level` VARCHAR(250) NULL DEFAULT NULL,
  `vote_period` TIME NULL,
  PRIMARY KEY (`proposal_level_id`));


-- -----------------------------------------------------
-- Table `votemeup`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`role` (
  `role_id` BIGINT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(20) NULL DEFAULT NULL,
  `role_description` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`));


-- -----------------------------------------------------
-- Table `votemeup`.`user_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`user_status` (
  `user_status_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_status` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`user_status_id`));


-- -----------------------------------------------------
-- Table `votemeup`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`country` (
  `country_id` BIGINT NOT NULL AUTO_INCREMENT,
  `country_name` VARCHAR(255) NULL,
  PRIMARY KEY (`country_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`region` (
  `region_id` BIGINT NOT NULL AUTO_INCREMENT,
  `region_name` VARCHAR(45) NULL,
  `country_id` BIGINT NOT NULL,
  PRIMARY KEY (`region_id`),
  INDEX `fk_region_country1_idx` (`country_id` ASC),
  CONSTRAINT `fk_region_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `votemeup`.`country` (`country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`city` (
  `city_id` BIGINT NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(45) NULL,
  `region_id` BIGINT NOT NULL,
  PRIMARY KEY (`city_id`),
  INDEX `fk_city_region1_idx` (`region_id` ASC),
  CONSTRAINT `fk_city_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `votemeup`.`region` (`region_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`district`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`district` (
  `district_id` BIGINT NOT NULL AUTO_INCREMENT,
  `district_name` VARCHAR(255) NOT NULL,
  `city_id` BIGINT NOT NULL,
  PRIMARY KEY (`district_id`),
  INDEX `fk_district_city1_idx` (`city_id` ASC),
  CONSTRAINT `fk_district_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `votemeup`.`city` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `votemeup`.`userd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`userd` (
  `userd_id` BIGINT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(50) NULL DEFAULT NULL,
  `last_name` VARCHAR(50) NULL DEFAULT NULL,
  `birth_year` INT NULL DEFAULT NULL,
  `sex` VARCHAR(50) NULL DEFAULT NULL,
  `registration_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email` VARCHAR(250) NULL DEFAULT NULL,
  `user_login` VARCHAR(20) NULL DEFAULT NULL UNIQUE,
  `user_password` VARCHAR(255) NULL DEFAULT NULL,
  `user_status_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
  `country_id` BIGINT NOT NULL,
  `region_id` BIGINT NOT NULL,
  `city_id` BIGINT NOT NULL,
  `district_id` BIGINT NOT NULL,
  PRIMARY KEY (`userd_id`),
  INDEX `fk_userd_role1_idx` (`role_id` ASC),
  INDEX `fk_userd_user_status1_idx` (`user_status_id` ASC),
  INDEX `fk_userd_country1_idx` (`country_id` ASC),
  INDEX `fk_userd_region1_idx` (`region_id` ASC),
  INDEX `fk_userd_city1_idx` (`city_id` ASC),
  INDEX `fk_userd_district1_idx` (`district_id` ASC),
  CONSTRAINT `fk_userd_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `votemeup`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userd_user_status1`
    FOREIGN KEY (`user_status_id`)
    REFERENCES `votemeup`.`user_status` (`user_status_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userd_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `votemeup`.`country` (`country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userd_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `votemeup`.`region` (`region_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userd_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `votemeup`.`city` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_userd_district1`
    FOREIGN KEY (`district_id`)
    REFERENCES `votemeup`.`district` (`district_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `votemeup`.`proposal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`proposal` (
  `proposal_id` BIGINT NOT NULL AUTO_INCREMENT,
  `proposal_name` TEXT NULL DEFAULT NULL,
  `proposal_text` TEXT NULL DEFAULT NULL,
  `proposal_result` TEXT NULL DEFAULT NULL,
  `creation_date` DATETIME NULL DEFAULT NULL,
  `required_votes` BIGINT NULL DEFAULT NULL,
  `proposal_status_id` BIGINT NOT NULL,
  `proposal_level_id` BIGINT NOT NULL,
  `userd_id` BIGINT NOT NULL,
  `country_id` BIGINT NULL DEFAULT NULL,
  `region_id` BIGINT NULL DEFAULT NULL,
  `city_id` BIGINT NULL DEFAULT NULL,
  `district_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`proposal_id`),
  INDEX `fk_proposal_proposal_status1_idx` (`proposal_status_id` ASC),
  INDEX `fk_proposal_proposal_level1_idx` (`proposal_level_id` ASC),
  INDEX `fk_proposal_userd1_idx` (`userd_id` ASC),
  INDEX `fk_proposal_country1_idx` (`country_id` ASC),
  INDEX `fk_proposal_region1_idx` (`region_id` ASC),
  INDEX `fk_proposal_city1_idx` (`city_id` ASC),
  INDEX `fk_proposal_district1_idx` (`district_id` ASC),
  CONSTRAINT `fk_proposal_proposal_status1`
    FOREIGN KEY (`proposal_status_id`)
    REFERENCES `votemeup`.`proposal_status` (`proposal_status_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proposal_proposal_level1`
    FOREIGN KEY (`proposal_level_id`)
    REFERENCES `votemeup`.`proposal_level` (`proposal_level_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proposal_userd1`
    FOREIGN KEY (`userd_id`)
    REFERENCES `votemeup`.`userd` (`userd_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proposal_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `votemeup`.`country` (`country_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proposal_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `votemeup`.`region` (`region_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proposal_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `votemeup`.`city` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proposal_district1`
    FOREIGN KEY (`district_id`)
    REFERENCES `votemeup`.`district` (`district_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `votemeup`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`category` (
  `category_id` BIGINT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`));


-- -----------------------------------------------------
-- Table `votemeup`.`document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`document` (
  `doc_id` BIGINT NOT NULL AUTO_INCREMENT,
  `doc_name` VARCHAR(250) NULL DEFAULT NULL,
  `doc_url` TEXT NULL DEFAULT NULL,
  `proposal_id` BIGINT NULL,
  PRIMARY KEY (`doc_id`),
  INDEX `fk_document_proposal1_idx` (`proposal_id` ASC),
  CONSTRAINT `fk_document_proposal1`
    FOREIGN KEY (`proposal_id`)
    REFERENCES `votemeup`.`proposal` (`proposal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `votemeup`.`vote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`vote` (
  `vote_id` BIGINT NOT NULL AUTO_INCREMENT,
  `userd_id` BIGINT NOT NULL,
  `proposal_id` BIGINT NOT NULL,
  `vote` BOOL NULL,
  `vote_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`vote_id`),
  INDEX `fk_vote_userd1_idx` (`userd_id` ASC),
  INDEX `fk_vote_proposal1_idx` (`proposal_id` ASC),
  CONSTRAINT `fk_vote_userd1`
    FOREIGN KEY (`userd_id`)
    REFERENCES `votemeup`.`userd` (`userd_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vote_proposal1`
    FOREIGN KEY (`proposal_id`)
    REFERENCES `votemeup`.`proposal` (`proposal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `votemeup`.`commentd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`commentd` (
  `comment_id` BIGINT NOT NULL AUTO_INCREMENT,
  `userd_id` BIGINT NULL,
  `proposal_id` BIGINT NULL DEFAULT NULL,
  `comment_text` TEXT NULL DEFAULT NULL,
  `comment_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `fk_commentd_userd1_idx` (`userd_id` ASC),
  INDEX `fk_commentd_proposal1_idx` (`proposal_id` ASC),
  CONSTRAINT `fk_commentd_userd1`
    FOREIGN KEY (`userd_id`)
    REFERENCES `votemeup`.`userd` (`userd_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_commentd_proposal1`
    FOREIGN KEY (`proposal_id`)
    REFERENCES `votemeup`.`proposal` (`proposal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `votemeup`.`proposal_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `votemeup`.`proposal_category` (
  `proposal_proposal_id` BIGINT NOT NULL,
  `category_category_id` BIGINT NOT NULL,
  PRIMARY KEY (`proposal_proposal_id`, `category_category_id`),
  INDEX `fk_proposal_has_category_category1_idx` (`category_category_id` ASC),
  INDEX `fk_proposal_has_category_proposal1_idx` (`proposal_proposal_id` ASC),
  CONSTRAINT `fk_proposal_has_category_proposal1`
    FOREIGN KEY (`proposal_proposal_id`)
    REFERENCES `votemeup`.`proposal` (`proposal_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proposal_has_category_category1`
    FOREIGN KEY (`category_category_id`)
    REFERENCES `votemeup`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;