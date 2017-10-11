set (PACKAGE_NAME "com.rxl.stduy")
STRING (REPLACE "." "\\" ${PACKAGE_NAME} PACKAGE_PATH)
set (PACKAGE_PATH "${CMAKE_CURRENT_BINARY_DIR}/src/${PACKAGE_PATH}")

message (STATUS "create antlr4 files in ${PACKAGE_PATH}")
file (MAKE_DIRECTORY ${PACKAGE_PATH})

execute_process (
    COMMAND antlr4 Hello.g4 -package ${PACKAGE_NAME} -o ${PACKAGE_PATH} 
    WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR})
    
file (GLOB hello_java_srcs ${PACKAGE_PATH}/*.java)
add_jar (hello_g4_jar ${hello_java_srcs} 
    INCLUDE_JARS "/usr/local/Cellar/antlr/4.7/antlr-4.7-complete.jar" 
    OUTPUT_DIR "${CMAKE_BINARY_DIR}/libs")
