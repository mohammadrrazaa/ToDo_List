# To-Do List Application 📝

A simple yet effective **Java desktop application** for managing tasks, built with **Swing GUI** and **object-oriented principles**.  

---
## Features ✨
- Add, view, and delete tasks.  
- Mark tasks as completed ✅.  
- Each task includes:  
  - Unique ID  
  - Title  
  - Due Date  
  - Creation Timestamp  
- Intuitive **Swing-based GUI** with task list, buttons, and dialogs.  
- Separation of concerns:  
  - `ToDoManager` → Handles logic.  
  - `ToDoListGUI` → Handles user interface.  
---
## Tech Stack 🛠️
- **Language**: Java  
- **UI Framework**: Swing  
- **Architecture**: MVC-inspired (separating logic & UI)  
- **OOP Concepts**: Abstraction, Inheritance, Encapsulation 
---
## Project Structure 📂
src/
├── Main.java # Entry point
├── ListItem.java # Abstract base class for items
├── Task.java # Task implementation
├── ToDoManager.java # Business logic for task management
├── ToDoListGUI.java # Swing-based graphical interface
└── package-info.java # Package declaration
---
## Installation & Usage 🚀
1. Clone the repo:  
   ```bash
   git clone https://github.com/yourusername/todo-list.git
   cd todo-list
javac src/*.java
java -cp src todo.Main
