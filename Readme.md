# Spring WebFlux Reactive API Example

This project is a **simple Spring Boot WebFlux application** demonstrating **reactive programming** using **Project Reactor**. It exposes REST APIs to create and fetch users, using **non-blocking, asynchronous, functional code**.

---

## 📦 Features

* Non-blocking I/O
* Efficient thread usage under high load
* Asynchronous request handling
* Clean, functional code using Reactor

---

## 🛠️ Prerequisites

* Java 17+ (JDK)
* Maven
* (Optional) Postman or `curl` for testing APIs

---

## 🚀 Running the Application

1. Clone the repository:

```bash
git clone <your-repo-url>
cd reactive-spring
```

2. Build and run:

```bash
mvn clean install
mvn spring-boot:run
```

The application will start on **`http://localhost:8080`**.

---

## 📜 REST APIs

### 1️⃣ Create Users

```bash
curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{ "id": "1", "name": "Alice", "age": 25 }'

curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{ "id": "2", "name": "Bob", "age": 17 }'

curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{ "id": "3", "name": "Charlie", "age": 30 }'
```

### 2️⃣ Get User by ID

```bash
curl http://localhost:8080/api/users/1
curl http://localhost:8080/api/users/2
```

### 3️⃣ Get All Users

```bash
curl http://localhost:8080/api/users
```

### 4️⃣ Get Adults Only (age > 17)

```bash
curl http://localhost:8080/api/users/adults
```

---

## 🧠 How It Works

### 1️⃣ Non-blocking I/O

Traditional Spring MVC uses **blocking I/O**, where each HTTP request occupies a thread until completion. Reactive WebFlux with Reactor is **non-blocking**:

* Threads are freed while waiting for I/O (e.g., database calls).
* The server can handle thousands of concurrent requests with a small number of threads.

**Benefit:** High scalability with low memory usage.

---

### 2️⃣ Efficient Thread Usage Under High Load

* Blocking MVC: 1000 requests → 1000 threads
* WebFlux Reactor: 1000 requests → 20–50 threads

**Benefit:** Efficient CPU usage and lower server resource consumption.

---

### 3️⃣ Asynchronous Request Handling

Endpoints return **`Mono`** or **`Flux`**, representing asynchronous data streams:

```java
@GetMapping("/users/{id}")
public Mono<User> getUser(@PathVariable String id) {
    return repository.findById(id);
}
```

* Request threads are **not blocked**.
* When data is ready, Reactor automatically resumes processing and returns the response.

---

### 4️⃣ Clean, Functional Code Using Reactor

Reactor encourages **functional and declarative programming**:

```java
Flux<User> adults = repository.findAll()
                              .filter(user -> user.getAge() > 17)
                              .map(user -> {
                                  user.setName(user.getName().toUpperCase());
                                  return user;
                              });
```

* Use operators like `map()`, `filter()`, `flatMap()`, `zip()`
* Avoid explicit loops or manual thread management

---

## 📖 Summary

This project demonstrates the **core benefits of Spring WebFlux + Project Reactor**:

* Scalable, non-blocking I/O
* Efficient thread usage under high load
* Asynchronous, reactive endpoints
* Clean, functional, maintainable code
