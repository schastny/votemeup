SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `SSvotemeup` ;
CREATE SCHEMA IF NOT EXISTS `SSvotemeup` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `SSvotemeup` ;

-- -----------------------------------------------------
-- Table `SSvotemeup`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSvotemeup`.`Users` ;

CREATE TABLE IF NOT EXISTS `SSvotemeup`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Login` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `DateBirthday` DATE NOT NULL,
  `Male` ENUM('male','female') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC),
  UNIQUE INDEX `Password_UNIQUE` (`Password` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSvotemeup`.`Level_Proposal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSvotemeup`.`Level_Proposal` ;

CREATE TABLE IF NOT EXISTS `SSvotemeup`.`Level_Proposal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Level` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idLevel_Proposal_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSvotemeup`.`Proposal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSvotemeup`.`Proposal` ;

CREATE TABLE IF NOT EXISTS `SSvotemeup`.`Proposal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(100) NOT NULL,
  `Description` VARCHAR(500) NOT NULL,
  `Improvement` VARCHAR(100) NOT NULL,
  `DataProposal` DATE NOT NULL,
  `Users_id` INT NOT NULL,
  `Level_Proposal_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idProposal_UNIQUE` (`id` ASC),
  INDEX `fk_Proposal_Users1_idx` (`Users_id` ASC),
  INDEX `fk_Proposal_Level_Proposal1_idx` (`Level_Proposal_id` ASC),
  CONSTRAINT `fk_Proposal_Users1`
    FOREIGN KEY (`Users_id`)
    REFERENCES `SSvotemeup`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_Level_Proposal1`
    FOREIGN KEY (`Level_Proposal_id`)
    REFERENCES `SSvotemeup`.`Level_Proposal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSvotemeup`.`Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSvotemeup`.`Category` ;

CREATE TABLE IF NOT EXISTS `SSvotemeup`.`Category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Category` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSvotemeup`.`Vote`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSvotemeup`.`Vote` ;

CREATE TABLE IF NOT EXISTS `SSvotemeup`.`Vote` (
  `Users_id` INT NOT NULL,
  `Proposal_id` INT NOT NULL,
  `Comment` VARCHAR(100) NULL COMMENT 'Таблица для хранения голосов Пользователей за существующие Предложения',
  PRIMARY KEY (`Users_id`, `Proposal_id`),
  INDEX `fk_Vote_Users1_idx` (`Users_id` ASC),
  INDEX `fk_Vote_Proposal1_idx` (`Proposal_id` ASC),
  CONSTRAINT `fk_Vote_Users1`
    FOREIGN KEY (`Users_id`)
    REFERENCES `SSvotemeup`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vote_Proposal1`
    FOREIGN KEY (`Proposal_id`)
    REFERENCES `SSvotemeup`.`Proposal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSvotemeup`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSvotemeup`.`Roles` ;

CREATE TABLE IF NOT EXISTS `SSvotemeup`.`Roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSvotemeup`.`Attachments`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSvotemeup`.`Attachments` ;

CREATE TABLE IF NOT EXISTS `SSvotemeup`.`Attachments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `URL` VARCHAR(100) NOT NULL,
  `Proposal_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Attachments_Proposal1_idx` (`Proposal_id` ASC),
  CONSTRAINT `fk_Attachments_Proposal1`
    FOREIGN KEY (`Proposal_id`)
    REFERENCES `SSvotemeup`.`Proposal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSvotemeup`.`Users_has_Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSvotemeup`.`Users_has_Roles` ;

CREATE TABLE IF NOT EXISTS `SSvotemeup`.`Users_has_Roles` (
  `Users_id` INT NOT NULL,
  `Roles_id` INT NOT NULL,
  PRIMARY KEY (`Users_id`, `Roles_id`),
  INDEX `fk_Users_has_Roles_Roles1_idx` (`Roles_id` ASC),
  INDEX `fk_Users_has_Roles_Users1_idx` (`Users_id` ASC),
  CONSTRAINT `fk_Users_has_Roles_Users1`
    FOREIGN KEY (`Users_id`)
    REFERENCES `SSvotemeup`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_has_Roles_Roles1`
    FOREIGN KEY (`Roles_id`)
    REFERENCES `SSvotemeup`.`Roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSvotemeup`.`Proposal_has_Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSvotemeup`.`Proposal_has_Category` ;

CREATE TABLE IF NOT EXISTS `SSvotemeup`.`Proposal_has_Category` (
  `Proposal_id` INT NOT NULL,
  `Category_id` INT NOT NULL,
  PRIMARY KEY (`Proposal_id`, `Category_id`),
  INDEX `fk_Proposal_has_Category_Category1_idx` (`Category_id` ASC),
  INDEX `fk_Proposal_has_Category_Proposal1_idx` (`Proposal_id` ASC),
  CONSTRAINT `fk_Proposal_has_Category_Proposal1`
    FOREIGN KEY (`Proposal_id`)
    REFERENCES `SSvotemeup`.`Proposal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_has_Category_Category1`
    FOREIGN KEY (`Category_id`)
    REFERENCES `SSvotemeup`.`Category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `SSvotemeup`.`Users`
-- -----------------------------------------------------
START TRANSACTION;
USE `SSvotemeup`;
INSERT INTO `SSvotemeup`.`Users` (`id`, `FirstName`, `LastName`, `Login`, `Password`, `Email`, `DateBirthday`, `Male`) VALUES (1, 'Слава', 'Пономаренко', 'marengo', '123', 'marengo.sys@gmail.com', '04.09.1975', 'male');

COMMIT;


-- -----------------------------------------------------
-- Data for table `SSvotemeup`.`Level_Proposal`
-- -----------------------------------------------------
START TRANSACTION;
USE `SSvotemeup`;
INSERT INTO `SSvotemeup`.`Level_Proposal` (`id`, `Level`) VALUES (1, 'По району');
INSERT INTO `SSvotemeup`.`Level_Proposal` (`id`, `Level`) VALUES (2, 'По городу');
INSERT INTO `SSvotemeup`.`Level_Proposal` (`id`, `Level`) VALUES (3, 'По стране');

COMMIT;


-- -----------------------------------------------------
-- Data for table `SSvotemeup`.`Proposal`
-- -----------------------------------------------------
START TRANSACTION;
USE `SSvotemeup`;
INSERT INTO `SSvotemeup`.`Proposal` (`id`, `Title`, `Description`, `Improvement`, `DataProposal`, `Users_id`, `Level_Proposal_id`) VALUES (1, 'Проба пера', 'Предложение по трансорту. Всем проезд бесплатный', 'Меньше машин на дорогах', '19,02,20141', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `SSvotemeup`.`Category`
-- -----------------------------------------------------
START TRANSACTION;
USE `SSvotemeup`;
INSERT INTO `SSvotemeup`.`Category` (`id`, `Category`) VALUES (1, 'Транспорт');
INSERT INTO `SSvotemeup`.`Category` (`id`, `Category`) VALUES (2, 'Вывоз мусора');
INSERT INTO `SSvotemeup`.`Category` (`id`, `Category`) VALUES (3, 'Газофикация');

COMMIT;


-- -----------------------------------------------------
-- Data for table `SSvotemeup`.`Roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `SSvotemeup`;
INSERT INTO `SSvotemeup`.`Roles` (`id`, `Name`) VALUES (1, 'Администратор');
INSERT INTO `SSvotemeup`.`Roles` (`id`, `Name`) VALUES (2, 'Пользователь');

COMMIT;

