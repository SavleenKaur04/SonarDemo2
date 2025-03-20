package com.savleen;

public class Main {
    public static void main(String[] args) { 
        System.out.println("Hello SonarCloud!");
    }
   public void useOfSystemOut() {
        // ❌ System.out.println should be replaced with a logger (java:S106)
        System.out.println("Logging should be done using a logger.");
    }

    public void switchWithoutDefault(int value) {
        // ❌ Switch statement should have a default case (java:S131)
        switch (value) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
        }
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
