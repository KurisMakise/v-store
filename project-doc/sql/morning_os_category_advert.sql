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
-- Table structure for table `os_category_advert`
--

DROP TABLE IF EXISTS `os_category_advert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_category_advert` (
  `category_advert_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '类目广告ID',
  `category_id` bigint(20) DEFAULT NULL COMMENT '类目ID',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `sort` int(9) DEFAULT NULL COMMENT '排序',
  `href` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '链接地址',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 1=显示/0=隐藏',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '展示图片',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  `begin_time` datetime DEFAULT NULL COMMENT '广告起始时间',
  `end_time` datetime DEFAULT NULL COMMENT '广告结束时间',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`category_advert_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='类目广告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_category_advert`
--

LOCK TABLES `os_category_advert` WRITE;
/*!40000 ALTER TABLE `os_category_advert` DISABLE KEYS */;
INSERT INTO `os_category_advert` VALUES (1,2,'测试产品广告4',3,'detail/1472581220748',1,'images/advert/20170228/1471798587971.jpg',NULL,'1',NULL,NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00','地方'),(2,2,'测试产品广告2',2,'detail/1472581220748',1,'images/advert/20170228/1471798587971.jpg',NULL,'2',NULL,NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00','地方'),(3,2,'测试产品广告1',1,'detail/1472581220748',1,'images/advert/20170228/1471798587971.jpg',NULL,'3',NULL,NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00','地方'),(4,3,'测试产品广告5',1,'detail/1472581220748',1,'images/advert/20170228/1471798587971.jpg',NULL,'4',NULL,NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00','地方'),(5,4,'测试产品广告6',1,'detail/1472581220748',1,'images/advert/20170228/1471798587971.jpg',NULL,'5',NULL,NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00','地方'),(6,3,'测试产品广告7',2,'detail/1472581220748',1,'images/advert/20170228/1471798587971.jpg',NULL,'6',NULL,NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00','地方'),(7,4,'测试产品广告8',2,'detail/1472581220748',1,'images/advert/20170228/1471798587971.jpg',NULL,'7',NULL,NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00','地方'),(8,5,'测试产品广告9',1,'detail/1472581220748',1,'images/advert/20170228/1471798587971.jpg',NULL,'',NULL,NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL);
/*!40000 ALTER TABLE `os_category_advert` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 20:02:13
