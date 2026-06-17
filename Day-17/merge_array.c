#include <stdio.h>

int main() {
    int arr1[50], arr2[50], merged[100];
    int size1, size2, i, k = 0;

    printf("Enter size for array 1: ");
    scanf("%d", &size1);
    printf("Enter elements: ");
    for (i = 0; i < size1; i++) {
        scanf("%d", &arr1[i]);
        merged[k++] = arr1[i]; 
    }

    printf("Enter size for array 2: ");
    scanf("%d", &size2);
    printf("Enter elements: ");
    for (i = 0; i < size2; i++) {
        scanf("%d", &arr2[i]);
        merged[k++] = arr2[i];
    }

    printf("Merged array: ");
    for (i = 0; i < k; i++) printf("%d ", merged[i]);
    return 0;
}
