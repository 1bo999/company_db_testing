SELECT e.*,s.salary
FROM employees e
JOIN salaries s ON e.emp_no=s.emp_no
WHERE e.dept_no='d007'
ORDER BY s.salary DESC;