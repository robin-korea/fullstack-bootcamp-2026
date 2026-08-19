-- SCOTT --
--------------------------------------------------------------------------------
-- [ 오라클 연산자(Operator) ]
--1. 비교 연산자: WHERE 절 사용, 숫자, 날짜, 문자 비교
--    (   =  !=^=<>      >   <    >=  <=   )
--------------------------------------------------------------------------------
-- 예) 입사일자를 기준으로 3분기에 입사한 사원들을 조회
SELECT e.*
      , TO_CHAR(hiredate, 'MM') h_month
      , extract(month from e.hiredate)h_month
      , TO_CHAR(hiredate, 'Q') h_quarter
FROM emp e
WHERE TO_CHAR(hiredate, 'Q') = 3;
WHERE TO_CHAR(hiredate, 'MM') BETWEEN 7 AND  9;
WHERE TO_CHAR(hiredate, 'MM') >= 7 AND  TO_CHAR(hiredate, 'MM') <= 9;
WHERE TO_CHAR(hiredate, 'MM') IN ( 7,8,9 );
-- 예) ename     C ~ S  사원 정보 출력
SELECT * 
FROM emp
WHERE ename BETWEEN 'C' AND 'T'
--WHERE REGEXP_LIKE( ename, '^[C-S]', 'i' )
--WHERE ename LIKE 'C%' OR .OR. OR ..  ename LIKE 'S%'
ORDER BY ename ASC;
-- 예) 1981년 6월 1일 이후 입사한  30번 부서원의 정보를 조회.
SELECT * 
FROM emp
WHERE hiredate >= DATE '1981-06-01' AND deptno = 30
-- WHERE hiredate >= TO_DATE('1981/06-01', 'YYYY/MM-DD') AND deptno = 30
-- WHERE hiredate >= '1981.06.01' AND deptno = 30
ORDER BY hiredate ASC;
-------------------------------------------------------------------------------- 
-- 2. 논리연산자: AND OR NOT
-------------------------------------------------------------------------------- 
-- 2. SQL연산자:  [NOT] IN ( 목록 ), NOT] BETWEEN a AND b , [NOT] LIKE 
-- , IS [NOT] NULL
-- 예) 수도권 아닌 사원 정보를 조회
SELECT * 
FROM insa
WHERE city NOT IN ('경기','서울','인천')
ORDER BY city ASC;
-- 예)
--------------------------------------------------------------------------------
-- 3) SET(집합)연산자
--    합집합(UNION, UNION ALL)
--    교집합(INTERSECT)
--    차집합(MINUS)
SELECT COUNT(*) -- 60명
FROM insa;
-- 1) 개발부 부서원수 : 14명
SELECT COUNT(*) -- 14명
FROM insa
WHERE buseo = '개발부';
-- 2) 출신지역이 '인천'인 사원수: 9명
SELECT COUNT(*) -- 9명
FROM insa
WHERE city = '인천';
-- 17명 = 14 + 9 = 23
SELECT name, ibsadate, buseo, city
FROM insa
WHERE buseo = '개발부'
UNION -- 합집합:  중복 제거
-- UNION ALL -- 합집합:  중복 포함
SELECT name, ibsadate, buseo, city
FROM insa
WHERE city = '인천';
--
SELECT name, ibsadate, buseo, city
FROM insa
WHERE buseo = '개발부' OR city = '인천';
-- 예) insa 테이블 사원 + emp 테이블 사원 합치고...
SELECT name, ibsadate, city, MOD(SUBSTR( ssn, -7, 1),2) gender 
FROM insa
UNION
SELECT ename, hiredate, null, null
FROM emp;
--ORA-01789: 질의 블록은 부정확한 수의 결과 열을 가지고 있습니다.
--01789. 00000 -  "query block has incorrect number of result columns"
--*Cause:    
--*Action:
-- 교집합
SELECT name, ibsadate, buseo, city
FROM insa
WHERE buseo = '개발부'
INTERSECT
SELECT name, ibsadate, buseo, city
FROM insa
WHERE city = '인천';
-- 
SELECT name, ibsadate, buseo, city
FROM insa
WHERE buseo = '개발부' AND city = '인천';

