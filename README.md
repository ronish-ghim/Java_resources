# Java Lab Programs — B.Sc. CSIT 7th Semester (CSC409)

Advanced Java Programming coursework: class practice, lab assignments, and college notes — IOST syllabus.

## Structure

| Directory | Description |
|-----------|-------------|
| `01_Java_Class/` | Core Java — HelloWorld, Calculator, Prime check, ClassTypes, Exceptions, Threads, File I/O |
| `02_SpringBoot/e-commerce/` | Spring Boot 3.4.1 + Web, JPA, MySQL, Flyway (Java 23) |
| `02_SpringBoot/store/` | Spring Boot 4.0.1 + Web, Actuator (Java 21) |
| `03_Swing/` | AWT/Swing — layouts (Flow, Border, Grid, GridBag), Calculator, Registration Form |
| `04_Events/` | AWT event handling — ActionListener, Mouse, MouseMotion, Key events, CalculatorComboBox |
| `05_Socket/` | Networking — TCP ChatApp (port 5000), UDP, URL fetch, SMTP |
| `06_RMI/` | RMI Adder (port 5000, binder `"hiserver"`) |
| `07_Database/` | JDBC + MySQL — connection, login, DDL, CRUD |
| `Labs/ronish-java-labs/` | 24 lab assignments with `App.java` + `report.md` (AWT/Swing, JDBC, Servlet/JSP, RMI) |
| `Labs/convert-all.ps1` | Batch-converts all lab reports to DOCX via pandoc |
| `Labs/todo-all-labs.md` | Status tracker for all 24 labs |
| `Sunil_sir_notes/` | Course notes — 8 chapters + syllabus-aligned [table of contents](Sunil_sir_notes/readme.md) |

## Prerequisites

- Java 21+ (for numbered modules)
- VS Code with Java Extension Pack (recommended)
- MySQL 8+ on `localhost:3306`, database `javasamriddhi`, user `root`, empty password
- `mysql-connector-j` JAR (JDBC modules reference it via absolute path)
- Maven wrapper included for Spring Boot sub-projects
- Pandoc (for DOCX conversion)

## Running

**Numbered modules (01–07):**
```
javac -d bin src/App.java
java -cp bin App
```

**Spring Boot:**
```
cd 02_SpringBoot/e-commerce && ./mvnw spring-boot:run
cd 02_SpringBoot/store/store && ./mvnw spring-boot:run
```

**TCP ChatApp:** start `05_Socket/TCP/01_ChatApp/src/Server.java` first, then `Client.java`
**RMI Adder:** start `rmiregistry` on port 5000, then `06_RMI/01_Adder/src/MyClient.java`

## Course notes (`Sunil_sir_notes/`)

Lecture notes compiled from Sunil Sir's original `.docx` files for **CSC409: Advanced Java Programming** (B.Sc. CSIT 7th Sem, TU). Each chapter covers one syllabus unit with diagrams, code examples, and explanations.

| # | Unit | File |
|---|------|------|
| 1 | Programming in Java (8 hrs) — JVM, OOP, Inheritance, Exceptions, Threads, I/O | [`Chapter-01_Java-Fundamentals.md`](Sunil_sir_notes/chapters/Chapter-01_Java-Fundamentals.md) |
| 2 | GUI with Swing (10 hrs) — AWT, Layouts, Swing Components, Dialogs | [`Chapter-02_AWT-Swing.md`](Sunil_sir_notes/chapters/Chapter-02_AWT-Swing.md) |
| 3 | Event Handling (4 hrs) — Delegation Model, Listeners, Adapters | [`Chapter-03_Event-Handling.md`](Sunil_sir_notes/chapters/Chapter-03_Event-Handling.md) |
| 4 | Database Connectivity (4 hrs) — JDBC Types, Statements, RowSet, Transactions | [`Chapter-04_JDBC.md`](Sunil_sir_notes/chapters/Chapter-04_JDBC.md) |
| 5 | Network Programming (5 hrs) — TCP/UDP Sockets, URL, JavaMail | [`Chapter-05_Network-Programming.md`](Sunil_sir_notes/chapters/Chapter-05_Network-Programming.md) |
| 6 | GUI with JavaFX (3 hrs) — Layouts, Controls, Animation, Charts | [`Chapter-06_JavaFX.md`](Sunil_sir_notes/chapters/Chapter-06_JavaFX.md) |
| 7 | Servlets & JSP (8 hrs) — Servlet API, Session, Cookies, JSTL, Frameworks | [`Chapter-07_Servlets.md`](Sunil_sir_notes/chapters/Chapter-07_Servlets.md) |
| 8 | RMI & CORBA (3 hrs) — RMI Architecture, Stub/Skeleton, CORBA | [`Chapter-08_RMI.md`](Sunil_sir_notes/chapters/Chapter-08_RMI.md) |
| — | Lab Programs (24 labs across A/B/C/D groups) | [`Appendix-Lab-Programs.md`](Sunil_sir_notes/chapters/Appendix-Lab-Programs.md) |

- **[Full Table of Contents](Sunil_sir_notes/readme.md)** — syllabus-aligned with clickable anchors to every section heading
- **[Original `.docx` sources](Sunil_sir_notes/original_docx/)** — 4 files: `UNIT 1.docx`, `Unit-1 (File IO).docx`, `Unit1(Threading).docx`, `Unit-1( Inner Class).docx`
- **[Chapter images](Sunil_sir_notes/chapters/images/)** — 42 extracted diagrams in document order
