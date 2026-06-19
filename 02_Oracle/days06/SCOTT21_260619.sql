-- 예1) emp 테이블에서 급여(sal) TOP-5 조회
--  ㄱ.RANK 분석함수
--  ㄴ.TOP_N 방식
--          1) FROM (서브쿼리 정렬)
SELECT *
FROM emp
ORDER BY sal DESC;
--          2) WHERE ROWNUM 컬럼 조건

SELECT e.*, ROWNUM seq
FROM(
    SELECT *
    FROM emp
    ORDER BY sal DESC
) e
WHERE ROWNUM <= 5;
-- WHERE ROWNUM BETWEEN 3 AND 5; (중간 부터 가져오는건 안된다)

-- 예2) TOP-N
--       emp 테이블에서 사원수가 가장 많은 부서번호, 사원수 조회
-- 풀이 1) TOP-N 방식                 오라클 11g 이하~
SELECT e.*, ROWNUM seq
FROM(
    SELECT p.deptno, d.dname, COUNT(*) as emp_cnt
    FROM emp p JOIN dept d ON p.deptno = d.deptno
    GROUP BY p.deptno, d.dname
    ORDER BY emp_cnt DESC
) e
WHERE ROWNUM = 1;

-- 풀이 2) RANK 분석함수
SELECT e.*
FROM (
     SELECT deptno 
        ,COUNT(*) as emp_cnt
        ,RANK() OVER(ORDER BY COUNT(*) DESC) as emp_cnt_rank
        ,DENSE_RANK() OVER(ORDER BY COUNT(*) DESC) as emp_cnt_rank2
        ,ROW_NUMBER() OVER(ORDER BY COUNT(*) DESC) as emp_cnt_rank3
     FROM emp
     GROUP BY deptno
)e
WHERE emp_cnt_rank = 1;

-- 풀이3) FETCH 절: 오라클 12c
--         ㄴ 정렬된 결과 집합에서 원하는 갯수의 행만 가져오는 절
SELECT deptno
        , COUNT(*) as emp_cnt
FROM emp
GROUP BY deptno
ORDER BY emp_cnt DESC
FETCH FIRST 2 ROW WITH TIES;  -- 만약 2등이 여러명있다면 2등 모두 가져온다
FETCH FIRST 1 ROW ONLY;       -- 만약 2등이 여러명있다면 2등 한명만 가져온다

-- 예) WITH TIES 확인, sal
SELECT *
FROM emp
ORDER BY sal DESC
FETCH FIRST 2 ROW ONLY;
FETCH FIRST 2 TOW WITH TIES;

-- 예) FETCH절  OFFSET 과 함께 사용해서 5~10 번째 데이터를 얻어올 수 있다
SELECT *
FROM emp
ORDER BY sal DESC
OFFSET 5 ROWS
FETCH NEXT 5 ROWS ONLY;

--풀이 4) KEEP 함수
SELECT
    MAX(e.deptno) KEEP( DENSE_RANK FIRST ORDER BY e.emp_cnt DESC) max_deptno
    ,MAX(e.emp_cnt) max_emp_cnt
FROM(
    SELECT deptno
          ,COUNT(*) emp_cnt
    FROM emp
    GROUP BY deptno
) e;

-- 예) 각 부서별 최고액, 최저액 사원의 정보를 조회
-- 풀이 1) ROW_NUMBER() : 추천
SELECT deptno, ename, sal
FROM(
SELECT deptno, ename, sal
    , ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal DESC) sdr
    , ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal ASC) sar
FROM emp
)
WHERE sdr = 1 OR sar = 1;

-- 풀이 2) KEEP (DENSE_RANK) 사용
SELECT deptno
        ,MAX(ename) KEEP(DENSE_RANK FIRST ORDER BY sal DESC) max_ename
        ,MAX(sal) max_sal
        ,MAX(ename) KEEP(DENSE_RANK FIRST ORDER BY sal) minename
        ,MIN(sal) min_sal
FROM emp
GROUP BY deptno
ORDER BY deptno;

