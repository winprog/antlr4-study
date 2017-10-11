project (antlr4-study)
cmake_minimum_required (VERSION 3.9)

find_package (Java REQUIRED)
include (UseJava)

# config path from my macos.
set (ANTLR_JAVA_LIB "/usr/local/Cellar/antlr/4.7/antlr-4.7-complete.jar")

add_subdirectory (install)
add_subdirectory (test)
