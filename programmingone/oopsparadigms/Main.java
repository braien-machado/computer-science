package programmingone.oopsparadigms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class to run the Vehicle/Automobile Administration App.
 */
public class Main {
  private static final Scanner scanner = new Scanner(System.in);
  private static ArrayList<Car> cars = new ArrayList<>();
  private static ArrayList<Motorcycle> motorcycles = new ArrayList<>();
  private static ArrayList<Truck> trucks = new ArrayList<>();

  /**
   * Main method to start the program.
   *
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    startProgram();
  }

  /**
   * Starts the program by displaying the menu and processing user choices.
   */
  public static void startProgram() {
    printMenu();

    int choice = doGetChoice();

    switch (choice) {
        case 1 -> {
            addCarMethod();
            startProgram();
        }
        case 2 -> {
            addMotorcycleMethod();
            startProgram();
        }
        case 3 -> {
            addTruckMethod();
            startProgram();
        }
        case 4 -> {
            listCars();
            startProgram();
        }
        case 5 -> {
            listMotorcycles();
            startProgram();
        }
        case 6 -> {
            listTrucks();
            startProgram();
        }
        case 7 -> {
            System.out.println("You chose to exit the program. Bye for now");
        }
        default -> {
            printRepeatedMark();
            System.out.println("Invalid choice. Please try again.");
            startProgram();
        }
    }
  }

  /**
   * Gets a non-empty string input from the user.
   *
   * @param promptMessage The prompt message to display to the user.
   * @param invalidMessage The message to display if the input is invalid.
   * @return The valid non-empty string input.
   */
  private static String getNonEmptyStringInput(String promptMessage, String invalidMessage) {
    String input = null;

    while (input == null) {
      printRepeatedMark();
      System.out.print(promptMessage);

      input = scanner.nextLine().trim();

      if (!input.isEmpty()) return input;

      System.out.println(invalidMessage);
      input = null;
    }

    return input;
  }

  /**
   * Gets a valid year of manufacture input from the user.
   *
   * @return The valid year of manufacture.
   */
  private static int getYearInput() {
    int year = 0;

    while (year <= 1000 || year >= 2025) {
        printRepeatedMark();
        System.out.print("Enter Year of Manufacture (1001-2024): ");

        String userInput = scanner.nextLine();

        try {
            year = Integer.parseInt(userInput);

            if (year <= 1000 || year >= 2025) {
              System.out.println("Year of manufacture must be between 1001 and 2024.");
            }

        } catch (NumberFormatException e) {
            printRepeatedMark();
            System.out.println("Invalid year. Please enter a valid year between 1001 and 2024.");
        }
    }

    return year;
  }

  /**
   * Sets the cargo capacity input for a Truck object.
   *
   * @param truck The Truck object.
   */
  private static void setCargoInput(Truck truck) {
    double value;

    while (true) {
        printRepeatedMark();
        System.out.print("Enter Cargo Capacity (in tons): ");

        String userInput = scanner.nextLine();

        try {
            value = Double.parseDouble(userInput);

            truck.setCargoCapacity(value);
            break;

        } catch (IllegalArgumentException e) {
            printRepeatedMark();
            System.out.println("Error: " + e.getMessage() + ", Capacity in tons must be a realistic number.");
        }
    }
  }

  /**
   * Sets the transmission type input for a Truck object.
   *
   * @param truck The Truck object.
   */
  private static void setTransmissionTypeInput(Truck truck) {
    String type;

    while (true) {
        printRepeatedMark();
        System.out.print("Enter Transmission Type (Manual/Automatic): ");

        type = scanner.nextLine();

        try {
            truck.setTransmissionType(type);
            break;

        } catch (IllegalArgumentException e) {
            printRepeatedMark();
            System.out.println("Error: " + e.getMessage());
        }
    }
  }

