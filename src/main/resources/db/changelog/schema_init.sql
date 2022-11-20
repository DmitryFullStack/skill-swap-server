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
                       logoId uuid,
                       name varchar(255)
);

create table if not exists skill_swap.skills
(
    id                  uuid not null
        primary key,
    level               integer,
    name                varchar(255),
    price               numeric(19, 2),
    experience          int2,
    user_account_number varchar(255),
    user_account_type   varchar(255),
    archive             boolean not null default false,
    constraint fk_skills_users
        foreign key (user_account_number, user_account_type) references skill_swap.users,
    unique (name, user_account_number, user_account_type)
);

create table if not exists skill_swap.requirements
(
    id                  uuid not null
        primary key,
    level               integer,
    name                varchar(255) not null ,
    min_experience      int2,
    description         varchar(512),
    gender              varchar(255),
    user_account_number varchar(255),
    user_account_type   varchar(255),
    archive             boolean not null default false,
    constraint fk_skills_users
        foreign key (user_account_number, user_account_type) references skill_swap.users,
    unique (name, user_account_number, user_account_type)
);

create table if not exists files (
            id uuid primary key,
            type varchar(50),
            data bytea
);
