-- ■ [문제] 
-- DDL 문 : CREATE 
CREATE TABLE tbl_pivot
(
--    컬럼명 자료형(크기)       제약조건...
     no    NUMBER            PRIMARY KEY -- 고유한키(PK) 제약조건 = UK + NN
   , name  VARCHAR2(20 BYTE) NOT NULL    -- NN 제약조건(== 필수입력사항)
   , jumsu NUMBER(3)         -- NULL 허용
); 
-- Table TBL_PIVOT이(가) 생성되었습니다.
INSERT INTO TBL_PIVOT ( no, name, jumsu ) VALUES ( 1, '박예린', 90 );  -- kor
INSERT INTO TBL_PIVOT ( no, name, jumsu ) VALUES ( 2, '박예린', 89 );  -- eng
INSERT INTO TBL_PIVOT ( no, name, jumsu ) VALUES ( 3, '박예린', 99 );  -- mat
 
INSERT INTO TBL_PIVOT ( no, name, jumsu ) VALUES ( 4, '안시은', 56 );  -- kor
INSERT INTO TBL_PIVOT ( no, name, jumsu ) VALUES ( 5, '안시은', 45 );  -- eng
INSERT INTO TBL_PIVOT ( no, name, jumsu ) VALUES ( 6, '안시은', 12 );  -- mat 
 
INSERT INTO TBL_PIVOT ( no, name, jumsu ) VALUES ( 7, '김민', 99 );  -- kor
INSERT INTO TBL_PIVOT ( no, name, jumsu ) VALUES ( 8, '김민', 85 );  -- eng
INSERT INTO TBL_PIVOT ( no, name, jumsu ) VALUES ( 9, '김민', 100 );  -- mat 

COMMIT; 
---

SELECT *
FROM (
  SELECT name
        ,CASE ROW_NUMBER() OVER(PARTITION BY name ORDER BY no)
            WHEN 1 THEN '국'
            WHEN 2 THEN '영'
            WHEN 3 THEN '수'
        END as subject 
        ,jumsu
  FROM tbl_pivot
)
PIVOT (
    MAX(jumsu)
    FOR subject
    IN ('국','영','수')
);


--( 피봇되어져서 결과 출력)
--번호 이름 국 영 수
--1 박예린 90 89 99
--2 안시은 56 45 12
--3 김민   99 85 100


----------------------------------------------------------------------------
--롤 부서별, 직무별, 사원수를 조회 하는 쿼리

SELECT d.deptno,
       d.dname,
       e.job,
       COUNT(*) AS emp_cnt
FROM dept d LEFT OUTER JOIN emp e ON d.deptno = e.deptno
GROUP BY d.deptno, d.dname, e.job
ORDER BY d.deptno, e.job;

-- 
SELECT DISTINCT job
FROM emp;

-- 안나오는 job 도 다 나오게 하기
WITH jobs AS(
    SELECT DISTINCT job
    FROM emp
)
SELECT 10, j.job, COUNT(empno)
FROM emp e RIGHT OUTER JOIN jobs j ON e.job = j.job AND e.deptno = 10
GROUP BY deptno, j.job
UNION ALL
SELECT 20, j.job, COUNT(empno)
FROM emp e RIGHT OUTER JOIN jobs j ON e.job = j.job AND e.deptno = 20
GROUP BY deptno, j.job
UNION ALL
SELECT 30, j.job, COUNT(empno)
FROM emp e RIGHT OUTER JOIN jobs j ON e.job = j.job AND e.deptno = 30
GROUP BY deptno, j.job;

-- Oracle PARTITIONED RIGHT OUTER JOIN 
--    ㄴ OUTER JOIN의 확장된 기능
--    ㄴ 부서별로 각 10/20/30 등 파티션을 나누고 파티션 별로 OUTER JOIN
--    ㄴ 각 부서별 직무가 없는 정보고 출력할 떄 많이 사용한다
--    ㄴ 형식
--    FROM 사원 PARTITION BY(컬럼명) RIGHT/LEFT/FULL OUTER JOIN 직문 j ON 조인조건

