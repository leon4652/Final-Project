-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
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
-- Table structure for table `story_board`
--

DROP TABLE IF EXISTS `story_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `story_board` (
  `story_board_no` int NOT NULL AUTO_INCREMENT,
  `story_board_hit` int DEFAULT '0',
  `story_board_title` varchar(30) DEFAULT NULL,
  `story_board_content` blob,
  `story_board_like` int DEFAULT '0',
  `user_no` int DEFAULT NULL,
  `comment_count` int DEFAULT '0',
  `regist_date` timestamp NULL DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `remove_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`story_board_no`),
  KEY `fk_user_user_id_idx` (`user_no`),
  CONSTRAINT `fk_user_user_id_story_board` FOREIGN KEY (`user_no`) REFERENCES `user` (`user_no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `story_board`
--

LOCK TABLES `story_board` WRITE;
/*!40000 ALTER TABLE `story_board` DISABLE KEYS */;
INSERT INTO `story_board` VALUES (1,2,'test입니다',_binary 'test입니다',0,3,0,'2023-05-15 07:04:35',NULL,NULL),(2,0,'test입니다',_binary 'test입니다',0,3,0,'2023-05-15 07:04:58',NULL,NULL),(3,0,'test입니다',_binary 'test입니다',0,3,0,'2023-05-15 07:04:58',NULL,NULL),(4,5,'test입니다',_binary 'test입니다',0,3,0,'2023-05-15 07:04:59',NULL,NULL),(5,0,'타이틀1234555',_binary '수정한 텍스트입니다',0,3,0,'2023-05-15 07:16:06',NULL,'2023-05-15 07:21:58'),(6,3,'asd',_binary 'asd',0,8,0,'2023-05-23 06:15:49',NULL,NULL),(7,1,'테스트 글입니다',_binary 'ㅎㅎ',0,3,0,'2023-05-25 13:28:24',NULL,NULL),(8,0,'오늘 강호띠 회식',_binary '안간다고 할 뻔~',0,3,0,'2023-05-25 13:28:50',NULL,NULL),(9,0,'테스트입니다',_binary '테스트입니다',0,7,0,'2023-05-25 14:02:52',NULL,NULL),(10,3,'글 작성 가능',_binary '로그인했으니까~',0,7,0,'2023-05-25 14:04:21',NULL,NULL);
/*!40000 ALTER TABLE `story_board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26  1:52:04
