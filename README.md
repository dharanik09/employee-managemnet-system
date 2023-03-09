# employee-managemnet-system
Technology
Java 8
Spring Boot 2.6.2 (with Spring Web MVC, Spring Data JPA)
MySQL
Maven 3.8.1
Project Structure


 Let me explain it briefly.
– Employee, Company data model class correspond to entity and table employee, company.
– EmployeeRepository, companyRepository are interfaces that extends JpaRepository for CRUD methods and custom finder methods. It will be autowired in EmployeeController, CompanyController.
– EmployeeController, CompanyController are RestControllers which has request mapping methods for RESTful CRUD API requests.
– Configuration for Spring Datasource, JPA & Hibernate in application.properties.
– pom.xml contains dependencies for Spring Boot and MySQL database.

Create & Setup Spring Boot project
Use Spring web tool or your development tool (Spring Tool Suite, Eclipse, Intellij) to create a Spring Boot project. Then open pom.xml and you can see added addtached file dependencies:
I have attached springboot project and you can import via maven existing projects

Configure Spring Datasource, JPA, Hibernate
Under src/main/resources folder, open application.properties and you should change databse password which you have configured.
spring.datasource.username & spring.datasource.password properties are the same as your database installation.
Spring Boot uses Hibernate for JPA implementation, we configure MySQL5InnoDBDialect for MySQL or PostgreSQLDialect for PostgreSQL
spring.jpa.hibernate.ddl-auto is used for database initialization. We set the value to update value so that a table will be created in the database automatically corresponding to defined data model. Any change to the model will also trigger an update to the table. For production, this property should be validate.

DataBase
I have attached database file in the folder and import in your mysal workbench.
employee-storage-service.zip\employee-storage-service\database
Run : compile and test rest url which is below in Postman or.. .
Building requests
You can send requests in Postman to connect to APIs you are working with. Your requests can retrieve, add, delete, and update data. 
We also write Rest Apis to perform CRUD operations on the Company entities.
These are APIs that we need to provide:
Methods	Urls	Actions
POST	http://localhost:8083/api/addCompany	create new company list
POST	http://localhost:8083/api/30/employees	create new employee list
GET	http://localhost:8083/api/getEmployeesDetails	retrieve all employees list with company name
PUT	http://localhost:8083/api/updateEmployees/133  update a employee details by :id

DELETE	http://localhost:8083/api/deleteEmployeesByID	delete a employee by :id
GET	http://localhost:8083/api/getEmployeesAvgSalary	retrieve Average salary for company  

These are APIs with Screenshot that we need to provide:
1. POST	http://localhost:8083/api/addCompany	create new company list


