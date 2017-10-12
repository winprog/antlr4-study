set (PACKAGE_NAME "com.rxl.study")
message (STATUS "packages = ${PACKAGE_NAME}")

STRING (REPLACE "." "/" PACKAGE_PATH ${PACKAGE_NAME})
set (PACKAGE_PATH "${CMAKE_CURRENT_BINARY_DIR}/src/${PACKAGE_PATH}")
message (STATUS "create antlr4 files in ${PACKAGE_PATH}")

file (MAKE_DIRECTORY ${PACKAGE_PATH})

execute_process (
    COMMAND antlr4 Hello.g4 -package ${PACKAGE_NAME} -o ${PACKAGE_PATH} 
    WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
    
file (GLOB_RECURSE hello_java_srcs "${PACKAGE_PATH}/*.java")
file (GLOB_RECURSE hello_java_res "${PACKAGE_PATH}/*.tokens")

message (STATUS "srcs path = ${PACKAGE_PATH}")
message (STATUS "srcs = ${hello_java_srcs}")

set (JAR_OUTPUT_PATH "${CMAKE_BINARY_DIR}/libs")

add_jar (hello_g4_jar 
    SOURCES ${hello_java_srcs} 
    INCLUDE_JARS ${ANTLR_JAVA_LIB}
    OUTPUT_DIR ${JAR_OUTPUT_PATH})