--
WITH jobs AS(
    SELECT DISTINCT job
    FROM emp
)
SELECT deptno, j.job, COUNT(empno)
FROM emp e PARTITION BY (deptno) RIGHT OUTER JOIN jobs j ON e.job = j.job
GROUP BY deptno, j.job
ORDER BY deptno, j.job;
--------------------------------------------------------------------------------
--[실무 활용]
--Partitioned Outer Join은 주로 데이터 웨어하우스(DW) 나 통계 보고서에서 사용됩니다.
--
--예시:
--
--월별 매출 집계
--일별 접속 통계
--부서별 직급 현황
--상품별 월별 판매 실적
--고객별 구매 이력

-- 문제: emp 테이블에서 각 년도별 입사한 사원수 
SELECT TO_CHAR(hiredate, 'YYYY') as h_year, COUNT(ename)
FROM emp
GROUP BY TO_CHAR(hiredate, 'YYYY')
ORDER BY h_year;

-- 각 년도별, 월별 입사한 사원수 조회
SELECT TO_CHAR(hiredate, 'YYYY') as h_year 
        , TO_CHAR(hiredate, 'MM') as h_month
        , COUNT(ename)
FROM emp
GROUP BY TO_CHAR(hiredate, 'YYYY'), TO_CHAR(hiredate, 'MM')
ORDER BY h_year, h_month;

-- PARTITION BY 써서 월 다 출력해보기
SELECT e.h_year, m.month, COUNT(empno)
    FROM(
      SELECT empno
            , TO_CHAR(hiredate, 'YYYY') as h_year 
            , TO_CHAR(hiredate, 'MM') as h_month
      FROM emp
    ) e
    PARTITION BY (e.h_year)
    RIGHT OUTER JOIN (
        SELECT LEVEL month
        FROM dual
        CONNECT BY LEVEL <= 12
    ) m
    ON e.h_month = m.month
GROUP BY e.h_year, m.month
ORDER BY e.h_year, m.month;

-- WITH 절로 풀어보기
WITH e AS (
        SELECT empno
                    , TO_CHAR( hiredate, 'YYYY') h_year
                    , TO_CHAR( hiredate, 'MM') h_month
              FROM emp
    )
    , m AS (
        SELECT LEVEL month
        FROM dual
        CONNECT BY LEVEL <= 12
    )
SELECT e.h_year, m.month , COUNT(empno)
FROM e PARTITION BY ( e.h_year ) RIGHT JOIN   m ON e.h_month = m.month
GROUP BY e.h_year, m.month      
ORDER BY e.h_year, m.month;

------------------------------------------------------------------------------
-- 오라클 자료형

-- 1) CHAR[(size [BYTE|CHAR])]: 고정길이, 1~2000 바이트
-- CHAR
-- CHAR(1)
-- CHAR (1 BYTE)
-- CHAR (1 CHAR)

create table tbl_char (aa char, bb char(3), cc char(3 char));
-- CHAR == CHAR(1) == CHAR(1 BYTE)
-- CHAR(3) == CHAR(3 BYTE)
INSERT INTO tbl_char VALUES('한','abc','abc');

-- CHAR(3) CHAR(3 CHAR) 차이점
--             ㄴ 한글 3문자 집어넣음

-- 2) NCHAR([SIZE]): N 유니코드 + CHAR, 고정길이, 1~2000 바이트 
-- NCHAR == NCAHR(1)

-- 3) VARCHAR2(SIZE [BYTE|CHAR]): VAR + CHAR: 가변길이, 1~4000 바이트
--    VARCHAR2(100) == VARCHAR2(100 BYTE)

-- 4) NVARCHAR2(SIZE): N(유니코드) + VARCHAR, 1~4000 바이트

