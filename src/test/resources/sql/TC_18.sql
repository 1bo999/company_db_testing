SELECT emp_no, birth_date, first_name, last_name, gender, hire_date
FROM employees
WHERE hire_date < '1990-01-01'
ORDER BY first_name, last_name;
