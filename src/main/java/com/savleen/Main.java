package com.savleen;

public class Main {
    public static void main(String[] args) { 
        System.out.println("Hello SonarCloud!");
    }
    private int unusedVar = 10;  

    public void checkNullRisk(String input) {
        // ❌ Possible NullPointerException (Bug)
        System.out.println(input.length());  
    }

    public void alwaysTrueCondition() {
        // ❌ Hardcoded condition (Code Smell)
        if (true) {  
            System.out.println("This block will always execute.");
        }
    }
}