-- 풀이 3) 
SELECT e.*
FROM emp e RIGHT OUTER JOIN (
                SELECT deptno
                    ,MAX(sal) max_sal
                    ,MIN(sal) min_sal
                FROM emp
                GROUP BY deptno
                ) t
            -- ON NVL(t.deptno, -1) = NVL(e.deptno, -1)
                ON t.deptno = e.deptno OR (e.deptno IS NULL AND t.deptno IS NULL)
WHERE e.sal = max_sal OR e.sal = min_sal AND e.deptno = t.deptno
ORDER BY e.deptno, e.sal DESC;

-- 예) emp 테이블에서 sal

SELECT ename, sal
    , CASE 
        WHEN rn <= total_cnt/ 3 THEN '상'
        WHEN rn <= total_cnt *2/3 THEN '중'
        ELSE '하'
    END as grade
FROM(
    SELECT ename
            , sal
            , ROW_NUMBER() OVER(ORDER BY sal DESC) as rn
            , COUNT(*) OVER() as total_cnt
    FROM emp
) e;

SELECT ename, sal
        ,CASE
            WHEN sal >= 3000 THEN '상'
            WHEN sal >= 1500 THEN '중'
            ELSE '하'
        END as grade
FROM emp;

-- NON EQUAL JOIN
SELECT ename, sal, s.grade
FROM emp e JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;

-- 풀이 2) NTILE() 분석함수
--      N-타일 , 정렬된 데이터를 N개의 그룹으로 균등하게 나누는 분석함수
--      번호 1/2/3~ 부여
--      NTILE(n) OVER(ORDER BY 컬럼)
--   최대한 균등하게 분배한다
SELECT ename, sal
        ,DECODE(NTILE(3) OVER (ORDER BY sal DESC),1,'상',2,'중','하') as grade
FROM emp;

-- 풀이 3) PERCENT_RANK()
SELECT ename, sal, TRUNC(p_r,4)
    , CASE
        WHEN p_r < 0.33 THEN '상'
        WHEN p_r BETWEEN 0.33 AND 0.66 THEN '중'
        ELSE '하'
      END as grade
FROM (
    SELECT ename, sal
            ,PERCENT_RANK() OVER (ORDER BY sal DESC) p_r
    FROM emp
) t;

-- 인원 2명 생일 오늘로 변경

--UPDATE insa
--SET ssn = SUBSTR(ssn, 1, 2) || TO_CHAR(SYSDATE, 'MMDD') || SUBSTR(ssn, 7)
--WHERE num IN (1001,1002);

UPDATE insa
SET ssn = REGEXP_REPLACE(ssn,'^(\d{2})(\d{4})(-\d{7})$','\1' || TO_CHAR(SYSDATE, 'MMDD') || '\3' )
WHERE num IN (1001,1002);

-- 예) insa 테이블에서 오늘을 기준으로 생일이 지났다, 오늘이 생일이다, 생일이 지나지 않았다
SELECT
    name
    ,ssn
    ,CASE
      WHEN SUBSTR(ssn,3,4) < TO_CHAR(SYSDATE, 'MMDD') THEN '생일이 지났다'
      WHEN SUBSTR(ssn,3,4) = TO_CHAR(SYSDATE, 'MMDD') THEN '생일이 오늘이다'
      ELSE '생일이 지나지 않았다' 
    END as check_birth
FROM insa;

SELECT name, ssn
--     , TO_CHAR( SYSDATE, 'MMDD' ) 
--     , SUBSTR( ssn, 3, 4 )
--     , SIGN(  TO_CHAR( SYSDATE, 'MMDD' ) - SUBSTR( ssn, 3, 4 ) )
     , DECODE( SIGN(  TO_CHAR( SYSDATE, 'MMDD' ) - SUBSTR( ssn, 3, 4 ) ), 0, '오늘', -1, '지나지않음', 1,  '지남' ) birthday_status
FROM insa;

