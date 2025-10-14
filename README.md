## Employee Stream API Mini Project (Core Java)
This Java mini-project demonstrates the **power of Java 25 Stream API** through a progressive, console-based application series.
It begins with basic stream operations and evolves into a **fully menu-driven system** that supports **dynamic, user-defined filters**.
The project showcases **functional programming concepts** such as:
* `filter()`, `map()`, `distinct()`, `sorted()`, `flatMap()`, `collect()`, `count()`, `average()`, and `findAny()`.
* Real-world use of `Comparator`, `Collectors`, and lambda expressions.

### Project Sections
#### 🔹 Section 1 – `EmpStreamDemo.java`
A simple demonstration of Stream API operations on a predefined list of employees.
It prints:
* Filtered employees (`salary > 70000`)
* Employee names (via `map`)
* Unique employees (`distinct()`)
* Sorting (by salary and name)
* Unique skill extraction (`flatMap`)
* Department grouping (`collect(groupingBy)`)
* Average salary and count examples

#### 🔹 Section 2 – `EmpStreamMenu.java`
A **menu-driven console application** that allows users to execute various Stream operations interactively.
**Features:**
* Display all employees
* Filter by salary
* Map names
* Remove duplicates
* Sort (ascending / descending)
* Flatten skills
* Count employees in a department
* Calculate average salary
* Group employees by department
* Find employee older than 35

#### 🔹 Section 3 – `EmpStreamMenuCustom.java`
The upgraded version — **fully interactive** and **user-driven**.
**New Features:**
* Filter by **custom salary range**
* Filter by **department name**
* Filter by **age threshold**
* Input validation (`readInt()` / `readDouble()` methods)
* Dynamic stream filtering based on runtime input

### Key Concepts Demonstrated
```
| Operation               | Purpose                                           |
| ----------------------- | ------------------------------------------------- |
| `filter()`              | Select data based on conditions                   |
| `map()`                 | Transform objects (e.g., extract names)           |
| `distinct()`            | Remove duplicates using `equals()` + `hashCode()` |
| `sorted()`              | Sort by any field using `Comparator`              |
| `flatMap()`             | Combine nested lists (e.g., all skills)           |
| `collect()`             | Group and aggregate data                          |
| `count()` / `average()` | Compute summary statistics                        |
| `findAny()`             | Fetch any matching record                         |
```

### Folder Structure
```
EmpDataStream2/
│
├── EmployeeStreamDemo.java
├── EmployeeStreamMenuDriven.java
├── EmployeeStreamMenuDrivenCustom.java
└── README.md
```

### Output (Combined)
<img width="1627" height="2484" alt="Screenshot 2025-10-14 120019" src="https://github.com/user-attachments/assets/3bdbeb1f-c27d-4d67-8e4f-b4956df50f8f" />
<img width="1607" height="2687" alt="Screenshot 2025-10-14 120101" src="https://github.com/user-attachments/assets/bfa144a0-b13f-4cdd-a076-9ed2b3161344" />
<img width="1646" height="1230" alt="Screenshot 2025-10-14 120131" src="https://github.com/user-attachments/assets/ca29e26a-df4d-4b68-85f2-deac12c44af2" />

### Technologies Used
* **Language:** Java 25
* **Concepts:** Stream API, Lambda Expressions, Functional Programming
* **Tools:** IntelliJ IDEA

### Highlights
* Clear demonstration of modern Java Stream API concepts.
* Gradual enhancement from static code → menu-driven → custom-filter app.
* Ideal for students, interview prep, and Core Java learning.
