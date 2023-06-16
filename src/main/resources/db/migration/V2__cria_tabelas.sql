-- Criação da tabela tb_campeonato
CREATE TABLE tb_campeonato
(
    id   SERIAL PRIMARY KEY,
    ano  INT          NOT NULL,
    nome VARCHAR(255) NOT NULL
);

-- Criação da tabela tb_estadio
CREATE TABLE tb_estadio
(
    id       SERIAL PRIMARY KEY,
    nome     VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL
);

-- Criação da tabela tb_jogador
CREATE TABLE tb_jogador
(
    id              SERIAL PRIMARY KEY,
    nome            VARCHAR(255)     NOT NULL,
    data_nascimento VARCHAR(10)      NOT NULL,
    genero          VARCHAR(255)     NOT NULL,
    altura          DOUBLE PRECISION NOT NULL,
    time_id         BIGINT REFERENCES tb_time (id)
);

-- Criação da tabela tb_partida
CREATE TABLE tb_partida
(
    id                SERIAL PRIMARY KEY,
    data              DATE NOT NULL,
    time_mandante_id  BIGINT REFERENCES tb_time (id),
    time_visitante_id BIGINT REFERENCES tb_time (id),
    campeonato_id     BIGINT REFERENCES tb_campeonato (id),
    estadio_id        BIGINT REFERENCES tb_estadio (id)
);

-- Criação da tabela tb_resultados
CREATE TABLE tb_resultados
(
    id                  SERIAL PRIMARY KEY,
    gols_time_mandante  INT NOT NULL,
    gols_time_visitante INT NOT NULL,
    partida_id          BIGINT REFERENCES tb_partida (id)
);

-- Criação da tabela tb_time
CREATE TABLE tb_time
(
    id            SERIAL PRIMARY KEY,
    nome          VARCHAR(255) NOT NULL,
    vitorias      INT          NOT NULL,
    saldo_gols    INT          NOT NULL,
    campeonato_id BIGINT REFERENCES tb_campeonato (id)
);
