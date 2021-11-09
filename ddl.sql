-- starthair.categoria definition

-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: starthair
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_agendamento` datetime NOT NULL,
  `cliente_id` int NOT NULL,
  `servico` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_agendamento_cliente1_idx` (`cliente_id`),
  CONSTRAINT `fk_agendamento_cliente1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
INSERT INTO `agendamento` VALUES (1,'2021-04-22 23:05:00',1,'Pedicure'),(2,'2022-09-08 10:21:00',2,'Cabelo'),(3,'2021-03-18 12:22:00',3,'Manicure'),(4,'2022-08-31 03:59:00',4,'Cabelo'),(5,'2020-10-27 07:53:00',5,'Cabelo'),(6,'2021-04-29 23:05:00',1,'Pedicure'),(7,'2022-09-08 09:21:00',2,'Cabelo'),(8,'2021-03-18 16:22:00',3,'Cabelo'),(9,'2022-08-31 20:59:00',4,'Manicure'),(10,'2020-05-27 07:00:00',5,'Pedicure');
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Shampoo e condicionador'),(2,'Hidratação'),(3,'Tinta');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Lenore','123.456.789-10','feminino','2001-06-24','dignissim.magna@interdumCurabiturdictum.com','RPD91XPG1JP','034-11928-8563','rua coronel kleber de andrade','jaboatão','PE',2),(2,'Ryan','343.444.890-23','masculino','2007-06-11','posuere.at.velit@tellusSuspendisse.org','RWT01JVD2PS','044-96628-4583','','','',NULL),(3,'Jason','624.674.234-67','masculino','2016-03-29','lorem@Nullamsuscipit.edu','DPE10KTU2RD','095-70973-1210','','','',NULL),(4,'Colby','965.123.784-42','masculino','2010-05-30','mus.Proin@placerategetvenenatis.org','SQE07POL6AU','007-68384-0051','','','',NULL),(5,'Shelby','888.511.345-12','feminino','2018-05-23','tortor.dictum.eu@nibh.com','GNN46JWU0RS','090-88890-8926','','','',NULL),(6,'Erin','521.632.948-89','feminino','2015-10-03','gravida@molestie.edu','MMK46KVZ7HK','091-16981-8788','','','',NULL),(7,'Rhoda','786.111.124-456','feminino','2013-02-02','venenatis@quispedeSuspendisse.edu','UPU91OSV1TQ','076-25310-6128','','','',NULL),(8,'Noble','253.456.789-10','outro','2020-07-17','lorem.luctus.ut@euismod.com','OHT80DJF3HT','082-24608-4847','','','',NULL),(9,'McKenzie','102.555.277-78','masculino','2013-06-08','dolor.Donec@maurisaliquameu.co.uk','CPB42ZUI9YZ','061-91846-2831','','','',NULL),(10,'Chiquita','454.212.675-07','outro','2019-10-31','tempus.non@lectusjusto.ca','LQR94BXC0NC','031-06225-8616','','','',NULL),(11,'qweqweqwe','123.123.123-12','Masculino','2021-11-01','asdasdas@asdasd','123123123','(12) 31231-2312','12341324rqerwer','3wsaeqweqweqwe','AC',NULL),(12,'carlos henrique camilo','711.377.844-58','Masculino','2021-11-23','carlos_camilo250@hotmail.com','carlos250','(81) 99572-7182','Rua coronel kleber de andrade ','Jaboatao dos Guararapes','CE',NULL),(13,'carlos henrique camilo','711.377.844-58','Masculino','2021-11-11','carlos_camilo250@hotmail.com','11111','(11) 11111-1111','Rua coronel kleber de andrade ','Jaboatao dos Guararapes','SE',NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Severina','704.596.132-65',NULL,'0000-00-00','severina48@gmail.com ','845994as','985649871','','','',1),(2,'Jorge','954.268.165-43',NULL,'0000-00-00','jorgealves15@hotmail.com','Jorge84516 ','915641165','','','',NULL),(3,'Heitor','352.614.897-56',NULL,'0000-00-00','heitorvictor1561@gmail.com','heitor8194','916164131','','','',NULL),(4,'Walisson','864.224.561-84',NULL,'0000-00-00','walisson@gmail.com','hvh58465','948464512','','','',NULL),(5,'Victor','345.612.487-95',NULL,'0000-00-00','victorguilherme@hotmail.com','vuctorcgch8','973523485','','','',NULL),(6,'Severino','215.494.661-31',NULL,'0000-00-00','severino@gmail.com','severino1613','997464212','','','',NULL),(7,'Melissa','781.846.414-31',NULL,'0000-00-00','melissa@gmail.com','gvnhg54621a','946513221','','','',NULL),(8,'Sofia','314.614.761-16',NULL,'0000-00-00','sofia@gmail.com','sofia2351','986542132','','','',NULL),(9,'Helena','167.562.431-57',NULL,'0000-00-00','helena@gmail.com','23hvu54568','984651123','','','',NULL),(10,'Ryan','701.465.176-16',NULL,'0000-00-00','ryanlucas@gmail.com','lucas3678','946165498','','','',NULL);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` text,
  `preco_unid` decimal(10,0) NOT NULL,
  `quant_estoque` int NOT NULL,
  `categoria_id` int NOT NULL,
  `funcionario_id` int NOT NULL,
  `status_prod` varchar(45) NOT NULL,
  PRIMARY KEY (`id`,`categoria_id`,`funcionario_id`),
  KEY `fk_produtos_categoria1_idx` (`categoria_id`),
  KEY `fk_produto_funcionario1_idx` (`funcionario_id`),
  CONSTRAINT `fk_produto_funcionario1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_produtos_categoria1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Shampoo ClearMan Anticaspas 200ml','Shampoo Contra caspas da clear',50,10,1,1,'ativo'),(2,'Shampoo Elseve liso extremo 500ml','Shampoo para cabelos lisos',80,0,1,2,'inativo'),(3,'Tinta Maxton Preto brilhoso','Tinta preta para cabelo',50,15,3,3,'ativo'),(4,'Hidratação elseve cabelos cacheados 1L','Hidratação para cabelos cacheados',150,5,2,4,'ativo'),(5,'Hidratção lisos extremos Loreal Paris 500ml','Hidaratação para cabelos lisos',90,6,2,5,'ativo'),(6,'Shampoo antiquedas tressemé','Shampoo para quedas de cabelo',80,2,1,6,'ativo'),(7,'Condicionador reparador de pontas Johnson & Johnson','Condicionador para reparação de pontas',50,1,1,7,'ativo'),(8,'Shampoo antiquedas Clear 500ml','Shampoo para quedas de cabelo',100,0,1,8,'inativo'),(9,'Tinta vermelha Soft Color','Tinta para cabelos cacheados da cor vermelho rubro',55,1,3,9,'ativo'),(10,'Kit hidratação Dias Frios','Duas Hidratações para todos os tipos de cabelos',150,0,2,10,'inativo');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtovenda`
