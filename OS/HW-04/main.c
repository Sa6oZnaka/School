// TODO LS
// 1. Da formatiram data i chas
// 2. ima razlichni argumenti
// -a mnoje da go napishem sled mnogo spaecove (-a, -l , -la)
// mojem da imame mnogo kombinacii ot komandi
// ls -a -l = ls -la
// getopt - trqbda se se izpolzva za argumentite tq kazva kakvi argumenti ima za tazi zadacha
// no ne pishat po niska otcenka prosto moje da izpusna neshto i shte go
// prava 10 minuti poveche
// -a - skriti failove
// -l - dopulnitelni danni
// da pusna root directorqta s -a
// ne trqbva da sortirama
// mnogo da vnimavam s rekursivnoto izvikvane che se stiga do bezkraen cigul!


#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <pwd.h>
#include <dirent.h>
#include <stdbool.h>

bool use_a = false;
bool use_l = false;
bool use_R = false;


void ReadDir(char arg[]){
    printf("Hello, World!\n");

    struct dirent *direntbuff;
    DIR* dir = opendir(arg);
    if(dir == NULL){
        perror("opendir");
        return;
    }

    direntbuff = readdir(dir);

    while(direntbuff != NULL){
        printf("%s\n", direntbuff -> d_name);
        direntbuff = readdir(dir);
    }

    if(closedir(dir) == -1){
        perror("closedir");
        return;
    }

}

int main(int argc, char **argv) {


    printf("Hello, World!\n");

    char command = getopt(argc, argv, "alR");
    while(command != -1){

        if(command == 'a'){
            use_a = true;
        }else if(command == 'l'){
            use_l = true;
        }else if(command == 'R'){
            use_R = true;
        }
        command = getopt(argc, argv, "alR");
    }

    printf("USE_A %d \n", use_a);
    printf("USE_L %d \n", use_l);
    printf("USE_R %d \n", use_R);


    printf("\n");

    ReadDir(argv[1]);


    return 0;
}