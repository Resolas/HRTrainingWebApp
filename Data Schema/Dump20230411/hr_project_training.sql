-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: hr_project
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `training`
--

DROP TABLE IF EXISTS `training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `training` (
  `trainingid` char(4) NOT NULL,
  `training name` varchar(45) NOT NULL,
  `training provider` varchar(45) NOT NULL,
  `start date` timestamp NOT NULL,
  `end date` timestamp NOT NULL,
  `objective` longtext NOT NULL,
  `cost` int NOT NULL,
  `adminid` char(4) NOT NULL,
  `evaluationid` char(4) NOT NULL,
  `registrationid` char(4) NOT NULL,
  `reportid` char(4) NOT NULL,
  PRIMARY KEY (`trainingid`),
  KEY `adminid_idx` (`adminid`),
  KEY `evaluationid_idx` (`evaluationid`),
  KEY `registrationid_idx` (`registrationid`),
  KEY `reportid_idx` (`reportid`),
  KEY `idx_training_evaluationid` (`evaluationid`),
  CONSTRAINT `id_admin` FOREIGN KEY (`adminid`) REFERENCES `admin` (`adminid`),
  CONSTRAINT `id_evaluation` FOREIGN KEY (`evaluationid`) REFERENCES `evaluation` (`evaluationid`),
  CONSTRAINT `id_registration` FOREIGN KEY (`registrationid`) REFERENCES `registration` (`registrationid`),
  CONSTRAINT `id_report` FOREIGN KEY (`reportid`) REFERENCES `report` (`reportid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-11 10:24:19
