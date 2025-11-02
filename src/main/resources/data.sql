-- Inserir dados iniciais para testes

-- Pessoas (Diretores e Atores)
INSERT INTO pessoas (id, tipo_pessoa, nome) VALUES (1, 'DIRETOR', 'Christopher Nolan');
INSERT INTO pessoas (id, tipo_pessoa, nome) VALUES (2, 'DIRETOR', 'Steven Spielberg');
INSERT INTO pessoas (id, tipo_pessoa, nome) VALUES (3, 'ATOR', 'Leonardo DiCaprio');
INSERT INTO pessoas (id, tipo_pessoa, nome) VALUES (4, 'ATOR', 'Tom Hanks');
INSERT INTO pessoas (id, tipo_pessoa, nome) VALUES (5, 'ATOR', 'Morgan Freeman');

-- Filmes
INSERT INTO filmes (id, titulo, data_lancamento, orcamento, descricao, diretor_id)
VALUES (1, 'A Origem', '2010-07-16', 160000000.00, 'Um ladrão que rouba segredos corporativos através do uso da tecnologia de compartilhamento de sonhos', 1);

INSERT INTO filmes (id, titulo, data_lancamento, orcamento, descricao, diretor_id)
VALUES (2, 'Interestelar', '2014-11-07', 165000000.00, 'Uma equipe de exploradores viaja através de um buraco de minhoca no espaço', 1);

INSERT INTO filmes (id, titulo, data_lancamento, orcamento, descricao, diretor_id)
VALUES (3, 'O Resgate do Soldado Ryan', '1998-07-24', 70000000.00, 'Após o desembarque na Normandia, um grupo de soldados vai atrás de um paraquedista', 2);

-- Associações Filme-Ator
INSERT INTO filme_ator (filme_id, ator_id) VALUES (1, 3);
INSERT INTO filme_ator (filme_id, ator_id) VALUES (2, 3);
INSERT INTO filme_ator (filme_id, ator_id) VALUES (3, 4);
