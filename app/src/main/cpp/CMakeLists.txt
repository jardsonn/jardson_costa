cmake_minimum_required(VERSION 3.10.2)

project("jardson_costa")

add_library(
        jardson_costa
        SHARED
        native-lib.cpp)

find_library(
        log-lib
        log)

target_link_libraries(
        jardson_costa
        ${log-lib})