-- 예) insa 테이블에서 주민등록번호로 만나이를 계산해서  출력
-- 올해년도 2026 생일년도 2027 
-- 만나이 = 생일년도 - 올해년도   생일이지나지않으면 -1
-- 성별 1/2/5/6 1900년대생 3/4/7/8 2000년대생 그 외 1800년대생
SELECT name,ssn,SYSDATE
     , TO_CHAR(SYSDATE,'YYYY') as YYYY
     , DECODE (SIGN(TO_CHAR(SYSDATE, 'MMDD') - SUBSTR(ssn,3,4)),-1,-1,0) birthday_status
     , CASE
           WHEN SUBSTR(ssn,8,1) IN (1,2,5,6) THEN 19 || SUBSTR(ssn,1,2)
           WHEN SUBSTR(ssn,8,1) IN (3,4,7,8) THEN 20 || SUBSTR(ssn,1,2)
           ELSE 18 || SUBSTR(ssn,1,2)
       END as birth_year
       ,TO_CHAR(SYSDATE,'YYYY') 
       - CASE
           WHEN SUBSTR(ssn,8,1) IN (1,2,5,6) THEN 19 || SUBSTR(ssn,1,2)
           WHEN SUBSTR(ssn,8,1) IN (3,4,7,8) THEN 20 || SUBSTR(ssn,1,2)
           ELSE 18 || SUBSTR(ssn,1,2)
       END  
       + DECODE (SIGN(TO_CHAR(SYSDATE, 'MMDD') - SUBSTR(ssn,3,4)),-1,-1,0) as american_age
FROM insa;

-- 풀이 1)
SELECT name, ssn, current_year, birth_year
        , current_year - birth_year + birthday_status as age
FROM(
    SELECT i.*
        ,TO_CHAR(SYSDATE, 'YYYY') current_year
        -- ,SUBSRR(ssn,-7,1)
        ,CASE 
            WHEN SUBSTR(ssn,-7,1) IN (1,2,5,6) THEN 1900
            WHEN REGEXP_LIKE(SUBSTR(ssn,-7,1),'[3478]') THEN 2000
        END + SUBSTR(ssn,1,2) birth_year
        , DECODE (SIGN(TO_CHAR(SYSDATE, 'MMDD') - SUBSTR(ssn,3,4)),-1,-1,0) birthday_status
    FROM insa i
);

-- 풀이 2) 실무 + 오라클 : 만나이
-- 주민등록번호 -> 생일 날짜 생성
SELECT name, ssn
    , FLOOR(MONTHS_BETWEEN(SYSDATE, birthday)/12) as 만나이
FROM(
    SELECT
        insa.*
        ,TO_DATE(CASE 
                WHEN SUBSTR(ssn,-7,1) IN (1,2,5,6) THEN 19
                WHEN REGEXP_LIKE(SUBSTR(ssn,-7,1),'[3478]') THEN 20
                ELSE 18
            END || SUBSTR(ssn,1,6)
        )birthday
    FROM insa
)t;

-- 예 insa 테이블에서 사원들을 랜덤하게 5명 뽑기
SELECT *
FROM(SELECT i.*,DBMS_RANDOM.VALUE rv FROM insa i ORDER BY rv)
WHERE ROWNUM <= 5;

-- 위의 쿼리 설명
-- 0.0 <= 실수 DBMS_RANDOM.VALUE < 1.0
-- 1.0 <= DBMS_RANDOM.VALUE(1,46) < 46.0
SELECT DBMS_RANDOM.VALUE
        , TRUNC(DBMS_RANDOM.VALUE(1,46))
FROM dual;

--
SELECT *
FROM(
    SELECT *
    FROM emp
    ORDER BY DBMS_RANDOM.VALUE
)
WHERE ROWNUM <= 5;

--
SELECT DBMS_RANDOM.STRING('X', 10)  -- 대문자 + 숫자
     , DBMS_RANDOM.STRING('U', 10)  -- 대문자
     , DBMS_RANDOM.STRING('L', 10)  -- 소문자
     , DBMS_RANDOM.STRING('P', 10)  -- 대문자 + 소문자 + 숫자 + 특수문자
     , DBMS_RANDOM.STRING('A', 10)  -- 알파벳(대+소문자)
