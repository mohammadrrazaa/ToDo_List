package todo;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ToDoListGUI {
    private JFrame frame;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private ArrayList<Task> tasks;

    public ToDoListGUI() {
        tasks = new ArrayList<>();
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Mo's!! To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Task list area
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Buttons
        JButton addTaskButton = new JButton("Add Task");
        JButton markCompleteButton = new JButton("Mark as Completed");
        JButton deleteTaskButton = new JButton("Delete Task");

        // Button actions
        addTaskButton.addActionListener(e -> openAddTaskDialog());
        markCompleteButton.addActionListener(e -> markTaskAsCompleted());
        deleteTaskButton.addActionListener(e -> deleteTask());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addTaskButton);
        buttonPanel.add(markCompleteButton);
        buttonPanel.add(deleteTaskButton);

        // Adding components to the frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void openAddTaskDialog() {
        String title = JOptionPane.showInputDialog(frame, "Enter task title:");
        if (title == null || title.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Task title cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dueDateText = JOptionPane.showInputDialog(frame, "Enter due date (YYYY-MM-DD):");
        try {
            LocalDate dueDate = LocalDate.parse(dueDateText);
            Task newTask = new Task(title, dueDate);
            tasks.add(newTask);
            taskListModel.addElement("Task: " + title + " | Due: " + dueDate + " | Status: Pending");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Invalid date format. Please use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void markTaskAsCompleted() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            Task selectedTask = tasks.get(selectedIndex);
            selectedTask.markAsCompleted();
            taskListModel.set(selectedIndex, "Task: " + selectedTask.getTitle() + " | Due: " + selectedTask.getDueDate() + " | Status: Completed");
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a task to mark as completed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            tasks.remove(selectedIndex);
            taskListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a task to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListGUI::new);
    }
}
