-- [문제] emp 테이블에서 월급이 2000이상 4000이하를 받는 사원 정보 조회
--       (부서번호, 사원명, 잡, 월급)

SELECT empno, ename, job, sal + NVL(comm,0) as pay
FROM emp
WHERE sal + NVL(comm,0) BETWEEN 2000 AND 4000
ORDER BY pay DESC;

-- 위의 쿼리를 WITH 절을 사용해서 처리
WITH empPay AS (
-- 서브쿼리
    SELECT empno, ename, job, sal + NVL(comm,0) as pay
    FROM emp
)
SELECT empPay.*
FROM empPay
WHERE empPay.pay BETWEEN 2000 AND 4000
ORDER BY empPay.pay ASC;

-- FROM (sub query) 별칭 : 인라인뷰(inline view)
SELECT e.*
FROM (
    SELECT empno, ename, job, sal + NVL(comm,0) as pay
    FROM emp
) e
WHERE e.pay BETWEEN 2000 AND 4000
ORDER BY e.pay ASC;

-- FROM (sub query) 별칭 : 인라인뷰(inline view)
SELECT *
FROM (
    SELECT empno, ename, job, sal + NVL(comm,0) as pay
    FROM emp
)
WHERE pay BETWEEN 2000 AND 4000
ORDER BY pay ASC;

-- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다
SELECT ename, COUNT(*)
FROM emp;

SELECT ename, LOWER(ename) ,UPPER(ename), INITCAP(ename)
FROM emp;

-- 문제)
-- insa 테이블에서 남자는 'X', 여자는 'O' 로 성별(gender) 출력하는 쿼리 작성   
--    NAME                 SSN            GENDER
--    -------------------- -------------- ------
--    홍길동               771212-1022432    X
--    이순신               801007-1544236    X
--    이순애               770922-2312547    O
--    김정훈               790304-1788896    X
--    한석봉               811112-1566789    X 
--    :

SELECT name,
        ssn,
        CASE
            WHEN SUBSTR(ssn,8,1) IN ('1','3') THEN 'X'
            ELSE 'O'
            END as gender
FROM insa;

SELECT name, ssn
    , MOD(SUBSTR(ssn,-7,1),2) as gender
--    , REPLACE(MOD(SUBSTR(ssn,-7,1),2),1,'X') as gender
    ,NULLIF(MOD(SUBSTR(ssn,-7,1),2),0)
    ,NVL2(NULLIF(MOD(SUBSTR(ssn,-7,1),2),0),'X','O') as gender
FROM insa;

SELECT name, ssn,
        SUBSTR(ssn,1,6) RRN6
        ,TO_DATE(SUBSTR(ssn,1,6)) BIRTHDAY
        ,TO_CHAR(TO_DATE(SUBSTR(ssn,1,6)), 'YYYY') year
        ,TO_CHAR(TO_DATE(SUBSTR(ssn,1,6)), 'MM') month
        ,TO_CHAR(TO_DATE(SUBSTR(ssn,1,6)), 'DD') day
        -- 날짜 타입으로 부터 날짜정보를 얻어올때 EXTRACT() 함수도 사용할 수 있다
        ,EXTRACT(YEAR FROM TO_DATE(SUBSTR(ssn,1,6))) as b_year
        ,EXTRACT(MONTH FROM TO_DATE(SUBSTR(ssn,1,6))) as b_month
        ,EXTRACT(DAY FROM TO_DATE(SUBSTR(ssn,1,6))) as b_day
--        ,SUBSTR(ssn,-7)
--        ,SUBSTR(ssn,0,2)
--        ,SUBSTR(ssn,3,2)
--        ,SUBSTR(ssn,5,2)
FROM insa;

----------------------------------
-- 산술연산자 확인
SELECT DISTINCT 3+5
FROM dept;

-- 나머지 구해주는 % 연산자 없지만 MOD() 함수는 있다
SELECT 3 + 5, 3 - 5, 3 * 5, 3 / 5
FROM dual;

-----------------------------------------------
-- REPLACE() 함수
SELECT REPLACE ('aaaaa','a','b') as bbbbb
        ,REPLACE ('aaaaaaa','a') as bbbb
FROM dual;

-----------------------------------------------
-- NULLIF() 함수
SELECT NULLIF(1,1) -- 같으면 null
      ,NULLIF(1,2) -- 다르면 첫번째값
FROM dual;

-----------------------------------------------
-- insa 테이블에서 70년대(70~79년생) 12월생 모든 사원 정보를 조회
--- LIKE 연산자
SELECT name, ssn
FROM insa
WHERE REGEXP_LIKE (ssn, '^7.12')
WHERE REGEXP_LIKE (ssn, '^7\d12')
WHERE REGEXP_LIKE (ssn, '^7[0-12]12')
--WHERE ssn LIKE '7_12%'
--WHERE SUBSTR(ssn,1,1) = 7 AND SUBSTR(ssn,3,2) = 12
ORDER BY ssn ASC;

