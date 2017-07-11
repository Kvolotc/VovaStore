-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vovastore
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `bikes`
--

DROP TABLE IF EXISTS `bikes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bikes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `brake_id` int(11) DEFAULT NULL,
  `fork_id` int(11) DEFAULT NULL,
  `frame_id` int(11) DEFAULT NULL,
  `rim_id` int(11) DEFAULT NULL,
  `tire_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_faeyjdmeke33ilvcrsy5qpqcw` (`frame_id`),
  KEY `FKijjaqiubbikdi58mqsjvgualc` (`brake_id`),
  KEY `FKsmxvc1n40wbxa7l2jlxf4md86` (`fork_id`),
  KEY `FK6q29p3h7rmfrxkwd6cs43ql51` (`rim_id`),
  KEY `FKdvict68qjc0prymtjc7329yk2` (`tire_id`),
  CONSTRAINT `FK6q29p3h7rmfrxkwd6cs43ql51` FOREIGN KEY (`rim_id`) REFERENCES `rims` (`id`),
  CONSTRAINT `FK6yuacigp5dqfvvt3uliqwvhec` FOREIGN KEY (`frame_id`) REFERENCES `frames` (`id`),
  CONSTRAINT `FKdvict68qjc0prymtjc7329yk2` FOREIGN KEY (`tire_id`) REFERENCES `tires` (`id`),
  CONSTRAINT `FKijjaqiubbikdi58mqsjvgualc` FOREIGN KEY (`brake_id`) REFERENCES `brakes` (`id`),
  CONSTRAINT `FKsmxvc1n40wbxa7l2jlxf4md86` FOREIGN KEY (`fork_id`) REFERENCES `forks` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bikes`
--

