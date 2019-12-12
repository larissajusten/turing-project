------------------------------------------------------------------------------------------------------------------------------
------------------ Script de Delete do Banco - CWI Turing - CRESCER 2019 ----------------------------------------
------------------------------------------------------------------------------------------------------------------------------
--
/******************************* TABELAS *******************************/
DROP TABLE USUARIO;
DROP TABLE QUESTAO_TECNICA;
DROP TABLE QUESTAO_DISSERTATIVA;
DROP TABLE QUESTAO_MULTIPLA_ESCOLHA;
DROP TABLE ALTERNATIVAS_MULTIPLA_ESCOLHA;
DROP TABLE PROVAS;
/******************************* TABELAS DE LIGAÇÃO *******************************/
DROP TABLE TECNICA_PROVAS;
DROP TABLE DISSERTATIVA_PROVAS;
DROP TABLE MULTIPLA_ESCOLHA_PROVAS;
/******************************* TABELAS DE RESPOSTAS DA PROVA *******************************/
DROP TABLE RESPOSTAS_DISSERTATIVAS_PROVAS;
DROP TABLE RESPOSTAS_TECNICAS_PROVAS;
DROP TABLE RESPOSTAS_MULT_ESCOLHAS_PROVAS;

--
/******************************* SEQUENCES *******************************/
DROP SEQUENCE SEQ_USUARIO;
DROP SEQUENCE SEQ_QUESTAO_TECNICA;
DROP SEQUENCE SEQ_QUESTAO_DISSERTATIVA;
DROP SEQUENCE SEQ_QUESTAO_MULTIPLA_ESCOLHA;
DROP SEQUENCE SEQ_ALTERNATIVAS;
DROP SEQUENCE SEQ_PROVAS;
/******************************* SEQUENCE DAS TABELAS DE LIGAÇÃO *******************************/
DROP SEQUENCE SEQ_TECNICA_PROVAS;
DROP SEQUENCE SEQ_DISSERTATIVA_PROVAS;
DROP SEQUENCE SEQ_MULTIPLA_ESCOLHA_PROVAS;
/******************************* SEQUENCES DAS TABELAS DE RESPOSTAS DA PROVA *******************************/
DROP SEQUENCE SEQ_RESPOSTAS_DISSERTATIVAS;
DROP SEQUENCE SEQ_RESPOSTAS_TECNICAS;
DROP SEQUENCE SEQ_RESPOSTAS_MULT_ESCOLHAS;
