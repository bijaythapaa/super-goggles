# super-goggles
a RESTful Spring Boot API for tracking expenses.

This is my starter RESTful API written in Java Spring Boot framework with PostgreSQL database.

I have made some advancements in this project than in my previous project [fluffy-train](https://github.com/dbijaya/fluffy-train).

In this project, I have tried to use JWT authentication token to authenticate user to the system.

So, this system has three database Entities: User, Categories and Transactions. User can have different categories of Expenses and every category can have many expense transactions. 

**Advancements:** 
- JWT Token Authentication: JSON Web Token used for authenticating users, and authorizing the HTTP Requests-Response in API.
- PostgreSQL Database: In previous project, I used MySQL database, but this project has PostgreSQL database.
- also, I used Hibernate inplace of JPA.
	- Read: [Hibernate vs. JPA](https://dzone.com/articles/what-is-the-difference-between-hibernate-and-sprin-1#:~:text=Hibernate%20is%20a%20JPA%20implementation,solution%20to%20GenericDao%20custom%20implementations.&text=question%20at%20StackOverflow.-,Hibernate%20provides%20a%20reference%20implementation%20of%20the%20Java%20Persistence%20API,with%20benefits%20of%20loose%20coupling.) , more about [Hibernate](https://www.javaguides.net/p/hibernate-tutorial.html).
  
## Explore Rest APIs

The app defines following CRUD APIs.

    POST /api/users/login
 
    POST /api/users/register
    
    GET /api/categories/
    
    GET /api/categories/{categoryId}
    
    POST /api/categories/
    
    PUT /api.categories/{categoryId}
        
    DELETE /api/categories/{categoryId}
    
    GET /api/categories/{categoryId}/transactions
    
    GET /api/categories/{categoryId}/transactions/{transactionId}
    
    POST /api/categories/{categoryId}/transactions
    
    PUT /api/categories/{categoryId}/transactions/{transactionId}
    
    DELETE /api/categories/{categoryId}/transactions/{transactionId}

Test these requests using Postman or any other HTTP REST-client.

## Set-Up
**1. Clone project:**

First, locate to your local Directory then hit:

```bash
git clone https://github.com/dbijaya/super-goggles/
```

**2. PostgreSQL database:**

in project directory, it has [expensetracker_db.sql](https://github.com/dbijaya/super-goggles/blob/main/expensetracker_db.sql), execute this file to your PostgreSQL database for database setup.

**3. Update application.properties:**
+ change 
`spring.datasource.url=jdbc:postgresql://localhost:5432/your-db-name`, `spring.datasource.username` and `spring.datasource.password` per as your PostgreSQL installation set-up.

**4. Run API:**
1. ```bash
    mvn clean install
    ```

2. ```bash
    mvn spring-boot:run
    ```
**with luck, it should work :)**
