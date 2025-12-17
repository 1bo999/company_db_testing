SELECT e.emp_no, e.first_name, e.last_name, 'EMPLOYEE' AS role
FROM employees e
JOIN dept_emp de ON e.emp_no = de.emp_no
WHERE de.dept_no = ? AND de.to_date = '9999-01-01'
UNION SELECT e.emp_no, e.first_name,e.last_name, 'MANAGER' AS role
FROM employees e
JOIN dept_manager dm ON e.emp_no = dm.emp_no
WHERE dm.dept_no = ?
AND dm.to_date = '9999-01-01';
