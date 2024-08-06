package programmingone.oopsparadigms;

/**
 * Represents a Car object that implements the CarVehicle interface.
 */
public class Car implements CarVehicle {
  private String make;
  private String model;
  private int yearOfManufacture;
  private int numberOfDoors;
  private String fuelType;

  /**
   * Constructs a Car object with the specified make, model, and year of manufacture.
   *
   * @param make The make of the car.
   * @param model The model of the car.
   * @param year The year of manufacture of the car.
   */
  public Car(String make, String model, int year) {
     setMake(make);
     setModel(model);
     setYearOfManufacture(year);
  }

  /**
   * Gets the make of the car.
   *
   * @return The make of the car.
   */
  @Override
  public String getMake() {
    return make;
  }

  /**
   * Gets the model of the car.
   *
   * @return The model of the car.
   */
  @Override
  public String getModel() {
    return model;
  }

  /**
   * Gets the year of manufacture of the car.
   *
   * @return The year of manufacture of the car.
   */
  @Override
  public int getYearOfManufacture() {
    return yearOfManufacture;
  }

  /**
   * Sets the make of the car.
   *
   * @param make The make of the car.
   * @throws IllegalArgumentException if make is an empty string.
   */
  public void setMake(String make) {
    if (make.length() == 0) {
      throw new IllegalArgumentException("`make` must be a non-empty String");
    }
    this.make = make;
  }

  /**
   * Sets the model of the car.
   *
   * @param model The model of the car.
   * @throws IllegalArgumentException if model is an empty string.
   */
  public void setModel(String model) {
    if (model.length() == 0) {
      throw new IllegalArgumentException("`model` must be a non-empty String");
    }
    this.model = model;
  }

  /**
   * Sets the year of manufacture of the car.
   *
   * @param yearOfManufacture The year of manufacture of the car.
   * @throws IllegalArgumentException if the year is not between 1001 and 2024.
   */
  @Override
  public void setYearOfManufacture(int yearOfManufacture) {
    if (yearOfManufacture <= 1000 || yearOfManufacture >= 2025) {
      throw new IllegalArgumentException("Year of manufacture must be between 1001 and 2024.");
    }

    this.yearOfManufacture = yearOfManufacture;
  }

  /**
   * Sets the number of doors of the car.
   *
   * @param doors The number of doors of the car.
   * @throws IllegalArgumentException if the number of doors is less than 0.
   */
  @Override
  public void setNumberOfDoors(int doors) {
    if (doors < 0) {
      throw new IllegalArgumentException("Number of doors must be greater than or equal zero");
    }
    
    this.numberOfDoors = doors;
  }

  /**
   * Gets the number of doors of the car.
   *
   * @return The number of doors of the car.
   */
  @Override
  public int getNumberOfDoors() {
    return numberOfDoors;
  }

  /**
   * Gets the fuel type of the car.
   *
   * @return The fuel type of the car.
   */
  @Override
  public String getFuelType() {
    return fuelType;
  }

  /**
   * Sets the fuel type of the car.
   *
   * @param fuelType The fuel type of the car.
   * @throws IllegalArgumentException if the fuel type is not valid.
   */
  @Override
  public void setFuelType(String fuelType) {
    if (!isValidFuelType(fuelType)) {
      throw new IllegalArgumentException("Invalid! Fuel type must be Petrol, Diesel, Electric, or Hybrid.");
    }
    this.fuelType = fuelType;
  }

  /**
   * Checks if the provided fuel type is valid.
   *
   * @param type The fuel type to check.
   * @return true if the fuel type is valid, false otherwise.
   */
  public boolean isValidFuelType(String type) {
    return type.equals("Petrol") || type.equals("Diesel") || type.equals("Electric") || type.equals("Hybrid");
  }

  /**
   * Returns a string representation of the car.
   *
   * @return A string representation of the car.
   */
  public String toString() {
    return "Car [Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture + ", Doors: " + numberOfDoors + ", Fuel Type: " + fuelType + "]";
  }
}
