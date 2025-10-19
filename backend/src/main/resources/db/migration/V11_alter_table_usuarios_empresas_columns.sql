-- Primeiro remova a constraint atual
ALTER TABLE usuarios DROP CONSTRAINT usuarios_empresa_id_fkey;

-- Recrie com CASCADE
ALTER TABLE usuarios
ADD CONSTRAINT usuarios_empresa_id_fkey
FOREIGN KEY (empresa_id)
REFERENCES empresas(id)
ON DELETE CASCADE;