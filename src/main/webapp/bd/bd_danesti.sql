CREATE DATABASE  IF NOT EXISTS `bd_danesti` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_danesti`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_danesti
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `tb_cab_boleta`
--

DROP TABLE IF EXISTS `tb_cab_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cab_boleta` (
  `numbol` varchar(5) NOT NULL,
  `codcli` int DEFAULT NULL,
  `fechabol` date DEFAULT NULL,
  PRIMARY KEY (`numbol`),
  KEY `fkcliente_idx` (`codcli`),
  CONSTRAINT `fkcliente` FOREIGN KEY (`codcli`) REFERENCES `tb_usuarios` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cab_boleta`
--

LOCK TABLES `tb_cab_boleta` WRITE;
/*!40000 ALTER TABLE `tb_cab_boleta` DISABLE KEYS */;
INSERT INTO `tb_cab_boleta` VALUES ('B0001',16,'2023-05-27'),('B0002',16,'2023-05-27'),('B0003',17,'2023-05-27'),('B0004',17,'2023-05-27'),('B0005',16,'2023-05-27'),('B0006',17,'2023-05-27'),('B0007',15,'2023-05-27'),('B0008',16,'2023-05-27'),('B0009',17,'2023-05-27'),('B0010',17,'2023-05-27'),('B0011',17,'2023-05-27'),('B0012',17,'2023-05-27'),('B0013',15,'2023-05-27'),('B0014',15,'2023-05-27'),('B0015',17,'2023-05-27'),('B0016',17,'2023-05-27'),('B0017',17,'2023-05-27'),('B0018',17,'2023-05-27'),('B0019',17,'2023-05-27'),('B0020',17,'2023-05-27'),('B0021',16,'2023-05-27'),('B0022',17,'2023-05-27'),('B0023',17,'2023-05-27'),('B0024',17,'2023-05-27'),('B0025',17,'2023-05-28'),('B0026',17,'2023-05-28'),('B0027',17,'2023-05-30'),('B0028',15,'2023-05-31'),('B0029',15,'2023-05-31'),('B0030',15,'2023-05-31'),('B0031',15,'2023-05-31'),('B0032',15,'2023-05-31'),('B0033',15,'2023-06-01'),('B0034',15,'2023-06-01'),('B0035',15,'2023-06-01'),('B0036',15,'2023-06-01'),('B0037',15,'2023-06-02'),('B0038',15,'2023-06-02'),('B0039',15,'2023-06-02'),('B0040',15,'2023-06-04');
/*!40000 ALTER TABLE `tb_cab_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_caja`
--

DROP TABLE IF EXISTS `tb_caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_caja` (
  `codcaja` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `codproveedor` int DEFAULT NULL,
  PRIMARY KEY (`codcaja`),
  KEY `fkproveedor_idx` (`codproveedor`),
  CONSTRAINT `fkproveedor` FOREIGN KEY (`codproveedor`) REFERENCES `tb_proveedor` (`codproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_caja`
--

LOCK TABLES `tb_caja` WRITE;
/*!40000 ALTER TABLE `tb_caja` DISABLE KEYS */;
INSERT INTO `tb_caja` VALUES (1,'Personal',1),(2,'Mediana',2),(3,'Grande',3),(4,'Familiar',1);
/*!40000 ALTER TABLE `tb_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalle_boleta`
--

DROP TABLE IF EXISTS `tb_detalle_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_detalle_boleta` (
  `numbol` char(5) NOT NULL,
  `codprod` char(5) NOT NULL,
  `cantidad` int DEFAULT NULL,
  `precioventa` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`numbol`,`codprod`),
  KEY `fkprod_idx` (`codprod`),
  CONSTRAINT `fknumbol` FOREIGN KEY (`numbol`) REFERENCES `tb_cab_boleta` (`numbol`),
  CONSTRAINT `fkprod` FOREIGN KEY (`codprod`) REFERENCES `tb_producto` (`codprod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalle_boleta`
--

LOCK TABLES `tb_detalle_boleta` WRITE;
/*!40000 ALTER TABLE `tb_detalle_boleta` DISABLE KEYS */;
INSERT INTO `tb_detalle_boleta` VALUES ('B0001','P0001',2,40.00),('B0001','P0002',3,45.00),('B0002','P0001',2,40.00),('B0002','P0002',3,45.00),('B0003','P0001',2,40.00),('B0003','P0002',3,45.00),('B0004','P0001',2,40.00),('B0004','P0002',3,45.00),('B0005','P0001',2,40.00),('B0005','P0002',3,45.00),('B0006','P0001',2,40.00),('B0006','P0002',3,45.00),('B0007','P0001',2,40.00),('B0007','P0002',3,45.00),('B0008','P0001',2,40.00),('B0008','P0002',3,45.00),('B0009','P0001',2,40.00),('B0009','P0002',3,45.00),('B0010','P0001',1,20.00),('B0010','P0002',3,45.00),('B0011','P0001',2,40.00),('B0011','P0002',3,45.00),('B0012','P0001',2,40.00),('B0012','P0002',3,45.00),('B0013','P0001',4,80.00),('B0013','P0002',3,45.00),('B0014','P0001',2,40.00),('B0014','P0002',3,45.00),('B0015','P0001',2,40.00),('B0015','P0002',3,45.00),('B0016','P0001',2,40.00),('B0016','P0002',3,45.00),('B0017','P0001',2,20.00),('B0017','P0002',3,15.00),('B0018','P0001',2,20.00),('B0018','P0002',3,15.00),('B0019','P0002',3,15.00),('B0019','P0004',5,25.90),('B0020','P0001',2,20.00),('B0020','P0003',4,12.00),('B0021','P0001',2,20.00),('B0021','P0003',3,12.00),('B0022','P0003',4,12.00),('B0022','P0004',5,25.90),('B0024','P0001',2,20.00),('B0024','P0002',1,15.00),('B0025','P0002',3,15.00),('B0025','P0003',4,12.00),('B0026','P0001',2,20.00),('B0026','P0002',3,15.00),('B0027','P0001',2,20.00),('B0027','P0002',3,15.00),('B0028','P0001',2,20.00),('B0028','P0002',3,15.00),('B0029','P0001',1,20.00),('B0029','P0008',1,22.00),('B0029','P0010',1,21.00),('B0030','P0001',2,20.00),('B0030','P0008',4,22.00),('B0030','P0010',3,21.00),('B0031','P0002',1,15.00),('B0031','P0003',1,12.00),('B0032','P0001',1,20.00),('B0032','P0002',1,15.00),('B0033','P0001',1,20.00),('B0033','P0002',1,15.00),('B0033','P0003',1,12.00),('B0034','P0001',1,20.00),('B0034','P0002',3,15.00),('B0035','P0001',1,20.00),('B0035','P0002',1,15.00),('B0035','P0003',1,12.00),('B0036','P0001',2,20.00),('B0036','P0002',3,15.00),('B0037','P0001',1,20.00),('B0037','P0003',1,12.00),('B0037','P0007',1,33.00),('B0039','P0002',1,15.00),('B0039','P0003',1,12.00),('B0039','P0004',1,26.00),('B0039','P0008',1,22.00),('B0039','P0012',1,42.00),('B0040','P0001',1,20.00),('B0040','P0002',1,15.00);
/*!40000 ALTER TABLE `tb_detalle_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estado`
--

DROP TABLE IF EXISTS `tb_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estado` (
  `codestado` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codestado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estado`
--

LOCK TABLES `tb_estado` WRITE;
/*!40000 ALTER TABLE `tb_estado` DISABLE KEYS */;
INSERT INTO `tb_estado` VALUES (1,'Activo'),(2,'Agotado'),(3,'Eliminado');
/*!40000 ALTER TABLE `tb_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_producto`
--

DROP TABLE IF EXISTS `tb_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_producto` (
  `codprod` varchar(5) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `codcaja` int DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `estado` int DEFAULT '1',
  PRIMARY KEY (`codprod`),
  KEY `fkcaja_idx` (`codcaja`),
  KEY `fkest_idx` (`estado`),
  CONSTRAINT `fkcaja` FOREIGN KEY (`codcaja`) REFERENCES `tb_caja` (`codcaja`),
  CONSTRAINT `fkest` FOREIGN KEY (`estado`) REFERENCES `tb_estado` (`codestado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_producto`
--

LOCK TABLES `tb_producto` WRITE;
/*!40000 ALTER TABLE `tb_producto` DISABLE KEYS */;
INSERT INTO `tb_producto` VALUES ('P0001','Margarita','Una pizza clásica con salsa de tomate, mozzarella y albahaca fresca.',1,20,24,1),('P0002','Peperoni','Pizza con rodajas de pepperoni (salami picante) y queso.',2,15,111,1),('P0003','Hawaiana','Pizza con jamón, piña y queso.',2,12,113,1),('P0004','Cuatro quesos','Pizza con una combinación de quesos como mozzarella, gorgonzola, parmesano y queso de cabra.',3,26,295,1),('P0005','Vegetariana','Pizza cargada de verduras como champiñones, pimientos, cebolla, tomate y aceitunas.',2,30,300,1),('P0006','Barbacoa','Pizza con salsa barbacoa, pollo a la parrilla, cebolla y queso.',1,30,300,1),('P0007','Marinara','Pizza con salsa de tomate, ajo, aceite de oliva y especias, sin queso.',2,33,332,1),('P0008','Diavola','Pizza picante con salami picante, aceitunas y chiles.',3,22,216,1),('P0009','Capricciosa','Pizza con jamón, champiñones, alcachofas y aceitunas.',4,44,444,1),('P0010','Siciliana','Pizza rectangular con una base gruesa y esponjosa, generalmente cubierta con salsa de tomate, anchoas, queso y hierbas.',3,21,349,1),('P0011','Napolitana','Pizza tradicional de Nápoles con tomate, ajo, orégano, aceite de oliva y albahaca fresca',2,17,177,1),('P0012','Romana','Pizza delgada y crujiente con aceite de oliva, salsa de tomate, anchoas, aceitunas y albahaca.',1,42,241,1),('P0013','Romanas','Pizza delgada y crujiente con aceite sde oliva, salsa de tomate, anchoas, aceitunas y albahaca.',2,42,241,1);
/*!40000 ALTER TABLE `tb_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proveedor` (
  `codproveedor` int NOT NULL,
  `razonsocial` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedor`
--

LOCK TABLES `tb_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` VALUES (1,'Perupac SAC','994415212','perupac@contacto.pe'),(2,'PackingPeru SAC','998421345','packingpe@contacto.pe'),(3,'Empaques Belen SAC','995421562','ebelen@contacto.pe');
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipos`
--

DROP TABLE IF EXISTS `tb_tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipos` (
  `idtipo` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipos`
--

LOCK TABLES `tb_tipos` WRITE;
/*!40000 ALTER TABLE `tb_tipos` DISABLE KEYS */;
INSERT INTO `tb_tipos` VALUES (1,'Administrador'),(2,'Vendedor'),(3,'Cliente');
/*!40000 ALTER TABLE `tb_tipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `fnacim` date DEFAULT NULL,
  `idtipo` int DEFAULT '3',
  PRIMARY KEY (`codigo`),
  KEY `fktipo_idx` (`idtipo`),
  CONSTRAINT `fktipo` FOREIGN KEY (`idtipo`) REFERENCES `tb_tipos` (`idtipo`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (15,'Angelo','Balbin','abalbin@gmail.com','10001','2023-04-20',3),(16,'Luis','Arias','larias@gmail.com','10001','2023-04-28',3),(17,'Pedro','Casas','pcasas@gmail.com','10003','2023-04-28',2),(23,'Masi','Pora','mpora@gmail.com','10004','2023-04-07',1),(24,'Asha','Eara','aeara@gmail.com','10005','2023-05-13',3),(27,'Pepe','Martinez','pmartinez@gmail.com','10006','2023-05-17',3),(28,'usuario2','usuario2','usuario2@gmail.com','10001','2023-05-23',3),(31,'usuario3','usuario3','usuario@gmail.com','10001','2023-05-23',1);
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_danesti'
--

--
-- Dumping routines for database 'bd_danesti'
--
/*!50003 DROP PROCEDURE IF EXISTS `proc_listarProd` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_listarProd`()
BEGIN
select p.codprod, p.nombre, p.descripcion,c.descripcion, p.precio, p.stock, e.descripcion
from bd_danesti.tb_producto p
inner join bd_danesti.tb_estado e
on e.codestado = p.estado
inner join bd_danesti.tb_caja c
on c.codcaja = p.codcaja
ORDER BY 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-06 14:16:12
