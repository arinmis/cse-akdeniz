#include <pthread.h>
#include <unistd.h>
#include <stdio.h>


void* myturn(void *arg) { 
    for (int i = 0; i < 8; i++) { 
        sleep(1);
        printf("My Turn! %d\n", i);
    }
    return NULL;
}


void yourturn() { 
    for (int i = 0; i < 3; i++) { 
        sleep(2);
        printf("Your Turn! %d\n", i);
    }
}

int main() { 
    pthread_t tid;

    pthread_create(&tid, NULL, myturn, NULL);
    yourturn();
    pthread_join(tid, NULL);
}
