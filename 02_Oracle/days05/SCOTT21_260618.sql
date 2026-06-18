-- 예) emp 테이블에서 comm 이 400 이하인 사원의 정보 조회
--   (조건 : comm 이 null 인 사원도 포함)

SELECT *
FROM emp
WHERE comm < 400 or comm IS NULL ;

-- LNNVL() 함수 (Logically Negated NVL)
--  조건이 NULL 인 경우에  true 반환
--  조건이 false인 경우에도 true 반환

SELECT *
FROM emp
WHERE LNNVL(comm >= 400);

------------------------------------------------------------
-- SELECT 문 7가지 절
--WITH 1
--SELECT 6 
--FROM  2
--WHERE 3
--GROUP BY 4
--HAVING 5
--ORDER BY 7

-- 예) 각 부서별 사원수 조회
SELECT DISTINCT deptno
        ,(SELECT COUNT(*) FROM emp WHERE deptno = e.deptno) as 사원수
FROM emp e
UNION ALL
SELECT null, COUNT(*)
FROM emp
ORDER BY deptno;

-- GROUP BY 절
SELECT deptno, COUNT(*), SUM(sal + NVL(comm,0)) as sum ,ROUND(AVG(sal + NVL(comm,0)),2) as avg
FROM emp
GROUP BY deptno
ORDER BY deptno;

-- 예) 직속상사가 없는 사원의 번호를 null 로 수정
SELECT *
FROM emp
WHERE mgr is null;

UPDATE emp
SET deptno = null
WHERE empno = 7839;

COMMIT;


-- 사원이 존재하지 않는 부서도 출력
SELECT d.deptno, COUNT(empno) as count
FROM dept d FULL OUTER JOIN emp e ON d.deptno = e.deptno
GROUP BY d.deptno
ORDER BY d.deptno; 

-- [문제] insa 테이블에서 각 부서별 남자 사원수 조회
SELECT buseo, COUNT(*) as count
FROM insa
WHERE MOD(SUBSTR(ssn,-7,1),2) = 1
GROUP BY buseo
ORDER BY buseo;

-- 남자사원수가 5명 이상인 부서만
SELECT buseo, COUNT(*) as count
FROM insa
WHERE MOD(SUBSTR(ssn,-7,1),2) = 1
GROUP BY buseo
HAVING COUNT(*) >= 5
ORDER BY buseo;

-------------------------------------------------------------
-- 예) 각 부서별로 최고급여액을 받는 사원의 정보를 조회
-- 1) 상관 서브 쿼리 사용

SELECT *
FROM emp m
WHERE sal+NVL(comm,0) = (SELECT MAX(sal+NVL(comm,0)) FROM emp WHERE deptno IS NULL)
ORDER BY deptno;

SELECT *
FROM emp m
WHERE sal+NVL(comm,0) >= ALL (SELECT (sal+NVL(comm,0)) FROM emp WHERE deptno = m.deptno)
ORDER BY deptno;

-- GROUP BY 절 IN 연산자 (가장 많은 사용 경우) 
SELECT *
FROM emp e
WHERE (e.deptno, sal+NVL(comm,0)) IN(
    SELECT deptno, MAX(sal+NVL(comm,0))
    FROM emp
    GROUP BY deptno
)
ORDER BY e.deptno;

-- 급여순으로 등수  ,RANK() 함수
SELECT e.*
    ,sal + NVL(comm,0) pay
FROM emp e
ORDER BY pay DESC;

--
SELECT *
FROM(
    SELECT e.*
        ,RANK() OVER( ORDER BY sal + NVL(comm,0) DESC ) as pay_rank
    FROM emp e
) t
WHERE t.pay_rank <= 3;

-- 각 부서별 급여 1등 순위 사원 정보
SELECT t.deptno, t.pay_rank, empno, ename, sal + NVL(comm,0) as pay
FROM(
SELECT e.*
    , RANK() OVER( PARTITION BY deptno ORDER BY sal + NVL(comm,0) ) as pay_rank
FROM emp e
) t
WHERE pay_rank = 1;

--------------------------------------------------------------------------------
-- 예) 각 부서의 사원수 조회
SELECT COUNT (*) FROM emp WHERE deptno = 10;
SELECT COUNT (*) FROM emp WHERE deptno = 20;
SELECT COUNT (*) FROM emp WHERE deptno = 30;
SELECT COUNT (*) FROM emp WHERE deptno = 40;
SELECT COUNT (*) FROM emp WHERE deptno IS NULL;
--
SELECT 
         (SELECT COUNT (*) FROM emp WHERE deptno = 10) deptno_10
        ,(SELECT COUNT (*) FROM emp WHERE deptno = 20) deptno_20
        ,(SELECT COUNT (*) FROM emp WHERE deptno = 30) deptno_30
        ,(SELECT COUNT (*) FROM emp WHERE deptno = 40) deptno_40
        ,(SELECT COUNT (*) FROM emp WHERE deptno IS NULL) deptno_null
