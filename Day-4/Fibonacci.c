#include <stdio.h>
 int main() 
 { 
    int n,i, a = 0, b = 1, c; 
    printf("Enter the number of terms: ");
    scanf("%d", &n); 
    printf("Fibonacci Series: "); 
    for(int i = 1; i <=n; ++i) 
    { 
      if(i==1)
      {
         printf("%d",a);
         continue;
      }
      if(i==2)
      {
         printf("%d",b);
         continue;
      }
        printf("%d ", a); 
        c = a + b; 
        a = b; 
        b = c;
     }
      return 0; 
    }