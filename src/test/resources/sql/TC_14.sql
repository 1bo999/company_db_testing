SELECT CONCAT(e.first_name, ' ', e.last_name) AS full_name, s.salary
FROM departments d
JOIN employees e on e.dept_no = d.dept_no
JOIN salaries s ON e.emp_no=s.emp_no
WHERE d.dept_name= ?
ORDER BY s.salary DESC;