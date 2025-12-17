SELECT CONCAT(e.first_name, ' ', e.last_name) AS full_name,
	   AVG(s.salary) AS avg_salary
FROM departments d
JOIN employees e ON e.dept_no = d.dept_no
JOIN salaries s ON e.emp_no = s.emp_no
JOIN dept_emp de ON de.dept_no = d.dept_no
WHERE d.dept_name = ?
GROUP BY e.emp_no, e.first_name, e.last_name
ORDER BY avg_salary DESC
LIMIT 1;