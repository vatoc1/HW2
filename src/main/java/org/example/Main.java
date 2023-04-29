package org.example;

// you should enable assertions with java-ea ClassName or adding -ea in VM settings

public class Main {
    public static void main(String[] args) throws AssertionError{

        System.out.println("Hello world!");
        MyClass instance = new MyClass(10000,3.2F, (byte) 30,(byte)4);
        instance.printMortgage();
        instance.printPaymentSchedule();


    }
}