-- 차집합:  개발부 중에서 인천 출신은 제외: 14-6 = 8명
SELECT name, ibsadate, buseo, city
FROM insa
WHERE buseo = '개발부'
MINUS
SELECT name, ibsadate, buseo, city
FROM insa
WHERE city = '인천';
-- 예)
SELECT name, ibsadate, buseo, city
FROM insa
WHERE buseo = '개발부' AND city != '인천';
--------------------------------------------------------------------------------
-- 4) 계층적 질의 연산자: PRIOR, CONNECT_BY_ROOT 
--    ㄴ 계층적 질의(hierarchical query)
SELECT * 
FROM emp;
-- 예) 조인 문제:      deptno, ename, sal, dname, hiredate 조회 출력
--dept: deptno(PK), dname
--emp:  deptno(FK), ename, sal, hiredate
SELECT d.deptno, ename, sal,dname, hiredate
FROM dept d JOIN  emp e ON d.deptno= e.deptno;
--
SELECT d.deptno, ename, sal,dname, hiredate
FROM dept d ,  emp e 
WHERE d.deptno= e.deptno;

--【형식】 
--	SELECT 	[LEVEL] {*,컬럼명 [alias],...}
--	FROM	테이블명
--	WHERE	조건
--	START WITH 조건
--	CONNECT BY [PRIOR 컬럼1명  비교연산자  컬럼2명]
--		또는 
--		   [컬럼1명 비교연산자 PRIOR 컬럼2명]
-- 의사컬럼(가짜컬럼): LEVEL
SELECT  empno, ename, mgr,  LEVEL 
FROM emp
START WITH mgr IS NULL
CONNECT BY PRIOR empno = mgr ; -- TOP-DOWN 방식
-- 예) 공과대학 계층 구조 
DROP TABLE TBL_TEST ;
-- 
CREATE TABLE TBL_TEST(
  deptno number(3) not null primary key,
  dname varchar2(24) not null,
  college number(3),
  loc varchar2(10)
);
-- INSERT 문 
      deptno dname             college  loc
INSERT INTO tbl_test  VALUES ( 101, '컴퓨터공학과',   100,  '1호관' );
INSERT INTO tbl_test  VALUES ( 102, '멀티미디어학과',   100,  '2호관' );
INSERT INTO tbl_test  VALUES ( 201, '전자공학과',   200,  '3호관');
INSERT INTO tbl_test  VALUES ( 202, '기계공학과',   200,  '4호관');
INSERT INTO tbl_test  VALUES ( 100, '정보미디어학부',   10, null );
INSERT INTO tbl_test  VALUES ( 200, '메카트로닉스학부',   10, null );
INSERT INTO tbl_test  VALUES ( 10 , '공과대학', null, null );
COMMIT;
--
SELECT * 
FROM tbl_test;
--
SELECT deptno,dname,college,LEVEL
FROM tbl_test
START WITH deptno=10
CONNECT BY PRIOR deptno=college;
-- 
SELECT LPAD(' ', (LEVEL-1)*2) || dname 조직도
FROM tbl_test
-- WHERE dname != '정보미디어학부'  -- 정보미디어학부 는 제거.
START WITH dname='공과대학'
CONNECT BY PRIOR deptno=college AND dname != '정보미디어학부' ;
--------------------------------------------------------------------------------
-- 5) 연결 연산자(¦¦) 
-- 6) 산술 연산자
SELECT 3+5, 3-5, 3*5, 3/5
FROM dual;
--  dual: PUBLIC 시노님
SELECT * 
FROM user_tables
WHERE table_name LIKE 'EMP';
-- OWNER 소유자 SCOTT -> HR    emp 테이블 조회할 수 있도록 권한 부여...
-- DCL
GRANT SELECT ON emp  TO hr;
REVOKE
--
grant select on emp to public; 
--------------------------------------------------------------------------------
-- 복잡한 쿼리문을 간단하게 해주고 데이터의 값을 조작하는데 사용되는 것: [함수] function
-- ROUND(number, date): 숫자값을 특정 위치에서 반올림하여 리턴한다. 
SELECT 
    1.67895
    , ROUND( 1.67895 ) -- 소수점 1 자리
    , ROUND( 1.67895, 0 ) -- 소수점 b+1 자리
    , ROUND( 1.67895, 3 ) -- 소수점 b+1 자리
    , 12345
    , ROUND( 12345, -2 )
