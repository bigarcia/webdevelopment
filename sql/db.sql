DROP TABLE Locacao;
DROP TABLE Locadora;
DROP TABLE Cliente;
DROP TABLE Usuario;
DROP TABLE Papel;

create table Usuario
(
    id_usuario integer not null generated always as identity (start with 1, increment by 1),
    email_usuario varchar(50) not null,
    senha_usuario varchar(100) not null,
    ativo_usuario smallint not null,
    constraint Usuario_PK PRIMARY KEY (id_usuario)
);

create table Papel (
    id_papel integer not null generated always as identity (start with 1, increment by 1),
    email_papel varchar(50) not null,
    nome_papel varchar(50) not null,
    constraint Papel_PK PRIMARY KEY (id_papel)
);

create table Cliente(
    id_cliente integer UNIQUE,
    cpf_cliente varchar(15) not null,
    nome_cliente varchar(100) not null,
    telefone_cliente varchar(20) not null, 
    sexo_cliente varchar(1) not null,
    nascimento_cliente varchar(10) not null,
    constraint Cliente_PK PRIMARY KEY (cpf_cliente),
    constraint Cliente_FK FOREIGN KEY (id_cliente) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

create table Locadora(
    id_locadora integer UNIQUE,
    cnpj_locadora varchar(14) not null,
    nome_locadora varchar(100) not null,
    cidade_locadora varchar(50) not null,
    constraint Locadora_PK PRIMARY KEY (cnpj_locadora),
    constraint Locadora_FK FOREIGN KEY (id_locadora) REFERENCES Usuario(id_usuario) ON DELETE CASCADE
);

create table Locacao(
    id_locacao integer not null generated always as identity(start with 1, increment by 1),
    dia varchar(50) not null,
    hora varchar(50) not null,
    cpf_cliente varchar(15) not null,
    cnpj_locadora varchar(14) not null,
    /*constraint Locacao1_FK FOREIGN KEY (cnpj_locadora) REFERENCES Locadora(cnpj_locadora), */
    constraint Locacao_PK PRIMARY KEY (id_locacao),
    constraint Locacao_FK1 FOREIGN KEY (cpf_cliente) REFERENCES Cliente(cpf_cliente) ON DELETE CASCADE,
    constraint Locacao_FK2 FOREIGN KEY (cnpj_locadora) REFERENCES Locadora(cnpj_locadora) ON DELETE CASCADE
);

