#include <stdio.h>
#include <stdbool.h>

// Function to perform Bubble Sort
void bubbleSort(int arr[], int n) {
    int i, j, temp;
    bool swapped;
    
    // Outer loop runs for each pass
    for (i = 0; i < n - 1; i++) {
        swapped = false;
        
        // Inner loop compares adjacent elements
        // Last i elements are already in place, so we look at n-i-1
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j+1]
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                
                swapped = true; // Mark that a swap occurred
            }
        }
        
        // Optimization: If no two elements were swapped in this pass, the array is already sorted
        if (swapped == false) {
            break;
        }
    }
}

int main() {
    int n, i;

    // Get the number of elements from the user
    printf("Enter the number of elements: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Invalid array size.\n");
        return 1;
    }

    int arr[n]; // Variable-length array based on user input

    // Get the array elements from the user
    printf("Enter %d integers:\n", n);
    for (i = 0; i < n; i++) {
        printf("Element %d: ", i + 1);
        scanf("%d", &arr[i]);
    }

    // Call the bubbleSort function
    bubbleSort(arr, n);

    // Display the sorted array
    printf("\nSorted array in ascending order:\n");
    for (i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