FROM dual;
-- TRUNC(NUMBER or DATE) : 절삭 + 지정한 위치
-- FLOOR(NUMBER) : 절삭 + 무조건 소수점 1 자리에서 절삭
SELECT 1.67895
      , TRUNC( 1.67895 )
      , TRUNC( 1.67895, 0 )
      , TRUNC( 1.67895, 3 ) -- b+1 위치에서 실제 절삭이 일어난다. 
      , TRUNC( 12395, -2 )
      , FLOOR( 1.67895 )
FROM dual;
-- 날짜 : ROUND( 날짜, 포맷 ), TRUNC() ~
-- 26/06/17
-- 2026/06/17 오후 12:04:05
SELECT SYSDATE
      , TO_CHAR( SYSDATE, 'DS TS' )
      , ROUND( SYSDATE )
      , ROUND( SYSDATE, 'year' ) -- 26/01/01
      , ROUND( SYSDATE, 'day' ) -- 26/06/21
FROM dual;
--
SELECT SYSDATE
      , TO_CHAR( SYSDATE, 'DS TS' ) a
--      , TRUNC( SYSDATE ) -- 시분초 00:00:00
--      , TO_CHAR( TRUNC( SYSDATE ), 'DS TS' )
--      , TO_CHAR( TRUNC( SYSDATE, 'YEAR' ), 'DS TS' )
       , TO_CHAR( TRUNC( SYSDATE, 'MONTH' ), 'DS TS' ) b
FROM dual;
-- CEIL() 함수: 올림(절상)  지정된위치X, 소수점 1 자리
SELECT CEIL( 12.345 ), CEIL( 12.745 )
FROM dual;
-- MOD() 나머지 함수
-- ABS() : 절대치
SELECT ABS(3 ), ABS(-3)
FROM dual;
-- SIGN() 함수: 숫자가 양수: 1, 음수: -1 반환..    0 반환
-- 예) 회사의 급여 평균 
SELECT ename, pay, avg_pay, SIGN(pay - avg_pay) s
FROM (  -- 인라인뷰(inline view)
        SELECT ename
            , sal + NVL(comm, 0) pay
            , ( SELECT ROUND( AVG(sal + NVL(comm, 0)), 2 )   FROM emp ) avg_pay
        FROM emp
) e;

-- 31225
-- 2230.357142857142857142857142857142857143
-- 2230.36
SELECT 
     SUM(sal + NVL(comm, 0)) sum_pay
     , AVG(sal + NVL(comm, 0)) avg_pay
     , ROUND( AVG(sal + NVL(comm, 0)), 2 ) 
FROM emp;

-- POWER(): 누승
SELECT POWER(2,3), POWER(2,-3)
      , SQRT(4), SQRT(2)
FROM dual;
-- 문자 함수   ''  
SELECT ename
     , LOWER(ename)
     , UPPER(ename)
     , INITCAP(ename)
     , LENGTH(ename)
     , CONCAT( ename , '입니다')
     , SUBSTR( ename, 1,2) || '***'
     , SUBSTR( ename, 3)
FROM emp;
-- INSTR(): 이름 속에 N 문자가 있는 위치를 파악
SELECT ename
     , INSTR( ename , 'N' )
     , INSTR( ename , 'NE' )
FROM emp;
--
SELECT 'ABCDEABCDEABCDE'
     , INSTR( 'ABCDEABCDEABCDE', 'CD' ) -- 앞에서부터 찾은 첫 번째 CD 위치값을 반환
     , INSTR( 'ABCDEABCDEABCDE', 'CD', 1, 2 )-- 앞에서부터 찾은 두 번째 CD 위치값을 반환
     , INSTR( 'ABCDEABCDEABCDE', 'CD', -1, 1 )-- 뒤에서부터 찾은 첫 번째 CD 위치값을 반환
