create table jspboard(
num number(10) constraint jspboard_num_pk primary key,
title varchar2(100),
cont varchar2(400),
age number(3),
name varchar2(34),
pwd varchar2(10),
sex varchar2(2),
hit number(3),
reip varchar2(34),
rdate date);

create sequence jspboard_seq
increment by 1
start with 1;

select * from jspboard;

 -- 10/16¿œ
 
create table andmem(
num number primary key,
id varchar2(10) not null,
pwd varchar2(10),
name varchar2(34),
rdate date);

create sequence andmem_seq
increment by 1
start with 1;

insert into andmem values(andmem_seq.nextVal, 'xman', '12', 'Kim', sysdate);
insert into andmem values(andmem_seq.nextVal, 'aman', '14', 'Rim', sysdate);
insert into andmem values(andmem_seq.nextVal, 'bman', '15', 'Lim', sysdate);
insert into andmem values(andmem_seq.nextVal, 'cman', '16', 'Dim', sysdate);
commit;

select * from andmem;

select count(*) cnt from andmem where id='aman' and pwd='12';