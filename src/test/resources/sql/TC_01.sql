SELECT emp_no,birth_date, first_name, last_name, gender, hire_date, dept_no
FROM employees
WHERE dept_no = ?
ORDER BY first_name;