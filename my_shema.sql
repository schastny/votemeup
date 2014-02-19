SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';



CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

USE `mydb` ;



-- -----------------------------------------------------

-- Table `mydb`.`Role`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Role` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `name` VARCHAR(45) NULL ,

  PRIMARY KEY (`id`) ,

  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`User`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`User` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `FirstName` VARCHAR(45) NOT NULL ,

  `LastName` VARCHAR(45) NOT NULL ,

  `login` VARCHAR(45) NOT NULL ,

  `password` VARCHAR(45) NOT NULL ,

  `email` VARCHAR(45) NOT NULL ,

  `Role_id` INT NOT NULL ,

  PRIMARY KEY (`id`) ,

  UNIQUE INDEX `Login_UNIQUE` (`login` ASC) ,

  UNIQUE INDEX `password_UNIQUE` (`password` ASC) ,

  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,

  INDEX `fk_User_Role1` (`Role_id` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`Proposal`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Proposal` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `Title` VARCHAR(100) NOT NULL ,

  `Date` DATE NOT NULL ,

  `Improvment` VARCHAR(100) NOT NULL ,

  `Author` INT NOT NULL ,

  PRIMARY KEY (`id`) ,

  UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,

  INDEX `fk_Proposal_User1` (`Author` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`Category`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Category` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `init_category` VARCHAR(100) NOT NULL ,

  PRIMARY KEY (`id`) ,

  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`Proposal_Category`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Proposal_Category` (

  `Proposal_id` INT NOT NULL ,

  `Category_id` INT NOT NULL ,

  INDEX `fk_Proposal_Category_Proposal1` (`Proposal_id` ASC) ,

  INDEX `fk_Proposal_Category_Category1` (`Category_id` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`Attachment`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Attachment` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `kind` VARCHAR(45) NOT NULL ,

  `Proposal_id` INT NOT NULL ,

  PRIMARY KEY (`id`) ,

  INDEX `fk_Attachment_Proposal1` (`Proposal_id` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`Comments`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Comments` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `comment` VARCHAR(100) NOT NULL ,

  `Proposal_id` INT NOT NULL ,

  `User_id` INT NOT NULL ,

  PRIMARY KEY (`id`) ,

  INDEX `fk_Comments_Proposal` (`Proposal_id` ASC) ,

  INDEX `fk_Comments_User1` (`User_id` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`Vote`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Vote` (

  `Proposal_id` INT NOT NULL ,

  `User_id` INT NOT NULL ,

  INDEX `fk_Vote_Proposal1` (`Proposal_id` ASC) ,

  INDEX `fk_Vote_User1` (`User_id` ASC) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `mydb`.`Provement`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `mydb`.`Provement` (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `name` VARCHAR(45) NOT NULL ,

  `Role_id` INT NOT NULL ,

  PRIMARY KEY (`id`, `Role_id`) ,

  INDEX `fk_Provement_Role1` (`Role_id` ASC) )

ENGINE = InnoDB;







SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;