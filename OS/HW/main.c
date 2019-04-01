//--------------------------------------------
// NAME: Alexandar Karapenev
// CLASS: XIb
// NUMBER: 1
// PROBLEM: #3
// FILE NAME: main.c
// FILE PURPOSE: 
// Starcraft 3 prototype using threads
// The goal is to buy 20 seldiers and mine all
// of the blocks using your miners                       
//---------------------------------------------

#include<unistd.h>
#include<pthread.h>
#include<math.h>
#include<stdlib.h>
#include<stdio.h>

#define MAX_MINERALS 10000
#define MAX_THREADS 1000
#define BLOCK_REWARD 500
#define WORKER_PAYOUT 8

pthread_mutex_t mutex[MAX_MINERALS];
pthread_mutex_t command_center;
pthread_mutex_t miners_learning;
pthread_mutex_t soldiers_learning;

int Mineral_Blocks_Count;
int minerals[MAX_MINERALS];

int MyMinerals = 0;
int Soldiers = 0;
int Miners = 5;

pthread_t threads[MAX_THREADS];

int br = 0;
int sol = 0;

//--------------------------------------------
// FUNCTION: miner
// Workers (threads) they are mining minerals from blocks (mutex)
// PARAMETERS:
// none
//----------------------------------------------
void* miner(void *arg){
    
    int id = *((int *)arg) - 1;
    
    int blocks[Mineral_Blocks_Count];
    for(int i = 0;i < Mineral_Blocks_Count;i++){
        blocks[i] = 1;
    }
	
    while(1){
    	
    	if(br == 1 && sol == 1) break;
    	
	    for(int i = 0;i < Mineral_Blocks_Count;i ++){		
			
	    	int e = 0;
	    	for(int j = 0;j < Mineral_Blocks_Count;j ++){
				if(minerals[j] == 0){
					e++;	
				}
	    	}
	    	if(e == Mineral_Blocks_Count){
				br = 1;
				break;		
			}
	    	
	        if(blocks[i] == 1){ // if it contains minerals
	        	sleep(3);
	            if(pthread_mutex_trylock(&mutex[i]) == 0){

	            	if(minerals[i] == 0){
	                    blocks[i] = 0;
	                    continue;
	                }else{ 
	        
			            printf("SCV %d is mining from mineral block %d\n", id, (i+1));
			            
			            int reward = 0;
			            if(minerals[i] < WORKER_PAYOUT){
							reward += minerals[i];
							minerals[i] = 0;
							blocks[i] = 0; 
				  
						}else{
							minerals[i] -= WORKER_PAYOUT;
							reward += WORKER_PAYOUT;
						}
			         	
			         	pthread_mutex_unlock(&mutex[i]);
			         	
			            printf("SCV %d is transporting minerals\n", id);
			            
			            sleep(2);
			            
						int delivered = 0;
						while(delivered != 1){
							
					        if(pthread_mutex_trylock(&command_center) == 0){
					        	
							    MyMinerals += reward;
							    
							    printf("SCV %d delivered minerals to the Command center\n", id);

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

//--------------------------------------------
// FUNCTION: main
// Input and thrad creation/join
// PARAMETERS:
// argc - num of arguments
// argv - arguments 
//----------------------------------------------
int main( int argc, char * argv [] ) {
    
    
    // BLOCKS //
    if(argc > 1){
    	Mineral_Blocks_Count = atoi(argv[1]);
    }else{
    	Mineral_Blocks_Count = 2;
    }
    ////////////
    
    for(int i = 0;i < Mineral_Blocks_Count;i ++){
        minerals[i] = BLOCK_REWARD;
    }
	
	
	for(int i=0;i < Mineral_Blocks_Count;i++){
	    pthread_mutex_init(&mutex[i],NULL);
    }
    
    // thread creation
    for (int i = 0; i < Miners;i ++){
    	int tmp = i+1;
	    pthread_create(&threads[i],NULL,miner,&tmp);
	}
	
	while(1){
	
		if(Soldiers >= 20) sol = 1;
	
		if(br == 1 && sol == 1) break;

		char input;
		scanf("%c", &input);
		
		if(br == 1 && sol == 1) break;	
		
		if(Miners + Soldiers < 200){
			if(input == 'm'){
				if(MyMinerals >= 50){
					
					//pthread_mutex_lock(&soldiers_learning);	
					
					sleep(1);
					MyMinerals -= 50;
					printf("You wanna piece of me, boy?\n");
					Soldiers++;
					
					//pthread_mutex_unlock(&soldiers_learning);
					
				}else{
					printf("Not enough minerals.\n");
				}
				
			}

			if(input == 's'){
				if(MyMinerals >= 50){
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
		
	}
	
	for(int i = 0; i < Miners; i ++){ 
		pthread_join(threads[i], NULL);
	}
	
	for(int i=0;i < Mineral_Blocks_Count;i++){
	    pthread_mutex_destroy(&mutex[i]);
	}
	
	int N = BLOCK_REWARD * Mineral_Blocks_Count;
	            
	printf("Map minerals %d, player minerals %d, SCVs %d, Marines %d\n", N, MyMinerals, Miners, Soldiers);
	
	return 0;
}

