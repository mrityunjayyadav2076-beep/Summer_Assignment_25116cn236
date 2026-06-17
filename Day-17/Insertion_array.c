#include <stdio.h>

int main() {
    int n1, n2, i, j, k;
    int isDuplicate, isAlreadyInIntersection;

    printf("Enter the number of elements for the first array: ");
    scanf("%d", &n1);
    int arr1[n1];
    printf("Enter %d elements for the first array:\n", n1);
    for(i = 0; i < n1; i++) {
        scanf("%d", &arr1[i]);
    }

    printf("Enter the number of elements for the second array: ");
    scanf("%d", &n2);
    int arr2[n2];
    printf("Enter %d elements for the second array:\n", n2);
    for(i = 0; i < n2; i++) {
        scanf("%d", &arr2[i]);
    }

    int minSize = (n1 < n2) ? n1 : n2;
    int intersection[minSize];
    int intersectCount = 0;

    for(i = 0; i < n1; i++) {
        isDuplicate = 0;
        for(k = 0; k < i; k++) {
            if(arr1[i] == arr1[k]) {
                isDuplicate = 1;
                break;
            }
        }
        if(isDuplicate) continue; 

        for(j = 0; j < n2; j++) {
            if(arr1[i] == arr2[j]) {
                
                isAlreadyInIntersection = 0;
                for(k = 0; k < intersectCount; k++) {
                    if(arr1[i] == intersection[k]) {
                        isAlreadyInIntersection = 1;
                        break;
                    }
                }
                
                if(!isAlreadyInIntersection) {
                    intersection[intersectCount] = arr1[i];
                    intersectCount++;
                }
                break; 
            }
        }
    }

    printf("\nIntersection of the two arrays: ");
    if(intersectCount == 0) {
        printf("No common elements found.");
    } else {
        for(i = 0; i < intersectCount; i++) {
            printf("%d ", intersection[i]);
        }
    }
    printf("\n");

    return 0;
}
