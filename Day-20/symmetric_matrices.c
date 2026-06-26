#include <stdio.h>

int main() {
    int rows, cols, i, j;
    int isSymmetric = 1; // 1 means true, 0 means false

    // 1. Get matrix dimensions from the user
    printf("Enter the number of rows: ");
    scanf("%d", &rows);
    printf("Enter the number of columns: ");
    scanf("%d", &cols);

    // A symmetric matrix must be a square matrix
    if (rows != cols) {
        printf("\nThe matrix is NOT symmetric (It must be a square matrix).\n");
        return 0;
    }

    int matrix[rows][cols];

    // 2. Input matrix elements
    printf("\nEnter the elements of the matrix (%dx%d):\n", rows, cols);
    for (i = 0; i < rows; i++) {
        for (j = 0; j < cols; j++) {
            printf("Element [%d][%d]: ", i, j);
            scanf("%d", &matrix[i][j]);
        }
    }

    // 3. Check for symmetry
    // We only need to check elements below the main diagonal (j < i)
    for (i = 0; i < rows; i++) {
        for (j = 0; j < i; j++) {
            if (matrix[i][j] != matrix[j][i]) {
                isSymmetric = 0; // Mismatch found
                break;           // Exit the inner loop
            }
        }
        if (!isSymmetric) {
            break; // Exit the outer loop
        }
    }

    // 4. Print the result
    if (isSymmetric == 1) {
        printf("\nThe given matrix is a SYMMETRIC matrix.\n");
    } else {
        printf("\nThe given matrix is NOT a SYMMETRIC matrix.\n");
    }

    return 0;
}
