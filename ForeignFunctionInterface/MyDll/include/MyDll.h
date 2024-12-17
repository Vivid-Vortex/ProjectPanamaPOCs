// include/MyDll.h
#ifndef MYDLL_H
#define MYDLL_H

struct InputObject {
    int number;
    const char* text;
};

struct OutputObject {
    int result;
    const char* message;
};

extern "C" OutputObject process(InputObject input);

#endif // MYDLL_H