  /**
   * Adds a Truck object based on user input.
   */
  private static void addTruckMethod() {
    try {
      String truckMake = getNonEmptyStringInput("Enter Truck Make: ", "Invalid! Truck Make cannot be empty.");
      String truckModel = getNonEmptyStringInput("Enter Truck Model: ", "Invalid! Truck Model cannot be empty.");
      int truckYear = getYearInput();
  
      Truck truck = new Truck(truckMake, truckModel, truckYear);
  
      setCargoInput(truck);
      setTransmissionTypeInput(truck);
      trucks.add(truck);
  
      System.out.println("Truck added: " + truck);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Sets the number of wheels input for a Motorcycle object.
   *
   * @param motorcycle The Motorcycle object.
   */
  private static void setNumberOfWheelsInput(Motorcycle motorcycle) {
    int value;

    while (true) {
        printRepeatedMark();
        System.out.print("Enter Number of Wheels: ");

        String userInput = scanner.nextLine();

        try {
            value = Integer.parseInt(userInput);

            motorcycle.setNumberOfWheels(value);
            break;

        } catch (IllegalArgumentException e) {
            printRepeatedMark();
            System.out.println("Error: " + e.getMessage() + ", Number of Wheels must be a realistic number.");
        }
    }
  }

  /**
   * Sets the motorcycle type input for a Motorcycle object.
   *
   * @param motorcycle The Motorcycle object.
   */
  private static void setMotorcycleTypeInput(Motorcycle motorcycle) {
    String type;

    while (true) {
        printRepeatedMark();
        System.out.print("Enter Motorcycle Type (Sport/Cruiser/Off-road): ");

        type = scanner.nextLine();

        try {
            motorcycle.setMotorcycleType(type);
            break;

        } catch (IllegalArgumentException e) {
            printRepeatedMark();
            System.out.println("Error: " + e.getMessage());
        }
    }
  }

  /**
   * Adds a Motorcycle object based on user input.
   */
  private static void addMotorcycleMethod() {
    try {
      String motorcycleMake = getNonEmptyStringInput("Enter Motorcycle Make: ", "Invalid! Motorcycle Make cannot be empty.");
      String motorcycleModel = getNonEmptyStringInput("Enter Motorcycle Model: ", "Invalid! Motorcycle Model cannot be empty.");
      int motorcycleYear = getYearInput();
  
      Motorcycle motorcycle = new Motorcycle(motorcycleMake, motorcycleModel, motorcycleYear);
  
      setNumberOfWheelsInput(motorcycle);
      setMotorcycleTypeInput(motorcycle);
      motorcycles.add(motorcycle);
  
      System.out.println("Motorcycle added: " + motorcycle);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Sets the number of doors input for a Car object.
   *
   * @param car The Car object.
   */
  private static void setNumberOfDoorsInput(Car car) {
    int value;

    while (true) {
        printRepeatedMark();
        System.out.print("Enter Number of Doors: ");

        String userInput = scanner.nextLine();

        try {
            value = Integer.parseInt(userInput);

            car.setNumberOfDoors(value);
            break;

        } catch (IllegalArgumentException e) {
            printRepeatedMark();
            System.out.println("Error: " + e.getMessage() + ", Number of Doors must be a realistic number.");
        }
    }
  }

  /**
   * Sets the fuel type input for a Car object.
   *
   * @param car The Car object.
   */
  private static void setCarFuelTypeInput(Car car) {
    String type;

    while (true) {
        printRepeatedMark();
        System.out.print("Enter Fuel Type (Petrol/Diesel/Electric/Hybrid): ");

        type = scanner.nextLine();

        try {
            car.setFuelType(type);
            break;

        } catch (IllegalArgumentException e) {
            printRepeatedMark();
            System.out.println("Error: " + e.getMessage());
        }
    }
  }

  /**
   * Adds a Car object based on user input.
   */
  private static void addCarMethod() {
    try {
      String carMake = getNonEmptyStringInput("Enter Car Make: ", "Invalid! Car Make cannot be empty.");
      String carModel = getNonEmptyStringInput("Enter Car Model: ", "Invalid! Car Model cannot be empty.");
      int carYear = getYearInput();
  
      Car car = new Car(carMake, carModel, carYear);
  
      setNumberOfDoorsInput(car);
      setCarFuelTypeInput(car);
      cars.add(car);
  
      System.out.println("Car added: " + car);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Lists all Car objects.
   */
  private static void listCars() {
    if (cars.isEmpty()) {
      System.out.println("No cars available");
      return;
    }

    for (Car car : cars) {
      System.out.println(car);
    }
  }

  /**
   * Lists all Motorcycle objects.
   */
  private static void listMotorcycles() {
    if (motorcycles.isEmpty()) {
      System.out.println("No motorcycles available");
      return;
    }

    for (Motorcycle motorcycle : motorcycles) {
      System.out.println(motorcycle);
    }
  }

  /**
   * Lists all Truck objects.
   */
  private static void listTrucks() {
    if (trucks.isEmpty()) {
      System.out.println("No trucks available");
      return;
    }

    for (Truck truck : trucks) {
      System.out.println(truck);
    }
  }

  /**
   * Prompts the user for a choice and returns the valid input.
   *
   * @return The user's choice as an integer.
   */
  private static int doGetChoice() {
    int choice = -1;
    boolean isChoice = false;

    printChoicePrompt();

    String invalidChoiceMessage = "Invalid input. Please enter a number between 1 and 7.";

    while (!isChoice) {
        try {
            choice = Integer.parseInt(scanner.nextLine());

            if (choice < 1 || choice > 7) {
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

  /**
   * Prints a repeated mark for visual separation.
   */
  private static void printRepeatedMark() {
    System.out.println(Character.toString('=').repeat(40));
  }

  /**
   * Prints the choice prompt for the user.
   */
  private static void printChoicePrompt() {
    System.out.print("Your Choice =>: ");
  }

  /**
   * Prints the menu options for the user.
   */
  private static void printMenuOptions() {
    printRepeatedMark();
    System.out.println("Select an operation: ");
    System.out.println("1. Add Car");
    System.out.println("2. Add Motorcycle");
    System.out.println("3. Add Truck");
    System.out.println("4. Display all Cars");
    System.out.println("5. Display all Motorcycles");
    System.out.println("6. Display all Trucks");
    System.out.println("7. Exit");
    printRepeatedMark();
  }

  /**
   * Prints the main menu for the program.
   */
  private static void printMenu() {
    printRepeatedMark();
    System.out.println("Welcome to the Vehicle/Automobile Administration App");
    printMenuOptions();
  }
}
