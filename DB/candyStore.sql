-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema candy_store
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `candy_store` ;

-- -----------------------------------------------------
-- Schema candy_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `candy_store` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `candy_store` ;

-- -----------------------------------------------------
-- Table `candy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `candy` ;

CREATE TABLE IF NOT EXISTS `candy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `calories` INT NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `available` TINYINT(1) NULL DEFAULT NULL,
  `average_price` DECIMAL(5,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SET SQL_MODE = '';
DROP USER IF EXISTS candyman@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'candyman'@'localhost' IDENTIFIED BY 'candyman';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'candyman'@'localhost';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'candyman'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `candy`
-- -----------------------------------------------------
START TRANSACTION;
USE `candy_store`;
INSERT INTO `candy` (`id`, `name`, `calories`, `description`, `available`, `average_price`) VALUES (1, 'Gobstoppers', 0, 'yummy yum yum', true, 5.25);
INSERT INTO `candy` (`id`, `name`, `calories`, `description`, `available`, `average_price`) VALUES (2, 'marshmallows', 25, 'melt in your mouth', true, .99);
INSERT INTO `candy` (`id`, `name`, `calories`, `description`, `available`, `average_price`) VALUES (3, 'snickers', 225, 'delicious caramel and nuts', true, 2.99);
INSERT INTO `candy` (`id`, `name`, `calories`, `description`, `available`, `average_price`) VALUES (4, 'Knoppers', 100, 'chocolate and wafer', false, 4.99);

COMMIT;