FROM dual;

-- LISTAGG 함수
--    ㄴ 여러 행의 값을 하나의 문자열로 집계(연결) 하는 함수
      ㄴ LISTAGG(컬럼명, 구분자) WITHIN GROUP (ORDER BY 컬럼명)
--  1) 모든 사원의 이름 출력
SELECT name FROM emp;
--
SELECT LISTAGG (ename,';') WITHIN GROUP (ORDER BY hiredate) "emp_list_agg"
FROM emp;
--
SELECT LISTAGG (ename,';') WITHIN GROUP (ORDER BY sal DESC) "emp_list_agg"
FROM emp;

-- 2) 부서별로 사원명 출력
SELECT d.deptno
    , COUNT(ename)
    , NVL(
     LISTAGG (ename,';') WITHIN GROUP (ORDER BY sal DESC),'EMPTY'
     ) "emp_list_agg"
FROM emp e FULL OUTER JOIN dept d ON d.deptno = e.deptno
GROUP BY d.deptno
ORDER BY d.deptno;

-- 2-2)
SELECT DISTINCT deptno
        , LISTAGG (ename,';') WITHIN GROUP (ORDER BY sal DESC)
            OVER(PARTITION BY deptno) emp_list
FROM emp;

-- 예) 부서별 직무 목록 출력
-- 부서명 출력: 조인
SELECT d.deptno
        ,d.dname as dname
        ,LISTAGG (job,',') WITHIN GROUP (ORDER BY job) "Employee"
FROM emp e FULL OUTER JOIN dept d ON e.deptno = d.deptno
GROUP BY d.deptno, d.dname
ORDER BY d.deptno;

-- 예) 관리자별 부하 직원 목록
SELECT mgr
    , LISTAGG (ename,',') WITHIN GROUP (ORDER BY ename) "emp_list"
FROM emp
WHERE mgr IS NOT NULL
GROUP BY mgr;
-- SELF JOIN
SELECT a.empno, a.ename, a.mgr, b.ename
FROM emp a JOIN emp b ON a.mgr = b.empno;
--
SELECT a.mgr, b.ename, a.emp_list
FROM(
    SELECT mgr
        , LISTAGG (ename,',') WITHIN GROUP (ORDER BY ename) emp_list
    FROM emp
    WHERE mgr IS NOT NULL
    GROUP BY mgr
) a JOIN emp b ON a.mgr = b.empno;
--
FROM 뷰 또는 테이블
-- 입사년도별 사원 목록
SELECT TO_CHAR(hiredate, 'YYYY')
        ,COUNT(*)
        , LISTAGG (ename,',') WITHIN GROUP (ORDER BY ename) emp_list
FROM emp
GROUP BY TO_CHAR(hiredate, 'YYYY')
ORDER BY 1;

-- 급여 등급별로 사원 목록

SELECT s.grade
    , LISTAGG (ename,',') WITHIN GROUP (ORDER BY ename) emp_list
FROM emp e JOIN salgrade s ON sal BETWEEN losal AND hisal
GROUP BY s.grade
ORDER BY s.grade DESC;


SELECT t.grade
    , LISTAGG (ename,',') WITHIN GROUP (ORDER BY ename) emp_list
FROM(
    SELECT e.*,
    --       losal || '~' || hisal
            grade
    FROM emp e JOIN salgrade s ON sal BETWEEN losal AND hisal
) t
GROUP BY t.grade
ORDER BY t.grade;

-- 문제) 사원수가 가장 많은 부서 및 가장 적은 부서 정보 출력

SELECT deptno, dname, cnt, cnt_rank
FROM(
    SELECT d.deptno
            ,dname
            ,COUNT(e.empno) as cnt
            ,RANK() OVER (ORDER BY COUNT(e.empno) DESC) cnt_rank
            ,RANK() OVER (ORDER BY COUNT(e.empno) ASC) min_rank
    FROM dept d LEFT OUTER JOIN emp e ON e.deptno = d.deptno
    GROUP BY d.deptno,dname
) t
WHERE cnt_rank = 1 OR min_rank = 1
ORDER BY cnt_rank;

