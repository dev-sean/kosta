create table tvo(
num number(10) primary key,
sub varchar2(34),
writer varchar2(34),
content varchar2(400),
pwd varchar2(34),
mfile varchar2(34));

create sequence tvo_seq
increment by 1
start with 1;
