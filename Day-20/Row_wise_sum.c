#include <stdio.h>

int main() {
    int rows, cols;

    // 1. Get matrix dimensions from the user
    printf("Enter the number of rows and columns: ");
    scanf("%d %d", &rows, &cols);

    // Declare the 2D array (Matrix)
    int matrix[rows][cols];

    // 2. Get matrix elements from the user
    printf("Enter the elements of the matrix:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("Element [%d][%d]: ", i, j);
            scanf("%d", &matrix[i][j]);
        }
    }

    // 3. Display the entered matrix for verification
    printf("\nThe Matrix is:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }

    // 4. Calculate and display the row-wise sum
    printf("\n--- Row-wise Sum ---\n");
    for (int i = 0; i < rows; i++) {
        int rowSum = 0; // Reset sum for each new row
        for (int j = 0; j < cols; j++) {
            rowSum += matrix[i][j]; // Accumulate row elements
        }
        printf("Sum of Row %d = %d\n", i + 1, rowSum);
    }

    return 0;
}
