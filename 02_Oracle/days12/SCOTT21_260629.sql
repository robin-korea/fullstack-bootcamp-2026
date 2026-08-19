-- SCOTT

-- PL/SQL while/for 문

-- for 문
DECLARE
BEGIN
    FOR vi IN 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE(vi);
    END LOOP;
--EXCEPTION
END;

-- while 문
DECLARE
    vi NUMBER(2) := 1;
BEGIN
    WHILE vi <= 10 LOOP
        DBMS_OUTPUT.PUT_LINE(vi);
        vi := vi + 1;
    END LOOP;
-- EXCEPTION
END;

DECLARE
    vi NUMBER(2) := 1;
BEGIN
    LOOP
        EXIT WHEN vi > 10;
        DBMS_OUTPUT.PUT_LINE(vi);
        vi := vi + 1;
    END LOOP;
-- EXCEPTION
END;

-- 예) 1+2+3 ... 9+10=55
-- 1) for
DECLARE
    vsum NUMBER(10) := 0;
BEGIN
    FOR vi IN 1..10 LOOP
        DBMS_OUTPUT.PUT(vi || '+');
        vsum := vsum + vi;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('=' ||  vsum);
-- EXCEPTION
END;

-- 2) while
DECLARE
    vi NUMBER(2) := 1;
    vsum NUMBER(10) := 0;
BEGIN
    WHILE vi <= 10 LOOP
        DBMS_OUTPUT.PUT(vi || '+');
        vsum := vsum + vi;
        vi := vi + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('=' ||  vsum);
-- EXCEPTION
END;

-- 2~9 단
-- 1) FOR
-- DECLARE 
DECLARE
BEGIN
  FOR vi IN 1.. 9 LOOP
    FOR vdan IN 2..9 LOOP
      DBMS_OUTPUT.PUT( vdan || '*' || vi || '=' ||  RPAD( vdan*vi, 4, ' '));
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(''); -- 개행
  END LOOP;
--EXCEPTION
END;

-- 2) WHILE
DECLARE
    vdan NUMBER(2) := 2;
    vi NUMBER(2):= 1;
BEGIN
    WHILE vdan <= 9 LOOP
    vi := 1;
        WHILE vi <= 9 LOOP
            DBMS_OUTPUT.PUT( vdan || '*' || vi || '=' ||  RPAD( vdan*vi, 4, ' '));
            vi := vi+1;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('');
        vdan := vdan + 1;
    END LOOP;
-- EXCEPTION
END;

-- 예) emp 테이블에서 10번 부서원 salary 20% 인상 20번 부서원 10%인상 그외 15%인상
-- (익명 프로시저로 처리)
DECLARE
BEGIN
    UPDATE emp
        SET sal = CASE deptno
                    WHEN 10 THEN sal * 1.2
                    WHEN 20 THEN sal * 1.1
                    ELSE         sal * 1.15
                  END;
-- EXCEPTION
END;

--
SELECT * FROM emp ORDER BY deptno;

ROLLBACK;

--
DECLARE
    vename emp.ename%TYPE;
    vhiredate emp.hiredate%TYPE;
BEGIN
    SELECT ename, hiredate INTO vename, vhiredate
    FROM emp;
    -- WHERE empno = 7782;
    
    DBMS_OUTPUT.PUT_LINE(vename || ', ' || vhiredate);
-- EXCEPTION
END;

-- 여러 행을 PL/SQL 에서 처리할때는 커서 (CURSOR) 사용
-- 묵시적 커서 예)
DECLARE
    vrow emp%ROWTYPE;
BEGIN
    FOR vrow IN ( SELECT ename, hiredate FROM emp ) LOOP
        DBMS_OUTPUT.PUT_LINE(vrow.ename || ', ' || vrow.hiredate);
    END LOOP;
-- EXCEPTION
END;

--
-- 1) %TYPE 변수 
DECLARE
  vdeptno dept.deptno%TYPE;
  vdname dept.dname%TYPE;
  vempno emp.empno%TYPE;
  vename emp.ename%TYPE;
  vpay NUMBER;
BEGIN
   SELECT d.deptno, dname, empno, ename, sal + NVL(comm,0) pay
     INTO vdeptno, vdname, vempno, vename, vpay
   FROM dept d JOIN emp e ON d.deptno = e.deptno
   WHERE empno = 7369;
   DBMS_OUTPUT.PUT_LINE( vdeptno || ', ' || vdname  
    || ', ' ||  vempno  || ', ' || vename  || ', ' ||  vpay );
--EXCEPTION
END;

-- 2) %ROWTYPE 변수
DECLARE
  vdrow dept%ROWTYPE;
  verow emp%ROWTYPE;
  vpay NUMBER;
