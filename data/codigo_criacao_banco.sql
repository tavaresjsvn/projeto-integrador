CREATE DATABASE hairmatch;

USE hairmatch;

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(20) NULL,
    idade INT NULL,
    endereco TEXT NULL,
    senha VARCHAR(255) NOT NULL,
    id_plano INT NOT NULL,
    FOREIGN KEY (id_plano) REFERENCES plano(id_plano) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE perfil_capilar (
    id_perfil_capilar INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL UNIQUE,
    tipo_de_cabelo VARCHAR(100) NULL,
    descricao_da_curvatura VARCHAR(255) NULL,
    curvatura VARCHAR(50) NULL,
    estado_do_cabelo VARCHAR(255) NULL,
    objetivo VARCHAR(255) NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE salao (
    id_salao INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    eelefone VARCHAR(20) NULL,
    especialidades TEXT NULL,
    nota DECIMAL(3, 2) DEFAULT 0.00
);

CREATE TABLE profissional (
    id_profissional INT AUTO_INCREMENT PRIMARY KEY,
    id_salao INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    especialidade VARCHAR(255) NULL,
    telefone VARCHAR(20) NULL,
    FOREIGN KEY (id_salao) REFERENCES salao(id_salao) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE servico (
    id_servico INT AUTO_INCREMENT PRIMARY KEY,
    id_salao INT NOT NULL,
    id_profissional INT NULL,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    tipo_servico VARCHAR(100) NULL,
    FOREIGN KEY (id_salao) REFERENCES salao(id_salao) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_profissional) REFERENCES profissional(id_profissional) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE agendamento (
    id_agendamento INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_salao INT NOT NULL,
    id_profissional INT NULL,
    id_servico INT NOT NULL,
    data_agendamento DATE NOT NULL,
    hora_agendamento TIME NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'Agendado',
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_salao) REFERENCES salao(id_salao) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_profissional) REFERENCES profissional(id_profissional) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (id_servico) REFERENCES servico(id_servico) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE avaliacao (
    id_avaliacao INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_salao INT NOT NULL,
    nota INT NOT NULL CHECK (nota >= 1 AND nota <= 5),
    comentario TEXT NULL,
    data_avaliacao DATE NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_salao) REFERENCES salao(id_salao) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cronograma_capilar (
    id_cronograma INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_perfil_capilar INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_perfil_capilar) REFERENCES perfil_capilar(id_perfil_capilar) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE etapa_cronograma (
    id_etapa_cronograma INT AUTO_INCREMENT PRIMARY KEY,
    id_cronograma INT NOT NULL,
    tipo_etapa VARCHAR(50) NOT NULL,
    data_etapa DATE NOT NULL,
    meu_cuidado TEXT NULL,
    FOREIGN KEY (id_cronograma) REFERENCES cronograma_capilar(id_cronograma) ON DELETE CASCADE ON UPDATE CASCADE
);
    
CREATE TABLE plano (
    id_plano INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    duracao INT NULL,
    beneficios TEXT NULL,
    valor DECIMAL(10, 2) NOT NULL
);
