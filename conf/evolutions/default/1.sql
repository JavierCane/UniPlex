# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table coneixement (
  id                        integer auto_increment not null,
  nom                       varchar(255) not null,
  constraint uq_coneixement_nom unique (nom),
  constraint pk_coneixement primary key (id))
;

create table oferta (
  tipus                     varchar(31) not null,
  id                        integer auto_increment not null,
  titol                     varchar(255) not null,
  informacio_oferta         longtext not null,
  jornada_laboral           varchar(10) not null,
  destinatari               varchar(22) not null,
  data_insercio             datetime not null,
  data_caducitat            datetime,
  nom_persona_contacte      varchar(255),
  email_persona_contacte    varchar(255),
  empresa_id                integer,
  constraint ck_oferta_jornada_laboral check (jornada_laboral in ('Indiferent','Completa','Mitja')),
  constraint ck_oferta_destinatari check (destinatari in ('TitulatsAmbExperiencia','Indiferent','AcabatsDeTitular','Estudiants')),
  constraint pk_oferta primary key (id))
;

create table usuari (
  tipus                     varchar(31) not null,
  id                        integer auto_increment not null,
  nom                       varchar(255) not null,
  user                      varchar(255) not null,
  password                  varchar(255) not null,
  email                     varchar(255) not null,
  es_administrador          tinyint(1) default 0 not null,
  es_blocat                 tinyint(1) default 0 not null,
  es_deganal                tinyint(1) default 0 not null,
  expiracio_blocatge        datetime,
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
alter table oferta add constraint fk_oferta_empresa_1 foreign key (empresa_id) references usuari (id) on delete restrict on update restrict;
create index ix_oferta_empresa_1 on oferta (empresa_id);



alter table oferta_conexiement add constraint fk_oferta_conexiement_oferta_01 foreign key (oferta_id) references oferta (id) on delete restrict on update restrict;

alter table oferta_conexiement add constraint fk_oferta_conexiement_coneixement_02 foreign key (conexiement_id) references coneixement (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table coneixement;

drop table oferta;

drop table oferta_conexiement;

drop table usuari;

SET FOREIGN_KEY_CHECKS=1;

