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


void getType(mode_t mode) {
    if(mode == DT_DIR) printf("%c", 'd');  // directory
    if(mode == DT_LNK) printf("%c", 'l');  // symbolic link
    if(mode == DT_REG) printf("%c", '-');  // regular file
    if(mode == DT_BLK) printf("%c", 'b');  // block device
    if(mode == DT_SOCK) printf("%c", 's'); // socket
    if(mode == DT_FIFO) printf("%c", 'p'); // pipe
}

void getPermissions(mode_t mode){
    printf( (S_ISDIR(mode)) ? "d" : "-");
    printf( (mode & S_IRUSR) ? "r" : "-");
    printf( (mode & S_IWUSR) ? "w" : "-");
    printf( (mode & S_IXUSR) ? "x" : "-");
    printf( (mode & S_IRGRP) ? "r" : "-");
    printf( (mode & S_IWGRP) ? "w" : "-");
    printf( (mode & S_IXGRP) ? "x" : "-");
    printf( (mode & S_IROTH) ? "r" : "-");
    printf( (mode & S_IWOTH) ? "w" : "-");
    printf( (mode & S_IXOTH) ? "x" : "-");
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

            if(! use_l) {
                getType(direntbuff->d_type);
                printf(" ");
            } else {
                // Show permission
                struct stat fileStat;
                if (stat(direntbuff->d_name, &fileStat) < 0)
                    return false;
                getPermissions(fileStat.st_mode);
            }

            printf(" %s\n", direntbuff->d_name);
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

    printf("LS V3!\n");

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

    printf("USE_a %d \n", use_a);
    printf("USE_l %d \n", use_l);
    printf("USE_R %d \n", use_R);

    printf("\n");

    //ReadDir(argv[1]);
    ReadDir(".");


    return 0;
}