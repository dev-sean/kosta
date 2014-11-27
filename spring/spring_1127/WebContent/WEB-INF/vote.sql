-- vote 테이블 구성중 code는 투표 항목을 구분해주는 컬럼이다.
create table vote(
num number primary key,
sub varchar2(100) not null,
code number(2) not null,
vsub1 varchar2(55),
vsub2 varchar2(55),
vsub3 varchar2(55),
vsub4 varchar2(55),
vsub5 varchar2(55),
vres1 number(5) default 0,
vres2 number(5) default 0,
vres3 number(5) default 0,
vres4 number(5) default 0,
vres5 number(5) default 0,
vdate date  default sysdate);

create sequence vote_seq
increment by 1
start with 1;