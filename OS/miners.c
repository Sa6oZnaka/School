#include<stdio.h>
#include<unistd.h>
#include<pthread.h>
#include<math.h>
#include<stdlib.h>
#define NUM_OF_THREADS 10
#define SIZE 1000000

int gold =0;
pthread_mutex_t mutex;

void* miners(void *arg){
	int num = *((int*)arg);
	for(int i=1; i<21;i++){
		pthread_mutex_lock(&mutex);
		gold+=10;
		pthread_mutex_unlock(&mutex);
		printf("Miner %d gathered 10 gold\n",num);
		sleep(2);
	}
	return NULL;
}

void* traders(void *arg){
	int num = *((int*)arg);
	for(int i=1;i<21;){
		pthread_mutex_lock(&mutex);
		if(gold >= 10){
			gold-=10;
			printf("Trader %d sold 10 gold\n",num);
			i++;
			sleep(2);
		}
		else printf("The warehouse is empty, cannot sell!\n");
		
		//while(gold < 0)printf("nema zlato\n");
		pthread_mutex_unlock(&mutex);
		
	}
	return NULL;
}

int main(int argc, char**argv){
	int miners_count = atoi(argv[1]);
	int traders_count = atoi(argv[2]);
	int last = 0;
	pthread_t threads[NUM_OF_THREADS];
	pthread_mutex_init(&mutex,NULL);
	for(int i=1; i< miners_count;i++){
		pthread_create(&threads[i], NULL, miners, &i);
		last = i;
	}
	
	for(int i=last; i< traders_count;i++){
		int index = i - last;
		pthread_create(&threads[i],NULL,traders,&last);
	}
	
	for(int i=0; i< (traders_count + miners_count); i++){
		printf("4istq\n");
		pthread_join(threads[i],NULL);
	}
	
	
	printf("Gold: %d\n",gold);
	pthread_mutex_destroy(&mutex);
	return 0;
}
