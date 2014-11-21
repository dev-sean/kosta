create table mjoin(
num number primary key,
id varchar2(10) not null,
pwd varchar2(34),
name varchar2(34),
info varchar2(400),
hdate date,
pay number(10));

create sequence mjoin_seq
increment by 1
start with 1;