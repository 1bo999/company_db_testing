SELECT d.dept_name, d.dept_no
FROM dept_emp de
JOIN departments d ON de.dept_no = d.dept_no
WHERE de.emp_no = 10102;