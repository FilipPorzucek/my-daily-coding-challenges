#include <stdio.h>
#include <pthread.h>
#include <unistd.h>
#include <semaphore.h>



int licznik = 0;
sem_t semafor;

int zwiększ()
{
    int tmp = 0;
    sem_wait(&semafor);
    tmp = licznik;
    usleep(0);
    tmp = tmp + 1;
    licznik = tmp;
    sem_post(&semafor);
    return tmp;
}

#define LICZBA_WATKOW 5
#define ILE_RAZY 100

void* thread(void* arg)
{
    for (int i = 0; i < ILE_RAZY; i++) {
        zwiększ();
    }
    return NULL;
}

int main()
{
    pthread_t watki[LICZBA_WATKOW];

    sem_init(&semafor,0,1);

    for (int i = 0; i < LICZBA_WATKOW; i++) {
        pthread_create(&watki[i], NULL, thread, NULL);
    }
    
   
    for (int i = 0; i < LICZBA_WATKOW; i++) {
        pthread_join(watki[i], NULL);
    }

    sem_destroy(&semafor);

    printf("Wartość licznika: %d\n", licznik);
    return 0;
}
