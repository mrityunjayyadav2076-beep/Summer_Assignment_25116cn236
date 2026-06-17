#include <stdio.h>

void moveZeroesToEnd(int arr[], int n) {
    int nonZeroIndex = 0;

    for (int i = 0; i < n; i++) {
        if (arr[i] != 0) {
            arr[nonZeroIndex] = arr[i];
            nonZeroIndex++;
        }
    }

    while (nonZeroIndex < n) {
        arr[nonZeroIndex] = 0;
        nonZeroIndex++;
    }
}

int main() {
    int arr[] = {1, 0, 3, 0, 12, 5, 0};
    int n = sizeof(arr) / sizeof(arr[0]);

    printf("Original array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    moveZeroesToEnd(arr, n);

    printf("Modified array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
