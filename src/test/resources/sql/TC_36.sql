SELECT first_name, last_name, emp_no,
CURRENT_DATE-hire_date AS emp_duration
FROM employees;