LOCK TABLES `bikes` WRITE;
/*!40000 ALTER TABLE `bikes` DISABLE KEYS */;
INSERT INTO `bikes` VALUES (1,'Giant FASTROAD SLR.jpg',1500,1,1,1,1,1),(2,'Cube AXIAL WLS GTC PRO.jpg',1800,2,2,2,2,2),(3,'Comanche STRADA PRO.jpg',500,3,3,3,3,3),(4,'Cube AIM PRO.jpg',600,4,4,4,4,4),(5,'Cube ANALOG 29.jpg',800,5,5,5,5,5),(6,'Giant TALON 1.jpg',2000,6,6,6,6,6),(7,'Giant XTC 2 26.jpg',1100,7,7,7,7,7),(8,'Ghost SE 5000.jpg',900,5,8,8,8,8),(9,'Ghost ASX 4900.jpg',1500,9,9,9,9,9),(10,'Ghost RT Actinum 5900.jpg',2300,10,10,10,10,10),(11,'Specialized\'s Demo 8.jpg',4500,11,11,11,11,11),(12,'Enduro FSR Comp.jpg',3500,12,12,12,12,12),(13,'FORCE CARBON PRO SRAM.jpg',6000,13,13,13,13,13),(14,'SENSOR CARBON PRO.jpg',7500,14,14,14,14,14),(15,'SANCTION EXPERT.jpg',4000,15,15,15,15,13);
/*!40000 ALTER TABLE `bikes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brakes`
--

DROP TABLE IF EXISTS `brakes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brakes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` int(11) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brakes`
--

LOCK TABLES `brakes` WRITE;
/*!40000 ALTER TABLE `brakes` DISABLE KEYS */;
INSERT INTO `brakes` VALUES (1,2016,'Tektro HDC-M290.jpg','HDC-M290',50,'TEKTRO','HYDRAULICS'),(2,2017,'Shimano 105 BR-5800.jpg','105 BR-5800',90,'SHIMANO','CLOVER'),(3,2015,'TEKTRO R-325.jpg','R-325',40,'TEKTRO','CLOVER'),(4,2016,'Tektro HD-M290.jpg','HD-M290',60,'TEKTRO','HYDRAULICS'),(5,2017,'Shimano BR-M315.jpg','BR-M315',65,'SHIMANO','HYDRAULICS'),(6,2017,'Shimano M395.jpg','M395',90,'SHIMANO','HYDRAULICS'),(7,2017,'Shimano M446.jpg','M446',70,'SHIMANO','HYDRAULICS'),(9,2016,'Tektro HDC 330.jpg','HDC 330',75,'TEKTRO','HYDRAULICS'),(10,2017,'Shimano 596.jpg','596',85,'SHIMANO','HYDRAULICS'),(11,2013,'Avid Code X0.jpg','Code X0',160,'AVID','HYDRAULICS'),(12,2017,'Shimano Deore BR-M615.jpg','Deore BR-M615',180,'SHIMANO','HYDRAULICS'),(13,2017,'SRAM Guide RS.jpg','Guide RS',190,'SRAM','HYDRAULICS'),(14,2017,'Shimano Deore XT M8000.jpg','Deore XT M8000',350,'SHIMANO','HYDRAULICS'),(15,2017,'SRAM Guide R G2.jpg','Guide R G2',250,'SRAM','HYDRAULICS');
/*!40000 ALTER TABLE `brakes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forks`
--

DROP TABLE IF EXISTS `forks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` int(11) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forks`
--

LOCK TABLES `forks` WRITE;
/*!40000 ALTER TABLE `forks` DISABLE KEYS */;
INSERT INTO `forks` VALUES (1,2016,'ALUXX OverDrive.jpg','Steerer',100,'ALUXX ','0','HARD'),(2,2017,'CUBE CSL Race.jpg','CSL Race',1800,'CUBE','0','HARD'),(3,2015,'Comanche.jpg','CRC',70,'COMANCHE','0','HARD'),(4,2016,'SR Suntour XCT.jpg','XCT',70,'SR_SUNTOUR','100','SPRING'),(5,2017,'Rock Shox XC 30.jpg','XC 30',75,'ROCKSHOCK','100','COIL'),(6,2017,'Rock Shox Reba RL.jpg','Reba RL',160,'ROCKSHOCK','100','AIR'),(7,2017,'RockShox Recon Silver TK.jpg','Recon Silver TK',100,'ROCKSHOCK','100','AIR'),(8,2017,'First 32.jpg','First 32',90,'RST','100','AIR'),(9,2016,'RST Aerial Air RLO.jpg','Aerial Air RLO',140,'RST','130','AIR'),(10,2017,'FOX Forx 32F Air RL.jpg','Forx 32F Air',200,'FOX','100','AIR'),(11,1013,'RockShox Boxxer.jpg','Boxxer',330,'ROCKSHOCK','200','AIR'),(12,2017,'RockShox Pike RC 29.jpg','Pike RC 29',280,'ROCKSHOCK','160','AIR'),(13,2017,'RockShox Pike RCT3 Boost.jpg','Pike RCT3 Boost',300,'ROCKSHOCK','160','AIR'),(14,2017,'Fox Factory 34 Float 27.5.jpg','Factory 34 Float 27.5',430,'FOX','140','AIR'),(15,2017,'RockShox Yari RC Boost.jpg','Yari RC Boost',320,'ROCKSHOCK','170','AIR');
/*!40000 ALTER TABLE `forks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frames`
--

DROP TABLE IF EXISTS `frames`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frames` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` int(11) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `alloy` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `is_exist_snubber` bit(1) DEFAULT NULL,
  `brand_snubber` varchar(255) DEFAULT NULL,
  `course_snubber` varchar(255) DEFAULT NULL,
  `type_snubber` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `model_snubber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frames`
--

LOCK TABLES `frames` WRITE;
/*!40000 ALTER TABLE `frames` DISABLE KEYS */;
INSERT INTO `frames` VALUES (1,2016,'ALUXX SLR-Grade.jpg','ALUXX SLR-Grade',90,'ALUMINUM','GIANT','\0',NULL,NULL,NULL,'RACING',NULL),(2,2017,'GTC Monocoque.jpg','GTC Monocoque',250,'CARBON','CUBE','\0',NULL,NULL,NULL,'RACING',NULL),(3,2015,'Comanche.jpg','CY-5',60,'ALUMINUM','COMANCHE','\0',NULL,NULL,NULL,'RACING',NULL),(4,2016,'Cube AIM PRO.jpg','AIM PRO  AMF-27',75,'ALUMINUM','CUBE','\0',NULL,NULL,NULL,'MOUNTAIN',NULL),(5,2017,'Aluminium Lite, AMF.jpg','ANALOG 29 AMF-29',75,'ALUMINUM','CUBE','\0',NULL,NULL,NULL,'MOUNTAIN',NULL),(6,2017,'Giant TALON 1.jpg','TALON 1',110,'ALUMINUM','GIANT','\0',NULL,NULL,NULL,'MOUNTAIN',NULL),(7,2017,'Giant XTC 2.jpg','XTC 2',90,'ALUMINUM','GIANT','\0',NULL,NULL,NULL,'MOUNTAIN',NULL),(8,2017,'Ghost SE 5000.jpg','SE 5000',80,'ALUMINUM','GHOST','\0',NULL,NULL,NULL,'MOUNTAIN',NULL),(9,2016,'Ghost ASX 4900.jpg','ASX 4900',180,'ALUMINUM','GHOST','','X_FUSION','120','AIR','ALL_MOUNTAIN','E1 RL'),(10,2017,'Ghost RT Actinum 5900 56.jpg','RT Actinum',220,'ALUMINUM','GHOST','','FOX','100','AIR','ALL_MOUNTAIN','Float RL'),(11,2013,'The Demo 8 Carbon.jpg','Demo 8 Team Replica',330,'CARBON','SPECIALIZED','','ROCKSHOCK','200','SPRING','ALL_MOUNTAIN','DHX RC4'),(12,2017,'Specialized Enduro FSR Comp.jpg','Enduro FSR Comp ',280,'ALUMINUM','SPECIALIZED','','ROCKSHOCK','165','AIR','ALL_MOUNTAIN','FSR'),(13,2017,'FORCE CARBON PRO SRAM.jpg','FORCE CARBON PRO',340,'CARBON','GT','','ROCKSHOCK','150','AIR','ALL_MOUNTAIN','Monarch PLUS'),(14,2017,'SENSOR CARBON PRO.jpg','SENSOR CARBON PRO',440,'CARBON','GT','','FOX','130','AIR','ALL_MOUNTAIN','Racing Shox'),(15,2017,'SANCTION EXPERT.jpg','SANCTION EXPERT',320,'ALUMINUM','GT','','ROCKSHOCK','160','AIR','ALL_MOUNTAIN','Monarch R');
/*!40000 ALTER TABLE `frames` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_products` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contry` varchar(255) DEFAULT NULL,
  `date_of_purchase` datetime DEFAULT NULL,
  `new_post` int(11) DEFAULT NULL,
  `type_of_payment` varchar(255) DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `sum_purchase` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`),
  CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rims`
--

DROP TABLE IF EXISTS `rims`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rims` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` int(11) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `diameter` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rims`
--

LOCK TABLES `rims` WRITE;
/*!40000 ALTER TABLE `rims` DISABLE KEYS */;
INSERT INTO `rims` VALUES (1,2016,'Giant S-R2.jpg','S-R2',35,'GIANT',28,'SINGLE_WALLED_HIGH'),(2,2017,'Alexrims Race28.jpg','Race28',80,'ALEXRIMS',28,'SINGLE_WALLED_HIGH'),(3,2015,'ALEX R450.jpg','R450',25,'ALEXRIMS',28,'SINGLE_WALLED_HIGH'),(4,2016,'Cube SX, Disc.jpg','SX',28,' CUBE',27.5,'DOUBLE_WALLED'),(5,2017,'CUBE ZX20.jpg','ZX20',30,'CUBE',29,'DOUBLE_WALLED'),(6,2017,'Giant S-XC2 29.jpg','S-XC2',60,'GIANT',29,'DOUBLE_WALLED'),(7,2017,'Giant S-XC2 26.jpg','S-XC2',55,'GIANT',26,'DOUBLE_WALLED'),(8,2017,'Alex XD Sport.jpg','XD Sport',45,'ALEXRIMS',26,'DOUBLE_WALLED'),(9,2016,'Ryde Taurus 21.jpg','Taurus 21',60,'RYDE',27.5,'DOUBLE_WALLED'),(10,2017,'Alex XD Pro.jpg','XD Pro',75,'ALEXRIMS',26,'TRIPLE_WALLED'),(11,2013,'DT Swiss FR 600.jpg','FR 600',95,'SWISS',26,'TRIPLE_WALLED'),(12,2017,'Roval Fattie, 29.jpg','Fattie, 29',80,'ROVAL',29,'TRIPLE_WALLED'),(13,2017,'Stan NoTubes Flow Mk3, 32H.jpg','NoTubes Flow',90,'STAN',27.5,'TRIPLE_WALLED'),(14,2017,'Stan\'s NoTubes ARCH MK3.jpg','NoTubes ARCH MK3',140,'STAN',27.5,'TRIPLE_WALLED'),(15,2017,'WTB STP i29.jpg','STP i29',25,'WTB',27.5,'TRIPLE_WALLED');
/*!40000 ALTER TABLE `rims` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tires`
--

DROP TABLE IF EXISTS `tires`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tires` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_on` int(11) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `diameter` double DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `width` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tires`
--

LOCK TABLES `tires` WRITE;
/*!40000 ALTER TABLE `tires` DISABLE KEYS */;
INSERT INTO `tires` VALUES (1,2016,'Giant S-R3 All.jpg','S-R3 All',25,'GIANT',28,'RACING',1.2),(2,2017,'MAVIC Aksion.jpg','Aksion',90,'MAVIC',28,'RACING',1.2),(3,2014,'KENDA K-193.jpg','K-193',25,'KENDA',28,'RACING',1.4),(4,2016,'Schwalbe Smart Sam.jpg','Smart Sam',30,'SCHWALBE',27.5,'MOUNTAIN',2.1),(5,2017,'Schwalbe Smart Sam, Active, 29х2.25.jpg','Smart Sam',35,'SCHWALBE',29,'MOUNTAIN',2.25),(6,2017,'Maxxis CROSSMARK 29x2.1.jpg','CROSSMARK',40,'MAXXIS',29,'MOUNTAIN',2.1),(7,2017,'Racing Ralph.jpg','Racing Ralph',35,'SCHWALBE',26,'MOUNTAIN',2.1),(8,2017,'Schwalbe Smart Sam 2.1.jpg',' Smart Sam',35,'SCHWALBE',26,'MOUNTAIN',2.1),(9,2016,'Smart Sam 2.25.jpg','Smart Sam 2.25',45,'SCHWALBE',27.5,'MOUNTAIN',2.25),(10,2017,'Schwalbe Rocket Ron 2.25.jpg','Rocket Ron 2.25',60,'SCHWALBE',26,'MOUNTAIN',2.25),(11,2013,'Specialized Butcher DH.jpg','Butcher DH',90,'SPECIALIZED',26,'MOUNTAIN',2.3),(12,2014,'Specialized Slaughter Control.jpg','Slaughter Control',80,'SPECIALIZED',29,'MOUNTAIN',2.3),(13,2017,'Schwalbe Magic Mary Performance 27.5.jpg','Magic Mary Performance 27.5',90,'SCHWALBE',27.5,'MOUNTAIN',2.35),(14,2017,'Schwalbe Nobby Nic Performance 27.5.jpg','Nobby Nic Performance 27.5',115,'SCHWALBE',27.5,'MOUNTAIN',2.35);
/*!40000 ALTER TABLE `tires` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `birth_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `is_activated` bit(1) DEFAULT NULL,
  `is_logged` bit(1) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `registration_date` datetime DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1992-02-22 00:00:00','meloman-for@mail.ru','Vova','MALE','','','Khmil','$2a$10$vtTNfzZKrOJ1ZbcpGNUdlefp8UY8HjSm/3d3nH5JYsP4eFdoQ4iUi','2017-06-11 15:14:18','USER'),(10,'1992-02-22 00:00:00','Admin@mail.ru','Admin','MALE','','\0','SuperAdmin','$2a$10$mmYPOLqiakHe0gB13jtg4.6c0cMWsV7pvIx1aPTDemUAGlx57UtwO','2017-06-14 17:19:03','ADMIN'),(12,NULL,'melomanfor@gmail.com','Vovaan','MALE','','\0','Khmil','$2a$10$x8LvpEuxn/fQBVyILtVT5.gdFOwkBJ9.vXUUNd79zMjkio9VssOlO','2017-07-11 16:46:18','USER');
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

-- Dump completed on 2017-07-11 23:07:09
