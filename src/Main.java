import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        manager.addStudent(new Student("S001", "Alice Johnson", 8.2));
        manager.addStudent(new Student("S002", "Bob Smith", 5.5));
        manager.addStudent(new Student("S003", "Charlie Brown", 9.1));
        manager.addStudent(new Student("S004", "David White", 7.0));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Information Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Add student
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    double marks = 0.0;
                    
                    boolean validMarks = false;
                    while (!validMarks) {
                        System.out.print("Enter student marks: ");
                        if (scanner.hasNextDouble()) {
                            marks = scanner.nextDouble();
                            scanner.nextLine(); // Consume the newline character
                            validMarks = true; // Đã nhập đúng kiểu dữ liệu
                        } else {
                            System.out.println("Invalid input. Please enter a valid number for marks.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                    }
                    manager.addStudent(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    // Delete student
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteStudent(deleteId);
                    System.out.println("Student deleted successfully!");
                    break;

                case 3:
                    // Search student
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student student = manager.searchStudent(searchId);
                    if (student != null) {
                        System.out.println("Student found: " + student);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    // Display all students
                    System.out.println("All Students:");
                    manager.displayAllStudents();
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
