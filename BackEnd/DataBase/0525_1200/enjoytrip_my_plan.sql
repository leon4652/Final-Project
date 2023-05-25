-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: enjoytrip
-- ------------------------------------------------------
-- Server version	8.0.32

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
  `user_id` varchar(45) NOT NULL,
  `user_no` varchar(45) NOT NULL,
  `my_plan_like` int DEFAULT '0',
  `my_plan_hit` int DEFAULT '0',
  `my_plan_regist_date` varchar(45) DEFAULT NULL,
  `trip_content` blob,
  `sido_code` int NOT NULL,
  `gugun_code` int NOT NULL,
  PRIMARY KEY (`my_plan_no`),
  KEY `fk_user_id_my_plan_from_user_idx` (`user_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_user_id_my_plan_from_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_plan`
--

LOCK TABLES `my_plan` WRITE;
/*!40000 ALTER TABLE `my_plan` DISABLE KEYS */;
INSERT INTO `my_plan` VALUES (58,'나만의 여행 계획!','1','9',0,0,'2023-05-25 10:20:37',_binary '내용을 입력하세요.',1,1),(59,'나만의 여행 계획!2','1','9',0,0,'2023-05-25 11:43:39',_binary '내용을 입력하세요.',1,1),(60,'3333','1','9',0,0,'2023-05-25 11:45:41',_binary '내용을 입력하세요.',1,1),(61,'444','1','9',0,0,'2023-05-25 11:45:51',_binary 'ㅁㄴㅇㅁㄴㅇㅁㄴ',1,1),(62,'나만의 여행 계획!','1','9',0,0,'2023-05-25 11:46:02',_binary '내용을 입력하세요.',1,1),(63,'나만의 여행 계획!','1','9',0,0,'2023-05-25 11:47:16',_binary '내용을 입력하세요.',3,4);
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

-- Dump completed on 2023-05-25 12:00:07
