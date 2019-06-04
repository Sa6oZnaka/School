//--------------------------------------------
// NAME: Alexandar Karapenev
// CLASS: XIb
// NUMBER: 1
// PROBLEM: #5
// FILE NAME: main.c
// FILE PURPOSE:
// Implementation of the UNIX shell
//---------------------------------------------

#include<sys/types.h>
#include<sys/wait.h>
#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include<time.h>
#include<stdlib.h>

int precessesCount = 0;

// TODO
char** getCommands(const char* cmdline){

    char **result = malloc(100 * sizeof(char*));
    for (int i =0 ; i < 100; ++i){
        result[i] = malloc(100 * sizeof(char));
    }
    int elem=0;
    int last=0;
    char *temp = malloc(20*sizeof(char*));

    for(int i = 0;i < strlen(cmdline);i ++) {
        if (cmdline[i] == ' ' || strlen(cmdline) - 1 == i) {
            int index = 0;
            if (last > 0)last++;
            for (int j = last; j < i; j++) {
                temp[index] = cmdline[j];
                index++;
            }
            temp[index] = '\0';
            last = i;
            strcpy(result[elem], temp);

            elem++;
        }
    }

    result[elem] = NULL;
    return result;
}

char** getProcesses(char* line){

    // TODO
    char** result = malloc(100 * sizeof(char*));
    for (int i = 0 ; i < 100; ++i){
        result[i] = malloc(100 * sizeof(char));
    }

    int index = 0;
    const char s[2] = "|";
    char *token;

    token = strtok(line, s);
    while( token != NULL ) {
        strcpy(result[index], token);
        index ++;

        token = strtok(NULL, s);
    }

    precessesCount = index;
    return result;
}

int main(int argc, char*argv[]) {
    char line[100];

    while(1){
        printf("$ ");
        fgets(line,100,stdin);

        char** precesses = getProcesses(line);

        for(int i = 0; i < precessesCount; i ++) {
            char **commands = getCommands(precesses[i]);

            // Ctrl + D
            if (feof(stdin)) {
                break;
            }

            pid_t pid = fork();
            if (pid < 0) {
                perror("fork");
                return -1;
            } else if (pid == 0) {
                if (execv(commands[0], commands) < 0) {
                    perror(commands[0]);
                    return -1;
                }
                return 0;
            } else {
                int rstatus;
                if (waitpid(pid, &rstatus, 0) < 0) {
                    perror("waitpid");
                    return -1;
                }
            }
        }
    }

    return 0;
}

