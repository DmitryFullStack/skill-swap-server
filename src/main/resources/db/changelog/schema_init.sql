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
create table if not exists skills (
                        id uuid  primary key,
                        user_id uuid
                            constraint fk_skills_user_id_users
                                references users
);
