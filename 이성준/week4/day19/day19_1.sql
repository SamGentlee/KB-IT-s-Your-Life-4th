
select * from employees;
select count(*) from employees;
select employee_id, last_name as "¼º" from employees;

desc employees;

select employee_id, first_name, salary, job_id, commission_pct,salary*commission_pct as Bonus
from employees;

select rent_seq.currval
from dual;

select first_name||':'||salary
from employees;