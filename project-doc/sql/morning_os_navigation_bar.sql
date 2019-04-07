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
-- Table structure for table `os_navigation_bar`
--

DROP TABLE IF EXISTS `os_navigation_bar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_navigation_bar` (
  `navigation_bar_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '导航栏ID',
  `navigation_id` bigint(20) unsigned DEFAULT NULL COMMENT '导航ID',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `target` varchar(64) DEFAULT '_blank' COMMENT '打开方式：_blank；_parent；_self；_top',
  `sort` int(9) DEFAULT NULL COMMENT '排序',
  `href` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '链接地址',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态 1=显示/0=隐藏',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`navigation_bar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='导航栏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_navigation_bar`
--

LOCK TABLES `os_navigation_bar` WRITE;
/*!40000 ALTER TABLE `os_navigation_bar` DISABLE KEYS */;
INSERT INTO `os_navigation_bar` VALUES (1,4,'小米商城','_self',1,'/index',0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',''),(2,4,'公益频道','_self',2,'gongyi/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(3,4,'小米社区','_self',3,'bbs/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(4,4,'小米后台管理平台','_self',4,'system/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',''),(5,1,'小米商城','_self',1,'/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',''),(6,1,'公益频道','_blank',2,'gongyi/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(7,1,'小米社区','_blank',3,'bbs/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(8,1,'小米后台管理平台','_blank',4,'system/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',''),(9,1,'意见反馈','_blank',5,'/feedback',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(10,1,'关于我们','_blank',6,'/about',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(11,3,'小米商城','_self',1,'/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',''),(12,3,'公益频道','_blank',2,'gongyi/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(13,3,'小米社区','_blank',3,'bbs/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(14,3,'小米后台管理平台','_blank',4,'system/index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',''),(15,3,'意见反馈','_blank',5,'/feedback',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(16,3,'关于我们','_blank',6,'/about',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(17,2,'深圳壹基金公益基金会','_blank',1,'http://www.onefoundation.cn/',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',''),(18,2,'腾讯公益','_blank',2,'http://gongyi.qq.com/',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(19,2,'中国青年志愿者网','_blank',3,'http://www.zgzyz.org.cn/',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(20,2,'向日葵公益','_blank',4,'http://www.sunflowerangel.org/',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',''),(21,2,'中华爱心基金会','_blank',5,'http://www.ckf.org.cn/',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(22,2,'网易公益','_blank',6,'http://gongyi.163.com/',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(23,5,'平板 · 笔记本','_blank',1,'list?categoryId=4',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(24,5,'耳机 · 音响','_blank',2,'list?categoryId=7',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(25,5,'智能硬件','_blank',3,'list?categoryId=3',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(27,5,'生活周边','_blank',4,'list?categoryId=9',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(28,5,'周边配件','_blank',5,'list?categoryId=6',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(29,5,'公益频道','_blank',6,'index',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(30,5,'猫宁后台管理平台','_blank',7,'index',0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(31,7,'周边配件','_blank',5,'list?categoryId=6',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL),(33,1,'一点点慈善','_blank',7,'https://www.baidu.com/',1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','一点点慈善'),(34,7,'一点点','_blank',3,'www.baidu.com',0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','百度一点点此项政策');
/*!40000 ALTER TABLE `os_navigation_bar` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 20:02:16
