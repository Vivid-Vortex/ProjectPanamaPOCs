package com.panama.ffi.ForeignFunctionInterface.dll;

// src/main/java/com/example/MyLibrary.java

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public interface MyLibrary extends Library {
    MyLibrary INSTANCE = Native.load(Platform.isWindows() ? "MyDll/build/libMyDll" : "mydll", MyLibrary.class);

    String hello();
}

