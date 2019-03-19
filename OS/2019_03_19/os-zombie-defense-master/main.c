#include "ui.h"
#include<unistd.h>
#include<pthread.h>
#include<math.h>
#include<stdlib.h>
#include<stdio.h>

#define NUM_OF_THREADS 1000

int gold = 100;
int zombies_count = 1;
int soldiers_count = 15;
int heal = 100;
pthread_mutex_t mutex;

void* miners(void *arg){

	while(1) {
		pthread_mutex_lock(&mutex);
		gold += 10;
		print_gold(gold);
		pthread_mutex_unlock(&mutex);

		sleep(1);
	}
	return NULL;
}

void* zombies(void *arg){
	while(1){
		for(int i = 5;i > 0;i --){
	    	print_zombies(i, zombies_count);
	    	sleep(1);
	    }
		if(zombies_count > soldiers_count){
			pthread_mutex_lock(&mutex);
		    
		    heal -= (zombies_count - soldiers_count);
		    print_fail("Zombie attack succeded ;(!");
		    if(heal <= 0){
		    	game_end(zombies_count);
		    }
		    print_health(heal);

		    pthread_mutex_unlock(&mutex);
		}else{
		    print_succ("Zombie attack deflected! :)");
		}
		zombies_count *= 2;
	}
	return NULL;
}


int main() {

	int last = 0;

	pthread_t threads[NUM_OF_THREADS];
	pthread_mutex_init(&mutex,NULL);

	init();
	print_gold(gold);
	print_soldiers(soldiers_count);
	//print_zombies(5, 13);
	print_health(heal);

	pthread_create(&threads[last],NULL,zombies,NULL);

	while(1) {
		int ch = get_input();
		switch(ch) {
			case 'q':
				game_end(zombies_count);
				break;
			case 'm':
				if(gold >= 100){
					gold -= 100;
					print_gold(gold);

					pthread_create(&threads[last],NULL,miners,NULL);
					last ++;

					print_msg("Miner created!");

				}else{
					print_fail("Not enough gold!");
				}

				break;
			case 's':
				if(gold >= 10){
					gold -= 10;
					soldiers_count++;
					print_gold(gold);
					print_msg("Soldier created!");
					print_soldiers(soldiers_count);
				}else{
					print_fail("Not enough gold!");
				}
				break;
			case 'x':
				if(gold >= 100){
					gold -= 100;
					soldiers_count += 10;
					print_gold(gold);
					print_msg("10 x soldiers created!");
					print_soldiers(soldiers_count);
				}else{
					print_fail("Not enough gold!");
				}
				break;
		}
	}

	for(int i=0; i< last + 1; i++){ // + 1 for the zombies
		pthread_join(threads[i],NULL);
	}
	pthread_mutex_destroy(&mutex);
}
