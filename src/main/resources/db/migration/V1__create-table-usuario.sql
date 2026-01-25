create table usuario (
    id BIGSERIAL primary key,
    nome varchar(100) not null,
    cpf char(11) not null unique,
    email varchar(100) not null unique,
    telefone varchar(20),
    tipousuario varchar(20) not null,
    ativo BOOLEAN not null default true,
    datacriacao timestamp not null default current_timestamp
);