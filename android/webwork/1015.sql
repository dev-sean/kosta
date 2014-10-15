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