SELECT deptno, sal + NVL(comm , 0) as pay, ename, hiredate
FROM emp
ORDER BY 1,2 DESC;
--ORDER BY deptno , pay DESC;

-- [문제] insa 테이블에서 70년대 남자만 조회(이름, 주민번호)
-- 1) LIKE 연산자
SELECT name, ssn
FROM insa
WHERE ssn LIKE '7______1%'
    OR ssn LIKE '7______3%'
    OR ssn LIKE '7______5%'
    OR ssn LIKE '7______7%'
    OR ssn LIKE '7______9%';
    
-- 2) REGEXP_LIKE 연산자    
SELECT name, ssn
FROM insa
WHERE REGEXP_LIKE (ssn,'^7\d{5}-[13579]');

-- [문제] emp 테이블의 ename 에 la/La/lA/LA 라는 문자열이 포함된 사원의 정보를 조회

-- 1) LIKE
SELECT ename
FROM emp
WHERE LOWER(ename) LIKE '%la%';

-- 2) REGEXP_LIKE()
SELECT ename
FROM emp
WHERE REGEXP_LIKE (ename, 'la','i');

-- LIKE 연산자 + ESCAPE 문
SELECT ename
FROM emp
WHERE ename LIKE '%LE%';

-- AL**N
-- MIL**R
SELECT ename
    , REPLACE(ename, 'LE', '**')
--    , REGEXP_REPLACE(source_string, pattern, replace_string, position = 1, occurrence = 0, match_parameter)
    , REGEXP_REPLACE(ename,'LE','**',1,0,'i') 
FROM emp
WHERE ename LIKE '%LE%';

UPDATE emp
SET ename = REPLACE(ename,'LE', '**')
WHERE ename LIKE '%LE%';

SELECT ename
FROM emp;

-------------------------------------------------------------------------------
SELECT ename,job,sal 
FROM emp p
WHERE deptno IN (
                SELECT deptno 
                FROM dept
                WHERE deptno = p.deptno
                );
                
SELECT ename,job,sal 
FROM emp p
WHERE NOT EXISTS(
                SELECT 'X'
                FROM dept
                WHERE deptno = p.deptno
                );
                
---------------------------------------------------------------
SELECT num, name
FROM insa
--WHERE name LIKE '김%';
--WHERE name LIKE '_김_';
--WHERE name LIKE '%김';
--WHERE name LIKE '김_';
WHERE name LIKE '김%';

-- 조인(Join)
사원테이블
사번 사원명 입사일자 ... 부서명 부서번호 부서장   부서번호(FK)
1001 홍길동           영업부  101    김기수      10
1002 홍길동           영업부  101    김기수      10
1003 홍길동           영업부  101    김기수      10
1004 홍길동           영업부  101    김기수      10
1001 홍길동           영업부  101    김기수      10

부서테이블
부서번호(PK) 부서명 부서번호 부서장
10         영업부  101   서영학
20         총무부  102   정창기
30         생산부  103   홍길동
40         기술부  104   서영민
-- 사원정보  사번 사원명 부서명
-- emp : empno, ename  자식테이블
-- dept: dname         부모테이블

SELECT emp.empno, emp.ename, dept.dname
FROM dept, emp -- 오라클 전통 조인(Old Style Join) oracle 8i ~
WHERE dept.deptno = emp.deptno;
--
SELECT e.empno, e.ename, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno;

SELECT empno, ename, dname, e.deptno
FROM dept d, emp e
WHERE d.deptno = e.deptno AND d.deptno = 10;

-- ANSI JOIN(표준 조인) JOIN ~ ON 구문
SELECT empno, ename, dname, e.deptno
FROM dept d JOIN emp e ON d.deptno = e.deptno
WHERE d.deptno = 10;

-- 오늘 날짜/시간 조회하는 쿼리
SELECT SYSDATE, CURRENT_TIMESTAMP
FROM dual;

-- SYSDATE 함수 + TO_DATE 함수 : 내가 원하는 날짜/시간 정보 출력
-- TO_CHAR(): 숫자, 날짜 -> 문자 형변환하는 함수
-- 숫자 100은 오른쪽정렬 문자 100은 왼쪽정렬
SELECT 100, TO_CHAR(100)
FROM dual;

--
SELECT SYSDATE
        ,TO_CHAR(SYSDATE, 'YYYY') YEAR
        ,TO_CHAR(SYSDATE, 'MM') MONTH
        ,TO_CHAR(SYSDATE, 'MONTH') MONTH
        ,TO_CHAR(SYSDATE, 'MON') MONTH
        ,TO_CHAR(SYSDATE, 'DD') DAY
        -- 시간, 분, 초, 요일
        ,TO_CHAR(SYSDATE, 'HH24') TIME
        ,TO_CHAR(SYSDATE, 'MI') MINUTE 
        ,TO_CHAR(SYSDATE, 'SS') SECOND
        ,TO_CHAR(SYSDATE, 'DY') DAY
        ,TO_CHAR(SYSDATE, 'DAY') DAY
        -- 오전/오후
        ,TO_CHAR(SYSDATE, 'AM') AM
        ,TO_CHAR(SYSDATE, 'DL') DL
        ,TO_CHAR(SYSDATE, 'DS') DS
        -- 주
        ,TO_CHAR(SYSDATE, 'W') W    -- 셋째주 3
        ,TO_CHAR(SYSDATE, 'WW') WW  -- 년중에는 24번째 주
        ,TO_CHAR(SYSDATE, 'IW') IW  -- 25번째 주
