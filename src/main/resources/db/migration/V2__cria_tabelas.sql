CREATE TABLE IF NOT EXISTS tb_campeonato
(
    id_campeonato SERIAL PRIMARY KEY,
    ano           INTEGER      NOT NULL,
    nome          VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_estadio
(
    id_estadio   SERIAL PRIMARY KEY,
    nome         VARCHAR(50)  NOT NULL,
    endereco     VARCHAR(255) NOT NULL,
    time_id_time BIGINT,
    FOREIGN KEY (time_id_time) REFERENCES tb_time (id_time)
);

CREATE TABLE IF NOT EXISTS tb_jogador
(
    id_jogador   SERIAL PRIMARY KEY,
    nome         VARCHAR(50)      NOT NULL,
    nascimento   DATE             NOT NULL,
    genero       VARCHAR(255)     NOT NULL,
    altura       DOUBLE PRECISION NOT NULL,
    time_id_time BIGINT,
    FOREIGN KEY (time_id_time) REFERENCES tb_time (id_time)
);

CREATE TABLE IF NOT EXISTS tb_partida
(
    id_partida               SERIAL PRIMARY KEY,
    data                     DATE NOT NULL,
    time_id_time             BIGINT,
    campeonato_id_campeonato BIGINT,
    FOREIGN KEY (time_id_time) REFERENCES tb_time (id_time),
    FOREIGN KEY (campeonato_id_campeonato) REFERENCES tb_campeonato (id_campeonato)
);

CREATE TABLE IF NOT EXISTS tb_time
(
    id_time            SERIAL PRIMARY KEY,
    nome               VARCHAR(255) NOT NULL,
    estadio_id_estadio BIGINT,
    FOREIGN KEY (estadio_id_estadio) REFERENCES tb_estadio (id_estadio)
);