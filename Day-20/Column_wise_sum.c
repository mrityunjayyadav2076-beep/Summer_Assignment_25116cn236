#include <stdio.h>

int main() {
    int rows, cols;
    
    // 1. Get the matrix dimensions from the user
    printf("Enter the number of rows: ");
    scanf("%d", &rows);
    printf("Enter the number of columns: ");
    scanf("%d", &cols);
    
    int matrix[rows][cols];
    
    // 2. Take matrix elements as input
    printf("\nEnter the elements of the matrix:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("Element [%d][%d]: ", i, j);
            scanf("%d", &matrix[i][j]);
        }
    }
    
    // 3. Display the entered matrix for verification
    printf("\nThe entered matrix is:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }
    
    // 4. Calculate and print column-wise sums
    printf("\n--- Column-wise Sum ---\n");
    for (int j = 0; j < cols; j++) {
        int colSum = 0;
        for (int i = 0; i < rows; i++) {
            colSum += matrix[i][j]; // Accumulate sum down the column
        }
        printf("Sum of Column %d = %d\n", j + 1, colSum);
    }
    
    return 0;
}
