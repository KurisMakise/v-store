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
-- Table structure for table `os_product_attribute`
--

DROP TABLE IF EXISTS `os_product_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_product_attribute` (
  `attribute_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '属性ID',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `stock` int(11) DEFAULT '0' COMMENT '总库存',
  `sales_volume` int(11) DEFAULT '0' COMMENT '销售量',
  `page_views` int(11) DEFAULT '0' COMMENT '游览量',
  `comment_number` int(11) DEFAULT '0' COMMENT '评论数量',
  `comment_total` int(11) DEFAULT '0' COMMENT '累计评价',
  `comment_average` decimal(10,0) DEFAULT '0' COMMENT '平均评价',
  `favorite_number` int(11) DEFAULT '0' COMMENT '收藏数',
  `question_number` int(11) DEFAULT NULL COMMENT '提问数',
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='商品属性表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_product_attribute`
--

LOCK TABLES `os_product_attribute` WRITE;
/*!40000 ALTER TABLE `os_product_attribute` DISABLE KEYS */;
INSERT INTO `os_product_attribute` VALUES (1,1,1,1,1,17,1,1,1,17),(2,2,2,2,2,2,2,1,2,2),(3,3,3,3,3,3,3,1,3,2),(4,4,4,4,4,0,0,0,0,0),(5,5,5,5,5,5,5,1,5,5),(6,6,6,6,6,6,6,1,6,6),(7,7,7,7,7,7,7,1,7,7),(8,8,8,8,8,8,8,1,8,8),(9,9,9,9,9,9,9,1,9,9),(10,10,10,10,10,10,10,1,10,10),(11,11,11,11,11,11,11,1,11,11),(12,12,12,12,12,12,12,1,12,12),(13,13,13,13,13,13,13,1,13,13),(14,14,14,14,14,14,14,1,14,14),(15,15,15,15,15,15,15,1,15,15),(16,16,16,16,16,16,16,1,16,16),(17,17,17,17,17,17,17,1,17,17),(18,18,18,18,18,18,18,1,18,18),(19,19,19,19,19,19,19,1,19,19),(20,20,20,20,20,20,20,1,20,20),(21,21,21,21,21,21,21,1,21,21),(22,22,22,22,22,22,22,1,22,22),(23,23,23,23,23,23,23,1,23,23),(24,24,24,24,24,24,24,1,24,24),(25,25,25,25,25,25,25,1,25,25),(26,26,26,26,26,26,26,1,26,26),(27,27,27,27,27,27,27,1,27,27),(28,28,28,28,28,28,28,1,28,28),(29,29,29,29,29,29,29,1,29,29),(30,30,30,30,30,30,30,1,30,30),(31,31,31,31,31,31,31,1,31,31),(32,32,32,32,32,32,32,32,32,32),(33,33,33,33,33,33,33,33,33,33),(34,34,34,34,34,34,34,34,34,34);
/*!40000 ALTER TABLE `os_product_attribute` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 20:02:12
