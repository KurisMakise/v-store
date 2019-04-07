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
-- Table structure for table `os_advert_detail`
--

DROP TABLE IF EXISTS `os_advert_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_advert_detail` (
  `advert_detail_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '广告详情ID',
  `advert_id` bigint(20) DEFAULT NULL COMMENT '广告位ID',
  `title` varchar(64) DEFAULT NULL COMMENT '标题',
  `sort` int(9) DEFAULT NULL COMMENT '排序',
  `href` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '链接地址',
  `status` tinyint(2) DEFAULT NULL COMMENT '状态 1=显示/0=隐藏',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '展示图片',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注信息',
  `begin_time` datetime DEFAULT NULL COMMENT '广告起始时间',
  `end_time` datetime DEFAULT NULL COMMENT '广告结束时间',
  `content` varchar(255) DEFAULT NULL COMMENT '广告内容',
  PRIMARY KEY (`advert_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='广告位管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_advert_detail`
--

LOCK TABLES `os_advert_detail` WRITE;
/*!40000 ALTER TABLE `os_advert_detail` DISABLE KEYS */;
INSERT INTO `os_advert_detail` VALUES (1,1,'日行一善，小心意，大爱心',1,'#',1,'images/advert/20170224/1471798388806.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(2,1,'微光计划',2,'#',1,'images/advert/20170224/1471798568000.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(3,1,'免费午餐',3,'#',1,'images/advert/20170224/1471798318820.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(4,1,'走，带着热情去基层',4,'#',1,'images/advert/20170224/1471798587971.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(5,1,'微笑江豚',5,'#',1,'images/advert/20170224/1471798587469.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(6,1,'伸出援助之手',6,'#',1,'images/advert/20170224/1471798364441.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(7,2,'爸妈食堂',1,'#',1,'images/advert/20170224/1487945656155.png','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(8,2,'我们一起回家',2,'#',1,'images/advert/20170224/1487945778175.png','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(9,2,'关上一盏灯，点亮一盏灯',3,'#',1,'images/advert/20170224/1487946033939.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(10,2,'深圳壹基金公益基金会',4,'http://www.onefoundation.cn/',1,'images/advert/20170224/1487946180347.png','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(11,2,'腾讯公益',5,'http://gongyi.qq.com/',1,'images/advert/20170224/1487946256048.png','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(12,3,'测试产品广告',1,'list/2',1,'images/advert/20170228/1471798587971.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(13,3,'手机专场，有你好看',2,'list/2',1,'images/advert/20170228/1471798587371.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(14,3,'测试产品广告2',3,'list/2',1,'images/advert/20170228/1471798587971.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(16,3,'测试产品广告3',1,'list/4',1,'images/advert/20170228/1471798587971.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(17,3,'测试产品广告4',1,'list/4',1,'images/advert/20170228/1471798587971.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(18,3,'测试产品广告5',1,'list/4',1,'images/advert/20170228/1471798587971.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(19,3,'测试产品广告5',1,'list/4',1,'images/advert/20170228/1471798587971.jpg','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米',NULL,'2019-02-24 00:00:00','2019-02-24 00:00:00',NULL),(20,1,'测试管理',7,'/index',1,'images/advert/20170710/1499664359342.png','2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米','','2019-02-24 00:00:00','2019-02-24 00:00:00',NULL);
/*!40000 ALTER TABLE `os_advert_detail` ENABLE KEYS */;
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
