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

-- Дамп структуры базы данных ssvotemeup
CREATE DATABASE IF NOT EXISTS `ssvotemeup` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ssvotemeup`;


-- Дамп структуры для таблица ssvotemeup.attachment_proposal
CREATE TABLE IF NOT EXISTS `attachment_proposal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(100) NOT NULL,
  `Proposal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Attachments_Proposal1_idx` (`Proposal_id`),
  CONSTRAINT `fk_Attachments_Proposal1` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ssvotemeup.attachment_proposal: ~7 rows (приблизительно)
DELETE FROM `attachment_proposal`;
/*!40000 ALTER TABLE `attachment_proposal` DISABLE KEYS */;
INSERT INTO `attachment_proposal` (`id`, `URL`, `Proposal_id`) VALUES
	(1, 'картинка 1', 1),
	(2, 'картинка 2', 1),
	(3, 'картинка 3', 1),
	(4, 'картинка 4', 1),
	(5, 'картинка 5', 1),
	(6, 'Документ 1', 2),
	(7, 'Документ 2', 2);
/*!40000 ALTER TABLE `attachment_proposal` ENABLE KEYS */;


-- Дамп структуры для таблица ssvotemeup.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ssvotemeup.category: ~10 rows (приблизительно)
DELETE FROM `category`;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `Category`) VALUES
	(1, 'Транспорт'),
	(2, 'Вывоз мусора'),
	(3, 'Газофикация'),
	(4, 'Здравоохранение'),
	(5, 'Социальная защита'),
	(6, 'Туризм'),
	(7, 'Культура'),
	(8, 'Обеспечение порядка'),
	(9, 'Коррупция'),
	(10, 'Инвестиции');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


