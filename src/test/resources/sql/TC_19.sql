SELECT emp_no, birth_date, first_name, last_name, gender, hire_date,dept_no
FROM employees
WHERE hire_date
BETWEEN '1985-01-01'
AND '1989-12-31'
ORDER BY hire_date;
