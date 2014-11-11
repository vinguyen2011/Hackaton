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
-- Table structure for table `bank_account`
--

DROP TABLE IF EXISTS `bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank_account` (
  `idbank_account` int(11) NOT NULL AUTO_INCREMENT,
  `account_number` varchar(45) NOT NULL,
  `bank_holder` varchar(100) NOT NULL,
  `bank_name` varchar(45) NOT NULL,
  `id_owner_user` int(11) NOT NULL,
  PRIMARY KEY (`idbank_account`,`id_owner_user`),
  KEY `fk_bank_account_user1_idx` (`id_owner_user`),
  CONSTRAINT `fk_bank_account_user1` FOREIGN KEY (`id_owner_user`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account`
--

LOCK TABLES `bank_account` WRITE;
/*!40000 ALTER TABLE `bank_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank_account` ENABLE KEYS */;
UNLOCK TABLES;

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
  `target_amount` decimal(7,0) NOT NULL,
  `current_amount` decimal(7,0) NOT NULL DEFAULT '0',
  `Currency` varchar(45) NOT NULL DEFAULT 'Euro',
  `id_receiving_account` int(11) NOT NULL,
  `id_creator_user` int(11) NOT NULL,
  PRIMARY KEY (`idcampaign`,`id_receiving_account`,`id_creator_user`),
  KEY `fk_campaign_bank_account_idx` (`id_receiving_account`),
  KEY `fk_campaign_user1_idx` (`id_creator_user`),
  CONSTRAINT `fk_campaign_bank_account` FOREIGN KEY (`id_receiving_account`) REFERENCES `bank_account` (`idbank_account`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_campaign_user1` FOREIGN KEY (`id_creator_user`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campaign`
--

LOCK TABLES `campaign` WRITE;
/*!40000 ALTER TABLE `campaign` DISABLE KEYS */;
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
  `amount` decimal(7,0) NOT NULL,
  `currency` varchar(45) NOT NULL DEFAULT 'Euro',
  `date` datetime NOT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `id_campaign` int(11) NOT NULL,
  `id_contributing_account` int(11) NOT NULL,
  PRIMARY KEY (`idcontribution`,`id_campaign`,`id_contributing_account`),
  KEY `fk_contribution_campaign1_idx` (`id_campaign`),
  KEY `fk_contribution_bank_account1_idx` (`id_contributing_account`),
  CONSTRAINT `fk_contribution_bank_account1` FOREIGN KEY (`id_contributing_account`) REFERENCES `bank_account` (`idbank_account`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contribution_campaign1` FOREIGN KEY (`id_campaign`) REFERENCES `campaign` (`idcampaign`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contribution`
--

LOCK TABLES `contribution` WRITE;
/*!40000 ALTER TABLE `contribution` DISABLE KEYS */;
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
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'vi','1234','...','thanhvi.ng@gmail.com','vi','nguyen');
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

-- Dump completed on 2014-11-11 23:11:16