FROM dual;
-- DECODE() 수정
if(A = B){
    C
}
=> DECODE(A,B,C)

if(A = B){
    C
}else{
    D
}
=> DECODE(A,B,C,D)

if(A = B){
    ㄱ
}else if (A = C){
    ㄴ
}else if (A = D){
    ㄷ
}else{
    ㄹ
}
=> DECODE(A,B,ㄱ,C,ㄴ,D,ㄷ,ㄹ)

-- DECODE() 수정
SELECT 
         COUNT(DECODE(deptno,10,'O')) deptno_10
        ,COUNT(DECODE(deptno,20,1000)) deptno_20
        ,COUNT(DECODE(deptno,30,1)) deptno_30
        ,COUNT(DECODE(deptno,40,-1)) deptno_40
        -- DECODE 는 = 연산자만 사용 가능하기 떄문에 NULL 은 못쓴다
        -- ,COUNT(DECODE(deptno,NULL,00)) deptno_null (X)
FROM emp;

-- 예) insa 테이블에서 이름, 주민번호, 성별('남자','여자') 출력

-- CASE 함수
CASE 컬럼명|수식
    WHEN 조건 1 THEN 결과 1
    WHEN 조건 2 THEN 결과 2
    WHEN 조건 3 THEN 결과 3
    ELSE            결과
END 별칭

--

SELECT name, ssn
    , DECODE(MOD(SUBSTR(ssn,-7,1),2),'1','남자','여자') as gender
    , NVL2( NULLIF( MOD( SUBSTR(ssn, -7, 1) , 2 ) , 1 ), 'O', 'X') gender
    , REPLACE(REPLACE(MOD(SUBSTR(ssn, 8, 1) , 2 ), 1, 'X'), 0, 'O') gender
    , CASE(MOD( SUBSTR(ssn, -7, 1) ,  2 ))
        WHEN 1 THEN '남자'
        ELSE '여자'
     END gender_case
     ,CASE
        WHEN MOD( SUBSTR(ssn, -7, 1) , 2 ) = 1 THEN '남자'
        ELSE '여자'
      END gender_case
FROM insa;

-- 예) emp 테이블에서 모든 사원의 pay의 10% 인상해서 출력하는 쿼리
SELECT e.*
    , sal + NVL(comm,0) as pay
    , '10%' as increase_rate
    , (sal + NVL(comm,0)) * 1.1 as increase_pay
FROM emp e;

-- 예) 기본급을 10% 인상하는 UPDATE 문

-- UPDATE emp
-- SET sal = sal * 1.1;

-- 예) emp 테이블에서 10번 부서원은 sal 10% 인상, 20번 25%, 30번 15% 그 외는 인상 X
SELECT deptno , DECODE(deptno,10,'10%',20,'25%',30,'15%','X') as increase_rate
FROM emp
GROUP BY deptno
ORDER BY deptno;

SELECT deptno 
    , CASE
       WHEN deptno = 10 THEN '10%'
       WHEN deptno = 20 THEN '25%'
       WHEN deptno = 30 THEN '15%'
       ELSE '0%'
      END rate
      , sal * DECODE( deptno, 10,  1.1, 20 , 1.25, 30,  1.15 ) i_sal
      , sal * CASE deptno
                WHEN 10 THEN 1.1
                WHEN 20 THEN 1.25
                WHEN 30 THEN 1.15        
             END i_sal2 
FROM emp;

-- 예) 위와 같이 sal 인상률 만큼 UPDATE 하는 문 작성
-- UPDATE emp
-- SET sal = sal * DECODE( deptno, 10,  1.1, 20 , 1.25, 30,  1.15 );
 
-- 예) 설문조사
--        시작일 :  26.6.1 오전 6:00
--        종료일 :  26.6.18 낮 12:00
--    지금 설문이 가능한지 여부?
SELECT SYSDATE
        , TO_CHAR(SYSDATE, 'DS TS') -- 2026/06/18 오후 2:03:23
FROM dual;

