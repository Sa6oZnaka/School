//--------------------------------------------
//	NAME: Alexandar Karapenev
//  CLASS: XIb
//  NUMBER: 1
//  PROBLEM: #1
//---------------------------------------------

#include<unistd.h>
#include<pthread.h>
#include<math.h>
#include<stdlib.h>
#include<stdio.h>

#define NUM_OF_THREADS 100

pthread_mutex_t mutex[5];

void* drivers(void *arg){
    
    int id = *((int *)arg);
    int used_cars[5] = {0,0,0,0,0};

    while(1){
	    for(int i = 0;i < 5;i ++){	
	        if(used_cars[i] != 1){
	            if(pthread_mutex_trylock(&mutex[i]) == 0){
	                printf("Buyer %d takes car %d.\n", id, i + 1);
	                used_cars[i] = 1;
	                sleep(1);
	                pthread_mutex_unlock(&mutex[i]);
	                printf("Buyer %d returns car %d.\n", id, i + 1);
	            }
	        }
        }
        // check
        int found = 0;
        for(int i = 0;i < 5;i ++){
            if(used_cars[i] == 1){
                found ++;
            }
        }
        if(found == 5){
            break;
        }
	}	
		
	return NULL;
}

int main() {
    
	pthread_t threads[NUM_OF_THREADS];
	
	for(int i=0;i < 5;i++){
	    pthread_mutex_init(&mutex[i],NULL);
    }
    
    for (int i = 0; i < 20;i ++){
	    pthread_create(&threads[i],NULL,drivers,&i);
	}

	for(int i = 0; i< 20; i ++){ 
		pthread_join(threads[i],NULL);
	}
	
	for(int i=0;i < 5;i++){
	    pthread_mutex_destroy(&mutex[i]);
	}
	
}
