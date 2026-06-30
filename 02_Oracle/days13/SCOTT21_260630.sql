-- SCOTT
-- 문제) 부서번호를 입력받아서 삭제하는 저장 프로시저
CREATE OR REPLACE PROCEDURE updeletetbldept
(
    pdeptno IN tbl_dept.deptno%TYPE
)
IS
BEGIN
    DELETE FROM tbl_dept
    WHERE deptno = pdeptno;
    COMMIT;
-- EXCEPTION
-- ROLLBACK;
END;

--
SELECT *
FROM tbl_dept;

--
EXEC updeletetbldept(50);

-- 예)
EXEC upupdatetbldept( 80, 'X', 'Y' );  -- 부서명, 지역명 모두 수정
EXEC upupdatetbldept( pdeptno=>80,  pdname=>'QC3' );  -- 부서명만 수정
EXEC upupdatetbldept( pdeptno=>80,  ploc=>'SEOUL' );  -- 지역명만 수정

-- 풀이2
CREATE OR REPLACE PROCEDURE upupdatetbldept
(
    pdeptno IN tbl_dept.deptno%TYPE,
    pdname IN tbl_dept.dname%TYPE := NULL,
    ploc IN tbl_dept.loc%TYPE := NULL
)
IS
BEGIN
    UPDATE tbl_dept
    SET dname = CASE 
                    WHEN pdname IS NULL THEN dname
                    ELSE pdname
                END
        ,loc = NVL(ploc, loc)
    WHERE deptno = pdeptno;
END;

-- 풀이1
CREATE OR REPLACE PROCEDURE upupdatetbldept
(
    pdeptno IN tbl_dept.deptno%TYPE,
    pdname IN tbl_dept.dname%TYPE := NULL,
    ploc IN tbl_dept.loc%TYPE := NULL
)
IS
    vdnmae tbl_dept.dname%TYPE;
    loc tbl_dept.loc%TYPE;
BEGIN
    SELECT dname, loc INTO vdname, vloc -- 수정 전 원래 부서명, 지역명
    FROM tbl_dept
    WHERE deptno = pdeptno;
    
    IF pdname IS NULL THEN
        pdname := vdname;
    END IF;
    
    IF ploc IS NULL THEN
        ploc := vloc;
    END IF;
    
    UPDATE tbl_dept
    SET dname = pdname, loc = ploc
    WHERE deptno = pdeptno;
END;

-- 예) 명시적 커서를 사용해서 모든 부서원 출력 upselecttblemp
CREATE OR REPLACE PROCEDURE upselecttblemp
(
    pdeptno IN tbl_dept.deptno%TYPE := null
)
IS
    -- 1) 커서 선언
    CURSOR vecursor IS (
        SELECT *
        FROM tbl_emp
        WHERE deptno = NVL(pdeptno,10)
    );
    
    verow tbl_emp%ROWTYPE;
BEGIN
    -- 2) 커서 실행 OPEN
    OPEN vecursor;
    
    -- 3) FETCH 반복 처리
    LOOP
    FETCH vecursor INTO verow;
    EXIT WHEN vecursor%NOTFOUND;
    DBMS_OUTPUT.PUT( vecursor%ROWCOUNT || ' : '  );
    DBMS_OUTPUT.PUT_LINE( verow.deptno || ', ' || verow.ename 
      || ', ' ||  verow.hiredate);  
    END LOOP;
    -- 4) 커서 CLOSE
    CLOSE vecursor;    
END;

--
EXEC upselecttblemp;
EXEC upselecttblemp(30);
EXEC upselecttblemp(80); -- 없는 부서를 매개변수로 호출하면 예외처리

-- 풀이 2)
CREATE OR REPLACE PROCEDURE upselecttblemp
(
    pdeptno IN tbl_dept.deptno%TYPE := null
)
IS
    -- 1) 커서 선언: 파라미터를 이용하는 방법
    CURSOR vecursor (cdeptno tbl_emp.deptno%TYPE)IS (
        SELECT *
        FROM tbl_emp
        WHERE deptno = NVL(cdeptno,10)
    );
    
    verow tbl_emp%ROWTYPE;
