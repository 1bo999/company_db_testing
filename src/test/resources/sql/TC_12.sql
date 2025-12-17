SELECT e.emp_no, e.birth_date, e.first_name, e.last_name, e.gender, e.hire_date, e.dept_no
FROM employees e
JOIN salaries s ON e.emp_no=s.emp_no
ORDER BY s.salary DESC LIMIT 1;