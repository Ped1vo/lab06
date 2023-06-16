-- migration V6__populate_table_jogador.sql

INSERT INTO tb_jogador (id_jogador, nome, nascimento, genero, altura, time_id_time)
VALUES (1, 'Jogador A', '1990-01-01', 'Masculino', 1.80, 1),
       (2, 'Jogador B', '1992-03-15', 'Feminino', 1.65, 1),
       (3, 'Jogador C', '1995-05-20', 'Masculino', 1.75, 2);
