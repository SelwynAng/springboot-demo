# SpringBoot Demo Application
- A demo backend created using Spring JPA with connection to a PostgresSQL database.
- Demonstrates how to handle HTTP requests which will cause changes in the database, using Student as an example.
- Demo application consists of 3 layers:
  1. **Data Access Layer:** Handles the HTTP requests to the backend (`StudentController.java`)
  2. **Service Layer:** Handles business logic related to the HTTP request (`StudentService.java`)
  3. **API Layer:** Handles the interaction with the database (`StudentRepository.java`)
- Demo application's database is pre-populated with data via `StudentConfig.java`, using `Student.java` as a model.