WITH a AS (
            SELECT d.deptno
            ,dname
            ,COUNT(e.empno) as emp_cnt
            ,RANK() OVER (ORDER BY COUNT(e.empno) DESC) cnt_rank
    FROM dept d LEFT OUTER JOIN emp e ON e.deptno = d.deptno
    GROUP BY d.deptno,dname
    ),
    b AS (
        SELECT MAX(emp_cnt) as max_cnt, MIN(emp_cnt) as min_cnt
        FROM a   
    )
SELECT a.*
FROM a JOIN b ON a.emp_cnt IN (b.max_cnt, b.min_cnt);

-- 피봇(PIVOT)/ 언피봇(UNPIVOT)
-- 피봇: 행 데이터를 열 데이터로 회전시켜 보여주는 기능
-- 1단계) 대상 쿼리(원본 쿼리)
SELECT job
FROM emp;

-- 2단계) 피봇 기능 사용하지 않고 해보기
SELECT 
      COUNT(DECODE(job,'CLERK','X')) CLERK
    , COUNT(DECODE(job,'SALESMAN','X')) SALESMAN
    , COUNT(DECODE(job,'PRESIDENT','X')) PRESIDENT
    , COUNT(DECODE(job,'MANAGER','X')) MANAGER
    , COUNT(DECODE(job,'ANALYST','X')) ANALYST
FROM emp;

-- 3단계) 피봇 기능
SELECT *
FROM (
   1) 원본쿼리 (대상) : 결과가 행으로 출력되는 대상 쿼리
)
PIVOT (
    집계함수 COUNT(job)
    FOR 회전할컬럼  원본쿼리의 컬럼 중에 job 컬럼
    IN (값1, 값2, 값3 ...)
);
--
SELECT *
FROM (
    SELECT job 
    FROM emp
)
PIVOT (
    COUNT(*)
    FOR job
    IN ('CLERK','SALESMAN','PRESIDENT','MANAGER','ANALYST')
);
--
SELECT *
FROM (
    SELECT d.deptno,dname, job 
    FROM emp e FULL OUTER JOIN dept d ON e.deptno = d.deptno
)
PIVOT (
    COUNT(*)
    FOR job
    IN ('CLERK','SALESMAN','PRESIDENT','MANAGER','ANALYST')
) 
ORDER BY deptno;

--
-- UNPIVOT 예제
A)
   'CLERK' 'SALESMAN' 'PRESIDENT'  'MANAGER'  'ANALYST'
---------- ---------- ----------- ---------- ----------
         4          4           1          3          2
B)
JOB          EMP_CNT
--------- ----------
CLERK              4
SALESMAN           4
PRESIDENT          1
MANAGER            3
ANALYST            2
-------------------------
-- UNPIVOT 구문
UNPIVOT (
    값컬럼명
    FOR 구분컬럼명
    IN (
        컬럼1,
        컬럼2,
        컬럼3
    )
)
---------------------------
SELECT *
FROM (
    SELECT *  -- 원본(대상) 쿼리
    FROM (
        SELECT job
        FROM emp
    )
    PIVOT (
        COUNT(*)
        FOR job IN (
            'CLERK'     AS CLERK,
            'SALESMAN'  AS SALESMAN,
            'PRESIDENT' AS PRESIDENT,
            'MANAGER'   AS MANAGER,
            'ANALYST'   AS ANALYST
        )
    )
) t
UNPIVOT (
    emp_cnt
    FOR job 
    IN (
        CLERK,
        SALESMAN,
        PRESIDENT,
        MANAGER,
        ANALYST
    )
);

-- 예) 피봇 2번째 예제
--     emp 테이블에서 각 월별 입사한 사원수 조회
-- 1단계) 피봇 대상 쿼리
SELECT 
        -- TO_CHAR(hiredate, 'YYYY') year
        ,TO_CHAR(hiredate, 'MM') month
