#include <stdio.h>

int main() {
    int n;

    printf("Enter the number of elements in the array: ");
    if (scanf("%d", &n) != 1 || n <= 0) {
        printf("Invalid array size.\n");
        return 1;
    }

    int arr[n];

    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    printf("\nDuplicate elements in the array are:\n");
    int hasDuplicates = 0;

    for (int i = 0; i < n; i++) {
        int isAlreadyPrinted = 0;

        for (int k = 0; k < i; k++) {
            if (arr[i] == arr[k]) {
                isAlreadyPrinted = 1;
                break;
            }
        }
        if (!isAlreadyPrinted) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    printf("%d ", arr[i]);
                    hasDuplicates = 1;
                    break; 
                }
            }
        }
    }

    if (!hasDuplicates) {
        printf("None");
    }
    printf("\n");

    return 0;
}
