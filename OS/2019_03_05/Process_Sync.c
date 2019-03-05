#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<math.h>
#define NUM_OF_THREADS 2
#define SIZE 10000000

int sum = 0;

void* sum_fun(void* arg){

	int i;
	for(i = 0;i < SIZE;i ++){
		sum += sin(i)*sin(i) + cos(i)*cos(i);
	}
	
	return NULL;
}

int main(){
	
	pthread_t threads[NUM_OF_THREADS];

	int i;
	for(i = 0;i < NUM_OF_THREADS;i++){
		pthread_create(&threads[i],NULL,sum_fun,NULL);
	}

	for(i = 0;i < NUM_OF_THREADS;i++){
		pthread_join(threads[i],NULL);
	}

	printf("%d\n", sum);

	return 0;
}