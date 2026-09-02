# 🏬 Shopping Mall Management System - Backend

A Spring Boot based backend application for managing day-to-day operations of a shopping mall — shops, employees, items, customers, shop owners, and orders — exposed via a clean set of REST APIs.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Maven](https://img.shields.io/badge/Build-Maven-red)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 📖 Overview

**Shopping Mall Management System** provides REST APIs for managing shops, employees, items, and customers within a mall. It follows a standard layered architecture (Controller → Service → Repository) and uses PostgreSQL for persistence via Spring Data JPA and Hibernate. Postman is used for API testing.

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java 17 | Core language |
| Spring Boot | Application framework |
| Spring Data JPA | Data access abstraction |
| Hibernate | ORM implementation |
| PostgreSQL | Relational database |
| Maven | Build & dependency management |
| Postman | API testing |
| Spring Tools for Eclipse | IDE |

---

## 📦 Modules

- Shop Management
- Employee Management
- Item Management
- Customer Management
- Shop Owner
- Order Details

---

## 🏗️ Architecture

```
Client / Postman
      |
      | REST / JSON
      v
  Controllers
      |
      v
   Services
      |
      v
  Repositories
      |
      v
 JPA / Hibernate
      |
      v
  PostgreSQL
```

A request from the client (Postman) is received by the **Controller**, which delegates to the **Service** layer. The Service layer performs the required business logic through the **Repository**, and Spring Data JPA / Hibernate handle communication with PostgreSQL.

---

## 📂 Project Structure

```
src/main/java/com/shoppingmall
│
├── controller
│   ├── CustomerController.java
│   ├── EmployeeController.java
│   ├── ItemController.java
│   └── ShopController.java
│
├── entity
│   ├── Customer.java
│   ├── Employee.java
│   ├── Item.java
│   ├── OrderDetails.java
│   ├── Shop.java
│   └── ShopOwner.java
│
├── repository
│   ├── ICustomerRepository.java
│   ├── IEmployeeRepository.java
│   ├── IItemRepository.java
│   └── IShopRepository.java
│
├── service
│   ├── ICustomerService.java
│   ├── IEmployeeService.java
│   ├── IItemService.java
│   └── IShopService.java
│
└── service.impl
    ├── CustomerServiceImpl.java
    ├── EmployeeServiceImpl.java
    ├── ItemServiceImpl.java
    └── ShopServiceImpl.java
```

---

## 🔗 Entity Relationship

Employees, Items, and Customers can each be associated with a Shop:

```
                 Shop
                  |
   ---------------------------------
   |               |               |
   v               v               v
Employee         Item          Customer
```

This relationship is implemented using JPA relationships in the entity classes.

---

## 🚀 Features

- REST API based backend
- Shop CRUD operations
- Employee management
- Item management
- Customer management
- PostgreSQL database integration
- JPA and Hibernate based database operations
- Postman API testing
- Layered architecture using Controller, Service, and Repository

---

## 📡 API Endpoints

### Shop Management

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/shops` | Add a new shop |
| `GET` | `/api/shops/{id}` | Search a shop by ID |
| `PUT` | `/api/shops` | Update shop details |
| `DELETE` | `/api/shops/{id}` | Delete a shop |

### Employee Management

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/shops/employees` | Add an employee |
| `PUT` | `/api/shops/employees` | Update employee details and associate with a shop |

### Item Management

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/shops/items` | Add an item and associate it with a shop |

### Customer Management

Customer details are managed and can be associated with a shop via the shop relationship.

---

## 🗄️ Database

- **Database Engine:** PostgreSQL
- **Database Name:** `shopping_mall`
- **Port:** `5432`

### Tables

- `shop`
- `employee`
- `item`
- `customer`
- `shop_owner`
- `order_details`

The application uses Spring Data JPA and Hibernate for all database operations.

---

## ⚙️ Database Setup

**1. Create the database in PostgreSQL:**

```sql
CREATE DATABASE shopping_mall;
```

**2. Configure your database credentials** in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/shopping_mall
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8082
```

> With `spring.jpa.hibernate.ddl-auto=update`, Hibernate will automatically create or update the required tables based on the entity classes.

> ⚠️ **Important:** Do not commit your actual PostgreSQL password or other sensitive information to GitHub. Always use your own database username and password when running the project locally.

---

## ▶️ Running the Application

**Option 1 — Using Maven:**

```bash
mvn clean spring-boot:run
```

**Option 2 — Using Spring Tools for Eclipse:**

Open the project in Spring Tools for Eclipse and run `ShoppingMallManagementApplication.java`.

The application will be available at:

```
http://localhost:8082
```

---

## 🧪 API Testing with Postman

The main HTTP methods used are `POST` (Create), `GET` (Read), `PUT` (Update), and `DELETE` (Delete).

**Add a shop**

```
POST http://localhost:8082/api/shops
Content-Type: application/json

{
    "shopId": 1,
    "shopName": "Fashion Hub",
    "shopCategory": "Clothing",
    "customers": "10",
    "shopStatus": "OPEN",
    "leaseStatus": "ACTIVE"
}
```

**Search a shop by ID**

```
GET http://localhost:8082/api/shops/1
```

**Update a shop**

```
PUT http://localhost:8082/api/shops
```

**Delete a shop**

```
DELETE http://localhost:8082/api/shops/1
```

---

## 👤 Author

**Ajithcurrun**

---

## 📄 License

This project is open source. Feel free to use, modify, and distribute it for learning purposes.