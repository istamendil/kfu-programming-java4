-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Апр 10 2015 г., 18:20
-- Версия сервера: 5.5.41-0ubuntu0.14.04.1
-- Версия PHP: 5.5.9-1ubuntu4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `test`
--

-- --------------------------------------------------------

--
-- Структура таблицы `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `isbn` varchar(255) CHARACTER SET utf8 NOT NULL,
  `description` text CHARACTER SET utf8,
  `year` smallint(5) unsigned NOT NULL,
  `pages` smallint(6) NOT NULL,
  `url` tinytext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn` (`isbn`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Дамп данных таблицы `book`
--

INSERT INTO `book` (`id`, `name`, `isbn`, `description`, `year`, `pages`, `url`) VALUES
(1, 'Java 8 in Action', '9781617291999 ', 'Every new version of Java is important, but Java 8 is a game changer. Java 8 in Action is a clearly written guide to the new features of Java 8. It begins with a practical introduction to lambdas, using real-world Java code. Next, it covers the new Streams API and shows how you can use it to make collection-based code radically easier to understand and maintain. It also explains other major Java 8 features including default methods, Optional, CompletableFuture, and the new Date and Time API.\r\n\r\nThis book is written for programmers familiar with Java and basic OO programming.', 2014, 424, 'http://www.manning.com/urma/'),
(2, 'Spring in Action', '9781935182351', 'Spring in Action, Third Edition continues the practical, hands-on style of the previous bestselling editions. Author Craig Walls has a special knack for crisp and entertaining examples that zoom in on the features and techniques you really need. This edition highlights the most important aspects of Spring 3.0 including REST, remote services, messaging, Security, MVC, Web Flow, and more.', 2014, 624, 'http://www.manning.com/walls5/');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
