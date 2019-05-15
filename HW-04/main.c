#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <pwd.h>
#include <dirent.h>

int main(int argc, char **argv) {
    printf("Hello, World!\n");

    char c = getopt(argc, argv, "la");
    while(c != -1){
        printf("%c", c);
        c = getopt(argc, argv, "la");
    }
    printf("\n");

    printf("FILES %s", *argv);
    ////////////////////////////

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


    return 0;
}
