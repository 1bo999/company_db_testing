SELECT e.first_name, e.last_name, e.emp_no, d.dept_name, d.dept_no
FROM employees e
JOIN dept_emp de ON e.emp_no = de.emp_no
JOIN departments d ON d.dept_no = de.dept_no
WHERE d.dept_name = ?;