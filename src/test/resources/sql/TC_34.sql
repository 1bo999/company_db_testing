SELECT d.dept_name, COUNT(de.emp_no) AS employee_count FROM departments d JOIN dept_emp de ON d.dept_no = de.dept_no GROUP BY d.dept_name;
