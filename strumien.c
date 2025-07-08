#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#define BUFOR_SIZE 5
#define PRODUCE_COUNT 20

int buffer[BUFOR_SIZE];
int in = 0;
int out = 0;
int count = 0;

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t not_full = PTHREAD_COND_INITIALIZER;
pthread_cond_t not_empty = PTHREAD_COND_INITIALIZER;

void *producer(void *arg)
{
  for (int i = 0; i < PRODUCE_COUNT; i++)
  {
    pthread_mutex_lock(&mutex);
    while (count == BUFOR_SIZE)
    {
      pthread_cond_wait(&not_full, &mutex);
    }

    buffer[in] = i;
    printf("Producent zapisuje %d na pozycji %d\n", i, in);
    in = (in + 1) % BUFOR_SIZE;
    count++;

    pthread_cond_signal(&not_empty);
    pthread_mutex_unlock(&mutex);

    usleep(100000);
  }

  return NULL;
}

void *consumer(void *arg)
{
  for (int i = 0; i < PRODUCE_COUNT; i++)
  {
    pthread_mutex_lock(&mutex);

    while (count == BUFOR_SIZE)
    {
      pthread_cond_wait(&not_empty, &mutex);
    }

    int value = buffer[out];
    printf("Konsument odczytuje %d z pozycji %d\n", value, out);

    out = (out + 1) % BUFOR_SIZE;
    count--;

    pthread_cond_signal(&not_full);
    pthread_mutex_unlock(&mutex);

    usleep(150000);
  }
  return NULL;
}

int main()
{
  pthread_t prod_thread, cons_thread;

  pthread_create(&prod_thread, NULL, producer, NULL);
  pthread_create(&cons_thread, NULL, consumer, NULL);

  pthread_join(prod_thread, NULL);
  pthread_join(cons_thread, NULL);

  pthread_mutex_destroy(&mutex);
  pthread_cond_destroy(&not_full);
  pthread_cond_destroy(&not_empty);

  return 0;
}