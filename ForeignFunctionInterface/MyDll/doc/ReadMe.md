### Tools Required for DLL Creation Using C++ Code

To set up your environment for creating DLL files using C++ code on Ubuntu, you will need to install several tools. Below are the steps to install the necessary components.

### Install GCC Compiler
To install the GCC compiler, run the following command:
```sh
sudo apt install build-essential
```

### Install Ninja-Build
Ninja is a small build system with a focus on speed. Install it with the following command:
```sh
sudo apt install ninja-build
```

### Install CMake and MinGW-W64
CMake is a cross-platform, open-source build system. MinGW-W64 is a compiler suite for Windows. Install them with the following command:
```sh
sudo apt install cmake ninja-build mingw-w64
```

By following these steps, you'll have the necessary tools installed to create DLL files using C++ code on Ubuntu.

----------------------------------------------------------------

### Step 1: Create the Directory Structure
Open a terminal and create the directory structure as follows:

```sh
mkdir MyDll
cd MyDll
mkdir include src build
```

### Step 2: Create the Header File (`MyDll.h`)
Create a header file named `MyDll.h` inside the `include` folder:

```cpp
// include/MyDll.h
#ifndef MYDLL_H
#define MYDLL_H

extern "C" const char* hello();

#endif // MYDLL_H
```

### Step 3: Create the Source File (`MyDll.cpp`)
Create a source file named `MyDll.cpp` inside the `src` folder:

```cpp
// src/MyDll.cpp
#include "MyDll.h"

const char* hello() {
    return "Hello, World!";
}
```

### Step 4: Create the `CMakeLists.txt` File
Create a `CMakeLists.txt` file in the `MyDll` directory:

```cmake
# CMakeLists.txt
cmake_minimum_required(VERSION 3.10)
project(MyDll)

set(CMAKE_CXX_STANDARD 11)

include_directories(include)

add_library(MyDll SHARED src/MyDll.cpp)
```

### Step 5: Compile the Project
1. **Navigate to the `build` Directory:**
   ```sh
   cd build
   ```

2. **Run CMake to Configure the Project:**
   ```sh
   cmake -G "Ninja" -DCMAKE_SYSTEM_NAME=Windows -DCMAKE_C_COMPILER=x86_64-w64-mingw32-gcc -DCMAKE_CXX_COMPILER=x86_64-w64-mingw32-g++ ..
   ```

3. **Build the Project:**
   ```sh
   ninja
   ```

### Step 6: Manually Create the DLL (Optional)
You can manually create the DLL using the following command if needed:

```sh
x86_64-w64-mingw32-gcc -shared -o MyDll.dll src/MyDll.cpp -Iinclude -lstdc++ -lgcc
```

### Summary of Files and Directories:
```
MyDll/
├── include/
│   └── MyDll.h
├── src/
│   └── MyDll.cpp
├── build/
├── CMakeLists.txt
```

This project should create a DLL that you can then load into a Java program using FFI.

--------------------------------------------------------------------------------------------

After running Ninja, the two files you see—`libMyDll.dll` and `libMyDll.dll.a`—serve different purposes:

1. **libMyDll.dll:**
    - This is the **dynamic link library (DLL)** file itself. It contains the compiled code that will be used at runtime by other programs. This is the actual shared library you will load and use in your Java application using FFI.

2. **libMyDll.dll.a:**
    - This is the **import library** for the DLL. It is used by the linker at build time to resolve references to functions and data in the DLL. The import library is a static archive file that provides the necessary symbols for linking with the DLL.

### Which One to Use:
- For loading the DLL in your Java application using FFI, you will use `libMyDll.dll`. This is the file that contains the actual executable code that will be loaded into your application's memory space at runtime.

You can safely ignore the `libMyDll.dll.a` file unless you are doing further development or linking against the DLL in other C++ projects.

### Summary:
- **Use `libMyDll.dll`** for loading into Java.
- **Ignore `libMyDll.dll.a`** for your current use case.

