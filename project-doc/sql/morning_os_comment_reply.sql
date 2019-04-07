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
-- Table structure for table `os_comment_reply`
--

DROP TABLE IF EXISTS `os_comment_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_comment_reply` (
  `comment_reply_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论回复ID',
  `comment_id` bigint(20) DEFAULT NULL COMMENT '评论ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(30) DEFAULT NULL COMMENT '昵称',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `good_count` int(11) DEFAULT '0' COMMENT '好评数',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态：1.显示；0.隐藏',
  `type` tinyint(2) DEFAULT '0' COMMENT '评论类型：1,官方回复；0,用户回复',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`comment_reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1113822409762684930 DEFAULT CHARSET=utf8 COMMENT='评论回复表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_comment_reply`
--

LOCK TABLES `os_comment_reply` WRITE;
/*!40000 ALTER TABLE `os_comment_reply` DISABLE KEYS */;
INSERT INTO `os_comment_reply` VALUES (1,8,1,'猫宁','default/avatar/avatar_8.jpg','很好用啊',17,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(2,8,1,'猫宁','default/avatar/avatar_4.jpg','测试2',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(3,8,1,'猫宁','default/avatar/avatar_5.jpg','测试3',0,0,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(4,8,1,'猫宁','default/avatar/avatar_8.jpg','测试3',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(5,10,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','超级赞！~赞',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(6,10,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','超级赞！~赞',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(7,12,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(8,12,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(9,12,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','赞赞岁男子拿',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(10,12,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','咱按时打算的',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(11,20,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','赞赞赞！~',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(12,20,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','赞赞赞！~',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(13,18,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','赞赞赞！~',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(14,19,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','赞赞男咋！~',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(15,10,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','咱在那咋咋！',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(1113822167348690945,20,1112532938807226369,'两仪式','default/avatar/avatar_1.jpg','发发发',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(1113822194301288450,20,1112532938807226369,'两仪式','default/avatar/avatar_6.jpg','三分暗示法',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(1113822351226978306,20,1112532938807226369,'两仪式','default/avatar/avatar_6.jpg','轻微轻微',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(1113822374098518018,20,1112532938807226369,'两仪式','default/avatar/avatar_6.jpg','432废物发',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(1113822394633830402,20,1112532938807226369,'两仪式','default/avatar/avatar_6.jpg','765一认同和认同',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(1113822409762684929,20,1112532938807226369,'两仪式','default/avatar/avatar_6.jpg','好人拖后腿',0,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米');
/*!40000 ALTER TABLE `os_comment_reply` ENABLE KEYS */;
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