-- 5) NUMBER[(p,[s])]   숫자(정수,실수)
--            p: precision 정밀도  1~38
--            s: scale          -84~127
--  NUMBER == NUMBER(38,127) NUMBER에 아무값도 안 지정한 경우 최대값 자동 저장
CREATE TABLE tbl_number (
    kor NUMBER(3) -- NUMBER(3,0)
    ,avg NUMBER(5,2)
); 

INSERT INTO tbl_number VALUES(9.72,88.78); -- 소수점 1번째 반올림
INSERT INTO tbl_number VALUES(9.123,88.78);
INSERT INTO tbl_number VALUES(9.12,88.78);
INSERT INTO tbl_number VALUES(999.499,88.78);
INSERT INTO tbl_number VALUES(999,88.78);
INSERT INTO tbl_number VALUES(-999,-88.78);

SELECT * FROM tbl_number;

--6) FLOAT[(p)] : 숫자를 나타내는 자료형 (잘안씀)

--7) LONG : 가변길이 문자열, 2GB 까지 저장가능
-- 예) 게시판 글 내용 LONG 2GB 가변길이 문자열 저장

-- 8) DATE 날짜/시간: 년/월/일/시간/분/초 정보를 저장
--    TIMESTAMP:                    + 나노초 + 시간대

-- 9) RAW(size) : 이진데이터   2000바이트
--    ,LONG RAW :            2GB

-- 10) LOB == Large OBject
-- CLOB   Char + 문자열
-- NCLOB  NChar + 문자열
-- BLOB   Binary + 문자열

-- 11) BFILE : 2진 데이터 + 외부 파일형식으로 저장 (4GB)

-- 테이블 생성, 수정, 삭제
--        DDL문: CREATE, ALTER, DROP
--          생성: CREATE TABLE
--          수정: ALTER TABLE
--          삭제: DROP TABLE

-- 예) 아이디/이름/나이/연락처/생일/비고
-- 회원을 구분할 수 있는 고유한 키 (PK): 아이디/
-- 아이디 id   문자 (가변길이)   VARCHAR2(10)
-- 이름 name   문자 (가변길이)   VARCHAR2(20)
-- 나이 age    숫자 (정수)      NUMBER(3)
-- 연락처 tel   문자 (가변길이)  VARCHAR2(20)
-- 생일 birth  날짜            DATE
-- 비고 etc    문자  (가변길이)  LONG 

-- tbl_sample 테이블 생성 전 확인
SELECT *
FROM tabs
WHERE REGEXP_LIKE(table_name,'^tbl_sam','i');
WHERE table_name LIKE 'TBL\_SAMPLE' ESCAPE '\';

-- tbl_sample 테이블 생성
CREATE TABLE tbl_sample(
    id VARCHAR2(10) PRIMARY KEY 
    ,name VARCHAR2(20)
    , age NUMBER(3)
    -- 연락처 tel   문자 (가변길이)  VARCHAR2(20) 테이블 생성 후 컬럼 추가
    ,birth DATE
    -- 비고 etc    문자  (가변길이)  LONG 
);

SELECT *
FROM tbl_sample;

-- 테이블 생성 후에 컬럼을 추가 (연락처, 비고 컬럼)
-- alter table ... add 컬럼 :                  컬럼, 제약조건 추가
-- alter table ... modify 컬럼 :               컬럼 수정
-- alter table ... drop[constraint] 제약조건 :  제약조건 삭제
-- alter table ... drop column 컬럼 :          컬럼 삭제

ALTER TABLE tbl_sample
ADD(
    tel VARCHAR2(20) -- DEFAUL '000-0000-0000'
    , bigo VARCHAR2(255) 
);

DESC tbl_sample;

