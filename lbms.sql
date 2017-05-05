-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: lbms
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator` (
  `admid` int(11) NOT NULL AUTO_INCREMENT,
  `itemid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `username` char(9) NOT NULL,
  PRIMARY KEY (`admid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (3,NULL,'埃罗芒阿','男','13992477466','04143160');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `batch`
--

DROP TABLE IF EXISTS `batch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `batch` (
  `batid` int(11) NOT NULL AUTO_INCREMENT,
  `itemid` int(11) DEFAULT NULL,
  `teaid` int(11) DEFAULT NULL,
  `laboratory` varchar(45) DEFAULT NULL,
  `date` char(50) NOT NULL,
  `segmentation` varchar(20) DEFAULT NULL,
  `sure` int(11) DEFAULT '0',
  PRIMARY KEY (`batid`),
  KEY `fk_batch_1_idx` (`itemid`),
  KEY `fk_batch_2_idx` (`teaid`),
  CONSTRAINT `fk_batch_1` FOREIGN KEY (`itemid`) REFERENCES `item` (`itemid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_batch_2` FOREIGN KEY (`teaid`) REFERENCES `teacher` (`teaid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `batch`
--

LOCK TABLES `batch` WRITE;
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` VALUES (16,4,NULL,'a222','2017-05-05','2',0),(17,4,5,'ff201','2017-07-02','4',2);
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cipher`
--

DROP TABLE IF EXISTS `cipher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cipher` (
  `cipid` int(11) NOT NULL AUTO_INCREMENT,
  `admid` int(11) DEFAULT NULL,
  `teaid` int(11) DEFAULT NULL,
  `numid` int(11) DEFAULT NULL,
  `cipher` varchar(50) DEFAULT NULL,
  `power` varchar(50) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cipid`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_cipher_3_idx` (`numid`),
  KEY `fk_cipher_1_idx` (`admid`),
  KEY `fk_cipher_2_idx` (`teaid`),
  CONSTRAINT `fk_cipher_1` FOREIGN KEY (`admid`) REFERENCES `administrator` (`admid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cipher_2` FOREIGN KEY (`teaid`) REFERENCES `teacher` (`teaid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cipher_3` FOREIGN KEY (`numid`) REFERENCES `student` (`numid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cipher`
--

LOCK TABLES `cipher` WRITE;
/*!40000 ALTER TABLE `cipher` DISABLE KEYS */;
INSERT INTO `cipher` VALUES (20,3,NULL,NULL,'11111111','1','04143160'),(21,NULL,NULL,4,'11111111','3','04141076'),(22,NULL,NULL,5,'11111111','3','04141089'),(23,NULL,5,NULL,'11111111','2','01010101'),(24,NULL,NULL,6,'11111111','3','04151020'),(25,NULL,NULL,7,'11111111','3','4143160.0'),(26,NULL,NULL,8,'11111111','3','1.4010101E7'),(27,NULL,NULL,9,'11111111','3','1.3010101E7'),(28,NULL,NULL,10,'11111111','3','1.2020311E7'),(29,NULL,NULL,11,'11111111','3','1.1020311E7'),(30,NULL,NULL,12,'11111111','3','1.2050533E7'),(31,NULL,NULL,13,'11111111','3','1.2050534E7');
/*!40000 ALTER TABLE `cipher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `itemname` varchar(50) DEFAULT NULL,
  `term` varchar(50) DEFAULT NULL,
  `coursename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (4,'杠杆的平衡原理','2017-1','大学物理'),(5,'杨氏模量','2017-2','大学物理'),(6,'哈夫曼树','2016-2','数据结构');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `noticeid` int(11) NOT NULL AUTO_INCREMENT,
  `noticetile` varchar(50) DEFAULT NULL,
  `noticecontent` varchar(255) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`noticeid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (4,NULL,'从今天开始放假了','2017-05-04 18:33:15');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `numid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `specialization` varchar(20) DEFAULT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `contact` varchar(50) DEFAULT NULL,
  `username` char(12) NOT NULL,
  PRIMARY KEY (`numid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (4,'工藤新一','0','2014','计科1403','2017-05-04 18:16:34','123456789','04141076'),(5,'毛利兰','1','2014','计科1403','2017-05-04 18:17:11','789456123','04141089'),(6,'张杰','0','2015','音乐1503','2017-05-04 18:38:13','123456789','04151020'),(7,'喵帕斯','女','2014.0','软件1405','2017-05-05 09:31:44','1.3992477466E10','4143160.0'),(8,'蒲心语','女','2014.0','计科1403','2017-05-05 14:09:07','1.8392677805E10','1.4010101E7'),(9,'陈彤','男','2013.0','通工1302','2017-05-05 14:09:07','1.23456789E8','1.3010101E7'),(10,'张杰','男','2012.0','音乐1202','2017-05-05 14:09:07','1.547896321E9','1.2020311E7'),(11,'谢娜','女','2011.0','主持1104','2017-05-05 14:09:07','1.47258369E8','1.1020311E7'),(12,'吴昕','女','2012.0','主持1202','2017-05-05 14:09:07','2.58369147E8','1.2050533E7'),(13,'何炅','男','2012.0','主持1203','2017-05-05 14:09:07','1.47258369E8','1.2050534E7');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teaid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `contact` varchar(50) DEFAULT NULL,
  `username` char(9) NOT NULL,
  PRIMARY KEY (`teaid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (5,'江户川柯南','0','通工院','博士','2017-05-04 18:18:18','147258369','01010101');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `testid` int(11) NOT NULL AUTO_INCREMENT,
  `batid` int(11) DEFAULT NULL,
  `numid` int(11) DEFAULT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `results` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`testid`),
  KEY `fk_test_1_idx` (`batid`),
  KEY `fk_test_2_idx` (`numid`),
  CONSTRAINT `fk_test_1` FOREIGN KEY (`batid`) REFERENCES `batch` (`batid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_test_2` FOREIGN KEY (`numid`) REFERENCES `student` (`numid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (5,17,4,'计科1403',89,NULL);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiyou_schedule`
--

DROP TABLE IF EXISTS `xiyou_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiyou_schedule` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `major` varchar(20) NOT NULL COMMENT '专业',
  `class` varchar(20) NOT NULL COMMENT '班级',
  `week` tinyint(4) DEFAULT NULL COMMENT '星期',
  `first_course` varchar(50) DEFAULT NULL COMMENT '第一节课程',
  `first_teacher` varchar(200) DEFAULT NULL COMMENT '第一节老师',
  `first_room` varchar(30) DEFAULT NULL COMMENT '第一节教室',
  `second_course` varchar(50) DEFAULT NULL COMMENT '第二节课程',
  `second_teacher` varchar(200) DEFAULT NULL COMMENT '第二节老师',
  `second_room` varchar(30) DEFAULT NULL COMMENT '第二节教室',
  `third_course` varchar(50) DEFAULT NULL COMMENT '第三节课程',
  `third_teacher` varchar(200) DEFAULT NULL COMMENT '第三节老师',
  `third_room` varchar(30) DEFAULT NULL COMMENT '第三节教室',
  `fourth_course` varchar(50) DEFAULT NULL COMMENT '第四节课程',
  `fourth_teacher` varchar(200) DEFAULT NULL COMMENT '第四节老师',
  `fourth_room` varchar(30) DEFAULT NULL COMMENT '第四节教室',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiyou_schedule`
--

LOCK TABLES `xiyou_schedule` WRITE;
/*!40000 ALTER TABLE `xiyou_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `xiyou_schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-05 22:13:53
