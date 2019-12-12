------------------------------------------------------------------------------------------------------------------------------
------------------ Script de Criação da TableSpace do Banco - CWI Turing - CRESCER 2019 --------------------------------------
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
