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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_no` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `user_pw` varchar(255) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `email0` varchar(45) DEFAULT NULL,
  `email1` varchar(45) DEFAULT NULL,
  `sido` int DEFAULT NULL,
  `gugun` int DEFAULT NULL,
  `birth_year` int DEFAULT NULL,
  `birth_month` int DEFAULT NULL,
  `birth_date` int DEFAULT NULL,
  `regist_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NULL DEFAULT NULL,
  `remove_date` timestamp NULL DEFAULT NULL,
  `is_admin` tinyint DEFAULT '0',
  PRIMARY KEY (`user_no`,`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'ssafy1','1234','ssafy','ssafy@ssafy.com',NULL,NULL,NULL,NULL,NULL,NULL,'2023-05-12 07:16:01',NULL,NULL,0),(4,'ssafy','1234','최싸피',NULL,NULL,36,15,1970,1,1,'2023-05-19 07:25:08',NULL,NULL,0),(5,'test1','1234','김김김',NULL,NULL,3,3,2023,5,23,'2023-05-19 07:26:53',NULL,NULL,0),(6,'test123','1234','12345','1234',NULL,37,12,2023,5,10,'2023-05-19 07:27:39',NULL,NULL,0),(7,'songkey','1234','테스트','asd@ssafy.com',NULL,36,17,2023,5,10,'2023-05-19 08:07:22','2023-05-19 08:26:50',NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-23 15:12:05
