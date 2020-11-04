-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: inventario_kiba
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `pro_id` int NOT NULL AUTO_INCREMENT,
  `pro_codigo` varchar(20) NOT NULL,
  `pro_especie` varchar(15) NOT NULL,
  `pro_cantidad` double NOT NULL,
  `pro_tipo_madera` varchar(30) NOT NULL,
  `pro_tipo_troza` varchar(30) NOT NULL,
  `pro_procedencia` varchar(30) NOT NULL,
  `pro_proveedor` varchar(30) NOT NULL,
  `pro_tranportista` varchar(30) NOT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (7,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(8,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(9,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(10,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(11,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(12,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(13,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(14,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(15,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(16,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(17,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(18,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(19,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(20,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(21,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(22,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi'),(23,'123456','tornillo',100,'comercial','larga','iquitos','travi','travi');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-03 20:31:11
