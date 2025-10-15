APIs
curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{
"id": "1",
"name": "Alice",
"age": 25
}'

curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{
"id": "2",
"name": "Bob",
"age": 17
}'

curl -X POST http://localhost:8080/api/users \
-H "Content-Type: application/json" \
-d '{
"id": "3",
"name": "Charlie",
"age": 30
}'


curl http://localhost:8080/api/users/1

curl http://localhost:8080/api/users/2

curl http://localhost:8080/api/users/adults


✅ What You Get 
1. Non-blocking I/O 
2. Efficient thread usage under high load
3. Asynchronous request handling 
4. Clean, functional code using Reactor

1️⃣ Non-blocking I/O
Traditional Spring MVC uses blocking I/O.
    Each HTTP request consumes a thread until it completes.
    If a thread waits for a database or external API, it’s idle but still occupied.

Reactive (WebFlux + Reactor) uses non-blocking I/O:
    Threads don’t wait; they are freed to handle other requests while waiting for I/O.
    Example: If fetching a user from a DB, the thread continues doing other work instead of blocking.

Benefit: You can handle thousands of concurrent requests with a small thread pool.

2️⃣ Efficient Thread Usage Under High Load
Because threads aren’t blocked during I/O, you need far fewer threads to handle high load.
Example:
    Blocking Spring MVC: 1000 requests → 1000 threads (heavy memory usage).
    WebFlux Reactor: 1000 requests → 20–50 threads (low memory, efficient CPU usage).

Benefit: Scalability and lower server resource usage.

3️⃣ Asynchronous Request Handling
With Reactor, you return Mono or Flux from your endpoints.
    The request doesn’t block the server thread, but still produces a response as soon as the data is ready.
    While waiting for the DB, other requests can be served.
    Once the DB responds, Reactor resumes the processing and sends the response.

4️⃣ Clean, Functional Code Using Reactor
Reactor encourages a functional, declarative style:
    Transform streams with map(), filter(), flatMap(), zip(), etc.
    Avoid explicit loops or blocking code.