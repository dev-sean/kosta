create table imgdir(
num number primary key,
writer varchar2(30),
imgpath varchar2(50),
hit number(5),
reip varchar2(34),
edate date);

create sequence imgdir_seq
increment by 1
start with 1;