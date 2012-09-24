-- Role: plus

-- DROP ROLE plus;

CREATE ROLE plus LOGIN
  ENCRYPTED PASSWORD 'md5e972e3a3f7aa301c314ca24a5ea43146'
  SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;

-- Database: sysdb

-- DROP DATABASE sysdb;

CREATE DATABASE sysdb
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;
GRANT ALL ON DATABASE sysdb TO plus;

CREATE TABLE FOP_FORMA_PAGAMENTO (
  FOP_ID INTEGER  NOT NULL ,
  FOP_NOME VARCHAR(200) NULL,
  FOP_SIGLA VARCHAR(5) NULL,
  FOP_DTCADASTRO DATE NULL,
  FOP_STATUS CHAR NULL,
  FOP_DESCRICAO VARCHAR(1000) NULL,
  PRIMARY KEY(FOP_ID)
);

CREATE TABLE LOJ_LOJA (
  LOJ_ID INTEGER  NOT NULL ,
  LOJ_NOME VARCHAR(200) NULL,
  LOJ_TELEFONE VARCHAR(15) NULL,
  LOJ_ENDERECO VARCHAR(200) NULL,
  LOJ_CNPJ VARCHAR(20) NULL,
  LOJ_END_NUM INTEGER NULL,
  LOJ_BAIRRO VARCHAR(200) NULL,
  LOJ_CEP VARCHAR(20) NULL,
  LOJ_STATUS CHAR NULL,
  LOJ_CELULAR VARCHAR(15) NULL,
  LOJ_DTCADASTRO DATE NULL,
  LOJ_DESCRICAO VARCHAR(1000) NULL,
  CID_ID INTEGER NULL,
  PRIMARY KEY(LOJ_ID)
);

CREATE INDEX LOJ_LOJA_FKIndex1 ON LOJ_LOJA(CID_ID);

CREATE TABLE TIM_TIPO_MERCADORIA (
  TIM_ID INTEGER  NOT NULL ,
  TIM_NOME VARCHAR(200) NULL,
  TIM_SIGLA VARCHAR(5) NULL,
  TIM_DTCADASTRO DATE NULL,
  TIM_DESCRICAO VARCHAR(1000) NULL,
  TIM_STATUS CHAR NULL,
  PRIMARY KEY(TIM_ID)
);

CREATE TABLE EST_ESTADO (
  EST_ID INTEGER  NOT NULL ,
  EST_NOME VARCHAR(200) NULL,
  EST_SIGLA VARCHAR(5) NULL,
  PRIMARY KEY(EST_ID)
);

CREATE TABLE TIV_TIPO_VENDA (
  TIV_ID INTEGER  NOT NULL ,
  TIV_NOME VARCHAR(200) NULL,
  TIV_DTCADASTRO DATE NULL,
  TIV_STATUS CHAR NULL,
  TIV_DESCRICAO VARCHAR(500) NULL,
  PRIMARY KEY(TIV_ID)
);

CREATE TABLE CID_CIDADE (
  CID_ID INTEGER  NOT NULL ,
  EST_ID INTEGER  NOT NULL,
  CID_NOME VARCHAR(200) NULL,
  PRIMARY KEY(CID_ID)
);

CREATE INDEX CID_CIDADE_FKIndex1 ON CID_CIDADE(EST_ID);

CREATE TABLE MER_MERCADORIA (
  MER_ID INTEGER  NOT NULL ,
  TIM_ID INTEGER  NOT NULL,
  MER_NOME VARCHAR(200) NULL,
  MER_DTCADASTRO DATE NULL,
  MER_VALOR MONEY NULL,
  MER_QUANTIDADE INTEGER  NULL,
  PRIMARY KEY(MER_ID)  
);

CREATE INDEX MER_MERCADORIA_FKIndex1 ON MER_MERCADORIA(TIM_ID);

CREATE TABLE FOR_FORNECEDOR (
  FOR_ID INTEGER  NOT NULL ,
  CID_ID INTEGER  NOT NULL,
  FOR_NOME VARCHAR(200) NULL,
  FOR_CNPJ VARCHAR(20) NULL,
  FOR_ENDERECO VARCHAR(200) NULL,
  FOR_TELEFONE VARCHAR(15) NULL,
  FOR_CELULAR VARCHAR(15) NULL,
  FOR_CONTATO VARCHAR(200) NULL,
  FOR_DESCRICAO VARCHAR(1000) NULL,
  FOR_DTCADASTRO DATE NULL,
  FOR_STATUS CHAR NULL,
  PRIMARY KEY(FOR_ID)  
);

CREATE INDEX FOR_FORNECEDOR_FKIndex1 ON FOR_FORNECEDOR(CID_ID);

