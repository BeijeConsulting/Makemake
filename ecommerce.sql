CREATE TABLE `makemake`.`user` (
`id` INT NOT NULL AUTO_INCREMENT,
`username` VARCHAR(100) NOT NULL,
`name` VARCHAR(45) NULL,
`surname` VARCHAR(45) NULL,
`password` VARCHAR(45) NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `email_UNIQUE` (`username` ASC) VISIBLE);


CREATE TABLE `makemake`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `brand` VARCHAR(45) NULL,
  `desc` VARCHAR(255) NULL,
  `price` DECIMAL NOT NULL DEFAULT 0,
  `image` VARCHAR(255) NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
  
  
CREATE TABLE `makemake`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `id_user` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `total` DECIMAL NOT NULL,
  PRIMARY KEY (`id`));
  
  
CREATE TABLE `makemake`.`order_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_order` INT NOT NULL,
  `id_product` INT NOT NULL,
  `price` DECIMAL NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id`));
  
  
ALTER TABLE `makemake`.`order` 
ADD INDEX `fk_user_idx` (`id_user` ASC) VISIBLE;
;
ALTER TABLE `makemake`.`order` 
ADD CONSTRAINT `fk_user`
  FOREIGN KEY (`id_user`)
  REFERENCES `makemake`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
ALTER TABLE `makemake`.`order_item` 
ADD INDEX `fk_order_idx` (`id_order` ASC) VISIBLE,
ADD INDEX `fk_product_idx` (`id_product` ASC) VISIBLE;
;
ALTER TABLE `makemake`.`order_item` 
ADD CONSTRAINT `fk_order`
  FOREIGN KEY (`id_order`)
  REFERENCES `makemake`.`order` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_product`
  FOREIGN KEY (`id_product`)
  REFERENCES `makemake`.`product` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  