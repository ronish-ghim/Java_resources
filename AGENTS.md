# AGENTS.md — Java Lab Programs

## Repo structure

- **`01_Java_Class`** — Core Java (HelloWorld, Calculator, Prime, ClassTypes, Exception, Threads, File I/O)
- **`02_SpringBoot`** — Maven Spring Boot apps (`mvnw` + `pom.xml`, standard Maven layout)
- **`03_Swing`** — AWT/Swing GUI demos (BorderLayout, GridLayout, GridBagLayout, Calculator, RegistrationForm)
- **`04_Events`** — AWT event handling (ActionListener, Mouse, MouseMotion, Key events, CalculatorComboBox)
- **`05_Socket`** — Networking (TCP ChatApp on port 5000, UDP, URL fetch, SMTP)
- **`06_RMI`** — RMI demo (port 5000, binder name `"hiserver"`)
- **`07_Database`** — JDBC + MySQL (`localhost:3306`, database `javasamriddhi`, user `root`/empty)

## Build & run

### Numbered modules (01–07) — VS Code Java projects

- **No build tool** — compiled via VS Code Java extension
- Each sub-project is **self-contained**: `src/` (sources), `bin/` (output), `lib/` (jars), `.vscode/settings.json`
- Sources use **default package** (no `package` declaration)
- Entry point: `src/App.java` with `public static void main(String[] args)`
- `.class` files may be checked into `src/` next to `.java` — ignore them
- Run from VS Code or manually:
  ```
  javac -d bin src/App.java
  java -cp bin App
  ```

### 02_SpringBoot — Maven

```
cd 02_SpringBoot/e-commerce
./mvnw spring-boot:run
```

## Run order for multi-class programs

- **Socket TCP ChatApp**: start `Server.java` first, then `Client.java` (port 5000 localhost)
- **RMI Adder**: start `rmiregistry` (or `MyServer` creates registry on port 5000), then `MyClient`
- **SMTP mail**: needs `config.properties` (gitignored) with Gmail app password

## Database programs

- Requires MySQL on `localhost:3306` with database `javasamriddhi`
- User `root`, empty password
- Table used in examples: `tblstudent` (columns: id, name, gender, address)
- JDBC driver JAR goes in `lib/` (currently empty — user must add `mysql-connector-j`)

## Excluded directories

- `Gradle/` and `Hangman-Java-Football-Edition/` are test/sandbox projects — ignore

## Git

- Single commit `Initial commit` — entire repo committed at once
- Java build artifacts (`*.class`, `bin/`, `.vscode/`) tracked in git; `.gitignore` ignores `*.class` at root level only
