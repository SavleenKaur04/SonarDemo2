package com.savleen;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) { 
        System.out.println("Hello SonarCloud!");
    }
    private int unusedVariable = 100; 

    public void checkNullRisk() {
        String riskyString = null;
        System.out.println(riskyString.length());   // ❌ Possible NullPointerException (java:S2259)
    }

    public void emptyMethod() {       // ❌ Empty method should be removed or implemented (java:S1186)
    }

    public void hardcodedCondition() {
        if (true) {
            System.out.println("This will always execute.");         // ❌ Condition is always true (java:S2583)
        }
    }

    public void useOfSystemOut() {
        System.out.println("Logging should be done using a logger.");     // ❌ System.out.println should be replaced with a logger (java:S106)
    }

    public void redundantArrayList() {
        List<String> names = new ArrayList<>();      // ❌ Avoid instantiating an empty list unnecessarily (java:S2384)
    }
}
