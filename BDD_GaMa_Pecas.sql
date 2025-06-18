CREATE DATABASE IF NOT EXISTS GamaPecas;
USE GamaPecas;


CREATE TABLE Fornecedores (
    id_Fornecedor INT AUTO_INCREMENT PRIMARY KEY,
    CNPJ_fornecedor VARCHAR(20) UNIQUE NOT NULL,
    razao_social VARCHAR(255) NOT NULL
);


CREATE TABLE Produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(50) NOT NULL,
    Especificacoes_tecnicas VARCHAR(1000),
    Padroes_qualidade VARCHAR(1000),
    Certificados_conformidade VARCHAR(1000),
    Certificado_qualidade VARCHAR(1000),
    Documentacao_tecnicas VARCHAR(1000),
    Documentacao_status VARCHAR(10) CHECK (Documentacao_status IN ('COMPLETO', 'INCOMPLETO', 'PENDENTE'))
);


CREATE TABLE Materiais (
    id_Material INT AUTO_INCREMENT PRIMARY KEY,
    nome_material VARCHAR(50) NOT NULL,
    Especificacoes_tecnicas VARCHAR(1000),
    Padroes_qualidade VARCHAR(1000),
    Valiadade_material DATE NOT NULL,
    Ponto_ressuprimento FLOAT NOT NULL,
    Nivel_estoque FLOAT NOT NULL,
    Unidade_estoque VARCHAR(7),
    Status_Obsolescencia BOOLEAN NOT NULL
);


CREATE TABLE Pedidos (
    id_Pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_Fornecedor INT NOT NULL,
    Previsao_Recebimento DATE,
    Status_Pedido VARCHAR(20) CHECK (Status_Pedido IN ('ABERTO', 'ENVIADO', 'RECEBIDO PARCIAL', 'RECEBIDO', 'CANCELADO')),
    FOREIGN KEY (id_Fornecedor) REFERENCES Fornecedores(id_Fornecedor)
);


CREATE TABLE Lotes (
    id_Lote INT AUTO_INCREMENT PRIMARY KEY,
    id_Material INT NOT NULL,
    id_Pedido INT NOT NULL,
    Certificados_Qualidade VARCHAR(1000),
    Quantidade FLOAT NOT NULL,
    Unidade_Quantidade VARCHAR(7),
    Volumes INT NOT NULL,
    Desvios_Especificacao VARCHAR(1000),
    Nao_Conformidades VARCHAR(1000),
    Status_Aprovacao VARCHAR(20) CHECK (Status_Aprovacao IN ('LIBERADO', 'REJEITADO', 'PENDENTE')),
    Status_Quarentena VARCHAR(20) CHECK (Status_Quarentena IN ('LIBERADO', 'REJEITADO', 'PENDENTE')),
    Acao_Necessaria VARCHAR(255),
    Ultima_Verificacao DATETIME,
    FOREIGN KEY (id_Material) REFERENCES Materiais(id_Material),
    FOREIGN KEY (id_Pedido) REFERENCES Pedidos(id_Pedido)
);


CREATE TABLE Maquinas (
    id_Maquina INT AUTO_INCREMENT PRIMARY KEY,
    Nome_Maquina VARCHAR(255) NOT NULL,
    Documentacao_Tecnica VARCHAR(1000),
    Disponibilidade VARCHAR(20) CHECK (Disponibilidade IN ('MANUTENCAO', 'OPERACIONAL', 'PARADA', 'INDISPONIVEL'))
);


CREATE TABLE Ferramentas (
    id_Ferramenta INT AUTO_INCREMENT PRIMARY KEY,
    nome_ferramenta VARCHAR(50) NOT NULL,
    Descricao_Ferramenta VARCHAR(1000),
    Estoque_Reposicao INT NOT NULL,
    Vida_Util FLOAT
);


CREATE TABLE Processos (
    id_Processo INT AUTO_INCREMENT PRIMARY KEY,
    Nome_Processo VARCHAR(50) NOT NULL,
    id_Maquina INT NOT NULL,
    Ferramentas_Necessarias VARCHAR(1000),
    FOREIGN KEY (id_Maquina) REFERENCES Maquinas(id_Maquina)
);


CREATE TABLE Ordens_Producao (
    id_OP INT AUTO_INCREMENT PRIMARY KEY,
    id_Produto INT NOT NULL,
    Quantidade_Produzir FLOAT NOT NULL,
    Status_OP VARCHAR(20) CHECK (Status_OP IN ('PLANEJADA', 'LIBERADA', 'MOVIMENTADA', 'PAUSADA', 'CONCLUIDA', 'CANCELADA')),
    Tempo_Conclusao_Estimado DATETIME,
    Tempo_Restante_Estimado TIME,
    Volume_Produzido FLOAT NOT NULL,
    Necessidades_Retrabalho VARCHAR(255),
    FOREIGN KEY (id_Produto) REFERENCES Produtos(id_produto)
);


CREATE TABLE Ordens_Servico (
    id_OS INT AUTO_INCREMENT PRIMARY KEY,
    id_OP INT NOT NULL,
    id_Processo INT NOT NULL,
    Ordem_Roteiro INT NOT NULL,
    Recurso_ID INT NOT NULL,
    Setor_Responsavel VARCHAR(50),
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
    id_Lote INT NOT NULL,
    Quantidade_Reservada FLOAT NOT NULL,
    Quantidade_Consumida FLOAT NOT NULL,
    FOREIGN KEY (id_OP) REFERENCES Ordens_Producao(id_OP),
    FOREIGN KEY (id_Lote) REFERENCES Lotes(id_Lote)
);
