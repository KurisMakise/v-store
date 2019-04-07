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
-- Table structure for table `os_advert`
--

DROP TABLE IF EXISTS `os_advert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_advert` (
  `advert_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '广告位ID',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `width` int(11) DEFAULT NULL COMMENT '宽度',
  `height` int(11) DEFAULT NULL COMMENT '高度',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `code` varchar(64) DEFAULT NULL COMMENT '代码简称',
  `template` text COMMENT '模版内容',
  `defult_number` int(11) DEFAULT '0' COMMENT '默认显示个数',
  `number` int(11) DEFAULT '0' COMMENT '广告数量',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态 1=显示/0=隐藏',
  `type` tinyint(4) DEFAULT NULL COMMENT '广告位类型 1=图片/0=文本',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`advert_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='广告位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_advert`
--

LOCK TABLES `os_advert` WRITE;
/*!40000 ALTER TABLE `os_advert` DISABLE KEYS */;
INSERT INTO `os_advert` VALUES (1,'首页-轮播广告',1226,460,'电子商城首页轮播广告位','indexCarousel','				<ul class=\"ull\">\r\n				<c:forEach items=\"${indexCarouselImgs }\" var=\"indexCarouselImg\">\r\n				    <li><a href=\"${indexCarouselImg.href }\"><img src=\"${ctximg }/${indexCarouselImg.picImg}\" alt=\"${indexCarouselImg.title }\"></a></li>\r\n				</c:forEach>\r\n				</ul>\r\n				<ol class=\"oll\">\r\n				</ol>\r\n				<span class=\"left btnL glyphicon glyphicon-menu-right\"></span> <span class=\"right btnL glyphicon glyphicon-menu-left\"></span>',6,7,1,1,NULL,'',NULL,NULL),(2,'首页-热点广告',315,170,'电子商城首页热点广告位','indexHotAdvert','				<ul class=\"list2\">\r\n					<li><img src=\"img/dianhuaka.jpg\" alt=\"\"></li>\r\n					<li><img src=\"img/notexianhuo.jpg\" alt=\"\"></li>\r\n					<li><img src=\"img/jinghuaqi.jpg\" alt=\"\"></li>\r\n				</ul>',3,6,1,1,NULL,'',NULL,NULL),(3,'首页-分栏广告',234,300,'电子商城首页分栏广告位','indexSubfield',NULL,2,6,1,1,NULL,'',NULL,NULL);
/*!40000 ALTER TABLE `os_advert` ENABLE KEYS */;
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
