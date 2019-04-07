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
-- Table structure for table `os_product`
--

DROP TABLE IF EXISTS `os_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `os_product` (
  `product_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `category_id` bigint(20) unsigned DEFAULT NULL COMMENT '分类id',
  `label_id` int(10) DEFAULT NULL COMMENT '标签ID',
  `name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `show_score` int(11) DEFAULT NULL COMMENT '显示积分',
  `show_price` decimal(10,2) DEFAULT NULL COMMENT '显示价格',
  `introduce` varchar(64) DEFAULT NULL COMMENT '商品简介',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '展示图片',
  `product_number` bigint(20) unsigned DEFAULT NULL COMMENT '商品编号',
  `show_in_nav` tinyint(2) DEFAULT '0' COMMENT '是否导航栏 1=显示/0=隐藏',
  `show_in_hot` tinyint(2) DEFAULT '0' COMMENT '是否热门 1=热门/0=默认',
  `show_in_shelve` tinyint(2) DEFAULT '0' COMMENT '是否上架：1=上架/0=下架',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建者',
  `shelve_time` datetime DEFAULT NULL COMMENT '上架时间',
  `shelve_by` varchar(64) DEFAULT NULL COMMENT '上架人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新者',
  `search_key` varchar(255) DEFAULT NULL COMMENT '搜索关键词',
  `page_title` varchar(64) DEFAULT NULL COMMENT '页面标题',
  `page_description` varchar(255) DEFAULT NULL COMMENT '页面描述',
  `page_keyword` varchar(64) DEFAULT NULL COMMENT '页面关键词',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `show_in_top` tinyint(2) DEFAULT '0' COMMENT '是否置顶 1=置顶/0=默认',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `os_product`
--

LOCK TABLES `os_product` WRITE;
/*!40000 ALTER TABLE `os_product` DISABLE KEYS */;
INSERT INTO `os_product` VALUES (1,NULL,1,'小米手机5',2299,2299.00,'支持手机分身，能刷公交卡、银行卡','images/goods/20170226/1471798318820.png',1472581220748,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','小米5,小米手机5,小米5手机,小米 5','小米手机5','小米手机5 十余项黑科技，很轻狠快。骁龙820处理器，最大可选4GB内存+128GB闪存，4轴防抖相机，3D陶瓷/玻璃机身。','小米5,小米手机5,小米5手机,小米 5,猫宁商城',NULL,1),(2,NULL,2,'小米MIX',3499,3499.00,'全面屏概念手机','images/goods/20170226/1471798364441.jpg',1472581245880,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','小米MIX,小米手机,超大屏','小米MIX','小米MIX 全面屏概念手机，开创性的在6.4寸超大屏幕上，做到了惊人的91.3%。当你点亮屏幕的一瞬间，200多万颗像素的色彩，开满了整个屏幕。','小米MIX,猫宁商城',NULL,1),(3,NULL,2,'魅蓝 Note5',1099,1099.00,'快的更漂亮，薄的更持久','images/goods/20170226/1471798388806.jpg',1472581300305,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','魅蓝 Note5,魅族','魅蓝 Note5','魅蓝 Note5，正品行货，另有魅蓝 Note5详细介绍、图片、价格、参数、售前咨询等，购买魅蓝 Note5上魅族商城，全场包邮，7天无理由退货，15天换货保障。','魅蓝 Note5,魅族,猫宁商城',NULL,1),(4,NULL,3,'小米手环 2',149,149.00,'看得见的时刻，和你的每一步','images/goods/20170226/1471798568000.jpg',1472583774201,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','小米手环2,小米手环2代,手环,智能手环','小米手环2','全新的小米手环 2，加入了 OLED 显示屏，通过轻触圆形按键，即可显示当前时间、步数、心率，甚至里程、热量等更多数据。当不方便触控操作时，抬起手腕，手环便可自动显示当前时间，轻松便捷。','小米手环2,小米手环2代,猫宁商城',NULL,1),(5,NULL,NULL,'魅族手环',229,229.00,'腕间流动的心率专家','images/goods/20170226/1471798587971.jpg',1472583831117,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','魅族手环,魅族,手环,智能手环','魅族手环','魅族手环，腕间流动的心率专家，正品行货，另有魅族手环详细介绍、图片、价格、参数、售前咨询等，购买魅族手环上魅族商城，全场包邮，7天无理由退货，15天换货保障。','魅族手环,魅族,手环,智能手环,猫宁商城',NULL,1),(6,NULL,NULL,'LED 智能台灯',169,169.00,'照明之上，光的艺术品','images/goods/20170226/1471798587451.jpg',1472628630086,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','小米台灯,小米LED灯,LED小米灯,小米 LED灯','LED 智能台灯','米家LED智能台灯的色温与亮度可以无级调节，几乎可以满足用户对光线的所有需求。还针对最常见的四种使用场景单独做了光线优化，专注保护用户的双眼。','小米台灯,小米LED灯,LED小米灯,小米 LED灯,猫宁商城',NULL,1),(7,NULL,NULL,'Yeelight床头灯',249,249.00,'触摸式操作 给卧室1600万种颜色','images/goods/20170226/1471799887971.jpg',1472736931796,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','Yeelight床头灯,床头灯,智能灯','Yeelight床头灯','官网正品智能灯推荐，Yeelight床头灯最新价格249元，有多种颜色可选，另有Yeelight床头灯详细介绍及图片，还有用户评价，售前咨询等。','Yeelight床头灯,床头灯,智能灯,猫宁商城',NULL,1),(8,NULL,NULL,'Yeelight LED智能灯泡',99,99.00,'亮度自由调节 WIFI远程操作','images/goods/20170226/1471798581451.jpg',1473318741286,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','Yeelight LED智能灯泡 白光版,智能灯泡','Yeelight LED智能灯泡','Yeelight LED 智能灯泡,亮度自由调节 WIFI远程操作','Yeelight LED智能灯泡 白光版,智能灯泡,猫宁商城',NULL,1),(9,NULL,NULL,'测试商品名称1',166,166.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1473685327798,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称1','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(10,NULL,NULL,'测试商品名称2',223,223.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1474910562755,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称2','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(11,NULL,4,'测试商品名称3',166,166.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1475353900453,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称3','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(12,NULL,NULL,'测试商品名称4',124,124.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1475353918562,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称4','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(13,NULL,NULL,'测试商品名称5',249,249.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1475354006972,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称5','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(14,NULL,NULL,'测试商品名称6',219,219.00,'测试描述，测试商品描述，测试商品描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1475407186147,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称6','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(15,NULL,1,'测试商品名称7',2366,2366.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1475947762038,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称7','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(16,NULL,NULL,'测试商品名称8',2499,2499.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1475996329018,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称8','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(17,NULL,NULL,'测试商品名称9',2188,2188.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1477472951669,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称9','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(18,NULL,1,'测试商品名称10',249,249.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478099883634,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称10','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(19,NULL,NULL,'测试商品名称11',1300,1300.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478522533460,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称11','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(20,NULL,NULL,'测试商品名称12',179,179.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478527872182,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称12','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(21,NULL,NULL,'测试商品名称13',6429,6429.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478680540669,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称13','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(22,NULL,NULL,'测试商品名称14',2416,2416.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478682438293,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称14','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(23,NULL,NULL,'测试商品名称15',219,219.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478682709405,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称15','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(24,NULL,NULL,'测试商品名称16',295,295.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478682831935,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称16','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(25,NULL,NULL,'测试商品名称17',2164,2164.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478682893916,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称17','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(26,NULL,NULL,'测试商品名称18',146,146.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478683391099,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称18','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(27,NULL,NULL,'测试商品名称19',26,26.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478683407372,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称19','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(28,NULL,NULL,'测试商品名称20',4974,4974.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478683468241,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称20','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(29,NULL,NULL,'测试商品名称21',265,265.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478683468246,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称21','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(30,NULL,NULL,'测试商品名称22',259,259.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478683468279,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称22','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(31,NULL,NULL,'测试商品名称23',789,789.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478689468277,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称23','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(32,NULL,NULL,'测试商品名称24',456,456.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478689468979,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称24','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(33,NULL,NULL,'测试商品名称25',7845,7845.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478689448279,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称25','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1),(34,NULL,NULL,'测试商品名称26',1548,1548.00,'测试描述，测试商品描述','images/goods/20170226/1471797894441.jpg',1478689468679,1,1,1,'2019-02-24 00:00:00','小米',NULL,NULL,'2019-02-24 00:00:00','小米','测试搜索，测试商品搜索','测试商品名称26','测试商品页面描述,测试商品页面描述','测试商品页面关键词','',1);
/*!40000 ALTER TABLE `os_product` ENABLE KEYS */;
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