#include <stdio.h>

int main() {
    int size;
    int even_count = 0;
    int odd_count = 0;

    printf("Enter the number of elements in the array: ");
    scanf("%d", &size);

    int arr[size];

    printf("Enter %d elements:\n", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    for (int i = 0; i < size; i++) {
        if (arr[i] % 2 == 0) {
            even_count++;
        } else {
            odd_count++;
        }
    }

    printf("\nTotal even elements: %d\n", even_count);
    printf("Total odd elements: %d\n", odd_count);

    return 0;
}
