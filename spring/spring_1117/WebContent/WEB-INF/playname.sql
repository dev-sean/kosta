create table playme(
num number primary key,
pname varchar2(25),
price number(8),
users varchar2(34),
rdate date);

create sequence playme_seq
increment by 1
start with 1;