package programmingone.arraysandarraylists.stockpriceoperations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class StockPriceOperator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startProgram();
    }

    private static void printRepeatedMark(char mark, int times) {
        System.out.println(Character.toString(mark).repeat(times));
    }

    private static void printRepeatedMark(char mark) {
        printRepeatedMark(mark, 40);
     }

    private static void printRepeatedMark() {
       printRepeatedMark('=', 40);
    }

    private static void startProgram() {
        printMenu();
        int choice = doGetChoice();

        switch (choice) {
            case 1 -> {
                doCalculateAverage();
                startProgram();
                break;
            }
            case 2 -> {
                doFindMaximum();
                startProgram();
                break;
            }
            case 3 -> {
                doCountOcurrence();
                startProgram();
                break;
            }
            case 4 -> {
                doCumulativeSum();
                startProgram();
                break;
            }
            case 0 -> {
                doExit();
                break;
            }
            default -> {
                printRepeatedMark();
                System.out.println("Invalid option.");
                startProgram();
            }
        }
    }

    private static void printMenuOptions() {
        printRepeatedMark();
        System.out.println("1. Calculate the average stock price");
        System.out.println("2. Find the maximum stock price");
        System.out.println("3. Determine the occurrence count of a specific price");
        System.out.println("4. Compute the cumulative sum of stock prices");
        System.out.println("0. Quit the program");
        printRepeatedMark();
    }

    private static void printMenu() {
        printRepeatedMark();
        System.out.println("Enter a numeric value corresponding to the operation that you want to carry out");
        printMenuOptions();
    }

    private static void printChoicePrompt() {
        System.out.print("Your Choice =>: ");
    }

    private static int doGetChoice() {
        int choice = -1;
        boolean isChoice = false;

        printChoicePrompt();

        String invalidChoiceMessage = "Invalid choice. The options are: 0, 1, 2, 3 or 4";

        while (!isChoice) {
            try {
                choice = Integer.parseInt(scanner.nextLine());

                if (choice < 0 || choice > 4) {
                    printRepeatedMark();
                    System.out.println(invalidChoiceMessage);
                    printRepeatedMark();
                    printChoicePrompt();
                } else {
                    isChoice = true;
                }
            } catch (NumberFormatException e) {
                printRepeatedMark();
                    System.out.println(invalidChoiceMessage);
                    printRepeatedMark();
                printChoicePrompt();
            }
        }

        return choice;
    }

    private static void doExit() {
        printRepeatedMark();
        System.out.println("You chose to exit the program, bye for now!");
        printRepeatedMark();
    }

    private static void printOperationInstructions() {
        printRepeatedMark();
        System.out.println("Please enter a series of floats separated by comma.");
        System.out.println("For example:");
        System.out.println("3.00, 3.45, 5.11, 100.01, 100, 20.34");
        System.out.println("Or");
        System.out.println("Enter 0 to quit");
        printRepeatedMark();
    }

    private static void printFloatsPrompt() {
        System.out.print("Your series of floats =>: ");
    }

    private static boolean areAllFloats(String[] values) {
        try {
            for (String value : values) {
                Float.parseFloat(value);
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static float[] doGetFloats() {
        String[] tokens;

        while (true) {
            printFloatsPrompt();
            String input = scanner.nextLine();

            if (input.equals("0")) return new float[0];

            tokens = input.split(",");

            if (areAllFloats(tokens)) {
                System.out.println("All inputs are valid floats");

                var list = new float[tokens.length];

                for (int index = 0; index < tokens.length; index += 1) {
                    list[index] = Float.parseFloat(tokens[index]);
                }

                return list;
            }
            printRepeatedMark();
            System.out.println("The input contains non-float values.");
            System.out.println("Try again or press 0 to quit.");
            printRepeatedMark();
        }
    }

    private static void goBackToMainMenu() {
        printRepeatedMark();
        System.out.println("You chose to get back to main menu.");
    }

    private static float calculateAverage(float[] values) {
        float sum = 0;

        for (float value : values) {
            sum += value;
        }

        return sum / values.length;
    }

    private static void doCalculateAverage() {
        printRepeatedMark();
        System.out.println("You chose to calculate the average stock price");
        printOperationInstructions();

        float[] floats = doGetFloats();

        if (floats.length == 0) {
            goBackToMainMenu();
            return;
        }
        
        float average = calculateAverage(floats);

        BigDecimal bd = new BigDecimal(Float.toString(average));
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        printRepeatedMark('*');
        System.out.printf("The Average Price of the entered value(s) to 2 decimal places is == %.2f%n", bd.floatValue());
        printRepeatedMark('*');
    }

    private static float getGreaterFloat(float[] values) {
        float greater = values[0];

        for (float value : values) {
            if (value > greater) {
                greater = value;
            }
        }

        return greater;
    }

    private static void doFindMaximum() {
        printRepeatedMark();
        System.out.println("You chose to find maximum price");
        printOperationInstructions();

        float[] floats = doGetFloats();

        if (floats.length == 0) {
            goBackToMainMenu();
            return;
        }
        
        float greater = getGreaterFloat(floats);

        BigDecimal bd = new BigDecimal(Float.toString(greater));
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        printRepeatedMark('*');
        System.out.printf("The Maximum Price of the entered value(s) to 2 decimal places is == %.2f%n", bd.floatValue());
        printRepeatedMark('*');
    }

    private static void doCountOcurrence() {
        printRepeatedMark();
        System.out.println("You chose to determine the occurrence count of a specific price.");
        printOperationInstructions();
    }

    private static void doCumulativeSum() {
        printRepeatedMark();
        System.out.println("You chose to compute the cumulative sum of stock prices.");
        printOperationInstructions();
    }
    
}
