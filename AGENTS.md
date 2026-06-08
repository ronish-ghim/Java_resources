# AGENTS.md — Java Lab Programs (B.Sc. CSIT 7th Sem)

## Repo structure

| Path | Contents |
|------|----------|
| `01_Java_Class/` | Core Java (HelloWorld, Calculator, Prime, ClassTypes, Exception, Threads, File I/O) |
| `02_SpringBoot/e-commerce/` | Maven Spring Boot (Web + JPA + MySQL + Flyway, Java 23, SB 3.4.1) |
| `02_SpringBoot/store/` | Maven Spring Boot (Web + Actuator, Java 21, SB 4.0.1) |
| `03_Swing/` | AWT/Swing GUI (layouts, Calculator, RegistrationForm) |
| `04_Events/` | AWT event handling (Mouse, Key, ActionListener, CalculatorComboBox) |
| `05_Socket/` | Networking (TCP ChatApp, UDP, URL fetch, SMTP) |
| `06_RMI/` | RMI Adder (port 5000, binder name `"hiserver"`) |
| `07_Database/` | JDBC + MySQL (`localhost:3306`, database `javasamriddhi`, user `root`/empty) |
| `Labs/ronish-java-labs/` | 24 lab assignments (AWT/Swing, JDBC, Servlet/JSP, RMI), each with `App.java` + `report.md` |
| `Sunil_sir_notes/chapters/` | Course notes (8 chapters, markdown) from original 16 docx files |
| `Gradle/` | Sandbox — ignore |
| `Hangman-Java-Football-Edition/` | Standalone game (separate git repo) — ignore |

## Numbered modules (01–07) — VS Code Java projects

- **No build tool** — compiled via VS Code Java extension
- Each project: `src/` (sources), `bin/` (gitignored output), `lib/` (jars), `.vscode/settings.json`
- Sources use **default package** (no `package` declaration)
- Entry point: `src/App.java` with `public static void main(String[] args)`
- Run:
  ```
  javac -d bin src/App.java
  java -cp bin App
  ```
- **Exception**: `05_Socket/TCP/01_ChatApp/` — `App.java` is a placeholder; real entry points are `Server.java` and `Client.java`

## 02_SpringBoot — Maven

```
cd 02_SpringBoot/e-commerce; ./mvnw spring-boot:run
cd 02_SpringBoot/store/store; ./mvnw spring-boot:run
```

## Run order for multi-class programs

- **TCP ChatApp**: start `Server.java` first, then `Client.java` (port 5000 localhost)
- **RMI Adder**: start `rmiregistry` (or `MyServer` creates one on port 5000), then `MyClient`
- **SMTP**: needs `config.properties` (gitignored) with Gmail app password

## Database programs

- Requires MySQL on `localhost:3306`, database `javasamriddhi`, user `root`, empty password
- Reference table: `tblstudent(id, name, gender, address)`
- JDBC connector JAR referenced via absolute path in `.vscode/settings.json` (not in `lib/`)

## Lab reports (`Labs/`)

- 24 labs in `Labs/ronish-java-labs/`, each with standalone `App.java` + `report.md`
- `Labs/convert-all.ps1` batch-converts all `report.md` → single DOCX via **pandoc**
- Lab detailed status: see `Labs/todo-all-labs.md`

## Notes (`Sunil_sir_notes/`)

- Course notes for **Advanced Java Programming** (CSC409): Java Fundamentals, AWT/Swing, Event Handling, JDBC, Networking, JavaFX, Servlets, RMI

## .gitignore

- Ignores: `.vscode/`, `bin/`, `target/`, `*.class` (any depth), `.env`, `config.properties`, `temp/**/bin/`
