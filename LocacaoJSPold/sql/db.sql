create table Locacao(
    id_locacao integer not null generated always as identity(start with 1, increment by 1),
    data_dia varchar(50) not null,
    cpf_cliente integer not null,
    cnpj_locadora integer not null,
    /*constraint Locacao1_FK FOREIGN KEY (cnpj_locadora) REFERENCES Locadora(cnpj_locadora), */
    PRIMARY KEY (id_locacao),
    FOREIGN KEY (cnpj_locadora) REFERENCES Locadora(cnpj_locadora),
    FOREIGN KEY (cpf_cliente) REFERENCES Cliente(cpf_cliente)
);

create table Cliente(
    email_cliente varchar(50) not null,
    senha_cliente varchar(100) not null,
    cpf_cliente varchar(15) not null,
    nome_cliente varchar(50) not null,
    telefone_cliente varchar(20) not null, 
    sexo_cliente varchar(1) not null,
    nascimento_cliente date not null,
    PRIMARY KEY (cpf_cliente)
);

create table Locadora(
    cnpj_locadora varchar(14) not null,
    email_locadora varchar(50) not null,
    senha_locadora varchar(100) not null,
    nome_locadora varchar(50) not null,
    cidade_locadora varchar(50) not null,
    PRIMARY KEY (cnpj_locadora)
);


