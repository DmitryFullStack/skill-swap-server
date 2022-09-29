--liquibase formatted sql

--changeset dkirilin:schema_init.sql logicalFilePath:db/changelog/schema_init.sql

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';

create table if not exists users (
                       id uuid primary key,
                       age varchar(50) not null,
                       gender int4,
                       login varchar(255),
                        logo varchar(255),
                       name varchar(255)
);
create table if not exists skill_swap.skills
(
    id                  uuid not null
        primary key,
    level               integer,
    name                varchar(255),
    price               numeric(19, 2),
    user_account_number varchar(255),
    user_account_type   varchar(255),
    constraint fk_skills_users
        foreign key (user_account_number, user_account_type) references skill_swap.users,
    unique (name, user_account_number, user_account_type)
);
