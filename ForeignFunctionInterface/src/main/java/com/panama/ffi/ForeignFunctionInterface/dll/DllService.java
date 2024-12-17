package com.panama.ffi.ForeignFunctionInterface.dll;

public class DllService {
    public static void main(String[] args) {
        System.out.println(MyLibrary.INSTANCE.hello());
    }
}
