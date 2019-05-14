//
// Created by alex on 14.05.19.
//


#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <pwd.h>
#include <dirent.h>


int main(int argc, char **argv) {
    printf("Hello, World!\n");

    char c = getopt(argc, argv, "abcd");
    while(c != -1){
        printf("%c", c);
        c = getopt(argc, argv, "abcd");
    }
    printf("\n");

    return 0;
}
