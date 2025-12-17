SELECT emp_no,birth_date, first_name, last_name, gender, hire_date, dept_no
FROM employees
WHERE EXTRACT(YEAR  FROM hire_date)= 1992;