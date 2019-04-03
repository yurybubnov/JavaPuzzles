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
        VarHandle VALUE = MethodHandles.privateLookupIn(String.class, MethodHandles.lookup()).findVarHandle(String.class,"value", byte[].class);
        Object hw = VALUE.get("Hello World!");
        Object oops = VALUE.get("Opps!");
        System.arraycopy(oops,0, hw, 0, Array.getLength(oops));
       // VALUE.set("Hello World!", VALUE.get("Opps!"));
        System.out.println("Hello World!");
    }
}
