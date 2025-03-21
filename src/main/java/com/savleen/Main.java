package com.savleen;

public class Main {
    public static void main(String[] args) { 
        System.out.println("Hello SonarCloud!");
    }
    int x = 10;
        if (x > 5) {
            if (x < 15) { // Nested ifs, bad practice
                System.out.println("Nested if detected");
            }
        }
        
        try {
            int y = 5 / 0; // Division by zero
        } catch (Exception e) {
            // Empty catch block - bad practice
        }
    }

}
