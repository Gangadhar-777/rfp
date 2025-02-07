# Spring Boot Microservices Project

## Overview
This project consists of two microservices built using **Spring Boot**:
1. **User Service** - Manages user authentication and profile retrieval.
2. **RFP Service** - Handles creation, retrieval, and updates of RFPs (Request for Proposals).

## Microservices Details

### 1. User Service
#### **Functionalities:**
- **Login** - Authenticate users using credentials.
- **Registration** - Register a new user in the system.
- **Get User by Email** - Retrieve user details based on email.

#### **Endpoints:**
| Method | Endpoint         | Description             |
|--------|-----------------|-------------------------|
| POST   | `/login`  | Authenticate user       |
| POST   | `/register` | Register a new user   |
| GET    | `user?email={email}` | Get user details by email |

---

### 2. RFP Service
#### **Functionalities:**
- **Create RFP** - Allows users to submit an RFP.
- **Get RFP** - Retrieve an existing RFP.
- **Update RFP** - Modify an existing RFP.

#### **Endpoints:**
| Method | Endpoint           | Description          |
|--------|-------------------|----------------------|
| POST   | `/rfp`            | Create a new RFP    |
| GET    | `/rfp`            | Get all RFP details    |
| GET    | `/rfp/{id}`       | Get RFP details     |
| PUT    | `/rfp`       | Update RFP details  |

---

## Technologies Used
- **Spring Boot** - Microservices framework
- **Spring Web** - RESTful API support
- **Spring Data JPA** - Database interaction
- **H2/MySQL/PostgreSQL** - Database (choose one based on environment)
- **Spring Security (Optional)** - Authentication & Authorization

## Running the Microservices
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/spring-boot-microservices.git
   cd spring-boot-microservices
   ```
2. Navigate to each service (`user-service/`, `rfp-service/`) and run:
   ```sh
   mvn spring-boot:run
   ```
3. The services will be available at:
   - **User Service**: `http://localhost:8080`
   - **RFP Service**: `http://localhost:8080`

## API Testing
Use **Postman** or **cURL** to test the APIs.

---

### Contributing
Feel free to submit issues or contribute to the project by creating a pull request.

### License
This project is open-source and available under the MIT License.

