CREATE DATABASE  IF NOT EXISTS `hospital` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hospital`;
-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `hospital_id` bigint(20) NOT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `created` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKds7ws3yyj4c5wj35fpefpeny0` (`hospital_id`),
  CONSTRAINT `FKds7ws3yyj4c5wj35fpefpeny0` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'miraflores',NULL,'Fernanda',NULL,7,'https://randomuser.me/api/portraits/med/men/40.jpg',NULL,NULL,NULL,NULL,NULL),(2,'Tejada Sorzano',NULL,'Paul Landaeta',NULL,7,'https://randomuser.me/api/portraits/med/men/50.jpg',NULL,NULL,NULL,NULL,NULL),(3,'Sur',NULL,'Paul Landaeta',NULL,7,'https://randomuser.me/api/portraits/med/men/70.jpg',NULL,NULL,NULL,NULL,NULL),(4,'Kantuta',NULL,'Luis Quispe',NULL,7,'https://randomuser.me/api/portraits/med/men/71.jpg',NULL,NULL,NULL,NULL,NULL),(5,'Kantuta',NULL,'Luis Quispe',NULL,7,'https://randomuser.me/api/portraits/thumb/men/98.jpg',NULL,NULL,NULL,NULL,NULL),(6,'Zona Sur',NULL,'Juan ',NULL,4,'https://randomuser.me/api/portraits/med/men/83.jpg',NULL,NULL,NULL,NULL,'2020-06-17');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_specialities`
--

DROP TABLE IF EXISTS `doctor_specialities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_specialities` (
  `doctor_id` bigint(20) NOT NULL,
  `specialities_id` bigint(20) NOT NULL,
  PRIMARY KEY (`doctor_id`,`specialities_id`),
  KEY `FKp48epsex2ojv6uc74skk4bua4` (`specialities_id`),
  CONSTRAINT `FK29o6fk8lj7ttiwrc3abpltb20` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `FKp48epsex2ojv6uc74skk4bua4` FOREIGN KEY (`specialities_id`) REFERENCES `speciality` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_specialities`
--

