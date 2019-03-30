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

#define NUM_OF_THREADS 5
#define MINERAL_BLOCK 2

int MyMinerals = 0;
int Soldiers = 0;

pthread_mutex_t mutex[MINERAL_BLOCK];
int minerals[MINERAL_BLOCK];

pthread_mutex_t command_center;

void* miner(void *arg){
    
    int id = *((int *)arg);
    int blocks[MINERAL_BLOCK];
    for(int i = 0;i < MINERAL_BLOCK;i++){
        blocks[i] = 1;
    }
    // 0 - empty
    // 1 - contains gems
	
	printf("THREAD CREATED ID %d \n", id);	
	
    while(1){
	    for(int i = 0;i < MINERAL_BLOCK;i ++){	
	        if(blocks[i] == 1){ // if it contains minerals
	        	sleep(3);
	            if(pthread_mutex_trylock(&mutex[i]) == 0){
	            	if(minerals[i] == 0){
	                    blocks[i] = 0;
	                }else{ 
			            printf("SCV %d is mining from mineral block %d\n", id, i + 1);
			            pthread_mutex_unlock(&mutex[i]);
			            
			            printf("SCV %d is transporting minerals\n", id);
			            sleep(2);
			            
			            // deliver the minerals
						int delivered = 0;
						while(delivered != 1){
						
					        if(pthread_mutex_trylock(&command_center) == 0){
					        	sleep(1);
					        	//printf("M LOCK ------------------\n");
							    if(minerals[i] < 8){
							    	MyMinerals += minerals[i];
							    	minerals[i] = 0; 
							    }else{
							    	MyMinerals += 8;
							    	minerals[i] -= 8;
							    }
							    printf("SCV %d delivered minerals to the Command center\n", id);
							    //printf("M UNLOCK ================\n");
							    pthread_mutex_unlock(&command_center);
							    delivered = 1;
							}    
	  					}
			        }    
	            }
	        }
        }
        
	}	
		
	return NULL;
}

int main( int argc, char * argv [] ) {
    
    printf("ARGUMENT (BLCOKS) - %s \n \n", argv[1]);
    
    for(int i = 0;i < MINERAL_BLOCK;i ++){
        minerals[i] = 500;
    }
    
	pthread_t threads[NUM_OF_THREADS];
	
	for(int i=0;i < MINERAL_BLOCK;i++){
	    pthread_mutex_init(&mutex[i],NULL);
    }
    
    for (int i = 0; i < NUM_OF_THREADS;i ++){
    	printf("%p %d \n", &i, i);
	    pthread_create(&threads[i],NULL,miner,&i);
	    sleep(1);
	}

	for(int i = 0; i< NUM_OF_THREADS; i ++){ 
		pthread_join(threads[i],NULL);
	}
	
	for(int i=0;i < MINERAL_BLOCK;i++){
	    pthread_mutex_destroy(&mutex[i]);
	}
	
}
