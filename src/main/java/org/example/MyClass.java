package org.example;

import java.text.NumberFormat;

public class MyClass {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    private int principal;
    private float annualInterest;
    private byte years;
    private byte numberOfPaymentsMade;



    public MyClass(int principal,float annualInterest,byte years,byte numberOfPaymentsMade) {
        assert principal>=1000&&principal<=1000000:"invalid principal";
        assert annualInterest>=1&&annualInterest<=30 : "invalid annual interest";
        assert years >=1&&years<=30 : "invalid years";


        this.principal=principal;
        this.annualInterest=annualInterest;
        this.years=years;
        this.numberOfPaymentsMade=numberOfPaymentsMade;


    }
    public byte getNumberOfPaymentsMade() {
        return numberOfPaymentsMade;
    }

    public void setNumberOfPaymentsMade(byte numberOfPaymentsMade) {
        this.numberOfPaymentsMade = numberOfPaymentsMade;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public float getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }

    public byte getYears() {
        return years;
    }

    public void setYears(byte years) {
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }

    public double calculateBalance() {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;
        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }

    public void printMortgage() {
        double mortgage = calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance();
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
