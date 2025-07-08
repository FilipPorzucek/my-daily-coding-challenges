#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/mman.h>
#include <sys/wait.h>
#include <semaphore.h>

#define N 10
#define P 4

sem_t *mutex;
sem_t *wagonReady;
int *pasazerowieNaPokladzie;

void pasazer(int id)
{
  printf("Pasażer %d próbuje wejść do kolejki \n", id);
  sem_wait(mutex);
  while (*pasazerowieNaPokladzie >= P)
  {
    sem_post(mutex);
    usleep(1000);
    sem_wait(mutex);
  }
  (*pasazerowieNaPokladzie)++;
  printf("Pasażer %d wszedł do wagonika,Liczba pasażerów to %d \n", id, *pasazerowieNaPokladzie);
  if (*pasazerowieNaPokladzie == P)
  {
    printf("Wagonik rusz a %d pasażerami\n", P);
    sleep(2);
    printf("Wagonik zakończył przejazd\n");
    *pasazerowieNaPokladzie = 0;
    sem_post(wagonReady);
  }
  sem_post(mutex);
  exit(0);
}

int main()
{
  pasazerowieNaPokladzie = mmap(NULL, sizeof(int), PROT_READ | PROT_WRITE,
                                MAP_SHARED | MAP_ANONYMOUS, -1, 0);
  mutex = mmap(NULL, sizeof(sem_t), PROT_READ | PROT_WRITE,
               MAP_SHARED | MAP_ANONYMOUS, -1, 0);
  wagonReady = mmap(NULL, sizeof(sem_t), PROT_READ | PROT_WRITE,
                    MAP_SHARED | MAP_ANONYMOUS, -1, 0);

  *pasazerowieNaPokladzie = 0;

  sem_init(mutex, 1, 1);
  sem_init(wagonReady, 1, 0);

  for (int i=0; i < N; i++)
  {
    pid_t pid = fork();
    if (pid == 0)
    {
      pasazer(i + 1);
    }
    usleep(1000);
  }
  for (int i = 0; i < N; i++)
  {
    wait(NULL);
  }

  sem_destroy(mutex);
  sem_destroy(wagonReady);
  munmap(mutex, sizeof(sem_t));
  munmap(wagonReady, sizeof(sem_t));
  munmap(pasazerowieNaPokladzie, sizeof(int));

  return 0;
}
