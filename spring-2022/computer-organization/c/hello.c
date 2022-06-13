#include <stdio.h>

int main() 
{


    printf("%lu", sizeof(long));
    printf("is it?: %c", getchar() != EOF);
    int c;
    c = getchar();
    while (c != EOF) { 
        putchar(c);
        c = getchar();
    }
    return 0;
}
