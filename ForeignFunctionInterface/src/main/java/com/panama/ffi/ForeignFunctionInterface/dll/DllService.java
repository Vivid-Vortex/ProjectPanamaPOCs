package com.panama.ffi.ForeignFunctionInterface.dll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DllService {

    public static String processInput(@RequestParam int number, @RequestParam String text) {
        MyLibrary.InputObject.ByValue input = new MyLibrary.InputObject.ByValue();
        input.number = number;
        input.text = text;
        MyLibrary.OutputObject.ByValue output = MyLibrary.INSTANCE.process(input);
        return "Result: " + output.result + ", Message: " + output.message;
    }
    public static void main(String[] args) {
        System.out.println(DllService.processInput(10, "hello"));
    }
}
