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
-- Table structure for table `os_email`
--

DROP TABLE IF EXISTS `os_email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_email` (
  `email_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '邮箱ID',
  `email_sign` bigint(20) unsigned DEFAULT NULL COMMENT '邮箱标识号',
  `user_email` varchar(50) DEFAULT NULL COMMENT '用户邮箱',
  `email_type` tinyint(4) DEFAULT NULL COMMENT '邮箱类型：0.找回密码；1.注册；2.改变邮箱；3.通知',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `start_time` datetime DEFAULT NULL COMMENT '有效开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '有效结束时间',
  `new_email` varchar(50) DEFAULT NULL COMMENT '新电子邮箱',
  `status` tinyint(1) DEFAULT '1' COMMENT '链接是否已失效：0.失效；1.未失效；',
  `send_status` tinyint(1) DEFAULT NULL COMMENT '发送状态：0.发送失败；1.发送成功；',
  `captcha` varchar(10) DEFAULT NULL COMMENT '验证码',
  `email_subject` varchar(255) DEFAULT NULL COMMENT '邮箱主题',
  `email_content` text COMMENT '邮箱正文',
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1114721008956723202 DEFAULT CHARSET=utf8 COMMENT='邮箱记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_email`
--

LOCK TABLES `os_email` WRITE;
/*!40000 ALTER TABLE `os_email` DISABLE KEYS */;
INSERT INTO `os_email` VALUES (1112201699957141505,1554004522177946,'569252295@qq.com',1,'2019-03-31 11:55:21','2019-03-31 11:55:21','2019-03-31 12:01:21',NULL,0,0,'rQhGK8','很高兴遇见你！','{\"userName\":\"两仪式\",\"createTime\":1554004520805,\"captcha\":\"rQhGK8\",\"email\":\"569252295@qq.com\",\"userDate\":1554004520805}'),(1112201699957141506,1554022225071235,'508284102@qq.com',1,'2019-03-31 08:50:18','2019-03-31 08:50:18','2019-03-31 08:53:18',NULL,0,1,'zrrwdN','『但行好事·莫问前程』很高兴遇见您!','{\"createTime\":1554022218477,\"captcha\":\"zrrwdN\",\"userNumber\":\"两仪式\",\"email\":\"508284102@qq.com\"}'),(1112286897830772737,1554024836329805,'508284102@qq.com',1,'2019-03-31 17:33:55','2019-03-31 17:33:55','2019-03-31 17:39:55',NULL,0,0,'kUA4yK','很高兴遇见你！','{\"userName\":\"亚丝娜\",\"createTime\":1554024834792,\"captcha\":\"kUA4yK\",\"email\":\"508284102@qq.com\",\"userDate\":1554024834794}'),(1112532071651651586,1554083290299624,'569252295@qq.com',1,'2019-04-01 09:48:09','2019-04-01 09:48:09','2019-04-01 09:54:09',NULL,0,0,'YPUnX4','很高兴遇见你！','{\"userName\":\"两仪式\",\"createTime\":1554083288536,\"captcha\":\"YPUnX4\",\"email\":\"569252295@qq.com\",\"userDate\":1554083288539}'),(1112532956138090497,1554083501263369,'569252295@qq.com',1,'2019-04-01 09:51:40','2019-04-01 09:51:40','2019-04-01 09:57:40',NULL,0,0,'Hs36c4','很高兴遇见你！','{\"userName\":\"两仪式\",\"createTime\":1554083500007,\"captcha\":\"Hs36c4\",\"email\":\"569252295@qq.com\",\"userDate\":1554083500007}'),(1114718829432786945,1554604654005527,'508284102@qq.com',1,'2019-04-07 10:37:32','2019-04-07 10:37:32','2019-04-07 10:43:32',NULL,0,0,'ax3x6G','很高兴遇见你！','{\"userName\":\"番茄酱\",\"createTime\":1554604652262,\"captcha\":\"ax3x6G\",\"email\":\"508284102@qq.com\",\"userDate\":1554604652264}'),(1114721008956723201,1554605173642047,'1026467837@qq.com',1,'2019-04-07 10:46:12','2019-04-07 10:46:12','2019-04-07 10:52:12',NULL,0,0,'xYeY98','很高兴遇见你！','{\"userName\":\"Nikii\",\"createTime\":1554605172197,\"captcha\":\"xYeY98\",\"email\":\"1026467837@qq.com\",\"userDate\":1554605172199}');
/*!40000 ALTER TABLE `os_email` ENABLE KEYS */;
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
