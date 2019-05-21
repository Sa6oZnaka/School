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
#include <grp.h>
#include <time.h>

bool use_a = false;
bool use_l = false;
bool use_R = false;

// show file type - used for -l
void showType(mode_t mode) {
    if(mode == DT_DIR) printf("%c", 'd');  // directory
    if(mode == DT_LNK) printf("%c", 'l');  // symbolic link
    if(mode == DT_REG) printf("%c", '-');  // regular file
    if(mode == DT_BLK) printf("%c", 'b');  // block device
    if(mode == DT_SOCK) printf("%c", 's'); // socket
    if(mode == DT_FIFO) printf("%c", 'p'); // pipe
}

// show permission - used for -l
void showPermissions(mode_t mode){
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

// get total (block) - used for -l
long getTotal(char arg[]){
    int total = 0;

    struct dirent *direntbuff;
    DIR* dir = opendir(arg);
    if(dir == NULL){
        perror("opendir");
        return -1;
    }

    direntbuff = readdir(dir);

    while (direntbuff != NULL){
        struct stat fileStat;
        if (stat(direntbuff -> d_name, &fileStat) < 0){
            perror("stat");
            return false;
        }
        if(direntbuff -> d_name[0] != '.' || use_a) {
            total += fileStat.st_blocks;
        }

        direntbuff = readdir(dir);
    }

    if(closedir(dir) == -1){
        perror("closedir");
        return -1;
    }

    return total / 2;
}

// show files from the directory
bool ReadDir(char arg[]){

    struct dirent *direntbuff;
    DIR* dir = opendir(arg);
    if(dir == NULL){
        perror("opendir");
        return false;
    }

    direntbuff = readdir(dir);

    if(use_l) {
        printf("total: %ld\n", getTotal(arg));
    }

    while(direntbuff != NULL){

        if(direntbuff -> d_name[0] != '.' || use_a) {

            showType(direntbuff -> d_type);

            if(use_l) {
                struct stat fileStat;
                if (stat(direntbuff->d_name, &fileStat) < 0){
                    perror("stat");
                    return false;
                }

                showPermissions(fileStat.st_mode);
                printf(" %ld" ,fileStat.st_nlink);
                printf(" %s" ,getpwuid(fileStat.st_uid)->pw_name);
                printf(" %s", getgrgid(fileStat.st_gid)->gr_name);
                printf(" %8ld" ,fileStat.st_size);

                struct tm *tm;
                char buf[200];
                tm = localtime((const time_t *) &fileStat.st_mtim);
                strftime(buf, sizeof(buf), " %b %d %H:%M", tm);
                printf("%s", buf);

            }
            printf(" %s\n", direntbuff -> d_name);

        }
        direntbuff = readdir(dir);
    }

    if(closedir(dir) == -1){
        perror("closedir");
        return false;
    }

    return true;
}

// check is argument is file or directory
bool isDir(char arg[]){
    DIR* dir = opendir(arg);
    if(dir == NULL){
        return false;
    }
    if(closedir(dir) == -1){
        perror("closedir");
        return false;
    }
    return true;
}

// execute the arguments
void executeArguments(int argc, char* argv[]){

    for (int i = optind; i < argc; ++i){
        if (isDir(argv[i])){
            if(argc > 2){
                printf("\n%s", argv[i]);
            }
            ReadDir(argv[i]);
            continue;
        }else{
            printf("- %s\n", argv[i]);
            continue;
        }
    }
}

int main(int argc, char *argv[]) {

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
    executeArguments(argc, argv);
    //ReadDir(".");

    return 0;
}