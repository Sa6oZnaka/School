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

#define MAX_MINERALS 10000
#define MAX_THREADS 10000

pthread_mutex_t mutex[MAX_MINERALS];
pthread_mutex_t command_center;
pthread_mutex_t miners_learning;

int Mineral_Blocks_Count;
int minerals[MAX_MINERALS];

int MyMinerals = 0;
int Soldiers = 0;
int Miners = 5;

pthread_t threads[MAX_THREADS];

void* miner(void *arg){
    
    int id = *((int *)arg) - 1;
    int blocks[Mineral_Blocks_Count];
    for(int i = 0;i < Mineral_Blocks_Count;i++){
        blocks[i] = 1;
    }
    // 0 - empty
    // 1 - contains gems
	
	//printf("THREAD CREATED ID %d \n", id);	
	
    while(1){
    	if(Soldiers >= 20) break;
	    for(int i = 0;i < Mineral_Blocks_Count;i ++){
	    	if(Soldiers >= 20) break;	
	        if(blocks[i] == 1){ // if it contains minerals
	        	sleep(3);
	            if(pthread_mutex_trylock(&mutex[i]) == 0){
	            	if(minerals[i] == 0){
	                    blocks[i] = 0;
	                }else{ 
			            printf("SCV %d is mining from mineral block %d\n", id, i + 1);
			            pthread_mutex_unlock(&mutex[i]);
			            
			            printf("SCV %d is transporting minerals\n", id);
			            //sleep(2);
			            
			            // deliver the minerals
						int delivered = 0;
						while(delivered != 1){
						
					        if(pthread_mutex_trylock(&command_center) == 0){
					        	sleep(2);
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

void *user_commands(void *arg){

	while(1){
		char input;
		scanf("%c", &input);
		if(Soldiers >= 20) break;
		if(input == 'm'){
			if(MyMinerals > 50){
				sleep(1);
				MyMinerals -= 50;
				printf("You wanna piece of me, boy?\n");
				Soldiers++;
			}else{
				printf("Not enough minerals.\n");
			}
			//printf("SOLDIERS: %d", Soldiers);
			
		}
		if(input == 's'){
			if(MyMinerals > 50){
				pthread_mutex_lock(&miners_learning); // LOCK MUTEX
				MyMinerals -= 50;
				sleep(4);
				printf("SCV good to go, sir.\n");
				Miners++;
				pthread_create(&threads[Miners],NULL,miner,&Miners);
				pthread_mutex_unlock(&miners_learning); // UNLOCK
			}else{
				printf("Not enough minerals.\n");
			}	
		}
		
	}

	return NULL;
}


int main( int argc, char * argv [] ) {
    
    
    // BLOCKS //
    if(argc > 1){
    	Mineral_Blocks_Count = atoi(argv[1]);
    }else{
    	Mineral_Blocks_Count = 2;
    }
    //printf("ARGUMENT (BLOCKS) - %d \n \n", Mineral_Blocks_Count);
    ///////////
    
    pthread_create(&threads[0],NULL,user_commands,NULL);
    
    for(int i = 0;i < Mineral_Blocks_Count;i ++){
        minerals[i] = 500;
    }
	
	for(int i=0;i < Mineral_Blocks_Count;i++){
	    pthread_mutex_init(&mutex[i],NULL);
    }
    
    for (int i = 1; i <= Miners;i ++){
    	printf("%p %d \n", &i, i);
	    pthread_create(&threads[i],NULL,miner,&i);
	    //sleep(1);
	}

	
	for(int i = 0; i<= Miners; i ++){ 
		pthread_join(threads[i],NULL);
	}
	
	for(int i=0;i < Mineral_Blocks_Count;i++){
	    pthread_mutex_destroy(&mutex[i]);
	}
	
}
