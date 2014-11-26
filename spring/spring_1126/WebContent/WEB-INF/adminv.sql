create table adminv(
num number(10) primary key,
id varchar2(34),
pwd varchar2(34),
lvl varchar2(10),
regdate date,
name varchar2(34));

create sequence adminv_seq
increment by 1
start with 1;

insert into adminv values(adminv_seq.nextVal, 'xman', 'test09', 'A', sysdate, 'À±Èñ¼±');

commit;