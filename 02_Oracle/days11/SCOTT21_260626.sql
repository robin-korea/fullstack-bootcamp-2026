-- [문제] 서점별 판매현황 구하기
--서점코드  서점명  판매금액합  비율(소수점 둘째반올림)  
-- g_id    g_name
------------ -------------------------- ----------------
--7       강북서점    15300      26%
--4       서울서점    11551      19%
--2       도시서점    6000      10%
--6       강남서점    18060      30%
--1       우리서점    8850      15%

-- p_su, d.b_id, price
SELECT g_id, g_name, "서점별총구매금액"
    , ROUND("서점별총구매금액" / "전체 총구매금액" * 100,2) || '%' as rate
FROM (
    SELECT g.g_id, g_name, SUM(price * p_su) "서점별총구매금액"
            , (SELECT SUM(price * p_su) FROM panmai p JOIN danga d ON p.b_id = d.b_id) "전체 총구매금액"
    FROM panmai p JOIN danga d ON p.b_id = d.b_id
                  JOIN gogaek g ON g.g_id = p.g_id
    GROUP BY g.g_id, g_name
);

--
WITH gogaek_sales AS (
    SELECT
          g.g_id , g.g_name
        , NVL(SUM(p_su * price), 0) total_amt
        , COUNT(p_date) total_cnt
    FROM panmai p JOIN danga d ON p.b_id = d.b_id
             RIGHT JOIN gogaek g  ON g.g_id = p.g_id
    GROUP BY  g.g_id , g.g_name
)
SELECT 
    g_id, g_name, total_amt
    , ROUND(total_amt / SUM(total_amt) OVER() * 100 , 2) 구매비율
FROM gogaek_sales;

-- RATIO_TO_REPORT() 함수: 전체 합계의 각 행이 차지하는 비율을 계산하는 분석 함수
SELECT g.g_id, g_name, NVL(SUM(price * p_su),0) "서점별총구매금액"
            , ROUND(RATIO_TO_REPORT (NVL(SUM(price * p_su),0)) OVER() * 100 , 2) 구매비율
FROM panmai p JOIN danga d ON p.b_id = d.b_id
              RIGHT JOIN gogaek g ON g.g_id = p.g_id
GROUP BY g.g_id, g_name;

--------------------------------------------------------------------------
-- VIEW
-- 형식
-- CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름
--		[(alias[,alias]...]
--	AS subquery
--	[WITH CHECK OPTION]
--	[WITH READ ONLY];

-- 예) 고객의 구매 정보 조회
SELECT b.b_id, title, price, g.g_id, g_name, p_date, p_su
FROM book b JOIN danga d ON b.b_id = d.b_id
            JOIN panmai p ON b.b_id = p.b_id
            JOIN gogaek g ON p.g_id = g.g_id;
            
-- view 작성
CREATE OR REPLACE VIEW uvpan
AS 
SELECT b.b_id, title, price, g.g_id, g_name, p_date, p_su
FROM book b JOIN danga d ON b.b_id = d.b_id
            JOIN panmai p ON b.b_id = p.b_id
            JOIN gogaek g ON p.g_id = g.g_id;

-- 권한 확인
SELECT *
FROM user_sys_privs;

-- view 목록 확인 
SELECT *
FROM user_views;

--
SELECT *
FROM uvpan;

-- 실무에서 많이 쓰이는 용도
-- 회원 정보 조회
-- 주문 현황
-- 게시판 목록
-- 매출 현황 ... 둥둥

-- 예) 년도, 월, 고객코드, 고객명, 판매금액합 정보 조회 뷰 작성
--    (년도, 월 오름차순 정렬)
--     uvgogaek

CREATE OR REPLACE VIEW uvgogaek
--  (컬럼명)
AS
SELECT g.g_id
     , g_name
     , TO_CHAR(p_date, 'YYYY') p_year
     , TO_CHAR(p_date, 'MM') p_month
     , SUM(price * p_su) 총판매금액합
