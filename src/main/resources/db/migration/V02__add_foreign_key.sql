-- Adição de chaves estrangeiras na tabela tb_campeonato
ALTER TABLE tb_partida
    ADD CONSTRAINT fk_campeonato_partida
        FOREIGN KEY (campeonato_id) REFERENCES tb_campeonato (id);

ALTER TABLE tb_time
    ADD CONSTRAINT fk_campeonato_time
        FOREIGN KEY (campeonato_id) REFERENCES tb_campeonato (id);

-- Adição de chaves estrangeiras na tabela tb_partida
ALTER TABLE tb_partida
    ADD CONSTRAINT fk_time_mandante
        FOREIGN KEY (time_mandante_id) REFERENCES tb_time (id);

ALTER TABLE tb_partida
    ADD CONSTRAINT fk_time_visitante
        FOREIGN KEY (time_visitante_id) REFERENCES tb_time (id);

ALTER TABLE tb_partida
    ADD CONSTRAINT fk_estadio
        FOREIGN KEY (estadio_id) REFERENCES tb_estadio (id);

-- Adição de chaves estrangeiras na tabela tb_resultados
ALTER TABLE tb_resultados
    ADD CONSTRAINT fk_partida_resultados
        FOREIGN KEY (partida_id) REFERENCES tb_partida (id);

-- Adição de chave estrangeira na tabela tb_jogador
ALTER TABLE tb_jogador
    ADD CONSTRAINT fk_time_jogador
        FOREIGN KEY (time_id) REFERENCES tb_time (id);

-- Adição de chaves estrangeiras na tabela tb_time
ALTER TABLE tb_time
    ADD CONSTRAINT fk_time_partida
        FOREIGN KEY (id) REFERENCES tb_partida (time_mandante_id, time_visitante_id);
