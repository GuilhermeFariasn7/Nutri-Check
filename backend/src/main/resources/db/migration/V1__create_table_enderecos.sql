create table tb_enderecos (

	id 			bigserial,
	rua 		VARCHAR(255) not null,
    numero		INT not null,
    complemento VARCHAR(255),
	bairro 		VARCHAR(255) not null,
    municipio 	VARCHAR(255) not null,
    uf 			CHAR(2) not null,
    cep 		char(9) not null,

    primary key(id)
);