DROP TABLE IF EXISTS tb_campeonato;
CREATE TABLE IF NOT EXISTS tb_campeonato
(
    id_campeonato BIGINT PRIMARY KEY,
    ano           INTEGER      NOT NULL,
    nome          VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS tb_estadio;
CREATE TABLE IF NOT EXISTS tb_estadio
(
    id_estadio   BIGINT PRIMARY KEY,
    nome         VARCHAR(50)  NOT NULL,
    endereco     VARCHAR(255) NOT NULL,
    time_id_time BIGINT UNIQUE,
    FOREIGN KEY (time_id_time) REFERENCES tb_time (id_time)
);

DROP TABLE IF EXISTS tb_jogador;
CREATE TABLE IF NOT EXISTS tb_jogador
(
    id_jogador   BIGINT PRIMARY KEY,
    nome         VARCHAR(50)      NOT NULL,
    nascimento   DATE             NOT NULL,
    genero       VARCHAR(255)     NOT NULL,
    altura       FLOAT NOT NULL,
    time_id_time BIGINT,
    FOREIGN KEY (time_id_time) REFERENCES tb_time (id_time)
);

DROP TABLE IF EXISTS tb_partida;
CREATE TABLE IF NOT EXISTS tb_partida
(
    id_partida               BIGINT PRIMARY KEY,
    data                     DATE NOT NULL,
    time_id_time             BIGINT,
    campeonato_id_campeonato BIGINT,
    FOREIGN KEY (time_id_time) REFERENCES tb_time (id_time),
    FOREIGN KEY (campeonato_id_campeonato) REFERENCES tb_campeonato (id_campeonato)
);

DROP TABLE IF EXISTS tb_time;
CREATE TABLE IF NOT EXISTS tb_time
(
    id_time            BIGINT PRIMARY KEY,
    nome               VARCHAR(255) NOT NULL,
    estadio_id_estadio BIGINT UNIQUE,
    FOREIGN KEY (estadio_id_estadio) REFERENCES tb_estadio (id_estadio)
);
