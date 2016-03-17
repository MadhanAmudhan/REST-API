# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cw_login (
  seq                       number(19) not null,
  username                  varchar2(255),
  password                  varchar2(255),
  constraint pk_cw_login primary key (seq))
;

create table person (
  id                        varchar2(255) not null,
  name                      varchar2(255),
  constraint pk_person primary key (id))
;

create sequence cw_login_seq;

create sequence person_seq;




# --- !Downs

drop table cw_login cascade constraints purge;

drop table person cascade constraints purge;

drop sequence cw_login_seq;

drop sequence person_seq;