-- [칼럼명 bigo -> memo 칼럼명을 수정]
-- 1) bigo 칼럼명을 memo 별칭으로 사용
SELECT name, bigo as memo
FROM tbl_sample;
-- 2) 실제 칼럼명 수정
ALTER TABLE tbl_sample
RENAME COLUMN bigo TO memo;
-- memo 컬럼의 자료형 변경 (단 모든 값이 비어있어야함)
ALTER TABLE tbl_sample
MODIFY (memo VARCHAR2(100));
-- 컬럼 삭제
ALTER TABLE tbl_sample
DROP COLUMN memo;

DESC tbl_sample;

-- 테이블 이름 tbl_sample -> tbl_example
RENAME tbl_sample TO tbl_example;

-- 예) 게시판 테이블 생성 + CRUD
DROP TABLE tbl_board PURGE;

CREATE TABLE tbl_board(
    seq NUMBER(38) PRIMARY KEY           -- 글번호
    , writer VARCHAR2(20) NOT NULL    -- 작성자
    , password VARCHAR2(15) NOT NULL  -- 비밀번호
    , title VARCHAR2(100) NOT NULL    -- 제목
    , content CLOB                    -- 내용
    , regdate DATE DEFAULT SYSDATE    -- 작성일
);

-- 조회수(readed) 칼럼 추가: NUMBER(38) 기본값 0
ALTER TABLE tbl_board
ADD (readed NUMBER(38) DEFAULT 0);

-- 새로운 게시글 추가
INSERT INTO tbl_board (seq, writer, password, title)
VALUES (1, '홍길동', '1234', 'Hello');
INSERT INTO tbl_board VALUES (2, '서무식', '1234', 'Hello',null, SYSDATE, 0);

-- 새로운 게시글을 추가: seq 글번호 컬럼값은 시쿼스 자동 증가 처리
CREATE SEQUENCE seq_tblboard
START WITH 3;

SELECT *
FROM user_sequences;

INSERT INTO tbl_board VALUES (seq_tblboard.NEXTVAL, '정창숙', '1234', '신정역','(내용무)', SYSDATE, 0);

INSERT INTO tbl_board VALUES (seq_tblboard.NEXTVAL, '홍기수', '1234', '오류처리','NET_VAL 이 아닌 NEXTVAL 의사컬럼', SYSDATE, 0);

COMMIT;

SELECT *
FROM tbl_board;

SELECT seq_tblboard.CURRVAL
FROM dual;

-- 샘플 100개의 게시글 추가
-- DECLARE 변수선언
BEGIN
 FOR i IN 1..100 LOOP
     INSERT INTO tbl_board VALUES (
        seq_tblboard.NEXTVAL
        , '홍기수' || i
        , '1234'
        , '게시글 제목' || i
        , '게시글 내용' || i
        , SYSDATE
        , 0
);
 END LOOP;
-- EXCEPTION 예외처리
END;

COMMIT;

SELECT *
FROM tbl_board;

-- 현재 페이지 번호 : 1    currentPage
-- 한페이지에 출력할 게시글 수: 10  pageSize
SELECT seq, title, writer, regdate, readed
FROM tbl_board
ORDER BY seq DESC
OFFSET (:currentPage-1)* :pageSize ROWS
FETCH NEXT :pageSize ROWS ONLY;

-- title 컬럼을 subject 컬럼명으로 수정
ALTER TABLE tbl_board
RENAME COLUMN title TO subject;

-- writer 컬럼 크기 20 -> 30 크기 확장
ALTER TABLE tbl_board
MODIFY writer VARCHAR2(30);

DESC tbl_board;

-- [테이블 생성하는 방법]
-- 1) CREATE TABLE 테이블명 ();
-- 2) 서브쿼리를 사용해서 데이터 생성
CREATE TABLE emp_10
AS 
SELECT *
FROM emp
WHERE deptno = 10;
--
SELECT *
FROM emp_10;

-- 예) emp + dept + salgrade 테이블 3개 조인 -> 새로운 테이블 생성
emp: deptno, empno, ename, sal+NVL(comm,0) pay
deptno: dname
salgrade: grade

