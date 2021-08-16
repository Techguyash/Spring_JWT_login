-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: authapi
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.21.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_user` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `app_user_role` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `locked` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (1,'Admin','ROLE_ADMIN','2021-07-24','admin@mail.com',_binary '',NULL,_binary '\0','$2a$10$SAKSvr6r8zxJz0Hi7PutoOcKSQvDw4LN4LCVl6rttSckBXr/eR4JW');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user_role`
--

DROP TABLE IF EXISTS `app_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `app_user_role` (
  `id` int NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user_role`
--

LOCK TABLES `app_user_role` WRITE;
/*!40000 ALTER TABLE `app_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `created_on` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (5,'plastic','2021-08-12','non -eatable'),(6,'food','2021-08-12','non -eatable'),(7,'fruits','2021-08-12','eatable'),(8,'vegetable','2021-08-12','eatable'),(9,'grocessory','2021-08-12','eatable');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmation_token`
--

DROP TABLE IF EXISTS `confirmation_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `confirmation_token` (
  `id` bigint NOT NULL,
  `confirmed_at` datetime DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `expires_at` datetime NOT NULL,
  `token` varchar(255) NOT NULL,
  `app_user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo9fl25wqyh7w7mnfkdqen1rcm` (`app_user_id`),
  CONSTRAINT `FKo9fl25wqyh7w7mnfkdqen1rcm` FOREIGN KEY (`app_user_id`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmation_token`
--

LOCK TABLES `confirmation_token` WRITE;
/*!40000 ALTER TABLE `confirmation_token` DISABLE KEYS */;
INSERT INTO `confirmation_token` VALUES (1,'2021-08-12 19:14:27','2021-08-12 19:14:17','2021-08-12 19:29:17','7588c604-8adc-4ba7-98d2-7cfb8cbf03f6',1);
/*!40000 ALTER TABLE `confirmation_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (10,'default','1998-08-20','default@mail.com','1234567791','food supplier');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `id` int NOT NULL,
  `created_at` date DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `discount_name` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `percentage_val` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (0,'2018-12-07','default','default disount',_binary '',0),(2,'2019-02-15','50% off on invoice','Double DHAMAKA',_binary '',50);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (68);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_t`
--

DROP TABLE IF EXISTS `invoice_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_t` (
  `invoice_no` bigint NOT NULL,
  `amount_paid` float NOT NULL,
  `billed_amount` float NOT NULL,
  `billed_at` datetime DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `biller_no` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `discount_id` int DEFAULT NULL,
  `tax_id` int DEFAULT NULL,
  PRIMARY KEY (`invoice_no`),
  KEY `FK1kbd484o2pkke8c0ge50d05o7` (`biller_no`),
  KEY `FKe3t05bslr3jv7hmmuqvohiml3` (`customer_id`),
  KEY `FKd1mvdxegwelako09kj98hb8hu` (`discount_id`),
  KEY `FKrlxh70l95viaykg56hkowjxg2` (`tax_id`),
  CONSTRAINT `FK1kbd484o2pkke8c0ge50d05o7` FOREIGN KEY (`biller_no`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FKd1mvdxegwelako09kj98hb8hu` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`),
  CONSTRAINT `FKe3t05bslr3jv7hmmuqvohiml3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FKrlxh70l95viaykg56hkowjxg2` FOREIGN KEY (`tax_id`) REFERENCES `tax` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_t`
--

LOCK TABLES `invoice_t` WRITE;
/*!40000 ALTER TABLE `invoice_t` DISABLE KEYS */;
INSERT INTO `invoice_t` VALUES (16,1200,1200,'2021-08-12 19:27:55','cash',1,10,0,0),(20,1200,1200,'2021-08-12 19:28:33','cash',1,10,2,0),(24,600,1200,'2021-08-12 19:34:15','cash',1,10,2,0),(28,1200,1200,'2021-08-12 19:35:18','cash',1,10,0,0),(32,1200,1200,'2021-08-12 19:37:43','cash',1,10,0,1),(36,1200,1200,'2021-08-12 19:40:06','cash',1,10,0,0),(40,1200,1200,'2021-08-12 19:40:33','cash',1,10,0,0),(44,1200,1200,'2021-08-12 19:40:46','cash',1,10,0,0),(48,1200,1200,'2021-08-12 19:41:42','cash',1,10,0,0),(52,1200,1200,'2021-08-12 19:42:42','cash',1,10,0,1),(56,1320,1200,'2021-08-12 19:43:45','cash',1,10,0,1),(60,720,1200,'2021-08-12 19:45:43','cash',1,10,2,1),(64,660,1200,'2021-08-12 19:49:56','cash',1,10,2,1);
/*!40000 ALTER TABLE `invoice_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` bigint NOT NULL,
  `created_on` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `stock_qty` float NOT NULL,
  `category_category_id` int DEFAULT NULL,
  `unit_id` int DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK76928e4ka0gitg4fl9q7tgg4b` (`category_category_id`),
  KEY `FKeex0i50vfsa5imebrfdiyhmp9` (`unit_id`),
  CONSTRAINT `FK76928e4ka0gitg4fl9q7tgg4b` FOREIGN KEY (`category_category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `FKeex0i50vfsa5imebrfdiyhmp9` FOREIGN KEY (`unit_id`) REFERENCES `units` (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (12,'2021-08-12','toys',50,'boys-car ',30,5,3),(13,'2021-08-12','eatalbe',50,'tomato ',30,8,4),(14,'2021-08-12','eatalbe',50,'potato ',30,8,4),(15,'2021-08-12','eatalbe',50,'soya ',30,8,4);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order` (
  `purchaseid` bigint NOT NULL,
  `purchased_price` float NOT NULL,
  `qty` float NOT NULL,
  `total` float NOT NULL,
  `productid` bigint DEFAULT NULL,
  `vendorid` bigint DEFAULT NULL,
  PRIMARY KEY (`purchaseid`),
  KEY `FKtogmvo77de69geib6ihjvjyov` (`productid`),
  KEY `FKj65kyfdf8jf578sfxmrw17of` (`vendorid`),
  CONSTRAINT `FKj65kyfdf8jf578sfxmrw17of` FOREIGN KEY (`vendorid`) REFERENCES `vendor` (`vendor_id`),
  CONSTRAINT `FKtogmvo77de69geib6ihjvjyov` FOREIGN KEY (`productid`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesorder_t`
--

DROP TABLE IF EXISTS `salesorder_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salesorder_t` (
  `sales_id` bigint NOT NULL,
  `qty` float NOT NULL,
  `sold_price` float NOT NULL,
  `total` float NOT NULL,
  `invoice_no` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`sales_id`),
  KEY `FKew6llmlfd877mypjqk4ykjqlk` (`invoice_no`),
  KEY `FKecdy5ghw5u069bshl7994vnnb` (`product_id`),
  CONSTRAINT `FKecdy5ghw5u069bshl7994vnnb` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  CONSTRAINT `FKew6llmlfd877mypjqk4ykjqlk` FOREIGN KEY (`invoice_no`) REFERENCES `invoice_t` (`invoice_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesorder_t`
--

LOCK TABLES `salesorder_t` WRITE;
/*!40000 ALTER TABLE `salesorder_t` DISABLE KEYS */;
INSERT INTO `salesorder_t` VALUES (17,1,100,100,16,12),(18,4,200,800,16,13),(19,3,100,300,16,14),(21,1,100,100,20,12),(22,4,200,800,20,13),(23,3,100,300,20,14),(25,1,100,100,24,12),(26,4,200,800,24,13),(27,3,100,300,24,14),(29,1,100,100,28,12),(30,4,200,800,28,13),(31,3,100,300,28,14),(33,1,100,100,32,12),(34,4,200,800,32,13),(35,3,100,300,32,14),(37,1,100,100,36,12),(38,4,200,800,36,13),(39,3,100,300,36,14),(41,1,100,100,40,12),(42,4,200,800,40,13),(43,3,100,300,40,14),(45,1,100,100,44,12),(46,4,200,800,44,13),(47,3,100,300,44,14),(49,1,100,100,48,12),(50,4,200,800,48,13),(51,3,100,300,48,14),(53,1,100,100,52,12),(54,4,200,800,52,13),(55,3,100,300,52,14),(57,1,100,100,56,12),(58,4,200,800,56,13),(59,3,100,300,56,14),(61,1,100,100,60,12),(62,4,200,800,60,13),(63,3,100,300,60,14),(65,1,100,100,64,12),(66,4,200,800,64,13),(67,3,100,300,64,14);
/*!40000 ALTER TABLE `salesorder_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_email_token_id`
--

DROP TABLE IF EXISTS `seq_email_token_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seq_email_token_id` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_email_token_id`
--

LOCK TABLES `seq_email_token_id` WRITE;
/*!40000 ALTER TABLE `seq_email_token_id` DISABLE KEYS */;
INSERT INTO `seq_email_token_id` VALUES (2);
/*!40000 ALTER TABLE `seq_email_token_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seq_user_id`
--

DROP TABLE IF EXISTS `seq_user_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seq_user_id` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seq_user_id`
--

LOCK TABLES `seq_user_id` WRITE;
/*!40000 ALTER TABLE `seq_user_id` DISABLE KEYS */;
INSERT INTO `seq_user_id` VALUES (2);
/*!40000 ALTER TABLE `seq_user_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tax`
--

DROP TABLE IF EXISTS `tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax` (
  `id` int NOT NULL,
  `created_at` date DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `percentage` int NOT NULL,
  `tax_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax`
--

LOCK TABLES `tax` WRITE;
/*!40000 ALTER TABLE `tax` DISABLE KEYS */;
INSERT INTO `tax` VALUES (0,'2015-05-05','default',_binary '',0,'default tax'),(1,'2021-05-05','dummy',_binary '',10,'dummy');
/*!40000 ALTER TABLE `tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `units` (
  `unit_id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `short_form` varchar(255) DEFAULT NULL,
  `unit_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (1,'used to measure','grm','gram'),(2,'used to measure','ml','ml'),(3,'used to measure','pc','piece'),(4,'used to measure','kg','kg');
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendor` (
  `vendor_id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gst_no` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES (11,'164 Erode','2019-10-05','hai@gmail.com','455475','223456890','vendor1');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'authapi'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-12 20:02:45
