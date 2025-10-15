-- Tipos de usuário
CREATE TYPE tipo_usuario AS ENUM ('EMPRESA', 'ADMIN', 'FUNCIONARIO');

-- Tabela de usuários
CREATE TABLE tb_usuarios (
    id BIGSERIAL,
    login VARCHAR(255) NOT NULL UNIQUE, 			-- e-mail ou username
    senha VARCHAR(255) NOT NULL,        			-- sempre armazenar hash, nunca a senha pura!
    tipo tipo_usuario NOT NULL,         			-- define se é empresa, admin ou funcionário
    CONSTRAINT pk_tb_usuarios PRIMARY KEY (id)
);
