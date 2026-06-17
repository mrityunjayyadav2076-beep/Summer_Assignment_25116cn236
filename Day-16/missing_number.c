#include <stdio.h>

int findMissingXOR(int arr[], int size) {
    int xor_all = 0;
    int xor_arr = 0;
    int N = size + 1; 

    for (int i = 1; i <= N; i++) {
        xor_all ^= i;
    }

    for (int i = 0; i < size; i++) {
        xor_arr ^= arr[i];
    }

    return xor_all ^ xor_arr;
}

int main() {

    int arr[] = {1, 3, 7, 4, 2, 6}; 
    int size = sizeof(arr) / sizeof(arr[0]);

    int missing = findMissingXOR(arr, size);
    printf("The missing number is: %d\n", missing);

    return 0;
}
