list (APPEND CMAKE_JAVA_INCLUDE_PATH "${CMAKE_BINARY_DIR}/libs/hello_g4_jar.jar")

message (STATUS "java libs = ${CMAKE_JAVA_INCLUDE_PATH}")

set (HELLO_G4_LIB_NAME "hello_g4_jar")
set (HELLO_G4_LIB "${CMAKE_BINARY_DIR}/libs/${HELLO_G4_LIB_NAME}.jar")
configure_file ("HelloWorld.MF.in" "HelloWorld.MF")

add_jar (HelloWorld HelloWorld.java
    INCLUDE_JARS ${HELLO_G4_LIB_NAME} ${ANTLR_JAVA_LIB}
    MANIFEST "${CMAKE_CURRENT_BINARY_DIR}/HelloWorld.MF")

