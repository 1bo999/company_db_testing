SELECT (SELECT COUNT(DISTINCT first_name)
FROM employees) AS unique_first_names, (SELECT COUNT(DISTINCT dept_name)
FROM departments) AS department_count;