FROM emp;
-- 2단계) 피봇
SELECT *
FROM (
    SELECT
    TO_CHAR(hiredate, 'YYYY') year
    ,TO_CHAR(hiredate, 'MM') month -- FOR month 회전할 컬럼
    FROM emp
)
PIVOT(
    COUNT(*)
    FOR month
    IN ('01' AS "1월",'02','03','04','05','06','07','08','09','10','11','12')
)
ORDER BY year;

-- 예) insa 테이블 생일 지남 유무
-- 1) DECODE 집계
WITH t AS (
    SELECT ssn
        , TO_CHAR(SYSDATE,'MMDD') current_md
        , SUBSTR(ssn,3,4) birth_md
        , SIGN(TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4)) birth_sign
    FROM insa
)
SELECT
    COUNT(DECODE(birth_sign,0,'O')) 오늘생일
    ,COUNT(DECODE(birth_sign,1,'O')) 생일지남
    ,COUNT(DECODE(birth_sign,-1,'O')) 생일안지남
FROM t;
-- 2) PIVOT 집계

SELECT *
FROM (
   SELECT SIGN(TO_CHAR(SYSDATE,'MMDD') - SUBSTR(ssn,3,4)) birth_sign
   FROM insa
) 
PIVOT (
    COUNT(*)
    FOR birth_sign
    IN (0 AS "오늘생일",1 AS "지남",-1 AS "안지남")
);

---- [ 피봇의 실무 사용  ]
--1. 월별 매출 보고서
--2. 부서별 직급 인원 현황
--3. 설문조사 결과 집계
--4. 병원 진료 통계
----> DBMS 호환성과 유지보수 때문에 X.

-- 예) 각 부서별 pay 총합 행 -> 열
SELECT deptno
    ,SUM(sal + NVL(comm,0)) pay
FROM emp
GROUP BY deptno;

SELECT *
FROM(
    SELECT deptno, sal + NVL(comm,0) pay
    FROM emp
)
PIVOT(
    SUM(pay)
    ,MAX(pay) as 최고액
    ,MIN(pay) as 최저액
    FOR deptno 
    IN (10,20,30,40,null)
);

-- 예) WIDTH_BUCKET(expression, min_value, max_value, num_buckets) 함수
--      숫자값을 지정됨 범위(min_value ~ max_value)를 균등한 구간 (buckets)을 나누어서 
--      해당하는 숫자값이 어떤 구간 (버킷)에 해당하는 지를 반환하는 함수 
SELECT 
     -- ename, sal
     WIDTH_BUCKET(sal, 0, 5001, 5) wb
    , COUNT(*) cnt
FROM emp
GROUP BY WIDTH_BUCKET(sal, 0, 5001, 5);
-- 실무 활용 사례 1. 고객 구매금액 등급
-- 실무 활용 사례 2. 연령대 분석
-- 실무 활용 사례 3. 시험 점수 분포
-- 실무 활용 사례 4. 급여 구간 분석

-- 차이점: NTILE(5) OVER(ORDER BY sal) 레코드 (행)수를 균등하게 분배해서 구간 나눔

-- [SET 연산자] + SQL 연산자 (ANY, SOME, ALL ,EXISTS) 정리
-- 예) emp 테이블에서 사원이 존재하지 않는 부서번호, 부서명 조회
WITH t AS (
    SELECT deptno
    FROM dept
    MINUS
    SELECT DISTINCT deptno
    FROM emp
)
SELECT t.deptno, d.dname
FROM t JOIN dept d ON t.deptno = d.deptno;

-- EXISTS 연산자 --
SELECT deptno
FROM dept m
WHERE NOT EXISTS (SELECT empno FROM emp WHERE deptno = m.deptno );

--
SELECT d.deptno, COUNT(empno)
FROM emp e RIGHT OUTER JOIN dept d ON e.deptno = d.deptno
GROUP BY d.deptno
HAVING COUNT(empno) = 0;