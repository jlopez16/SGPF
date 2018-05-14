-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: SGPF
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

BEGIN;

-- -----------------------------------------------------
-- Schema SGPF
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SGPF` ;

-- -----------------------------------------------------
-- Schema SGPF
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SGPF` DEFAULT CHARACTER SET utf8 ;
USE `SGPF` ;

--
-- Table structure for table `accion`
--

DROP TABLE IF EXISTS `accion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `accion` (
  `idaccion` int(11) NOT NULL AUTO_INCREMENT,
  `nomAccion` varchar(45) NOT NULL,
  `movDatos` char(1) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idaccion`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


--
-- Dumping data for table `accion`
--

LOCK TABLES `accion` WRITE;
/*!40000 ALTER TABLE `accion` DISABLE KEYS */;
INSERT INTO `accion` VALUES (1,'ingresaSz','M','entrada de datos',1),(2,'envia','X','envia de datos',0),(3,'solicita','R','pide de datos',0),(4,'Prueba','X','This',1),(5,'Prueba2','E','22',1),(6,'Prueba','X','C',1),(7,'Bombón','M','D',1),(8,'Prueba','E','This is the description',1);
/*!40000 ALTER TABLE `accion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupodato`
--

DROP TABLE IF EXISTS `grupodato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grupodato` (
  `idgrupoDato` int(11) NOT NULL AUTO_INCREMENT,
  `nomGD` varchar(45) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idgrupoDato`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupodato`
--

LOCK TABLES `grupodato` WRITE;
/*!40000 ALTER TABLE `grupodato` DISABLE KEYS */;
INSERT INTO `grupodato` VALUES (1,'estudianteR','Estudiante del IIMAZ',0),(2,'Juano','Sisg',1),(3,'','',1),(4,'','',1),(5,'','',1),(6,'','',1),(7,'df','',1),(8,'fe','ef',1),(9,'Juano','Feith',1),(10,'Peio','kbjhb',1);
/*!40000 ALTER TABLE `grupodato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interup`
--

DROP TABLE IF EXISTS `interup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `interup` (
  `idinterUP` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `idproyecto` int(11) NOT NULL,
  PRIMARY KEY (`idinterUP`),
  KEY `idusuario_idx` (`idusuario`),
  KEY `idproyecto_idx` (`idproyecto`),
  CONSTRAINT `idproyecto1` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`),
  CONSTRAINT `idusuario1` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interup`
--

LOCK TABLES `interup` WRITE;
/*!40000 ALTER TABLE `interup` DISABLE KEYS */;
INSERT INTO `interup` VALUES (1,1,1),(2,1,2),(3,2,2),(4,1,3),(5,1,4),(6,3,2),(7,3,4);
/*!40000 ALTER TABLE `interup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procesofuncional`
--

DROP TABLE IF EXISTS `procesofuncional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `procesofuncional` (
  `idprocesoFuncional` int(11) NOT NULL AUTO_INCREMENT,
  `nomPF` varchar(45) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `eventoDes` varchar(250) NOT NULL,
  `idproyecto` int(11) NOT NULL,
  `tamPF` int(11) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idprocesoFuncional`),
  KEY `idproyecto_idx` (`idproyecto`),
  CONSTRAINT `idproyecto` FOREIGN KEY (`idproyecto`) REFERENCES `proyecto` (`idproyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procesofuncional`
--

LOCK TABLES `procesofuncional` WRITE;
/*!40000 ALTER TABLE `procesofuncional` DISABLE KEYS */;
INSERT INTO `procesofuncional` VALUES (1,'cualquiera','descripcion','entrada desencadenante',2,0,1),(2,'cualquiera','descripcion','entrada desencadenenante',2,0,0),(3,'Pancho','Nuevo','Genial',2,0,1),(4,'Mi Proceso Funcional','Esta es una descripción para el proceso funcional.','Esta es una instancia de evento desencadenante',2,0,0),(5,'Nuevo','hkjekj','nhjhkj',4,0,0);
/*!40000 ALTER TABLE `procesofuncional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proyecto` (
  `idproyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nomProy` varchar(60) NOT NULL,
  `anioProy` varchar(4) NOT NULL,
  `operProy` tinyint(4) NOT NULL,
  `duraProy` decimal(9,2) NOT NULL,
  `esfuTotProy` decimal(9,2) NOT NULL,
  `esfuPlaneProy` decimal(9,2) NOT NULL,
  `esfuEsReqProy` decimal(9,2) NOT NULL,
  `esfuAnaDisProy` decimal(9,2) NOT NULL,
  `esfuConstProy` decimal(9,2) NOT NULL,
  `esfuPrueProy` decimal(9,2) NOT NULL,
  `esfuImpleDesProy` decimal(9,2) NOT NULL,
  `costTotProy` decimal(9,2) NOT NULL,
  `costEsReqProy` decimal(9,2) NOT NULL,
  `costAnaDisProy` decimal(9,2) NOT NULL,
  `costConstProy` decimal(9,2) NOT NULL,
  `costPrueProy` decimal(9,2) NOT NULL,
  `costImpleDesProy` decimal(9,2) NOT NULL,
  `tamFunProy` decimal(9,2) NOT NULL,
  `fpAjusProy` decimal(9,2) NOT NULL,
  `medidorCertProy` tinyint(4) NOT NULL,
  `expeMedMetProy` int(11) NOT NULL,
  `usoCase` tinyint(4) NOT NULL,
  `certModelo` tinyint(4) NOT NULL,
  `comCertModelo` varchar(250) NOT NULL,
  `costPlanProy` decimal(11,2) NOT NULL,
  `confInfo` varchar(45) NOT NULL,
  `arqProyecto` varchar(45) NOT NULL,
  `metDesarrollo` varchar(45) NOT NULL,
  `metMedicion` varchar(45) NOT NULL,
  `sisOpe` varchar(45) NOT NULL,
  `tipoDesarrollo` varchar(45) NOT NULL,
  `lenguaje` varchar(45) NOT NULL,
  `modCalidad` varchar(45) NOT NULL,
  `baseDatos` varchar(45) NOT NULL,
  `secOrg` varchar(45) NOT NULL,
  `estatus` tinyint(4) NOT NULL,
  `tipoOrg` varchar(45) NOT NULL,
  `tipoCapOrg` varchar(45) NOT NULL,
  `tamOrgDes` varchar(45) NOT NULL,
  `tamOrgUsa` varchar(45) NOT NULL,
  `marcoPosUsa` varchar(45) NOT NULL,
  `escala` varchar(45) NOT NULL,
  `capDes` varchar(45) NOT NULL,
  `proposito` varchar(250) NOT NULL,
  `alcance` varchar(250) NOT NULL,
  PRIMARY KEY (`idproyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,'C-Reg','1993',1,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,1,10,1,0,'foo',12.00,'abcdef','abcdefg','abcdef','abcdefg','abcdef','abcdefg','abcdef','abcdefg','abcdef','abcdefg',1,'abcdef','abcdefg','abcdef','abcdefg','abcdef','abcdefg','abcdefg','abcdef','abcdefg'),(2,'SGPF','1993',1,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,10.00,1,10,1,0,'foo',12.00,'abcdef','abcdefg','abcdef','abcdefg','abcdef','abcdefg','abcdef','abcdefg','abcdef','abcdefg',0,'abcdef','abcdefg','abcdef','abcdefg','abcdef','abcdefg','abcdefg','abcdef','abcdefg'),(3,'Olgasss','2015',1,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,1,1,1,1,'Olgasss',0.24,'Olgasss','Olgasss','Olgasss','Olgasss','Olgasss','Olgasss','Olgasss','Olgasss','Olgasss','Olgasss',1,'Olgasss','Olgasss','Olgasss','Olgasss','Olgasss','Olgasss','Olgasss','Olgasss','Olgasss'),(4,'C-Reg691ffeaafe23','2015',1,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,0.24,1,1,1,1,'C-Reg69123',0.24,'C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123',0,'C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123','C-Reg69123');
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subproceso`
--

DROP TABLE IF EXISTS `subproceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subproceso` (
  `idsubProceso` int(11) NOT NULL AUTO_INCREMENT,
  `flujoAl` tinyint(4) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `idusuarioFuncional` int(11) NOT NULL,
  `idaccion` int(11) NOT NULL,
  `idgrupoDato` int(11) NOT NULL,
  `idprocesoFuncional` int(11) NOT NULL,
  `actividad` varchar(45) NOT NULL,
  `indice` int(11) NOT NULL,
  PRIMARY KEY (`idsubProceso`),
  KEY `idusuarioFuncional_idx` (`idusuarioFuncional`),
  KEY `idaccion_idx` (`idaccion`),
  KEY `idgrupoDato_idx` (`idgrupoDato`),
  KEY `idprocesoFuncional_idx` (`idprocesoFuncional`),
  CONSTRAINT `idaccion` FOREIGN KEY (`idaccion`) REFERENCES `accion` (`idaccion`),
  CONSTRAINT `idgrupoDato` FOREIGN KEY (`idgrupoDato`) REFERENCES `grupodato` (`idgrupodato`),
  CONSTRAINT `idprocesoFuncional` FOREIGN KEY (`idprocesoFuncional`) REFERENCES `procesofuncional` (`idprocesofuncional`),
  CONSTRAINT `idusuarioFuncional` FOREIGN KEY (`idusuarioFuncional`) REFERENCES `usuariofuncional` (`idusuariofuncional`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subproceso`
--

LOCK TABLES `subproceso` WRITE;
/*!40000 ALTER TABLE `subproceso` DISABLE KEYS */;
INSERT INTO `subproceso` VALUES (1,0,'los datos de',2,1,1,2,'Inicio de PF',1),(2,0,'los datos de',2,1,1,2,'Inicio de PF',2),(3,0,'los datos de',2,1,1,2,'Valida',1),(4,0,'los datos de',2,1,1,2,'Valida',2),(5,1,'canjlewnlk',1,1,2,5,'Inicio de Proceso Funcional',1),(6,1,'caenew',1,1,2,5,'Inicio de Proceso Funcional',2);
/*!40000 ALTER TABLE `subproceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nomUsuario` varchar(45) NOT NULL,
  `pwdUsuario` varchar(45) NOT NULL,
  `usuTipo1` tinyint(4) DEFAULT NULL,
  `usuTipo2` tinyint(4) DEFAULT NULL,
  `usuTipo3` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Olga','pass',1,NULL,NULL),(2,'Juan','pass',NULL,1,NULL),(3,'Pancho','pass',NULL,NULL,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariofuncional`
--

DROP TABLE IF EXISTS `usuariofuncional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuariofuncional` (
  `idusuarioFuncional` int(11) NOT NULL AUTO_INCREMENT,
  `nomUF` varchar(45) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idusuarioFuncional`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariofuncional`
--

LOCK TABLES `usuariofuncional` WRITE;
/*!40000 ALTER TABLE `usuariofuncional` DISABLE KEYS */;
INSERT INTO `usuariofuncional` VALUES (1,'Registradores','Registrador del IIMAST',1),(2,'C-Reg','Sistema C-Reg',1),(3,'Registrador','Registrador C-Reg',1),(4,'Juano','FHKLI',1);
/*!40000 ALTER TABLE `usuariofuncional` ENABLE KEYS */;
UNLOCK TABLES;


-- Dump completed on 2018-05-13 18:23:45

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

COMMIT;