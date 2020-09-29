-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema inventario_kiba
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema inventario_kiba
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `inventario_kiba` DEFAULT CHARACTER SET utf8 ;
USE `inventario_kiba` ;

-- -----------------------------------------------------
-- Table `inventario_kiba`.`Inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario_kiba`.`Inventario` (
  `inv_id` INT NOT NULL,
  `inv_fecha_ingreso` DATE NOT NULL,
  `inv_fecha_salida` DATE NOT NULL,
  `inv_codigo_operacion` VARCHAR(8) NOT NULL,
  `inv_stock` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`inv_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario_kiba`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario_kiba`.`Producto` (
  `pro_id` INT NOT NULL,
  `pro_codigo` VARCHAR(20) NOT NULL,
  `pro_descripcion` VARCHAR(50) NOT NULL,
  `pro_especie` VARCHAR(15) NOT NULL,
  `pro_cantidad` DECIMAL(10,2) NOT NULL,
  `pro_tipo_madera` VARCHAR(30) NOT NULL,
  `pro_tipo_troza` VARCHAR(30) NOT NULL,
  `pro_procedencia` VARCHAR(30) NOT NULL,
  `pro_proveedor` VARCHAR(30) NOT NULL,
  `pro_tranportista` VARCHAR(30) NOT NULL,
  `inv_id` INT NOT NULL,
  PRIMARY KEY (`pro_id`),
  INDEX `fk_Producto_Inventario_idx` (`inv_id` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_Inventario`
    FOREIGN KEY (`inv_id`)
    REFERENCES `inventario_kiba`.`Inventario` (`inv_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventario_kiba`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventario_kiba`.`Usuario` (
  `usr_id` INT NOT NULL,
  `usr_nombres` VARCHAR(45) NOT NULL,
  `usr_apellidos` VARCHAR(45) NOT NULL,
  `usr_dni` VARCHAR(8) NOT NULL,
  `usr_registro` DATE NOT NULL,
  `usr_tipo` VARCHAR(30) NOT NULL,
  `inv_id` INT NOT NULL,
  PRIMARY KEY (`usr_id`),
  INDEX `fk_Usuario_Inventario1_idx` (`inv_id` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Inventario1`
    FOREIGN KEY (`inv_id`)
    REFERENCES `inventario_kiba`.`Inventario` (`inv_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
