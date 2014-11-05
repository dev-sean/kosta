create table mjoin(
num number primary key,
id varchar2(10) not null,
pwd varchar2(10),
name varchar2(34),
info varchar2(400),
hdate date,
constraint mjoin_id_uq unique(id));

create sequence mjoin_seq
increment by 1
start with 1;