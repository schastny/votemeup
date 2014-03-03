-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.16 - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных votemeup_new
DROP DATABASE IF EXISTS `votemeup_new`;
CREATE DATABASE IF NOT EXISTS `votemeup_new` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `votemeup_new`;


-- Дамп структуры для таблица votemeup_new.attachment
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE IF NOT EXISTS `attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FileName` varchar(255) NOT NULL,
  `Proposal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Attachments_Proposal1_idx` (`Proposal_id`),
  CONSTRAINT `fk_Attachments_Proposal1` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.attachment: ~0 rows (приблизительно)
DELETE FROM `attachment`;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.category: ~3 rows (приблизительно)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `Category`) VALUES
	(1, 'Транспорт'),
	(2, 'Вывоз мусора'),
	(3, 'Газофикация');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.category_proposal
DROP TABLE IF EXISTS `category_proposal`;
CREATE TABLE IF NOT EXISTS `category_proposal` (
  `Proposal_id` int(11) NOT NULL,
  `Category_id` int(11) NOT NULL,
  PRIMARY KEY (`Proposal_id`,`Category_id`),
  KEY `fk_Proposal_has_Category_Category1_idx` (`Category_id`),
  KEY `fk_Proposal_has_Category_Proposal1_idx` (`Proposal_id`),
  CONSTRAINT `fk_Proposal_has_Category_Proposal1` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_has_Category_Category1` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.category_proposal: ~0 rows (приблизительно)
DELETE FROM `category_proposal`;
/*!40000 ALTER TABLE `category_proposal` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_proposal` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.city
DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `City` varchar(45) NOT NULL,
  `Сountry_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_City_Сountry1_idx` (`Сountry_id`),
  CONSTRAINT `fk_City_Сountry1` FOREIGN KEY (`Сountry_id`) REFERENCES `сountry` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.city: ~0 rows (приблизительно)
DELETE FROM `city`;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.comment
DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Proposal_id` int(11) NOT NULL,
  `CommentText` varchar(250) NOT NULL,
  `CommentAuthor` int(11) NOT NULL,
  `CommentParent` int(11) NOT NULL,
  `CommentDate` date NOT NULL,
  `CommentDelete` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Comment_User1_idx` (`CommentAuthor`),
  KEY `fk_Comment_Proposal2_idx` (`Proposal_id`),
  KEY `fk_Comment_Comment1_idx` (`CommentParent`),
  CONSTRAINT `fk_Comment_User1` FOREIGN KEY (`CommentAuthor`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_Proposal2` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_Comment1` FOREIGN KEY (`CommentParent`) REFERENCES `comment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.comment: ~0 rows (приблизительно)
DELETE FROM `comment`;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.district
DROP TABLE IF EXISTS `district`;
CREATE TABLE IF NOT EXISTS `district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `District` varchar(45) NOT NULL,
  `City_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_District_City1_idx` (`City_id`),
  CONSTRAINT `fk_District_City1` FOREIGN KEY (`City_id`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.district: ~0 rows (приблизительно)
DELETE FROM `district`;
/*!40000 ALTER TABLE `district` DISABLE KEYS */;
/*!40000 ALTER TABLE `district` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.level
DROP TABLE IF EXISTS `level`;
CREATE TABLE IF NOT EXISTS `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Level` varchar(45) NOT NULL,
  `MinVoteYes` int(11) NOT NULL,
  `MinVotePeriod` enum('неделя','месяц','квартал') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idLevel_Proposal_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.level: ~0 rows (приблизительно)
DELETE FROM `level`;
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
/*!40000 ALTER TABLE `level` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.proposal
DROP TABLE IF EXISTS `proposal`;
CREATE TABLE IF NOT EXISTS `proposal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) NOT NULL,
  `DataCreate` date NOT NULL,
  `DateEnd` date DEFAULT NULL,
  `Description` longtext NOT NULL,
  `Improvement` longtext NOT NULL,
  `Author` int(11) NOT NULL,
  `Level_id` int(11) NOT NULL,
  `Сountry_id` int(11) NOT NULL,
  `City_id` int(11) NOT NULL,
  `District_id` int(11) NOT NULL,
  `TotalYes` int(11) DEFAULT NULL,
  `TotalNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idProposal_UNIQUE` (`id`),
  KEY `fk_Proposal_Users1_idx` (`Author`),
  KEY `fk_Proposal_Level_Proposal1_idx` (`Level_id`),
  KEY `fk_Proposal_Сountry1_idx` (`Сountry_id`),
  KEY `fk_Proposal_City1_idx` (`City_id`),
  KEY `fk_Proposal_District1_idx` (`District_id`),
  CONSTRAINT `fk_Proposal_Users1` FOREIGN KEY (`Author`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_Level_Proposal1` FOREIGN KEY (`Level_id`) REFERENCES `level` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_Сountry1` FOREIGN KEY (`Сountry_id`) REFERENCES `сountry` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_City1` FOREIGN KEY (`City_id`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_District1` FOREIGN KEY (`District_id`) REFERENCES `district` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.proposal: ~0 rows (приблизительно)
DELETE FROM `proposal`;
/*!40000 ALTER TABLE `proposal` DISABLE KEYS */;
/*!40000 ALTER TABLE `proposal` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Role` varchar(20) NOT NULL,
  `Login` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `CodeConfirmation` varchar(45) DEFAULT NULL,
  `ReportNewProposal` tinyint(1) DEFAULT NULL,
  `ReportNewComment` tinyint(1) DEFAULT NULL,
  `ReportNewCommentAuthor` tinyint(1) DEFAULT NULL,
  `PeriodReport` enum('немедленно','раз в день','раз в неделю','раз в месяц') DEFAULT NULL,
  `DateBirthday` date NOT NULL,
  `DateRegistration` date NOT NULL,
  `Gender` enum('male','female') DEFAULT NULL,
  `ProposalBan` tinyint(1) DEFAULT NULL,
  `CommentBan` tinyint(1) DEFAULT NULL,
  `Сountry_id` int(11) NOT NULL,
  `City_id` int(11) NOT NULL,
  `District_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `Login_UNIQUE` (`Login`),
  UNIQUE KEY `Password_UNIQUE` (`Password`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  KEY `fk_User_Сountry1_idx` (`Сountry_id`),
  KEY `fk_User_City1_idx` (`City_id`),
  KEY `fk_User_District1_idx` (`District_id`),
  CONSTRAINT `fk_User_Сountry1` FOREIGN KEY (`Сountry_id`) REFERENCES `сountry` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_City1` FOREIGN KEY (`City_id`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_District1` FOREIGN KEY (`District_id`) REFERENCES `district` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.user: ~0 rows (приблизительно)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.user_like
DROP TABLE IF EXISTS `user_like`;
CREATE TABLE IF NOT EXISTS `user_like` (
  `User_id` int(11) NOT NULL,
  `Comment_id` int(11) NOT NULL,
  PRIMARY KEY (`User_id`,`Comment_id`),
  KEY `fk_User_has_Comment_Comment1_idx` (`Comment_id`),
  KEY `fk_User_has_Comment_User1_idx` (`User_id`),
  CONSTRAINT `fk_User_has_Comment_User1` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Comment_Comment1` FOREIGN KEY (`Comment_id`) REFERENCES `comment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.user_like: ~0 rows (приблизительно)
DELETE FROM `user_like`;
/*!40000 ALTER TABLE `user_like` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_like` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.vote_proposal
DROP TABLE IF EXISTS `vote_proposal`;
CREATE TABLE IF NOT EXISTS `vote_proposal` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Vote` tinyint(1) NOT NULL,
  `VoteDateTime` datetime NOT NULL,
  `Proposal_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id_UNIQUE` (`Id`),
  KEY `fk_Vote_Proposal_Proposal1_idx` (`Proposal_id`),
  KEY `fk_Vote_Proposal_User1_idx` (`User_id`),
  CONSTRAINT `fk_Vote_Proposal_Proposal1` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vote_Proposal_User1` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.vote_proposal: ~0 rows (приблизительно)
DELETE FROM `vote_proposal`;
/*!40000 ALTER TABLE `vote_proposal` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote_proposal` ENABLE KEYS */;


-- Дамп структуры для таблица votemeup_new.сountry
DROP TABLE IF EXISTS `сountry`;
CREATE TABLE IF NOT EXISTS `сountry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Сountry` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы votemeup_new.сountry: ~0 rows (приблизительно)
DELETE FROM `сountry`;
/*!40000 ALTER TABLE `сountry` DISABLE KEYS */;
/*!40000 ALTER TABLE `сountry` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
