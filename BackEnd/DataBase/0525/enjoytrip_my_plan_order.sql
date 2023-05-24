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
INSERT INTO `my_plan_order` VALUES (49,0,'동화상가','서울특별시 중구 장충단로13길 34','',0),(49,1,'더벨스파 동대문현대시티아울렛점','서울특별시 중구 장충단로13길 20','http://tong.visitkorea.or.kr/cms/resource/06/2796106_image2_1.jpg',0),(50,0,'계산시장','인천광역시 계양구 계산동 1040','http://tong.visitkorea.or.kr/cms/resource/30/2780930_image2_1.jpg',0),(50,1,'계산국민체육센터','인천광역시 계양구 주부토로 580','http://tong.visitkorea.or.kr/cms/resource/77/2461877_image2_1.jpg',0),(50,2,'이학갈비','인천광역시 계양구 계산새로 1','http://tong.visitkorea.or.kr/cms/resource/93/2836993_image2_1.jpg',0),(50,3,'갤럭시호텔','인천광역시 계양구 계양문화로53번길 8','http://tong.visitkorea.or.kr/cms/resource/22/1832022_image2_1.JPG',0),(50,4,'부평향교','인천광역시 계양구 향교로 19','http://tong.visitkorea.or.kr/cms/resource/41/1577341_image2_1.jpg',0),(50,5,'부평향교','인천광역시 계양구 향교로 19','http://tong.visitkorea.or.kr/cms/resource/41/1577341_image2_1.jpg',0),(51,0,'부평향교','인천광역시 계양구 향교로 19','http://tong.visitkorea.or.kr/cms/resource/41/1577341_image2_1.jpg',0),(51,1,'계산시장','인천광역시 계양구 계산동 1040','http://tong.visitkorea.or.kr/cms/resource/30/2780930_image2_1.jpg',0),(52,0,'유진참치','인천광역시 계양구 아나지로 466','',0),(52,1,'계양산전통시장','인천광역시 계양구 계양산로215번길 10','http://tong.visitkorea.or.kr/cms/resource/34/2780934_image2_1.jpg',0),(53,0,'작전시장','인천광역시 계양구 봉오대로677번길 26','http://tong.visitkorea.or.kr/cms/resource/50/2780950_image2_1.png',0),(54,0,'에머슨 골프클럽','충청북도 진천군 백곡면 배티로 818-105','http://tong.visitkorea.or.kr/cms/resource/66/1596966_image2_1.jpg',0),(54,1,'생거진천 자연휴양림','충청북도 진천군 백곡면 명암길 435-135','http://tong.visitkorea.or.kr/cms/resource/90/2769790_image2_1.jpg',5),(54,2,'진천 산수리와 삼용리 요지','충청북도 진천군 이월면 삼용리','http://tong.visitkorea.or.kr/cms/resource/71/1330171_image2_1.jpg',7),(55,0,'생거진천 자연휴양림','충청북도 진천군 백곡면 명암길 435-135','http://tong.visitkorea.or.kr/cms/resource/90/2769790_image2_1.jpg',0),(55,1,'성림사(진천)','충청북도 진천군 덕산면 인화길 83','http://tong.visitkorea.or.kr/cms/resource/63/214063_image2_1.jpg',10),(55,2,'진천 이영남 묘소','충청북도 진천군 덕산읍 기전리','http://tong.visitkorea.or.kr/cms/resource/50/1332550_image2_1.jpg',4),(55,3,'진천 금성대군 사당','충청북도 진천군 초평면 수의1길 75-7','',10),(56,0,'진천 산수리와 삼용리 요지','충청북도 진천군 이월면 삼용리','http://tong.visitkorea.or.kr/cms/resource/71/1330171_image2_1.jpg',0),(56,1,'영수사(진천)','충청북도 진천군 초평면 영구리길 60-125','',10.4),(56,2,'진천 정송강사','충청북도 진천군 문백면 송강로 523','http://tong.visitkorea.or.kr/cms/resource/25/1332625_image2_1.jpg',13.17);
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

-- Dump completed on 2023-05-25  1:31:27
