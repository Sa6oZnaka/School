# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.14

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/alexy/Downloads/clion-2019.1.3/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/alexy/Downloads/clion-2019.1.3/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /home/alexy/Documents/School/OS/HW-02

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /home/alexy/Documents/School/OS/HW-02/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/HW_02.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/HW_02.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/HW_02.dir/flags.make

CMakeFiles/HW_02.dir/main.c.o: CMakeFiles/HW_02.dir/flags.make
CMakeFiles/HW_02.dir/main.c.o: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/home/alexy/Documents/School/OS/HW-02/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/HW_02.dir/main.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/HW_02.dir/main.c.o   -c /home/alexy/Documents/School/OS/HW-02/main.c

CMakeFiles/HW_02.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/HW_02.dir/main.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /home/alexy/Documents/School/OS/HW-02/main.c > CMakeFiles/HW_02.dir/main.c.i

CMakeFiles/HW_02.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/HW_02.dir/main.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /home/alexy/Documents/School/OS/HW-02/main.c -o CMakeFiles/HW_02.dir/main.c.s

# Object files for target HW_02
HW_02_OBJECTS = \
"CMakeFiles/HW_02.dir/main.c.o"

# External object files for target HW_02
HW_02_EXTERNAL_OBJECTS =

libHW_02.a: CMakeFiles/HW_02.dir/main.c.o
libHW_02.a: CMakeFiles/HW_02.dir/build.make
libHW_02.a: CMakeFiles/HW_02.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/home/alexy/Documents/School/OS/HW-02/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C static library libHW_02.a"
	$(CMAKE_COMMAND) -P CMakeFiles/HW_02.dir/cmake_clean_target.cmake
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/HW_02.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/HW_02.dir/build: libHW_02.a

.PHONY : CMakeFiles/HW_02.dir/build

CMakeFiles/HW_02.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/HW_02.dir/cmake_clean.cmake
.PHONY : CMakeFiles/HW_02.dir/clean

CMakeFiles/HW_02.dir/depend:
	cd /home/alexy/Documents/School/OS/HW-02/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /home/alexy/Documents/School/OS/HW-02 /home/alexy/Documents/School/OS/HW-02 /home/alexy/Documents/School/OS/HW-02/cmake-build-debug /home/alexy/Documents/School/OS/HW-02/cmake-build-debug /home/alexy/Documents/School/OS/HW-02/cmake-build-debug/CMakeFiles/HW_02.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/HW_02.dir/depend

