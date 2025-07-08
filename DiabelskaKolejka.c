#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>


#define N 10
#define P 4

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t wagonReady=PTHREAD_COND_INITIALIZER;

int pasazerowieNaPokladzie=0;

void* pasazer(void* arg){
  int id=*((int*)arg);
  free(arg);


  printf("Pasażer %d próbuje wejść do wagonika...\n",id);

  pthread_mutex_lock(&mutex);

 while (pasazerowieNaPokladzie>=P){
  pthread_cond_wait(&wagonReady,&mutex);
 }
pasazerowieNaPokladzie++;

printf("Pasażer %d wszedł do wagonika. Liczba pasażerów: %d\n",id,pasazerowieNaPokladzie);

if(pasazerowieNaPokladzie==P){
printf("Wagonik rusza z %d pasażerami",P);
sleep(2);
printf("Wagonik zakończył przejazd!\n");

pasazerowieNaPokladzie=0;

pthread_cond_broadcast(&wagonReady);

}
pthread_mutex_unlock(&mutex);
pthread_exit(NULL);
}

int main(){
  pthread_t threads[N];
  for(int i=0;i<N;i++){
    int* id=malloc(sizeof(int));
    *id=i+1;
    pthread_create(&threads[i],NULL,pasazer,id);
    usleep(1000);
  }

  for(int i=0;i<N;i++){
    pthread_join(threads[i],NULL);
  }

  pthread_mutex_destroy(&mutex);
  pthread_cond_destroy(&wagonReady);

  return 0;

}

