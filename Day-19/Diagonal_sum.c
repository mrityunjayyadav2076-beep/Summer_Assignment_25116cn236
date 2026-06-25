#include <stdio.h>

int main() {
    int matrix[100][100];
    int size, i, j;
    int main_diagonal_sum = 0;
    int secondary_diagonal_sum = 0;

    // 1. Get matrix dimensions from the user
    printf("Enter the size of the square matrix (e.g., 3 for 3x3): ");
    scanf("%d", &size);

    // 2. Input matrix elements
    printf("Enter the elements of the matrix:\n");
    for (i = 0; i < size; i++) {
        for (j = 0; j < size; j++) {
            printf("Element [%d][%d]: ", i, j);
            scanf("%d", &matrix[i][j]);
        }
    }

    // 3. Compute diagonal sums in a single O(N) loop
    for (i = 0; i < size; i++) {
        main_diagonal_sum += matrix[i][i];
        secondary_diagonal_sum += matrix[i][size - 1 - i];
    }

    // 4. Display the results
    printf("\n--- Results ---\n");
    printf("Sum of Principal (Main) Diagonal: %d\n", main_diagonal_sum);
    printf("Sum of Secondary (Anti) Diagonal: %d\n", secondary_diagonal_sum);

    return 0;
}
