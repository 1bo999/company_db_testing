SELECT e.emp_no, e.birth_date, e.first_name, e.last_name, e.gender, e.hire_date, s.salary, d.dept_name, t.title
FROM employees e
JOIN salaries s ON e.emp_no = s.emp_no
JOIN dept_emp de ON e.emp_no = de.emp_no
JOIN departments d ON de.dept_no = d.dept_no
JOIN titles t ON e.emp_no = t.emp_no
WHERE e.first_name = ?
AND e.last_name = ?
AND s.to_date = '9999-01-01'
AND de.to_date = '9999-01-01'
AND t.to_date = '9999-01-01';
