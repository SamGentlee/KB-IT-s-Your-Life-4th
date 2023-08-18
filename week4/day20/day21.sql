-- NULL값을 제외한 값출력
select count(commission_pct)
from employees;

--부서별 월급 평균
SELECT 10 ,AVG(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID=10
UNION 
SELECT 20 ,AVG(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID=20;

--부서별 월급 평균(GROUP BY 사용)
SELECT DEPARTMENT_ID, AVG(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID-- 부서별
ORDER BY 1; 

--부서별로 인원수, 평균 급여, 최소,최대,합 급여
SELECT DEPARTMENT_ID, COUNT(*), ROUND(AVG(SALARY),1), MIN(SALARY),MAX(SALARY), SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY 1;

--업무별로 인원수, 평균 급여, 최소,최대,합 급여
SELECT JOB_ID, COUNT(*), ROUND(AVG(SALARY),1), MIN(SALARY),MAX(SALARY), SUM(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
ORDER BY 1;

--업무별과 부서별로 인원수, 평균 급여, 최소,최대,합 급여
SELECT JOB_ID, DEPARTMENT_ID, COUNT(*), ROUND(AVG(SALARY),1), MIN(SALARY),MAX(SALARY), SUM(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID, DEPARTMENT_ID
ORDER BY 1;

--평균 월급보다 많은 월급을 받는 직원 목록
SELECT DEPARTMENT_ID, round(AVG(SALARY))
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) > 10000;

--부서인원이 4명보다 많은
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

--ROLLUP사용시
SELECT DEPARTMENT_ID, COUNT(*), SUM(SALARY)
FROM EMPLOYEES
GROUP BY ROLLUP(DEPARTMENT_ID)
ORDER BY 1;

-- ROLLUP 사용 안할시
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
D.MANAGER_ID, --부서장
E.FIRST_NAME
FROM DEPARTMENTS D, LOCATIONS L, EMPLOYEES E
WHERE D.LOCATION_ID = l.location_id 
AND
D.MANAGER_ID = E.EMPLOYEE_ID;

SELECT E.EMPLOYEE_ID, E.FIRST_NAME, D.DEPARTMENT_ID, D.DEPARTMENT_NAME
FROM EMPLOYEES E, DEPARTMENTS D
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID;

--employees 테이블 emp_id, first_name, salary
--departments 테이블 department_name, location_id
--locations 테이블 city
--countries 테이블 country_name 출려
select e.employee_id, e.first_name,
        e.salary, d.department_name, d.location_id,
        l.city ,c.country_name
from employees e, departments d, locations l, countries c
where e.department_id = d.department_id 
    and d.location_id = l.location_id
    and e.job_id = 'SA_MAN'
    and c.country_id = l.country_id;

-- department_id가 null값이 데이터가 한개있기때문에 107개중 106개만 출력
select count(*)
from employees e, departments d
where e.department_id = d.department_id;

-- outer join 처리를 하여 d.department_id를 기준으로 출력 107개
select count(*)
from employees e, departments d
where e.department_id = d.department_id(+);
     
-- 부서27개
-- 부서명과 부서장 이름을 출력, 부서장이 없어도 출력
-- 부서의 도시명 출력(도시명이 없어도 출력)
select d.department_name, e.first_name, l.city
from departments d, employees e, locations l
where d.manager_id = e.employee_id(+)
    and l.location_id(+) = d.location_id;

--사원번호, 사원이름, 사원의 관리자 번호, 관리자 이름 조회
select e1.employee_id, e1.first_name, e1.manager_id, e2.first_name
from employees e1,employees e2
where e1.manager_id = e2.employee_id(+)
order by 4;

--사원이름, 부서번호, 부서명 부서번호가 20과 30인 정보
select e.first_name,department_id,d.department_name
from employees e NATURAL JOIN departments d
where department_id in(30,20);

--부서번호, 부서명, 도시이름을 natural join 을 사용하여 조회하세요
select e.first_name, department_id, d.department_name, l.city
from employees e natural join departments d natural join locations l
order by 2;

--사원명, 급여, 관리자명, 관리자급여, 근무 도시명 추가
select 
    e.first_name 사원명,
    e.salary 급여, 
    mgr.first_name 관리자명,
    mgr.salary 관리자급여, 
    l.city 근무도시명
from employees e
    join employees mgr 
        on(e.manager_id = mgr.employee_id)
    join departments d 
         on (d.department_id = e.department_id)
    join locations l 
         on(l.location_id = d.location_id);
         

-- 모든 부서명과 부서장 이름을 조회.
-- 부서장 없는 부서도 조회(LEFT OUTER JOIN) 
-- 부서를 기준으로 부서장이름이 NULL값인 부서를 출력하기위해서
-- left join 한다.
select d.department_id, d.manager_id,
    e.first_name 부서장이름
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


-- 서브쿼리 사용: 괄호
select first_name, job_id
from employees
where job_id=(select job_id
from employees
where employee_id = 139);

-- 사원들의 평균 급여보다 많이 받는 사원들의 이름, 급여를 조회
select first_name, salary
from employees
where salary > (select avg(salary) from employees);

--급여가 가장많은 사원의 이름, 급여, 입사일 조회
select first_name, salary
from employees
where salary = (select max(salary) from employees);

--20번 부서의 최소급여보다 많은 부서를 조회
select department_id, min(salary)
from employees
group by department_id
having min(salary) > (select min(salary) from employees where department_id = 20);

-- '=' 은 숫자데이터 비교이므로 in을 사용한다.
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


--소속 부서의 평균급여보다 많은 급여를 받는 사원의 이름 , 부서번호, 업무 조회
select first_name, department_id, job_id
from employees e
where salary > (select avg(salary) 
                            from employees
                            where department_id = e.department_id);
                            



--from절 서브쿼리/ 부서별 평균급여보다 많은 급여를 받는 사원의 정보 조회
select e.employee_id, e.department_id, e.salary, d.avgsal
    from employees e, 
        (select department_id, round(avg(salary)) avgsal 
        from employees
        group by department_id) d
    where e.department_id = d.department_id and e.salary > d.avgsal
order by 2;

--rownum이 뒤죽박죽
select rownum, employee_id, first_name, salary
from employees
order by salary desc;

--inline 뷰를 사용하여 rownum도 정렬
select rownum, d.employee_id, d.first_name, d.salary
from (select employee_id, first_name, salary 
from employees order by salary desc) d;


--스칼라 서브쿼리
select employee_id, department_id, salary,
(select round(avg(salary)) from employees where department_id = e.department_id) as sal
from employees e;
