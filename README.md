# Spring Boot CRUD API

This is a simple Spring Boot CRUD API with MySQL integration.

## Prerequisites
- Java JDK
- MySQL
- Maven

## Database Setup
1. Create a MySQL database with the name `entity`.
2. Update `spring.datasource.username` and `spring.datasource.password` in `application.properties` with your MySQL credentials.

## Running the Application
1. Clone the repository.
2. Open a terminal and navigate to the project root directory.
3. Run the following command to build the project:
   ```bash
   mvn clean install

   
## API Endpoints
*Create a new user:
POST /api/users
Request Body: User JSON

*Read user details by user ID:
GET /api/users/{userId}

*Update user details by user ID:
PUT /api/users/{userId}
Request Body: User JSON

*Delete a user by user ID:
DELETE /api/users/{userId}


Replace placeholders such as `your_database_name`, `your_database_username`, and `your_database_password` with your actual MySQL database information.

This is a basic setup, and you may need to adjust it based on your specific requirements and preferences. Additionally, you should consider adding validation, error handling, and security features for a production-ready application.