CREATE TABLE empdeptgrade
AS
SELECT empno, ename, sal+NVL(comm,0) pay, d.deptno, dname, sal, grade
FROM emp e JOIN dept d ON e.deptno = d.deptno
           JOIN salgrade s ON sal BETWEEN losal AND hisal;

SELECT *
FROM empdeptgrade;

DESC empdeptgrade;

-- 제약조건은 복제되지 않는다
-- (1) emp 테이블에 어떤 제약조건 확인
SELECT *
FROM user_constraints
WHERE table_name = 'TBL_EMP';
WHERE table_name = 'EMP';

-- 생성한 테이블 삭제
DROP TABLE emp_10 PURGE;
DROP TABLE empdeptgrade PURGE;

-- 예) 서브쿼리를 사용해서 테이블 생성할 때 구조만 생성하고 데이터는 필요없는 경우
CREATE TABLE tbl_emp
AS
SELECT *
FROM emp
WHERE 1 = 0;
--
DESC tbl_emp;
--
SELECT *
FROM tbl_emp;

-- 예) empno 컬럼에 PK 복제 X, tbl_emp 테이블에 PK 제약조건 추가
--【형식】constraint추가
--	ALTER TABLE 테이블명
--	ADD (컬럼명 datatype CONSTRAINT constraint명 constraint실제값
--	    [,컬럼명 datatype]...);
ALTER TABLE tbl_emp
ADD CONSTRAINT PK_tblemp_empno PRIMARY KEY (empno);

-- 확인)
SELECT *
FROM tbl_emp;

-- emp 테이블로 부터 30번 부서원 -> tbl_emp 테이블에 INSERT
--   ㄴ Subquery를 사용하여 행(row) 삽입
-- • 다른 테이블로부터 서브쿼리를 사용하여 그 결과를 테이블에 삽입한다.
-- • subquery를 이용한 행 삽입에서는 VALUES 절을 사용하지 않는다.
-- • INSERT 절에 명시한 컬럼의 수는 subquery 절에 명시한 컬럼의 수와 일치해야 하고,
-- 또한 각 컬럼의 데이터 타입도 일치해야 한다.
-- • subquery에 의해 리턴되는 행의 수만큼 삽입된다.

INSERT INTO tbl_emp (
                        SELECT *
                        FROM emp
                        WHERE deptno = 30
);
COMMIT;

SELECT *
FROM tbl_emp;

-- 예) emp 테이블에 20번 부서원들로 부터 empno, ename 2개의 칼럼만 가져와서
-- tbl_emp 테이블에 INSERT 

INSERT INTO tbl_emp (empno, ename) (
                    SELECT empno, ename
                    FROM emp
                    WHERE deptno = 20
);

COMMIT;

SELECT *
FROM tbl_emp;
-- 예) 다중 INSERT 문
-- 1) unconditional insert all: 조건이 없는 다중 INSERT ALL 문
--【형식】
--	INSERT ALL | FIRST
--	  [INTO 테이블1 VALUES (컬럼1,컬럼2,...)]
--	  [INTO 테이블2 VALUES (컬럼1,컬럼2,...)]
--	  .......
--	Subquery;

tbl_emp10
tbl_emp20
tbl_emp30
tbl_emp40

CREATE TABLE tbl_emp10 AS (SELECT * FROM emp WHERE 1 = 0);
CREATE TABLE tbl_emp20 AS (SELECT * FROM emp WHERE 1 = 0);
CREATE TABLE tbl_emp30 AS (SELECT * FROM emp WHERE 1 = 0);
CREATE TABLE tbl_emp40 AS (SELECT * FROM emp WHERE 1 = 0);

SELECT * FROM tbl_emp10;
SELECT * FROM tbl_emp20;
SELECT * FROM tbl_emp30;
SELECT * FROM tbl_emp40;

