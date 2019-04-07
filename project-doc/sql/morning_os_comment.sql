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
-- Table structure for table `os_comment`
--

DROP TABLE IF EXISTS `os_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_comment` (
  `comment_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '评价ID',
  `product_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(30) DEFAULT NULL COMMENT '昵称',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `star` tinyint(4) DEFAULT NULL COMMENT '评论星级：1,2,3,4,5',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `good_count` int(11) DEFAULT '0' COMMENT '好评数',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态：1.显示；0.隐藏',
  `type` tinyint(2) DEFAULT '0' COMMENT '评论类型：1,优质；0,普通',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='评价表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_comment`
--

LOCK TABLES `os_comment` WRITE;
/*!40000 ALTER TABLE `os_comment` DISABLE KEYS */;
INSERT INTO `os_comment` VALUES (1,21,1,'穿鞋子的猫','default/avatar/avatar_8.jpg',1,5,'价格实惠，外观好看，还有盒子便于保管，不错。',53,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(3,22,1,'测试评价人1','default/avatar/avatar_4.jpg',1,5,'测试评价内容，测试评价内容，测试评价内容，测试评价内容。',3,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(4,23,1,'测试评价人2','default/avatar/avatar_5.jpg',1,5,'测试评价内容，测试评价内容，测试评价内容，测试评价内容。',4,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(5,24,1,'测试评价人3','default/avatar/avatar_8.jpg',1,5,'测试评价内容，测试评价内容，测试评价内容，测试评价内容。',5,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(6,6,1,'测试评价人4','default/avatar/avatar_4.jpg',1,5,'测试评价内容，测试评价内容，测试评价内容，测试评价内容。',6,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(7,5,1,'测试评价人5','default/avatar/avatar_5.jpg',1,5,'测试评价内容，测试评价内容，测试评价内容，测试评价内容。',7,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(8,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg',1,5,'价格实惠，外观好看，还有盒子便于保管，不错。',53,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(9,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg',1,5,'价格实惠，外观好看，还有盒子便于保管，不错。',53,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(10,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg',1,5,'价格实惠，外观好看，还有盒子便于保管，不错。',95,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(11,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg',1,5,'价格实惠，外观好看，还有盒子便于保管，不错。',52,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(12,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg',1,5,'价格实惠，外观好看，还有盒子便于保管，不错。',57,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(13,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg',1,5,'价格实惠，外观好看，还有盒子便于保管，不错。',5,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(14,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg',1,5,'价格实惠，外观好看，还有盒子便于保管，不错。',52,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(15,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg',1,5,'价格实惠，外观好看，还有盒子便于保管，不错。',52,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(16,1,1,'测试评价人3','default/avatar/avatar_8.jpg',1,5,'测试评价内容，测试评价内容，测试评价内容，测试评价内容。',5,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(17,1,1,'测试评价人4','default/avatar/avatar_4.jpg',1,5,'测试评价内容，测试评价内容，测试评价内容，测试评价内容。',6,1,1,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(18,1,1,'测试评价人5','default/avatar/avatar_5.jpg',1,5,'测试评价内容，测试评价内容，测试评价内容，测试评价内容。',7,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(19,1,1,'穿鞋子的猫','default/avatar/avatar_8.jpg',1,5,'价格实惠，外观好看，还有盒子便于保管，不错。',52,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米'),(20,1,1,'测试评价人4','default/avatar/avatar_4.jpg',1,5,'测试评价内容，测试评价内容，测试评价内容，测试评价内容。',7,1,0,'2019-02-24 00:00:00','小米','2019-02-24 00:00:00','小米');
/*!40000 ALTER TABLE `os_comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 20:02:12
