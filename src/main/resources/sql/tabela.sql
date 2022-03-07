-- auto-generated definition
create table tabela_testowa
(
    id       bigint not null
        constraint i1_constr
            primary key,
    kolumna1 varchar(256),
    kolumna2 varchar(256),
    kolumna3 varchar(256),
    kolumna4 bigint
);

alter table tabela_testowa
    owner to gmovxgzf;
