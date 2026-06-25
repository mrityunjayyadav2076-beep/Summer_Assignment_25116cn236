#include <stdio.h>

// Function to perform binary search
int binarySearch(int arr[], int size, int target) {
    int low = 0;
    int high = size - 1;

    while (low <= high) {
        // Safe midpoint calculation to avoid integer overflow
        int mid = low + (high - low) / 2;

        // Check if the target is present at mid
        if (arr[mid] == target) {
            return mid; 
        }
        
        // If target is greater, ignore the left half
        if (arr[mid] < target) {
            low = mid + 1;
        } 
        // If target is smaller, ignore the right half
        else {
            high = mid - 1;
        }
    }

    // Element was not present in the array
    return -1;
}

int main() {
    int size, target, result;

    // Get the size of the array from the user
    printf("Enter the number of elements: ");
    if (scanf("%d", &size) != 1 || size <= 0) {
        printf("Invalid array size.\n");
        return 1;
    }

    int arr[size];

    // Get array elements from the user (Must be in ascending order)
    printf("Enter %d sorted elements (in ascending order):\n", size);
    for (int i = 0; i < size; i++) {
        printf("Element %d: ", i);
        scanf("%d", &arr[i]);
    }

    // Get the target value to search for
    printf("Enter the element to search for: ");
    scanf("%d", &target);

    // Call the binary search function
    result = binarySearch(arr, size, target);

    // Output the result
    if (result != -1) {
        printf("\nSuccess: Element found at index %d.\n", result);
    } else {
        printf("\nFailure: Element %d is not present in the array.\n", target);
    }

    return 0;
}
