import java.util.Scanner;


public class Main {
    private static Student[] students = new Student[2];
    private static int studentsCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    addStudent(id, name, age);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String id1 = scanner.nextLine();
                    removeStudent(id1);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String id2 = scanner.nextLine();
                    updateStudent(id2);
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(String id, String name, int age) {
        if (studentsCount >= students.length) {
            increaseArraySize();
        }
        students[studentsCount] = new Student(id, name, age);
        studentsCount++;
        System.out.println("Student added successfully!");
    }

    private static void removeStudent(String id) {
        int indexToRemove = -1;

        for (int i = 0; i < studentsCount; i++) {
            if (students[i].id.equals(id)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < studentsCount - 1; i++) {
                students[i] = students[i + 1];
            }
            students[studentsCount - 1] = null;
            studentsCount--;
            System.out.println("Student with ID " + id + " has been removed.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void updateStudent(String id) {
        int indexToUpdate = -1;

        for (int i = 0; i < studentsCount; i++) {
            if (students[i].id.equals(id)) {
                indexToUpdate = i;
                break;
            }
        }

        if (indexToUpdate != -1) {
            System.out.print("Enter new Student ID: ");
            String newID = scanner.nextLine();
            System.out.print("Enter new Student Name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new Student Age: ");
            int newAge = scanner.nextInt();
            scanner.nextLine();

            students[indexToUpdate].id = newID;
            students[indexToUpdate].name = newName;
            students[indexToUpdate].age = newAge;

            System.out.println("Student with input ID " + id + " has been updated.");
        } else {
            System.out.println("Student with input ID " + id + " not found.");
        }
    }

    private static void increaseArraySize() {
        int newSize = students.length * 2;
        Student[] newStudents = new Student[newSize];
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        students = newStudents;
        System.out.println("Array size increased to " + newSize);
    }

    private static void displayStudents() {
        if (studentsCount == 0) {
            System.out.println("No student to display.");
        } else {
            for (int i = 0; i < studentsCount; i++) {
                System.out.println(students[i]);
            }
        }
    }
}

