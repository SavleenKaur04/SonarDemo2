package com.savleen;

public class Main {
    public static void main(String[] args) { 
        System.out.println("Hello SonarCloud!");
    }
     public void nestedIfStatements(int x) {
        // ❌ Avoid too many nested if statements (java:S1067)
        if (x > 0) {
            if (x > 5) {
                if (x > 10) {
                    System.out.println("X is greater than 10");
                }
            }
        }
    }

    public void emptyCatchBlock() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // ❌ Catch block should not be empty (java:S2486)
        }
    }
}
