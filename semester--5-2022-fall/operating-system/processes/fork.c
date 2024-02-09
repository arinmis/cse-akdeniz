#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main()
{

        // make two process which run same
        // program after this instruction
        pid_t pid = fork();

        printf("This is pid: %d\n", pid);
        return 0;
}
