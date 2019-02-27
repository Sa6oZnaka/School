#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>
#include <time.h>
#define NUM_OF_THREADS 100
#define SIZE 10

void* sort_number(void* arg){
	int *arr = *((int *)arg);
	
	return NULL;
}

int main(){
	int *arr_origin = malloc(sizeof(int)*SIZE);
	int *arr_first = malloc(sizeof(int)*SIZE/2);
	int *arr_second = malloc(sizeof(int)*SIZE/2);
	pthread_t threads[NUM_OF_THREADS];
	
	for(int i=0;i<SIZE;i++){
		arr_origin[i] = (rand() % (100 - 1 + 1)) + 1;
	}
	
	for(int i=0;i<SIZE/2;i++){
		arr_first[i] = arr_origin[i];
	}
	for(int i=SIZE/2;i<SIZE;i++){
		arr_second[i-SIZE/2] = arr_origin[i];
	}

	pthread_create(&threads[0],NULL,sort_number,&arr_first);
	pthread_create(&threads[1],NULL,sort_number,&arr_second);
	pthread_join(threads[0],NULL);
	pthread_join(threads[1],NULL);
	
	return 0;
}
