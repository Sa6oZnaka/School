//
// Created by alex on 14.05.19.
//

#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <pwd.h>
#include <dirent.h>


int main(int arcg, char **argv) {
    printf("Hello, World!\n");

    struct dirent *direntbuff;
    DIR* dir = opendir(argv[1]);
    if(dir == NULL){
        perror("opendir");
        return 1;
    }

    direntbuff = readdir(dir);

    while(direntbuff != NULL){
        printf("%s\n", direntbuff -> d_name);
        direntbuff = readdir(dir);
    }

    if(closedir(dir) == -1){
        perror("closedir");
        return 1;
    }

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




    return 0;
}
