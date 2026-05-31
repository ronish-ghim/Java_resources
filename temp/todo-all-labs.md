# Lab Report Todo — Ronish

## Project structure

All labs go under `temp/ronish-java-labs/NN-title/` as standalone directories.

Each lab contains:
- `App.java` (compilable source, default package)
- `report.md` (write-up for docx conversion)

Existing code in the repo (`01_Java_Class/`, `03_Swing/`, `04_Events/`, `06_RMI/`, `07_Database/`)
can be used as reference.

## Groups

### Group A — AWT / Swing GUI (labs 1–12)

No external dependencies.

| # | Lab | Source exists in repo? | Status |
|---|-----|-----------------------|--------|
| 1 | SumDiff via MouseListener (AWT Frame) | `04_Events/03_MouseEvents` — similar | done |
| 2 | Swing add two numbers (button) | `01_Java_Class/02_SimpleCalc` | done |
| 3 | Calculator with radio buttons (Add/Sub/Mul/Div) | No | done |
| 4 | SumDiff via MouseAdapter | `04_Events/03_MouseEvents` — similar to #1 | done |
| 5 | Login Form using GridLayout | `03_Swing/04_GridLayout` | done |
| 6 | Login Form using GridBagLayout | `03_Swing/07_GridBagLayout` | done |
| 7 | Calculator with BorderLayout + sub-panels | `03_Swing/05_Calculator` | done |
| 8a | Button color changes itself on click | No | done |
| 8b | Button sets form background color | No | done |
| 9 | Layout Manager combo (Flow+Grid+Border) | No | done |
| 10 | Shape Drawer (Circle/Square/Triangle) | No | done |
| 11 | Radio buttons + ItemListener → bg color | No | done |
| 12 | Toolbar with icons + message dialogs | No | done |

### Group B — RMI (lab 24)

Quick standalone. No external deps.

| # | Lab | Source exists? | Status |
|---|-----|---------------|--------|
| 24 | RMI add two numbers | `06_RMI/01_Adder` | done |

### Group C — JDBC (labs 13–17)

Requires MySQL on `localhost:3306`, database `javasamriddhi`, user `root`/empty.
Table `tblstudent(id, name, gender, address)` is the common reference table.

| # | Lab | Source exists? | Status |
|---|-----|---------------|--------|
| 13 | Insert 5 students, display sorted by name | `07_Database/04_Student_DB` — similar | done |
| 14 | Update salary +15% where <20000 | No | done |
| 15 | Create table + insert via PreparedStatement | `07_Database/01_SQL_Connection` — similar | done |
| 16 | ResultSet navigation (first/last/previous/next) | No | done |
| 17 | Updatable ResultSet — retrieve by ID, update name | No | done |

### Group D — Servlet / JSP (labs 18–23)

Requires a servlet container (Tomcat). No existing code in repo.

| # | Lab | Source exists? | Status |
|---|-----|---------------|--------|
| 18 | Servlet lifecycle (init/service/destroy) | No — web.xml + index.html provided | done |
| 19 | Store & retrieve "Samriddhi College" in session | No — web.xml + index.html provided | done |
| 20 | Username/password in cookies — Servlet | No — web.xml + index.html provided | done |
| 21 | Username/password in cookies — JSP | No — 3 JSP files | done |
| 22 | JSP form → second JSP display student data | No — 2 JSP files | done |
| 23 | JSP form — Simple Interest (P/T/R → result) | No — 2 JSP files | done |

## Suggested order

1. **Group A (GUI)** — Labs 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8a → 8b → 9 → 10 → 11 → 12
2. **Group B (RMI)** — Lab 24 (quick, break from GUI)
3. **Group C (JDBC)** — Labs 13 → 14 → 15 → 16 → 17
4. **Group D (Servlet/JSP)** — Labs 18 → 19 → 20 → 21 → 22 → 23

Each lab needs:
- `App.java` (compilable source code, default package)
- `report.md` (write-up: Objective, Source Code, Output, Conclusion)
- Run `convert-all.ps1` to batch-convert all `report.md` → `report.docx` via pandoc
