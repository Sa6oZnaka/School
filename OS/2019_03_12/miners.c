//--------------------------------------------
// NAME: Alexndar Karapenev
// CLASS: XI b
// NUMBER: 1
// PROBLEM: #2
//---------------------------------------------

#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<math.h>
#include<unistd.h>
#define NUM_OF_THREADS 2

int gold = 0;

pthread_mutex_t mutex; 

void* miner(void* arg) {

    for(int i = 0; i < 20;) {      
        pthread_mutex_lock(&mutex);
        if(gold == 0){
            gold += 10;
            printf("Miner 1 gathered 10 gold\n");
            sleep(2);
            i++;
        }
        pthread_mutex_unlock(&mutex);
    }

    return NULL;
}
void* trader(void* arg) {
    
    for(int i = 0; i < 20;) {
        pthread_mutex_lock(&mutex);
        if(gold >= 10){
            gold -= 10;
            printf("Trader 1 sold 10 gold\n");
            i++;      
        }else{
            //printf("The warehouse is empty, cannot sell!\n");
        }    
        pthread_mutex_unlock(&mutex);  
        
    }
    
    return NULL;
}


int main() {

    pthread_t threads[NUM_OF_THREADS];

    pthread_mutex_init(&mutex, NULL);

    pthread_create(&threads[0],NULL,miner,NULL);
    pthread_create(&threads[1],NULL,trader,NULL);

    pthread_join(threads[0],NULL);
    pthread_join(threads[1],NULL);

    printf("Gold: %d\n", gold);

    pthread_mutex_destroy(&mutex);

    return 0;
}
