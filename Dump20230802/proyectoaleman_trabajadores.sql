CREATE DATABASE  IF NOT EXISTS `proyectoaleman` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyectoaleman`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: proyectoaleman
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `trabajadores`
--

DROP TABLE IF EXISTS `trabajadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajadores` (
  `Idtrabajador` int(11) NOT NULL,
  `nombre` varchar(55) DEFAULT NULL,
  `apepat` varchar(55) DEFAULT NULL,
  `apemat` varchar(55) DEFAULT NULL,
  `puesto` varchar(55) DEFAULT NULL,
  `sueldo` int(11) DEFAULT NULL,
  `fechaini` date DEFAULT NULL,
  PRIMARY KEY (`Idtrabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajadores`
--

LOCK TABLES `trabajadores` WRITE;
/*!40000 ALTER TABLE `trabajadores` DISABLE KEYS */;
INSERT INTO `trabajadores` VALUES (1,'Andrik','Aleman','Santiago','Director',10000,'2023-07-04'),(2,'Andres','Nose','Perez','supervisor',5000,'2023-07-10'),(3,'Ricardo','Hernandes','Lopez','Jefe',50000,'2023-07-23'),(4,'Juan','Lopez','Carrillo','Ayudante',6000,'2023-07-29'),(5,'Dafne','Aleman','Santiago','Supervisor',18000,'2023-07-29'),(6,'María','García','Martínez','Asistente',8000,'2023-08-02'),(7,'Pedro','Ramírez','Gómez','Operario',6500,'2023-08-05'),(8,'Ana','Hernández','López','Supervisor',12000,'2023-08-12'),(9,'Carlos','Fernández','Rodríguez','Jefe',55000,'2023-08-20'),(10,'Laura','Martínez','Sánchez','Asistente',7500,'2023-08-25'),(11,'José','Gómez','Torres','Operario',6000,'2023-08-30'),(12,'Paula','Sánchez','Vargas','Supervisor',16000,'2023-09-02'),(13,'Sergio','López','Gutiérrez','Jefe',52000,'2023-09-10'),(14,'Isabel','Rodríguez','Martínez','Asistente',7800,'2023-09-15'),(15,'Roberto','Torres','Gómez','Operario',6200,'2023-09-20'),(16,'Mariana','González','Hernández','Asistente',8200,'2023-09-25'),(17,'Javier','Martínez','Gómez','Operario',6400,'2023-09-30'),(18,'Carmen','Vargas','Sánchez','Supervisor',15000,'2023-10-02'),(19,'Felipe','Gutiérrez','López','Jefe',53000,'2023-10-10'),(20,'Luisa','Hernández','Torres','Asistente',7900,'2023-10-15'),(21,'Andrés','Gómez','Rodríguez','Operario',6100,'2023-10-20'),(22,'Gabriela','Sánchez','Martínez','Supervisor',17000,'2023-10-25'),(23,'Rafael','López','García','Jefe',54000,'2023-11-02'),(24,'Alejandra','Rodríguez','Gómez','Asistente',8100,'2023-11-15'),(25,'Diego','Torres','Vargas','Operario',6300,'2023-11-20'),(26,'Elena','García','Martínez','Asistente',8400,'2023-11-25'),(27,'Hugo','Martínez','Gómez','Operario',6600,'2023-11-30'),(28,'Adriana','Vargas','Sánchez','Supervisor',15500,'2023-12-02'),(29,'Rogelio','Gutiérrez','López','Jefe',52000,'2023-12-10'),(30,'Fernanda','Hernández','Torres','Asistente',8000,'2023-12-15'),(31,'Emilio','Gómez','Rodríguez','Operario',6200,'2023-12-20'),(32,'Valeria','Sánchez','Martínez','Supervisor',17500,'2023-12-25'),(33,'Miguel','López','García','Jefe',55000,'2024-01-02'),(34,'Martha','Rodríguez','Gómez','Asistente',8300,'2024-01-15'),(35,'Arturo','Torres','Vargas','Operario',6400,'2024-01-20'),(36,'Paola','García','Martínez','Supervisor',18000,'2024-01-25'),(37,'Santiago','Martínez','Gómez','Jefe',53000,'2024-02-02'),(38,'Gabriel','Vargas','Sánchez','Asistente',8500,'2024-02-15'),(39,'Daniela','Gutiérrez','López','Operario',6500,'2024-02-20'),(40,'Roberto','Hernández','Torres','Supervisor',18500,'2024-02-25'),(41,'Julia','Gómez','Rodríguez','Jefe',54000,'2024-03-02'),(42,'Samuel','Sánchez','Martínez','Asistente',8200,'2024-03-15'),(43,'Camila','López','García','Operario',6700,'2024-03-20'),(44,'Andrea','Rodríguez','Gómez','Supervisor',16500,'2024-03-25'),(45,'Jorge','Torres','Vargas','Jefe',56000,'2024-04-02'),(46,'Isabella','García','Martínez','Asistente',8600,'2024-04-15'),(47,'Eduardo','Martínez','Gómez','Operario',6800,'2024-04-20'),(48,'Ximena','Vargas','Sánchez','Supervisor',19000,'2024-04-25'),(49,'Alejandro','Gutiérrez','López','Jefe',55000,'2024-05-02'),(50,'Natalia','Hernández','Torres','Asistente',8400,'2024-05-15'),(51,'Pablo','Gómez','Rodríguez','Operario',6900,'2024-05-20'),(52,'Valentina','Sánchez','Martínez','Supervisor',19500,'2024-05-25'),(53,'Rodrigo','López','García','Jefe',57000,'2024-06-02'),(54,'Mariano','Rodríguez','Gómez','Asistente',8700,'2024-06-15'),(55,'Lucía','Torres','Vargas','Operario',7000,'2024-06-20');
/*!40000 ALTER TABLE `trabajadores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-02 14:24:36
