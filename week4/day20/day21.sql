-- NULL���� ������ �����
select count(commission_pct)
from employees;

--�μ��� ���� ���
SELECT 10 ,AVG(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID=10
UNION 
SELECT 20 ,AVG(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID=20;

--�μ��� ���� ���(GROUP BY ���)
SELECT DEPARTMENT_ID, AVG(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID-- �μ���
ORDER BY 1; 

--�μ����� �ο���, ��� �޿�, �ּ�,�ִ�,�� �޿�
SELECT DEPARTMENT_ID, COUNT(*), ROUND(AVG(SALARY),1), MIN(SALARY),MAX(SALARY), SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY 1;

--�������� �ο���, ��� �޿�, �ּ�,�ִ�,�� �޿�
SELECT JOB_ID, COUNT(*), ROUND(AVG(SALARY),1), MIN(SALARY),MAX(SALARY), SUM(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
ORDER BY 1;

--�������� �μ����� �ο���, ��� �޿�, �ּ�,�ִ�,�� �޿�
SELECT JOB_ID, DEPARTMENT_ID, COUNT(*), ROUND(AVG(SALARY),1), MIN(SALARY),MAX(SALARY), SUM(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID, DEPARTMENT_ID
ORDER BY 1;

--��� ���޺��� ���� ������ �޴� ���� ���
SELECT DEPARTMENT_ID, round(AVG(SALARY))
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) > 10000;

--�μ��ο��� 4���� ����
select department_id, count(*), round(avg(salary))
from employees
group by department_id
having count(*) > 4;

select department_id, sum(salary)
from employees
group by department_id
having sum(salary) > 20000
and department_id in(20,30);


select department_id, avg(salary)
from employees
where job_id like 'SA%'
group by department_id
having avg(salary)>1000;

--ROLLUP����
SELECT DEPARTMENT_ID, COUNT(*), SUM(SALARY)
FROM EMPLOYEES
GROUP BY ROLLUP(DEPARTMENT_ID)
ORDER BY 1;

-- ROLLUP ��� ���ҽ�
SELECT DEPARTMENT_ID, COUNT(*), SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
UNION
SELECT NULL ,COUNT(*), SUM(SALARY)
FROM EMPLOYEES
ORDER BY 1;

-- ROLLUP(X,Y)
SELECT DEPARTMENT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEES
GROUP BY ROLLUP(DEPARTMENT_ID, JOB_ID)
ORDER BY 1,2;

-- ROLLUP(X,Y)
SELECT DEPARTMENT_ID, JOB_ID, SUM(SALARY)
FROM EMPLOYEES
GROUP BY ROLLUP( JOB_ID, DEPARTMENT_ID)
ORDER BY 1;


SELECT 
D.DEPARTMENT_ID, 
D.DEPARTMENT_NAME,
D.LOCATION_ID, 
L.CITY
FROM DEPARTMENTS D, LOCATIONS L
WHERE D.LOCATION_ID = l.location_id;

SELECT 
D.DEPARTMENT_ID, 
D.DEPARTMENT_NAME,
D.LOCATION_ID, 
L.CITY,
D.MANAGER_ID, --�μ���
E.FIRST_NAME
FROM DEPARTMENTS D, LOCATIONS L, EMPLOYEES E
WHERE D.LOCATION_ID = l.location_id 
AND
D.MANAGER_ID = E.EMPLOYEE_ID;

SELECT E.EMPLOYEE_ID, E.FIRST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID;

--employees ���̺� emp_id, first_name, salary
--departments ���̺� department_name, location_id
--locations ���̺� city
--countries ���̺� country_name ���
select e.employee_id, e.first_name,
        e.salary, d.department_name, d.location_id,
        l.city ,c.country_name
from employees e, departments d, locations l, countries c
where e.department_id = d.department_id 
    and d.location_id = l.location_id
    and e.job_id = 'SA_MAN'
    and c.country_id = l.country_id;

-- department_id�� null���� �����Ͱ� �Ѱ��ֱ⶧���� 107���� 106���� ���
select count(*)
from employees e, departments d
where e.department_id = d.department_id;

-- outer join ó���� �Ͽ� d.department_id�� �������� ��� 107��
select count(*)
from employees e, departments d
where e.department_id = d.department_id(+);
     
-- �μ�27��
-- �μ���� �μ��� �̸��� ���, �μ����� ��� ���
-- �μ��� ���ø� ���(���ø��� ��� ���)
select d.department_name, e.first_name, l.city
from departments d, employees e, locations l
where d.manager_id = e.employee_id(+)
    and l.location_id(+) = d.location_id;

--�����ȣ, ����̸�, ����� ������ ��ȣ, ������ �̸� ��ȸ
select e1.employee_id, e1.first_name, e1.manager_id, e2.first_name
from employees e1,employees e2
where e1.manager_id = e2.employee_id(+)
order by 4;

--����̸�, �μ���ȣ, �μ��� �μ���ȣ�� 20�� 30�� ����
select e.first_name,department_id,d.department_name
from employees e NATURAL JOIN departments d
where department_id in(30,20);

--�μ���ȣ, �μ���, �����̸��� natural join �� ����Ͽ� ��ȸ�ϼ���
select e.first_name, department_id, d.department_name, l.city
from employees e natural join departments d natural join locations l
order by 2;

--�����, �޿�, �����ڸ�, �����ڱ޿�, �ٹ� ���ø� �߰�
select 
    e.first_name �����,
    e.salary �޿�, 
    mgr.first_name �����ڸ�,
    mgr.salary �����ڱ޿�, 
    l.city �ٹ����ø�
from employees e
    join employees mgr 
        on(e.manager_id = mgr.employee_id)
    join departments d 
         on (d.department_id = e.department_id)
    join locations l 
         on(l.location_id = d.location_id);
         

-- ��� �μ���� �μ��� �̸��� ��ȸ.
-- �μ��� ���� �μ��� ��ȸ(LEFT OUTER JOIN) 
-- �μ��� �������� �μ����̸��� NULL���� �μ��� ����ϱ����ؼ�
-- left join �Ѵ�.
select d.department_id, d.manager_id,
    e.first_name �μ����̸�
from departments d 
    left outer join employees e on (d.manager_id = e.employee_id);
    
--1
select job_id
from employees
where employee_id = 139; --'ST_CLERK'
--2
select first_name, job_id
from employees
where job_id='ST_CLERK';


-- �������� ���: ��ȣ
select first_name, job_id
from employees
where job_id=(select job_id
from employees
where employee_id = 139);

-- ������� ��� �޿����� ���� �޴� ������� �̸�, �޿��� ��ȸ
select first_name, salary
from employees
where salary > (select avg(salary) from employees);

--�޿��� ���帹�� ����� �̸�, �޿�, �Ի��� ��ȸ
select first_name, salary
from employees
where salary = (select max(salary) from employees);

--20�� �μ��� �ּұ޿����� ���� �μ��� ��ȸ
select department_id, min(salary)
from employees
group by department_id
having min(salary) > (select min(salary) from employees where department_id = 20);

-- '=' �� ���ڵ����� ���̹Ƿ� in�� ����Ѵ�.
select employee_id, first_name
from employees
where salary in (select max(salary)
from employees
group by department_id)
order by 1;


select employee_id, first_name
from employees
where salary < ANY (select max(salary)
from employees
group by department_id)
order by 1;


--�Ҽ� �μ��� ��ձ޿����� ���� �޿��� �޴� ����� �̸� , �μ���ȣ, ���� ��ȸ
select first_name, department_id, job_id
from employees e
where salary > (select avg(salary) 
                            from employees
                            where department_id = e.department_id);
                            



--from�� ��������/ �μ��� ��ձ޿����� ���� �޿��� �޴� ����� ���� ��ȸ
select e.employee_id, e.department_id, e.salary, d.avgsal
    from employees e, 
        (select department_id, round(avg(salary)) avgsal 
        from employees
        group by department_id) d
    where e.department_id = d.department_id and e.salary > d.avgsal
order by 2;

--rownum�� ���׹���
select rownum, employee_id, first_name, salary
from employees
order by salary desc;

--inline �並 ����Ͽ� rownum�� ����
select rownum, d.employee_id, d.first_name, d.salary
from (select employee_id, first_name, salary 
from employees order by salary desc) d;


--��Į�� ��������
select employee_id, department_id, salary,
(select round(avg(salary)) from employees where department_id = e.department_id) as sal
from employees e;
