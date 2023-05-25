-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: enjoytrip
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `my_plan`
--

DROP TABLE IF EXISTS `my_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_plan` (
  `my_plan_no` int NOT NULL AUTO_INCREMENT,
  `trip_title` varchar(45) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `user_no` varchar(45) DEFAULT NULL,
  `my_plan_like` int DEFAULT '0',
  `my_plan_hit` int DEFAULT '0',
  `my_plan_regist_date` varchar(45) DEFAULT NULL,
  `trip_content` blob,
  PRIMARY KEY (`my_plan_no`),
  KEY `fk_user_id_my_plan_from_user_idx` (`user_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_user_id_my_plan_from_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_plan`
--

LOCK TABLES `my_plan` WRITE;
/*!40000 ALTER TABLE `my_plan` DISABLE KEYS */;
INSERT INTO `my_plan` VALUES (44,'나만의 여행 계획!','ssafy','4',0,0,'2023-05-24 15:03:36',NULL),(45,'나만의 여행 계획!','ssafy','4',0,0,'2023-05-24 16:42:29',NULL),(46,'나만의 여행 계획!','ssafy','4',0,0,'2023-05-24 16:56:52',NULL),(47,'나만의 여행 계획!','ssafy','4',0,0,'2023-05-24 17:04:01',NULL),(48,'박정희','ssafy','4',0,0,'2023-05-24 17:19:59',NULL),(49,'나만의 여행 계획!','ssafy','4',0,0,'2023-05-24 17:20:22',NULL),(50,'나만의 여행 계획!','1','9',0,0,'2023-05-24 22:16:21',NULL),(51,'나만의 여행 계획!','1','9',0,0,'2023-05-24 22:17:30',NULL),(52,'나만의 여행 계획!','1','9',0,0,'2023-05-24 22:20:16',_binary '내용을 입력하세요.'),(53,'나만의 여행 계획!','1','9',0,0,'2023-05-24 22:24:41',_binary '내용을 입력하세요.'),(54,'나만의 여행 계획!','1','9',0,0,'2023-05-25 01:26:19',_binary '거리계산 되네용'),(55,'나만의 여행 계획!','1','9',0,0,'2023-05-25 01:29:05',_binary 'ㅁㄴㅇㅁㄴㅇ'),(56,'나만의 여행 계획!','1','9',0,0,'2023-05-25 01:29:57',_binary '1111111111');
/*!40000 ALTER TABLE `my_plan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-25  1:31:26
