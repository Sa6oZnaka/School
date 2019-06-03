//--------------------------------------------
// NAME: Alexandar Karapenev
// CLASS: XIb
// NUMBER: 1
// PROBLEM: #5
// FILE NAME: main.c
// FILE PURPOSE:
// Implementation of the UNIX shell
//---------------------------------------------

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <stdbool.h>

#define CAPACITY 100;

char **processCommand(char *cmdline){
    int capacity = CAPACITY;
    char **arr = malloc(capacity * sizeof(char*));

    for(int i = 0; i < capacity; ++i){
        arr[i] = malloc(capacity * sizeof(char));
    }

    char string[500];
    strcpy(string, cmdline);

    int position = 0;

    char *q = strtok(string," \n");
    while(q != NULL){

        /* reallocate */
        int length = strlen(q);
        if(position == (capacity - 1)|| capacity <= length){
            capacity *= 2;
            arr = realloc(arr, sizeof(char*) * capacity);
            for(int i = 0 ; i < capacity; i++)
                arr[i] = realloc(arr[i], sizeof(char) * capacity);
        }

        strcpy(arr[position++], q);

        q = strtok(NULL, " \n");
    }
    arr[position] = NULL;
    return arr;
}

int main(int argc, char const *argv[]){

    size_t bufsize = CAPACITY;

    char *line = (char *)malloc(bufsize * sizeof(char));
    char **commands = NULL;

    while(true){

        write(STDOUT_FILENO, "$ ", 2);
        size_t resultSize = getline(&line,&bufsize,stdin);
        if(resultSize == -1){
            free(commands);
            break;
        }

        commands = processCommand(line);

        if(fork() < 0){
            perror("fork");
            return -1;
        }

        execv(commands[0], commands);

    }

    return 0;
}

// /bin/ls -l /usr/include
