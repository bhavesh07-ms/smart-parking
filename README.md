# 🅿️ Smart Parking System

A scalable, modular **Smart Parking System** built using **Spring Boot**, aimed at managing vehicles, parking floors, and dynamic spot allocation. Designed with real-world production standards including clean architecture, testability, and extensibility.

---

## 📌 Features

- 🚗 Vehicle Check-in & Check-out
- 🅿️ Dynamic Parking Spot Allocation based on `VehicleType`
- 📊 Rate Card Management (per hour billing)
- 🧠 Smart Floor Availability Detection
- ✅ Clean Domain-Driven Model with JPA
- 🔧 RESTful API integration
- 🧪 Testable & Scalable Design

---

## 🛠️ Tech Stack

| Layer          | Technology          |
|----------------|---------------------|
| Language       | Java 17+            |
| Framework      | Spring Boot 3.x     |
| ORM            | JPA (Hibernate)     |
| Database       | H2 / PostgreSQL     |
| Build Tool     | Maven / Gradle      |
| Testing        | JUnit + MockMvc     |
| API Testing    | Postman             |

---

## 📁 Project Structure

```bash
src/
├── main/
│   ├── java/com/example/parking/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── model/
│   │   ├── repository/
│   │   └── SmartParkingApplication.java
│   └── resources/
│       ├── application.yml
│       └── data.sql
├── test/
│   └── java/com/example/parking/
└── pom.xml
