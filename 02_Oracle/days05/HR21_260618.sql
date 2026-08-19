SELECT *
FROM employees;
------------------------------------------
-- 예) 분기별 입사한 사원수
SELECT Quarter, COUNT(*)
FROM(
SELECT hire_date
    ,TO_CHAR(hire_date, 'MM') h_month
    ,EXTRACT(MONTH FROM hire_date) h_month
    ,CASE
        WHEN EXTRACT(MONTH FROM hire_date) BETWEEN 1 AND 3 THEN '1Q'
        WHEN EXTRACT(MONTH FROM hire_date) BETWEEN 4 AND 6 THEN '2Q'
        WHEN EXTRACT(MONTH FROM hire_date) BETWEEN 7 AND 9 THEN '3Q'
        ELSE '4Q'
     END Quarter
     , TO_CHAR(hire_date,'Q') Quarter2
FROM employees
) t
GROUP BY Quarter
ORDER BY Quarter;
--------------------------------------------------------------------
-- DECODE() 사용
SELECT COUNT(DECODE(TO_CHAR(hire_date, 'Q'),1,'O')) quarter_1
    ,COUNT(DECODE(TO_CHAR(hire_date, 'Q'),2,'O')) quarter_2
    ,COUNT(DECODE(TO_CHAR(hire_date, 'Q'),3,'O')) quarter_3
    ,COUNT(DECODE(TO_CHAR(hire_date, 'Q'),4,'O')) quarter_4
FROM employees;

