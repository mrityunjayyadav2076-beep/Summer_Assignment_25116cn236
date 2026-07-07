import java.util.Scanner;

public class MarksheetSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Gather Student Details
        System.out.println("=========================================");
        System.out.println("       MARKSHEET GENERATION SYSTEM       ");
        System.out.println("=========================================");
        
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        
        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int totalSubjects = scanner.nextInt();
        
        // Arrays to hold subject data
        String[] subjects = new String[totalSubjects];
        int[] marks = new int[totalSubjects];
        
        int totalObtainedMarks = 0;
        int maxMarksPerSubject = 100;
        boolean hasFailedAnySubject = false;

        // 2. Collect Subject Names and Marks
        for (int i = 0; i < totalSubjects; i++) {
            scanner.nextLine(); // Clear scanner buffer
            System.out.print("\nEnter name for Subject " + (i + 1) + ": ");
            subjects[i] = scanner.nextLine();
            
            // Loop for validation: Marks must be between 0 and 100
            while (true) {
                System.out.print("Enter marks obtained in " + subjects[i] + " (Out of 100): ");
                int inputMark = scanner.nextInt();
                
                if (inputMark >= 0 && inputMark <= maxMarksPerSubject) {
                    marks[i] = inputMark;
                    totalObtainedMarks += inputMark;
                    
                    // Consider passing marks for individual subject as 40
                    if (inputMark < 40) {
                        hasFailedAnySubject = true;
                    }
                    break;
                } else {
                    System.out.println("Invalid entry! Marks must be between 0 and 100.");
                }
            }
        }

        // 3. Perform Calculations
        int maximumTotalMarks = totalSubjects * maxMarksPerSubject;
        double percentage = ((double) totalObtainedMarks / maximumTotalMarks) * 100;
        
        // 4. Determine Final Grade and Status
        String grade;
        String finalStatus;

        if (hasFailedAnySubject) {
            grade = "F";
            finalStatus = "FAILED (Failed in one or more subjects)";
        } else {
            finalStatus = "PASSED";
            if (percentage >= 90) grade = "A+";
            else if (percentage >= 80) grade = "A";
            else if (percentage >= 70) grade = "B";
            else if (percentage >= 60) grade = "C";
            else if (percentage >= 50) grade = "D";
            else grade = "E";
        }

        // 5. Generate and Display the Formatted Marksheet
        System.out.println("\n\n=================================================");
        System.out.println("                OFFICIAL MARKSHEET               ");
        System.out.println("=================================================");
        System.out.printf(" Student Name : %-30s \n", studentName.toUpperCase());
        System.out.printf(" Roll Number  : %-30s \n", rollNumber);
        System.out.println("-------------------------------------------------");
        System.out.printf(" %-25s | %-15s \n", "SUBJECT", "MARKS OBTAINED");
        System.out.println("-------------------------------------------------");
        
        for (int i = 0; i < totalSubjects; i++) {
            System.out.printf(" %-25s | %-15d \n", subjects[i], marks[i]);
        }
        
        System.out.println("-------------------------------------------------");
        System.out.printf(" Total Marks Secured: %d / %d \n", totalObtainedMarks, maximumTotalMarks);
        System.out.printf(" Aggregate Percent  : %.2f%% \n", percentage);
        System.out.printf(" Final Grade        : %s \n", grade);
        System.out.printf(" Result Status      : %s \n", finalStatus);
        System.out.println("=================================================");

        scanner.close();
    }
}
