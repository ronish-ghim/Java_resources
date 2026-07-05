# AGENTS.md — Java Lab Programs (B.Sc. CSIT 7th Sem)

## Repo structure

| Path | Contents |
|------|----------|
| `01_Java_Class/` | Core Java (HelloWorld, Calculator, Prime, ClassTypes, Exception, Threads, File I/O) |
| `02_SpringBoot/e-commerce/` | Maven Spring Boot 3.4.1 + Web + JPA + MySQL + Flyway, Java 23 |
| `02_SpringBoot/store/store/` | Maven Spring Boot 4.0.1 + Web + Actuator, Java 21 |
| `03_Swing/` | AWT/Swing GUI (layouts, Calculator, RegistrationForm) |
| `04_Events/` | AWT event handling (Mouse, Key, ActionListener, CalculatorComboBox) |
| `04_Events/New folder/02_Calculator/` | CalculatorComboBox variant (extra) |
| `05_Socket/` | Networking (TCP ChatApp, UDP, URL fetch, SMTP) |
| `06_RMI/` | RMI Adder (two variants, port 5000, binder `"hiserver"`) |
| `07_Database/` | JDBC + MySQL (`localhost:3306`, database `javasamriddhi`, user `root`/empty) |
| `Labs/ronish-java-labs/` | 24 lab assignments (AWT/Swing, JDBC, Servlet/JSP, RMI), each with `App.java` + `report.md` |
| `Labs/convert-all.ps1` | Batch-converts all lab `report.md` → single DOCX via pandoc |
| `Sunil_sir_notes/chapters/` | 8 course notes chapters (markdown) merged from 16 original docx files |
| `Gradle/` | Sandbox — ignore |
| `Hangman-Java-Football-Edition/` | Standalone game (separate git repo) — ignore |

## Numbered modules (01–07) — VS Code Java projects

- **No build tool** — compiled via VS Code Java Extension Pack
- Each project: `src/` (sources), `bin/` (gitignored), `lib/` (jars), `.vscode/settings.json`
- Sources use **default package** (no `package` declaration)
- Entry point: `src/App.java` with `public static void main(String[] args)`
- Compile and run:
  ```
  javac -d bin src/App.java
  java -cp bin App
  ```
- **Exceptions** — these have `App.java` as a placeholder; real entry points differ:
  - `05_Socket/TCP/01_ChatApp/` → `Server.java` then `Client.java`
  - `06_RMI/01_Adder/` → `MyServer.java` then `MyClient.java`
  - `06_RMI/02_Adder/` → `Adder.java` then `Client.java`

## 02_SpringBoot — Maven

```
cd 02_SpringBoot/e-commerce; ./mvnw spring-boot:run
cd 02_SpringBoot/store/store; ./mvnw spring-boot:run
```

- e-commerce has Flyway migration at `src/main/resources/db/migration/V1__initial_migration.sql`

## Run order for multi-class programs

- **TCP ChatApp**: start `Server.java` first, then `Client.java` (port 5000 localhost)
- **RMI Adder**: `rmiregistry` on port 5000 (or `MyServer` creates one), then client
- **SMTP**: needs `config.properties` (gitignored) with Gmail app password; requires `jakarta.mail` JAR (referenced via absolute path in `.vscode/settings.json`)

Two SMTP projects exist:
- `05_Socket/mail/01_SMTP_GMAIL/` — VS Code project, uses `config.properties` + local JARs
- `05_Socket/mail/gmail_smtp/` — Maven project (Java 17), `./mvnw compile exec:java`

## Database programs

- Requires MySQL on `localhost:3306`, database `javasamriddhi`, user `root`, empty password
- Reference table: `tblstudent(id, name, gender, address)`
- JDBC connector JAR referenced via **absolute path** in `.vscode/settings.json` (not in `lib/`)

## Labs (`Labs/ronish-java-labs/`)

- 24 labs: each is a standalone directory with `App.java` + `report.md` (same default-package pattern)
- Lab 24 (RMI) has multi-file source: `Adder.java`, `MyServer.java`, `MyClient.java`, `App.java`
- Labs 18–23 (Servlet/JSP) require a servlet container (Tomcat)
- Run `Labs/convert-all.ps1` to batch-convert all `report.md` → single DOCX via pandoc
- Detailed status: `Labs/todo-all-labs.md`
- Lab descriptions (for submission): `Labs/lab-list.md`

## Notes (`Sunil_sir_notes/`)

- Course notes for **Advanced Java Programming** (CSC419): 8 chapters + appendix + images
- Start at `Sunil_sir_notes/readme.md` (syllabus-aligned table of contents)

## .gitignore

- Ignores: `.vscode/`, `bin/`, `target/`, `*.class` (any depth), `.env`, `config.properties`, `temp/**/bin/`