FROM gogaek g JOIN panmai p ON g.g_id = p.g_id
              JOIN danga d ON p.b_id = d.b_id
GROUP BY TO_CHAR(p_date, 'YYYY'), TO_CHAR(p_date, 'MM'),g.g_id, g_name
ORDER BY TO_CHAR(p_date, 'YYYY'), TO_CHAR(p_date, 'MM');

SELECT *
FROM uvgogaek;

DROP VIEW uvgogaek;

--------------------------------------------------------------------------------
-- PL/SQL
[DECLARE]
    변수, 상수 선언
BEGIN
    실행문
    INSERT
    
    INSERT
    INSERT
    INSERT
    INSERT
    -- 투표 (트랜잭션 처리)
    INSERT 투표             O
    UPDATE 설문 총투표자수    O
    UPDATE 항목 항목투표자수   X

[EXCEPTION]
END;

-- PL/SQL 예)
DESC emp;

-- 1) 익명 프로시저: DECLARE 시작, DB 객체로 저장 X
DECLARE
 -- 변수, 상수 선언 블럭
 vename VARCHAR2(10);
 vpay NUMBER;
 -- vpi CONSTANT NUMBER := 3.141592;
BEGIN
 -- 실행 블럭
 SELECT ename, sal + NVL(comm,0) as pay
    INTO vename, vpay
 FROM emp
 WHERE empno = 7369;
 
 -- 출력
 DBMS_OUTPUT.PUT_LINE(vename || ', ' || vpay);
-- EXCEPTION
END;
-- PL/SQL 프로시저가 성공적으로 완료되었습니다.

-- 예) 30번 부서의 지역명을 얻어와서
--     10번 부서의 지역명으로 설정하는 익명 프로시저 작성

SELECT *
FROM dept;
-- 10	ACCOUNTING	NEW YORK   <- CHICAGO
-- 20	RESEARCH	DALLAS
-- 30	SALES	    CHICAGO    <- NEW YORK
-- 40	OPERATIONS	BOSTON

DECLARE
    vloc10 dept.loc%TYPE; -- TYPE 변수
    vloc30 dept.loc%TYPE;
BEGIN
    SELECT loc INTO vloc10
    FROM dept
    WHERE deptno = 10;
    
    SELECT loc INTO vloc30
    FROM dept
    WHERE deptno = 30;
    
    UPDATE dept
    SET loc = vloc30
    WHERE deptno = 10;
    
    UPDATE dept
    SET loc = vloc10
    WHERE deptno = 30;
    
-- COMMIT;
-- EXCEPTION
END;
-- PL/SQL 프로시저가 성공적으로 완료되었습니다.
ROLLBACK;

-- 예) 30번 부서원들 중에 최고 급여 받는 사원의 정보
--     얻어와서 출력하는 익명 프로시저를 작성
--  ( empno, ename, hiredate, job, sal, comm )
-- 1)
DECLARE
   vempno emp.empno%TYPE; 
   vename emp.ename%TYPE; 
   vhiredate emp.hiredate%TYPE;  
   vjob emp.job%TYPE;  
   vsal emp.sal%TYPE;  
   vcomm emp.comm%TYPE; 
BEGIN
    SELECT empno, ename, hiredate, job, sal, comm 
        INTO vempno, vename, vhiredate, vjob, vsal, vcomm 
    FROM emp
    WHERE deptno = 30
    ORDER BY sal + NVL(comm, 0) DESC
    FETCH FIRST 1 ROW ONLY;
    
    DBMS_OUTPUT.PUT_LINE(vempno|| ', ' || vename|| ', ' || vhiredate|| ', ' || vjob|| ', ' || vsal|| ', ' || vcomm);
--EXCEPTION
END;

-- 2)
DECLARE
   vdeptno dept.deptno%TYPE := 30;
   
   vemprow emp%ROWTYPE; -- 한 행 전체 타입 저장
