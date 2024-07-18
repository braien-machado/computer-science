package programmingone.arraysandarraylists.stockpriceoperations;

import java.util.Scanner;

public class StockPriceOperator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startProgram();
    }

    private static void printRepeatedMark(char mark, int times) {
        System.out.println(Character.toString(mark).repeat(times));
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

    private static void doCalculateAverage() {
        printRepeatedMark();
        System.out.println("You chose to calculate the average stock price");
        printOperationInstructions();
    }

    private static void doFindMaximum() {
        printRepeatedMark();
        System.out.println("You chose to find maximum price");
        printOperationInstructions();
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
