-- MySQL Script generated by MySQL Workbench
-- Thu Apr 26 14:00:49 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

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

-- -----------------------------------------------------
-- Table `SGPF`.`proyecto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`proyecto` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`proyecto` (
  `idproyecto` INT NOT NULL auto_increment,
  `nomProy` VARCHAR(60) NOT NULL,
  `anioProy` VARCHAR(4) NOT NULL,
  `operProy` TINYINT NOT NULL,
  `duraProy` INT NOT NULL,
  `esfuTotProy` INT NOT NULL,
  `esfuPlaneProy` INT NOT NULL,
  `esfuEsReqProy` INT NOT NULL,
  `esfuAnaDisProy` INT NOT NULL,
  `esfuConstProy` INT NOT NULL,
  `esfuPrueProy` INT NOT NULL,
  `esfuImpleDesProy` INT NOT NULL,
  `costTotProy` INT NOT NULL,
  `costEsReqProy` INT NOT NULL,
  `costAnaDisProy` INT NOT NULL,
  `costConstProy` INT NOT NULL,
  `costPrueProy` INT NOT NULL,
  `costImpleDesProy` INT NOT NULL,
  `tamFunProy` INT NOT NULL,
  `fpAjusProy` INT NOT NULL,
  `medidorCertProy` TINYINT NOT NULL,
  `expeMedMetProy` INT NOT NULL,
  `usoCase` TINYINT NOT NULL,
  `certModelo` TINYINT NOT NULL,
  `comCertModelo` VARCHAR(250) NOT NULL,
  `costPlanProy` DECIMAL(11,2) NOT NULL,
  `confInfo` VARCHAR(45) NOT NULL,
  `arqProyecto` VARCHAR(45) NOT NULL,
  `metDesarrollo` VARCHAR(45) NOT NULL,
  `metMedicion` VARCHAR(45) NOT NULL,
  `sisOpe` VARCHAR(45) NOT NULL,
  `tipoDesarrollo` VARCHAR(45) NOT NULL,
  `lenguaje` VARCHAR(45) NOT NULL,
  `modCalidad` VARCHAR(45) NOT NULL,
  `baseDatos` VARCHAR(45) NOT NULL,
  `secOrg` VARCHAR(45) NOT NULL,
  `estatus` TINYINT NOT NULL,
  `tipoOrg` VARCHAR(45) NOT NULL,
  `tipoCapOrg` VARCHAR(45) NOT NULL,
  `tamOrgDes` VARCHAR(45) NOT NULL,
  `tamOrgUsa` VARCHAR(45) NOT NULL,
  `marcoPosUsa` VARCHAR(45) NOT NULL,
  `escala` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idproyecto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`usuario` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nomUsuario` VARCHAR(45) NOT NULL,
  `pwdUsuario` VARCHAR(45) NOT NULL,
  `usuTipo1` TINYINT NULL,
  `usuTipo2` TINYINT NULL,
  `usuTipo3` TINYINT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`procesoFuncional`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`procesoFuncional` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`procesoFuncional` (
  `idprocesoFuncional` INT NOT NULL AUTO_INCREMENT,
  `nomPF` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `entradaDes` VARCHAR(250) NOT NULL,
  `idproyecto` INT NOT NULL,
  `tamPF` INT NOT NULL,
  PRIMARY KEY (`idprocesoFuncional`),
  INDEX `idproyecto_idx` (`idproyecto` ASC),
  CONSTRAINT `idproyecto`
    FOREIGN KEY (`idproyecto`)
    REFERENCES `SGPF`.`proyecto` (`idproyecto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`usuarioFuncional`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`usuarioFuncional` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`usuarioFuncional` (
  `idusuarioFuncional` INT NOT NULL AUTO_INCREMENT,
  `nomUF` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuarioFuncional`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`accion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`accion` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`accion` (
  `idaccion` INT NOT NULL AUTO_INCREMENT,
  `nomAccion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idaccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`grupoDato`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`grupoDato` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`grupoDato` (
  `idgrupoDato` INT NOT NULL AUTO_INCREMENT,
  `nomGD` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idgrupoDato`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SGPF`.`subProceso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`subProceso` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`subProceso` (
  `idsubProceso` INT NOT NULL AUTO_INCREMENT,
  `flujoAl` TINYINT NULL,
  `descripcion` VARCHAR(250) NULL,
  `idusuarioFuncional` INT NOT NULL,
  `idaccion` INT NOT NULL,
  `idgrupoDato` INT NOT NULL,
  `idprocesoFuncional` INT NOT NULL,
  PRIMARY KEY (`idsubProceso`),
  INDEX `idusuarioFuncional_idx` (`idusuarioFuncional` ASC),
  INDEX `idaccion_idx` (`idaccion` ASC),
  INDEX `idgrupoDato_idx` (`idgrupoDato` ASC),
  INDEX `idprocesoFuncional_idx` (`idprocesoFuncional` ASC),
  CONSTRAINT `idusuarioFuncional`
    FOREIGN KEY (`idusuarioFuncional`)
    REFERENCES `SGPF`.`usuarioFuncional` (`idusuarioFuncional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idaccion`
    FOREIGN KEY (`idaccion`)
    REFERENCES `SGPF`.`accion` (`idaccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idgrupoDato`
    FOREIGN KEY (`idgrupoDato`)
    REFERENCES `SGPF`.`grupoDato` (`idgrupoDato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idprocesoFuncional`
    FOREIGN KEY (`idprocesoFuncional`)
    REFERENCES `SGPF`.`procesoFuncional` (`idprocesoFuncional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `SGPF`.`interUP`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SGPF`.`interUP` ;

CREATE TABLE IF NOT EXISTS `SGPF`.`interUP` (
  `idinterUP` INT NOT NULL AUTO_INCREMENT,
  `idusuario` INT NOT NULL,
  `idproyecto` INT NOT NULL,
  PRIMARY KEY (`idinterUP`),
  INDEX `idusuario_idx` (`idusuario` ASC),
  INDEX `idproyecto_idx` (`idproyecto` ASC),
  CONSTRAINT `idusuario1`
    FOREIGN KEY (`idusuario`)
    REFERENCES `SGPF`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idproyecto1`
    FOREIGN KEY (`idproyecto`)
    REFERENCES `SGPF`.`proyecto` (`idproyecto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

set foreign_key_checks = 0;
-- --ESTE SI FUNCIONO
-- DELIMITER //
-- CREATE TRIGGER actualizaCFP AFTER INSERT ON SGPF.subProceso
-- FOR EACH ROW
-- BEGIN
--   DECLARE aux int default 0;
--   SET aux := (SELECT COUNT(*) FROM SGPF.subProceso
--    JOIN SGPF.procesoFuncional
--    ON subProceso.idprocesoFuncional = procesoFuncional.idprocesoFuncional
--     WHERE subProceso.flujoAl = 0 AND procesoFuncional.idprocesoFuncional = new.idprocesoFuncional);

--   UPDATE SGPF.procesoFuncional
--   SET tamPF  = aux
--   WHERE idprocesoFuncional =new.idprocesoFuncional;
-- END //

INSERT INTO usuarioFuncional values(1,'Juan');
insert into subProceso values(1,0,'prueba',1,1,1,1);
INSERT INTO procesoFuncional VALUES (1,'nombre','desci','¿e',1,25);

insert into proyecto (  idproyecto,
  nomProy,
  anioProy,
  operProy,
  duraProy,
  esfuTotProy,
  esfuPlaneProy,
  esfuEsReqProy,
  esfuAnaDisProy,
  esfuConstProy,
  esfuPrueProy,
  esfuImpleDesProy,
  costTotProy,
  costEsReqProy,
  costAnaDisProy,
  costConstProy,
  costPrueProy,
  costImpleDesProy,
  tamFunProy,
  fpAjusProy,
  medidorCertProy,
  expeMedMetProy,
  usoCase,
  certModelo,
  comCertModelo,
  costPlanProy,
  confInfo,
  arqProyecto,
  metDesarrollo,
  metMedicion,
  sisOpe,
  tipoDesarrollo,
  lenguaje,
  modCalidad,
  baseDatos,
  secOrg,
  estatus,
  tipoOrg,
  tipoCapOrg,
  tamOrgDes,
  tamOrgUsa,
  marcoPosUsa,
  escala)
values
(1, 'proyecto 1', '1990', true, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, true, 10, true, false, 'foo', 12.0, 'abcdef', 'abcdefg', 'abcdef', 'abcdefg', 'abcdef', 'abcdefg', 'abcdef', 'abcdefg', 'abcdef', 'abcdefg', false, 'abcdef', 'abcdefg', 'abcdef', 'abcdefg', 'abcdef', 'abcdefg');

insert into proyecto (  idproyecto,
  nomProy,
  anioProy,
  operProy,
  duraProy,
  esfuTotProy,
  esfuPlaneProy,
  esfuEsReqProy,
  esfuAnaDisProy,
  esfuConstProy,
  esfuPrueProy,
  esfuImpleDesProy,
  costTotProy,
  costEsReqProy,
  costAnaDisProy,
  costConstProy,
  costPrueProy,
  costImpleDesProy,
  tamFunProy,
  fpAjusProy,
  medidorCertProy,
  expeMedMetProy,
  usoCase,
  certModelo,
  comCertModelo,
  costPlanProy,
  confInfo,
  arqProyecto,
  metDesarrollo,
  metMedicion,
  sisOpe,
  tipoDesarrollo,
  lenguaje,
  modCalidad,
  baseDatos,
  secOrg,
  estatus,
  tipoOrg,
  tipoCapOrg,
  tamOrgDes,
  tamOrgUsa,
  marcoPosUsa,
  escala)
values
(2, 'proyecto 2', '1993', true, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, true, 10, true, false, 'foo', 12.0, 'abcdef', 'abcdefg', 'abcdef', 'abcdefg', 'abcdef', 'abcdefg', 'abcdef', 'abcdefg', 'abcdef', 'abcdefg', false, 'abcdef', 'abcdefg', 'abcdef', 'abcdefg', 'abcdef', 'abcdefg');


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

COMMIT;
