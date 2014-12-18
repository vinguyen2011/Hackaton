CREATE DATABASE  IF NOT EXISTS `Jedi` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Jedi`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: Jedi
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `campaign`
--

DROP TABLE IF EXISTS `campaign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `campaign` (
  `idcampaign` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  `target_amount` decimal(7,2) NOT NULL,
  `current_amount` decimal(7,2) NOT NULL DEFAULT '0.00',
  `Currency` varchar(45) NOT NULL DEFAULT 'Euro',
  `id_receiving_account` varchar(50) NOT NULL,
  `creator_username` varchar(50) NOT NULL,
  `image_url` varchar(500) DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  `date` varchar(50) NOT NULL,
  PRIMARY KEY (`idcampaign`),
  KEY `fk_campaign_bank_account_idx` (`id_receiving_account`),
  KEY `fk_campaign_user1_idx` (`creator_username`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campaign`
--

LOCK TABLES `campaign` WRITE;
/*!40000 ALTER TABLE `campaign` DISABLE KEYS */;
INSERT INTO `campaign` VALUES (1,'Birthday party','It\'s Mary\'s 5th birthday!!!',1200.00,1018.66,'EUR','NL31INGX0007946820','UID14201','http://www.happyholidays2014.com/wp-content/uploads/2014/01/Happy-Birthday-Cake-Photos-HD-Wallpaper-1.jpg','Party','2014-11-12 16:00:00'),(99,'Office Present','UNWINDED',0.00,0.00,'EUR','NL31INGX0007946820','UID14201','http://thegift.com/wp-content/uploads/2013/09/Screen-Shot-2013-09-03-at-3.21.38-PM.png','UNWINDED','2014-11-12 16:10:00'),(101,'Graduation present','UNWINDED',0.00,0.00,'EUR','NL31INGX0007946820','UID14201','http://3.bp.blogspot.com/-5SyBtUhC4dw/UFp6p_iiDlI/AAAAAAAADSQ/nbIyqgr-l2o/s1600/4010991630_b30ffb702f.jpg','UNWINDED','2014-11-12 16:30:00'),(102,'Gift for a colleague','Danny is leaving',50.00,15.00,'EUR','NL31INGX0007946820','UID14201','https://spoileralert22.files.wordpress.com/2013/05/the-office-finale-human-resources-600x320.jpg','Office gift','2014-11-12 20:00:00'),(103,'For a Green Gotham','For our local sustainability activities',2000.00,4050.00,'EUR','NL31INGX0007946820','UID14201','http://www.nrel.gov/learning/images/photo_10864.jpg','Friend in need','2014-11-12 21:46:00'),(104,'Charitable cause','For orphans in Ghana',1705.00,550.00,'EUR','NL31INGX0007946820','UID14201','http://besteducation.org.uk/uploads/images/AfricanKids.jpg','Charity','2014-11-12 22:10:00'),(105,'Jessy has a boy!','Let\'s organise a baby shower! ^^',200.00,100.00,'EUR','NL26INGX0003097446','UID14204','http://toptenintheworld.com/wp-content/uploads/2014/09/child3.jpg','Baby shower','2014-11-12 22:13:00'),(106,'Graduation party','Radioactive party<3',250.00,50.00,'EUR','NL83INGX0001221893','UID14203','http://3.bp.blogspot.com/-5SyBtUhC4dw/UFp6p_iiDlI/AAAAAAAADSQ/nbIyqgr-l2o/s1600/4010991630_b30ffb702f.jpg','Party','2014-11-12 22:15:00'),(107,'Emergency fund for Han','He is having a surgery',3000.00,1500.00,'EUR','NL83INGX0001221893','UID14203','http://www.hear-the-world.com/uploads/pics/ThankYou_02.jpg','Friend in need','2014-11-12 22:39:00'),(108,'Honeymoon trip','Special gift for Mary',1500.00,1600.00,'EUR','NL26INGX0003097446','UID14204','http://www.galaxytravelholidays.com/wp-content/uploads/2013/04/Honeymoon-Couples-in-Varca-Beach.jpg','Friend in need','2014-11-13 08:20:00'),(109,'Karen needs surgery','Please let\'s get some money together for Karen!',30000.00,400.00,'EUR','NL31INGX0007946820','UID14201','http://animalpetdoctor.homestead.com/surg2.jpg','Friend in need','2014-11-13 08:46:00'),(110,'A boat to share','Let\'s save up money to buy a boat together!',8250.00,8282.74,'EUR','NL31INGX0007946820','UID14201','http://www.blazerboats.com/boat_photos/boat41_large.jpg','Family','2014-11-13 09:24:00'),(111,'Skateboard','Skateboard for my birthday!',60.00,47.00,'EUR','NL31INGX0007946820','UID14201','http://i00.i.aliimg.com/wsphoto/v0/1388087312/Top-Selling-Adult-maple-font-b-skateboard-b-font-font-b-Deck-b-font-.jpg','Family','2014-11-13 09:26:00'),(115,'DJ for my party','Let\'s get a super awesome DJ for my party.',2000.00,0.00,'EUR','NL31INGX0007946820','UID14201','http://upload.wikimedia.org/wikipedia/commons/2/27/Armin_van_buuren_odi_jin.jpg','Party','2014-11-13 01:54:20'),(116,'Small cocktail party','I want to organize a small cocktail party for Linda in January.',250.00,0.00,'EUR','NL31INGX0007946820','UID14201','http://www.personalitytutor.com/files/2012/04/Cocktail-Party-Etiquette.jpg','Party','2014-11-13 02:12:01'),(117,'Baby shower for Linda','Baby shower for Linda in February.',75.00,0.00,'EUR','NL31INGX0007946820','UID14201','http://www.partyideasuk.co.uk/Portals/0/Blue baby Shower/Blue-baby-shower-cat-image.jpg','Baby shower','2014-11-13 02:14:42'),(118,'Fred is leaving','Let\'s buy him something nice.',100.00,0.00,'EUR','NL31INGX0007946820','UID14201','http://a57.foxnews.com/global.fbnstatic.com/static/managed/img/fb2/660/371/fired_leaving_office.jpg?ve=1','Office gift','2014-11-13 02:16:34');
/*!40000 ALTER TABLE `campaign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contribution`
--

DROP TABLE IF EXISTS `contribution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contribution` (
  `idcontribution` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(7,2) NOT NULL,
  `currency` varchar(45) NOT NULL DEFAULT 'Euro',
  `date` datetime NOT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `id_campaign` int(11) NOT NULL,
  `id_contributing_account` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `username_contributor` varchar(150) NOT NULL,
  PRIMARY KEY (`idcontribution`),
  KEY `fk_contribution_campaign1_idx` (`id_campaign`),
  KEY `fk_contribution_bank_account1_idx` (`id_contributing_account`),
  CONSTRAINT `fk_contribution_campaign1` FOREIGN KEY (`id_campaign`) REFERENCES `campaign` (`idcampaign`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contribution`
--

LOCK TABLES `contribution` WRITE;
/*!40000 ALTER TABLE `contribution` DISABLE KEYS */;
INSERT INTO `contribution` VALUES (1,400.00,'EUR','2014-11-12 00:00:00','Office Present',99,'NL31INGX0007946820','Jedi','UID14201'),(2,400.00,'EUR','2014-11-12 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(3,100.00,'EUR','2014-11-12 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(4,100.00,'EUR','2014-11-12 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(5,300.00,'EUR','2014-11-12 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(6,1000.00,'EUR','2014-11-12 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(7,20.00,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','blabla','UID14201'),(8,20.00,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','blabla','UID14201'),(9,20.00,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','blabla','UID14201'),(10,41.00,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','blabla2','UID14201'),(11,13.95,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','blabla2','UID14201'),(12,13.12,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','blabla2','UID14201'),(13,1.00,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','blabla2','UID14201'),(14,1.13,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','another contrib','UID14201'),(15,22.22,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','for you :)','UID14201'),(16,22.22,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','for you :)','UID14201'),(17,22.22,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','for you too :)','UID14201'),(18,22.22,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','yay','UID14201'),(19,70.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(20,70.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(21,70.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(22,10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(23,20.00,'undefined','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','Some message','UID14201'),(24,20.00,'undefined','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','Some message','UID14201'),(25,20.00,'undefined','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','Some message.','UID14201'),(26,21.00,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','Some message.','UID14201'),(27,21.00,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','Some message.','UID14201'),(28,1.00,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','Hi :)','UID14201'),(29,1.00,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','hi','UID14201'),(30,10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(31,-400.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','','UID14201'),(32,-100.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','','UID14201'),(33,10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL88INGX0004695747','Jedi','UID14202'),(34,-10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','','UID14201'),(35,-20.00,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','PURGE contribution #7','UID14201'),(36,-20.00,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','PURGE contribution #8','UID14201'),(37,-20.00,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','PURGE contribution #9','UID14201'),(38,-41.00,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','PURGE contribution #10','UID14201'),(39,-13.95,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','PURGE contribution #11','UID14201'),(40,-13.12,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','PURGE contribution #12','UID14201'),(41,-1.00,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','PURGE contribution #13','UID14201'),(42,-1.13,'EUR','2014-11-13 00:00:00','Graduation present for Penny',101,'NL31INGX0007946820','PURGE contribution #14','UID14201'),(43,-400.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #1','UID14201'),(44,-400.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #2','UID14201'),(45,-100.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #3','UID14201'),(46,-100.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #4','UID14201'),(47,-300.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #5','UID14201'),(48,-1000.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #6','UID14201'),(49,-22.22,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #17','UID14201'),(50,-70.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #19','UID14201'),(51,-70.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #20','UID14201'),(52,-70.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #21','UID14201'),(53,-10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #22','UID14201'),(54,-10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #30','UID14201'),(55,-10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #33','UID14201'),(56,10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','Jedi','UID14201'),(57,-400.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #1','UID14201'),(58,-400.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #2','UID14201'),(59,-100.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #3','UID14201'),(60,-100.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #4','UID14201'),(61,-300.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #5','UID14201'),(62,-1000.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #6','UID14201'),(63,-22.22,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #17','UID14201'),(64,-70.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #19','UID14201'),(65,-70.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #20','UID14201'),(66,-70.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #21','UID14201'),(67,-10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #22','UID14201'),(68,-10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #30','UID14201'),(69,-10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #33','UID14201'),(70,-10.00,'EUR','2014-11-13 00:00:00','Office Present',99,'NL31INGX0007946820','PURGE contribution #56','UID14201'),(71,500.00,'EUR','2014-11-13 00:00:00','Charitable cause',104,'NL83INGX0001221893','Jedi','UID14203'),(72,30.00,'EUR','2014-11-13 00:00:00','Jessy has a boy!',105,'NL83INGX0001221893','Jedi','UID14203'),(73,20.00,'EUR','2014-11-13 00:00:00','Jessy has a boy!',105,'NL88INGX0004695747','Jedi','UID14202'),(74,1.00,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','Hi','UID14201'),(75,50.00,'EUR','2014-11-13 00:00:00','Graduation party',106,'NL88INGX0004695747','Jedi','UID14202'),(76,50.00,'EUR','2014-11-13 00:00:00','Jessy has a boy!',105,'NL88INGX0004695747','Jedi','UID14202'),(77,50.00,'EUR','2014-11-13 00:00:00','Charitable cause',104,'NL26INGX0003097446','Jedi','UID14204'),(78,500.00,'EUR','2014-11-13 00:00:00','Emergency fund for Han',107,'NL26INGX0003097446','Jedi','UID14204'),(79,1000.00,'EUR','2014-11-13 00:00:00','Emergency fund for Han',107,'NL83INGX0001221893','Hope this helps','UID14203'),(80,100.00,'EUR','2014-11-13 00:00:00','Honeymoon trip',108,'NL83INGX0001221893','Hope this helps','UID14203'),(81,200.00,'EUR','2014-11-13 00:00:00','Honeymoon trip',108,'NL31INGX0007946820','Nice idea','UID14201'),(82,300.00,'EUR','2014-11-13 00:00:00','Honeymoon trip',108,'NL26INGX0003097446','Nice idea','UID14204'),(83,500.00,'EUR','2014-11-13 00:00:00','Honeymoon trip',108,'NL26INGX0003097446','Nice idea','UID14204'),(84,500.00,'EUR','2014-11-13 00:00:00','Honeymoon trip',108,'NL88INGX0004695747','Nice idea','UID14202'),(85,500.00,'EUR','2014-11-13 00:00:00','For a Green Gotham',103,'NL83INGX0001221893','Hope this helps','UID14203'),(86,500.00,'EUR','2014-11-13 00:00:00','For a Green Gotham',103,'NL88INGX0004695747','Hope this helps','UID14202'),(87,15.00,'EUR','2014-11-13 00:00:00','Gift for a colleague',102,'NL31INGX0007946820','Good for you','UID14201'),(88,1000.00,'EUR','2014-11-13 00:00:00','For a Green Gotham',103,'NL31INGX0007946820','Hope this helps','UID14201'),(89,50.00,'EUR','2014-11-13 00:00:00','For a Green Gotham',103,'NL26INGX0003097446','Hope this helps','UID14204'),(90,400.00,'EUR','2014-11-13 00:00:00','Karen needs surgury',109,'NL31INGX0007946820','Get better soon!','UID14201'),(91,800.00,'EUR','2014-11-13 00:00:00','A boat to share',110,'NL31INGX0007946820','Good initiative.','UID14201'),(92,2700.00,'EUR','2014-11-13 00:00:00','A boat to share',110,'NL31INGX0007946820','Super.','UID14201'),(93,2750.50,'EUR','2014-11-13 00:00:00','A boat to share',110,'NL31INGX0007946820','Let\'s do it!','UID14201'),(94,1032.24,'EUR','2014-11-13 00:00:00','A boat to share',110,'NL31INGX0007946820','I want a boat!','UID14201'),(95,700.00,'EUR','2014-11-13 00:00:00','A boat to share',110,'NL31INGX0007946820','I am in!','UID14201'),(96,300.00,'EUR','2014-11-13 00:00:00','A boat to share',110,'NL31INGX0007946820','Just for you','UID14201'),(97,40.00,'EUR','2014-11-13 00:00:00','Skateboard',111,'NL31INGX0007946820','for you','UID14201'),(98,2000.00,'EUR','2014-11-13 00:00:00','For a Green Gotham',103,'NL26INGX0003097446','Hope this helps','UID14204'),(99,20.00,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','For you','UID14201'),(100,25.00,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','Again.','UID14201'),(101,1.00,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL31INGX0007946820','Seriously?','UID14201'),(102,1.00,'EUR','2014-11-13 00:00:00','Birthday party',1,'NL26INGX0003097446','Now?','UID14204'),(103,2.00,'EUR','2014-11-13 00:00:00','Skateboard',111,'NL26INGX0003097446','With love.','UID14204'),(104,5.00,'EUR','2014-11-13 00:00:00','Skateboard',111,'NL26INGX0003097446','Voor jou :)','UID14204');
/*!40000 ALTER TABLE `contribution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `image` varchar(500) DEFAULT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `access_token` varchar(500) DEFAULT NULL,
  `apkey` varchar(100) NOT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'UID14201','12345','Vi.Nguyen2@ing.nl','http://www.babynameslog.com/wp-content/uploads/2013/12/baby-girl-names-2014.jpg','john','doe','eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMDc3MzksIm5vbmNlIjoiMWJlMTQwZTEtOTE4Yy00MDY1LWE4MDAtMjUyYjA1ODA0MDY4IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNDIwMSIsImp0aSI6ImEyMzNjNmM5LWRhMTQtNGRhMC1iNDhiLWU1YThmZGEyYzVhZCIsImlhdCI6MTQxNTc4NDk5Mn0.a9HQzKwA4iC1IYKa1X5DURzIesS1t32AJCPdxgfZFdg','[B@13af9d11'),(7,'UID14202','1234','thanhvi.ng@gmail.com','https://image-cdn.zap2it.com/images/sabrina-carpenter-girl-meets-world.jpg','Boris','romero','eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMjMxMDEsIm5vbmNlIjoiYjVkMjJmNzMtZjllZi00NDE0LTgxMzMtYTE4MDlkOTAxMmMwIiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNDIwMiIsImp0aSI6ImNlOWE3YmZkLTk1NmEtNGZhYS05N2Q0LWZhOGIwYzEzNjA3OCIsImlhdCI6MTQxNTgwMDM1M30.XJgwwlzyFpwvlWeHLikoLuCdl5ZFVxQ91n6KdbZojN4','[n@13af9d1c'),(8,'dabroek@gmail.com','qwerty','dabroek@gmail.com','http://4.bp.blogspot.com/-KKHf_YNt2dg/ULjgwohj9dI/AAAAAAAAA0w/45-KDSYpnm0/s1600/Nice+Guy.jpg','Matthijs','Dabroek',NULL,'zB@43af9d1c'),(9,'UID14204','1234','test4@testing.com','http://img.timeinc.net/time/photoessays/2011/guy_fawkes_1104/guy_fawkes_01.jpg','Ano','nymous','eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwODc0NTQsIm5vbmNlIjoiMjkwZWE2N2YtYzhkNS00NTUyLWIyNDktNTMxM2JlMTc2ZDljIiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNDIwNCIsImp0aSI6IjZkOWZiYzYwLWQ4OWItNDEzMi1iNjVjLWVjOTM0YWE1MDNjNSIsImlhdCI6MTQxNTg2NDcwN30.huSRzR6SS87V6vN3_k3Ouyq-_PGX9dYgeIFiH56roLk','pB@13af9d1c'),(12,'UID14203','1234','wezelman@hotmail.com','http://www.playbillsvspayingbills.com/wp-content/uploads/2009/10/ben-whitehair-business-guy-headshot.jpg','Dan','Brown','eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwODcxMDksIm5vbmNlIjoiY2YwMzEwZDEtNWFiNC00NzBkLWExY2UtMWZlZWE2M2UxZjFkIiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNDIwMyIsImp0aSI6ImMyMWJiYWI0LTJmYjgtNGY2ZS05OGZkLTNlN2ViNzJlN2E3MyIsImlhdCI6MTQxNTg2NDM2Mn0.-WT6Ec7A1tGwgsgd32F-BIi8Yhwv19UefDcXNnU3T-g','[B@13af9d1c');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-18 10:50:47
