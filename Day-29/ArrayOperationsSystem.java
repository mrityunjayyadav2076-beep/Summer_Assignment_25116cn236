import java.util.Scanner;

public class ArrayOperationsSystem {
    private static final int MAX_CAPACITY = 100;
    private static int[] array = new int[MAX_CAPACITY];
    private static int size = 0; // Tracks actual elements in the array
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice (1-7): ");
            while (!scanner.hasNextInt()) {
                System.out.println("❌ Invalid input! Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> initializeArray();
                case 2 -> displayArray();
                case 3 -> insertElement();
                case 4 -> deleteElement();
                case 5 -> searchElement();
                case 6 -> calculateSumAndAverage();
                case 7 -> System.out.println("\n👋 Exiting the system. Goodbye!");
                default -> System.out.println("❌ Invalid choice! Please select between 1 and 7.");
            }
        } while (choice != 7);
    }

    private static void displayMenu() {
        System.out.println("\n====================================");
        System.out.println("     ARRAY OPERATIONS SYSTEM        ");
        System.out.println("====================================");
        System.out.println("1. Initialize Array with Elements");
        System.out.println("2. Display Array Elements");
        System.out.println("3. Insert Element at a Position");
        System.out.println("4. Delete Element from a Position");
        System.out.println("5. Search Element (Linear Search)");
        System.out.println("6. Display Sum and Average");
        System.out.println("7. Exit");
        System.out.println("====================================");
    }

    // 2. Populate Array
    private static void initializeArray() {
        System.out.print("Enter the number of elements to add (Max " + MAX_CAPACITY + "): ");
        int count = scanner.nextInt();

        if (count < 0 || count > MAX_CAPACITY) {
            System.out.println("❌ Invalid size! Must be between 0 and " + MAX_CAPACITY);
            return;
        }

        size = count;
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element [" + i + "]: ");
            array[i] = scanner.nextInt();
        }
        System.out.println("✅ Array initialized successfully.");
    }

    // 3. Display Elements (Traversal)
    private static void displayArray() {
        if (size == 0) {
            System.out.println("⚠️ Array is empty!");
            return;
        }
        System.out.print("📋 Current Array Elements: [");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // 4. Insert Element at specific index
    private static void insertElement() {
        if (size >= MAX_CAPACITY) {
            System.out.println("❌ Array overflow! Cannot insert more elements.");
            return;
        }

        System.out.print("Enter element to insert: ");
        int element = scanner.nextInt();
        System.out.print("Enter target index position (0 to " + size + "): ");
        int index = scanner.nextInt();

        if (index < 0 || index > size) {
            System.out.println("❌ Invalid index position!");
            return;
        }

        // Shift elements to the right to make space
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
        size++;
        System.out.println("✅ Element inserted successfully.");
    }

    // 5. Delete Element from specific index
    private static void deleteElement() {
        if (size == 0) {
            System.out.println("⚠️ Array underflow! Nothing to delete.");
            return;
        }

        System.out.print("Enter index position to delete (0 to " + (size - 1) + "): ");
        int index = scanner.nextInt();

        if (index < 0 || index >= size) {
            System.out.println("❌ Invalid index position!");
            return;
        }

        int removedValue = array[index];

        // Shift elements to the left to close the gap
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        System.out.println("✅ Deleted " + removedValue + " from position " + index);
    }

    // 6. Linear Search
    private static void searchElement() {
        if (size == 0) {
            System.out.println("⚠️ Array is empty!");
            return;
        }

        System.out.print("Enter the element to search for: ");
        int target = scanner.nextInt();
        int foundIndex = -1;

        for (int i = 0; i < size; i++) {
            if (array[i] == target) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("🎯 Element found at index: " + foundIndex);
        } else {
            System.out.println("❌ Element not found in the array.");
        }
    }

    // 7. Statistical Aggregations
    private static void calculateSumAndAverage() {
        if (size == 0) {
            System.out.println("⚠️ Array is empty! Sum and average are 0.");
            return;
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }
        double average = (double) sum / size;

        System.out.println("📊 Array Statistics:");
        System.out.println("   • Total Sum: " + sum);
        System.out.println("   • Average:   " + average);
    }
}
