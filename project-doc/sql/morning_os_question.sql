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
-- Table structure for table `os_question`
--

DROP TABLE IF EXISTS `os_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_question` (
  `question_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '提问ID',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(30) DEFAULT NULL COMMENT '昵称',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `content` varchar(255) DEFAULT NULL COMMENT '提问内容',
  `good_count` int(11) DEFAULT '0' COMMENT '好评数',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态：1.显示；0.隐藏',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
  `answer_content` varchar(255) DEFAULT NULL COMMENT '回答内容',
  `answer_by` varchar(255) DEFAULT NULL COMMENT '回复人',
  `answer_time` datetime DEFAULT NULL COMMENT '回复时间',
  `type` tinyint(2) DEFAULT '0' COMMENT '状态：1.已处理；0.未处理；2.不予处理',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1113799819946037250 DEFAULT CHARSET=utf8 COMMENT='提问表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_question`
--

LOCK TABLES `os_question` WRITE;
/*!40000 ALTER TABLE `os_question` DISABLE KEYS */;
INSERT INTO `os_question` VALUES (1,1,1,'猫宁','default/avatar/avatar_8.jpg','商城的所有产品必须超过150免邮配送么',4,1,'2019-02-24 00:00:00','小米','您好，购买手机是免邮的~购买配件等商品在150元以下，需按照10元/单标准支付邮费， “满150元免邮费”需以实际支付金额超过150元为准。小米电视、空气净化器、体重秤因商品特殊性不参与满150元包邮活动。如遇活动期，资费标准以活动公告为准哦，感谢您对小米的支持，祝您购物愉快~','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(2,1,1,'猫宁','default/avatar/avatar_4.jpg','邮费多少',57,1,'2019-02-24 00:00:00','小米','您好，购买手机是免邮的~购买配件等商品在150元以下，需按照10元/单标准支付邮费， “满150元免邮费”需以实际支付金额超过150元为准。小米电视、空气净化器、体重秤因商品特殊性不参与满150元包邮活动。如遇活动期，资费标准以活动公告为准哦，感谢您对小米的支持，祝您购物愉快~','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(3,1,1,'猫宁','default/avatar/avatar_5.jpg','测试提问',0,1,'2019-02-24 00:00:00','小米','测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问。','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(4,1,1,'猫宁','default/avatar/avatar_8.jpg','测试提问',57,1,'2019-02-24 00:00:00','小米','测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问。','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(5,1,1,'猫宁','default/avatar/avatar_4.jpg','测试提问',57,1,'2019-02-24 00:00:00','小米','测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问。','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(6,1,1,'猫宁','default/avatar/avatar_5.jpg','测试提问',56,1,'2019-02-24 00:00:00','小米','测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问。','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(7,1,1,'猫宁','default/avatar/avatar_5.jpg','测试提问',56,1,'2019-02-24 00:00:00','小米','测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问。','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(8,1,1,'猫宁','default/avatar/avatar_5.jpg','测试提问',0,1,'2019-02-24 00:00:00','小米','测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问。','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(9,1,1,'猫宁','default/avatar/avatar_5.jpg','测试提问',56,1,'2019-02-24 00:00:00','小米','测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问。','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(10,1,1,'猫宁','default/avatar/avatar_5.jpg','测试提问',56,1,'2019-02-24 00:00:00','小米','测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问。','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(11,1,1,'猫宁','default/avatar/avatar_5.jpg','测试提问',56,1,'2019-02-24 00:00:00','小米','测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问。','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(12,1,1,'猫宁','default/avatar/avatar_5.jpg','测试提问',56,1,'2019-02-24 00:00:00','小米','测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问，测试提问。','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(13,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','你hi奥？',0,1,'2019-02-24 00:00:00','小米','回复，回复','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(14,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','我可以进行提问吗？',118,1,'2019-02-24 00:00:00','小米','当然可以啊','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(15,3,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','我可以进行题吗？',99,1,'2019-02-24 00:00:00','小米','回复，回复','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(16,3,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','我看ifsdaf斯蒂芬',100,1,'2019-02-24 00:00:00','小米','当然可以啊','小米','2019-02-24 00:00:00',1,'小米','2019-02-24 00:00:00'),(17,3,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','电视发射点发斯蒂芬',0,0,'2019-02-24 00:00:00','小米',NULL,'小米','2019-02-24 00:00:00',0,'小米','2019-02-24 00:00:00'),(18,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg','撒大帝',0,0,'2019-02-24 00:00:00','小米',NULL,'小米','2019-02-24 00:00:00',0,'小米','2019-02-24 00:00:00'),(1113799600315502593,1,1112532938807226369,'两仪式','default/avatar/avatar_5.jpg','123',2,1,'2019-02-24 00:00:00','小米','哈哈哈','小米','2019-02-24 00:00:00',0,'小米','2019-02-24 00:00:00'),(1113799819946037249,1,1112532938807226369,'两仪式','default/avatar/avatar_7.jpg','4849',14,1,'2019-02-24 00:00:00','小米','呜呜呜','小米','2019-02-24 00:00:00',0,'小米','2019-02-24 00:00:00');
/*!40000 ALTER TABLE `os_question` ENABLE KEYS */;
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