BEGIN
    -- 2) 커서 실행 OPEN
    OPEN vecursor(pdeptno);
    
    -- 3) FETCH 반복 처리
    LOOP
    FETCH vecursor INTO verow;
    EXIT WHEN vecursor%NOTFOUND;
    DBMS_OUTPUT.PUT( vecursor%ROWCOUNT || ' : '  );
    DBMS_OUTPUT.PUT_LINE( verow.deptno || ', ' || verow.ename 
      || ', ' ||  verow.hiredate);  
    END LOOP;
    
    -- 4) 커서 CLOSE
    CLOSE vecursor;    
END;

-- 풀이 3)
CREATE OR REPLACE PROCEDURE upselecttblemp
(
    pdeptno IN tbl_dept.deptno%TYPE := null
)
IS
BEGIN
    FOR verow IN (
        SELECT *
        FROM tbl_emp
        WHERE deptno = NVL(pdeptno,10)
    ) LOOP
        DBMS_OUTPUT.PUT_LINE( verow.deptno || ', ' || verow.ename 
         || ', ' ||  verow.hiredate); 
    END LOOP;
       
END;

--
EXEC upselecttblemp;
EXEC upselecttblemp(30);

-- 예) IN, OUT, IN OUT
-- 사원번호를 입력용 파라미터로 넘겨서 저장 프로시저를 호출하면
-- 사원이름과 주민번호를 출력용 파라미터로 반환하는 저장 프로시저를 생성 upselectinsa

CREATE OR REPLACE PROCEDURE upselectinsa
(
    pnum IN insa.NUM%TYPE,
    pname OUT insa.name%TYPE,
    pssn OUT insa.ssn%TYPE
)
IS
    vssn insa.ssn%TYPE;
BEGIN
    -- 000000-*******
    SELECT name, ssn INTO pname, vssn
    FROM insa
    WHERE num = pnum;
    
    pssn := RPAD(SUBSTR(vssn,0,8),14,'*');
END;

-- 테스트) 출력용 파라미터 확인
DECLARE
    vname insa.name%TYPE;
    vssn insa.ssn%TYPE;
BEGIN
    upselectinsa(1001,vname,vssn);
    DBMS_OUTPUT.PUT_LINE( vname || ' , ' || vssn); 
END;

-- 예) IN OUT 저장프로시저
--     주민등록번호를 매개변수로 생일
CREATE OR REPLACE PROCEDURE upiotest
(
    pssn IN OUT VARCHAR2
)
IS 
BEGIN
  pssn := SUBSTR(pssn,0,6);
-- EXCEPTION
END;

-- 테스트
DECLARE
  vssn VARCHAR2(14) := '910223-1700001';
BEGIN
    upiotest(Vssn);
    DBMS_OUTPUT.PUT_LINE(vssn);
END;

--
DROP TABLE tbl_score PURGE;
CREATE TABLE tbl_score
(
     num   NUMBER(4) PRIMARY KEY
   , name  VARCHAR2(20)
   , kor   NUMBER(3)  
   , eng   NUMBER(3)
   , mat   NUMBER(3)  
   , tot   NUMBER(3)
   , avg   NUMBER(5,2)
   , rank  NUMBER(4) 
   , grade CHAR(1 CHAR)
);
--
CREATE SEQUENCE seq_tbl_score;
--
EXEC up_insertscore( '홍길동', 89,44,55 );
EXEC up_insertscore( '윤재민', 49,55,95 );
EXEC up_insertscore( '김도균', 90,94,95 );
EXEC up_insertscore( '이시훈', 89,75,15 );
EXEC up_insertscore( '송세호', 67,44,75 );
EXEC up_insertscore( '서영학', 100,100,100 );

--
CREATE OR REPLACE PROCEDURE up_insertscore
(
      pname VARCHAR2
    , pkor  NUMBER := 0
    , peng  NUMBER := 0
    , pmat  NUMBER := 0
)
IS 
   vtot NUMBER(3) := 0;
   vavg NUMBER(5,2) ;
   vgrade tbl_score.grade%TYPE;
