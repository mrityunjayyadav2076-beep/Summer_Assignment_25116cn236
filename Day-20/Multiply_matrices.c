#include <stdio.h>
#include <stdlib.h>

int main() {
    int r1, c1, r2, c2;

    // 1. Input dimensions for the first matrix
    printf("Enter rows and columns for the first matrix: ");
    scanf("%d %d", &r1, &c1);

    // 2. Input dimensions for the second matrix
    printf("Enter rows and columns for the second matrix: ");
    scanf("%d %d", &r2, &c2);

    // 3. Check if matrix multiplication is possible
    if (c1 != r2) {
        printf("\nError: Multiplication not possible.\n");
        printf("Columns of the first matrix (%d) must match rows of the second matrix (%d).\n", c1, r2);
        return 1; 
    }

    // Declare matrices using Variable Length Arrays (VLA)
    int first[r1][c1];
    int second[r2][c2];
    int result[r1][c2];

    // 4. Input elements of the first matrix
    printf("\nEnter elements of the first matrix (%dx%d):\n", r1, c1);
    for (int i = 0; i < r1; i++) {
        for (int j = 0; j < c1; j++) {
            printf("Element [%d][%d]: ", i + 1, j + 1);
            scanf("%d", &first[i][j]);
        }
    }

    // 5. Input elements of the second matrix
    printf("\nEnter elements of the second matrix (%dx%d):\n", r2, c2);
    for (int i = 0; i < r2; i++) {
        for (int j = 0; j < c2; j++) {
            printf("Element [%d][%d]: ", i + 1, j + 1);
            scanf("%d", &second[i][j]);
        }
    }

    // 6. Initialize the result matrix to 0 and multiply matrices
    for (int i = 0; i < r1; i++) {
        for (int j = 0; j < c2; j++) {
            result[i][j] = 0; // Clear garbage values
            for (int k = 0; k < c1; k++) {
                result[i][j] += first[i][k] * second[k][j];
            }
        }
    }

    // 7. Display the final multiplied matrix
    printf("\nResultant Matrix after multiplication:\n");
    for (int i = 0; i < r1; i++) {
        for (int j = 0; j < c2; j++) {
            printf("%d\t", result[i][j]);
        }
        printf("\n");
    }

    return 0;
}
