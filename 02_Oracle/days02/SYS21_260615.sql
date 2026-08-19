SHOW USER;
SHOW CON_NAME;

SELECT *
FROM dba_users;

-- 용어정리
1. 데이터 : 컴퓨터에 저장되는 값 자체를 의미한다
2. 정보 :
3. 데이터베이스 : 관련 있는 데이터를 체계적으로 저장한 공간
4. DBMS : 데이터베이스를 관리하는 소프트웨어
    ex) 엑셀 프로그램
5. 테이블 : 데이터를 저장하는 기본 단위
    ex) 엑셀 시트
6. 스키마 : 사용자가 소유한
 SCOTT
│
├─ TABLE
│   ├─ EMP
│   ├─ DEPT
│   └─ BONUS
│
├─ VIEW
│   └─ V_EMP
│
├─ INDEX
│   └─ IDX_EMP_ENAME
│
├─ SEQUENCE
│   └─ EMP_SEQ
│
├─ PROCEDURE
│   └─ TEST_PROC
│
├─ FUNCTION
│   └─ ADD_NUM
│
└─ TRIGGER
    └─ TRG_EMP 
    
7. SCOTT 계정 소유의 DB객체 : 테이블 생성...
    BONUS,DEPT,EMP,SALGRADE
    
    
------------------------------------------------------
SELECT *
FROM dba_tables;

-- 모든 사용자 정보 조회
-- XEPDB1 이동
SHOW con_name;

ALTER SESSION SET CONTAINER = XEPDB1;

SHOW con_name;

-- SCOTT 계정 확인
SELECT *
FROM dba_users
WHERE username IN ('SCOTT' , 'HR');

    