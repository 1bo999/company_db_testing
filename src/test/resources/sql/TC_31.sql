SELECT e.emp_no, e.first_name, e.last_name, s.salary FROM employees e JOIN salaries s ON e.emp_no = s.emp_no JOIN dept_emp de ON e.emp_no = de.emp_no
WHERE de.dept_no = 'd004' AND s.to_date = '9999-01-01' AND de.to_date = '9999-01-01' ORDER BY s.salary DESC LIMIT 1;
