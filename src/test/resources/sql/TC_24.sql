SELECT emp_no, birth_date, first_name, last_name, gender, hire_date
FROM employees
WHERE hire_date
BETWEEN '1985-02-20'
AND '1990-02-20'
ORDER BY hire_date;
