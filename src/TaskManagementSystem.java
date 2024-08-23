import java.time.LocalDate;
import java.util.Scanner;

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Task Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Due Date (YYYY-MM-DD): ");
                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter Priority (1-5): ");
                    int priority = scanner.nextInt();
                    Task newTask = new Task(title, description, dueDate, priority);
                    taskManager.addTask(newTask);
                    break;

                case 2:
                    System.out.print("Enter Task Number to Update: ");
                    int updateIndex = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter New Task Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter New Task Description: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Enter New Due Date (YYYY-MM-DD): ");
                    LocalDate newDueDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter New Priority (1-5): ");
                    int newPriority = scanner.nextInt();
                    Task updatedTask = new Task(newTitle, newDescription, newDueDate, newPriority);
                    taskManager.updateTask(updateIndex, updatedTask);
                    break;

                case 3:
                    System.out.print("Enter Task Number to Delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    taskManager.deleteTask(deleteIndex);
                    break;

                case 4:
                    taskManager.viewTasks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
    }
}
