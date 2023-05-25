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
INSERT INTO `my_plan_order` VALUES (57,0,'도곡시장','서울특별시 강남구 선릉로 311','',0),(57,1,'헬레나 홈스테이','서울특별시 강남구 도곡로93길 12','http://tong.visitkorea.or.kr/cms/resource/69/2612169_image2_1.jpg',3.8),(58,0,'금강제화 (강남본점)','서울특별시 강남구 강남대로 500','http://tong.visitkorea.or.kr/cms/resource/10/1309110_image2_1.jpg',0),(58,1,'도곡시장','서울특별시 강남구 선릉로 311','',8.1),(59,0,'예본의 집[한국관광 품질인증/Korea Quality]','서울특별시 강남구 개포로118길 64','http://tong.visitkorea.or.kr/cms/resource/08/2557408_image2_1.jpg',0),(59,1,'도곡시장','서울특별시 강남구 선릉로 311','',8.7),(60,0,'아로마티카 제로스테이션','서울특별시 강남구 도산대로1길 62','',0),(60,1,'예본의 집[한국관광 품질인증/Korea Quality]','서울특별시 강남구 개포로118길 64','http://tong.visitkorea.or.kr/cms/resource/08/2557408_image2_1.jpg',19.3),(61,0,'도곡시장','서울특별시 강남구 선릉로 311','',0),(61,1,'더클라임','서울특별시 강남구 남부순환로 2615','',5.9),(61,2,'[서울둘레길 4코스] 대모·우면산코스','서울특별시 강남구 광평로 지하 270','http://tong.visitkorea.or.kr/cms/resource/27/893827_image2_1.jpg',17.5),(62,0,'오르시아','서울특별시 강남구 선릉로131길 12','',0),(62,1,'강남스테이힐(Gangnam Stay Hill)','서울특별시 강남구 테헤란로13길 65','http://tong.visitkorea.or.kr/cms/resource/28/2573328_image2_1.jpg',4.9),(62,2,'도곡시장','서울특별시 강남구 선릉로 311','',7.8),(63,0,'라트어린이극장','서울특별시 강남구 논현로 164','http://tong.visitkorea.or.kr/cms/resource/27/1865327_image2_1.jpg',0),(63,1,'갤러리 서림','서울특별시 강남구 학동로 523','http://tong.visitkorea.or.kr/cms/resource/32/1837332_image2_1.jpg',4.2),(63,2,'[서울둘레길 4코스] 대모·우면산코스','서울특별시 강남구 광평로 지하 270','http://tong.visitkorea.or.kr/cms/resource/27/893827_image2_1.jpg',13187.5),(63,3,'강태분 할머니묵집','대전광역시 유성구 금남구즉로 1378','http://tong.visitkorea.or.kr/cms/resource/96/1023896_image2_1.jpg',13258.4),(64,0,'방천시장','대구광역시 중구 달구벌대로446길','http://tong.visitkorea.or.kr/cms/resource/03/2668203_image2_1.jpg',0),(64,1,'남문시장','대구광역시 중구 명륜로 70','',1.3),(65,0,'아현시장','서울특별시 마포구 굴레방로9길 11','http://tong.visitkorea.or.kr/cms/resource/19/2779719_image2_1.jpg',0),(65,1,'프레젠트모먼트','서울특별시 마포구 동교로 49-1','http://tong.visitkorea.or.kr/cms/resource/91/2785791_image2_1.JPG',49.9),(65,2,'길정 낚시터','인천광역시 강화군 양도면 고려왕릉로 209','',157540.4),(65,3,'창후항수산물직판장','인천광역시 강화군 하점면 창후로 311','http://tong.visitkorea.or.kr/cms/resource/59/2791359_image2_1.jpg',183.9),(66,0,'다다르다','대전광역시 중구 중교로73번길 6','',0),(66,1,'문창시장','대전광역시 중구 문창로10번길 38','',1.6),(67,0,'뿌리공원캠핑장','대전광역시 중구 뿌리공원로 47','http://tong.visitkorea.or.kr/cms/resource/51/2753251_image2_1.jpg',0),(67,1,'문창시장','대전광역시 중구 문창로10번길 38','',5.8),(67,2,'학선식당','대전광역시 중구 보문로337번길 26','',2.7),(68,0,'우산월곡시장','광주광역시 광산구 사암로 300','',0),(68,1,'호텔 오노마 (대전 오토그래프 컬렉션 호텔)','대전광역시유성구 도룡동 3-1','',13261.6),(69,0,'하기숲 가족캠핑장','대전광역시 유성구 하기동 259','http://tong.visitkorea.or.kr/cms/resource/45/2794145_image2_1.jpg',0),(70,0,'도곡시장','서울특별시 강남구 선릉로 311','',0),(70,1,'헬레나 홈스테이','서울특별시 강남구 도곡로93길 12','http://tong.visitkorea.or.kr/cms/resource/69/2612169_image2_1.jpg',13183.9),(71,0,'대신샹제리제 휘트니스클럽(실내수영장)','서울특별시 강남구 테헤란로 406','http://tong.visitkorea.or.kr/cms/resource/19/2024219_image2_1.jpg',0),(71,1,'여수오동도 대치','서울특별시 강남구 삼성로71길 7','http://tong.visitkorea.or.kr/cms/resource/66/2684566_image2_1.jpg',0.8),(71,2,'청담패션거리','서울특별시 강남구 청담동','http://tong.visitkorea.or.kr/cms/resource/82/2728682_image2_1.jpg',13181.2),(71,3,'강동그린웨이 가족캠핑장','서울특별시 강동구 천호대로206길 87','http://tong.visitkorea.or.kr/cms/resource/69/2030469_image2_1.jpg',39568.2),(71,4,'둔촌역전통시장','서울특별시 강동구 풍성로58길 34','',5.7),(72,0,'영등포청과시장','서울특별시 영등포구 영신로41길 5-1','http://tong.visitkorea.or.kr/cms/resource/92/2779892_image2_1.png',0),(72,1,'화사랑화로구이 문래점','서울특별시 영등포구 선유로9가길 16 광양림빌딩','http://tong.visitkorea.or.kr/cms/resource/24/2855224_image2_1.jpg',0),(72,2,'신길동매운짬뽕','서울특별시 영등포구 영등포로62길 10-1','http://tong.visitkorea.or.kr/cms/resource/31/2852631_image2_1.jpg',0),(72,3,'도곡시장','서울특별시 강남구 선릉로 311','',0),(72,4,'도곡시장','서울특별시 강남구 선릉로 311','',0),(73,0,'세브도르 (Cep D\'or)','서울특별시 강남구 언주로 431','http://tong.visitkorea.or.kr/cms/resource/45/1926445_image2_1.jpg',0),(74,0,'도곡시장','서울특별시 강남구 선릉로 311','',0),(74,1,'세브도르 (Cep D\'or)','서울특별시 강남구 언주로 431','http://tong.visitkorea.or.kr/cms/resource/45/1926445_image2_1.jpg',0),(74,2,'은곡마을공원','서울 강남구 세곡동 369-3','',0),(74,3,'예본의 집[한국관광 품질인증/Korea Quality]','서울특별시 강남구 개포로118길 64','http://tong.visitkorea.or.kr/cms/resource/08/2557408_image2_1.jpg',0),(75,0,'더 비 (The B)','서울특별시 종로구 인사동길 44','',0),(75,1,'도곡시장','서울특별시 강남구 선릉로 311','',0),(76,0,'옥토끼우주센터','인천광역시 강화군 불은면 강화동로 403','http://tong.visitkorea.or.kr/cms/resource/71/1575771_image2_1.jpg',0),(76,1,'광성보','인천광역시 강화군 불은면 해안동로466번길 27','http://tong.visitkorea.or.kr/cms/resource/82/2363682_image2_1.jpg',4),(76,2,'야콘냉면본가집','인천광역시 강화군 양도면 정문길26번길 15','http://tong.visitkorea.or.kr/cms/resource/37/1901237_image2_1.jpg',13129),(77,0,'자이언트 호텔','서울특별시 강남구 봉은사로 459','http://tong.visitkorea.or.kr/cms/resource/98/1867598_image2_1.jpg',0),(77,1,'헬레나 홈스테이','서울특별시 강남구 도곡로93길 12','http://tong.visitkorea.or.kr/cms/resource/69/2612169_image2_1.jpg',5.5),(78,0,'경주별빛마루글램핑장과펜션','경상북도 경주시 천북면 새터흥림길 1-75','http://tong.visitkorea.or.kr/cms/resource/98/2726798_image2_1.jpg',0),(78,1,'월성원자력홍보관','경상북도 경주시 문무대왕면 불국로 1655','http://tong.visitkorea.or.kr/cms/resource/83/2753383_image2_1.jpg',16.5),(78,2,'감포공설시장(3, 8일)','경상북도 경주시 감포읍 감포로 115','http://tong.visitkorea.or.kr/cms/resource/28/2757128_image2_1.jpg',10.2),(78,3,'Cafe.803','경상북도 경산시 갓바위로 550','http://tong.visitkorea.or.kr/cms/resource/03/2840703_image2_1.jpg',160695.5),(79,0,'하양꿈바우시장/하양장 (4, 9일)','경상북도 경산시 하양읍 대학로 1543','http://tong.visitkorea.or.kr/cms/resource/54/1969054_image2_1.jpg',0);
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

-- Dump completed on 2023-05-25 22:29:47
