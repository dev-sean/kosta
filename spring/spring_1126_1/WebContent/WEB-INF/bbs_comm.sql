create table bbs_comm(
num number primary key,
tcode number not null,
comm varchar2(100),
writer varchar2(30),
pwd varchar2(10),
reip varchar2(45),
regdate date,
constraint bbs_comm_fk foreign key(tcode) references board2(no));

create sequence bbs_comm_seq
increment by 1
start with 1;
