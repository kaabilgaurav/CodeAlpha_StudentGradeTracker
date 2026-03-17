import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter marks: ");
                int marks = sc.nextInt();

                students.add(new Student(name, marks));
                System.out.println("Student added successfully!");

            }
            else if (choice == 2) {

                if (students.isEmpty()) {
                    System.out.println("No data available.");
                    continue;
                }

                int total = 0;
                int highest = students.get(0).marks;
                int lowest = students.get(0).marks;

                System.out.println("\n--- Student Report ---");

                for (Student s : students) {

                    String grade;
                    if (s.marks >= 80) grade = "A";
                    else if (s.marks >= 60) grade = "B";
                    else if (s.marks >= 40) grade = "C";
                    else grade = "Fail";

                    System.out.println("Name: " + s.name +
                            " | Marks: " + s.marks +
                            " | Grade: " + grade);

                    total += s.marks;

                    if (s.marks > highest) highest = s.marks;
                    if (s.marks < lowest) lowest = s.marks;
                }

                double avg = (double) total / students.size();

                System.out.println("\nTotal Students: " + students.size());
                System.out.println("Average Marks: " + avg);
                System.out.println("Highest Marks: " + highest);
                System.out.println("Lowest Marks: " + lowest);

            }
            else if (choice == 3) {
                System.out.println("Exiting program...");
                break;
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
    }

}
