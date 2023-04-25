CREATE DATABASE  IF NOT EXISTS `billing` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `billing`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: billing
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `bill_id` int NOT NULL AUTO_INCREMENT,
  `cust` int DEFAULT NULL,
  `items` varchar(500) NOT NULL,
  `quantity` int DEFAULT NULL,
  `cost` int NOT NULL,
  `timestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `cust` (`cust`),
  CONSTRAINT `bills_ibfk_1` FOREIGN KEY (`cust`) REFERENCES `customers` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (34,23,'Grapefruit,',1,88,'2023-04-23 01:44:41'),(36,39,'Honeydew Melon,Coconut,',3,222,'2023-04-25 02:55:52'),(37,40,'Banana,Pear,',7,130,'2023-04-25 02:58:41'),(38,41,'Grapefruit,Coconut,',2,138,'2023-04-25 03:05:42'),(39,23,'Grapefruit,',1,88,'2023-04-25 03:16:58'),(40,42,'Fresh Cream,Mushroom,',3,140,'2023-04-25 22:30:32');
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `cust_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(320) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cust_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (23,'Liam','liam60','[@, l, i, a, m, 6, 0, @]','liam60@gmail.com','7788554455'),(24,'Ramesh','ramesh12','[@, r, a, m, e, s, h, 1, 2, @]','ramesh12@gmail.com','5695697451'),(25,'Jai Choudary','jai_40','[@, j, a, i, _, 4, 0, @]','jai40@gmail.com','7788996541'),(26,'Dhruv Aggarwal','dhruv_30','[@, d, h, r, u, v, _, 3, 0, @]','dhruv30@gmail.com','8865942015'),(27,'Sara','sara12','[@, s, a, r, a, 1, 2, @]','sara12@gmail.com','4458756932'),(28,'Ruby Roy','ruby117','[@, r, u, b, 1, 1, 7, @]','ruby117@gmail.com','8877549965'),(29,'Anuj Singh','anuj_13','[@, a, n, u, j, _, 1, 3, @]','anuj13@gmail.com','6655449952'),(30,'Rahul Gupta','rahul18','[@, r, a, h, u, l, 1, 8, @]','rahul18@gmail.com','4521421521'),(31,'Naina Sharma','naina19','[@, n, a, i, n, a, 1, 9, @]','naina19@gmail.com','5544986363'),(32,'Payal Mishra','payal23','[@, p, a, y, a, l, 2, 3, @]','payal23@gmail.com','7758944856'),(33,'Keshav Singh','keshav31','[@, k, e, s, h, a, v, 3, 1, @]','keshav31@gmail.com','5569745821'),(34,'Riya Kumari','riya71','[@, r, i, y, a, 7, 1, @]','riya71@gmail.com','5568774854'),(35,'Priya Mishra','priya25','[@, p, r, i, y, a, 2, 5, @]','priya25@gmail.com','7785469832'),(36,'Itee Singh','itee32','[@, i, t, e, e, 3, 2, @]','itee32@gmail.com','8855446699'),(37,'Sam Pal','sam20','[@, s, a, m, 2, 0, @]','sam20@gmail.com','5566998654'),(38,'Aarti Kochhar','aarti21','[@, a, a, r, t, i, 2, 1, @]','aarti21@gmail.com','5698568569'),(39,'Khushi Bhardwaj','khushi24','[@, k, h, u, s, h, i, 2, 4, @]','khushi24@gmail.com','5548769542'),(40,'sneha','ghose','[s, g, h, o, s, e, 2, @]','snehaghose2@gmail.com','9870985739'),(41,'anusha sharja','anusha sharja','[1, 2, 3, 4, 5]','anuushamargi12@gmail.com','1234543212'),(42,'Suresh Singh','suresh_19','[@, s, u, r, e, s, h, _, 1, 9, @]','suresh19@gmail.com','9963256921');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-25 23:09:36