BEGIN
   SELECT d.deptno, dname, empno, ename, sal + NVL(comm,0) pay
     INTO vdrow.deptno, vdrow.dname, verow.empno, verow.ename, vpay 
   FROM dept d JOIN emp e ON d.deptno = e.deptno
   WHERE empno = 7369;   
   DBMS_OUTPUT.PUT_LINE( vdrow.deptno || ', ' || vdrow.dname 
    || ', ' ||  verow.empno  || ', ' || verow.ename  || ', ' ||  vpay );
--EXCEPTION
END;

-- 3) 사용자 정의 구조체 타입 -> 사용
DECLARE
  -- 사용자 정의한 구조체 타입
  TYPE EmpDeptType IS RECORD(
      deptno dept.deptno%TYPE,
      dname dept.dname%TYPE,
      empno emp.empno%TYPE,
      ename emp.ename%TYPE,
      pay NUMBER
  );
  
  vedrow EmpDeptType;
  
BEGIN
   SELECT d.deptno, dname, empno, ename, sal + NVL(comm,0) pay
     INTO vedrow.deptno, vedrow.dname, vedrow.empno, vedrow.ename, vedrow.pay 
   FROM dept d JOIN emp e ON d.deptno = e.deptno    
   WHERE empno = 7369;   
   DBMS_OUTPUT.PUT_LINE( vedrow.deptno || ', ' || vedrow.dname 
    || ', ' ||  vedrow.empno  || ', ' || vedrow.ename  || ', ' ||  vedrow.pay );
--EXCEPTION
END;

-- 명시적 커서 사용하는 예) 
DECLARE
  TYPE EmpDeptType IS RECORD(
      deptno dept.deptno%TYPE,
      dname dept.dname%TYPE,
      empno emp.empno%TYPE,
      ename emp.ename%TYPE,
      pay NUMBER
  );
  vedrow EmpDeptType;
  -- 1) 커서 선언
  CURSOR vedcursor IS (
                    SELECT d.deptno, dname, empno, ename, sal + NVL(comm,0) pay
                    FROM dept d JOIN emp e ON d.deptno = e.deptno 
                  );
BEGIN
    -- 2) SELECT문 실행
    OPEN vedcursor;
    
    -- 3) FETCH
    LOOP
       DBMS_OUTPUT.PUT_LINE( '> 읽어온 레코드 수: ' || vedcursor%ROWCOUNT );
       FETCH vedcursor INTO vedrow;
       EXIT WHEN vedcursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE( vedrow.deptno || ', ' || vedrow.dname 
    || ', ' ||  vedrow.empno  || ', ' || vedrow.ename  || ', ' ||  vedrow.pay );
    END LOOP;
    
   -- 4) CLOSE
   CLOSE vedcursor;
--EXCEPTION
END;

--
--DECLARE  
BEGIN
   FOR vrow IN (
      SELECT d.deptno, dname, empno, ename, sal + NVL(comm,0) pay     
      FROM dept d JOIN emp e ON d.deptno = e.deptno
   )
   LOOP
      DBMS_OUTPUT.PUT_LINE( vrow.deptno || ', ' || vrow.dname 
    || ', ' ||  vrow.empno  || ', ' || vrow.ename  || ', ' ||  vrow.pay );
   END LOOP; 
--EXCEPTION
END;

--
DECLARE  
  CURSOR vdecursor IS (
      SELECT d.deptno, dname, empno, ename, sal + NVL(comm,0) pay     
      FROM dept d JOIN emp e ON d.deptno = e.deptno
  );
BEGIN
   --OPEN vdecursor;
   FOR vrow IN vdecursor  
   LOOP
      DBMS_OUTPUT.PUT_LINE( vrow.deptno || ', ' || vrow.dname 
    || ', ' ||  vrow.empno  || ', ' || vrow.ename  || ', ' ||  vrow.pay );
   END LOOP; 
--EXCEPTION
END;

------------------------------------------------------------------------------------
-- stored procedure (저장 프로시저)
CREATE OR REPLACE PROCEDURE up저장프로시저명
(
    -- IN, OUT, IN OUT 파라미터(매개변수, 인자) p
    pssn VARCHAR2, -- 크기 X, 뒤에 콤마
    pssn IN VARCHAR2,
    pssn OUT VARCHAR2,
    pssn IN OUT VARCHAR2
)
IS
    -- 변수, 상수 선언         v
    vename VARCHAR2(20); -- 뒤에 세미콜론 
BEGIN
    -- 실행문 선언
-- EXCETPION
    -- 예외처리 선언
END;

-- 저장 프로시저를 실행하는 3가지 방법
-- 1) EXEC[UTE] 저장프로시저명;
-- 2) 익명 프로시저에서 호출해서 실행
-- 3) 또 다른 저장프로시저 안에서 실행

-- 예) emp 테이블을 복사해서 tbl_emp 테이블 생성
DROP TABLE tbl_emp PURGE;
--
CREATE TABLE tbl_emp
AS
    SELECT *
    FROM emp;
