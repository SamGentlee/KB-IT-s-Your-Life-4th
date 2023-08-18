drop table board;
drop sequence board_seq;

create table board(
    no number(8) constraint board_pk primary key,
    title varchar2(100) not null,
    writer varchar2(50) not null,
    regdate date default sysdate not null,
    content varchar2(4000) not null
);

create sequence board_seq;

insert into board
(no,title,writer,regdate,content)
values(board_seq.nextval, '1등이당~!','user01',sysdate,'우와~~~ 되나?');
insert into board
(no,title,writer,regdate,content)
values(board_seq.nextval, '2등~!','user01',sysdate,'2등 굳');
insert into board
(no,title,writer,regdate,content)
values(board_seq.nextval, '2등ㅇㄹㄴㅇㄹ~!','user01',sysdate,'2등 굳');

commit;