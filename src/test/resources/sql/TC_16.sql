SELECT d.dept_name, e.first_name, e.last_name, s.salary AS peak_salary FROM departments d JOIN dept_emp de ON d.dept_no = de.dept_no
JOIN employees e ON de.emp_no = e.emp_no JOIN salaries s ON e.emp_no = s.emp_no WHERE s.salary = (SELECT MAX(s2.salary)
FROM salaries s2 JOIN dept_emp de2 ON s2.emp_no = de2.emp_no WHERE de2.dept_no = d.dept_no) ORDER BY peak_salary DESC;