--
SELECT * FROM tbl_emp;

-- 예) 저장 프로시저 선언 + 사용 예
--  tbl_emp 테이블에서 사원 삭제.. 하는 저장 프로시저

EXEC UPDELETETBLEMP(7369);
--
CREATE OR REPLACE PROCEDURE UPDELETETBLEMP
(
    pempno NUMBER
)
IS -- AS DECLARE 선언
BEGIN
    DELETE FROM tbl_emp
    WHERE empno = pempno;
    COMMIT;
-- EXCEPTION
-- ROLLBACK;
END;

-- Procedure UPDELETETBLEMP이(가) 컴파일되었습니다.
SELECT * FROM tbl_emp;

-- 익명 프로시저에서 호출해서 사용할 수 있다.
BEGIN
    UPDELETETBLEMP(7499);
END;

-- 또 다른 저장 프로시저에서 호출할 수 있다.
CREATE OR REPLACE PROCEDURE upOther
(
    pempno tbl_emp.empno%TYPE
)
IS
BEGIN
    UPDELETETBLEMP(pempno);
END;

--
EXEC upOther(7566);

--
DROP PROCEDURE UPDELETETBLEMP;

-- 예) dept -> tbl_dept 테이블 생성
DROP TABLE tbl_dept PURGE;

CREATE TABLE tbl_dept
AS
SELECT *
FROM dept;

SELECT * FROM tbl_dept;

-- PK 제약조건 설정
ALTER TABLE tbl_dept
ADD CONSTRAINT pk_tbldept_deptno PRIMARY KEY (deptno);

-- 예) tbl_dept 의 모든 부서 정보를 출력하는 upSelectTblDept
--  명시적 커서 1) 2) 3) 4) 단계 ...
CREATE OR REPLACE PROCEDURE upSelectTblDept
IS
    CURSOR vdcursor IS (
        SELECT deptno, dname, loc
        FROM tbl_dept
    );
    vdrow tbl_dept%ROWTYPE;
BEGIN
    OPEN vdcursor;
    
    LOOP
        FETCH vdcursor INTO vdrow;
        EXIT WHEN vdcursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE( vdrow.deptno || ', ' || vdrow.dname || ', ' ||  vdrow.loc );
    END LOOP;
    
    CLOSE vdcursor;
-- EXCEPTION
END;

EXEC upSelectTblDept;

--
CREATE OR REPLACE PROCEDURE upSelectTblDept  
IS
--  CURSOR vdcursor IS (
--               SELECT deptno, dname, loc 
--               FROM tbl_dept
--  );
BEGIN

    FOR vdrow IN (SELECT deptno, dname, loc FROM tbl_dept) LOOP
        DBMS_OUTPUT.PUT_LINE( vdrow.deptno || ', ' || vdrow.dname || ', ' ||  vdrow.loc );
    END LOOP;

--EXCEPTION
END;

-- tbl_dept 부서테이블에 새로운 부서를 추가하는 코딩.. 저장 프로시저
-- 시퀀스 생성 사용...
【형식】
	CREATE SEQUENCE 시퀀스명
	[ INCREMENT BY 정수]
	[ START WITH 정수]
	[ MAXVALUE n ¦ NOMAXVALUE]
	[ MINVALUE n ¦ NOMINVALUE]
	[ CYCLE ¦ NOCYCLE]
	[ CACHE n ¦ NOCACHE];

-- 예)
CREATE SEQUENCE seq_tbldept
INCREMENT BY 10
START WITH 50
NOCYCLE
NOCACHE;

-- 
CREATE OR REPLACE PROCEDURE upInsertTblDept
(
    pdname tbl_dept.dname%TYPE DEFAULT NULL,
    ploc tbl_dept.loc%TYPE := NULL
)
IS 
--    vdeptno tbl_dept.deptno%TYPE;
BEGIN
--    SELECT MAX(deptno)+10 INTO vdeptno FROM tbl_dept;
        
--        INSERT INTO tbl_dept (deptno, dname, loc)
--        VALUES (vdeptno, pdname, ploc);
        
        INSERT INTO tbl_dept (deptno, dname, loc)
        VALUES (seq_tbldept.NEXTVAL, pdname, ploc);
        
        COMMIT;
--EXCEPTION
END;

EXEC upInsertTblDept;
EXEC upInsertTblDept('QC','SEOUL');

EXEC upInsertTblDept(ploc=>'S',pdname=>'Q');
EXEC upInsertTblDept(pdname=>'AAA');

SELECT * FROM tbl_dept;

-- 문제) 부서번호를 입력받아서 삭제하는 저장프로시저 upupdatetbldept
CREATE OR REPLACE PROCEDURE upupdatetbldept
(
    pdeptno tbl_dept.deptno%TYPE
)
IS
BEGIN
    DELETE FROM tbl_dept
    WHERE deptno = pdeptno;
END;