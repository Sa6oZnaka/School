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
#define MINERAL_BLOCK 10

int MyMinerals = 0;
pthread_mutex_t mutex[MINERAL_BLOCK];
int minerals[MINERAL_BLOCK];

void* miner(void *arg){
    
    int id = *((int *)arg);
    int blocks[MINERAL_BLOCK];
    for(int i = 0;i < MINERAL_BLOCK;i++){
        blocks[i] = 1;
    }
    // 0 - empty
    // 1 - contains gems

    while(1){
	    for(int i = 0;i < 5;i ++){	
	        if(blocks[i] == 1){ // if it contains minerals
	            if(pthread_mutex_trylock(&mutex[i]) == 0){
	                sleep(3);
	                printf("Miner %d is mining %d.\n", id, i + 1);
	                if(minerals[i] == 0)
	                    blocks[i] = 0;
	                sleep(1);
	                pthread_mutex_unlock(&mutex[i]);
	                printf("Miner %d Delivered %d.\n", id, i + 1);
	                MyMinerals += 20;
	                printf("GOLD %d \n", MyMinerals);
	                minerals[i] -= 20;
	            }
	        }
        }
        // check
        int found = 0;
        for(int i = 0;i < 5;i ++){
            if(blocks[i] == 1){
                found ++;
            }
        }
        if(found == MINERAL_BLOCK){
            break;
        }
	}	
		
	return NULL;
}

int main() {
    
    for(int i = 0;i < NUM_OF_THREADS;i ++){
        minerals[i] = 500;
    }
    
	pthread_t threads[NUM_OF_THREADS];
	
	for(int i=0;i < 5;i++){
	    pthread_mutex_init(&mutex[i],NULL);
    }
    
    for (int i = 0; i < 20;i ++){
	    pthread_create(&threads[i],NULL,miner,&i);
	}

	for(int i = 0; i< 20; i ++){ 
		pthread_join(threads[i],NULL);
	}
	
	for(int i=0;i < 5;i++){
	    pthread_mutex_destroy(&mutex[i]);
	}
	
}
