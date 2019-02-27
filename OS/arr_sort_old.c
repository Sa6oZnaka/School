#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>

#define NUM_OF_THREADS 5
#define SIZE 10

void* sort(void* arg){	
	
	int *arr = *((int *)arg);
	
	for(int i = 0;i < SIZE / 2;i ++){
		printf("%d \n", arr[i]);
	}
	
	return NULL;
}


int main(){
	
	int *input_array = malloc(sizeof(int) * SIZE);
	int *first_array = 	malloc(sizeof(int) * SIZE / 2);
	int *second_array = malloc(sizeof(int) * SIZE / 2);
	
	pthread_t threads[NUM_OF_THREADS];
	
	input_array[0] = 10;
	input_array[1] = 3;
	input_array[2] = 8;
	input_array[3] = 4;
	input_array[4] = 16;
	input_array[5] = 42;
	input_array[6] = 12;
	input_array[7] = 43;
	input_array[8] = 5;
	input_array[9] = 43;
	
	for(int i=0;i < SIZE / 2;i++){
		first_array[i] = input_array[i];
	}
	for(int i = SIZE / 2;i < SIZE;i++){
		second_array[i-SIZE/2] = input_array[i];
	}
	
	for(int i = 0;i < SIZE/2;i++){
		printf("%d\n", first_array[i]);
	}
	for(int i = 0;i < SIZE/2;i++){
		printf("%d\n", second_array[i]);
	}
	
	pthread_create(&threads[0], NULL, sort, &first_array);
	pthread_create(&threads[1], NULL, sort, &second_array);
	pthread_join(threads[0], NULL);
	pthread_join(threads[1], NULL);

	return 0;
}	
