-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Апр 28 2015 г., 22:40
-- Версия сервера: 5.5.43-0ubuntu0.14.04.1
-- Версия PHP: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `bookstore`
--

-- --------------------------------------------------------

--
-- Структура таблицы `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `description` text,
  `year` smallint(5) unsigned NOT NULL,
  `pages` smallint(6) NOT NULL,
  `url` tinytext NOT NULL,
  `publishing_house` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn` (`isbn`),
  KEY `FK_pmn2kxfjujasmno2p6tplx32c` (`publishing_house`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Дамп данных таблицы `book`
--

INSERT INTO `book` (`id`, `name`, `isbn`, `description`, `year`, `pages`, `url`, `publishing_house`) VALUES
(1, 'Java 8 in Action', '9781617291999', 'Every new version of Java is important, but Java 8 is a game changer. Java 8 in Action is a clearly written guide to the new features of Java 8. It begins with a practical introduction to lambdas, using real-world Java code. Next, it covers the new Streams API and shows how you can use it to make collection-based code radically easier to understand and maintain. It also explains other major Java 8 features including default methods, Optional, CompletableFuture, and the new Date and Time API.\r\n\r\nThis book is written for programmers familiar with Java and basic OO programming.', 2014, 424, 'http://www.manning.com/urma/', 2),
(2, 'Spring in Action', '9781935182351', 'Spring in Action, Third Edition continues the practical, hands-on style of the previous bestselling editions. Author Craig Walls has a special knack for crisp and entertaining examples that zoom in on the features and techniques you really need. This edition highlights the most important aspects of Spring 3.0 including REST, remote services, messaging, Security, MVC, Web Flow, and more.', 2014, 624, 'http://www.manning.com/walls5/', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `publishing_house`
--

CREATE TABLE IF NOT EXISTS `publishing_house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Дамп данных таблицы `publishing_house`
--

INSERT INTO `publishing_house` (`id`, `name`) VALUES
(1, 'Manning'),
(2, 'Apress');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `password`, `username`, `fullName`) VALUES
(10, '$2a$10$QQ4NZCEK6IASCKabjfe2lOkRIGSRj6CtVJYHTasoSosIh4./3amkK', 'lamp@kpfu.ru', 'Simple user'),
(11, '$2a$10$IQd/X6Y66q42K7QhcsdXduByMM/KkG9BHXOHzS4AKUj2KPZ8Mkd1W', 'lamp2@kpfu.ru', 'Admin user');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5m6djlf6toudifyf07bh74ich` (`authority`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`id`, `authority`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Структура таблицы `user_user_role`
--

CREATE TABLE IF NOT EXISTS `user_user_role` (
  `user` int(11) NOT NULL,
  `user_role` int(11) NOT NULL,
  PRIMARY KEY (`user`,`user_role`),
  KEY `FK_4w6qtvjyt42gdrdcg9ukuul40` (`user_role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_user_role`
--

INSERT INTO `user_user_role` (`user`, `user_role`) VALUES
(11, 1),
(10, 2),
(11, 2);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK_pmn2kxfjujasmno2p6tplx32c` FOREIGN KEY (`publishing_house`) REFERENCES `publishing_house` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_user_role`
--
ALTER TABLE `user_user_role`
  ADD CONSTRAINT `FK_1e97vv9xu9fx2kaeivgbh1jdx` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_4w6qtvjyt42gdrdcg9ukuul40` FOREIGN KEY (`user_role`) REFERENCES `user_role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
