#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <pwd.h>

int main(int arcg, char **argv) {
    printf("Hello, World!\n");

    struct stat statbuff;
    if(stat(argv[1], &statbuff) == 1){
        perror("Stat");
        return 1;
    }

    printf("%s size %ld", argv[1], statbuff.st_size);

    struct passwd *passwdbuffer = getpwuid(statbuff.st_uid);
    if(passwdbuffer == NULL){
        perror("getpwuid");
        return 1;
    }

    printf("%s\n", passwdbuffer->pw_name);


    return 0;
}