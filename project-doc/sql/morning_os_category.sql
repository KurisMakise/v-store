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
-- Table structure for table `os_category`
--

DROP TABLE IF EXISTS `os_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_category` (
  `category_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父分类ID',
  `name` varchar(64) DEFAULT NULL COMMENT '分类名称',
  `sort` int(9) DEFAULT NULL COMMENT '排序',
  `type` tinyint(2) DEFAULT NULL COMMENT '目录类型 2=二级目录/1=一级目录/0=总目录',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态 1=显示/0=隐藏',
  `show_in_nav` tinyint(2) DEFAULT '0' COMMENT '是否导航栏 1=显示/0=隐藏',
  `show_in_top` tinyint(2) DEFAULT '0' COMMENT '是否置顶 1=置顶/0=默认',
  `show_in_hot` tinyint(2) DEFAULT '0' COMMENT '是否热门 1=热门/0=默认',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  `page_title` varchar(64) DEFAULT NULL COMMENT '页面标题',
  `page_description` varchar(64) DEFAULT NULL COMMENT '页面描述',
  `page_keyword` varchar(64) DEFAULT NULL COMMENT '页面关键词',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1104804769262161922 DEFAULT CHARSET=utf8 COMMENT='分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_category`
--

LOCK TABLES `os_category` WRITE;
/*!40000 ALTER TABLE `os_category` DISABLE KEYS */;
INSERT INTO `os_category` VALUES (1,0,'全部商品',NULL,0,1,0,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','全部商品',NULL,NULL,NULL),(2,1,'手机',100,1,1,1,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','手机','小米手机,超乎你的想象,性能超级棒;小米手机,超乎你的想象,性能超级棒.','小米手机,超乎你的想象,性能超级棒','小米手机'),(3,1,'智能硬件',200,1,1,1,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','智能硬件',NULL,NULL,''),(4,1,'笔记本  平板',300,1,1,1,0,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','笔记本/平板',NULL,NULL,NULL),(5,1,'路由器  移动电源',400,1,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','路由器/移动电源',NULL,NULL,NULL),(6,1,'周边配件',500,1,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','周边配件',NULL,NULL,NULL),(7,1,'耳机  音响',600,1,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','耳机/音响',NULL,NULL,NULL),(8,1,'保护套  贴膜',700,1,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','保护套/贴膜',NULL,NULL,NULL),(9,1,'生活周边',800,1,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','生活周边',NULL,NULL,NULL),(10,3,'手环及配件',10,2,1,1,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','手环及配件','手环及配件','手环及配件','手环及配件'),(11,3,'智能灯',20,2,1,1,0,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','智能健康',NULL,NULL,NULL),(12,3,'智能家居',30,2,1,1,0,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','智能家居',NULL,NULL,NULL),(13,3,'智能健康',40,2,1,1,0,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','智能出行',NULL,NULL,NULL),(15,4,'笔记本电脑',10,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','笔记本电脑',NULL,NULL,NULL),(16,4,'平板电脑',20,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','平板电脑',NULL,NULL,NULL),(17,5,'路由器',10,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','路由器',NULL,NULL,NULL),(18,5,'移动电源',20,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','移动电源',NULL,NULL,NULL),(19,5,'路由器配件',30,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','路由器配件',NULL,NULL,NULL),(20,6,'插线板',10,2,0,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','插线板',NULL,NULL,NULL),(21,6,'存储卡',20,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','存储卡',NULL,NULL,NULL),(22,6,'移动硬盘',30,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','移动硬盘',NULL,NULL,NULL),(23,7,'头戴式耳机',10,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','头戴式耳机',NULL,NULL,NULL),(24,7,'活塞耳机',20,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','活塞耳机',NULL,NULL,NULL),(25,7,'蓝牙耳机',30,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','蓝牙耳机',NULL,NULL,NULL),(26,7,'音响',40,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','音响',NULL,NULL,NULL),(27,8,'贴膜',10,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','贴膜',NULL,NULL,NULL),(28,8,'保护套  保护壳',20,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','保护套/保护壳',NULL,NULL,NULL),(29,8,'移动电源保护套',30,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','移动电源保护套',NULL,NULL,NULL),(30,9,'箱包',10,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','箱包',NULL,NULL,NULL),(31,9,'服装',20,2,1,1,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','服装',NULL,NULL,''),(32,1,'智能家电',900,1,0,0,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','智能家电','智能家电','智能家电','智能家电'),(33,2,'小米手机',10,2,1,1,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','小米手机','小米手机','小米手机','小米手机'),(1104804722084663297,NULL,NULL,NULL,NULL,0,0,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,NULL,NULL,NULL),(1104804769262161921,NULL,NULL,NULL,NULL,0,0,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `os_category` ENABLE KEYS */;
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
