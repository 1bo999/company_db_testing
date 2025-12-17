SELECT e.emp_no, e.first_name, e.last_name
FROM employees e
JOIN dept_emp de ON e.emp_no = de.emp_no
JOIN departments d ON de.dept_no = d.dept_no
JOIN titles t ON e.emp_no = t.emp_no
WHERE d.dept_name = 'Sales'
AND t.title = 'Manager'
AND de.to_date = '9999-01-01'
AND t.to_date = '9999-01-01';
