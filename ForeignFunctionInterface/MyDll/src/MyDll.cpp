// src/MyDll.cpp
#include "MyDll.h"
#include <string>

OutputObject process(InputObject input) {
    OutputObject output;
    output.result = input.number * 2;  // Example processing
    std::string message = "Processed: ";
    message += input.text;
    output.message = message.c_str();
    return output;
}
