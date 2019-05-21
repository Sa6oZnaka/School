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


void getType(struct dirent *direntbuff) {
    if(direntbuff -> d_type == DT_DIR) printf("%s", "d"); // directory
    if(direntbuff -> d_type == DT_SOCK) printf("%s", "s"); // socket
    if(direntbuff -> d_type == DT_LNK) printf("%s", "l"); // symbolic link
    if(direntbuff -> d_type == DT_REG) printf("%s", "-"); // regular file
    if(direntbuff -> d_type == DT_BLK) printf("%s", "b"); // block device
    if(direntbuff -> d_type == DT_FIFO) printf("%s", "p"); // pipe
}

bool ReadDir(char arg[]){

    struct dirent *direntbuff;
    DIR* dir = opendir(arg);
    if(dir == NULL){
        perror("opendir");
        return false;
    }

    direntbuff = readdir(dir);

    while(direntbuff != NULL){

        if(direntbuff -> d_name[0] != '.' || use_a) {
            getType(direntbuff);
            printf(" %s\n", direntbuff->d_name); // name
        }
        direntbuff = readdir(dir);
    }

    if(closedir(dir) == -1){
        perror("closedir");
        return false;
    }

    printf("Sucesss!\n");
    return true;
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

    //ReadDir(argv[1]);
    ReadDir(".");


    return 0;
}