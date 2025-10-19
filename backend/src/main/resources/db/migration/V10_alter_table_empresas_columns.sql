-- Renomear colunas existentes
ALTER TABLE empresas
RENAME COLUMN numero_alvara TO alvara;

ALTER TABLE empresas
RENAME COLUMN inscricao_estadual_municipal TO inscricao_estadual;

ALTER TABLE empresas
RENAME COLUMN cmpl_cpf TO cnpj_cpf;

ALTER TABLE empresas
RENAME COLUMN endereco_rua TO endereco;

ALTER TABLE empresas
RENAME COLUMN endereco_numero TO numero;

ALTER TABLE empresas
RENAME COLUMN endereco_complemento TO complemento;

ALTER TABLE empresas
RENAME COLUMN endereco_bairro TO bairro;

ALTER TABLE empresas
RENAME COLUMN endereco_municipio TO municipio;

ALTER TABLE empresas
RENAME COLUMN endereco_uf TO uf;

ALTER TABLE empresas
RENAME COLUMN endereco_cep TO cep;

ALTER TABLE empresas
RENAME COLUMN representante_legal_nome TO representante_legal;

ALTER TABLE empresas
RENAME COLUMN representante_legal_cpf TO cpf_representante;

-- Adicionar novas colunas
ALTER TABLE empresas
ADD COLUMN cpf_manipulador VARCHAR(14),
ADD COLUMN tipo_empresa VARCHAR(50),
ADD COLUMN nome_fantasia VARCHAR(255),
ADD COLUMN fax VARCHAR(20),
ADD COLUMN numero_funcionarios INT,
ADD COLUMN numero_turnos INT,
ADD COLUMN responsavel_manipulacao VARCHAR(255),
ADD COLUMN login VARCHAR(100),
ADD COLUMN senha VARCHAR(255),
ADD COLUMN motivo_inspecao TEXT;