FROM dual;

-------------------------------------------------------
-- DML 문: UPDATE 문
SELECT *
FROM dept;
--
DESC dept;
--DEPTNO NOT NULL NUMBER(2)    
--DNAME           VARCHAR2(14) 
--LOC             VARCHAR2(13) 

-- 새로운 부서를 한게 추가: INSERT 문
INSERT INTO 테이블명(컬럼명...) VALUES (컬럼값...);
INSERT INTO dept(deptno, dname, loc) VALUES (50,'QC','SEOUL');
INSERT INTO dept VALUES (60,'Engineering','POHANG');
-- SQL 오류: ORA-00947: 값의 수가 충분하지 않습니다
INSERT INTO dept VALUES (70, null, null);
INSERT INTO dept (deptno) VALUES (70);

COMMIT;

SELECT *
FROM dept;

-- 70번 부서의 부서명(PRODUCTION), 지역명(SEOUL) 수정 (UPDATE)
UPDATE dept
SET dname = 'PRODUCTION' , loc = 'SEOUL'
WHERE deptno = 70;

ROLLBACK;

UPDATE dept
SET dname = 'PRODUCTION' , loc = 'SEOUL'
WHERE deptno = 70;

SELECT *
FROM dept;

COMMIT;

-- 새로 추가된 부서 삭제: DML - DELETE문
DELETE dept
WHERE deptno IN (50,60,70);
-- WHERE deptno >= 50;

-- 문제) 부서명  pro 문자열이 포함된 부서를 검색한 후에 삭제
-- 1) 부서검색
SELECT dname
FROM DEPT
WHERE LOWER(dname) LIKE '%pro%';

-- 2) 해당 부서 삭제
--DELETE dept
--WHERE deptno = 10;

-- [문제] 50번 새로운 부서 추가 
--  조건  부서명을 30번 부서명의+2 를 붙여서 추가
--       지역명은 40번 부서명의 지역명과 동일하게 추가

UPDATE dept
SET dname = dname || '2', loc = (SELECT loc FROM dept WHERE deptno = 40)
WHERE deptno = 50;


-- [문제] 50(가장 큰 부서번호 + 10)번 새로운 부서를 추가할 예정
--      부서명   30번 부서의 부서명, 지역명과 동일하게

SELECT dname, loc
FROM dept
WHERE deptno = 30;

--
INSERT INTO dept VALUES (
            (SELECT MAX(deptno) + 10 FROM dept)
            ,(SELECT dname FROM dept WHERE deptno = 30)
            ,(SELECT loc FROM dept WHERE deptno = 30)
                );
                
----

UPDATE dept
SET (dname, loc) = (SELECT dname, loc FROM dept WHERE deptno = 40)
WHERE deptno = 50;

COMMIT;

SELECT *
FROM dept;

DELETE FROM dept
WHERE deptno = 50;

-------------------------------------------------------------
INSERT INTO dept VALUES (  
  ( SELECT MAX( deptno ) + 10 FROM dept) ,
  ( SELECT dname FROM dept WHERE deptno= 30 ), 
  ( SELECT loc FROM dept WHERE deptno= 30 )
                          );
-- PL/SQL 사용해서 처리
DECLARE
 -- 변수 선언
 vdeptno NUMBER(2);
 vdname VARCHAR2(14);
 vloc   VARCHAR2(15);
BEGIN
 -- 실행명령문: INSERT, UPDATE, DELETE, SELECT 여러개
 SELECT MAX( deptno ) + 10 INTO vdeptno FROM dept;
 SELECT dname || '2' INTO vdname FROM dept WHERE deptno= 30;
 SELECT loc INTO vloc FROM dept WHERE deptno= 40;
 
 INSERT INTO dept VALUES (vdeptno, vdname, vloc);
 COMMIT;
-- EXCEPTION
 -- 예외 처리 블록
END;

DELETE FROM dept 
WHERE deptno = 50;
COMMIT;

-- [문제] emp 테이블의 모든 사원의 sal 기본급을 20% 인상하는 update 문

SELECT sal
FROM emp;

UPDATE emp
SET sal = sal * 1.2;

-- TBL_TEST 테이블 만들어보기
SELECT *
FROM tbl_test;

-- 문제) 이베일의 .co.kr -> .com 으로 수정(UPDATE)
--   (힌트) REPLACE(), REGEXP_REPLACE()

UPDATE tbl_test
SET email =  REPLACE(email,'.co.kr','.com')
WHERE email LIKE '%.co.kr';
