SELECT *
FROM tabs;

-- SET TERMOUT OFF;  -- Sql*plus 툴 스크립트 실행 결과를 화면에 출력하지 않는다
-- SET ECHO OFF;     -- 스크립트 안에있는 SQL 문장을 화면에 출력하지 않는다

SELECT *
FROM NLS_SESSION_PARAMETERS
WHERE PARAMETER = 'NLS_DATE_LANGUAGE';

ALTER SESSION SET nls_date_language='american';
-- Session이(가) 변경되었습니다.

SELECT PARAMETER, VALUE
FROM NLS_SESSION_PARAMETERS
WHERE PARAMETER = 'NLS_DATE_FORMAT';

ALTER SESSION SET nls_date_format='dd-MON-rr'; --일 월 년
-- Session이(가) 변경되었습니다.


DROP TABLE DEPT;

CREATE TABLE DEPT -- DEPT 테이블
(
    DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY, -- 부서번호
	DNAME VARCHAR2(14) , -- 부서명
	LOC VARCHAR2(13)     -- 위치
);

DROP TABLE EMP;

CREATE TABLE EMP  -- 사원 테이블
(
    EMPNO NUMBER(4) CONSTRAINT PK_EMP PRIMARY KEY, -- 사원번호
	ENAME VARCHAR2(10), 
	JOB VARCHAR2(9),
	MGR NUMBER(4),  -- 매니저(직속상사)의 사번
	HIREDATE DATE,
	SAL NUMBER(7,2), -- 기본급 (7,2) : 7자리의 소수점 둘째자리 까지 나타낸다
	COMM NUMBER(7,2), -- 커미션(수당)
	DEPTNO NUMBER(2) CONSTRAINT FK_DEPTNO REFERENCES DEPT -- DEPT 부서테이블의 부서번호 참조
);


INSERT INTO DEPT VALUES (10,'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30,'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40,'OPERATIONS','BOSTON');

INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,to_date('17-12-1980','dd-mm-yyyy'),800,NULL,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,to_date('20-2-1981','dd-mm-yyyy'),1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,to_date('22-2-1981','dd-mm-yyyy'),1250,500,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,to_date('2-4-1981','dd-mm-yyyy'),2975,NULL,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,to_date('28-9-1981','dd-mm-yyyy'),1250,1400,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,to_date('1-5-1981','dd-mm-yyyy'),2850,NULL,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,to_date('9-6-1981','dd-mm-yyyy'),2450,NULL,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,to_date('13-JUL-87')-85,3000,NULL,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',NULL,to_date('17-11-1981','dd-mm-yyyy'),5000,NULL,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,to_date('8-9-1981','dd-mm-yyyy'),1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,to_date('13-JUL-87')-51,1100,NULL,20);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,to_date('3-12-1981','dd-mm-yyyy'),950,NULL,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,to_date('3-12-1981','dd-mm-yyyy'),3000,NULL,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,to_date('23-1-1982','dd-mm-yyyy'),1300,NULL,10);

DROP TABLE BONUS;

CREATE TABLE BONUS
(
	ENAME VARCHAR2(10), -- 사원명
	JOB VARCHAR2(9),    -- 직업
	SAL NUMBER,         -- 기본급
	COMM NUMBER         -- 수당
);
    
DROP TABLE SALGRADE;

CREATE TABLE SALGRADE
( 
    GRADE NUMBER,   -- 등급
	LOSAL NUMBER,   
	HISAL NUMBER     
);
    
INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

COMMIT;

-- SET TERMOUT ON
-- SET ECHO ON
----------------------------------------------------------------
-- HR/lion 계정 생성 + 샘플 테이블 생성
-- 1)
--C:\app\user\product\21c\dbhomeXE\demo\schema
--    ㄴ human_resources 폴더
--        ㄴ hr_main.sql 파일

-- 2) CMD SYS 계정으로 접속  sqlplus / as sysdba
-- 3) EXPDB1 이동 ALTER SESSION SET CONTAINER = XEPDB1;

