create table bbs(
num number(5) constraint bbs_num_pk primary key,
sub varchar2(100),
writer varchar2(34),
pwd varchar2(10),
cont varchar2(400),
hit number(3),
reip varchar2(34),
redate date);

create sequence bbs_seq
increment by 1
start with 1;