BEGIN
    vtot := pkor + peng + pmat;
    vavg := vtot/3;
    -- 평균이 90이상 A, 80 이상 B, 70 C  ~ F
    IF vavg >= 90 THEN vgrade := 'A';
    ELSIF vavg >= 80 THEN vgrade := 'B';
    ELSIF vavg >= 70 THEN vgrade := 'C';
    ELSIF vavg >= 60 THEN vgrade := 'D';
    ELSE vgrade := 'F';
    END IF;

    INSERT INTO tbl_score (num, name, kor, eng, mat, tot, avg, rank, grade )
    VALUES ( SEQ_TBL_SCORE.NEXTVAL, pname, pkor, peng, pmat, vtot,vavg, 1, vgrade );
    
    -- 등수처리하는 프로시저 또는 함수를 호출
    -- UP_RANKSCORE;
    
    COMMIT;
-- EXCEPTION
END;

--
SELECT *
FROM tbl_score;

--
EXEC up_updateScore( 6, 0, 0, 0 );
EXEC up_updateScore( 1, 100, 100, 100 );
EXEC up_updateScore( 1, pkor =>34 );
EXEC up_updateScore( 1, pkor =>34, pmat => 90 );
EXEC up_updateScore( 1, peng =>45, pmat => 90 );

--
create or replace PROCEDURE up_updateScore
(
      pnum  NUMBER
    , pkor  NUMBER := NULL
    , peng  NUMBER := NULL
    , pmat  NUMBER := NULL
)
IS 
   vtot NUMBER(3) := 0;
   vavg NUMBER(5,2) ;
   vgrade tbl_score.grade%TYPE;

   vkor NUMBER(3); -- 수정 전의 원래 점수값
   veng NUMBER(3); -- 수정 전의 원래 점수값
   vmat NUMBER(3); -- 수정 전의 원래 점수값
BEGIN
    SELECT kor, eng, mat INTO vkor, veng, vmat
    FROM tbl_score
    WHERE num = pnum;

    vtot := NVL( pkor, vkor ) + NVL( peng, veng) + NVL(pmat, vmat);
    vavg := vtot/3;
    
    -- 평균이 90이상 A, 80 이상 B, 70 C  ~ F
    IF vavg >= 90 THEN vgrade := 'A';
    ELSIF vavg >= 80 THEN vgrade := 'B';
    ELSIF vavg >= 70 THEN vgrade := 'C';
    ELSIF vavg >= 60 THEN vgrade := 'D';
    ELSE vgrade := 'F';
    END IF;

    UPDATE tbl_score
    SET kor = NVL( pkor, vkor )
    , eng=NVL( peng, veng)
    , mat = NVL(pmat, vmat)
    , tot = vtot
    , avg = vavg, grade=vgrade
    WHERE num = pnum;

    -- 등수처리하는 프로시저 또는 함수를 호출
    -- UP_RANKSCORE;
    
    COMMIT;
-- EXCEPTION
END;

--
CREATE OR REPLACE PROCEDURE up_rankscore
IS
BEGIN
  UPDATE tbl_score p
  SET rank = ( SELECT COUNT(*)+1 FROM tbl_score WHERE p.tot < tot );
  COMMIT;
-- EXCEPTION
END;

EXECUTE UP_RANKSCORE;

--
SELECT * FROM tbl_score;

------------------------------------------------------------------------------
-- 예) up_selecttblscore 명시적 커서를 사용해서 출력
CREATE OR REPLACE PROCEDURE up_selectscore
IS 
-- 1) 커서선언
    CURSOR vecursor IS 
        SELECT * 
        FROM tbl_score
        ORDER BY rank;
    verow tbl_score%ROWTYPE;
BEGIN 
-- 2) 커서 실행 OPEN
    OPEN vecursor;
