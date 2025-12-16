SELECT e.first_name, e.last_name, d.dept_name, s.salary
FROM employees e
JOIN dept_emp de ON de.emp_no = e.emp_no
JOIN departments d ON de.dept_no = d.dept_no
JOIN salaries s ON s.emp_no = e.emp_no
WHERE d.dept_name = ?
AND s.salary >= ?
AND s.salary <= ?;