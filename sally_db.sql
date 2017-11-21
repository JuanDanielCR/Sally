-- MySQL Script generated by MySQL Workbench
-- 11/20/17 21:30:56
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sally
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sally
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sally` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sally` ;

-- -----------------------------------------------------
-- Table `sally`.`Permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Permiso` (
  `idPermiso` INT NOT NULL COMMENT '',
  `estatus` INT NULL COMMENT '',
  `valor` INT NULL COMMENT '',
  PRIMARY KEY (`idPermiso`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`Rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Rol` (
  `idRol` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `tipo` VARCHAR(20) NOT NULL DEFAULT '\"usuario\"' COMMENT '',
  `idPermiso` INT NOT NULL COMMENT '',
  `estatus` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idRol`)  COMMENT '',
  INDEX `idPermiso_idx` (`idPermiso` ASC)  COMMENT '',
  CONSTRAINT `idPermiso`
    FOREIGN KEY (`idPermiso`)
    REFERENCES `sally`.`Permiso` (`idPermiso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`Ocupacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Ocupacion` (
  `idOcupacion` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Descripcion` VARCHAR(45) NOT NULL COMMENT '',
  `estatus` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idOcupacion`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nombre` VARCHAR(30) NOT NULL COMMENT '',
  `apellidoM` VARCHAR(20) NULL COMMENT '',
  `apellidoP` VARCHAR(20) NULL COMMENT '',
  `sexo` CHAR NULL COMMENT '',
  `edad` INT NULL COMMENT '',
  `idRol` INT NOT NULL COMMENT '',
  `correo` VARCHAR(45) NOT NULL COMMENT '',
  `contraseña` VARCHAR(20) NOT NULL COMMENT '',
  `idOcupacion` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idCliente`)  COMMENT '',
  INDEX `idRol_idx` (`idRol` ASC)  COMMENT '',
  INDEX `idOcupacion_idx` (`idOcupacion` ASC)  COMMENT '',
  CONSTRAINT `idRol`
    FOREIGN KEY (`idRol`)
    REFERENCES `sally`.`Rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idOcupacion`
    FOREIGN KEY (`idOcupacion`)
    REFERENCES `sally`.`Ocupacion` (`idOcupacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`Direccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Direccion` (
  `idDireccion` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `calle` VARCHAR(45) NOT NULL COMMENT '',
  `ciudad` VARCHAR(45) NOT NULL COMMENT '',
  `pais` VARCHAR(45) NOT NULL COMMENT '',
  `estado` VARCHAR(45) NOT NULL COMMENT '',
  `colonia` VARCHAR(45) NOT NULL COMMENT '',
  `codigoP` VARCHAR(5) NOT NULL COMMENT '',
  `estatus` INT NOT NULL COMMENT '',
  `idCliente` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idDireccion`)  COMMENT '',
  INDEX `idCliente_idx` (`idCliente` ASC)  COMMENT '',
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `sally`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`Plantilla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Plantilla` (
  `idPlantilla` INT NOT NULL COMMENT '',
  `estatus` INT NOT NULL COMMENT '',
  `idCreador` INT NOT NULL COMMENT '',
  `objetivo` VARCHAR(45) NOT NULL COMMENT '',
  `idCliente` INT NOT NULL COMMENT '',
  `version` INT NOT NULL COMMENT '',
  `isPropia` INT NOT NULL COMMENT '',
  INDEX `idCliente_idx` (`idCliente` ASC)  COMMENT '',
  PRIMARY KEY (`idPlantilla`, `idCliente`)  COMMENT '',
  CONSTRAINT `fk_plantilla_Cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `sally`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;


-- -----------------------------------------------------
-- Table `sally`.`Tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Tipo` (
  `Descripcion` VARCHAR(30) NOT NULL COMMENT '',
  `estatus` INT NOT NULL COMMENT '',
  `idTipo` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `idPlantilla` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idTipo`)  COMMENT '',
  INDEX `idPlantilla_idx` (`idPlantilla` ASC)  COMMENT '',
  CONSTRAINT `idPlantilla`
    FOREIGN KEY (`idPlantilla`)
    REFERENCES `sally`.`Plantilla` (`idPlantilla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`Solucion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Solucion` (
  `idSolucion` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `jerarquia` INT NOT NULL COMMENT '',
  `descripcion` VARCHAR(45) NOT NULL COMMENT '',
  `idPlantilla` INT NOT NULL COMMENT '',
  `estatus` INT NOT NULL COMMENT '',
  `idCliente` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idSolucion`, `idPlantilla`, `idCliente`)  COMMENT '',
  INDEX `idPlantila_idx` (`idPlantilla` ASC)  COMMENT '',
  INDEX `idCliente_idx` (`idCliente` ASC)  COMMENT '',
  CONSTRAINT `fk_solucion_plantilla`
    FOREIGN KEY (`idPlantilla`)
    REFERENCES `sally`.`Plantilla` (`idPlantilla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solucion_cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `sally`.`Plantilla` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`Criterio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Criterio` (
  `idCriterio` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Descripcion` VARCHAR(45) NOT NULL COMMENT '',
  `Ponderacion` INT NOT NULL COMMENT '',
  `idSolucion` INT NOT NULL COMMENT '',
  `idCliente` INT NOT NULL COMMENT '',
  `idPlantilla` INT NOT NULL COMMENT '',
  `contenido` FLOAT NULL COMMENT '',
  `Criteriocol` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idCriterio`, `idCliente`, `idSolucion`, `idPlantilla`)  COMMENT '',
  INDEX `idSolucion_idx` (`idSolucion` ASC)  COMMENT '',
  INDEX `idPlantilla_idx` (`idPlantilla` ASC)  COMMENT '',
  CONSTRAINT `fk_criterio_idSolucion`
    FOREIGN KEY (`idSolucion`)
    REFERENCES `sally`.`Solucion` (`idSolucion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_criterio_idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `sally`.`Solucion` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_criterio_idPlantilla`
    FOREIGN KEY (`idPlantilla`)
    REFERENCES `sally`.`Solucion` (`idPlantilla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`TipoPago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`TipoPago` (
  `idTipoPago` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Descripcion` VARCHAR(45) NOT NULL COMMENT '',
  `estatus` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idTipoPago`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`Moneda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Moneda` (
  `idMoneda` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Nombre` VARCHAR(45) NOT NULL COMMENT '',
  `estatus` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idMoneda`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`Compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Compra` (
  `Folio` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `Descripcion` VARCHAR(45) NOT NULL COMMENT '',
  `referencia` VARCHAR(50) NOT NULL COMMENT '',
  `idMoneda` INT NOT NULL COMMENT '',
  `Monto` FLOAT NOT NULL COMMENT '',
  `fecha` DATE NOT NULL COMMENT '',
  `idTipoPago` INT NOT NULL COMMENT '',
  `customerld` VARCHAR(45) NOT NULL COMMENT '',
  `paymentld` VARCHAR(45) NOT NULL COMMENT '',
  `idPlantillaCompra` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Folio`, `idPlantillaCompra`)  COMMENT '',
  INDEX `idTipoPago_idx` (`idTipoPago` ASC)  COMMENT '',
  INDEX `idMoneda_idx` (`idMoneda` ASC)  COMMENT '',
  INDEX `idPlantilla_idx` (`idPlantillaCompra` ASC)  COMMENT '',
  CONSTRAINT `fk_compra_idTipoPago`
    FOREIGN KEY (`idTipoPago`)
    REFERENCES `sally`.`TipoPago` (`idTipoPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_idMoneda`
    FOREIGN KEY (`idMoneda`)
    REFERENCES `sally`.`Moneda` (`idMoneda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_idPlantilla`
    FOREIGN KEY (`idPlantillaCompra`)
    REFERENCES `sally`.`Plantilla` (`idPlantilla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sally`.`Contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sally`.`Contacto` (
  `idContacto` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `telefono` VARCHAR(12) NOT NULL COMMENT '',
  `correo` VARCHAR(45) NOT NULL COMMENT '',
  `estatus` INT NOT NULL COMMENT '',
  `idCliente` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idContacto`)  COMMENT '',
  INDEX `idCliente_idx` (`idCliente` ASC)  COMMENT '',
  CONSTRAINT `fk_contacto_idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `sally`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
