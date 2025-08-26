package todo;

import java.time.LocalDate;
import java.util.ArrayList;

public class ToDoManager {
    private ArrayList<Task> tasks;

    public ToDoManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title, LocalDate dueDate) {
        tasks.add(new Task(title, dueDate));
        System.out.println("Task added successfully!");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Your Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print((i + 1) + ". ");
            tasks.get(i).display();
        }
    }

    public void markTaskComplete(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks.get(index).markAsCompleted();
        System.out.println("Task marked as completed.");
    }

    public void deleteTask(int index) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks.remove(index);
        System.out.println("Task deleted successfully.");
    }
}

