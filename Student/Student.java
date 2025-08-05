package Student;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int marks;

    // Constructor
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        if (findStudentIndex(id) != -1) {
            System.out.println("Student with this ID already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Marks: ");
        int marks = scanner.nextInt();

        Student newStudent = new Student(id, name, marks);
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("--- Student List ---");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student not found!");
            return;
        }

        Student student = students.get(index);

        System.out.println("Current Student Details: " + student);
        System.out.println("What would you like to update?");
        System.out.println("1. Name");
        System.out.println("2. Marks");
        System.out.print("Enter your choice: ");

        int updateChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (updateChoice) {
            case 1:
                System.out.print("Enter new Name: ");
                String newName = scanner.nextLine();
                student.setName(newName);
                break;
            case 2:
                System.out.print("Enter new Marks: ");
                int newMarks = scanner.nextInt();
                student.setMarks(newMarks);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("Student updated successfully!");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student not found!");
            return;
        }

        students.remove(index);
        System.out.println("Student deleted successfully!");
    }

    private static int findStudentIndex(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}