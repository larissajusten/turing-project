------------------------------------------------------------------------------------------------------------------------------
------------------------- Script de Criação do Banco - CWI Turing - CRESCER 2019 ---------------------------------------------
------------------------------------------------------------------------------------------------------------------------------

/******************************* CRIAÇÃO DA TABLESPACE E DO USUARIO *******************************/
CREATE TABLESPACE CWITURING
DATAFILE '/opt/oracle/oradata/XE/XEPDB1/CWITURING.DBF'
SIZE 100M 
AUTOEXTEND ON NEXT 100M 
MAXSIZE 1024M;

CREATE USER CWITURING IDENTIFIED BY CWITURING DEFAULT TABLESPACE CWITURING;

GRANT CONNECT, RESOURCE, CREATE VIEW, CREATE SEQUENCE TO CWITURING;

ALTER USER CWITURING QUOTA UNLIMITED ON CWITURING;


/******************************* TABELAS *******************************/
--TABELA USUARIO
CREATE TABLE USUARIO(
  ID NUMBER NOT NULL PRIMARY KEY --PK
);
CREATE SEQUENCE "CRECWITURING"."SEQ_USUARIO" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

--TABELA QUESTÃO TÉCNICA
CREATE TABLE QUESTAO_TECNICA (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  DATA_CRIACAO DATE NOT NULL,
  QUESTAO VARCHAR(500) NOT NULL,
  ESPECIFICIDADE VARCHAR(12) NOT NULL,
  NIVEL VARCHAR(8) NOT NULL,
  ID_CRIADOR NUMBER NOT NULL --FK USUARIO
);
CREATE SEQUENCE "CRECWITURING"."SEQ_QUESTAO_TECNICA" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE QUESTAO_TECNICA
ADD CONSTRAINT FK_IDUSUARIO_TECNICA
FOREIGN KEY (ID_CRIADOR)
REFERENCES USUARIO (ID);

--TABELA QUESTÃO DISSERTATIVA
CREATE TABLE QUESTAO_DISSERTATIVA (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  DATA_CRIACAO DATE NOT NULL,
  QUESTAO VARCHAR(500) NOT NULL,
  ESPECIFICIDADE VARCHAR(12) NOT NULL,
  NIVEL VARCHAR(8) NOT NULL,
  ID_CRIADOR NUMBER NOT NULL --FK USUARIO
);
CREATE SEQUENCE "CRECWITURING"."SEQ_QUESTAO_DISSERTATIVA" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE QUESTAO_DISSERTATIVA
ADD CONSTRAINT FK_IDUSUARIO_DISSERTATIVA
FOREIGN KEY (ID_CRIADOR)
REFERENCES USUARIO (ID);

--TABELA QUESTÃO MULTIPLA ESCOLHA
CREATE TABLE QUESTAO_MULTIPLA_ESCOLHA (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  DATA_CRIACAO DATE NOT NULL,
  QUESTAO VARCHAR(500) NOT NULL,
  ESPECIFICIDADE VARCHAR(12) NOT NULL,
  NIVEL VARCHAR(8) NOT NULL,
  ID_CRIADOR NUMBER NOT NULL --FK USUARIO
);
CREATE SEQUENCE "CRECWITURING"."SEQ_QUESTAO_MULTIPLA_ESCOLHA" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE QUESTAO_MULTIPLA_ESCOLHA
ADD CONSTRAINT FK_IDUSUARIO_MULTIPLA_ESCOLHA
FOREIGN KEY (ID_CRIADOR)
REFERENCES USUARIO (ID);

--TABELA ALTERNATIVAS DA QUESTAO DE MULTIPLA ESCOLHA
CREATE TABLE ALTERNATIVAS_MULTIPLA_ESCOLHA (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  RESPOSTA VARCHAR(300) NOT NULL,
  CORRETA CHAR(1) NOT NULL,
  ID_QUESTAO NUMBER NOT NULL --FK QUESTAO
);
CREATE SEQUENCE "CRECWITURING"."SEQ_ALTERNATIVAS" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE ALTERNATIVAS_MULTIPLA_ESCOLHA
ADD CONSTRAINT FK_IDQUESTAO_MULTIPLA_ESCOLHA_ALTERNATIVAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_MULTIPLA_ESCOLHA (ID);

