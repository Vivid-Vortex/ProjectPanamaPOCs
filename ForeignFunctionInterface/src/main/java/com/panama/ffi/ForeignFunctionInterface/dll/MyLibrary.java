package com.panama.ffi.ForeignFunctionInterface.dll;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public interface MyLibrary extends Library {
    MyLibrary INSTANCE = Native.load(Platform.isWindows() ? "MyDll/build/libMyDll" : "mydll", MyLibrary.class);

    class InputObject extends Structure {
        public static class ByValue extends InputObject implements Structure.ByValue {}

        public int number;
        public String text;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("number", "text");
        }
    }

    class OutputObject extends Structure {
        public static class ByValue extends OutputObject implements Structure.ByValue {}

        public int result;
        public String message;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("result", "message");
        }
    }

    OutputObject.ByValue process(InputObject.ByValue input);
}
