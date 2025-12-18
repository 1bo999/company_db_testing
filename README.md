<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Company Database – Test Automation Project</title>
<style>
    body {
    font-family: Arial, sans-serif;
    line-height: 1.6;
    margin: 0;
    padding: 0 20px;
    color: #333;
}
    h1, h2, h3 {
        color: white;
    }
    h1 {
        text-align: center;
        margin-top: 20px;
    }
    .badges img {
        margin: 5px 5px 10px 0;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 10px;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #333;
        color: #fff;
    }
    code {
        background: #eee;
        padding: 2px 6px;
        border-radius: 2px;
        font-size: 1.5em;
    }
    pre {
        background: gre;
        padding: 10px;
        border-radius: 6px;
        overflow-x: auto;
    }
    .contributors {
        background: none;
        padding: 1px;
        border-radius: 10px;
        margin-bottom: 5px;
    }
    .gif {
        display: block;
        max-width: 200px;
        margin: 0 auto 30px;
    }
    section {
        margin-bottom: 1px;
    }
</style>
</head>
<body>

<h1>🏢 Company Database – Test Automation Project</h1>

<div class="badges">
    <img src="https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk&logoColor=white">
    <img src="https://img.shields.io/badge/TestNG-7.11.0-red?style=for-the-badge&logo=testng&logoColor=white">
    <img src="https://img.shields.io/badge/PostgreSQL-42.7.8-blue?style=for-the-badge&logo=postgresql&logoColor=white">
    <img src="https://img.shields.io/badge/Maven-3.8+-blue?style=for-the-badge&logo=apachemaven&logoColor=white">
    <img src="https://img.shields.io/badge/SLF4J-2.0.16-lightgrey?style=for-the-badge">
    <img src="https://img.shields.io/badge/Log4j-2.24.3-red?style=for-the-badge">
</div>

<section>
<h2>📌 Overview</h2>
<p>This framework is designed to test <strong>SQL queries</strong> for a company employee database. It follows a <strong>modular, maintainable, and scalable structure</strong> using:</p>
<ul>
    <li><strong>BaseTest</strong> class for database connections</li>
    <li><strong>TestNG</strong> for test execution and validation</li>
    <li><strong>PostgreSQL JDBC</strong> for database operations</li>
    <li><strong>SLF4J + Log4j</strong> for logging</li>
</ul>
</section>

<section>
<h2>🚀 Key Features</h2>
<ul>
    <li>✔️ Reusable Database Connection</li>
    <li>✔️ Dynamic Query Execution</li>
    <li>✔️ Structured Assertions for result validation</li>
    <li>✔️ Error Handling for invalid queries or connections</li>
    <li>✔️ Logging Integration with SLF4J and Log4j</li>
    <li>✔️ Maven + TestNG Execution</li>
</ul>
</section>

