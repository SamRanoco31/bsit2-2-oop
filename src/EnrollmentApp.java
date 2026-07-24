import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EnrollmentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course>  courses  = new ArrayList<>();
        HashMap<String, ArrayList<String>> enrollments =
                new HashMap<>();
        String[] validPrograms = {"BSIT", "BSCS"};

        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:  // Register Student
                    System.out.print("Student ID   : ");
                    String id = sc.nextLine();
                    // TODO: read name, program, year level
                    System.out.print("Full name: ");
                    String fullName = sc.nextLine();

                    System.out.print("Program: ");
                    String program = sc.nextLine();

                    System.out.print("Full name: ");
                    int yearLevel = Integer.parseInt(sc.nextLine());

                    // TODO: validate program vs validPrograms
                    boolean valid = false;
                    for (String validProgram : validPrograms){
                        if (program.equals(validPrograms)) {
                            valid = true;
                        }
                    }
                    // TODO: validate yearLevel is 1..4
                    if (yearLevel < 1 || 4 > yearLevel){
                        System.out.println("Invalid year level.");
                        break;
                    }
                    students.add(new Student(id, fullName, program, yearLevel));
                    System.out.println("[OK] Registered!");
                    break;
                case 2:  // TODO: Add Course Offering
                    System.out.print("Course Code: ");
                    String courseCode = sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Units: ");
                    int units = Integer.parseInt(sc.nextLine());

                    System.out.print("Capacity: ");
                    int capacity = Integer.parseInt(sc.nextLine());

                    courses.add(new Course(courseCode, title, units, capacity));
                    System.out.println("[OK] Registered!");
                    break;

                case 3:  // TODO: Enroll Student to Course
                    System.out.print("Student ID: ");
                    String studentId = sc.nextLine();

                    System.out.print("Course Code: ");
                    String courseCodes = sc.nextLine();

                    Student student = findStudent(students, studentId);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    Course course = null;
                    for (Course c : courses) {
                        if (c.getCourseCode().equals(courseCodes)) {
                            course = c;
                            break;
                        }
                    }

                    if (course == null) {
                        System.out.println("Course not found.");
                        break;
                    }

                    if (course.isFull()) {
                        System.out.println("Course is already full.");
                        break;
                    }

                    if (!enrollments.containsKey(studentId)) {
                        enrollments.put(studentId, new ArrayList<>());
                    }

                    if (enrollments.get(studentId).contains(courseCodes)) {
                        System.out.println("Student is already enrolled in this course.");
                        break;
                    }

                    enrollments.get(studentId).add(courseCodes);
                    course.addOneEnrollee();

                    System.out.println("[OK] Enrollment successful!");
                    break;
                // TODO: cases 4, 5, 6
                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students registered.");
                        break;
                    }

                    System.out.println("\n--- STUDENT LIST ---");

                    for (Student s : students) {
                        System.out.println("Student ID : " + s.getStudentId());
                        System.out.println("Name       : " + s.getFullName());
                        System.out.println("Program    : " + s.getProgram());
                        System.out.println("Year Level : " + s.getYearLevel());
                        System.out.println("---------------------------");
                    }
                    break;

                case 5:
                    if (courses.isEmpty()) {
                        System.out.println("No courses available.");
                        break;
                    }

                    System.out.println("\n--- COURSE LIST ---");

                    for (Course c : courses) {
                        System.out.println("Course Code : " + c.getCourseCode());
                        System.out.println("Title       : " + c.getTitle());
                        System.out.println("Units       : " + c.getUnits());
                        System.out.println("Capacity    : " + c.getCapacity());
                        System.out.println("Enrolled    : " + c.getEnrolledCount());
                        System.out.println("---------------------------");
                    }
                    break;

                case 6:
                    System.out.print("Student ID: ");
                    String studentsId = sc.nextLine();

                    Student Student = findStudent(students, studentsId);

                    if (Student == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    if (!enrollments.containsKey(studentsId)) {
                        System.out.println("This student has no enrolled courses.");
                        break;
                    }

                    System.out.println("\n--- STUDENT LOAD: " + Student.getFullName() + " ---");

                    int totalUnits = 0;

                    for (String code : enrollments.get(studentsId)) {

                        for (Course c : courses) {

                            if (c.getCourseCode().equals(code)) {

                                System.out.println(
                                        c.getCourseCode() + " - " +
                                                c.getTitle() + " (" +
                                                c.getUnits() + " units)"
                                );

                                totalUnits += c.getUnits();
                            }
                        }
                    }

                    System.out.println("---------------------------");
                    System.out.println("Total Units: " + totalUnits);

                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void printMenu() {
        System.out.println("========================================");
        System.out.println("LICEO ENROLLMENT SYSTEM (CLI)\n");
        System.out.println("========================================\n");
        System.out.println("[1] Register Student");
        System.out.println("[2] Add Course Offering");
        System.out.println("[3] Enroll Student to Course");
        System.out.println("[4] View All Students");
        System.out.println("[5] View All Courses");
        System.out.println("[6] View Student Load (Courses + Total Units)");
        System.out.println("[0] Exit");

        // ... print the rest of the menu
        System.out.print("Enter choice: ");
    }
}

static Student findStudent(ArrayList<Student> list,
                           String id) {
    for (Student s : list) {
        if (s.getStudentId().equals(id)) {
            return s;
        }
    }
    return null;   // not found
}

void main() {
}