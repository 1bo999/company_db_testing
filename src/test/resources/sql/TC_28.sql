SELECT e.emp_no, CONCAT(e.first_name, ' ', e.last_name) AS full_name, s.salary
FROM employees e JOIN salaries s ON e.emp_no = s.emp_no
WHERE e.hire_date > ?
AND s.salary > ?
AND s.to_date = '9999-01-01';
