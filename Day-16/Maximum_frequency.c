#include <stdio.h>
#include <stdbool.h>

int main() {
    int arr[] = {4, 2, 7, 4, 7, 5, 7, 4, 7, 6};
    int n = sizeof(arr) / sizeof(arr[0]);

    bool visited[n];
    for (int i = 0; i < n; i++) {
        visited[i] = false;
    }

    int max_element = arr[0];
    int max_frequency = 0;

    for (int i = 0; i < n; i++) {

        if (visited[i]) {
            continue;
        }

        int count = 1;
        
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                count++;
                visited[j] = true;
            }
        }

        if (count > max_frequency) {
            max_frequency = count;
            max_element = arr[i];
        }
    }

    printf("The element with maximum frequency is: %d\n", max_element);
    printf("It appears %d times.\n", max_frequency);

    return 0;
}
