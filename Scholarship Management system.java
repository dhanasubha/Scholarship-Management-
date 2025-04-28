import java.util.Scanner;


class Person {
    String name;
    String age;

    Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
}


class Student extends Person {
    String studentId;
    String grade;
    String address;

    Student(String studentId, String name, String age, String grade, String address) {
        super(name, age);
        this.studentId = studentId;
        this.grade = grade;
        this.address = address;
    }

    void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Address: " + address);
    }
}

class Scholarship extends Student {
    String scholarshipId;
    String scholarshipName;
    String eligibility;
    double amount;

    Scholarship(String scholarshipId, String scholarshipName, String eligibility, double amount,
                String studentId, String name, String age, String grade, String address) {
        super(studentId, name, age, grade, address);
        this.scholarshipId = scholarshipId;
        this.scholarshipName = scholarshipName;
        this.eligibility = eligibility;
        this.amount = amount;
    }

    void displayScholarship() {
        System.out.println("\n--- Student Details ---");
        displayStudent();
        System.out.println("--- Scholarship Details ---");
        System.out.println("Scholarship ID: " + scholarshipId);
        System.out.println("Scholarship Name: " + scholarshipName);
        System.out.println("Eligibility: " + eligibility);
        System.out.println("Amount: $" + amount);
        System.out.println("------------------------------");
    }
}


public class ScholarshipManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scholarship[] scholarships = new Scholarship[10];
        int count = 0;

        int choice;
        do {
            System.out.println("\n--- Scholarship Management System ---");
            System.out.println("1. Add Scholarship");
            System.out.println("2. View Scholarships");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            switch (choice) {
                case 1:
                    if (count < scholarships.length) {
                        // Input Scholarship info
                        System.out.print("Enter Scholarship ID: ");
                        String scholarshipId = sc.nextLine();
                        System.out.print("Enter Scholarship Name: ");
                        String scholarshipName = sc.nextLine();
                        System.out.print("Enter Eligibility: ");
                        String eligibility = sc.nextLine();
                        System.out.print("Enter Amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine(); // clear buffer

                        // Input Student info
                        System.out.print("Enter Student ID: ");
                        String studentId = sc.nextLine();
                        System.out.print("Enter Student Name: ");
                        String studentName = sc.nextLine();
                        System.out.print("Enter Student Age: ");
                        String studentAge = sc.nextLine();
                        System.out.print("Enter Student Grade: ");
                        String studentGrade = sc.nextLine();
                        System.out.print("Enter Student Address: ");
                        String studentAddress = sc.nextLine();

                        scholarships[count] = new Scholarship(scholarshipId, scholarshipName, eligibility, amount,
                                                              studentId, studentName, studentAge, studentGrade, studentAddress);
                        count++;
                        System.out.println("Scholarship assigned to student successfully!");
                    } else {
                        System.out.println("Scholarship list is full!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No scholarships available.");
                    } else {
                        System.out.println("\n--- Scholarship List ---");
                        for (int i = 0; i < count; i++) {
                            scholarships[i].displayScholarship();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
