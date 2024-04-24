import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> taskList = new ArrayList<>();

        boolean continueApp = true;
        while (continueApp) {
            System.out.println("1. Add new task");
            System.out.println("2. Show all tasks");
            System.out.println("3. Delete task by ID");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (option) {
                case 1:
                    addTask(scanner, taskList);
                    break;
                case 2:
                    showTasks(taskList, continueApp);
                    break;
                case 3:
                    System.out.print("Enter the ID of the task you want to delete: ");
                    int idToDelete = scanner.nextInt();
                    deleteTaskById(taskList, idToDelete);
                    break;
                case 4:
                    continueApp = false;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addTask(Scanner scanner, List<Task> taskList) {
        System.out.print("Enter the task ID:");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        System.out.print("Enter the date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter the task name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();

        System.out.print("Is the task completed? (true/false): ");
        boolean completed = scanner.nextBoolean();

        System.out.print("Enter the task priority (1-high, 2-medium, 3-low): ");
        int priority = scanner.nextInt();

        Task task = new Task(taskId, date, name, description, completed, priority);
        taskList.add(task);
        System.out.println("Task added successfully.");
    }

    private static void showTasks(List<Task> taskList, boolean ascending) {
        if (taskList.isEmpty()) {
            System.out.println("No tasks to show.");
        } else {
            // Sort the task list by priority
            if (ascending) {
                taskList.sort(Comparator.comparingInt(Task::getPriority));
            } else {
                taskList.sort(Comparator.comparingInt(Task::getPriority).reversed());
            }

            System.out.println("Task list:");
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }

    private static void deleteTaskById(List<Task> taskList, int taskId) {
        boolean taskFound = false;
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                taskList.remove(task);
                taskFound = true;
                System.out.println("Task deleted successfully.");
                break;
            }
        }
        if (!taskFound) {
            System.out.println("No task found with the specified ID.");
        }
    }
}