LOCK TABLES `doctor_specialities` WRITE;
/*!40000 ALTER TABLE `doctor_specialities` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor_specialities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `created` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Av Bush','Obrero','',NULL,NULL,NULL,NULL),(4,'Av Bush','Obrero','',NULL,NULL,NULL,NULL),(5,'Barrio Grafico','Arco Iris','',NULL,NULL,NULL,NULL),(6,'Villa copacabana','San Gabriel','',NULL,NULL,NULL,NULL),(7,'San Pedro','Uyuni','',NULL,NULL,NULL,NULL),(8,'Kenko','Holandes','',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital_specialities`
--

DROP TABLE IF EXISTS `hospital_specialities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital_specialities` (
  `hospital_id` bigint(20) NOT NULL,
  `specialities_id` bigint(20) NOT NULL,
  PRIMARY KEY (`hospital_id`,`specialities_id`),
  KEY `FKpk5g7nvlql6ue0cwlre5fw6o` (`specialities_id`),
  CONSTRAINT `FK8v59y7c3b80jryica6wbcke7q` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`),
  CONSTRAINT `FKpk5g7nvlql6ue0cwlre5fw6o` FOREIGN KEY (`specialities_id`) REFERENCES `speciality` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital_specialities`
--

LOCK TABLES `hospital_specialities` WRITE;
/*!40000 ALTER TABLE `hospital_specialities` DISABLE KEYS */;
/*!40000 ALTER TABLE `hospital_specialities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notes`
--

DROP TABLE IF EXISTS `notes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `doctor_id` bigint(20) NOT NULL,
  `patient_id` bigint(20) NOT NULL,
  `created` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKio3eqvqqrbntvfwu5dqx4lrj2` (`doctor_id`),
  KEY `FK5g0dgvn1h30abysm9yx0al7sd` (`patient_id`),
  CONSTRAINT `FK5g0dgvn1h30abysm9yx0al7sd` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `FKio3eqvqqrbntvfwu5dqx4lrj2` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notes`
--

LOCK TABLES `notes` WRITE;
/*!40000 ALTER TABLE `notes` DISABLE KEYS */;
/*!40000 ALTER TABLE `notes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `hospital_id` bigint(20) NOT NULL,
  `created` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated` varchar(255) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfrtkp1fawf55kilsxb1uxpio0` (`hospital_id`),
  CONSTRAINT `FKfrtkp1fawf55kilsxb1uxpio0` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'miraflores','La Paz','Paul Landaeta','76517816',4,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'Miraflores',NULL,'Juan Perez',NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Plaza kantuta',NULL,'Luis Limachi',NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'Miraflores',NULL,'Juan',NULL,7,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'Tejada Sorzano',NULL,'Paul',NULL,4,NULL,NULL,NULL,NULL,NULL,'Landaeta',NULL),(6,'',NULL,'',NULL,4,NULL,NULL,NULL,NULL,'2020-06-18','',NULL),(7,'',NULL,'',NULL,4,NULL,NULL,NULL,NULL,'2020-06-24','',NULL),(8,'Tejada Sorzano',NULL,'Elmer ',NULL,4,'2020-06-07','admin',NULL,NULL,'2020-06-09','Zapata',NULL);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality`
--

DROP TABLE IF EXISTS `speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `speciality` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created` date DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `updated` date DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality`
--

LOCK TABLES `speciality` WRITE;
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
INSERT INTO `speciality` VALUES (1,'Cuidados del Corazón ',NULL,'Cardiologia',NULL,NULL,NULL,NULL),(2,'Cuidado de los ojos',NULL,'oftalmologia',NULL,NULL,NULL,NULL),(3,'Cuidado de los ojos',NULL,'oftalmologia',NULL,NULL,NULL,NULL),(4,'Cuidado de los ojos',NULL,'oftalmologia',NULL,NULL,NULL,NULL),(5,'Cuidado de los ojos',NULL,'oftalmologia',NULL,NULL,NULL,NULL),(6,'Cuidado de los ojos',NULL,'oftalmologia',NULL,NULL,NULL,NULL),(7,'Cuidado de los ojos',NULL,'oftalmologia',NULL,NULL,NULL,NULL),(8,'Cuidado de los ojos',NULL,'oftalmologia',NULL,NULL,NULL,NULL),(9,'Cuidado de Corazon',NULL,'Cardiologia',NULL,NULL,NULL,NULL),(10,'Cuidado del Corazon ',NULL,'Cardiologia',NULL,NULL,NULL,NULL),(11,'Cuidado ',NULL,'Cardiologia',NULL,NULL,NULL,NULL),(12,'asdas ',NULL,'asdasd',NULL,NULL,NULL,NULL),(13,'Cuidado de corazon',NULL,'Cardiologia',NULL,NULL,NULL,NULL),(14,'Cuidado del corazon',NULL,'Cardiologia',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality_doctors`
--

DROP TABLE IF EXISTS `speciality_doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `speciality_doctors` (
  `speciality_id` bigint(20) NOT NULL,
  `doctors_id` bigint(20) NOT NULL,
  PRIMARY KEY (`speciality_id`,`doctors_id`),
  KEY `FKm5loslprhvs3nxwi42934scqn` (`doctors_id`),
  CONSTRAINT `FKg3bqfjuerh6965tvi572avqyu` FOREIGN KEY (`speciality_id`) REFERENCES `speciality` (`id`),
  CONSTRAINT `FKm5loslprhvs3nxwi42934scqn` FOREIGN KEY (`doctors_id`) REFERENCES `doctor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality_doctors`
--

LOCK TABLES `speciality_doctors` WRITE;
/*!40000 ALTER TABLE `speciality_doctors` DISABLE KEYS */;
/*!40000 ALTER TABLE `speciality_doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality_hospitals`
--

DROP TABLE IF EXISTS `speciality_hospitals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `speciality_hospitals` (
  `speciality_id` bigint(20) NOT NULL,
  `hospitals_id` bigint(20) NOT NULL,
  PRIMARY KEY (`speciality_id`,`hospitals_id`),
  KEY `FKb6qxjwpp7nvwwefoyo35akog` (`hospitals_id`),
  CONSTRAINT `FKb6qxjwpp7nvwwefoyo35akog` FOREIGN KEY (`hospitals_id`) REFERENCES `hospital` (`id`),
  CONSTRAINT `FKssm2rmjnnt6i5t3wux8b7qh5o` FOREIGN KEY (`speciality_id`) REFERENCES `speciality` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality_hospitals`
--

LOCK TABLES `speciality_hospitals` WRITE;
/*!40000 ALTER TABLE `speciality_hospitals` DISABLE KEYS */;
INSERT INTO `speciality_hospitals` VALUES (2,1),(3,1),(4,1),(5,1),(6,4),(7,4),(8,4),(13,4),(14,7);
/*!40000 ALTER TABLE `speciality_hospitals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-07 20:01:44
