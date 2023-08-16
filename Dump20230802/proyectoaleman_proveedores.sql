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
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `Idproveedor` int(11) NOT NULL,
  `nombreEmpresa` varchar(55) DEFAULT NULL,
  `direccion` varchar(55) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`Idproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Bimbo','Reforma',52686600),(2,'Saladitas','123 Main Street',5551234),(3,'Coca cola','456 Oak Avenue',5555678),(4,'mi alegria','789 Elm Road',5559012),(5,'Dominos','987 Pine Boulevard',5553456),(6,'Dulces de la roza',' Prolongación ',52369409),(7,'Sabritas','Tlanepantla',551234234),(8,'Dulcería La Abuelita','Calle de las rosas #123',555245345),(9,'CandyLand Delights','Avenida de las amapolas #4',55565634),(10,'Sweet Heaven','Candy Street 789',5534234),(11,'Sugar sugar','Sweet Avenue 567',55538678),(12,'Chocolatería Delicioso','Boulevard #321',5551239),(13,'GummyBears Emporium','Bear Lane #654',55534598),(14,'Marshmallow Dreams','Road  Centralia#987',55545634),(15,'Candy reciclable','Sugar Street #123',55556671),(16,'Jelly Joy','Jellybean Avenue #456',55596531),(17,'Sweet Sensations','El laurel #789',52355948),(18,'Caramel Corner','Av insurgentes #654',46342533),(19,'Choco Delights','Heaven #987',55556932),(20,'Fruit rico','Fruit  Boulevard #321',555568391),(21,'Fizzy Fizz Candy Shop','Indios verdes #654',92834913),(22,'Tamales pepe','Avenue #789',555945823),(23,'Fresa rio','Cosmopol#123',523492823),(24,'Pepsi','De la rosa #90',5239181),(25,'The Choco-Charm Boutique','Choco treet #789',555234533),(26,'Sweet Escapes ','Periferico  #456',50734553),(27,'Red bull','Prados sur#789',544635612);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
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
