# Uber Auth Service

A Java-based microservice for authentication and authorization in an Uber-like system. Built with **Spring Boot**, **Spring Security**, **JWT**, and **MySQL**. This service handles passenger signup, login, and secure token-based authentication.

---

## Microservices

This Uber project is split into multiple microservices:

| Service          | Description                                                                 | Link                                                                      |
|------------------|-----------------------------------------------------------------------------|---------------------------------------------------------------------------|
| Entity Service   | Manages core entities like Booking, Passenger, Driver, Review, and Locations | [GitHub Repo](https://github.com/himansh025/Comman-Entity)                |
| Booking Service  | Handles ride bookings, availability, and scheduling                         | [GitHub Repo](https://github.com/himansh025/Booking-Service)              |
| Socket Service   | Handles asynchronous requests between booking, driver, and passenger        | [GitHub Repo](https://github.com/himansh025/Uber-SocketServer.git)        |
| Auth Service     | Handles passenger signup, login, and JWT-based authentication               | [GitHub Repo](https://github.com/himansh025/AuthService)                  |
| Location Service | Manages driver locations and finds nearby drivers                            | [GitHub Repo](https://github.com/himansh025/Location-Service)             |
| Review Service   | Manages ride reviews for passengers and drivers                             | [GitHub Repo](https://github.com/himansh025/ReviewServices)               |

---

## Table of Contents

- [About](#about)
- [Features](#features)
- [Models](#models)
- [API Endpoints](#api-endpoints)
- [Security](#security)
- [Dependencies](#dependencies)
- [Setup](#setup)
- [License](#license)

---

## About

The **Auth Service** manages authentication and authorization for passengers:

- **Passenger Signup**: Registers new passengers securely.
- **Passenger Signin**: Authenticates passengers and issues JWT tokens.
- **JWT-based Security**: Stateless authentication using Spring Security filters.
- **Password Encryption**: Securely stores hashed passwords using BCrypt.

---

## Features

- Passenger signup and login.
- JWT token generation and validation.
- Secure API endpoints with role-based access.
- Password hashing using BCrypt.
- Stateless session management.

---

## Models

### Passenger
- `id`: Unique identifier.
- `name`: Passenger’s full name.
- `email`: Unique email used for login.
- `phoneNumber`: Contact number.
- `password`: Hashed password using BCrypt.

### DTOs
- `PassengerSignupDto`: Payload for signup (name, email, phoneNumber, password).
- `PassengerDto`: Response DTO after signup.
- `AuthRequestDto`: Payload for login (email, password).

---

## API Endpoints

| Endpoint        | Method | Description                        |
|-----------------|--------|------------------------------------|
| `/auth/signup`  | POST   | Passenger signup                   |
| `/auth/signin`  | POST   | Passenger login (returns JWT token)|

**Example Request:**

**Signup**
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "phoneNumber": "9876543210",
  "password": "password123"
}

Security

Spring Security with SecurityFilterChain for stateless authentication.

JWTFilter validates tokens for protected endpoints.

Public endpoints: /auth/signup, /auth/signin, /api/*.

Passwords encrypted using BCryptPasswordEncoder.

Spring Security Configuration Example:


Setup

Clone the repository:

git clone <repository-url>


Configure MySQL database in application.properties.

Run the service using Spring Boot:

./gradlew bootRun


Use /auth/signup to register a passenger and /auth/signin to obtain a JWT token.