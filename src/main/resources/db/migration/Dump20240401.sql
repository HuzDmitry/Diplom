CREATE DATABASE  IF NOT EXISTS `alarm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `alarm`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: alarm
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `logins`
--

DROP TABLE IF EXISTS `logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logins` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logins`
--

LOCK TABLES `logins` WRITE;
/*!40000 ALTER TABLE `logins` DISABLE KEYS */;
INSERT INTO `logins` VALUES (1,'admin','$2a$10$fNE1GorgUbwvZgK1W53eJO/WiRdx71DasXI7fDujG6.M0qdSm9VI6'),(2,'user','$2a$10$Qyei24x9rkp49BIgSRiEQOH4f2oW5y4alQ3TDV0kdMx9XVuvrOdgG');
/*!40000 ALTER TABLE `logins` ENABLE KEYS */;
UNLOCK TABLES;
-- login:password admin:300 user:100
--
-- Table structure for table `logins_roles`
--

DROP TABLE IF EXISTS `logins_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logins_roles` (
  `logins_id` int NOT NULL,
  `roles_id` int NOT NULL,
  KEY `FKsu8gnhd7c3ohfpu1urcfdms7l` (`roles_id`),
  KEY `FK4mt26hr955gmb4lcb37xmj2cv` (`logins_id`),
  CONSTRAINT `FK4mt26hr955gmb4lcb37xmj2cv` FOREIGN KEY (`logins_id`) REFERENCES `logins` (`id`),
  CONSTRAINT `FKsu8gnhd7c3ohfpu1urcfdms7l` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logins_roles`
--

LOCK TABLES `logins_roles` WRITE;
/*!40000 ALTER TABLE `logins_roles` DISABLE KEYS */;
INSERT INTO `logins_roles` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `logins_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `answer_origin` varchar(255) DEFAULT NULL,
  `answers` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `end` datetime(6) DEFAULT NULL,
  `start` datetime(6) DEFAULT NULL,
  `tickets` varchar(255) DEFAULT NULL,
  `users_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6yk22ibxwjemokxuoe2qtd02k` (`users_id`),
  CONSTRAINT `FK6yk22ibxwjemokxuoe2qtd02k` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `id` int NOT NULL,
  `answer1` varchar(255) DEFAULT NULL,
  `answer2` varchar(255) DEFAULT NULL,
  `answer3` varchar(255) DEFAULT NULL,
  `answer4` varchar(255) DEFAULT NULL,
  `answer_origin` int NOT NULL,
  `question` tinytext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,'1','2','3','4',4,'сколько будет  2+2'),
(2,'2','3','4','5',4,'сколько будет 2+3'),(3,'4','5','6','7',3,'сколько будет 2+4'),
(4,'5','6','7','8',3,'сколько будет 2+5'),(5,'7','8','9','10',2,'сколько будет 2+6'),
(6,'7','8','9','10',3,'сколько будет 2+7'),(7,'10','11','12','13',1,'сколько будет 2+8'),
(8,'10','11','12','13',2,'сколько будет 2+9'),(9,'11','12','13','14',2,'сколько будет 2+10'),
(10,'12','13','14','15',2,'сколько будет 2+11'),(11,'11','12','13','14',4,'сколько будет 2+12'),
(12,'15','16','17','18',1,'сколько будет 2+13'),(13,'15','16','17','18',2,'сколько будет 2+14'),
(14,'16','17','18','19',2,'сколько будет 2+15'),(15,'16','17','18','19',3,'сколько будет 2+16'),
(16,'16','17','18','19',4,'сколько будет 2+17'),(17,'18','19','20','21',3,'сколько будет 2+18'),
(18,'20','21','22','23',2,'сколько будет 2+19'),(19,'21','22','23','24',2,'сколько будет 2+20'),
(20,'23','24','25','26',1,'сколько будет 2+21'),(21,'24','25','27','28',1,'сколько будет 2+22'),
(22,'24','25','26','27',2,'сколько будет 2+23'),(23,'25','26','27','28',2,'сколько будет 2+24'),
(24,'25','26','27','28',3,'сколько будет 2+25'),(25,'25','26','27','28',4,'сколько будет 2+26'),
(26,'27','28','29','30',3,'сколько будет 2+27'),(27,'30','31','32','33',1,'сколько будет 2+28'),
(28,'30','31','32','33',2,'сколько будет 2+29'),(29,'31','32','33','34',2,'сколько будет 2+30'),
(30,'31','32','33','34',3,'сколько будет 2+31');
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `registration` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-01 12:27:47