FROM dual;
-- 예) 801007-1******
SELECT name, ssn
     , SUBSTR( ssn, 1, 8) || '******' rrn
     , SUBSTR( ssn, 1, INSTR(ssn, '-')+1 ) || '******' rrn
     , REGEXP_REPLACE( ssn, '(\d{6}-\d)\d{6}' , '\1' || '******' )
FROM insa;

--- LPAD()/ RPAD() 함수설명

SELECT ename
        , RPAD(ename, 10, '*')
        , LPAD(ename, 10, '*')
        , sal + NVL(comm, 0)
        , LPAD (sal + NVL(comm, 0),10,'*') as pay
FROM emp;

-- ASCII(char)
SELECT ename
        ,ASCII(SUBSTR(ename, -1))
FROM emp;

-- 나열한 세 숫자 중에 가장 큰 값을 반환하는 함수 GREATEST(1,2,3)
SELECT GREATEST(100,75,120)
        ,LEAST(100,75,120)
FROM dual;

--VSIZE(char) 지정된 문자열의 크기를 반환하는 함수
SELECT VSIZE('a'), VSIZE('한')
FROM dual;

-- RTRIM() / LTRIM()

SELECT '[   ADMIN   ]'
        ,'[' || LTRIM('   ADMIN  ') || ' ]'
        ,'[' || RTRIM('   ADMIN  ') || ' ]'
        ,'[' || TRIM(' ' FROM '   ADMIN  ') || ' ]'
        -- TRIM(제거할문자열 FROM 대상문자열)
FROM dual;

SELECT RTRIM('BROWINGyxXxyxyxyxyxy','xy') "RTRIM example"
FROM dual;

-- 날짜 함수
SELECT SYSDATE, CURRENT_TIMESTAMP
FROM dual;

-- MONTHS_BETWEEN 함수: 두 날짜 간의 달 차이를 리턴하는 함수

SELECT SYSDATE
    ,'2026.05.11'
    ,MONTHS_BETWEEN(SYSDATE,'2026.05.11')
FROM dyal;

-- emp 테이블에서 모든 사원들의 근무개월수를 조회
SELECT ename, ROUND(MONTHS_BETWEEN(SYSDATE,HIREDATE),2) as monthOfService
        , ROUND(MONTHS_BETWEEN(SYSDATE,HIREDATE)/12,2) as yearOfService
        , TRUNC(SYSDATE - hiredate) as 근무일수
FROM emp;

--날짜 + 숫자    = 날짜 (날짜에 일수를 더하여 날짜 계산)
--날짜 - 숫자    = 날짜 (날짜에 일수를 감하여 날짜 계산) 
--날짜 + 숫자/24 = 날짜 (날짜에 시간을 더하여 날짜 계산) 
--날짜 - 날짜    = 일수 (날짜에 날짜를 감하여 일수 계산)

SELECT SYSDATE + 10
        ,SYSDATE - 5
        ,TO_CHAR(SYSDATE + 3/24, 'DS TS')
FROM dual;

-- 예) 3달 후에 만나자
SELECT SYSDATE - 3 -- 오늘부터 3일 후
       , ADD_MONTHS(SYSDATE,3) -- 3개월 후
       , ADD_MONTHS(SYSDATE,-2) -- 2달 전
FROM dual;

-- 예) 이번 달 마지막 날 짜가 몇일인지 조회
SELECT SYSDATE
      , ADD_MONTHS(SYSDATE,1)
      , TO_CHAR(TRUNC(ADD_MONTHS(SYSDATE,1),'MONTH') - 1, 'DD')
      , LAST_DAY(SYSDATE)
FROM dual;

-- 예) 다음주 월요일은 휴강입니다
SELECT SYSDATE
    ,TO_CHAR(SYSDATE,'DAY')
    ,SYSDATE + 5
    ,NEXT_DAY(SYSDATE,'월요일')
FROM dual;