--TABELA PROVAS
CREATE TABLE PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  DATA_CRIACAO DATE NOT NULL,
  EMAIL VARCHAR2(50) NOT NULL,
  DURACAO NUMBER NOT NULL, 
  TEMPO_INICIO NUMBER NOT NULL,
  STATUS VARCHAR2(7) NOT NULL,
  ID_CRIADOR NUMBER NOT NULL --FK USUARIO
);
CREATE SEQUENCE "CRECWITURING"."SEQ_PROVAS" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE PROVAS
ADD CONSTRAINT FK_IDUSUARIO_PROVAS
FOREIGN KEY (ID_CRIADOR)
REFERENCES USUARIO (ID);


/******************************* TABELAS DE LIGAÇÃO *******************************/
--TABELA QUESTAO_TECNICA -> PROVAS
CREATE TABLE TECNICA_PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  ID_QUESTAO NUMBER NOT NULL, --FK
  ID_PROVA NUMBER NOT NULL --FK
);
CREATE SEQUENCE "CRECWITURING"."SEQ_TECNICA_PROVAS" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE TECNICA_PROVAS
ADD CONSTRAINT FK_IDPROVA_TECNICA_PROVAS
FOREIGN KEY (ID_PROVA)
REFERENCES PROVAS (ID);

ALTER TABLE TECNICA_PROVAS
ADD CONSTRAINT FK_IDQUESTAO_TECNICA_PROVAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_TECNICA (ID);

--TABELA QUESTAO_DISSERTATIVA -> PROVAS
CREATE TABLE DISSERTATIVA_PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  ID_QUESTAO NUMBER NOT NULL, --FK
  ID_PROVA NUMBER NOT NULL --FK
);
CREATE SEQUENCE "CRECWITURING"."SEQ_DISSERTATIVA_PROVAS" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE DISSERTATIVA_PROVAS
ADD CONSTRAINT FK_IDPROVA_DISSERTATIVA_PROVAS
FOREIGN KEY (ID_PROVA)
REFERENCES PROVAS (ID);

ALTER TABLE DISSERTATIVA_PROVAS
ADD CONSTRAINT FK_IDQUESTAO_DISSERTATIVA_PROVAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_DISSERTATIVA (ID);

--TABELA QUESTAO_MULTIPLA_ESCOLHA -> PROVAS
CREATE TABLE MULTIPLA_ESCOLHA_PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  ID_QUESTAO NUMBER NOT NULL, --FK
  ID_PROVA NUMBER NOT NULL --FK
);
CREATE SEQUENCE "CRECWITURING"."SEQ_MULTIPLA_ESCOLHA_PROVAS" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE MULTIPLA_ESCOLHA_PROVAS
ADD CONSTRAINT FK_IDPROVA_MULTIPLA_ESCOLHA_PROVAS
FOREIGN KEY (ID_PROVA)
REFERENCES PROVAS (ID);

ALTER TABLE MULTIPLA_ESCOLHA_PROVAS
ADD CONSTRAINT FK_IDQUESTAO_MULTIPLA_ESCOLHA_PROVAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_MULTIPLA_ESCOLHA (ID);


/******************************* TABELA DE RESPOSTAS DA PROVA *******************************/
--TABELA RESPOSTAS -> QUESTÕES DISSERTATIVAS
CREATE TABLE RESPOSTAS_DISSERTATIVAS_PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  RESPOSTA VARCHAR(500) NOT NULL,
  CORRETA CHAR(1) NOT NULL,
  ID_QUESTAO NUMBER NOT NULL, --FK
  ID_PROVA NUMBER NOT NULL, --FK
  ID_USUARIO NUMBER NOT NULL --FK
);
CREATE SEQUENCE "CRECWITURING"."SEQ_RESPOSTAS_DISSERTATIVAS" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE RESPOSTAS_DISSERTATIVAS_PROVAS
ADD CONSTRAINT FK_IDQUESTAO_RESPOSTAS_DISSERTATIVAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_DISSERTATIVA (ID);

