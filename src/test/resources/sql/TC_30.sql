SELECT d.dept_name
FROM dept_emp de
JOIN departments d ON de.dept_no = d.dept_no
WHERE de.emp_no = 10102
ORDER BY (de.to_date - de.from_date) DESC LIMIT 1;
