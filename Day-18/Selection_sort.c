#include <stdio.h>

// Function to perform Selection Sort
void selectionSort(int arr[], int n) {
    int i, j, min_idx, temp;

    // Move the boundary of the unsorted subarray one by one
    for (i = 0; i < n - 1; i++) {
        // Find the minimum element in the unsorted array
        min_idx = i;
        for (j = i + 1; j < n; j++) {
            if (arr[j] < arr[min_idx]) {
                min_idx = j;
            }
        }

        // Swap the found minimum element with the first element
        if (min_idx != i) {
            temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }
}

int main() {
    int n, i;

    // Get the size of the array from the user
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    int arr[n]; // Declare array of size n

    // Get array elements from the user
    printf("Enter %d elements:\n", n);
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Call the selection sort function
    selectionSort(arr, n);

    // Display the sorted array
    printf("\nSorted array in ascending order:\n");
    for (i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
