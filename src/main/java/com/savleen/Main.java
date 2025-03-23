package com.savleen;

public class Main {
    public static void main(String[] args) { 
        System.out.println("Hello SonarCloud!");
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
}