--SQL> @?/demo/schema/human_resources/hr_main.sql
--
--specify password for HR as parameter 1:
--1의 값을 입력하십시오: lion
--
--specify default tablespeace for HR as parameter 2:
--2의 값을 입력하십시오: users
--
--specify temporary tablespace for HR as parameter 3:
--3의 값을 입력하십시오: temp
--
--specify log path as parameter 4:
--4의 값을 입력하십시오: C:\app\user\product\21c\dbhomeXE\demo\schema\log
--
--
--PL/SQL 처리가 정상적으로 완료되었습니다.


--------------------------------------------------------------
-- [SQL]
1. Structed Query Language == 구조화된 질의 언어

    클라이언트도구                        오라클서버
    sqlplus.exe         질의/응답         
    sql developer     구조 질의 언어      
                          SQL(쿼리)

2. SQL 대상 : 테이블 또는 뷰

3. PL/SQL : 절차적인 언어(Procedural Language) + SQL
 오라클 에서만 존재

4. SQL 5가지 종류
    1) DQL : 조회(SELECT)
    2) DML : 조작(INSERT, UPDATE, DELETE) RENAME, TRUNCATE
            오라클은 기본 DML 문을 실행하면 모두 완료: COMMIT; (필수)
    3) DDL : 정의(CREATE, DROP, ALTER)
    4) DCL : 권한(GRANT, REVOKE)
    5) TCL : 트랜잭션
        예) 계좌이체 = [ A 계좌 출금 + B 계좌 입금 ] 논리적인 작업
                        (1)         (2)        모두 완료   COMMIT
                         O           X         모두 원위치 ROLLBACK
                         
-- SCOTT -- 

-- select 문
--   ㄴ 대상 : 
--   ㄴ 조회: 권한 O
--   ㄴ 선언 형식:

【형식】
    [subquery_factoring_clause] subquery [for_update_clause];

【subquery 형식】
   {query_block ¦
    subquery {UNION [ALL] ¦ INTERSECT ¦ MINUS }... ¦ (subquery)} 
   [order_by_clause] 

【query_block 형식】
   SELECT [hint] [DISTINCT ¦ UNIQUE ¦ ALL] select_list
   FROM {table_reference ¦ join_clause ¦ (join_clause)},...
     [where_clause] 
     [hierarchical_query_clause] 
     [group_by_clause]
     [HAVING condition]
     [model_clause]

【subquery factoring_clause형식】
   WITH {query AS (subquery),...}

-- SELECT 문: 7개의 절(clause) (실행 순서)

WITH [생략가능] 1
SELECT        6
FROM          2
WHERE         3
GROUP BY      4
HAVING        5
ORDER BY      7

-- 1) SCOTT 계정이 소유하고 있는 모든 테이블 정보를 확인하는 쿼리 작성

SELECT *
FROM all_tables;   -- 접근이 허용된 모든 테이블 정보
FROM dba_tables;   -- 데이터베이스에 존재하는 모든 테이블 정보
FROM user_tables;  -- 접속한 사용자(SCOTT) 소유의 테이블 정보
FROM tabs;

-- SQL
-- SQL 5가지 종류 : DQL, DDL, DML, DCL, TCL
-- DQL: SELECT (조회, 검색)
-- 7절 순서 (암기)

-- 스키마.객체명 (앞에 스키마 생략 가능)
DESC scott.emp;

SELECT e.*, empno, ename
FROM scott.emp e;

-- 모든 부서정보를 조회 
SELECT *
FROM dept;

-- 모든 직무 조회
SELECT count (DISTINCT job)
FROM EMP;

-- DISTINCT 키워드 : 중복을 제거하는 함수
SELECT ALL job, ename
FROM emp;

-- DISTINCT 하고 똑같다
SELECT UNIQUE job  
FROM emp;

-- 부서 테이블의 부서 번호만 출력 10 ~ 40
SELECT deptno
FROM dept;

-- 각 사원들이 속해 있는 부서번호를 조회
SELECT DISTINCT deptno
FROM emp;

-- 사원 정보를 조회(사원번호, 사원명, 입사일자)
SELECT empno, ename, hiredate
FROM emp;

-- null 값을 다른 값으로 대체해서 처리 (NVL)
-- 0 으로 대체해서 처리해보기

SELECT empno, ename, hiredate, sal, comm , NVL(comm,0)
        , sal + NVL(comm,0) as PAY -- 별칭(alias)
        , sal + NVL2(comm, comm, 0) PAY -- as 생략 가능
FROM emp;

