drop table ȸ��;
drop table ����T;
drop table ����T;
drop table CDT;
drop table �뿩��ǰT;
drop table �뿩;

--ȸ�����̺�
create table ȸ��(
    ���̵� varchar2(30) constraint ���̵�_pk primary key,
    �̸� varchar2(20) not null,
    ��� varchar2(30) not null,
    ����ó varchar2(30) not null
);

--�뿩��ǰ���̺�
create table �뿩��ǰT(
    ������ȣ number(10) constraint �뿩��ǰT_pk primary key, 
    ���� varchar2(10) not null,
    ���� varchar2(30) not null,
    ���� number(30) not null,
    ���� number(6) not null
);

--cd���̺�
create table CDT(
    ������ȣ number(10) constraint CDT_pk primary key,
    ���� varchar2(20),
    �ٹ����� varchar2(50),
    constraint CDT_fk foreign key(������ȣ) references �뿩��ǰT(������ȣ)
);

--�������̺�
create table ����T(
    ������ȣ number(10)constraint ����T_pk primary key,
    ���ǻ� varchar2(50),
    constraint ����T_fk foreign key(������ȣ) references �뿩��ǰT(������ȣ)
);

--�������̺�
create table ����T(
    ������ȣ number(10) constraint ����T_pk primary key,
    ���ۻ� varchar2(50),
    constraint ����T_fk foreign key(������ȣ) references �뿩��ǰT(������ȣ)
);

--�뿩���̺�
create table �뿩(
    �뿩�Ϸù�ȣ number(10) constraint �뿩_pk primary key,
    ȸ��id varchar2(30) constraint �뿩_ȸ��id_fk references ȸ��(���̵�),
    ������ȣ number(10) constraint �뿩_������ȣ_fk references �뿩��ǰT(������ȣ),
    �뿩����� char(8)not null,
    �뿩�ú� char(6)not null,
    �ݳ������ char(8),
    �ݳ��ú� char(6)   
);

drop sequence �뿩�Ϸù�ȣ_seq;
--�뿩�Ϸù�ȣ������
create sequence �뿩�Ϸù�ȣ_seq
increment by 1
start with 1000
nocache;

drop sequence ������ȣ_seq;
--������ȣ������
create sequence ������ȣ_seq
increment by 1
start with 100
nocache;

--ȸ�� ���
insert into ȸ��
values('user01','ȫ�浿','1234','010-3333-4444');
insert into ȸ��
values('user02','�ֱ浿','1234','010-2222-7777');

--�뿩��ǰ ���(����)
insert into �뿩��ǰT 
values(������ȣ_seq.nextval,'����','������',12000,3);
insert into ����T
values (������ȣ_seq.currval,'�س����ǻ�');

--�뿩��ǰ ���(����)
insert into �뿩��ǰT 
values(������ȣ_seq.nextval,'����','�͹̳�����',5000,2);
insert into ����T
values (������ȣ_seq.currval,'��Ʃ���_A');

--�뿩��ǰ ���(cd)
insert into �뿩��ǰT 
values(������ȣ_seq.nextval,'CD','������1��',10000,5);
insert into CDT
values (������ȣ_seq.currval,'������','������1��');

--�뿩���
insert into �뿩(�뿩�Ϸù�ȣ,ȸ��id,������ȣ,�뿩�����,�뿩�ú�)
values (�뿩�Ϸù�ȣ_seq.nextval,'user01',100,'230728','1700');
update �뿩��ǰT set ����=����-1 where ������ȣ = 100;

--�뿩���
insert into �뿩(�뿩�Ϸù�ȣ,ȸ��id,������ȣ,�뿩�����,�뿩�ú�)
values (�뿩�Ϸù�ȣ_seq.nextval,'user02',101,'230728','1800');
update �뿩��ǰT set ����=����-1 where ������ȣ = 101;

--�ݳ�������Ʈ
update �뿩 set �ݳ������ = '230801', �ݳ��ú� = '1000' where ������ȣ = 100;
update �뿩��ǰT set ����=����+1 where ������ȣ = 100;