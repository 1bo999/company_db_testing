SELECT e.emp_no, e.first_name, e.last_name, e.hire_date, s.salary FROM employees e JOIN salaries s ON e.emp_no = s.emp_no WHERE e.hire_date > ?
AND s.salary > ? AND s.to_date = '9999-01-01';
