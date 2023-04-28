package excercise;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=== Student Management System ===");
            System.out.println("1. Add student records");
            System.out.println("2. Display student records");
            System.out.println("3. Save records to file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    saveStudentsToFile();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void addStudent() {
        Student student = new Student();
        System.out.print("Enter student ID: ");
        student.setStudentId(scanner.nextLine());
        System.out.print("Enter student name: ");
        student.setName(scanner.nextLine());
        System.out.print("Enter student address: ");
        student.setAddress(scanner.nextLine());
        System.out.print("Enter student phone: ");
        student.setPhone(scanner.nextLine());
        students.add(student);
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.printf("%-10s%-20s%-30s%-15s\n",
                    "StudentID", "Name", "Address", "Phone");
            for (Student student : students) {
                System.out.printf("%-10s%-20s%-30s%-15s\n",
                        student.getStudentId(), student.getName(),
                        student.getAddress(), student.getPhone());
            }
        }
    }

    private static void saveStudentsToFile() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            try {
                FileWriter writer = new FileWriter("students.txt");
                for (Student student : students) {
                    String record = student.getStudentId() + "," +
                            student.getName() + "," +
                            student.getAddress() + "," +
                            student.getPhone() + "\n";
                    writer.write(record);
                }
                writer.close();
                System.out.println("All records saved to students.txt file.");
            } catch (IOException ex) {
                System.out.println("Error encountered while saving records to file.");
            }
        }
    }
}

