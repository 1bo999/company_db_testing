SELECT d.dept_no, d.dept_name, AVG(s.salary) AS average_salary
FROM employees e
JOIN dept_emp de ON de.emp_no = e.emp_no
JOIN departments d ON de.dept_no = d.dept_no
JOIN salaries s ON s.emp_no = e.emp_no
GROUP BY d.dept_no, d.dept_name;