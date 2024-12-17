# CMakeLists.txt
cmake_minimum_required(VERSION 3.10)
project(MyDll)

set(CMAKE_CXX_STANDARD 11)

include_directories(include)

add_library(MyDll SHARED src/MyDll.cpp)
