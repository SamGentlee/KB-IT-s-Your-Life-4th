drop table 회원;
drop table 비디오T;
drop table 도서T;
drop table CDT;
drop table 대여물품T;
drop table 대여;

--회원테이블
create table 회원(
    아이디 varchar2(30) constraint 아이디_pk primary key,
    이름 varchar2(20) not null,
    비번 varchar2(30) not null,
    연락처 varchar2(30) not null
);

--대여물품테이블
create table 대여물품T(
    관리번호 number(10) constraint 대여물품T_pk primary key, 
    종류 varchar2(10) not null,
    제목 varchar2(30) not null,
    가격 number(30) not null,
    수량 number(6) not null
);

--cd테이블
create table CDT(
    관리번호 number(10) constraint CDT_pk primary key,
    가수 varchar2(20),
    앨범제목 varchar2(50),
    constraint CDT_fk foreign key(관리번호) references 대여물품T(관리번호)
);

--도서테이블
create table 도서T(
    관리번호 number(10)constraint 도서T_pk primary key,
    출판사 varchar2(50),
    constraint 도서T_fk foreign key(관리번호) references 대여물품T(관리번호)
);

--비디오테이블
create table 비디오T(
    관리번호 number(10) constraint 비디오T_pk primary key,
    제작사 varchar2(50),
    constraint 비디오T_fk foreign key(관리번호) references 대여물품T(관리번호)
);

--대여테이블
create table 대여(
    대여일련번호 number(10) constraint 대여_pk primary key,
    회원id varchar2(30) constraint 대여_회원id_fk references 회원(아이디),
    관리번호 number(10) constraint 대여_관리번호_fk references 대여물품T(관리번호),
    대여년월일 char(8)not null,
    대여시분 char(6)not null,
    반납년월일 char(8),
    반납시분 char(6)   
);

drop sequence 대여일련번호_seq;
--대여일련번호시퀀스
create sequence 대여일련번호_seq
increment by 1
start with 1000
nocache;

drop sequence 관리번호_seq;
--관리번호시퀀스
create sequence 관리번호_seq
increment by 1
start with 100
nocache;

--회원 등록
insert into 회원
values('user01','홍길동','1234','010-3333-4444');
insert into 회원
values('user02','최길동','1234','010-2222-7777');

--대여물품 등록(도서)
insert into 대여물품T 
values(관리번호_seq.nextval,'도서','지리산',12000,3);
insert into 도서T
values (관리번호_seq.currval,'해냄출판사');

--대여물품 등록(비디오)
insert into 대여물품T 
values(관리번호_seq.nextval,'비디오','터미네이터',5000,2);
insert into 비디오T
values (관리번호_seq.currval,'스튜디오_A');

--대여물품 등록(cd)
insert into 대여물품T 
values(관리번호_seq.nextval,'CD','아이유1집',10000,5);
insert into CDT
values (관리번호_seq.currval,'아이유','아이유1집');

--대여등록
insert into 대여(대여일련번호,회원id,관리번호,대여년월일,대여시분)
values (대여일련번호_seq.nextval,'user01',100,'230728','1700');
update 대여물품T set 수량=수량-1 where 관리번호 = 100;

--대여등록
insert into 대여(대여일련번호,회원id,관리번호,대여년월일,대여시분)
values (대여일련번호_seq.nextval,'user02',101,'230728','1800');
update 대여물품T set 수량=수량-1 where 관리번호 = 101;

--반납업데이트
update 대여 set 반납년월일 = '230801', 반납시분 = '1000' where 관리번호 = 100;
update 대여물품T set 수량=수량+1 where 관리번호 = 100;