package dev.bubnov;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Hello world!
 * run with java --add-opens java.base/java.lang=ALL-UNNAMED
 */
public class NoSoHelloWorld
{
    public static void main( String[] args ) throws IllegalAccessException, NoSuchFieldException {
        String oldString = "Hello World";
        String newString = "Not so fast";
        VarHandle VALUE = MethodHandles.privateLookupIn(String.class, MethodHandles.lookup()).findVarHandle(String.class,"value", byte[].class);
        Object hw = VALUE.get(oldString);
        Object oops = VALUE.get(newString);
        System.arraycopy(oops,0, hw, 0, Array.getLength(oops));
        System.out.println(oldString);
    }
}
