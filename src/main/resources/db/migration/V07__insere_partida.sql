-- migration V7__populate_table_partida.sql

INSERT INTO tb_partida (id_partida, data, time_id_time, campeonato_id_campeonato)
VALUES (1, '2022-01-01', 1, 1), (2, '2022-02-01', 2, 1);