--

DROP TABLE IF EXISTS `produtovenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtovenda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantidade` int NOT NULL DEFAULT '1',
  `produtos_id` int NOT NULL,
  PRIMARY KEY (`id`,`produtos_id`),
  KEY `fk_produto_pedido_produtos1_idx` (`produtos_id`),
  CONSTRAINT `fk_produto_pedido_produtos1` FOREIGN KEY (`produtos_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtovenda`
--

LOCK TABLES `produtovenda` WRITE;
/*!40000 ALTER TABLE `produtovenda` DISABLE KEYS */;
INSERT INTO `produtovenda` VALUES (1,5,1),(2,9,3),(3,1,6),(4,4,4),(5,5,1),(6,1,3),(7,10,1),(8,1,9),(9,2,6),(10,8,1);
/*!40000 ALTER TABLE `produtovenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'severina@gmail.com','123'),(2,'Lenore@gmail.com','123'),(3,'carlos_camilo250@hotmail.com','11111');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_pedido` timestamp NOT NULL,
  `desconto` int DEFAULT NULL,
  `forma_pagamento` varchar(200) NOT NULL,
  `parcelas` smallint DEFAULT '0',
  `valor_total` float NOT NULL,
  `valor_pago` float NOT NULL,
  `cliente_id` int NOT NULL,
  `produtovenda_id` int NOT NULL,
  PRIMARY KEY (`id`,`produtovenda_id`),
  KEY `fk_venda_clientes1_idx` (`cliente_id`),
  KEY `fk_venda_produto_venda1_idx` (`produtovenda_id`),
  CONSTRAINT `fk_venda_clientes1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `fk_venda_produto-venda1` FOREIGN KEY (`produtovenda_id`) REFERENCES `produtovenda` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,'2021-04-15 23:30:00',5,'debito',1,90.49,85.96,1,1),(2,'2021-08-20 22:34:20',4,'credito',2,150,144,2,2),(3,'2021-10-21 12:11:59',5,'debito',1,50.5,47.97,3,3),(4,'2021-03-11 14:40:00',9,'boleto',1,240.75,228.71,4,4),(5,'2021-01-17 19:50:49',10,'boleto',1,40,36,5,5),(6,'2021-02-28 13:20:00',15,'credito',5,75.99,64.6,6,6),(7,'2021-09-04 23:42:13',10,'debito',1,540.99,486.9,7,7),(8,'2021-12-03 12:30:15',6,'credito',6,25.54,24,8,8),(9,'2021-05-03 18:40:05',25,'boleto',1,125.9,94.42,9,9),(10,'2021-02-08 03:00:00',8,'debito',1,45.8,42.13,10,10);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'starthair'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-05 21:57:21