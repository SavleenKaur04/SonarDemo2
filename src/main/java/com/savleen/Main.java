package com.savleen;

public class Main {
    public static void main(String[] args) { 
        System.out.println("Hello SonarCloud!");
    }
    int x=78;
     public void emptyCatchBlock() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // ❌ Catch block should not be empty (java:S2486)
        }
    }
}
