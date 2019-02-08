CREATE TABLE `compasso`.`tbl_cidade` (
  `id_cidade` INT NOT NULL AUTO_INCREMENT,
  `nm_cidade` VARCHAR(255) NULL,
  `id_estado` VARCHAR(2) NULL,
  PRIMARY KEY (`id_cidade`))
COMMENT = 'Tabela utilizada para armazenar os dados de cidade;';



CREATE TABLE `compasso`.`tbl_cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nm_cliente` VARCHAR(255) NOT NULL,
  `cd_sexo` CHAR(1) NULL,
  `dt_nascimento` DATE NULL,
  `id_cidade` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  FOREIGN KEY (id_cidade) REFERENCES tbl_cidade(id_cidade)
)
COMMENT = 'Tabela utilizada para armazenar os dados do cliente e o relacionar a uma cidade;';
;