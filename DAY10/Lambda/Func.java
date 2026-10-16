package DAY10.Lambda;
/*
Function<T,R>: applu(t);
T ->  R */
import java.util.*;

import java.util.function.Function;
public class Func {
    public static void main(String[] args) {
        Function<String,Integer> getLength = name -> name.length();
        System.out.println(getLength.apply("Java"));
        System.out.println(getLength.apply("John"));
    }
}