BEGIN
--  vdeptno := 30;
    
    SELECT empno, ename, hiredate, job, sal, comm 
        INTO vemprow.empno, vemprow.ename, vemprow.hiredate
            ,vemprow.job, vemprow.sal, vemprow.comm 
    FROM emp
    WHERE deptno = vdeptno
    ORDER BY sal + NVL(comm, 0) DESC
    FETCH FIRST 1 ROW ONLY;
    
    DBMS_OUTPUT.PUT_LINE(vemprow.empno|| ', ' || vemprow.ename);
--EXCEPTION
END;

-- 3) 30번 모든 사원정보를 조회 -> 출력
-- PL/SQL 에서 여러 개의 행을 처리할 때는 커서(CURSOR)를 사용해야 된다
DECLARE
   vemprow emp%ROWTYPE; -- 한 행 전체 타입 저장
BEGIN
    SELECT empno, ename, hiredate, job, sal, comm 
        INTO vemprow.empno, vemprow.ename, vemprow.hiredate
            ,vemprow.job, vemprow.sal, vemprow.comm 
    FROM emp
    ORDER BY sal + NVL(comm, 0) DESC;
    
    DBMS_OUTPUT.PUT_LINE(vemprow.empno|| ', ' || vemprow.ename);
--EXCEPTION
END;

-------------------------------------------------------------------------------
-- (1) 대입 연산자      :=
DECLARE
    va NUMBER(10) := 10;
    vb NUMBER(10);
    vc NUMBER(10);
BEGIN
     vb := 20;
     vc := va + vb;
     
     DBMS_OUTPUT.PUT_LINE(va || '+' || vb || '=' || vc);
-- EXCEPTION
END;

--(2) IF 문
IF 조건식 THEN
    -- 명령코딩
END IF;

--
IF 조건식 THEN
 -- 
ELSE
 -- 
END IF;

--
IF 조건식 THEN
 -- 
ELSIF 조건식 THEN
 -- 
ELSIF 조건식 THEN
 -- 
ELSIF 조건식 THEN
 -- 
ELSE
 --
END IF;

-- 예) 점수를 입력받아서 수/우/미/양/가 출력하는 익명 프로시저
DECLARE
    vscore NUMBER(3);
    vgrade CHAR(1 CHAR);
BEGIN
    vscore := :score; -- 바인드 입력창에서 점수를 입력
    IF vscore BETWEEN 90 AND 100 THEN
        vgrade := '수';
    ELSIF vscore BETWEEN 80 AND 89 THEN
        vgrade := '우';
    ELSIF vscore BETWEEN 70 AND 79 THEN
        vgrade := '미';
    ELSIF vscore BETWEEN 60 AND 69 THEN
        vgrade := '양';
    ELSIF vscore BETWEEN 0 AND 59 THEN
        vgrade := '가';
    ELSE
        -- DBMS_OUTPUT.PUT_LINE('입력 잘못!!');
        -- 1) 강제로 예외를 발생시킨다.
        RAISE_APPLICATION_ERROR(-20009,'>>> 점수의 범위가 벗어났습니다.');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(vgrade);
EXCEPTION
    -- 2) 예외 처리
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;

-- 예) 점수를 입력받아서 수/우/미/양/가 출력하는 익명 프로시저
--    (CASE 함수 사용해서 수정)
DECLARE
    vscore NUMBER(3);
    vgrade CHAR(1 CHAR);
BEGIN
    vscore := :score; -- 바인드 입력창에서 점수를 입력
    
    IF vscore BETWEEN 0 AND 100 THEN
    vgrade := CASE TRUNC(vscore/10)
            WHEN 10 THEN '수'
            WHEN 9 THEN '수'
            WHEN 8 THEN '우'
            WHEN 7 THEN '미'
            WHEN 6 THEN '양'
            ELSE '가'
            END;
            
--    vgrade := DECODE();
   ELSE
     RAISE_APPLICATION_ERROR(-20009, '>> 점수의 범위가 벗었났습니다.');
   END IF;
    
    DBMS_OUTPUT.PUT_LINE(vgrade);
EXCEPTION
    -- 2) 예외 처리
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;