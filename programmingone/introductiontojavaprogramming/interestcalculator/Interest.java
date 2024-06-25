package programmingone.introductiontojavaprogramming.interestcalculator;

import programmingone.introductiontojavaprogramming.utils.textio.TextIO;

// Base code from https://math.hws.edu/javanotes/c3/s1.html

/**
 * This class implements a simple program that will compute the amount of interest that is earned on an investment over a given period in years. The initial amount of the investment, the interest rate and the years are input by the user. The value of the investment at the end of each year is output.
 */
public class Interest {
  public static void main(String[] args) {
    double principal;
    double rate;
    int totalYears;

    System.out.print("Enter the initial investment: ");
    principal = TextIO.getlnDouble();

    System.out.println();
    System.out.println("Enter the annual interest rate.");
    System.out.print("Enter a decimal, not a percentage: ");
    rate = TextIO.getlnDouble();
    System.out.println();

    System.out.print("Enter the years to apply the interest reckoning: ");
    totalYears = TextIO.getlnInt();


    int currentYear = 0;

    while (currentYear < totalYears) {
      double interest;
      interest = principal * rate;
      principal += interest;

      currentYear += 1;

      System.out.printf("The value of the investment after %d year(s) is $%1.2f", currentYear, principal);
      System.out.println();
    }
  }
}
