-- hr_main.sqp 스크립트파일 @ CMD 실행: 샘플 테이블 생성 확인.
SELECT *
FROM tabs;

-- 인종
DESC regions;

SELECT *
FROM regions;

-- 사는 도시
DESC countries;

SELECT *
FROM countries;

-- 부서정보
DESC departments;

SELECT *
FROM departments;

-- 가장 중요한 직원 정보 테이블
DESC employees;

SELECT *
FROM employees;

 -- 회사 지점 주소 정보
DESC locations;

SELECT *
FROM locations;

 -- 직무정보
DESC jobs;

SELECT *
FROM jobs;

 -- 직원의 과거 직무 이력
DESC job_history;

SELECT *
FROM job_history;


---------------------------------------
-- 1) HR 계정이 소유하고 있는 테이블의 정보를 조회
SELECT table_name
FROM tabs;

-- 2) job의 종류를 확인하고 갯수 조회.
-- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다
SELECT job_id, count(JOB_ID)
FROM JOBS;

-- 총 사원수 파악(조회)
SELECT count (*)  -- 오라클 집계함수 중 count()
FROM employees;

SELECT department_id
FROM departments;

SELECT DISTINCT department_id
FROM employees;

-- 각 사원의 월급과 연봉을 출력하세요
-- [자바] + : 덧셈연산자, 문자열연결연산자
-- [오라클] 문자열연결연산자 || , CONCAT()
-- 날짜와 문자열일때 앞뒤에 ' ' 쓴다

SELECT employee_id
        , first_name || ' ' || last_name as name
        , CONCAT(first_name , ' ' || last_name) as full_name
        , CONCAT(CONCAT(first_name,' '),last_name) fn
        , salary
--      , commission_pct
        , NVL(commission_pct,0) comm
        , salary + (salary*NVL(commission_pct,0)) as pay
        , 12 * (salary + (salary*NVL(commission_pct,0))) as "annual salary"
FROM employees;

SELECT last_name || '님의 급여는 ' || salary || '입니다.' as result
FROM employees;

-----------------------------------------------------------

-- 직속상사가 있으면 Y 없다면 N
-- 부서가 있으면 'O' 없으면 'X'
-- NULL 처리 함수 : NVL(컬럼,0), NVL2(컬럼,??, ??)(2번째 null 이 아니라면 3번째 null 이라면)

SELECT employee_id, first_name
        , NVL2(manager_id,'Y','N') as mgr_yn
        , NVL2(department_id,'O','X') as dept_ox
FROM employees;





