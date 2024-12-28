# Institute Manager

### Technologies Used
- Java
- Spring Boot
- Hibernate/JPA
- PostgreSQL
- Maven

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/rp194/instituteDemo.git
   cd StudentManager
   ```
2. Create a database in PostgreSQL using the configurations provided in the `docker-compose.yml` file
3. Run this command in your terminal to set up the database
   ```bash
    docker-compose up
5. Update the `src/main/resources/application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
   spring.datasource.username=your_chosen_username
   spring.datasource.password=your_chosen_password
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.jpa.hibernate.ddl-auto=update
   ```
## Build the project:
```bash
 mvn clean install
```
## Run the application:
```bash
 mvn spring-boot:run
```
The application should now be accessible at http://localhost:8080