INSERT ALL
    INTO tbl_emp10 (empno, ename, job, mgr, hiredate, sal, comm, deptno)
    INTO tbl_emp20 (empno, ename, job, mgr, hiredate, sal, comm, deptno)
    INTO tbl_emp30 (empno, ename, job, mgr, hiredate, sal, comm, deptno)
    INTO tbl_emp40 (empno, ename, job, mgr) VALUEs (empno, ename, job, mgr)
SELECT *
FROM emp;

-- 2) conditional insert all  : 조건이 있는 다중 INSERT ALL 문
--INSERT INTO tbl_emp10 ( SELECT * FROM emp WHERE deptno = 10 );
--INSERT INTO tbl_emp20 ( SELECT * FROM emp WHERE deptno = 20 );
--INSERT INTO tbl_emp30 ( SELECT * FROM emp WHERE deptno = 30 );
--INSERT INTO tbl_emp40 ( SELECT * FROM emp WHERE deptno = 40 );
--ROLLBACK ;

--【형식】
--	INSERT ALL
--	WHEN 조건절1 THEN
--	  INTO [테이블1] VALUES (컬럼1,컬럼2,...)
--	WHEN 조건절2 THEN
--	  INTO [테이블2] VALUES (컬럼1,컬럼2,...)
--	........
--	ELSE
--	  INTO [테이블3] VALUES (컬럼1,컬럼2,...)
--	Subquery;


INSERT ALL
	WHEN deptno = 10 THEN
	  INTO tbl_emp10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
	WHEN deptno = 20 THEN
	  INTO tbl_emp20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
	WHEN deptno = 30 THEN
	  INTO tbl_emp30 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
    WHEN deptno = 40 THEN
	  INTO tbl_emp40 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
SELECT *
FROM emp;
ROLLBACK;

-- 3) conditional first insert 문
--【형식】
INSERT FIRST
    WHEN deptno = 10 THEN
          INTO tbl_emp10 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
    WHEN sal >= 1500 THEN
     INTO tbl_emp20 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
    ELSE
      INTO tbl_emp30 VALUES ( empno, ename, job, mgr, hiredate, sal, comm, deptno )
SELECT * FROM emp;

-- 완전히 테이블 삭제
DROP TABLE 테이블명 PURGE;

-- 테이블 안에 있는 행(데이터)만 삭제
TRUNCATE TABLE 테이블명  -- 커밋 필요 없음

-- 모든 행들을 삭제
DELETE FROM 테이블명;

----------------------------------------------------------------------------
-- 문제) insa 테이블의 num,name 컬럼을 복사해서 tbl_score 테이블 생성
--        (기존에 insa 테이블의 위의 2개의 컬럼만 복사해서 테이블 생성)
--        (num <= 1005)

CREATE TABLE tbl_score
AS
SELECT num, name
FROM insa
WHERE num <= 1005;

DESC tbl_score;

SELECT *
FROM tbl_score;

-- 문제 2) tbl_score 테이블에 PK_TBLSCORE_NUM 이름의 PK 제약조건을 설정
-- (PK는 num 이라는 칼럼)
ALTER TABLE tbl_score
ADD CONSTRAINT PK_TBLSCORE_NUM PRIMARY KEY (num);

SELECT *
FROM user_constraints
WHERE table_name = 'TBL_SCORE';

-- 문제3) tbl_score 테이블에 kor, eng, mat, tot, avg, grade, rank 컬럼 추가.
--                                                  CHAR(1 CHAR) N(3)

ALTER TABLE tbl_score
ADD (
    kor NUMBER(3) DEFAULT 0
    ,eng NUMBER(3) DEFAULT 0
    ,mat NUMBER(3) DEFAULT 0
    ,tot NUMBER(3) DEFAULT 0
    ,avg NUMBER(5,2) DEFAULT 0
    ,grade CHAR(1 CHAR)
    ,rank NUMBER(3)
);
DESC tbl_score;

SELECT *
FROM tbl_score;