-- Дамп структуры для таблица ssvotemeup.category_proposal
CREATE TABLE IF NOT EXISTS `category_proposal` (
  `Proposal_id` int(11) NOT NULL,
  `Category_id` int(11) NOT NULL,
  PRIMARY KEY (`Proposal_id`,`Category_id`),
  KEY `fk_Proposal_has_Category_Category1_idx` (`Category_id`),
  KEY `fk_Proposal_has_Category_Proposal1_idx` (`Proposal_id`),
  CONSTRAINT `fk_Proposal_has_Category_Proposal1` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_has_Category_Category1` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ssvotemeup.category_proposal: ~4 rows (приблизительно)
DELETE FROM `category_proposal`;
/*!40000 ALTER TABLE `category_proposal` DISABLE KEYS */;
INSERT INTO `category_proposal` (`Proposal_id`, `Category_id`) VALUES
	(1, 2),
	(2, 2),
	(3, 2),
	(2, 5),
	(2, 7),
	(1, 8);
/*!40000 ALTER TABLE `category_proposal` ENABLE KEYS */;


-- Дамп структуры для таблица ssvotemeup.comment
CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Text` varchar(500) NOT NULL,
  `User_id` int(11) NOT NULL,
  `Proposal_id1` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Comment_User1_idx` (`User_id`),
  KEY `fk_Comment_Proposal2_idx` (`Proposal_id1`),
  CONSTRAINT `fk_Comment_Proposal2` FOREIGN KEY (`Proposal_id1`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_User1` FOREIGN KEY (`User_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ssvotemeup.comment: ~7 rows (приблизительно)
DELETE FROM `comment`;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`id`, `Text`, `User_id`, `Proposal_id1`) VALUES
	(1, 'Полностью поддерживаю!!', 5, 1),
	(2, 'А не проще поставить больше мусорных баков???', 1, 1),
	(3, 'И посадить больше деревьев, что б дышали свежим воздухом', 2, 2),
	(4, 'Лучше руки отрубать за взятие', 5, 3),
	(5, 'Не поможет, это впитывается с молоком матери :(', 9, 3),
	(6, 'А баланс телефона пополнять за счет второй стороны? Не интересно..', 3, 3),
	(7, 'Нет мотивации достойной.. не пройдет', 7, 3);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


-- Дамп структуры для таблица ssvotemeup.level_proposal
CREATE TABLE IF NOT EXISTS `level_proposal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Level` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idLevel_Proposal_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ssvotemeup.level_proposal: ~3 rows (приблизительно)
DELETE FROM `level_proposal`;
/*!40000 ALTER TABLE `level_proposal` DISABLE KEYS */;
INSERT INTO `level_proposal` (`id`, `Level`) VALUES
	(1, 'По району'),
	(2, 'По городу'),
	(3, 'По стране');
/*!40000 ALTER TABLE `level_proposal` ENABLE KEYS */;


-- Дамп структуры для таблица ssvotemeup.privilege
CREATE TABLE IF NOT EXISTS `privilege` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Provement_Role1_idx` (`Role_id`),
  CONSTRAINT `fk_Provement_Role1` FOREIGN KEY (`Role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ssvotemeup.privilege: ~0 rows (приблизительно)
DELETE FROM `privilege`;
/*!40000 ALTER TABLE `privilege` DISABLE KEYS */;
/*!40000 ALTER TABLE `privilege` ENABLE KEYS */;


-- Дамп структуры для таблица ssvotemeup.proposal
CREATE TABLE IF NOT EXISTS `proposal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) NOT NULL,
  `Description` varchar(500) NOT NULL,
  `Improvement` varchar(100) NOT NULL,
  `DataProposal` date NOT NULL,
  `Author` int(11) NOT NULL,
  `Level_Proposal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idProposal_UNIQUE` (`id`),
  KEY `fk_Proposal_Users1_idx` (`Author`),
  KEY `fk_Proposal_Level_Proposal1_idx` (`Level_Proposal_id`),
  CONSTRAINT `fk_Proposal_Users1` FOREIGN KEY (`Author`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proposal_Level_Proposal1` FOREIGN KEY (`Level_Proposal_id`) REFERENCES `level_proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ssvotemeup.proposal: ~3 rows (приблизительно)
DELETE FROM `proposal`;
/*!40000 ALTER TABLE `proposal` DISABLE KEYS */;
INSERT INTO `proposal` (`id`, `Title`, `Description`, `Improvement`, `DataProposal`, `Author`, `Level_Proposal_id`) VALUES
	(1, 'Организовать вывоз мусора два раза в день', 'Так как количество мусорных баков слишком мало для нашего района, нужно вывозить мусор минимум два раза в день', 'Район будет намного чище', '2014-02-19', 4, 1),
	(2, 'Установить детскую площадку', 'Для досуга детей во дворе нужно установить детские площадки', 'Дети будут расти здоровыми', '2014-02-19', 10, 1),
	(3, 'Организовать горячую линию для обращения про требование взятки', 'Сделать бесплатную телефонную линию с коротким номером как у скорой помощи для сообщения о попытке дать/взять взятку', 'За звонок и подтвержденный случай пополнить баланс телефона', '2014-02-20', 5, 3),
	(4, 'Автобус в балаклаву сделать более комфортабельным', 'Надоело ездить стоя', 'На работу и домой буду приезжать счастливым', '2014-02-19', 4, 2);
/*!40000 ALTER TABLE `proposal` ENABLE KEYS */;


-- Дамп структуры для таблица ssvotemeup.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ssvotemeup.role: ~3 rows (приблизительно)
DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `Name`) VALUES
	(1, 'Администратор'),
	(2, 'Пользователь'),
	(3, 'Контент менеджер');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Дамп структуры для таблица ssvotemeup.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Login` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `DateBirthday` date NOT NULL,
  `Male` enum('male','female') NOT NULL,
  `Role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `Login_UNIQUE` (`Login`),
  UNIQUE KEY `Password_UNIQUE` (`Password`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  KEY `fk_User_Role1_idx` (`Role_id`),
  CONSTRAINT `fk_User_Role1` FOREIGN KEY (`Role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ssvotemeup.user: ~10 rows (приблизительно)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `FirstName`, `LastName`, `Login`, `Password`, `Email`, `DateBirthday`, `Male`, `Role_id`) VALUES
	(1, 'Слава', 'Пономаренко', 'marengo', '123', 'marengo.sys@gmail.com', '1975-09-04', 'male', 1),
	(2, 'Админ', 'Админов', 'admin', 'admin', 'kl-sys@mail.ru', '1975-09-04', 'male', 1),
	(3, 'Контент', 'Менеджер', 'content', 'content', 'test@mail.ru', '1985-09-04', 'male', 3),
	(4, 'Пользователь1', 'Пользователь1', 'user1', 'pass1', '1@mail.ru', '2000-01-01', 'female', 2),
	(5, 'Пользователь2', 'Пользователь2', 'user2', 'pass2', '2@mail.ru', '1900-01-01', 'male', 2),
	(6, 'Пользователь3', 'Пользователь3', 'user3', 'pass3', '3@mail.ru', '1956-01-01', 'male', 2),
	(7, 'Пользователь4', 'Пользователь4', 'user4', 'pass4', '4@mail.ru', '2005-10-20', 'female', 2),
	(8, 'Пользователь5', 'Пользователь5', 'user5', 'pass5', '5@mail.ru', '2005-10-20', 'female', 2),
	(9, 'Пользователь6', 'Пользователь6', 'user6', 'pass6', '6@mail.ru', '2005-10-20', 'male', 2),
	(10, 'Пользователь7', 'Пользователь7', 'user7', 'pass7', '7@mail.ru', '1990-02-15', 'male', 2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Дамп структуры для таблица ssvotemeup.vote
CREATE TABLE IF NOT EXISTS `vote` (
  `Users_id` int(11) NOT NULL,
  `Proposal_id` int(11) NOT NULL,
  PRIMARY KEY (`Users_id`,`Proposal_id`),
  KEY `fk_Vote_Users1_idx` (`Users_id`),
  KEY `fk_Vote_Proposal1_idx` (`Proposal_id`),
  CONSTRAINT `fk_Vote_Users1` FOREIGN KEY (`Users_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vote_Proposal1` FOREIGN KEY (`Proposal_id`) REFERENCES `proposal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы ssvotemeup.vote: ~14 rows (приблизительно)
DELETE FROM `vote`;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` (`Users_id`, `Proposal_id`) VALUES
	(1, 1),
	(2, 3),
	(3, 3),
	(4, 1),
	(4, 2),
	(4, 3),
	(5, 1),
	(5, 2),
	(5, 3),
	(6, 1),
	(7, 1),
	(8, 1),
	(9, 1),
	(10, 1);
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
