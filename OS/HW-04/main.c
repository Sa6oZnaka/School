#include <sys/stat.h>
#include <sys/types.h>
#include <dirent.h>
#include <getopt.h>
#include <grp.h>
#include <pwd.h>
#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include <sysexits.h>
#include <time.h>
#include <unistd.h>
#include <dirent.h>

#define BUFSIZE 1024

bool using_a = false;
bool using_d = false;
bool using_l = false;
bool using_R = false;
bool using_g = false;
bool using_h = false;
bool using_o = false;
bool using_q = false;
bool using_p = false;

struct Options get_options(int count, char* args[]);


void ShowPermissions(mode_t mode){
    putchar((mode & S_IRUSR) ? 'r' : '-');
    putchar((mode & S_IWUSR) ? 'w' : '-');
    putchar((mode & S_IXUSR) ? 'x' : '-');
    putchar((mode & S_IRGRP) ? 'r' : '-');
    putchar((mode & S_IWGRP) ? 'w' : '-');
    putchar((mode & S_IXGRP) ? 'x' : '-');
    putchar((mode & S_IROTH) ? 'r' : '-');
    putchar((mode & S_IWOTH) ? 'w' : '-');
    putchar((mode & S_IXOTH) ? 'x' : '-');
}

void ShowFiletype(mode_t mode){

    switch (mode & S_IFMT){
        case S_IFREG:  putchar('-'); break;
        case S_IFDIR:  putchar('d'); break;
        case S_IFLNK:  putchar('l'); break;
        case S_IFCHR:  putchar('c'); break;
        case S_IFBLK:  putchar('b'); break;
        case S_IFSOCK: putchar('s'); break;
        case S_IFIFO:  putchar('p'); break;
    }
}

void ShowFilesize(off_t size){

    const char* units[] = { "", "K", "M", "G", "T"};
    int i;

    for (int i = 0; size > 1024; ++i, size /= 1024);

    char FilesizeBuf[1024];

    snprintf(FilesizeBuf, sizeof(FilesizeBuf), "%*jd%s ", i, (intmax_t)size, units[i]);
    printf(" %8s", FilesizeBuf);

}

void GetOptions(int argc, char* argv[]){

    int command;
    while ((command = getopt(argc, argv, "AalRgoqh")) != -1){

        if(command == 'a' || command == 'A')
            using_a = true;
        else if(command == 'l')
            using_l = true;
        else if(command == 'R')
            using_R = true;
        else if(command == 'g')
            using_g = true;
        else if(command == 'o')
            using_o = true;
        else if(command == 'q')
            using_q = true;
        else if(command == 'h')
            using_h = true;

    }
}

struct stat GetStats(const char* filename, const char* dir){

    char PathBuf[BUFSIZE];

    const int WrittenBytes = snprintf(PathBuf, sizeof(PathBuf), "%s/%s", dir, filename);

    if(WrittenBytes <= 0){
        exit(EX_IOERR);
    }

    struct stat CurrentStatus;

    if(lstat(PathBuf, &CurrentStatus) < 0){
        perror(PathBuf);
        exit(EX_IOERR);
    }

    return CurrentStatus;
}

void ShowTime(time_t timeMode){
    // get current time with year
    time_t CurrentTime;
    time(&CurrentTime);
    struct tm* myTime = localtime(&CurrentTime);
    const int CurrentMonth = myTime->tm_mon;
    const int CurrentYear = 1970 + myTime->tm_year;

    // get modified time and year
    myTime = localtime(&timeMode);
    const int ModifiedMonth = myTime->tm_mon;
    const int ModifiedYear = 1970 + myTime->tm_year;

    // determine format based on modification time
    // (past six months)
    const char* format = (ModifiedYear == CurrentYear) && (ModifiedMonth >= (CurrentMonth - 6)) ? "%b %e %H:%M" : "%b %e  %Y";

    char TimeBuf[BUFSIZE];

    const size_t WrittenBytes = strftime(TimeBuf, sizeof(TimeBuf), format, myTime);

    if (WrittenBytes <= 0)exit(-1);
    printf("%s", TimeBuf);
}

int IsDir(const char* filename){
    struct stat Stat = GetStats(filename, ".");

    if(lstat(filename, &Stat) < 0){
        perror(filename);
        exit(EX_IOERR);
    }

    return Stat.st_mode & S_IFDIR;
}

