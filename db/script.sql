------------------------------------------------------------------------------------------------------------------------------
------------------------------ Script de Criação do Banco - CWI Turing - CRESCER 2019 ----------------------------------------
------------------------------------------------------------------------------------------------------------------------------

/******************************* TABELAS *******************************/
--TABELA USUARIO
CREATE TABLE USUARIO(
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  EMAIL VARCHAR(50) NOT NULL,
  PERFIL VARCHAR(13) NOT NULL
);

CREATE SEQUENCE SEQ_USUARIO
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

--TABELA QUESTÃO TÉCNICA
CREATE TABLE QUESTAO_TECNICA (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  DATA_CRIACAO DATE NOT NULL,
  QUESTAO VARCHAR(500) NOT NULL,
  ESPECIFICIDADE VARCHAR(12) NOT NULL,
  NIVEL VARCHAR(8) NOT NULL,
  VEZES_USADA INT DEFAULT 0,
  RESPOSTA_BASE VARCHAR2(500) NOT NULL,
  TESTE_BASE VARCHAR2(500) NOT NULL
);

CREATE SEQUENCE SEQ_QUESTAO_TECNICA
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

--TABELA QUESTÃO DISSERTATIVA
CREATE TABLE QUESTAO_DISSERTATIVA (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  DATA_CRIACAO DATE NOT NULL,
  QUESTAO VARCHAR(500) NOT NULL,
  ESPECIFICIDADE VARCHAR(12) NOT NULL,
  NIVEL VARCHAR(8) NOT NULL,
  VEZES_USADA INT DEFAULT 0
);

CREATE SEQUENCE SEQ_QUESTAO_DISSERTATIVA
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

--TABELA QUESTÃO MULTIPLA ESCOLHA
CREATE TABLE QUESTAO_MULTIPLA_ESCOLHA (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  DATA_CRIACAO DATE NOT NULL,
  QUESTAO VARCHAR2(500) NOT NULL,
  ESPECIFICIDADE VARCHAR(12) NOT NULL,
  NIVEL VARCHAR2(8) NOT NULL,
  VEZES_USADA INT DEFAULT 0
);

CREATE SEQUENCE SEQ_QUESTAO_MULTIPLA_ESCOLHA
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

--TABELA ALTERNATIVAS DA QUESTAO DE MULTIPLA ESCOLHA
CREATE TABLE ALTERNATIVAS_MULTIPLA_ESCOLHA (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  RESPOSTA VARCHAR(300) NOT NULL,
  CORRETA CHAR(1) NOT NULL,
  ID_QUESTAO NUMBER NOT NULL --FK QUESTAO
);

CREATE SEQUENCE SEQ_ALTERNATIVAS
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

ALTER TABLE ALTERNATIVAS_MULTIPLA_ESCOLHA
ADD CONSTRAINT FK_IDQUESTAO_MULTIPLA_ESCOLHA_ALTERNATIVAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_MULTIPLA_ESCOLHA (ID);

--TABELA PROVAS
CREATE TABLE PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  DATA_CRIACAO DATE NOT NULL,
  NOME_CANDIDATO VARCHAR2(100),
  EMAIL_CANDIDATO VARCHAR2(50) NOT NULL,
  DURACAO NUMBER NOT NULL, 
  TEMPO_INICIO NUMBER NOT NULL,
  DATA_INICIO DATE,
  LINGUAGEM VARCHAR(12) NOT NULL,
  TIPO VARCHAR(20),
  STATUS VARCHAR2(30) NOT NULL,
  NOTA NUMBER(10, 2) DEFAULT 0
);

CREATE SEQUENCE SEQ_PROVAS
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

/******************************* TABELAS DE LIGAÇÃO *******************************/
--TABELA QUESTAO_TECNICA -> PROVAS
CREATE TABLE TECNICA_PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  ID_QUESTAO NUMBER NOT NULL, --FK
  ID_PROVA NUMBER NOT NULL --FK
);

CREATE SEQUENCE SEQ_TECNICA_PROVAS
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

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

CREATE SEQUENCE SEQ_DISSERTATIVA_PROVAS
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

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

CREATE SEQUENCE SEQ_MULTIPLA_ESCOLHA_PROVAS
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

ALTER TABLE MULTIPLA_ESCOLHA_PROVAS
ADD CONSTRAINT FK_IDPROVA_MULTIPLA_ESCOLHA_PROVAS
FOREIGN KEY (ID_PROVA)
REFERENCES PROVAS (ID);

ALTER TABLE MULTIPLA_ESCOLHA_PROVAS
ADD CONSTRAINT FK_IDQUESTAO_MULTIPLA_ESCOLHA_PROVAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_MULTIPLA_ESCOLHA (ID);

/******************************* TABELAS DE RESPOSTAS DA PROVA *******************************/
--TABELA RESPOSTAS -> QUESTÕES DISSERTATIVAS
CREATE TABLE RESPOSTAS_DISSERTATIVAS_PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  RESPOSTA VARCHAR(500) NOT NULL,
  COMENTARIO VARCHAR2(500),
  NOTA NUMBER(10) NOT NULL,
  ID_QUESTAO NUMBER NOT NULL, --FK
  ID_PROVA NUMBER NOT NULL --FK
);

CREATE SEQUENCE SEQ_RESPOSTAS_DISSERTATIVAS
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

ALTER TABLE RESPOSTAS_DISSERTATIVAS_PROVAS
ADD CONSTRAINT FK_IDQUESTAO_RESPOSTAS_DISSERTATIVAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_DISSERTATIVA (ID);

ALTER TABLE RESPOSTAS_DISSERTATIVAS_PROVAS
ADD CONSTRAINT FK_IDPROVA_RESPOSTAS_DISSERTATIVAS
FOREIGN KEY (ID_PROVA)
REFERENCES PROVAS (ID);

--TABELA RESPOSTAS -> QUESTÕES TECNICAS
CREATE TABLE RESPOSTAS_TECNICAS_PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  RESPOSTA VARCHAR(500) NOT NULL,
  COMENTARIO VARCHAR2(500),
  NOTA NUMBER NUMBER(10, 2),
  ID_QUESTAO NUMBER NOT NULL, --FK
  ID_PROVA NUMBER NOT NULL --FK
);

CREATE SEQUENCE SEQ_RESPOSTAS_TECNICAS
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

ALTER TABLE RESPOSTAS_TECNICAS_PROVAS
ADD CONSTRAINT FK_IDQUESTAO_RESPOSTAS_TECNICAS
FOREIGN KEY (ID_QUESTAO)
REFERENCES QUESTAO_TECNICA (ID);

ALTER TABLE RESPOSTAS_TECNICAS_PROVAS
ADD CONSTRAINT FK_IDPROVA_RESPOSTAS_TECNICAS
FOREIGN KEY (ID_PROVA)
REFERENCES PROVAS (ID);

--TABELA RESPOSTAS -> QUESTÕES MULTIPLAS ESCOLHAS
CREATE TABLE RESPOSTAS_MULT_ESCOLHAS_PROVAS (
  ID NUMBER NOT NULL PRIMARY KEY, --PK
  ID_ALTERNATIVA NUMBER NOT NULL, --FK
  ID_QUESTAO NUMBER NOT NULL, --FK
  ID_PROVA NUMBER NOT NULL --FK
);

CREATE SEQUENCE SEQ_RESPOSTAS_MULT_ESCOLHAS
  INCREMENT BY 1
  START WITH 1
  NOMAXVALUE
  NOCYCLE
CACHE 10000;

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
