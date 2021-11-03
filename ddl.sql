-- starthair.categoria definition

CREATE TABLE categoria (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;


-- starthair.cliente definition

CREATE TABLE cliente (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(80) NOT NULL,
  cpf varchar(20) NOT NULL,
  sexo varchar(45) DEFAULT NULL,
  data_nascimento date NOT NULL,
  email varchar(255) NOT NULL,
  senha varchar(255) NOT NULL,
  telefone varchar(45) NOT NULL,
  endereco varchar(255) NOT NULL,
  cidade varchar(255) NOT NULL,
  estado varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;


-- starthair.funcionario definition

CREATE TABLE funcionario (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(100) NOT NULL,
  cpf varchar(14) NOT NULL,
  sexo varchar(45) DEFAULT NULL,
  data_nascimento date NOT NULL,
  email varchar(45) NOT NULL,
  senha varchar(45) NOT NULL,
  telefone varchar(45) NOT NULL,
  endereco varchar(255) NOT NULL,
  cidade varchar(255) NOT NULL,
  estado varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;


-- starthair.agendamento definition

CREATE TABLE agendamento (
  id int NOT NULL AUTO_INCREMENT,
  data_agendamento datetime NOT NULL,
  clientes_id int NOT NULL,
  servico varchar(200) NOT NULL,
  PRIMARY KEY (id),
  KEY fk_agendamento_clientes1_idx (clientes_id),
  CONSTRAINT fk_agendamento_clientes1 FOREIGN KEY (clientes_id) REFERENCES cliente (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;


-- starthair.produto definition

CREATE TABLE produto (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(255) NOT NULL,
  descricao text,
  preco_unid decimal(10,0) NOT NULL,
  quant_estoque int NOT NULL,
  categoria_id int NOT NULL,
  funcionario_id int NOT NULL,
  status_prod varchar(45) NOT NULL,
  PRIMARY KEY (id,categoria_id,funcionario_id),
  KEY fk_produtos_categoria1_idx (categoria_id),
  KEY fk_produto_funcionario1_idx (funcionario_id),
  CONSTRAINT fk_produto_funcionario1 FOREIGN KEY (funcionario_id) REFERENCES funcionario (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT fk_produtos_categoria1 FOREIGN KEY (categoria_id) REFERENCES categoria (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;


-- starthair.produtovenda definition

CREATE TABLE produtovenda (
  id int NOT NULL AUTO_INCREMENT,
  quantidade int NOT NULL DEFAULT '1',
  produtos_id int NOT NULL,
  PRIMARY KEY (id,produtos_id),
  KEY fk_produto_pedido_produtos1_idx (produtos_id),
  CONSTRAINT fk_produto_pedido_produtos1 FOREIGN KEY (produtos_id) REFERENCES produto (id)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;


-- starthair.venda definition

CREATE TABLE venda (
  id int NOT NULL AUTO_INCREMENT,
  data_pedido timestamp NOT NULL,
  desconto int DEFAULT NULL,
  forma_pagamento varchar(200) NOT NULL,
  parcelas smallint DEFAULT '0',
  valor_total float NOT NULL,
  valor_pago float NOT NULL,
  cliente_id int NOT NULL,
  produtovenda_id int NOT NULL,
  PRIMARY KEY (id,produtovenda_id),
  KEY fk_venda_clientes1_idx (cliente_id),
  KEY fk_venda_produto_venda1_idx (produtovenda_id),
  CONSTRAINT fk_venda_clientes1 FOREIGN KEY (cliente_id) REFERENCES cliente (id),
  CONSTRAINT fk_venda_produto-venda1 FOREIGN KEY (produtovenda_id) REFERENCES produtovenda (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;