void ShowName(const char* filename){

    if (using_q){
        printf(" \"%s\"", filename);
    }else{
        printf(" %s", filename);
    }

    if (using_p && IsDir(filename)){
        putchar('/');
    }

    putchar('\n');
}

void StructureDirEntries(DIR* dir, char** entries, size_t* entries_count){

    struct dirent* index = readdir(dir);
    *entries_count = 0;

    while (index){

        const bool omit_hidden = ! using_a && index->d_name[0] == '.';

        if (!omit_hidden){

            if (*entries_count >= BUFSIZE){

                entries = realloc(entries, sizeof(entries) * BUFSIZE);
                if (!entries){

                    perror("realloc");
                    abort();
                }
            }
            entries[*entries_count] = index -> d_name;
            ++(*entries_count);
        }
        index = readdir(dir);
    }
}

bool IsInDir(const char* dir, const char* filename){
    DIR* d = opendir(dir);

    if(!d){
        perror(dir);
        exit(EX_IOERR);
    }

    struct dirent* dirp = readdir(d);
    while(dirp){
        if(strcmp(filename, dirp->d_name) == 0){
            closedir(d);
            return true;
        }
        dirp = readdir(d);
    }
    closedir(d);
    return false;
}

void DisplayStats(const char* dir, const char* filename){
    if(!IsInDir(dir, filename)) {
        return;
    }

    struct stat sb = GetStats(filename, dir);

    if(! using_l && ! using_o && ! using_g){
        ShowFiletype(sb.st_mode);
        printf(" %s\n", filename);
        //using return statement, because I can't break here;
        return;
    }
    // show filetype
    ShowFiletype(sb.st_mode);
    // show permissions
    ShowPermissions(sb.st_mode);
    // number after wrx permissions
    if(sb.st_nlink > 9)
        printf(" %jd ", (intmax_t)sb.st_nlink);
    else
        printf("  %jd ", (intmax_t)sb.st_nlink);
    // print owner
    if(! using_g)
        printf("%4s ", getpwuid(sb.st_uid)->pw_name );
    // print group
    if(! using_o)
        printf("%4s", getgrgid(sb.st_gid)->gr_name);
    // print file size
    if(using_h){
        ShowFilesize(sb.st_size);
    }else{
        printf("%8jd ", (intmax_t)sb.st_size);
    }
    // print time
    ShowTime(sb.st_mtime);
    // print filename
    ShowName(filename);
}

void DisplayDirArgs(int argc, char* argv[]){
    //TO DO total
    if((argc - optind) == 0)
        DisplayStats(".",".");

    for (int i = optind; i < argc; ++i)
    {
        DisplayStats(".", argv[i]);
    }
}

void DisplayDirEntries(const char* dir){

    char** entries = malloc(BUFSIZE * sizeof(char*));
    if (!entries){
        perror("malloc");
        abort();
    }

    DIR* dfd = opendir(dir);

    size_t entries_count;

    StructureDirEntries(dfd, entries, &entries_count);

    for (size_t i = 0; i < entries_count; ++i){
        DisplayStats(dir, entries[i]);
    }

    closedir(dfd);

    free(entries);
}

void MultipleDirs(const char *name){
    DIR *dir;
    struct dirent *entry;

    if(!(dir = opendir(name)))return;

    while((entry = readdir(dir)) != NULL){
        if(entry->d_type == DT_DIR){
            char dirPath[BUFSIZE];
            if(strcmp(entry->d_name, ".") == 0 || strcmp(entry->d_name, "..") == 0)
                continue;
            snprintf(dirPath, sizeof(dirPath), "%s%s", name, entry->d_name);
            printf("d %s\n", entry->d_name);
        }else{
            if(entry->d_name[0] != '.'){
                struct stat sb = GetStats(entry->d_name, name);
                ShowFiletype(sb.st_mode);
                printf(" %s\n",entry->d_name);
            }
        }
    }
    closedir(dir);
}

void ScanDirEntries(int argc, char* argv[]){

    for (int i = optind; i < argc; ++i){

        if (!IsDir(argv[i])){
            DisplayStats(".", argv[i]);
            continue;
        }else{
            if(i != 1)printf("\n%s:\n",argv[i]);
            MultipleDirs(argv[i]);
            continue;
        }

    }
}

int main(int argc, char *argv[]){

    GetOptions(argc, argv);
    if(using_d){

        DisplayDirArgs(argc, argv);
        return EX_OK;
    }else{
        if(optind == argc){
            DisplayDirEntries(".");
            return EX_OK;
        }
        ScanDirEntries(argc, argv);
    }
}