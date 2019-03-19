#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<math.h>
#define NUM_OF_THREADS 2
#define SIZE 10000000

double sum = 0;
pthread_mutex_t mutex; // new

void* sum_fun(void* arg){

	int i;
	for(i = 0;i < SIZE;i ++){
	    
		double temp = sin(i)*sin(i) + cos(i)*cos(i);
		pthread_mutex_lock(&mutex);
		sum += temp;
		pthread_mutex_unlock(&mutex);
	}
	
	return NULL;
}

int main(){
	
	pthread_t threads[NUM_OF_THREADS];
    
    pthread_mutex_init(&mutex, NULL);   // new 
    
	int i;
	for(i = 0;i < NUM_OF_THREADS;i++){
		pthread_create(&threads[i],NULL,sum_fun,NULL);
	}

	for(i = 0;i < NUM_OF_THREADS;i++){
		pthread_join(threads[i],NULL);
	}

	printf("%f\n", sum);
    
    pthread_mutex_destroy(&mutex); // new

	return 0;
}
