SELECT AVG(s.salary) AS average_salary
FROM salaries s
JOIN employees e ON e.emp_no = s.emp_no
WHERE e.gender = ?;