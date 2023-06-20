-- V1__insert_data.sql

-- Inserts para tb_campeonato
INSERT INTO tb_campeonato (id, ano, nome)
VALUES (1, 2023, 'Campeonato A');
INSERT INTO tb_campeonato (id, ano, nome)
VALUES (2, 2023, 'Campeonato B');
INSERT INTO tb_campeonato (id, ano, nome)
VALUES (3, 2023, 'Campeonato C');
INSERT INTO tb_campeonato (id, ano, nome)
VALUES (4, 2023, 'Campeonato D');
INSERT INTO tb_campeonato (id, ano, nome)
VALUES (5, 2023, 'Campeonato E');
-- Adicione mais inserts conforme necessário

-- Inserts para tb_estadio
INSERT INTO tb_estadio (id, endereco, nome)
VALUES (1, 'Endereço A', 'Estádio A');
INSERT INTO tb_estadio (id, endereco, nome)
VALUES (2, 'Endereço B', 'Estádio B');
INSERT INTO tb_estadio (id, endereco, nome)
VALUES (3, 'Endereço C', 'Estádio C');
INSERT INTO tb_estadio (id, endereco, nome)
VALUES (4, 'Endereço D', 'Estádio D');
INSERT INTO tb_estadio (id, endereco, nome)
VALUES (5, 'Endereço E', 'Estádio E');
-- Adicione mais inserts conforme necessário

-- Inserts para tb_time
INSERT INTO tb_time (id, nome, vitorias, saldo_gols, campeonato_id)
VALUES (1, 'Time A', 3, 5, 1);
INSERT INTO tb_time (id, nome, vitorias, saldo_gols, campeonato_id)
VALUES (2, 'Time B', 2, 3, 1);
INSERT INTO tb_time (id, nome, vitorias, saldo_gols, campeonato_id)
VALUES (3, 'Time C', 4, 2, 2);
INSERT INTO tb_time (id, nome, vitorias, saldo_gols, campeonato_id)
VALUES (4, 'Time D', 1, 0, 2);
INSERT INTO tb_time (id, nome, vitorias, saldo_gols, campeonato_id)
VALUES (5, 'Time E', 2, 1, 3);
-- Adicione mais inserts conforme necessário

-- Inserts para tb_jogador
INSERT INTO tb_jogador (id, nome, data_nascimento, genero, altura, time_id)
VALUES (1, 'Jogador A', '1990-01-01', 'Masculino', 1.80, 1);
INSERT INTO tb_jogador (id, nome, data_nascimento, genero, altura, time_id)
VALUES (2, 'Jogador B', '1992-03-15', 'Feminino', 1.70, 2);
INSERT INTO tb_jogador (id, nome, data_nascimento, genero, altura, time_id)
VALUES (3, 'Jogador C', '1994-07-21', 'Masculino', 1.85, 3);
INSERT INTO tb_jogador (id, nome, data_nascimento, genero, altura, time_id)
VALUES (4, 'Jogador D', '1996-11-10', 'Feminino', 1.75, 4);
INSERT INTO tb_jogador (id, nome, data_nascimento, genero, altura, time_id)
VALUES (5, 'Jogador E', '1998-05-08', 'Masculino', 1.90, 5);
-- Adicione mais inserts conforme necessário

-- Inserts para tb_partida
INSERT INTO tb_partida (id, data, time_mandante_id, time_visitante_id, campeonato_id, estadio_id)
VALUES (1, '2023-06-01', 1, 2, 1, 1);
INSERT INTO tb_partida (id, data, time_mandante_id, time_visitante_id, campeonato_id, estadio_id)
VALUES (2, '2023-06-02', 2, 1, 1, 2);
INSERT INTO tb_partida (id, data, time_mandante_id, time_visitante_id, campeonato_id, estadio_id)
VALUES (3, '2023-06-03', 3, 4, 2, 3);
INSERT INTO tb_partida (id, data, time_mandante_id, time_visitante_id, campeonato_id, estadio_id)
VALUES (4, '2023-06-04', 4, 3, 2, 4);
INSERT INTO tb_partida (id, data, time_mandante_id, time_visitante_id, campeonato_id, estadio_id)
VALUES (5, '2023-06-05', 5, 2, 3, 5);
-- Adicione mais inserts conforme necessário

-- Inserts para tb_resultados
INSERT INTO resultados (id, gols_time_mandante, gols_time_visitante, partida_id)
VALUES (1, 2, 1, 1);
INSERT INTO resultados (id, gols_time_mandante, gols_time_visitante, partida_id)
VALUES (2, 1, 1, 2);
INSERT INTO resultados (id, gols_time_mandante, gols_time_visitante, partida_id)
VALUES (3, 3, 2, 3);
INSERT INTO resultados (id, gols_time_mandante, gols_time_visitante, partida_id)
VALUES (4, 0, 1, 4);
INSERT INTO resultados (id, gols_time_mandante, gols_time_visitante, partida_id)
VALUES (5, 2, 0, 5);
-- Adicione mais inserts conforme necessário
