#include<stdio.h>
#include<unistd.h>

int main() {
    int n = write(1, "Arinmis\n", 9);
    printf("value is: %d\n", n);
}