-- 예) 7월 첫번째 수요일 찾기
SELECT NEXT_DAY(TRUNC(ADD_MONTHS(SYSDATE,1),'MONTH'),'목요일')
        ,NEXT_DAY(TO_DATE('2026.07','YYYY.MM')-1,'수요일')
FROM dual;

-- 날짜/시간 함수
SELECT
      SYSDATE   -- 날짜/시간       DB 서버의 날짜/시간
    , CURRENT_DATE -- 날짜/시간    현재 세션의 날짜/시간
    , CURRENT_TIMESTAMP 
FROM dual;

--------------------------------------------------------------------------------
-- 변환 함수
-- 1) TO_NUMBER() 문자 -> 숫자 변환하는 함수
SELECT '123'- 123  -- 내부적으로 변환해준다
        ,'100.98' - 100
--        , '123AB' - 10 -- 오류
FROM dual;

-- 2) TO_CHAR(날짜): 날짜로 부터 내가 원하는 형식의 정보를 문자로 변환
--    TO_CHAR(숫자)

-- 예)
SELECT num,name
        ,TO_CHAR(basicpay, '99,999,999')
        ,TO_CHAR(sudang, '999,999')
        ,TO_CHAR(basicpay + sudang, 'L99G999G999') as pay
FROM insa;

--
SELECT TO_CHAR(100,'S9999')
    ,TO_CHAR(-100,'S9999')
    ,TO_CHAR(100,'9999MI')
    ,TO_CHAR(-100,'9999MI')
    ,TO_CHAR(-100,'9999PR') -- 음수일때 <> 붙임
FROM dual;

-- 예) 소수점 2자리 까지 연봉을 출력
SELECT ename
    ,TO_CHAR((sal + NVL(comm,0)) * 12,'L9,999,999.00')
FROM emp;

-- 문제) emp 테이블의 입사일자를 '1998년 10월 11일 일요일' 형식으로 출력
-- 날짜 -> 문자 변환: TO_CHAR(날짜 또는 숫자)

SELECT ename, hiredate
    ,TO_CHAR(hiredate,'YYYY"년" MM"월" DD"일" DAY')
FROM emp;

--------------------------------------------------------------
-- 일반함수
SELECT NVL(comm,0)
      , NVL2(comm,comm,0)
      , NULLIF(3,4) -- 2개가 같으면 null 다르면 A
      , COALESCE(comm,0) -- 나열해 놓은 값을 순차적으로 체크하여 NULL이 아닌 값을 리턴하는 함수
FROM emp;

SELECT COALESCE(NULL,NULL,100,200) - 100
FROM dual;

----------------------------------------------------------------
-- 그룹함수: COUNT() NULL 값을 제외한 집계
SELECT COUNT(comm)
       ,COUNT(*)
       ,SUM(sal)
       ,SUM(comm)
       ,AVG(sal)
       ,AVG(comm)   
       ,SUM(comm) / COUNT(*)
       ,MAX(comm), MAX(sal)
       ,MIN(comm), MIN(sal)
FROM emp;

-- 예) emp 테이블에서 pay (salary + comm)중 max min 조회해보기
SELECT MAX(sal + NVL(comm,0)) as max_pay
        ,MIN(sal + NVL(comm,0)) as min_pay
FROM emp;

-- 예) emp 테이블에서 pay 를 가장 많이 받는 사원의 이름, 번호, pay를  출력
SELECT empno,ename,sal + NVL(comm,0) as pay
FROM emp
WHERE sal + NVL(comm,0) = (
                            SELECT MAX(sal +  NVL(comm,0))
                            FROM emp
)
OR sal + NVL(comm,0) = (
                            SELECT MIN(sal +  NVL(comm,0))
                            FROM emp
);

SELECT *
FROM emp
WHERE sal + NVL(comm, 0 ) IN ( (SELECT MAX( sal + NVL(comm, 0 ) ) FROM emp), (SELECT MIN( sal + NVL(comm, 0 ) ) FROM emp) );

SELECT empno,ename,sal+NVL(comm,0) as pay
FROm emp
WHERE sal + NVL(comm,0) >= ALL (SELECT sal+NVL(comm,0) FROM emp);

-- 