--
SELECT TO_CHAR(SYSDATE, 'DS TS')
        -- ,TO_DATE( '26/06/01 09:00', 'YY/MM/DD HH24:MI') start_date
        ,TIMESTAMP '2026-03-20 09:00:00'
        ,TO_DATE( '26/06/17 18:00', 'YY/MM/DD HH24:MI') end_date
        , CASE
            WHEN SYSDATE < TIMESTAMP '2026-03-20 09:00:00'
                THEN '설문 시작 전'
           WHEN SYSDATE BETWEEN TO_DATE('26/06/01 09:00', 'YY/MM/DD HH24:MI')
                           AND TO_DATE('26/06/17 18:00', 'YY/MM/DD HH24:MI')
                THEN '설문 가능'
           WHEN SYSDATE > TO_DATE('26/06/17 18:00', 'YY/MM/DD HH24:MI')
                THEN '설문 종료'
           ELSE '설문 불가'
          END survey_status
FROM dual;

-----------------------------------------------------------------------------
-- 집계함수(컬럼) KEEP(DENSE_RANK FIRST | LAST ORDER BY 정렬컬럼)
-- 예) max 급여, min 급여 조회
SELECT MAX(sal), MIN(sal)
FROM emp;
-- 예) max급여: 사원번호, min 급여: 사원명 조회
SELECT
    deptno
    ,MAX(empno) KEEP(DENSE_RANK FIRST ORDER BY sal DESC) as max_pay_empno
    ,MIN(ename) KEEP(DENSE_RANK LAST ORDER BY sal DESC) as min_pay_empno
FROM emp
GROUP BY deptno;

-----------------------------------------------------------------------------
SELECT TRUNC(SYSDATE,'MONTH') + LEVEL -1
FROM dual
CONNECT BY LEVEL <= TO_CHAR(LAST_DAY(SYSDATE),'DD');

-----------------------------------------------------------------------------
-- [문제] insa 테이블에서 총사원수, 남자사원수, 여자사원수를 조회
-- 1)
SELECT 
    (SELECT COUNT(*) FROM insa) 총사원수
    ,(SELECT COUNT(*) FROM insa WHERE MOD(SUBSTR(ssn,-7,1),2) = 1) 남자사원수
    ,(SELECT COUNT(*) FROM insa WHERE MOD(SUBSTR(ssn,-7,1),2) = 0) 여자사원수 
FROM dual;
-- 2) SET 연산자 (UNION)
SELECT null as gender, COUNT(*) as cmt
FROM insa
UNION
SELECT '남자', COUNT(*)
FROM insa 
WHERE MOD(SUBSTR(ssn,-7,1),2) = 1
UNION
SELECT '여자', COUNT(*)
FROM insa 
WHERE MOD(SUBSTR(ssn,-7,1),2) = 0;
-- 3) DECODE 함수
SELECT 
    COUNT(*) 총사원수
    , COUNT(DECODE(MOD(SUBSTR(ssn,-7,1),2),1,'O'))
    , COUNT(DECODE(MOD(SUBSTR(ssn,-7,1),2),1,'O'))
FROM insa;
-- 4) CASE 함수
SELECT 
   COUNT(*) 총사원수
   , COUNT(CASE MOD(SUBSTR(ssn,-7,1),2)
                WHEN 0 THEN 'O'
        END
        ) 여자사원수
  , COUNT(CASE MOD(SUBSTR(ssn,-7,1),2)
                WHEN 1 THEN 'O'
        END
        ) 남자사원수
FROM insa;
-- 5) GROUP BY
SELECT 
        DECODE(MOD(SUBSTR(ssn,-7,1),2),1,'남자','여자') gender
--        , CASE MOD(SUBSTR(ssn,-7,1),2)
--            WHEN 1 THEN '남자'
--            ELSE '여자'
--          END gender2
        , COUNT(*)
FROM insa
GROUP BY MOD(SUBSTR(ssn,-7,1),2)
UNION
SELECT NULL, COUNT(*)
FROM insa;

-----------------------------------------------------------------------------
-- ROLLUP/ CUBE
SELECT MOD(SUBSTR(ssn,-7,1),2)
    ,COUNT(*)
FROM insa
GROUP BY ROLLUP(MOD(SUBSTR(ssn,-7,1),2));

-- 성별별 집계
-- 전체 집계 (추가)
-------------------------- GROUPING 함수 사용: 총계 행을 구분하기 위해서 사용
SELECT 
    CASE
        -- GROUPING () -ROLLUP/CUBE가 생성한 집계행 : 집계된 행이면 1 아니면 0
        WHEN GROUPING(MOD(SUBSTR(ssn,-7,1),2)) = 1 THEN '전체'
        WHEN MOD(SUBSTR(ssn,-7,1),2) = 1 THEN '남자'
        ELSE '여자'
    END gender
    ,COUNT(*)
