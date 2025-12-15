SELECT d.dept_name, e.first_name, e.last_name, AVG(s.salary) AS avg_salary FROM departments d JOIN dept_emp de                                                                                  ON d.dept_no = de.dept_no JOIN employees e ON de.emp_no = e.emp_no JOIN salaries s ON e.emp_no = s.emp_no
GROUP BY d.dept_name, d.dept_no, e.emp_no, e.first_name, e.last_name HAVING AVG(s.salary) = (SELECT MAX(avg_salary)
FROM (SELECT AVG(s2.salary) AS avg_salary FROM salaries s2 JOIN dept_emp de2 ON s2.emp_no = de2.emp_no WHERE
de2.dept_no = d.dept_no GROUP BY s2.emp_no) sub) ORDER BY avg_salary DESC;