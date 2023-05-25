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
-- Table structure for table `my_plan_order`
--

DROP TABLE IF EXISTS `my_plan_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_plan_order` (
  `my_plan_no` int DEFAULT NULL,
  `idx` int DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `addr1` varchar(100) DEFAULT NULL,
  `first_image` varchar(300) DEFAULT NULL,
  `expect_time` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_plan_order`
--

LOCK TABLES `my_plan_order` WRITE;
/*!40000 ALTER TABLE `my_plan_order` DISABLE KEYS */;
INSERT INTO `my_plan_order` VALUES (57,0,'도곡시장','서울특별시 강남구 선릉로 311','',0),(57,1,'헬레나 홈스테이','서울특별시 강남구 도곡로93길 12','http://tong.visitkorea.or.kr/cms/resource/69/2612169_image2_1.jpg',3.8),(58,0,'금강제화 (강남본점)','서울특별시 강남구 강남대로 500','http://tong.visitkorea.or.kr/cms/resource/10/1309110_image2_1.jpg',0),(58,1,'도곡시장','서울특별시 강남구 선릉로 311','',8.1),(59,0,'예본의 집[한국관광 품질인증/Korea Quality]','서울특별시 강남구 개포로118길 64','http://tong.visitkorea.or.kr/cms/resource/08/2557408_image2_1.jpg',0),(59,1,'도곡시장','서울특별시 강남구 선릉로 311','',8.7),(60,0,'아로마티카 제로스테이션','서울특별시 강남구 도산대로1길 62','',0),(60,1,'예본의 집[한국관광 품질인증/Korea Quality]','서울특별시 강남구 개포로118길 64','http://tong.visitkorea.or.kr/cms/resource/08/2557408_image2_1.jpg',19.3),(61,0,'도곡시장','서울특별시 강남구 선릉로 311','',0),(61,1,'더클라임','서울특별시 강남구 남부순환로 2615','',5.9),(61,2,'[서울둘레길 4코스] 대모·우면산코스','서울특별시 강남구 광평로 지하 270','http://tong.visitkorea.or.kr/cms/resource/27/893827_image2_1.jpg',17.5),(62,0,'오르시아','서울특별시 강남구 선릉로131길 12','',0),(62,1,'강남스테이힐(Gangnam Stay Hill)','서울특별시 강남구 테헤란로13길 65','http://tong.visitkorea.or.kr/cms/resource/28/2573328_image2_1.jpg',4.9),(62,2,'도곡시장','서울특별시 강남구 선릉로 311','',7.8),(63,0,'라트어린이극장','서울특별시 강남구 논현로 164','http://tong.visitkorea.or.kr/cms/resource/27/1865327_image2_1.jpg',0),(63,1,'갤러리 서림','서울특별시 강남구 학동로 523','http://tong.visitkorea.or.kr/cms/resource/32/1837332_image2_1.jpg',4.2),(63,2,'[서울둘레길 4코스] 대모·우면산코스','서울특별시 강남구 광평로 지하 270','http://tong.visitkorea.or.kr/cms/resource/27/893827_image2_1.jpg',13187.5),(63,3,'강태분 할머니묵집','대전광역시 유성구 금남구즉로 1378','http://tong.visitkorea.or.kr/cms/resource/96/1023896_image2_1.jpg',13258.4);
/*!40000 ALTER TABLE `my_plan_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-25 12:00:06
