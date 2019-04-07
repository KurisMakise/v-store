-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: morning
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `os_product_category`
--

DROP TABLE IF EXISTS `os_product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_product_category` (
  `product_category_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品分类ID',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`product_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='商品分类关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_product_category`
--

LOCK TABLES `os_product_category` WRITE;
/*!40000 ALTER TABLE `os_product_category` DISABLE KEYS */;
INSERT INTO `os_product_category` VALUES (1,1,2,'2019-02-24 00:00:00','小米'),(2,2,2,'2019-02-24 00:00:00','小米'),(3,3,12,'2019-02-24 00:00:00','小米'),(4,4,10,'2019-02-24 00:00:00','小米'),(5,5,10,'2019-02-24 00:00:00','小米'),(6,6,11,'2019-02-24 00:00:00','小米'),(7,7,11,'2019-02-24 00:00:00','小米'),(8,8,11,'2019-02-24 00:00:00','小米'),(9,9,12,'2019-02-24 00:00:00','小米'),(10,10,13,'2019-02-24 00:00:00','小米'),(11,11,13,'2019-02-24 00:00:00','小米'),(12,12,15,'2019-02-24 00:00:00','小米'),(13,13,15,'2019-02-24 00:00:00','小米'),(14,14,16,'2019-02-24 00:00:00','小米'),(15,15,13,'2019-02-24 00:00:00','小米'),(16,16,18,'2019-02-24 00:00:00','小米'),(17,17,19,'2019-02-24 00:00:00','小米'),(18,18,20,'2019-02-24 00:00:00','小米'),(19,19,21,'2019-02-24 00:00:00','小米'),(20,20,22,'2019-02-24 00:00:00','小米'),(21,21,23,'2019-02-24 00:00:00','小米'),(22,22,24,'2019-02-24 00:00:00','小米'),(23,23,25,'2019-02-24 00:00:00','小米'),(24,24,26,'2019-02-24 00:00:00','小米'),(25,25,26,'2019-02-24 00:00:00','小米'),(26,26,28,'2019-02-24 00:00:00','小米'),(27,27,29,'2019-02-24 00:00:00','小米'),(28,28,30,'2019-02-24 00:00:00','小米'),(29,29,30,'2019-02-24 00:00:00','小米'),(30,30,30,'2019-02-24 00:00:00','小米'),(31,31,31,'2019-02-24 00:00:00','小米');
/*!40000 ALTER TABLE `os_product_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 20:02:14
