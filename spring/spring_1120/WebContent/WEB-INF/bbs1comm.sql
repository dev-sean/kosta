CREATE TABLE bbs1comm(
num NUMBER CONSTRAINT bbs1comm_num_pk PRIMARY key,
kcode number(5) NOT NULL,
cnt number(5) NOT NULL,
writer VARCHAR2(34),
comm VARCHAR2(400),
reip VARCHAR2(34),
regdate DATE,
CONSTRAINT bbs1comm_kcode_fk FOREIGN KEY(kcode) REFERENCES bbs1(num));

CREATE SEQUENCE bbs1comm_seq
INCREMENT BY 1
START WITH 1;