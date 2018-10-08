DROP DATABASE IF EXISTS filme;
CREATE DATABASE filme;
USE filme;

CREATE TABLE filmes (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    nome            VARCHAR(255) NOT NULL,
    diretor         VARCHAR(100) NOT NULL,
    categoria       VARCHAR(255) NOT NULL,
    ano             SMALLINT NOT NULL,
    ator_principal  VARCHAR(100) NOT NULL,
    tempo_filme     SMALLINT NOT NULL,
    orcamento       DOUBLE NOT NULL,
    faturamento     DOUBLE NOT NULL,
    faixa_etaria    SMALLINT NOT NULL,
    legenda         BOOLEAN NOT NULL,
    dublado         BOOLEAN NOT NULL,
    idioma_original VARCHAR(50) NOT NULL
);
