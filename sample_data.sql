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

-- Дамп структуры базы данных new_test
CREATE DATABASE IF NOT EXISTS `new_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `new_test`;


-- Дамп структуры для таблица new_test.attachment
CREATE TABLE IF NOT EXISTS `attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kind` varchar(45) NOT NULL,
  `Proposal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Attachment_Proposal1` (`Proposal_id`),
  CONSTRAINT `fk_Attachment_Proposal1` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы new_test.attachment: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
INSERT INTO `attachment` (`id`, `kind`, `Proposal_id`) VALUES
	(1, 'карт1', 1),
	(2, 'док2', 2),
	(3, 'пдф', 1);
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;


-- Дамп структуры для таблица new_test.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `init_category` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы new_test.category: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `init_category`) VALUES
	(1, 'мусор'),
	(2, 'газ'),
	(3, 'транспорт'),
	(4, 'общие');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


-- Дамп структуры для таблица new_test.comments
CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(100) NOT NULL,
  `Proposal_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Comments_Proposal` (`Proposal_id`),
  KEY `fk_Comments_User1` (`User_id`),
  CONSTRAINT `fk_Comments_Proposal` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comments_User1` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы new_test.comments: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` (`id`, `comment`, `Proposal_id`, `User_id`) VALUES
	(1, 'бла бла', 1, 1),
	(2, 'бла!!', 1, 3),
	(3, 'хардкор', 2, 2),
	(4, 'brrr', 3, 1),
	(5, 'YO78O78', 4, 2),
	(6, 'SCCS', 4, 1);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;


-- Дамп структуры для таблица new_test.proposal
CREATE TABLE IF NOT EXISTS `proposal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) NOT NULL,
  `Date` date NOT NULL,
  `Improvment` varchar(100) NOT NULL,
  `Author` int(11) NOT NULL,
  `Prop_level` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Proposal_User1` (`Author`),
  KEY `fk_Proposal_Prop_level1` (`Prop_level`),
  CONSTRAINT `fk_Proposal_User1` FOREIGN KEY (`Author`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_Prop_level1` FOREIGN KEY (`Prop_level`) REFERENCES `prop_level` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы new_test.proposal: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `proposal` DISABLE KEYS */;
INSERT INTO `proposal` (`id`, `Title`, `Date`, `Improvment`, `Author`, `Prop_level`) VALUES
	(1, 'очистка свалки', '2014-02-21', 'надо срочно', 1, 1),
	(2, 'покрасить забор', '2013-12-21', 'тоже срочно', 2, 3),
	(3, 'быстрые маршрутки', '2014-02-24', 'надо', 3, 3),
	(4, 'дешевое такси', '2013-10-24', 'было бы не плохо', 2, 1),
	(5, 'Газификация села', '2014-02-24', 'срочно', 1, 1);
/*!40000 ALTER TABLE `proposal` ENABLE KEYS */;


-- Дамп структуры для таблица new_test.proposal_category
CREATE TABLE IF NOT EXISTS `proposal_category` (
  `Proposal_id` int(11) NOT NULL,
  `Category_id` int(11) NOT NULL,
  KEY `fk_Proposal_Category_Proposal1` (`Proposal_id`),
  KEY `fk_Proposal_Category_Category1` (`Category_id`),
  CONSTRAINT `fk_Proposal_Category_Proposal1` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_Category_Category1` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы new_test.proposal_category: ~4 rows (приблизительно)
/*!40000 ALTER TABLE `proposal_category` DISABLE KEYS */;
INSERT INTO `proposal_category` (`Proposal_id`, `Category_id`) VALUES
	(1, 1),
	(2, 4),
	(3, 3),
	(4, 3),
	(5, 2);
/*!40000 ALTER TABLE `proposal_category` ENABLE KEYS */;


-- Дамп структуры для таблица new_test.prop_level
CREATE TABLE IF NOT EXISTS `prop_level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы new_test.prop_level: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `prop_level` DISABLE KEYS */;
INSERT INTO `prop_level` (`id`, `level`) VALUES
	(1, 'по городу'),
	(2, 'по району'),
	(3, 'вообще глобально');
/*!40000 ALTER TABLE `prop_level` ENABLE KEYS */;


-- Дамп структуры для таблица new_test.provement
CREATE TABLE IF NOT EXISTS `provement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `Role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`Role_id`),
  KEY `fk_Provement_Role1` (`Role_id`),
  CONSTRAINT `fk_Provement_Role1` FOREIGN KEY (`Role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы new_test.provement: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `provement` DISABLE KEYS */;
INSERT INTO `provement` (`id`, `name`, `Role_id`) VALUES
	(1, 'админ', 1),
	(2, 'эзер', 3);
/*!40000 ALTER TABLE `provement` ENABLE KEYS */;


-- Дамп структуры для таблица new_test.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы new_test.role: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`) VALUES
	(1, 'admin'),
	(2, 'support'),
	(3, 'simp_user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Дамп структуры для таблица new_test.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `Role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Login_UNIQUE` (`login`),
  UNIQUE KEY `password_UNIQUE` (`password`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_User_Role1` (`Role_id`),
  CONSTRAINT `fk_User_Role1` FOREIGN KEY (`Role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы new_test.user: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `FirstName`, `LastName`, `login`, `password`, `email`, `Role_id`) VALUES
	(1, 'первый', 'первый', 'первый', '123', 'ыв@mail.ru', 1),
	(2, 'второй', 'второй', 'третий', '456', 'ыва@mail.ru', 3),
	(3, 'третий', 'третий', 'второй', '789', 'фыа@mail.ru', 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Дамп структуры для таблица new_test.vote
CREATE TABLE IF NOT EXISTS `vote` (
  `Proposal_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  KEY `fk_Vote_Proposal1` (`Proposal_id`),
  KEY `fk_Vote_User1` (`User_id`),
  CONSTRAINT `fk_Vote_Proposal1` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vote_User1` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы new_test.vote: ~7 rows (приблизительно)
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` (`Proposal_id`, `User_id`) VALUES
	(1, 1),
	(2, 2),
	(1, 3),
	(3, 2),
	(1, 2),
	(4, 1),
	(4, 2),
	(5, 2);
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