FROM insa
GROUP BY ROLLUP(MOD(SUBSTR(ssn,-7,1),2));
----------------------------------------------------------------------------
SELECT deptno, job, sal
FROM emp;
--
-- 부서별로 그룹화 -> 급여합
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY deptno, job
UNION
SELECT deptno, null, SUM(sal)
FROM emp
GROUP BY deptno
UNIONㅁㄴㅇㄹㄴㅇㄹ
SELECT null,null,SUM(sal)
FROM emp;
ORDER BY deptno, job;
-----------------------------------
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY deptno, job;

-- GROUP BY ROLLUP(deptno, job), job
--         1) deptno + job 집계
--         2) deptno() 집계
--         3) () 집계


-- GROUP BY ROLLUP(deptno), job
--         1) deptno + job 집계
--         2) job 집계

-- GROUP BY GROUPING SET ((deptno,job),(job))
-----------------------------------------------------------------------------
-- FIRST_VALUE / LAST_VALUE 분석 함수
--FIRST_VALUE(칼럼) OVER (ORDER BY 정렬컬럼)
--LAST_VALUE(칼럼) OVER (ORDER BY 정렬컬럼)

SELECT ename, sal
--        , (SELECT MAX(sal) FROM emp)max_sal
        , FIRST_VALUE(sal) OVER (ORDER BY sal DESC)
        , LAST_VALUE(sal) OVER (ORDER BY sal DESC)
        ,LAST_VALUE(sal) OVER (
            ORDER BY sal DESC
            ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
            )
        -- 현재행 까지의 가장 작은 값
FROM emp;

-- 예) 부서별 최고 급여자 표시
SELECT deptno, ename, sal
        ,FIRST_VALUE(ename) OVER (PARTITION BY deptno ORDER BY sal DESC)
FROM emp;

-- RANK() OVER () X
-- 예) 로직으로 순위 매겨서 출력
SELECT deptno, empno, ename, sal
    , (SELECT COUNT (*)+1 FROM emp WHERE e.sal < sal) sal_rank
    , (SELECT COUNT (*)+1 FROM emp WHERE e.sal < sal AND deptno = e.deptno) sal_rank_deptno
FROM emp e
ORDER BY deptno, sal_rank_deptno;


-- [문제] insa 테이블에서 여자사원수가 5명 이상인 부서명, 사원수 조회..
SELECT buseo, count(*) as count
FROM insa
WHERE MOD(SUBSTR(ssn,-7,1),2) = 0
GROUP BY buseo
HAVING COUNT(*) >= 5
ORDER BY buseo;

-- [문제] emp 테이블에서 (사원 전체 평균 급여)보다 사원의 급여(pay)가 많으면 "많다", "적다" 출력.
-- 1) UNION/UNION ALL
SELECT AVG(sal + NVL(comm,0)) avg_pag
FROM emp;
--
SELECT emp.*, '많다'
FROM emp
WHERE  sal + NVL(comm,0) > ( SELECT AVG(sal + NVL(comm,0)) avg_pag FROM emp )
UNION
SELECT emp.*, '작다'
FROM emp
WHERE  sal + NVL(comm,0) < ( SELECT AVG(sal + NVL(comm,0)) avg_pag FROM emp );

-- 2) DECODE, CASE 함수
SELECT e.ename, e.pay, e.avg_pay
    , CASE
        WHEN e.pay > e.avg_pay THEN '많다'
        WHEN e.pay < e.avg_pay THEN '적다'
        ELSE '같다'
      END as pay_status
FROM(
    SELECT emp.*
                , sal + NVL(comm,0) pay
                , (SELECT AVG(sal + NVL(comm,0) ) FROM emp )  avg_pay
            FROM emp
) e;

SELECT ename
    ,sal + NVL(comm,0) as pay
    ,CASE
        WHEN sal + NVL(comm,0) > (SELECT AVG(sal + NVl(comm,0)) FROM emp) THEN '많다'
        ELSE '적다'
    END as result
FROM emp
ORDER BY pay;

-- 
SELECT SIGN(200) -- 양수면 1 음수면 -1 0이면 0
FROM dual;

-- 4) 권장
SELECT ename, pay
        , DECODE(SIGN(pay - avg_pay),1,'많다',-1,'작다','같다')
FROM(
    SELECT ename, sal + NVL(comm,0) as pay
          , AVG(sal + NVL(comm,0)) OVER() avg_pay
    FROM emp
);

-- AVG() 복수행(집계)함수: 한개의 행으로 줄어들어서 오류
-- AVG() OVER() : 모든 행 마다 전체 평균을 표시

