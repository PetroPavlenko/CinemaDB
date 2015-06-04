CREATE DATABASE  IF NOT EXISTS `cinema` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cinema`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cinema
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `address_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(50) NOT NULL,
  `city_id` smallint(5) unsigned NOT NULL,
  `postal_code` varchar(10) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`address_id`),
  KEY `fk_address_city` (`city_id`),
  CONSTRAINT `fk_address_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Kopernika, 9',1,'111111','2015-04-17 07:46:18'),(2,'Teatralna, 22',1,'111111','2015-04-17 07:48:30'),(3,'Chervonoi Kalini, 81',1,'111111','2015-04-17 07:48:30'),(4,'Московський проспект 34-в	',2,'111112','2015-04-17 07:52:58'),(5,'вул. Артема, 93	',2,'111112','2015-04-17 07:52:58'),(6,'вул. Івана-Франка, 44',1,'111123','2015-04-17 09:13:24');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `autor_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`autor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Wachowski','Brothers','2015-03-29 17:01:25'),(2,'J.',' K. Rowling','2015-03-29 17:01:25');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Criminal','2015-03-29 16:55:58'),(2,'Action','2015-03-29 16:56:18'),(3,'Comedy','2015-03-29 16:56:54'),(4,'Love','2015-03-29 16:56:54'),(5,'Fentesy','2015-04-18 14:36:01'),(6,'Furcosh','2015-04-18 14:37:14');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinema` (
  `cinema_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `address_id` smallint(5) unsigned NOT NULL,
  `name` varchar(20) NOT NULL,
  `Area` int(10) unsigned DEFAULT '100',
  `Rent_pay` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
  `Comunal_pos` decimal(10,2) unsigned NOT NULL DEFAULT '10.00',
  `Product` decimal(10,2) unsigned DEFAULT NULL,
  `absolut_product` decimal(10,2) unsigned DEFAULT NULL,
  PRIMARY KEY (`cinema_id`),
  KEY `fk_cinema_adress` (`address_id`),
  CONSTRAINT `fk_cinema_adress` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema`
--

LOCK TABLES `cinema` WRITE;
/*!40000 ALTER TABLE `cinema` DISABLE KEYS */;
INSERT INTO `cinema` VALUES (1,1,'Kopernika',100,10.00,10.00,100.00,80.00),(2,2,'KinoPalz',200,20.00,15.00,200.00,165.00),(3,3,'KinoTeatr',200,13.00,13.00,180.00,154.00);
/*!40000 ALTER TABLE `cinema` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ins2_cinema.cinema` BEFORE INSERT ON cinema.cinema 
FOR EACH ROW 
SET NEW.absolut_product=NEW.Product-NEW.Comunal_pos-NEW.Rent_pay */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ins_cinema.cinema` BEFORE UPDATE ON cinema.cinema 
FOR EACH ROW 
SET NEW.absolut_product=NEW.Product-NEW.Comunal_pos-NEW.Rent_pay */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `city_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `city` varchar(50) NOT NULL,
  `country_id` smallint(5) unsigned NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`city_id`),
  KEY `fk_city_country` (`country_id`),
  CONSTRAINT `fk_city_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Lviv',1,'2015-04-17 07:32:22'),(2,'Kyiv',1,'2015-04-17 07:32:22'),(3,'Odesa',1,'2015-04-17 07:32:22'),(5,'Miami ',3,'2015-04-17 07:34:52'),(6,'Los Angeles',3,'2015-04-17 07:34:52'),(7,'New York',3,'2015-04-17 07:34:52'),(8,'Hong Kong',8,'2015-04-17 07:36:17'),(9,'Pekin',8,'2015-04-17 07:36:17'),(10,'Shanghai',8,'2015-04-17 07:36:17'),(11,'Tokio',9,'2015-04-17 07:36:17'),(12,'London',4,'2015-04-17 07:37:14'),(13,'Berlin',5,'2015-04-17 07:37:14'),(14,'Paris',6,'2015-04-17 07:40:41'),(15,'Graz',2,'2015-04-17 07:40:41'),(16,'Wien',2,'2015-04-17 07:40:41'),(17,'Linz',2,'2015-04-17 07:40:41');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `country_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `country` varchar(50) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`country_id`,`country`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Ukraine','2015-04-17 07:26:39'),(2,'Austria','2015-04-17 07:26:39'),(3,'USA','2015-04-17 07:27:24'),(4,'Great Britain','2015-04-17 07:27:24'),(5,'Germany','2015-04-17 07:28:35'),(6,'France','2015-04-17 07:28:35'),(7,'India','2015-04-17 07:29:46'),(8,'China','2015-04-17 07:29:46'),(9,'Japan','2015-04-17 07:29:46'),(10,'Australia','2015-04-17 07:30:19');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_company`
