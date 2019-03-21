package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.Predicate;
public class Lambda {
    public static void main(String[] args) {
        SayHi sayHi = () -> System.out.println("hi");
        sayHi.SayHi();

    }
}
interface SayHi{
    public void SayHi();
}
