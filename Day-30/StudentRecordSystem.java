import java.util.Scanner;

public class StudentRecordSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] rollNo = new int[100];
        String[] name = new String[100];
        double[] marks = new double[100];

        int n = 0, choice;

        while (true) {
            System.out.println("\n===== STUDENT RECORD SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter number of students to add: ");
                    int m = sc.nextInt();

                    for (int i = 0; i < m; i++) {
                        System.out.println("\nEnter details of Student " + (n + 1));

                        System.out.print("Roll Number: ");
                        rollNo[n] = sc.nextInt();

                        sc.nextLine(); // Clear buffer

                        System.out.print("Name: ");
                        name[n] = sc.nextLine();

                        System.out.print("Marks: ");
                        marks[n] = sc.nextDouble();

                        n++;
                    }

                    System.out.println("Student records added successfully!");
                    break;

                case 2:
                    if (n == 0) {
                        System.out.println("No records found.");
                    } else {
                        System.out.println("\n----- Student Records -----");
                        for (int i = 0; i < n; i++) {
                            System.out.println("Roll Number : " + rollNo[i]);
                            System.out.println("Name        : " + name[i]);
                            System.out.println("Marks       : " + marks[i]);
                            System.out.println("--------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (rollNo[i] == searchRoll) {
                            System.out.println("\nStudent Found");
                            System.out.println("Roll Number : " + rollNo[i]);
                            System.out.println("Name        : " + name[i]);
                            System.out.println("Marks       : " + marks[i]);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}