-- 3) FETCH  반복처리
    LOOP
        FETCH vecursor INTO verow;
        EXIT WHEN vecursor%NOTFOUND;
        DBMS_OUTPUT.PUT( vecursor%ROWCOUNT || ' : '  );
        DBMS_OUTPUT.PUT_LINE( verow.num || ', ' || verow.name || ', ' ||  verow.tot || ', ' ||  verow.avg || ', ' ||  verow.grade || ', ' ||  verow.rank);          
    END LOOP;
-- 4) 커서 CLOSE
    CLOSE vecursor;
  
--  COMMIT;
--EXCEPTION
--    ROLLBACK;
END;

EXEC up_selectscore;

--
-- 풀이 2)
CREATE OR REPLACE PROCEDURE up_selectscore
(
    pecursor OUT SYS_REFCURSOR
)
IS 
BEGIN 
  -- OPEN FOR문 사용 result set
  OPEN pecursor FOR 
        SELECT *
        FROM tbl_score
        ORDER BY rank;
END;

--
-- PL/SQL 밖에 있는 변수 cur을 호스트 변수 라고 부른다
VARIABLE cur REFCURSOR;
EXEC up_selectscore( :cur );
PRINT cur;

-- 예) 저장 함수
SELECT name, ssn, uf_gender(ssn) as gender , uf_age(ssn,0), uf_age(ssn,1)
FROM insa;

-- 성별 구분 함수 만들기
CREATE OR REPLACE FUNCTION uf_gender
(
    pssn VARCHAR2
)
RETURN VARCHAR2
IS 
    vgender VARCHAR2(6) := '남자';
BEGIN
    IF MOD (SUBSTR(pssn,-7,1),2) = 0 THEN
    vgender := '여자';
    END IF;
    RETURN vgender;
-- EXCEPTION
END;

-- 나이 함수 만들기
-- 예) uf_age(ssn,0,1) 0 한국나이, 1 만나이
CREATE OR REPLACE FUNCTION uf_age
(
    pssn VARCHAR2,
    ptype NUMBER
)
RETURN NUMBER
IS
    vcurrent_year NUMBER(4) := TO_CHAR(SYSDATE, 'YYYY');
    vbirth_year NUMBER(4);
    vcountingage NUMBER(3);
    vamericanage NUMBER(3);
BEGIN
    vbirth_year := CASE
                        WHEN SUBSTR( pssn, -7, 1) IN ( 1,2,5,6 ) THEN 1900
                        WHEN REGEXP_LIKE( SUBSTR( pssn, -7, 1), '[3478]' ) THEN 2000
                        ELSE 1800
                    END +  SUBSTR( pssn, 1, 2 );
    
    vcountingage := vcurrent_year - vbirth_year + 1;
    
    IF ptype = 0 THEN
        RETURN vcountingage;
    ELSIF ptype = 1 THEN
        vamericanage := vcountingage -1 
        + CASE SIGN(TO_CHAR(SYSDATE, 'MMDD') - SUBSTR(pssn,3,4))
            WHEN -1 THEN -1
            ELSE 0
          END;
        RETURN vamericanage;
    END IF;
    
END;

--
-- [문제] ssn ->  "1998.01.20(화)"  uf_birth
CREATE OR REPLACE FUNCTION uf_birth
(  
   pssn VARCHAR2
)
RETURN VARCHAR2
IS 
   vcentry NUMBER(2);  -- 18, 19, 20
   vbirth VARCHAR2(20); -- "1998.01.20(화)"
BEGIN      
   vbirth := SUBSTR(pssn, 0, 6);  --  771212
   vcentry := CASE 
               WHEN SUBSTR(pssn, -7,1) IN (1,2,5,6) THEN 19
               WHEN SUBSTR(pssn, -7,1) IN (3,4,7,8) THEN 20
               ELSE 18
             END;
  vbirth :=  vcentry ||  vbirth;  -- '19771212'
  vbirth :=  TO_CHAR( TO_DATE( vbirth ), 'YYYY.MM.DD(DY)');
  RETURN (vbirth);
--EXCEPTION
END;

--
SELECT ssn, uf_birth(ssn) FROM insa;