ALTER TABLE RESPOSTAS_DISSERTATIVAS_PROVAS
ADD CONSTRAINT FK_IDPROVA_RESPOSTAS_DISSERTATIVAS
FOREIGN KEY (ID_PROVA)
REFERENCES PROVAS (ID);

ALTER TABLE RESPOSTAS_DISSERTATIVAS_PROVAS
ADD CONSTRAINT FK_IDUSUARIO_RESPOSTAS_DISSERTATIVAS
FOREIGN KEY (ID_USUARIO)
REFERENCES USUARIO (ID);

--TABELA RESPOSTAS -> QUESTÕES TECNICAS
CREATE TABLE RESPOSTAS_TECNICAS_PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  RESPOSTA VARCHAR(500) NOT NULL,
  CORRETA CHAR(1) NOT NULL,
  ID_QUESTAO NUMBER NOT NULL, --FK
  ID_PROVA NUMBER NOT NULL, --FK
  ID_USUARIO NUMBER NOT NULL --FK
);
CREATE SEQUENCE "CRECWITURING"."SEQ_RESPOSTAS_TECNICAS" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE RESPOSTAS_TECNICAS_PROVAS
ADD CONSTRAINT FK_IDQUESTAO_RESPOSTAS_TECNICAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_TECNICA (ID);

ALTER TABLE RESPOSTAS_TECNICAS_PROVAS
ADD CONSTRAINT FK_IDPROVA_RESPOSTAS_TECNICAS
FOREIGN KEY (ID_PROVA)
REFERENCES PROVAS (ID);

ALTER TABLE RESPOSTAS_TECNICAS_PROVAS
ADD CONSTRAINT FK_IDUSUARIO_RESPOSTAS_TECNICAS
FOREIGN KEY (ID_USUARIO)
REFERENCES USUARIO (ID);

--TABELA RESPOSTAS -> QUESTÕES MULTIPLAS ESCOLHAS
CREATE TABLE RESPOSTAS_MULT_ESCOLHAS_PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  ID_ALTERNATIVA NUMBER NOT NULL,
  ID_QUESTAO NUMBER NOT NULL, --FK
  ID_PROVA NUMBER NOT NULL, --FK
  ID_USUARIO NUMBER NOT NULL --FK
);
CREATE SEQUENCE "CRECWITURING"."SEQ_RESPOSTAS_MULT_ESCOLHAS" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL;

ALTER TABLE RESPOSTAS_MULT_ESCOLHAS_PROVAS
ADD CONSTRAINT FK_IDALTERNATIVA_MULT_ESCOLHAS
FOREIGN KEY (ID_ALTERNATIVA)
REFERENCES ALTERNATIVAS_MULTIPLA_ESCOLHA (ID);

ALTER TABLE RESPOSTAS_MULT_ESCOLHAS_PROVAS
ADD CONSTRAINT FK_IDQUESTAO_RESPOSTAS_MULT_ESCOLHAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_MULTIPLA_ESCOLHA (ID);

ALTER TABLE RESPOSTAS_MULT_ESCOLHAS_PROVAS
ADD CONSTRAINT FK_IDPROVA_RESPOSTAS_MULT_ESCOLHAS
FOREIGN KEY (ID_PROVA)
REFERENCES PROVAS (ID);

ALTER TABLE RESPOSTAS_MULT_ESCOLHAS_PROVAS
ADD CONSTRAINT FK_IDUSUARIO_RESPOSTAS_MULT_ESCOLHAS
FOREIGN KEY (ID_USUARIO)
REFERENCES USUARIO (ID);