-- 실무에서 바로 삭제하기 전에 컬럼을 사용하지 못하도록 설정
-- ALTER TABLE 테이블명
-- SET UNUSED (컬럼명);

-- 문제 4) DBMS_RANDOM 패키지 안에 VALUE 랜덤한 실수
-- 0~100 정수를 랜덤하게 출력하는 쿼리 작성
SELECT TRUNC(DBMS_RANDOM.VALUE(0,101))
FROM dual;

UPDATE tbl_score
SET kor = TRUNC(DBMS_RANDOM.VALUE(0,101))
    ,eng = TRUNC(DBMS_RANDOM.VALUE(0,101))
    ,mat = TRUNC(DBMS_RANDOM.VALUE(0,101))
;

COMMIT;

-- 문제) 1005번 학생의 국,영,점수가 잘못되어서 1점씩 깍는다
UPDATE tbl_score
SET (kor, eng) = (SELECT kor-1, eng-1 FROM tbl_score WHERE num = 1005)
WHERE num = 1005;

COMMIT;

-- 문제) 수학이 3문제가 정답이 없어서 15점을 모든 학생들의 수학점수 추가
-- 수정된 수학점수가 100점이 초과되면 100점으로 업데이트 되도록 처리
UPDATE tbl_score
SET mat = CASE
            WHEN mat + 15 > 100 THEN 100
            ELSE mat + 15
        END;
        
COMMIT;


-- 문제) 총점, 평균 수정
UPDATE tbl_score
SET tot = kor + eng + mat
    ,avg = (kor + eng + mat) / 3;
    
-- 문제) 순위 수정
UPDATE tbl_score t
SET rank = (
    SELECT rnk
    FROM(
        SELECT num, RANK() OVER(ORDER BY tot DESC) as rnk
        FROM tbl_score
    ) r 
    WHERE r.num = t.num
);

SELECT *
FROM tbl_score;

COMMIT;

-- 문제) avg 90 수, 80 우, 70 미, 60 양, 가
UPDATE tbl_score
SET grade = CASE
                WHEN avg >= 90 THEN '수'
                WHEN avg >= 80 THEN '우'
                WHEN avg >= 70 THEN '미'
                WHEN avg >= 60 THEN '양'
                ELSE '가' 
            END;

-- 문제) tbl_score 테이블에서 남학생들만 국어점수를 30점 증가 (update)
-- (문제점) tbl_score 테이블에서 주민등록번호 X + insa 테이블 조인

UPDATE (
        SELECT t.kor, i.ssn
        FROM tbl_score t JOIN insa i ON t.num = i.num
    )
SET kor = CASE
            WHEN kor + 30 > 100 THEN 100
            ELSE kor + 30
        END
WHERE MOD(SUBSTR(ssn, -7, 1), 2) = 1;

UPDATE tbl_score s
SET kor = CASE
            WHEN kor + 30 > 100 THEN 100
            ELSE kor + 30
        END
WHERE num = ANY(
            SELECT num
            FROM insa
            WHERE MOD(SUBSTR(ssn, -7, 1), 2) = 1 AND num <= 1005
);
--
WHERE num IN(
            SELECT num
            FROM insa
            WHERE MOD(SUBSTR(ssn, -7, 1), 2) = 1 AND num <= 1005
);

COMMIT;

SELECT * FROM tbl_score;


-- 문제) result 컬럼 추가 ('합격','불합격','과락')
--    합격: 평균 60점이상이고, 40미만이면 X
--    불합격: 평균 60점 미만
--    과락 : 40점 미만

ALTER TABLE tbl_score
ADD result VARCHAR2(9);

-- result 칼럼값 UPDATE 쿼리 작성
UPDATE tbl_score
SET result = CASE
                WHEN kor < 40 OR eng < 40 OR mat < 40 THEN '과락'
                WHEN avg >= 60 THEN '합격'
                ELSE '불합격'
             END;
             