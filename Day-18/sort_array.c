#include <stdio.h>

int main() {
    int arr[100];
    int n, i, j, temp;

    // 1. Get the size of the array from the user
    printf("Enter the number of elements (Max 100): ");
    scanf("%d", &n);

    // 2. Take array elements as input from the user
    printf("Enter %d elements:\n", n);
    for (i = 0; i < n; i++) {
        printf("Element %d: ", i + 1);
        scanf("%d", &arr[i]);
    }

    // 3. Sort the array in descending order (Bubble Sort)
    for (i = 0; i < n - 1; i++) {
        for (j = i + 1; j < n; j++) {
            // Change '<' to '>' if you want ascending order
            if (arr[i] < arr[j]) { 
                // Swap elements
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    // 4. Print the sorted array
    printf("\nArray sorted in descending order:\n");
    for (i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
