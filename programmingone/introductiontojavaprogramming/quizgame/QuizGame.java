package programmingone.introductiontojavaprogramming.quizgame;

import java.util.Scanner;

public class QuizGame {
  public static void main(String[] args) {
    System.out.println("Welcome to the Java Quiz!");

    Scanner scanner = new Scanner(System.in);

    short score = 0; // variable to store the correct answers counter

    String [] questions = { // String array to store the questions
      "How many primitive types are supported by the Java programming language?",
      "Which type can represent real numbers?",
      "Which operator has the highest precedence?",
      "Which of the following is used to create an instance of a class in Java?",
      "What is the correct way to define the main method in a Java class?"
    };
    String[][] options = { // Array of String arrays to store questions' options
      { "9", "8", "6", "7" },
      { "byte", "long", "short", "double" },
      { "+", "+=", ">", ">=" },
      {"new", "class", "instance", "object"},
      {"public void main(String[] args)", "public static void main(String[] args)", "void main(String[] args)", "static void main(String[] args)"}
    };
    int[] answersPositions = { 1, 3, 0, 0, 1 }; // int array to store the correct answer position for each question in the options array

    System.out.println();

    for (int i = 0; i < questions.length; i += 1) { // Traverse the questions array
      System.out.printf("Question %d - ", i + 1); // Print the question number
      System.out.println(questions[i]); // Print the question statement 
      System.out.println();

      for (int j = 0; j < options[i].length; j += 1) { // Traverse the options array related to the question 
        char letter = (char) ('A' + j);

        System.out.printf("%c - %s%n", letter, options[i][j]); // Print the option
      }

      System.out.println();
      
      
      String answer = "";
      boolean isValid = false;
      
      while (!isValid) { // Keep repeating the input step until the answer is valid
        System.out.print("Enter the letter that contains the correct answer: ");
        answer = scanner.nextLine();

        isValid = switch (answer) {
          case "A", "a", "B", "b", "C", "c", "D", "d" -> true;
          default -> {

            System.out.println("Invalid enter. Try again.");
            System.out.println();
            yield false;
          }
        };
      }
      
      int answerPosition = switch (answer) { // Get the answer position related to the selected option
        case "A", "a" -> 0;
        case "B", "b" -> 1;
        case "C", "c" -> 2;
        case "D", "d" -> 3;
        default -> -1;
      };

      if (answerPosition == answersPositions[i]) { // If the selected option generates the correct answer position, increment the score
        score += 1;
      }
      
      System.out.println();
    }
    
    scanner.close();

    System.out.printf("Your score: %.1f%%%n", score * 100 / (double) (questions.length)); // Print the final score
  }
}
