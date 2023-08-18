select '$'||salary as salary 
from employees; 

select job_id from employees; -- 107��

select distinct job_id from employees; -- 19��

select department_id, job_id from employees; --107��

select distinct department_id, job_id from employees; -- 20��

select * 
from employees 
where salary >= 3000; -- job_id = 'sa_man'

select *
from employees
where salary between 2000 and 3000; -- salary�� 2000����3000���� ���

select *
from employees 
where department_id in(10, 30, 50); -- or ���� - 10,30,50�̸� ���

select *
from employees
where first_name like 'A%'; -- first_name �� A�� �����ϸ� ��� %�� 0���̻��ڿ� ����

select *
from employees
where first_name like '_'; -- first_name�� llen���� ������ ��� _ �� �Ѱ����ڿ� ����

select *
from employees
where first_name like '%#%%' ESCAPE '#'; --first_name�� %�� �����ϸ� ���

select *
from employees
where commission_pct is null; -- commission_pct�� ���� ��� ���

select * 
from employees 
where salary >2800 OR job_id = 'SA_MAN'; 

select * from employees where salary not between 1000 and 3000;

select * from employees where first_name not like 'A%';

select * from employees where commission_pct is not null;

select first_name, salary*commission_pct from employees
order by 1;

update login
set logout_date = '20230726', logout_time='090000' where member_id ='user02';

update login
set login_time = '070000' where member_id ='user02';

select * from login;

select first_name, length(first_name) from employees order by 2,1;

select first_name from employees where substr(first_name,1,1)>'K' and substr(first_name,1,1) <'Y';

--first_name�� 'L'�� �����ϴ� first_name ���
select first_name from employees where first_name like '%L%';
select first_name from employees where instr(first_name,'L')>0;

select first_name, LPAD(first_name, 15,'a')from employees;
select first_name, RPAD(first_name, 15,'a')from employees;

select job_id, LTRIM(job_id,'A') from employees;
select job_id, RTRIM(job_id,'T') from employees;

select first_name, replace(first_name, 'El','*?'),
translate(first_name,'El','*?')
from employees;

select power(2,10),
    ceil(3.7),
    floor(3.7),
    trunc(3.141592,3),
    round(3.141592,3),
    mod(5,3)
from dual;

select sysdate,
    systimestamp
from dual;

SELECT hire_date, months_between(sysdate,hire_date)
from employees;

SELECT 
    EXTRACT( YEAR FROM SYSDATE) YEAR,
    EXTRACT( MONTH FROM SYSDATE) MONTH,
    EXTRACT( DAY FROM SYSDATE) DAY,
    EXTRACT( HOUR FROM SYSDATE) HOUR,
    EXTRACT( MINUTE FROM SYSDATE)
FROM DUAL;

select sysdate "���� ��¥", 
    to_date('2023-12-25') "ũ��������",
    trunc(to_date('2023-12-25') - sysdate) "d-day",
    months_between(to_date('2023-12-25'),sysdate) "months"
from dual;

select sysdate, to_char(sysdate,'yyyy"��"mm"��"dd"��"') from dual;
select to_date('1225','mmdd')as christmas, to_char(to_date('2023-12-25'),'day') from dual;


select commission_pct, nvl(commission_pct,0) from employees;
select first_name, nvl2(manager_id,'����','����') from employees;
select job_id, nullif(job_id, 'IT_PROG') from employees;

select 
    salary,
    job_id,
    DECODE(job_id,'FI_ACCOUNT',salary*1.1,
        'IT_PROG', salary*1.2,
        'ST_MAN', salary*1.3,
        'IT_PROG', salary*1.4,
        salary) SAL
from employees;
        
 select first_name,
        salary,
        job_id,
        CASE job_id WHEN 'FI_ACCOUNT' THEN salary*1.1
                    WHEN 'IT_PROG' THEN salary*1.2
                    WHEN 'ST_MAN' THEN salary*1.3
                    ELSE salary
        END sal
from employees;
        
        