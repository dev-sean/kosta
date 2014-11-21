create table reg(
num number(10) primary key,
name varchar2(34),
id varchar2(34),
pwd varchar2(34),
email varchar2(100),
tel varchar2(50),
filename varchar2(100),
reip varchar2(34),
rdate date);

create sequence reg_seq
increment by 1
start with 1;