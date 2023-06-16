ALTER TABLE tb_campeonato
    ADD FOREIGN KEY (id_time) REFERENCES tb_time(id_time);

ALTER TABLE tb_jogador
    ADD FOREIGN KEY (id_campeonato) REFERENCES tb_campeonato(id_campeonato);