CREATE TABLE VED_VENDEDOR (
  VED_ID INTEGER  NOT NULL ,
  CID_ID INTEGER  NOT NULL,
  LOJ_ID INTEGER  NOT NULL,
  VED_NOME VARCHAR(200) NULL,
  VED_TELEFONE VARCHAR(15) NULL,
  VED_CELULAR VARCHAR(15) NULL,
  VED_CPF VARCHAR(15) NULL,
  VED_ENDERECO VARCHAR(200) NULL,
  VED_DTNASCIMENTO DATE NULL,
  VED_DTCADASTRO DATE NULL,
  VED_STATUS CHAR NULL,
  PRIMARY KEY(VED_ID)
);

CREATE INDEX VED_VENDEDOR_FKIndex1 ON VED_VENDEDOR(LOJ_ID);
CREATE INDEX VED_VENDEDOR_FKIndex2 ON VED_VENDEDOR(CID_ID);

CREATE TABLE CLI_CLIENTE (
  CLI_ID INTEGER  NOT NULL ,
  CID_ID INTEGER  NOT NULL,
  LOJ_ID INTEGER  NOT NULL,
  CLI_NOME VARCHAR(100) NULL,
  CLI_RG VARCHAR(15) NULL,
  CLI_TELEFONE VARCHAR(15) NULL,
  CLI_CELULAR VARCHAR(15) NULL,
  CLI_ENDERECO VARCHAR(200) NULL,
  CLI_CPF VARCHAR(15) NULL,
  CLI_CNPJ VARCHAR(20) NULL,
  CLI_DESCRICAO VARCHAR(1000) NULL,
  CLI_DTCADASTRO DATE NULL,
  CLI_STATUS CHAR NULL,
  CLI_DTNASCIMENTO DATE NULL,
  PRIMARY KEY(CLI_ID)
);

CREATE INDEX CLI_CLIENTE_FKIndex1 ON CLI_CLIENTE(LOJ_ID);
CREATE INDEX CLI_CLIENTE_FKIndex2 ON CLI_CLIENTE(CID_ID);

CREATE TABLE COM_COMPRA (
  COM_ID INTEGER  NOT NULL ,
  FOR_ID INTEGER  NOT NULL,
  TIV_ID INTEGER  NOT NULL,
  FOP_ID INTEGER  NOT NULL,
  COM_VALOR MONEY NULL,
  COM_DATA DATE NULL,
  COM_DESCRICAO VARCHAR(1000) NULL,
  PRIMARY KEY(COM_ID)
);

CREATE INDEX COM_COMPRA_FKIndex1 ON COM_COMPRA(FOP_ID);
CREATE INDEX COM_COMPRA_FKIndex3 ON COM_COMPRA(TIV_ID,FOR_ID);

CREATE TABLE VEN_VENDA (
  VEN_ID INTEGER  NOT NULL ,
  CLI_ID INTEGER  NOT NULL,
  VED_ID INTEGER  NOT NULL,
  TIV_ID INTEGER  NOT NULL,
  FOP_ID INTEGER  NOT NULL,
  VEN_VALOR MONEY NULL,
  VEN_STATUS CHAR NULL,
  VEN_DATA DATE NULL,
  VEN_DESCRICAO VARCHAR(1000) NULL,
  PRIMARY KEY(VEN_ID)
);

CREATE INDEX VEN_VENDA_FKIndex1 ON VEN_VENDA(FOP_ID);
CREATE INDEX VEN_VENDA_FKIndex4 ON VEN_VENDA(TIV_ID,VED_ID,CLI_ID);

CREATE TABLE PGV_PAGAMENTO_VENDA (
  PGV_ID INTEGER  NOT NULL ,
  VEN_ID INTEGER  NOT NULL,
  PGV_DATA DATE NULL,
  PGV_VALOR MONEY NULL,
  PGV_STATUS CHAR NULL,
  PRIMARY KEY(PGV_ID, VEN_ID)  
);

CREATE INDEX PGV_PAGAMENTO_VENDA_FKIndex1 ON PGV_PAGAMENTO_VENDA(VEN_ID);

CREATE TABLE MEC_MERCADORIA_COMPRA (
  MEC_ID INTEGER  NOT NULL ,
  COM_ID INTEGER  NOT NULL,
  MER_ID INTEGER  NOT NULL,
  MEC_STATUS CHAR NULL,
  PRIMARY KEY(MEC_ID, COM_ID) 
);

CREATE INDEX MEC_MERCADORIA_COMPRA_FKIndex2 ON MEC_MERCADORIA_COMPRA(MER_ID, COM_ID);

CREATE TABLE MEV_MERCADORIA_VENDA (
  MEV_ID INTEGER  NOT NULL ,
  VEN_ID INTEGER  NOT NULL,
  MER_ID INTEGER  NOT NULL,
  MEV_VALOR MONEY NULL,
  MEV_STATUS CHAR NULL,
  PRIMARY KEY(MEV_ID, VEN_ID, MER_ID)  
);

create SEQUENCE s_estado
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

  
  CREATE SEQUENCE s_cidade
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

  CREATE SEQUENCE s_loja
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;