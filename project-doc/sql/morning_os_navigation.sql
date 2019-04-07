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
-- Table structure for table `os_navigation`
--

DROP TABLE IF EXISTS `os_navigation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_navigation` (
  `navigation_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '导航ID',
  `code` varchar(64) DEFAULT NULL COMMENT '代码简称',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态 1=显示/0=隐藏',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  `show_number` int(11) DEFAULT NULL COMMENT '显示数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`navigation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='导航表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_navigation`
--

LOCK TABLES `os_navigation` WRITE;
/*!40000 ALTER TABLE `os_navigation` DISABLE KEYS */;
INSERT INTO `os_navigation` VALUES (1,'indexTop','首页-顶部',1,10,10,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','首页-顶部'),(2,'indexAdvertLeft','首页-广告栏-左部',1,6,6,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','首页-广告栏-左部'),(3,'indexBottom','首页-底部',1,10,10,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','首页-底部'),(4,'loginTop','登录-顶部',1,4,4,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','登录-顶部'),(5,'indexClassify','首页-分类',1,8,8,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','首页-分类'),(7,'loginBottom','登录-底部',1,2,2,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','登录-底部');
/*!40000 ALTER TABLE `os_navigation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 20:02:17
