#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>
#include <time.h>
#define NUM_OF_THREADS 100
#define SIZE 10

int f_array[SIZE/2];
int s_array[SIZE/2];

int cmpfunc (const void * a, const void * b) {
   return ( *(int*)a - *(int*)b );
}

void* sort_number_1(void* arg){

    qsort(f_array, SIZE/2, sizeof(int), cmpfunc);

	for(int i=0;i<SIZE/2;i++){
		printf("%d\n", f_array[i]);
	}
	
	return NULL;
}
void* sort_number_2(void* arg){
	
    qsort(s_array, SIZE/2, sizeof(int), cmpfunc);

	for(int i=0;i<SIZE/2;i++){
		printf("%d\n", s_array[i]);
	}
	
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
		f_array[i] = arr_origin[i];
	}
	for(int i=SIZE/2;i<SIZE;i++){
		s_array[i-SIZE/2] = arr_origin[i];
	}

	pthread_create(&threads[0],NULL,sort_number_1,NULL);
	pthread_create(&threads[1],NULL,sort_number_2,NULL);
	pthread_join(threads[0],NULL);
	pthread_join(threads[1],NULL);
	
    int pos1 = 0,
        pos2 = 0;

    int result_arr[SIZE];
    while(pos1 < SIZE/2 && pos2 < SIZE/2){
        if(f_array[pos1] > s_array[pos2]){
            result_arr[pos1 + pos2] = f_array[pos1];
            pos1++;
        }else{
            result_arr[pos1 + pos2] = s_array[pos2];
            pos2++;
        }        
    }
    printf("=============\n");
    for(int i=0;i<SIZE;i++){
        printf("%d \n", result_arr[i]);
    }


	return 0;
}
