# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table coneixement (
  id                        integer not null,
  nom                       varchar(255) not null,
  constraint pk_coneixement primary key (id))
;

create table oferta (
  type                      varchar(31) not null,
  id                        integer not null,
  titol                     varchar(255) not null,
  informacio_oferta         varchar(255) not null,
  constraint pk_oferta primary key (id))
;

create table usuari (
  type                      varchar(31) not null,
  id                        integer not null,
  username                  varchar(255) not null,
  password                  varchar(255) not null,
  email                     varchar(255),
  es_administrador          boolean not null,
  es_blocat                 boolean not null,
  es_deganal                boolean not null,
  expiracio_blocatge        timestamp,
  motiu_blocatge            varchar(255),
  cif                       varchar(255) not null,
  nom                       varchar(255) not null,
  logo                      varchar(255),
  constraint uq_usuari_cif unique (cif),
  constraint pk_usuari primary key (id))
;

create sequence coneixement_seq;

create sequence oferta_seq;

create sequence usuari_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists coneixement;

drop table if exists oferta;

drop table if exists usuari;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists coneixement_seq;

drop sequence if exists oferta_seq;

drop sequence if exists usuari_seq;

