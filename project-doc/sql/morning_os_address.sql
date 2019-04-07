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
-- Table structure for table `os_address`
--

DROP TABLE IF EXISTS `os_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_address` (
  `address_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '收获地址ID',
  `user_id` bigint(20) unsigned DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `user_tag` varchar(64) DEFAULT NULL COMMENT '地址标签',
  `user_phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `province_id` int(10) unsigned DEFAULT NULL COMMENT '省份ID',
  `province_name` varchar(64) DEFAULT NULL COMMENT '省份名字',
  `city_id` int(10) unsigned DEFAULT NULL COMMENT '城市ID',
  `city_name` varchar(64) DEFAULT NULL COMMENT '城市名字',
  `district_id` int(10) unsigned DEFAULT NULL COMMENT '区域ID',
  `district_name` varchar(64) DEFAULT NULL COMMENT '区域名字',
  `user_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `user_zipcode` varchar(6) DEFAULT NULL COMMENT '邮政编码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1114457557885743107 DEFAULT CHARSET=utf8 COMMENT='收获地址表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_address`
--

LOCK TABLES `os_address` WRITE;
/*!40000 ALTER TABLE `os_address` DISABLE KEYS */;
INSERT INTO `os_address` VALUES (1114424642191740930,1112532938807226369,'秋秋','','18583739589',1,'北京市',2,'北京市',5,'崇文区','哒哒哒哒哒哒','012345',NULL,'2019-04-06 17:19:39'),(1114457557885743106,1112532938807226369,'番茄酱','','18510165923',44,'上海市',45,'上海市',47,'卢湾区','哈哈哈哈哈哈哈','123456',NULL,'2019-04-06 17:19:34');
/*!40000 ALTER TABLE `os_address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 20:02:15
