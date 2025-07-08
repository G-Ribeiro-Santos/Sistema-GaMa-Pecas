CREATE DATABASE IF NOT EXISTS GamaPecas;
USE GamaPecas;

CREATE TABLE Usuario (
    login_usuario VARCHAR(50) NOT NULL PRIMARY KEY,
    senha_usuario VARCHAR(50) NOT NULL
);

INSERT INTO Usuario(login_usuario, senha_usuario)
VALUES 
("dummy1", "dummy1"),
("admin", "admin");

SELECT * FROM Usuario;


CREATE TABLE Produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(50) NOT NULL,
    Especificacoes_tecnicas VARCHAR(1000),
    Documentacao_status VARCHAR(10) CHECK (Documentacao_status IN ('COMPLETO', 'INCOMPLETO', 'PENDENTE'))
);

INSERT INTO Produtos(nome_produto, Especificacoes_tecnicas, Documentacao_status)
VALUES
("Parafuso 20 x 4", "BLABLABLA", "COMPLETO"),
("Parafuso aço 35 x 8", "blabla2","INCOMPLETO");

UPDATE Produtos SET nome_produto = 'parafuso 20x4 Aço AISI 312' WHERE id_produto = 1;

SELECT * FROM Produtos;

CREATE TABLE Materiais (
    id_Material INT AUTO_INCREMENT PRIMARY KEY,
    nome_material VARCHAR(50) NOT NULL,
    Nivel_estoque FLOAT NOT NULL,
    Unidade_estoque VARCHAR(7),
    Ponto_ressuprimento FLOAT NOT NULL,
    Status_Obsolescencia BOOLEAN NOT NULL
);
INSERT INTO Materiais(nome_material, Nivel_estoque, Unidade_estoque, Ponto_ressuprimento, Status_Obsolescencia)
VALUES
("aço aisi 316", 12.3, "Kg", 5, true),
("aço aisi 412", 12.3, "Kg", 2, false);
SELECT * FROM Materiais;

CREATE TABLE Maquinas (
    id_Maquina INT AUTO_INCREMENT PRIMARY KEY,
    Nome_Maquina VARCHAR(255) NOT NULL,
    Disponibilidade VARCHAR(20) CHECK (Disponibilidade IN ('MANUTENCAO', 'OPERACIONAL', 'PARADA', 'INDISPONIVEL'))
);

SELECT * FROM Maquinas;


CREATE TABLE Processos (
    id_Processo INT AUTO_INCREMENT PRIMARY KEY,
    Nome_Processo VARCHAR(50) NOT NULL,
    id_Maquina INT NOT NULL,
    FOREIGN KEY (id_Maquina) REFERENCES Maquinas(id_Maquina)
);

CREATE TABLE Ordens_Producao (	
    id_OP INT AUTO_INCREMENT PRIMARY KEY,
    id_Produto INT NOT NULL,
    Quantidade_Produzir FLOAT NOT NULL,
    Status_OP VARCHAR(20) CHECK (Status_OP IN ('PLANEJADA', 'LIBERADA', 'MOVIMENTADA', 'PAUSADA', 'CONCLUIDA', 'CANCELADA')),
    Volume_Produzido FLOAT NOT NULL,
    FOREIGN KEY (id_Produto) REFERENCES Produtos(id_produto)
);

CREATE TABLE Ordens_Servico (
    id_OS INT AUTO_INCREMENT PRIMARY KEY,
    id_OP INT NOT NULL,
    id_Processo INT NOT NULL,
    Ordem_Roteiro INT NOT NULL,
    Recurso_ID INT NOT NULL,
    Status_OS VARCHAR(20) CHECK (Status_OS IN ('PENDENTE', 'EM ANDAMENTO', 'PAUSADA', 'CONCLUIDA', 'CANCELADA')),
    Tempo_Execucao_Real TIME,
    FOREIGN KEY (id_OP) REFERENCES Ordens_Producao(id_OP),
    FOREIGN KEY (id_Processo) REFERENCES Processos(id_Processo),
    FOREIGN KEY (Recurso_ID) REFERENCES Maquinas(id_Maquina)
);

CREATE TABLE Ficha_Tecnica (
    id_Produto INT NOT NULL,
    id_Material INT NOT NULL,
    Quantidade_Material FLOAT NOT NULL,
    FOREIGN KEY (id_Produto) REFERENCES Produtos(id_produto),
    FOREIGN KEY (id_Material) REFERENCES Materiais(id_Material)
);

CREATE TABLE Uso_Material_OP (
    id_OP INT NOT NULL,
    Quantidade_Reservada FLOAT NOT NULL,
    Quantidade_Consumida FLOAT NOT NULL,
    FOREIGN KEY (id_OP) REFERENCES Ordens_Producao(id_OP)
);

CREATE TABLE logs_sistema (
	tipo_de_movimentacao varchar(50),
    data_da_movimentacao datetime
);
