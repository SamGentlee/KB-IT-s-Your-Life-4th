drop table members;
create table members(
    id varchar2(50) constraint members_pk primary key,
    name varchar2(50),
    pwd varchar2(50),
    status char(1) -- Normal(N) / Locked(L)
);

create table members(
    id varchar2(50) ,
    name varchar2(50) not null unique,
    pwd varchar2(50),
    status char(1), -- Normal(N) / Locked(L)
    constraint members_pk primary key(id) --constraint members_pk primary key(id,name) id�� name�� ���ؼ� �����̸Ӹ�Ű ����
);

INSERT INTO "HR"."MEMBERS" 
(ID, NAME, PWD, STATUS) 
VALUES ('user01', 'ȫ', '1111', 'N');

INSERT INTO "HR"."MEMBERS" 
(ID,name,PWD, STATUS)
VALUES ('user02','��','1111', 'N');

-- ��������
drop table login;
create table login(
    member_id varchar2(50), --ȸ��id
    login_date char(8), --��ٳ����
    login_time char(6), --��ٽð�
    logout_date char(8), --��ٳ����
    logout_time char(6), --��ٽð�
    constraint login_member_id_fk foreign key(member_id) references members(id)
);

insert into login values('user100',20230723,0700,null,null);
insert into login values('user02',20230723,0700,null,null);

create table emp2(
    empno number(4) constraint empno_pk primary key,
    ename varchar2(10) constraint ename_nn not null,
    phone varchar2(10) constraint phone_uk unique,
    job varchar2(5),
    sal number(10) constraint sal_ck check (sal>0),
    deptno number(3) constraint deptno_fk references dept(deptno));
);

create table my_emp(
as
    select * from employees
    where employee_id<200;
);
drop table my_emp;

delete login
where member_id = 'user02';

delete members
where id = 'user02';

create sequence rent_seq; --������ ����
select rent_seq.nextval from dual; -- ���� ��(�⺻�� 1������)
select rent_seq.currval from dual; -- ���� ��
drop sequence rent_seq; -- ������ ����

commit;
    