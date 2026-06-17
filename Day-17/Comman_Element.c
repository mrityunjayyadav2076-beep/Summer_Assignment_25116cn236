#include <stdio.h>

int main() {
    int n1, n2;
    int i, j, k = 0;
    int isDuplicate;

    printf("Enter the number of elements for the first array: ");
    scanf("%d", &n1);
    int arr1[n1];
    printf("Enter %d elements:\n", n1);
    for(i = 0; i < n1; i++) {
        scanf("%d", &arr1[i]);
    }
    printf("\nEnter the number of elements for the second array: ");
    scanf("%d", &n2);
    int arr2[n2];
    printf("Enter %d elements:\n", n2);
    for(i = 0; i < n2; i++) {
        scanf("%d", &arr2[i]);
    }

    int maxCommon = (n1 < n2) ? n1 : n2;
    int common[maxCommon];

    for(i = 0; i < n1; i++) {
        for(j = 0; j < n2; j++) {
            if(arr1[i] == arr2[j]) {
               isDuplicate = 0;
                for(int m = 0; m < k; m++) {
                    if(common[m] == arr1[i]) {
                        isDuplicate = 1;
                        break;
                    }
                }
                
                if(!isDuplicate) {
                    common[k] = arr1[i];
                    k++;
                }
                
                break; 
            }
        }
    }

    if(k > 0) {
        printf("\nCommon elements are: ");
        for(i = 0; i < k; i++) {
            printf("%d ", common[i]);
        }
        printf("\n");
    } else {
        printf("\nNo common elements found.\n");
    }

    return 0;
}
