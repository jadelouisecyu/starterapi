**Employee Management API**

**Features**
- Add new employees with unique IDs (can successfully add employee only when there are no existing email addresses in json)
- Retrieve all employees

**Tech Stack**
- Java 17
- Spring Boot
- Database: n/a (utilized json for data storage)
- Build tool: Gradle
- API testing: Postman

**Installation**
- Java 17+
- Gradle 8.11
- Install Spring boot extension in VScode or equivalent for other IDEs
- Postman (optional)

**Steps to run**
- clone the project to your workspace
- open StarterApiApplication.java
- open new terminal and run commands (.gradlew clean build) and (./gradlew --refresh-dependencies)
- once successful, Run
- open postman
- test api

**Endpoints**
Example Request/Response
1. Fetch all employees ( GET )
   - GET /api/employees
   - Body: None
   - Response: list of all employees
3. Add an Employee ( POST )
   - POST /api/employees/create
   - Content-Type: application/json
   - Body:
   {
      "title": "Software Engineer",
      "firstName": "John",
      "lastName": "Doe",
      "dateOfBirth": "1990-01-01",
      "gender": "Male",
      "emailAddress": "johndoe@example.com"
    }
   - Response:
   {
      "employeeNo": "f62e5e6d-abc3-4ef5-8c89-01b765349a56",
      "title": "Software Engineer",
      "firstName": "John",
      "lastName": "Doe",
      "dateOfBirth": "1990-01-01",
      "gender": "Male",
      "emailAddress": "johndoe@example.com"
    }
   
**Error handling:**
- 400 Bad Request: Invalid input data.
- 500 Internal Server Error: Unexpected server error.

**Given more time, I would:**
- add more validation (e.g. email format, gender, birthdate needs to be in the past)
- customize api responses (status, body)
- connect in mysql
- add more features to the starter api (delete employee, update resource)
