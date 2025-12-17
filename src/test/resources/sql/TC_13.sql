SELECT e.emp_no, CONCAT(e.first_name, ' ', e.last_name) AS full_name, s.salary
FROM employees e
INNER JOIN salaries s ON e.emp_no = s.emp_no
WHERE s.to_date = ?;