-- 단일행 함수
SELECT ename, LOWER(ename)
FROM emp;

-- 복수행 함수
SELECT COUNT(*)
FROM emp;

SELECT '이름은 ''' || ename || '''이고, 잡은' || job || '입니다' as name_job
FROM emp;

-- null 처리 함수 : NVL(), NVL2()
-- [문제] 사원 테이블에서 직속상사가 없는 사원은 'CEO'라고 출력
--      (사원번호, 사원명, 직속상사)

SELECT empno, ename, NVL(to_char(mgr),'CEO') as supervisor
FROM emp;

-- emp 테이블에서 사원번호, 사원명, 입사일자, 부서번호 조회
-- (조건) 부서번호가 10번인 사람들만 조회

SELECT empno, ename, hiredate, deptno
FROM emp
WHERE deptno = 10;

-- 1) 실행 계획
EXPLAIN PLAN FOR 
SELECT empno, ename, hiredate, deptno
FROM emp
WHERE deptno = 10;

-- 2) 실행
SELECT *
FROM TABLE(DBMS_XPLAN.DISPLAY);

Plan hash value: 3956160932   -- 실행 계획의 고유 식별자

실행순서    수행 작업          객체명  예상결과             비용        옵티마이저
식별자                       인덱스    행    데이터크기  CPU+IO사용량  예상시간
--------------------------------------------------------------------------
| Id  | Operation         | Name | Rows  | Bytes | Cost (%CPU)| Time     |
--------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |      |     5 |   105 |     3   (0)| 00:00:01 |
|*  1 |  TABLE ACCESS FULL| EMP  |     5 |   105 |     3   (0)| 00:00:01 |
--------------------------------------------------------------------------
 
TABLE ACCESS FULL : 테이블의 전체를 스캔

-- 조건식
Predicate Information (identified by operation id):
---------------------------------------------------
 
   1 - filter("DEPTNO"=10)
   

-- [문제] emp 테이블에서 10번 부서 사원이 아닌 사원의 정보를 조회
-- (사원번호, 사원명, 입사일자, 부서번호)

SELECT empno, ename, hiredate, deptno
FROM emp
WHERE deptno IN (20,30,40); -- SQL 연산자 중 IN 연산자
WHERE deptno = 20 or deptno = 30 or deptno = 40;

-- JAVA 논리연산자 =     &&  || !
-- Oracle 논리연산자 =   AND OR NOT

WHERE NOT deptno = 10;
WHERE deptno <> 10;
WHERE deptno ^= 10;
WHERE deptno != 10;

---------------------------------------------------------------------------------
CREATE TABLE insa(
        num NUMBER(5) NOT NULL CONSTRAINT insa_pk PRIMARY KEY
       ,name VARCHAR2(20) NOT NULL
       ,ssn  VARCHAR2(14) NOT NULL
       ,ibsaDate DATE     NOT NULL
       ,city  VARCHAR2(10)
       ,tel   VARCHAR2(15)
       ,buseo VARCHAR2(15) NOT NULL
       ,jikwi VARCHAR2(15) NOT NULL
       ,basicPay NUMBER(10) NOT NULL
       ,sudang NUMBER(10) NOT NULL
);

INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1001, '홍길동', '771212-1022432', '1998-10-11', '서울', '011-2356-4528', '기획부', 
   '부장', 2610000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1002, '이순신', '801007-1544236', '2000-11-29', '경기', '010-4758-6532', '총무부', 
   '사원', 1320000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1003, '이순애', '770922-2312547', '1999-02-25', '인천', '010-4231-1236', '개발부', 
   '부장', 2550000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1004, '김정훈', '790304-1788896', '2000-10-01', '전북', '019-5236-4221', '영업부', 
   '대리', 1954200, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1005, '한석봉', '811112-1566789', '2004-08-13', '서울', '018-5211-3542', '총무부', 
   '사원', 1420000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1006, '이기자', '780505-2978541', '2002-02-11', '인천', '010-3214-5357', '개발부', 
   '과장', 2265000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1007, '장인철', '780506-1625148', '1998-03-16', '제주', '011-2345-2525', '개발부', 
   '대리', 1250000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1008, '김영년', '821011-2362514', '2002-04-30', '서울', '016-2222-4444', '홍보부',    
'사원', 950000 , 145000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1009, '나윤균', '810810-1552147', '2003-10-10', '경기', '019-1111-2222', '인사부', 
   '사원', 840000 , 220400);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1010, '김종서', '751010-1122233', '1997-08-08', '부산', '011-3214-5555', '영업부', 
   '부장', 2540000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1011, '유관순', '801010-2987897', '2000-07-07', '서울', '010-8888-4422', '영업부', 
   '사원', 1020000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1012, '정한국', '760909-1333333', '1999-10-16', '강원', '018-2222-4242', '홍보부', 
   '사원', 880000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1013, '조미숙', '790102-2777777', '1998-06-07', '경기', '019-6666-4444', '홍보부', 
   '대리', 1601000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1014, '황진이', '810707-2574812', '2002-02-15', '인천', '010-3214-5467', '개발부', 
   '사원', 1100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1015, '이현숙', '800606-2954687', '1999-07-26', '경기', '016-2548-3365', '총무부', 
   '사원', 1050000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1016, '이상헌', '781010-1666678', '2001-11-29', '경기', '010-4526-1234', '개발부', 
   '과장', 2350000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1017, '엄용수', '820507-1452365', '2000-08-28', '인천', '010-3254-2542', '개발부', 
   '사원', 950000 , 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1018, '이성길', '801028-1849534', '2004-08-08', '전북', '018-1333-3333', '개발부', 
   '사원', 880000 , 123000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1019, '박문수', '780710-1985632', '1999-12-10', '서울', '017-4747-4848', '인사부', 
   '과장', 2300000, 165000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1020, '유영희', '800304-2741258', '2003-10-10', '전남', '011-9595-8585', '자재부', 
   '사원', 880000 , 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1021, '홍길남', '801010-1111111', '2001-09-07', '경기', '011-9999-7575', '개발부', 
   '사원', 875000 , 120000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1022, '이영숙', '800501-2312456', '2003-02-25', '전남', '017-5214-5282', '기획부', 
   '대리', 1960000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1023, '김인수', '731211-1214576', '1995-02-23', '서울', NULL           , '영업부', 
   '부장', 2500000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1024, '김말자', '830225-2633334', '1999-08-28', '서울', '011-5248-7789', '기획부', 
   '대리', 1900000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1025, '우재옥', '801103-1654442', '2000-10-01', '서울', '010-4563-2587', '영업부', 
   '사원', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1026, '김숙남', '810907-2015457', '2002-08-28', '경기', '010-2112-5225', '영업부', 
   '사원', 1050000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1027, '김영길', '801216-1898752', '2000-10-18', '서울', '019-8523-1478', '총무부', 
   '과장', 2340000, 170000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1028, '이남신', '810101-1010101', '2001-09-07', '제주', '016-1818-4848', '인사부', 
   '사원', 892000 , 110000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1029, '김말숙', '800301-2020202', '2000-09-08', '서울', '016-3535-3636', '총무부', 
   '사원', 920000 , 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1030, '정정해', '790210-2101010', '1999-10-17', '부산', '019-6564-6752', '총무부', 
   '과장', 2304000, 124000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1031, '지재환', '771115-1687988', '2001-01-21', '서울', '019-5552-7511', '기획부', 
   '부장', 2450000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1032, '심심해', '810206-2222222', '2000-05-05', '전북', '016-8888-7474', '자재부', 
   '사원', 880000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1033, '김미나', '780505-2999999', '1998-06-07', '서울', '011-2444-4444', '영업부', 
   '사원', 1020000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1034, '이정석', '820505-1325468', '2005-09-26', '경기', '011-3697-7412', '기획부', 
   '사원', 1100000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1035, '정영희', '831010-2153252', '2002-05-16', '인천', NULL           , '개발부', 
   '사원', 1050000, 140000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1036, '이재영', '701126-2852147', '2003-08-10', '서울', '011-9999-9999', '자재부', 
   '사원', 960400 , 190000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1037, '최석규', '770129-1456987', '1998-10-15', '인천', '011-7777-7777', '홍보부', 
   '과장', 2350000, 187000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1038, '손인수', '791009-2321456', '1999-11-15', '부산', '010-6542-7412', '영업부', 
   '대리', 2000000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1039, '고순정', '800504-2000032', '2003-12-28', '경기', '010-2587-7895', '영업부', 
   '대리', 2010000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1040, '박세열', '790509-1635214', '2000-09-10', '경북', '016-4444-7777', '인사부', 
   '대리', 2100000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1041, '문길수', '721217-1951357', '2001-12-10', '충남', '016-4444-5555', '자재부', 
   '과장', 2300000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1042, '채정희', '810709-2000054', '2003-10-17', '경기', '011-5125-5511', '개발부', 
   '사원', 1020000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1043, '양미옥', '830504-2471523', '2003-09-24', '서울', '016-8548-6547', '영업부', 
   '사원', 1100000, 210000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1044, '지수환', '820305-1475286', '2004-01-21', '서울', '011-5555-7548', '영업부', 
   '사원', 1060000, 220000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1045, '홍원신', '690906-1985214', '2003-03-16', '전북', '011-7777-7777', '영업부', 
   '사원', 960000 , 152000);         
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1046, '허경운', '760105-1458752', '1999-05-04', '경남', '017-3333-3333', '총무부', 
   '부장', 2650000, 150000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1047, '산마루', '780505-1234567', '2001-07-15', '서울', '018-0505-0505', '영업부', 
   '대리', 2100000, 112000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1048, '이기상', '790604-1415141', '2001-06-07', '전남', NULL           , '개발부', 
   '대리', 2050000, 106000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1049, '이미성', '830908-2456548', '2000-04-07', '인천', '010-6654-8854', '개발부', 
   '사원', 1300000, 130000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1050, '이미인', '810403-2828287', '2003-06-07', '경기', '011-8585-5252', '홍보부', 
   '대리', 1950000, 103000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1051, '권영미', '790303-2155554', '2000-06-04', '서울', '011-5555-7548', '영업부', 
   '과장', 2260000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1052, '권옥경', '820406-2000456', '2000-10-10', '경기', '010-3644-5577', '기획부', 
   '사원', 1020000, 105000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1053, '김싱식', '800715-1313131', '1999-12-12', '전북', '011-7585-7474', '자재부', 
   '사원', 960000 , 108000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1054, '정상호', '810705-1212141', '1999-10-16', '강원', '016-1919-4242', '홍보부', 
   '사원', 980000 , 114000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1055, '정한나', '820506-2425153', '2004-06-07', '서울', '016-2424-4242', '영업부', 
   '사원', 1000000, 104000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1056, '전용재', '800605-1456987', '2004-08-13', '인천', '010-7549-8654', '영업부', 
   '대리', 1950000, 200000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1057, '이미경', '780406-2003214', '1998-02-11', '경기', '016-6542-7546', '자재부', 
   '부장', 2520000, 160000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1058, '김신제', '800709-1321456', '2003-08-08', '인천', '010-2415-5444', '기획부', 
   '대리', 1950000, 180000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1059, '임수봉', '810809-2121244', '2001-10-10', '서울', '011-4151-4154', '개발부', 
   '사원', 890000 , 102000);
INSERT INTO insa (num, name, ssn, ibsaDate, city, tel, buseo, jikwi, basicPay, sudang) VALUES
  (1060, '김신애', '810809-2111111', '2001-10-10', '서울', '011-4151-4444', '개발부', 
   '사원', 900000 , 102000);

COMMIT;
------------------------------------------------------------------

SELECT *
FROM insa;

-- CITY 컬럼: 사원 출신 치역
-- [문제] insa 테이블에서 수도권 출신 사원들이 몇명인지 조회하는 쿼리
SELECT count(*)
FROM insa
WHERE city IN ('서울','경기','인천');

-- [문제] insa 테이블에서 비수도권 출신 사원들이 몇명인지 조회하는 쿼리
SELECT count(*)
FROM insa
WHERE city NOT IN ('서울','경기','인천');

-- [문제]: emp 테이블에서 comm 이 null 인 사원의 정보를 모두 조회
SELECT *
FROM emp
WHERE comm IS null;
WHERE comm IS NOT null; -- SQL 연산자

-- [문제] emp 테이블에서 월급이 2000이상 4000이하를 받는 사원 정보 조회
--       (부서번호, 사원명, 잡, 월급)

SELECT empno, ename, job, sal + NVL(comm,0) as pay
FROM emp
WHERE sal + NVL(comm,0) BETWEEN 2000 AND 4000;