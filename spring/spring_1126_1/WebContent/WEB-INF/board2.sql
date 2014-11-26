create table board2(
no number primary key,
pwd varchar2(10),
writer varchar2(34),
subject varchar2(100),
content varchar2(400),
reip varchar2(34),
ref number(5),
seq number(5),
lvl number(5),
hit number,
regdate date default sysdate);

create sequence board2_seq
increment by 1
start with 1;