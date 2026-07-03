import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int Max = 10;
        int[] studentID = new int[Max];
        String[] fullName = new String[Max];
        int[] age = new int[Max];
        String[] course = new String[Max];
        double[] grade = new double[Max];
        boolean[] enrolled = new boolean[Max];

        int count = 0;
        int choice;

        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. View Statistics");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        choice = input.nextInt();

        switch (choice) {

            case 1:
                if (count >= Max) {
                    System.out.println("Student list is full!");
                } else {
                    System.out.print("Student ID: ");
                    studentID[count] = input.nextInt();
                    input.nextLine();

                    System.out.print("Full Name: ");
                    fullName[count] = input.nextLine();

                    System.out.print("Age: ");
                    age[count] = input.nextInt();
                    input.nextLine();

                    System.out.print("Course: ");
                    course[count] = input.nextLine();

                    System.out.print("Grade: ");
                    grade[count] = input.nextDouble();

                    System.out.print("Enrolled (true/false): ");
                    enrolled[count] = input.nextBoolean();

                    count++;
                    System.out.println("Student added successfully!");
                }
                break;

            case 2:
                if (count == 0) {
                    System.out.println("No students found.");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.println("\nStudent " + (i + 1));
                        System.out.println("ID: " + studentID[i]);
                        System.out.println("Name: " + fullName[i]);
                        System.out.println("Age: " + age[i]);
                        System.out.println("Course: " + course[i]);
                        System.out.println("Grade: " + grade[i]);
                        System.out.println("Enrolled: " + enrolled[i]);
                    }
                }
                break;

            case 3:
                System.out.print("Enter Student ID: ");
                int searchID = input.nextInt();

                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (studentID[i] == searchID) {
                        System.out.println("\nStudent Found");
                        System.out.println("ID: " + studentID[i]);
                        System.out.println("Name: " + fullName[i]);
                        System.out.println("Age: " + age[i]);
                        System.out.println("Course: " + course[i]);
                        System.out.println("Grade: " + grade[i]);
                        System.out.println("Enrolled: " + enrolled[i]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Student not found.");
                }
                break;

            case 4:
                if (count == 0) {
                    System.out.println("No students available.");
                } else {
                    double total = 0;
                    double highest = grade[0];
                    double lowest = grade[0];

                    for (int i = 0; i < count; i++) {
                        total += grade[i];

                        if (grade[i] > highest) {
                            highest = grade[i];
                        }

                        if (grade[i] < lowest) {
                            lowest = grade[i];
                        }
                    }

                    double average = total / count;

                    System.out.println("\n===== STUDENT STATISTICS =====");
                    System.out.println("Total Students : " + count);
                    System.out.println("Average Grade  : " + average);
                    System.out.println("Highest Grade  : " + highest);
                    System.out.println("Lowest Grade   : " + lowest);
                }
                break;

            case 5:
                System.out.println("Thank you for using the Student Management System!");
                break;

            default:
                System.out.println("Invalid choice! Please try again.");

        }
    }
}