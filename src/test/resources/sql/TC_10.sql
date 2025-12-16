SELECT e.emp_no, CONCAT(e.first_name, ' ', e.last_name) AS full_name, s.salary, s.from_date, s.to_date
FROM employees e
JOIN salaries s ON e.emp_no = s.emp_no
WHERE e.emp_no = ?
ORDER BY s.from_date;