SELECT deptno, ename, sal + NVL(comm,0) as pay
          , AVG(sal + NVL(comm,0)) OVER(PARTITION BY deptno) avg_pay
FROM emp;

-- [문제] insa 테이블에서
--   서울 출신 사원 중에 부서별 남자, 여자 사원수
--                           남자급여총합, 여자 급여총합 조회(출력)
-- [출력 형식]
--BUSEO            남자인원수   여자인원수   남자급여합    여자급여합     
----------------- ---------- ---------- ---------- ----------
--개발부                   0          2             1,790,000
--기획부                   2          1  5,060,000  1,900,000
--영업부                   4          5  6,760,000  6,400,000
--인사부                   1          0  2,300,000           
--자재부                   0          1               960,400
--총무부                   2          1  3,760,000    920,000
--홍보부                   0          1               950,000

-- 1) GROUP BY X
WITH temp as (
    SELECT * 
    FROM insa
    WHERE city = '서울'
)
SELECT DISTINCT
    buseo
--    ,(SELECT COUNT(*) FROM temp) 총 사원수
     ,(SELECT COUNT(DECODE( MOD(SUBSTR(ssn, -7, 1),2), 1, 'O' )) FROM  temp WHERE buseo = t.buseo) 남자사원수
     ,(SELECT COUNT(DECODE( MOD(SUBSTR(ssn, -7, 1),2), 0, 'O' )) FROM  temp WHERE buseo = t.buseo) 여자사원수  
     ,(SELECT SUM(DECODE( MOD(SUBSTR(ssn, -7, 1),2), 1, basicpay )) FROM  temp WHERE buseo = t.buseo ) 남급여합
     ,(SELECT SUM(DECODE( MOD(SUBSTR(ssn, -7, 1),2), 0, basicpay )) FROM  temp WHERE buseo = t.buseo ) 여급여합
FROM temp t
ORDER BY buseo;

-- 2) GROUP BY O
SELECT buseo,
       COUNT(CASE
                 WHEN MOD(SUBSTR(ssn,-7,1),2)=1 THEN 1
             END) AS 남자인원수,
       COUNT(CASE
                 WHEN MOD(SUBSTR(ssn,-7,1),2)=0 THEN 1
             END) AS 여자인원수,
       TO_CHAR(SUM(CASE
                    WHEN MOD(SUBSTR(ssn,-7,1),2)=1
                    THEN basicpay
                   END),
           'L999,999,999'
       ) AS 남자급여합,
       TO_CHAR(SUM(CASE
                    WHEN MOD(SUBSTR(ssn,-7,1),2)=0
                    THEN basicpay
                   END),
           'L999,999,999'
       ) AS 여자급여합
FROM insa
WHERE city = '서울'
GROUP BY buseo
ORDER BY buseo;


SELECT buseo
        , DECODE(MOD(SUBSTR(ssn,-7,1),2),1,'남자',0,'여자') 성별
       , COUNT(*) 인원수
       , TO_CHAR(SUM(basicpay),'L999,999,999') 급여합
FROM insa
WHERE city = '서울'
-- GROUP BY ROLLUP(buseo, MOD(SUBSTR(ssn,-7,1),2))
GROUP BY CUBE(buseo, MOD(SUBSTR(ssn,-7,1),2))
ORDER BY buseo, MOD(SUBSTR(ssn,-7,1),2);

-- 문제) emp 테이블에서 sal 기준으로 상위 20%에 해당되는 사원 정보 조회
SELECT FLOOR(COUNT(*) * 0.2)
FROM emp;
-- 풀이 1)
SELECT *
FROM (
    SELECT emp.*
    --    , RANK() OVER(ORDER BY sal DESC) sal_rank
    --    , DENSE_RANK() OVER(ORDER BY sal DESC) sal_rank
        , ROW_NUMBER() OVER(ORDER BY sal DESC) sal_rank
    FROM emp
)
WHERE sal_rank <= (SELECT FLOOR(COUNT(*) * 0.2) FROM emp);
-- 풀이 2)
-- PERCENT_RANK(): 현재 행의 순위가 전체 데이터에서 몇 %에 해당하는지 계산해 주는 분석함수
-- (순위-1) / (전체행수-1)
SELECT *
FROM(
    SELECT ename,sal
        , RANK() OVER(ORDER BY sal DESC) sal_rank
        , ROUND(PERCENT_RANK() OVER(ORDER BY sal DESC),2)*100 sal_parcent
    FROM emp
)
WHERE sal_parcent < 20;

-- PERCENT_RANK() / CUME_DIST() 차이점