<section>
<h2>🧪 Test Coverage Summary</h2>
<table>
<thead>
<tr>
<th>Test Case</th>
<th>Description</th>
<th>Status</th>
</tr>
</thead>
<tbody>
<tr><td>TC_01</td><td>List all employees in department D001</td><td>🟢 Passed</td></tr>
<tr><td>TC_02</td><td>List all employees in 'Human Resources' department</td><td>🟢 Passed</td></tr>
<tr><td>TC_03</td><td>Calculate the average salary of all employees</td><td>🟢 Passed</td></tr>
<tr><td>TC_04</td><td>Calculate the average salary of all employees with gender "M"</td><td>🟢 Passed</td></tr>
<tr><td>TC_05</td><td>Calculate the average salary of all employees with gender "F"</td><td>🟢 Passed</td></tr>
<tr><td>TC_06</td><td>List all employees in the "Sales" department with a salary greater than 70,000</td><td>🟢 Passed</td></tr>
<tr><td>TC_07</td><td>Retrieve employees with salaries between 50,000 and 100,000</td><td>🟢 Passed</td></tr>
<tr><td>TC_08</td><td>Calculate the average salary for each department</td><td>🟢 Passed</td></tr>
<tr><td>TC_09</td><td>Calculate the average salary for each department, including department names</td><td>🟢 Passed</td></tr>
<tr><td>TC_10</td><td>Find all salary changes for employee with emp. no '10102'</td><td>🟢 Passed</td></tr>
<tr><td>TC_11</td><td>Find the salary increases for employee '10102' using to_date</td><td>🟢 Passed</td></tr>
<tr><td>TC_12</td><td>Find the employee with the highest salary</td><td>🟢 Passed</td></tr>
<tr><td>TC_13</td><td>Find the latest salaries for each employee</td><td>🟢 Passed</td></tr>
<tr><td>TC_14</td><td>List first name, last name, and highest salary of Sales employees</td><td>🟢 Passed</td></tr>
<tr><td>TC_15</td><td>Employee with highest salary average in Research department</td><td>🟢 Passed</td></tr>
<tr><td>TC_16</td><td>Highest single salary per department with employee info</td><td>🟢 Passed</td></tr>
<tr><td>TC_17</td><td>Employees with highest average salary per department</td><td>🟢 Passed</td></tr>
<tr><td>TC_18</td><td>List employees hired before 1990-01-01 alphabetically</td><td>🟢 Passed</td></tr>
<tr><td>TC_19</td><td>Employees hired between 1985-01-01 and 1989-12-31, sorted by hire date</td><td>🟢 Passed</td></tr>
<tr><td>TC_20</td><td>Sales employees hired 1985–1989, sorted by salary descending</td><td>🟢 Passed</td></tr>
<tr><td>TC_21</td><td>Employee gender counts (male/female/total)</td><td>🟢 Passed</td></tr>
<tr><td>TC_22</td><td>Count unique first names and department names</td><td>🟢 Passed</td></tr>
<tr><td>TC_23</td><td>Number of employees per department</td><td>🟢 Passed</td></tr>
<tr><td>TC_24</td><td>Employees hired within 5 years from 1990-02-20</td><td>🟢 Passed</td></tr>
<tr><td>TC_25</td><td>Information of employee "Annemarie Redmiles"</td><td>🟢 Passed</td></tr>
<tr><td>TC_26</td><td>Complete employee info for "Annemarie Redmiles"</td><td>🟢 Passed</td></tr>
<tr><td>TC_27</td><td>List all employees and managers in D005</td><td>🟢 Passed</td></tr>
<tr><td>TC_28</td><td>Employees hired after 1994-02-24 with salary &gt;50,000</td><td>🟢 Passed</td></tr>
<tr><td>TC_29</td><td>"Sales" employees with title "Manager"</td><td>🟢 Passed</td></tr>
<tr><td>TC_30</td><td>Department where employee '10102' worked the longest</td><td>🟢 Passed</td></tr>
<tr><td>TC_31</td><td>Highest paid employee in department D004</td><td>🟢 Passed</td></tr>
<tr><td>TC_32</td><td>Full position history for employee '10102'</td><td>🟢 Passed</td></tr>
<tr><td>TC_33</td><td>Calculate average employee age</td><td>🟢 Passed</td></tr>
<tr><td>TC_34</td><td>Number of employees per department</td><td>🟢 Passed</td></tr>
<tr><td>TC_35</td><td>Managerial history of employee 110022</td><td>🟢 Passed</td></tr>
<tr><td>TC_36</td><td>Duration of employment for each employee</td><td>🟢 Passed</td></tr>
<tr><td>TC_37</td><td>Latest title information for each employee</td><td>🟢 Passed</td></tr>
<tr><td>TC_38</td><td>First and last names of managers in D005</td><td>🟢 Passed</td></tr>
<tr><td>TC_39</td><td>Sort employees by birth dates</td><td>🟢 Passed</td></tr>
<tr><td>TC_40</td><td>Employees hired in April 1992</td><td>🟢 Passed</td></tr>
<tr><td>TC_41</td><td>All departments employee '10102' worked in</td><td>🟢 Passed</td></tr>
</tbody>
</table>
</section>

<section>
<h2>📦 Technologies Used</h2>
<ul>
<li>Java 21</li>
<li>TestNG 7.11.0</li>
<li>PostgreSQL 42.7.8</li>
<li>Maven 3.8+</li>
<li>SLF4J 2.0.16</li>
<li>Log4j 2.24.3</li>
<li>Allure Report</li>
</ul>
</section>

<section>
<h2>▶️ Clone and Run Tests</h2>
<pre>https://github.com/your-repo/company_db_testing.git
</section>

<section>
<h2>👥 Contributors</h2>
<div class="contributors">
<ul>
<li>Ibrahim Huseynli</li>
<li>Sibel Cebeci</li>
</ul>
</div>
</section>
<img class="gif" src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExNGJyb3BwNXRud2loY3dqNDdqaGNlN2syNjdwejc2cXdncnBuMjk1ZCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/l2qJnXbUzQAeY/giphy.gif" alt="Project Animation">

</body>
</html>