--

DROP TABLE IF EXISTS `country_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country_company` (
  `country_company_id` smallint(2) NOT NULL,
  `country_company` varchar(45) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`country_company_id`,`country_company`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_company`
--

LOCK TABLES `country_company` WRITE;
/*!40000 ALTER TABLE `country_company` DISABLE KEYS */;
INSERT INTO `country_company` VALUES (38,'Ukraine','2015-04-17 08:55:31');
/*!40000 ALTER TABLE `country_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_f`
--

DROP TABLE IF EXISTS `customer_f`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_f` (
  `customer_id` smallint(5) unsigned NOT NULL,
  `film_id` smallint(5) unsigned NOT NULL,
  `cinema_id` smallint(5) unsigned NOT NULL,
  `watching_date` datetime NOT NULL,
  `pay` decimal(10,2) unsigned NOT NULL,
  `remark` text,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `fk_customer_F_film` (`film_id`),
  KEY `fk_customer_F_cinema_id` (`cinema_id`),
  KEY `fk_customer_F_customers_idx` (`customer_id`),
  CONSTRAINT `fk_customer_F_cinema_id` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`cinema_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_F_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_F_film` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table storing all customers. Holds foreign keys to the addre';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_f`
--

LOCK TABLES `customer_f` WRITE;
/*!40000 ALTER TABLE `customer_f` DISABLE KEYS */;
INSERT INTO `customer_f` VALUES (1,1,1,'2015-04-18 17:39:21',12.00,'123','2015-05-25 21:04:52'),(2,1,1,'2015-04-18 17:39:21',12.00,'123','2015-05-25 21:04:57'),(2,1,1,'2015-04-12 17:39:21',12.00,'123','2015-05-25 21:05:03'),(1,1,1,'2015-04-18 17:39:21',132.00,'dsf','2015-05-25 21:10:34'),(3,3,3,'2015-01-01 10:02:00',234.00,'12','2015-05-25 21:11:05'),(3,7,2,'2015-05-26 23:21:43',1234.00,NULL,'2015-05-26 21:29:38'),(1,2,3,'2015-05-26 23:21:42',12.00,NULL,'2015-05-26 21:30:22'),(2,2,1,'2015-05-26 23:21:43',4.00,NULL,'2015-05-26 21:31:04'),(1,7,2,'2015-05-22 11:50:01',2000.00,'oi','2015-05-27 16:05:08'),(2,5,3,'2015-05-29 11:01:01',1000.00,'bladina','2015-05-29 09:23:32');
/*!40000 ALTER TABLE `customer_f` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `customer_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `address_id` smallint(5) unsigned NOT NULL,
  `phone_id` smallint(5) unsigned NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `Pasport number` varchar(50) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `second_phone_id` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `fk_custome_Fr_address0` (`address_id`),
  KEY `fk_customer_F_phone_number_second` (`phone_id`),
  CONSTRAINT `fk_custome_Fr_address0` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_customer_F_phone_number` FOREIGN KEY (`phone_id`) REFERENCES `phone_number` (`phone_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_F_phone_number_second` FOREIGN KEY (`phone_id`) REFERENCES `phone_number` (`phone_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Table storing all customers. Holds foreign keys to the addre';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,3,4,'Petro','Pavlenko','КС434343','2015-04-17 09:31:24',NULL),(2,4,5,'Olha','Goer','KC345676','2015-04-17 09:32:46',NULL),(3,5,5,'Kristina','Femenistca','SS102102','2015-04-17 09:32:46',NULL);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `customers_at_film`
--

DROP TABLE IF EXISTS `customers_at_film`;
/*!50001 DROP VIEW IF EXISTS `customers_at_film`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `customers_at_film` AS SELECT 
 1 AS `FID`,
 1 AS `title`,
 1 AS `count`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `joining_date` date NOT NULL,
  `salary` double NOT NULL,
  `ssn` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ssn` (`ssn`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'243','2015-04-17',2,'2');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film` (
  `film_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `length` smallint(5) unsigned DEFAULT NULL,
  `description` text,
  `tiket_price` decimal(10,2) unsigned NOT NULL DEFAULT '1.00',
  `central_rental_price` decimal(10,2) unsigned NOT NULL DEFAULT '4.99',
  `release_year` year(4) DEFAULT NULL,
  `language_id` tinyint(3) unsigned DEFAULT NULL,
  `original_language_id` tinyint(3) unsigned NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`film_id`),
  KEY `fk_film_language` (`language_id`),
  KEY `fk_film_language_original` (`original_language_id`),
  CONSTRAINT `fk_film_language` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_film_language_original` FOREIGN KEY (`original_language_id`) REFERENCES `language` (`language_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'Форсаж 1',130,'гонки',50.00,20000.00,2003,2,1,'2015-04-18 14:32:40'),(2,'Матриця 3',130,'фентезі',80.00,30000.00,2003,1,2,'2015-04-18 14:32:40'),(3,'Baptized parent',1234,'1234',12.00,11.00,2000,2,1,'2015-05-22 09:29:50'),(4,'Big Film',10000,'SO BIG',1000.00,100.00,2015,3,1,'2015-05-26 21:17:27'),(5,'Oh',12,'12',12.00,21.00,2000,1,1,'2015-05-28 17:54:24'),(6,'1',3,'1',4.00,1.00,2002,3,1,'2015-05-28 20:20:10'),(7,'HarishPoter',232,'blaa',1221.00,1212.00,2013,1,1,'2015-05-17 10:04:39'),(9,'cr2',12,'32',123.00,123.00,2010,1,1,'2015-05-28 19:57:58');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `upd_film` AFTER UPDATE ON `film` FOR EACH ROW BEGIN
    IF (old.title != new.title) or (old.description != new.description)
    THEN
        UPDATE film_text
            SET title=new.title,
                description=new.description,
                film_id=new.film_id
        WHERE film_id=old.film_id;
    END IF;
  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `film_autor`
--

DROP TABLE IF EXISTS `film_autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_autor` (
  `autor_id` smallint(5) unsigned NOT NULL,
  `film_id` smallint(5) unsigned NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `fk_film_autor_autor` (`autor_id`),
  KEY `fk_film_autor_film` (`film_id`),
  CONSTRAINT `fk_film_autor_autor` FOREIGN KEY (`autor_id`) REFERENCES `autor` (`autor_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_film_autor_film` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_autor`
--

LOCK TABLES `film_autor` WRITE;
/*!40000 ALTER TABLE `film_autor` DISABLE KEYS */;
INSERT INTO `film_autor` VALUES (1,1,'2015-04-18 14:33:59'),(2,7,'2015-05-21 08:53:42'),(2,3,'2015-05-22 09:29:51'),(2,4,'2015-05-26 21:17:27'),(1,5,'2015-05-28 17:54:25'),(1,9,'2015-05-28 19:57:58'),(1,6,'2015-05-28 20:20:10'),(2,6,'2015-05-28 20:20:10');
/*!40000 ALTER TABLE `film_autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film_category`
--

DROP TABLE IF EXISTS `film_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film_category` (
  `film_id` smallint(5) unsigned NOT NULL,
  `category_id` tinyint(3) unsigned NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`film_id`,`category_id`),
  KEY `fk_film_category_category` (`category_id`),
  CONSTRAINT `fk_film_category_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_film_category_film` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film_category`
--

LOCK TABLES `film_category` WRITE;
/*!40000 ALTER TABLE `film_category` DISABLE KEYS */;
INSERT INTO `film_category` VALUES (1,4,'2015-05-26 20:57:07'),(1,6,'2015-04-18 14:39:21'),(2,5,'2015-04-18 14:39:21'),(3,3,'2015-05-26 20:19:58'),(4,5,'2015-05-26 21:17:27'),(5,3,'2015-05-28 17:54:25'),(6,1,'2015-05-28 20:20:10'),(6,3,'2015-05-28 20:20:10'),(6,6,'2015-05-28 20:20:10'),(7,2,'2015-05-26 20:21:43'),(9,3,'2015-05-28 19:57:58'),(9,4,'2015-05-28 19:57:58'),(9,6,'2015-05-28 19:57:58');
/*!40000 ALTER TABLE `film_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `film_list`
--

DROP TABLE IF EXISTS `film_list`;
/*!50001 DROP VIEW IF EXISTS `film_list`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `film_list` AS SELECT 
 1 AS `FID`,
 1 AS `title`,
 1 AS `description`,
 1 AS `category`,
 1 AS `length`,
 1 AS `autors`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `language_id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`language_id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'English','2015-04-17 09:28:57'),(2,'Ukrainian','2015-04-17 09:28:57'),(3,'German','2015-04-17 09:28:57');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_number`
--

DROP TABLE IF EXISTS `phone_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone_number` (
  `phone_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `country_company_id` smallint(2) NOT NULL,
  `punkt_number` smallint(3) unsigned zerofill NOT NULL,
  `else_number` int(7) unsigned zerofill NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`phone_id`),
  KEY `fk_phone_number_cou_com` (`country_company_id`),
  CONSTRAINT `fk_phone_number_cou_com` FOREIGN KEY (`country_company_id`) REFERENCES `country_company` (`country_company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_number`
--

LOCK TABLES `phone_number` WRITE;
/*!40000 ALTER TABLE `phone_number` DISABLE KEYS */;
INSERT INTO `phone_number` VALUES (1,38,063,3614839,'2015-04-17 09:06:08'),(2,38,093,0000102,'2015-04-17 09:09:47'),(3,38,067,0222222,'2015-04-17 09:10:23'),(4,38,093,2929292,'2015-04-17 09:22:17'),(5,38,063,0930492,'2015-04-17 09:22:17'),(6,38,067,0123012,'2015-04-17 09:22:17'),(7,38,050,0413413,'2015-04-17 09:22:17');
/*!40000 ALTER TABLE `phone_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` double NOT NULL,
  `firstName` text NOT NULL,
  `lastName` text NOT NULL,
  `email` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workers`
--

DROP TABLE IF EXISTS `workers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workers` (
  `worker_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `address_id` smallint(5) unsigned NOT NULL,
  `phone_id` smallint(5) unsigned NOT NULL,
  `cinema_id` smallint(5) unsigned NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `Pasport number` varchar(50) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`worker_id`),
  KEY `fk_custome_Fr_address00` (`address_id`),
  KEY `fk_customer_F_phone_number00` (`phone_id`),
  KEY `fk_workers_cinema` (`cinema_id`),
  CONSTRAINT `fk_custome_Fr_address00` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_customer_F_phone_number00` FOREIGN KEY (`phone_id`) REFERENCES `phone_number` (`phone_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_workers_cinema` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`cinema_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Table storing all customers. Holds foreign keys to the addre';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workers`
--

LOCK TABLES `workers` WRITE;
/*!40000 ALTER TABLE `workers` DISABLE KEYS */;
INSERT INTO `workers` VALUES (1,1,1,1,'Loh','Ihor','ВК3455354','2015-04-17 09:21:03'),(2,1,2,1,'Dibili','Ivan','ВС2335654','2015-04-17 09:21:03'),(3,2,3,2,'Tududu','Lobodu','КС6542313','2015-04-17 09:21:03'),(4,2,4,3,'Bla','Bla','CC4444448','2015-04-17 09:26:40');
/*!40000 ALTER TABLE `workers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `customers_at_film`
--

/*!50001 DROP VIEW IF EXISTS `customers_at_film`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `customers_at_film` AS select `film`.`film_id` AS `FID`,`film`.`title` AS `title`,count(`customer_f`.`film_id`) AS `count` from (`film` join `customer_f` on((`customer_f`.`film_id` = `film`.`film_id`))) where (`customer_f`.`film_id` = 1) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `film_list`
--

/*!50001 DROP VIEW IF EXISTS `film_list`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `film_list` AS select `film`.`film_id` AS `FID`,`film`.`title` AS `title`,`film`.`description` AS `description`,`category`.`name` AS `category`,`film`.`length` AS `length`,group_concat(concat(`autor`.`first_name`,' ',`autor`.`last_name`) separator ', ') AS `autors` from ((((`category` left join `film_category` on((`category`.`category_id` = `film_category`.`category_id`))) left join `film` on((`film_category`.`film_id` = `film`.`film_id`))) join `film_autor` on((`film`.`film_id` = `film_autor`.`film_id`))) join `autor` on((`film_autor`.`autor_id` = `autor`.`autor_id`))) group by `film`.`film_id`,`category`.`name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-02 12:58:17
