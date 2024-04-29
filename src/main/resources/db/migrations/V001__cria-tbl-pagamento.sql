create table pagamento
(
    codigo         int auto_increment primary key,
    cpf            varchar(11)    null,
    cnpj           varchar(18)    null,
    numero_cartao  varchar(16)    null,
    tipo_pagamento varchar(15)    not null,
    valor          decimal(10, 2) not null,
    status         varchar(10)    not null
);
