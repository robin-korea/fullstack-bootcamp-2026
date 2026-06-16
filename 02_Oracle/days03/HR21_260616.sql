-- HR
SELECT *
FROM user_tables
WHERE table_name LIKE 'EMP%';
--WHERE table_name = 'EMPLOYEES';

DESC employees;

-- 1)
SELECT last_name, salary
FROM employees
WHERE last_name LIKE 'R%'
ORDER BY salary;

-- 2)
SELECT last_name, salary
FROM employees
WHERE last_name LIKE 'R___'
ORDER BY salary;

-- 3)
SELECT last_name, salary
FROM employees
WHERE last_name LIKE '%A\_B' ESCAPE '\'
ORDER BY salary;

-- 4)
SELECT first_name, last_name 
FROM employees
WHERE REGEXP_LIKE (first_name, '^Ste(v|ph)en$')
ORDER BY first_name, last_name; -- 1차 정렬, 2차 정렬

-- 5)
SELECT last_name 
FROM employees
WHERE REGEXP_LIKE (last_name, '([aeiou])\1','i')
ORDER BY last_name;

--------------------------------------------------
-- 사원번호 : 154번 조회
SELECT * 
FROM employees
WHERE employee_id = 154;

UPDATE employees
SET last_name = 'C_ambrault'
WHERE employee_id = 154;

-- [문제] 100,101,102 사원의 last_name 이름을 변경
--100   Steven   K%ing
--101   Neena   Koch%har
--102   Lex   De Ha%an

UPDATE employees
SET last_name = 'K%ing'
WHERE employee_id = 100;

UPDATE employees
SET last_name = 'Koch%har'
WHERE employee_id = 101;

UPDATE employees
SET last_name = 'De Ha%an'
WHERE employee_id = 102;

UPDATE employees
SET last_name = SUBSTR( last_name, 1, LENGTH(last_name)-2) || '%' || SUBSTR( last_name,-2 )  
WHERE employee_id IN (  100, 101, 102 );

-- 1) last_name 문자열 속에 '%'를 포함하고 있는 사원 조회
SELECT last_name
FROM employees
WHERE last_name LIKE '%\%%' ESCAPE '\';

-- 2) last_name 문자열 속에 '_'를 포함하고 있는 사원 조회
SELECT last_name
FROM employees
WHERE last_name LIKE '%\_%' ESCAPE '\';

ROLLBACK;

---------------------------------------------------------------------------------
-- 사원이 속해있는 부서의 종류를 조회하는 쿼리 작성
SELECT DISTINCT department_id
FROM employees
WHERE department_id IS NOT NULL;

-- 사원이 속해 있지 않는 부서의 갯수를 조회하는 쿼리 작성
-- 풀이 1) SET(집합)연산자 : U/M/I
SELECT COUNT(*)
FROM( -- 인라인뷰
    SELECT department_id
    FROM departments
    MINUS
    SELECT DISTINCT department_id
    FROM employees
    WHERE department_id IS NOT NULL
);
-- 풀이2) LEFT OUTER JOIN 사용
SELECT COUNT(*)
FROM departments d 
LEFT OUTER JOIN employees e
    ON d.department_id = e.department_id
WHERE e.department_id IS NULL;

-- 풀이3) GROUP BY + HAVING 사용
SELECT COUNT(*)
FROM (
    SELECT d.department_id
    FROM departments d
    LEFT JOIN employees e
        ON d.department_id = e.department_id
    GROUP BY d.department_id
    HAVING COUNT(e.employee_id) = 0
);
  
-- 풀이4) NOT EXISTS 사용
SELECT COUNT(*)
FROM departments d
WHERE NOT EXISTS (
    SELECT 1
    FROM employees e
    WHERE e.department_id = d.department_id
);

-- 풀이5) NOT IN 사용
SELECT COUNT(*)
FROM departments
WHERE department_id NOT IN (
    SELECT DISTINCT department_id
    FROM employees
    WHERE department_id IS NOT NULL
);
------------------------------------------------

