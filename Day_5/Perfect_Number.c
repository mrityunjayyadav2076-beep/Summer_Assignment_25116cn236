#include <stdio.h>
#include <stdbool.h>

// Function to check if the number is perfect
bool isPerfect(int n) {
    int sum = 0;
    for (int i = 1; i < n; i++) {
        if (n % i == 0) {
            sum += i;
        }
    }
    return sum == n;
}

int main() {
    int n = 15;
    printf(isPerfect(n) ? "true" : "false");
    return 0;
}