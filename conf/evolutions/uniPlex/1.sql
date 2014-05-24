# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table coneixement (
  id                        integer auto_increment not null,
  nom                       varchar(255) not null,
  constraint pk_coneixement primary key (id))
;

create table oferta (
  type                      varchar(31) not null,
  id                        integer auto_increment not null,
  titol                     varchar(255) not null,
  informacio_oferta         varchar(255) not null,
  constraint pk_oferta primary key (id))
;

create table usuari (
  type                      varchar(31) not null,
  id                        integer auto_increment not null,
  username                  varchar(255) not null,
  password                  varchar(255) not null,
  email                     varchar(255),
  es_administrador          tinyint(1) default 0 not null,
  es_blocat                 tinyint(1) default 0 not null,
  es_deganal                tinyint(1) default 0 not null,
  expiracio_blocatge        datetime,
  motiu_blocatge            varchar(255),
  cif                       varchar(255) not null,
  nom                       varchar(255) not null,
  logo                      varchar(255),
  constraint uq_usuari_cif unique (cif),
  constraint pk_usuari primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table coneixement;

drop table oferta;

drop table usuari;

SET FOREIGN_KEY_CHECKS=1;

