package todo;
import java.time.LocalDate;

public class Task extends ListItem {
    private String title;
    private LocalDate dueDate;
    private boolean isCompleted;

    public Task(String title, LocalDate dueDate) {
        super();
        this.title = title;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public void display() {
        String status = isCompleted ? "Completed" : "Pending";
        System.out.println("Task: " + title + " | Due: " + dueDate + " | Status: " + status);
    }
}
