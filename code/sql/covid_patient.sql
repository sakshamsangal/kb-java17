-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: covid
-- ------------------------------------------------------
-- Server version	8.0.13

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
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(50) DEFAULT NULL,
  `pr` int(11) DEFAULT NULL,
  `bp_systolic` int(11) DEFAULT NULL,
  `bp_diastolic` int(11) DEFAULT NULL,
  `temp` decimal(8,4) DEFAULT NULL,
  `rr` int(11) DEFAULT NULL,
  `spo2` int(11) DEFAULT NULL,
  `o2` decimal(8,4) DEFAULT NULL,
  `fio2` decimal(8,4) DEFAULT NULL,
  `other` varchar(100) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `gcs` decimal(8,4) DEFAULT NULL,
  `urine` decimal(8,4) DEFAULT NULL,
  `inotrope` varchar(100) DEFAULT NULL,
  `position` varchar(100) DEFAULT NULL,
  `Intake` varchar(100) DEFAULT NULL,
  `Steroids` varchar(100) DEFAULT NULL,
  `Antibiotics` varchar(100) DEFAULT NULL,
  `Clexane` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'Laith Mejia',60,120,140,98.5000,102,70,99.1500,99.1300,'95','normal',99.1300,99.1500,'normal','normal','normal','normal','normal','normal'),(2,'Neil Contreras',70,100,150,99.5000,98,60,100.1300,100.1300,'100','severe',100.1300,100.1300,'severe','severe','severe','severe','severe','severe'),(3,'Blossom Akhtar',100,130,120,100.5000,99,70,98.1300,98.1300,'98','severe',98.1300,98.1300,'severe','severe','severe','severe','severe','severe'),(4,'Ellie Beck',80,120,100,97.5000,100,100,95.1300,95.1300,'95','normal',95.1300,95.1300,'normal','normal','normal','normal','normal','normal'),(5,'Cosmo Stamp',70,100,130,104.5000,97,80,96.1300,96.1300,'99','severe',96.1300,96.1300,'severe','severe','severe','severe','severe','severe'),(6,'Honor Thomson',90,130,120,102.5000,104,70,99.1300,99.1300,'100','normal',99.1300,99.1300,'normal','normal','normal','normal','normal','normal'),(7,'Ben Mckinney',60,120,100,98.5000,102,90,100.1300,100.1300,'98','severe',100.1300,100.1300,'severe','severe','severe','severe','severe','severe'),(8,'Keaton Garrett',70,100,130,99.5000,98,60,98.1300,98.1300,'95','normal',98.1300,98.1300,'normal','normal','normal','normal','normal','normal'),(9,'Kristin Leigh',100,130,120,100.5000,99,70,95.1300,95.1300,'96','severe',95.1300,95.1300,'severe','severe','severe','severe','severe','severe'),(10,'Ariah Blundell',80,120,100,97.5000,100,100,96.1300,96.1300,'99','severe',96.1300,96.1300,'severe','severe','severe','severe','severe','severe'),(11,'Mila-Rose Townsend',70,100,130,104.5000,97,80,99.1300,99.1300,'100','normal',99.1300,99.1300,'normal','normal','normal','normal','normal','normal'),(12,'Cairo Miller',90,130,120,102.5000,104,70,100.1300,100.1300,'98','severe',100.1300,100.1300,'severe','severe','severe','severe','severe','severe'),(13,'Ailish Trejo',60,140,100,98.5000,98,90,98.1300,98.1300,'95','normal',98.1300,98.1300,'normal','normal','normal','normal','normal','normal'),(14,'Priya Lee',70,150,120,99.5000,99,60,95.1300,95.1300,'96','severe',95.1300,95.1300,'severe','severe','severe','severe','severe','severe'),(15,'Clare Valencia',100,140,100,100.5000,100,100,96.1300,96.1300,'99','normal',96.1300,96.1300,'normal','normal','normal','normal','normal','normal'),(16,'Alejandro Tate',80,150,130,97.5000,97,80,99.1300,99.1300,'100','severe',99.1300,99.1300,'severe','severe','severe','severe','severe','severe'),(17,'Jaxson Keeling',70,140,120,104.5000,104,70,100.1300,100.1300,'98','severe',100.1300,100.1300,'severe','severe','severe','severe','severe','severe'),(18,'Fatima Rowe',90,150,100,102.5000,102,90,98.1300,98.1300,'95','normal',98.1300,98.1300,'normal','normal','normal','normal','normal','normal'),(19,'Jax Bain',60,140,130,98.5000,98,60,95.1300,95.1300,'96','severe',95.1300,95.1300,'severe','severe','severe','severe','severe','severe'),(20,'Sannah Griffin',70,150,120,99.5000,99,70,96.1300,96.1300,'99','normal',96.1300,96.1300,'normal','normal','normal','normal','normal','normal'),(21,'Kodi Melton',100,120,100,100.5000,100,100,99.1300,99.1300,'100','severe',99.1300,99.1300,'severe','severe','severe','severe','severe','severe'),(22,'Grayson Castillo',80,100,130,97.5000,97,80,100.1300,100.1300,'98','normal',100.1300,100.1300,'normal','normal','normal','normal','normal','normal'),(23,'Kaci Dickerson',70,130,120,104.5000,104,70,98.1300,98.1300,'95','severe',98.1300,98.1300,'severe','severe','severe','severe','severe','severe'),(24,'Denis Gay',90,120,100,102.5000,102,90,95.1300,95.1300,'96','severe',95.1300,95.1300,'severe','severe','severe','severe','severe','severe'),(25,'Haris Boyer',60,100,130,98.5000,98,60,96.1300,96.1300,'99','normal',96.1300,96.1300,'normal','normal','normal','normal','normal','normal'),(26,'Bobby Keith',70,130,140,99.5000,99,70,99.1300,99.1300,'100','severe',99.1300,99.1300,'severe','severe','severe','severe','severe','severe'),(27,'Matas Firth',100,120,150,100.5000,100,100,100.1300,100.1300,'98','normal',100.1300,100.1300,'normal','normal','normal','normal','normal','normal'),(28,'Bethan Craft',80,100,140,97.5000,97,80,98.1300,98.1300,'95','severe',98.1300,98.1300,'severe','severe','severe','severe','severe','severe'),(29,'Kian Gunn',70,130,150,104.5000,104,70,99.1300,95.1300,'96','normal',95.1300,99.1300,'normal','normal','normal','normal','normal','normal'),(30,'Lina Eastwood',90,120,140,102.5000,102,90,100.1300,96.1300,'99','severe',96.1300,100.1300,'severe','severe','severe','severe','severe','severe'),(31,'Kiri Padilla',60,100,150,98.5000,98,60,98.1300,99.1300,'100','severe',99.1300,98.1300,'severe','severe','severe','severe','severe','severe'),(32,'Alayah Nava',80,130,130,99.5000,99,80,95.1300,100.1300,'98','normal',100.1300,95.1300,'normal','normal','normal','normal','normal','normal'),(33,'Bella Curran',60,140,140,100.5000,100,60,96.1300,98.1300,'95','severe',98.1300,96.1300,'severe','severe','severe','severe','severe','severe'),(35,'Owain O\'Quinn',100,140,140,104.5000,104,100,95.1300,96.1300,'96','severe',96.1300,95.1300,'severe','severe','severe','severe','severe','severe'),(36,'Thierry Mcgregor',80,150,150,102.5000,102,80,96.1300,99.1300,'99','normal',99.1300,96.1300,'normal','normal','normal','normal','normal','normal'),(37,'Cieran William',70,140,140,98.5000,98,70,99.1300,100.1300,'100','severe',100.1300,99.1300,'severe','severe','severe','severe','severe','severe'),(38,'Emer Norman',90,150,150,99.5000,99,90,100.1300,98.1300,'98','severe',98.1300,100.1300,'severe','severe','severe','severe','severe','severe'),(39,'Gracie-Leigh Dunne',60,140,140,100.5000,100,60,98.1300,95.1300,'95','normal',95.1300,98.1300,'normal','normal','normal','normal','normal','normal'),(40,'Haseeb Galloway',70,150,150,97.5000,97,70,95.1300,99.1300,'99','severe',99.1300,95.1300,'severe','severe','severe','severe','severe','severe'),(41,'Arwa Chambers',100,100,100,104.5000,104,100,99.1300,100.1300,'100','normal',100.1300,99.1300,'normal','normal','normal','normal','normal','normal'),(42,'Rogan Adams',80,120,120,102.5000,102,80,100.1300,98.1300,'98','severe',98.1300,100.1300,'severe','severe','severe','severe','severe','severe'),(43,'Lily-May Wood',70,100,100,98.5000,98,70,98.1300,95.1300,'95','normal',95.1300,98.1300,'normal','normal','normal','normal','normal','normal'),(44,'Anees Fuentes',90,130,130,99.5000,99,90,95.1300,96.1300,'96','severe',96.1300,95.1300,'severe','severe','severe','severe','severe','severe'),(45,'Mylee Esquivel',60,140,140,100.5000,100,60,96.1300,96.1300,'96','severe',96.1300,96.1300,'severe','severe','severe','severe','severe','severe'),(46,'Sallie Brett',70,150,150,97.5000,97,70,96.1300,99.1300,'99','severe',99.1300,96.1300,'severe','severe','severe','severe','severe','severe'),(47,'Tim Chadwick',100,140,140,104.5000,104,100,99.1300,100.1300,'100','normal',100.1300,99.1300,'normal','normal','normal','normal','normal','normal'),(48,'Ivie Branch',80,150,150,102.5000,102,80,100.1300,98.1300,'98','severe',98.1300,100.1300,'severe','severe','severe','severe','severe','severe'),(49,'Soraya Vinson',70,140,140,98.5000,98,70,98.1300,95.1300,'95','normal',95.1300,98.1300,'normal','normal','normal','normal','normal','normal'),(50,'Donell Peacock',90,150,150,99.5000,99,90,95.1300,96.1300,'96','severe',96.1300,95.1300,'severe','severe','severe','severe','severe','severe');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-24 17:20:57
