#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <semaphore.h>

#define SHM_NAME "/moja pamiec"
#define SEM_NAME "/moj_semafor"
#define BUFOR_SIZE 5

typedef struct
{
  int dane[BUFOR_SIZE];
  int head;
  int tail;
} Bufor;

int main()
{
  int shm_fd;
  Bufor *bufor;
  sem_t *semafor;

  shm_fd = shm_open(SHM_NAME, O_CREAT | O_RDWR, 0666);
  ftruncate(shm_fd, sizeof(Bufor));
  bufor = mmap(0, sizeof(int), PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);

  semafor = sem_open(SEM_NAME, O_CREAT, 0666, 1);

  bufor->head = 0;
  bufor->tail = 0;

  pid_t pid = fork();

  if (pid == 0)
  {
    for (int i = 0; i < 100; i++)
    {
      sem_wait(semafor);
      bufor->dane[bufor->head] = i;
      printf("Dziecko zapisalo: %d\n", i);
      bufor->head = (bufor->head + 1) % BUFOR_SIZE;
      sem_post(semafor);
      sleep(1);
    }
  }
  else
  {
    for (int i = 0; i < 100; i++)
    {
      sem_wait(semafor);
      printf("Rodzic odczytal: %d\n", bufor->dane[bufor->tail]);
      bufor->tail = (bufor->tail + 1) % BUFOR_SIZE;
      sem_post(semafor);
      sleep(1);
    }
  }
  sem_close(semafor);
  sem_unlink(SEM_NAME);
  munmap(bufor, sizeof(Bufor));
  shm_unlink(SHM_NAME);

  return 0;
}