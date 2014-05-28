# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table coneixement (
  id                        integer not null,
  nom                       varchar(255) not null,
  constraint uq_coneixement_nom unique (nom),
  constraint pk_coneixement primary key (id))
;

create table oferta (
  tipus                     varchar(31) not null,
  id                        integer not null,
  titol                     varchar(255) not null,
  informacio_oferta         clob not null,
  jornada_laboral           varchar(10) not null,
  data_insercio             timestamp not null,
  data_caducitat            timestamp,
  nom_persona_contacte      varchar(255),
  email_persona_contacte    varchar(255),
  empresa_id                integer,
  constraint ck_oferta_jornada_laboral check (jornada_laboral in ('Indiferent','Completa','Mitja')),
  constraint pk_oferta primary key (id))
;

create table usuari (
  tipus                     varchar(31) not null,
  id                        integer not null,
  nom                       varchar(255) not null,
  user                      varchar(255) not null,
  password                  varchar(255) not null,
  email                     varchar(255) not null,
  es_administrador          boolean not null,
  es_blocat                 boolean not null,
  es_deganal                boolean not null,
  expiracio_blocatge        timestamp,
  motiu_blocatge            varchar(255),
  cif                       varchar(255),
  logo                      varchar(255),
  telefon                   varchar(255),
  constraint uq_usuari_email unique (email),
  constraint uq_usuari_cif unique (cif),
  constraint pk_usuari primary key (id))
;


create table oferta_conexiement (
  oferta_id                      integer not null,
  conexiement_id                 integer not null,
  constraint pk_oferta_conexiement primary key (oferta_id, conexiement_id))
;
create sequence coneixement_seq;

create sequence oferta_seq;

create sequence usuari_seq;

alter table oferta add constraint fk_oferta_empresa_1 foreign key (empresa_id) references usuari (id) on delete restrict on update restrict;
create index ix_oferta_empresa_1 on oferta (empresa_id);



alter table oferta_conexiement add constraint fk_oferta_conexiement_oferta_01 foreign key (oferta_id) references oferta (id) on delete restrict on update restrict;

alter table oferta_conexiement add constraint fk_oferta_conexiement_coneixe_02 foreign key (conexiement_id) references coneixement (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists coneixement;

drop table if exists oferta;

drop table if exists oferta_conexiement;

drop table if exists usuari;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists coneixement_seq;

drop sequence if exists oferta_seq;

drop sequence if exists usuari_seq;

