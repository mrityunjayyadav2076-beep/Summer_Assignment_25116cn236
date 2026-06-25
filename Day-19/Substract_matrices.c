#include <stdio.h>

int main() {
    int rows, cols, i, j;

    // Get matrix dimensions
    printf("Enter rows and columns: ");
    scanf("%d %d", &rows, &cols);

    int m1[rows][cols], m2[rows][cols], res[rows][cols];

    // Input matrices
    printf("Enter elements of Matrix 1:\n");
    for(i=0; i<rows; i++) for(j=0; j<cols; j++) scanf("%d", &m1[i][j]);

    printf("Enter elements of Matrix 2:\n");
    for(i=0; i<rows; i++) for(j=0; j<cols; j++) scanf("%d", &m2[i][j]);

    // Subtract and Display
    printf("Resultant Matrix:\n");
    for(i=0; i<rows; i++) {
        for(j=0; j<cols; j++) {
            res[i][j] = m1[i][j] - m2[i][j];
            printf("%d ", res[i][j]);
        }
        printf("\n");
    }
    return 0;
}
