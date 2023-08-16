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
-- Table structure for table `pedidosproveedores`
--

DROP TABLE IF EXISTS `pedidosproveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidosproveedores` (
  `Idpedido` int(11) NOT NULL,
  `Idproveedor` int(11) NOT NULL,
  `Idproducto` int(11) NOT NULL,
  `producto` varchar(55) DEFAULT NULL,
  `nomproveedor` varchar(55) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fechapedido` date DEFAULT NULL,
  `fechaquere` date DEFAULT NULL,
  PRIMARY KEY (`Idpedido`,`Idproducto`,`Idproveedor`),
  KEY `Idproducto` (`Idproducto`),
  KEY `Idproveedor` (`Idproveedor`),
  CONSTRAINT `pedidosproveedores_ibfk_1` FOREIGN KEY (`Idproducto`) REFERENCES `producto` (`Idproducto`),
  CONSTRAINT `pedidosproveedores_ibfk_2` FOREIGN KEY (`Idproveedor`) REFERENCES `proveedores` (`Idproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidosproveedores`
--

LOCK TABLES `pedidosproveedores` WRITE;
/*!40000 ALTER TABLE `pedidosproveedores` DISABLE KEYS */;
INSERT INTO `pedidosproveedores` VALUES (1,1,1,'Paletas tustipop','Bimbo',25,'2023-07-25','2023-08-12'),(2,2,1,'Barras chocolate','Bimbo',12,'2023-07-25','2023-09-13'),(1000,1,1,'Paletas tustipop','Bimbo',25,'2023-07-25','2023-08-12');
/*!40000 ALTER TABLE `pedidosproveedores` ENABLE KEYS */;
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
