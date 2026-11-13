# Six-Week Java Learning Journey

A practical six-week roadmap for learning Java through consistent practice and project-based development.

This repository documents my progress from Java fundamentals to building tested, database-backed applications. The goal is to develop a strong Java foundation before moving into HTTP, REST APIs, Spring Boot, backend security, and cloud engineering.

## About Me

I am **Albert Adekanye**, a software developer and tech educator expanding my backend development skills with Java.

## Learning Goals

By the end of the six weeks, I aim to:

- Understand Java syntax and core programming concepts.
- Apply object-oriented programming principles.
- Work with collections, exceptions, files, and streams.
- Write automated tests with JUnit.
- Connect Java applications to an SQLite database using JDBC.
- Build and document a polished Java application.
- Prepare for learning HTTP, REST APIs, and Spring Boot.

## Development Setup

- **Operating system:** Windows 11
- **Editor:** Visual Studio Code
- **JDK:** Microsoft OpenJDK 25 LTS
- **Build tool:** Apache Maven
- **Java extension:** Extension Pack for Java

Verify the installation:

```powershell
java --version
javac --version
mvn --version
```

## Six-Week Roadmap

| Week | Focus | Main project |
|---|---|---|
| 1 | Java basics | Console calculator |
| 2 | Object-oriented programming | Library system |
| 3 | Collections and exceptions | Contact manager |
| 4 | Files, streams, and testing | Expense tracker |
| 5 | Databases and modern Java | SQLite task manager |
| 6 | Consolidation and interview practice | Inventory Management System |

## Week 1 — Core Foundations

- [x] Install the JDK and configure VS Code.
- [x] Learn Java program structure and output.
- [x] Learn variables and data types.
- [x] Practice operators and type conversion.
- [x] Accept user input with `Scanner`.
- [x] Learn `if`, `else`, and `switch`.
- [x] Practice `for`, `while`, and `do-while` loops.
- [x] Learn methods, arrays, and strings.
- [x] Build a console calculator with input validation.

## Week 2 — Object-Oriented Programming

- [x] Learn classes, objects, fields, and methods.
- [x] Use constructors and the `this` keyword.
- [x] Apply encapsulation and access modifiers.
- [x] Understand inheritance and polymorphism.
- [x] Work with abstract classes and interfaces.
- [x] Prefer composition where appropriate.
- [x] Organize code using packages.
- [x] Build a library management system.

## Week 3 — Collections and Error Handling

- [x] Use `ArrayList`, `HashSet`, and `HashMap`.
- [x] Learn iterators and enhanced `for` loops.
- [x] Understand generics.
- [x] Understand checked and unchecked exceptions.
- [x] Practice `try`, `catch`, `finally`, and `throw`.
- [x] Create custom exceptions.
- [x] Build a contact manager with CRUD operations.

## Week 4 — Files, Streams, and Testing

- [x] Read and write text files.
- [x] Read and write CSV data.
- [x] Use try-with-resources.
- [x] Learn lambda expressions and method references.
- [x] Process collections using the Stream API.
- [x] Write unit tests with JUnit.
- [x] Build an expense tracker with file persistence.

## Week 5 — Databases and Application Structure

- [x] Learn fundamental SQL commands.
- [x] Connect Java to SQLite using JDBC.
- [x] Perform CRUD operations.
- [x] Use prepared statements.
- [x] Separate model, repository, service, and UI layers.
- [x] Learn records, enums, `Optional`, and the date/time API.
- [x] Build a persistent task manager.

## Week 6 — Capstone and Consolidation

- [x] Select and define the final project.
- [x] Design the classes and application structure.
- [x] Implement the core features.
- [x] Add SQLite database persistence.
- [x] Implement transactional stock management.
- [x] Write automated tests with JUnit 5.
- [x] Test important behavior and edge cases.
- [x] Refactor and document the code.
- [x] Practice explaining design and technical decisions.

### Week 6 Capstone: Inventory Management System

A Java console-based inventory management application built to demonstrate practical backend programming, database integration, application architecture, and automated testing.

**Technologies Used**

- Java 25
- Apache Maven
- SQLite
- JDBC
- JUnit 5
- SQL

**Features**

1. Add products with unique SKUs.
2. View all products.
3. Search products by ID or SKU.
4. Update product details.
5. Delete products while preserving stock movement history.
6. Receive stock.
7. Remove stock.
8. View low-stock products.
9. Calculate total inventory value.
10. View stock movement history.

**Architecture**

The application follows a layered architecture:

- **Model:** Represents products and stock movements.
- **Repository:** Handles database operations.
- **Service:** Implements business rules and inventory operations.
- **UI:** Provides the console interface.
- **Config:** Handles SQLite database initialization and connections.

**Database Design**

The application uses two main database tables:

- `products` — Stores product information, prices, quantities, and low-stock thresholds.
- `stock_movements` — Records stock received and stock removed, including timestamps.

Stock quantity updates and their corresponding movement records are handled within database transactions to maintain data consistency.

**Testing**

Automated tests cover repository operations and inventory service behavior.

Latest test results:

| Test class | Tests |
|---|---:|
| ProductRepositoryTest | 8 |
| InventoryServiceTest | 5 |
| **Total** | **13** |

- **Passed:** 13
- **Failures:** 0
- **Errors:** 0
- **Skipped:** 0
- **Build status:** BUILD SUCCESS

**Running the Capstone**

Navigate to the capstone project directory:

```powershell
cd week-06-capstone/inventory-management-system
```

Run the tests:

```powershell
mvn clean test
```

Run the application:

```powershell
mvn exec:java "-Dexec.mainClass=com.codewithkanye.Main"
```

## Daily Routine

I study for **1–2 hours per day, six days per week**:

1. **15 minutes:** Review the previous lesson.
2. **30 minutes:** Learn one new concept.
3. **45–60 minutes:** Write code without copying.
4. **15 minutes:** Solve a small problem and document what I learned.

## Repository Structure

```text
java-learning/
├── week-01-basics/
├── week-02-oop/
├── week-03-collections-exceptions/
├── week-04-files-streams-testing/
├── week-05-databases/
├── week-06-capstone/
│   └── inventory-management-system/
│       ├── src/
│       │   ├── main/
│       │   └── test/
│       ├── pom.xml
│       └── README.md
└── README.md
```

## Running a Basic Java Program

Compile a program:

```powershell
javac Main.java
```

Run the compiled program:

```powershell
java Main
```

The filename and public class name must match exactly. For example, `public class Main` must be saved as `Main.java`.

## What Comes Next?

After completing this roadmap, I plan to learn:

- HTTP requests and responses.
- JSON processing.
- Java's built-in `HttpClient`.
- REST API design.
- Spring Boot.
- Authentication and backend security.
- Redis and caching.
- Apache Kafka and event-driven architecture.
- Docker and cloud deployment.
- Logging, monitoring, and observability.

## Progress

**Current stage:** Week 6 — Completed

**Milestone:** Built and tested a database-backed Inventory Management System using Java 25, SQLite, Maven, JDBC, and JUnit 5.

**Next learning phase:** HTTP, REST APIs, and Spring Boot.

## Author

**Albert Adekanye**

Software developer, backend engineering enthusiast, and tech educator.

## License

This learning repository is available for educational purposes.