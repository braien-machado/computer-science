package programmingone.oopsparadigms;

/**
 * Represents a Motorcycle object that implements the MotorVehicle interface.
 */
public class Motorcycle implements MotorVehicle {
  private String make;
  private String model;
  private int yearOfManufacture;
  private int numberOfWheels;
  private String motorcycleType;

  /**
   * Constructs a Motorcycle object with the specified make, model, and year of manufacture.
   *
   * @param make The make of the motorcycle.
   * @param model The model of the motorcycle.
   * @param year The year of manufacture of the motorcycle.
   */
  public Motorcycle(String make, String model, int year) {
     setMake(make);
     setModel(model);
     setYearOfManufacture(year);
  }

  /**
   * Gets the make of the motorcycle.
   *
   * @return The make of the motorcycle.
   */
  @Override
  public String getMake() {
    return make;
  }

  /**
   * Gets the model of the motorcycle.
   *
   * @return The model of the motorcycle.
   */
  @Override
  public String getModel() {
    return model;
  }

  /**
   * Gets the year of manufacture of the motorcycle.
   *
   * @return The year of manufacture of the motorcycle.
   */
  @Override
  public int getYearOfManufacture() {
    return yearOfManufacture;
  }

  /**
   * Sets the make of the motorcycle.
   *
   * @param make The make of the motorcycle.
   * @throws IllegalArgumentException if make is an empty string.
   */
  public void setMake(String make) {
    if (make.length() == 0) {
      throw new IllegalArgumentException("`make` must be a non-empty String");
    }
    this.make = make;
  }

  /**
   * Sets the model of the motorcycle.
   *
   * @param model The model of the motorcycle.
   * @throws IllegalArgumentException if model is an empty string.
   */
  public void setModel(String model) {
    if (model.length() == 0) {
      throw new IllegalArgumentException("`model` must be a non-empty String");
    }
    this.model = model;
  }

  /**
   * Sets the year of manufacture of the motorcycle.
   *
   * @param yearOfManufacture The year of manufacture of the motorcycle.
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
   * Gets the number of wheels of the motorcycle.
   *
   * @return The number of wheels of the motorcycle.
   */
  @Override
  public int getNumberOfWheels() {
    return numberOfWheels;
  }

  /**
   * Sets the number of wheels of the motorcycle.
   *
   * @param wheels The number of wheels of the motorcycle.
   * @throws IllegalArgumentException if the number of wheels is less than or equal to 0.
   */
  @Override
  public void setNumberOfWheels(int wheels) {
    if (wheels <= 0) {
      throw new IllegalArgumentException("Number of wheels must be greater than zero.");
    }
    
    this.numberOfWheels = wheels;
  }

  /**
   * Gets the type of the motorcycle.
   *
   * @return The type of the motorcycle.
   */
  @Override
 public String getMotorcycleType() {
   return motorcycleType;
 }

  /**
   * Sets the type of the motorcycle.
   *
   * @param type The type of the motorcycle.
   * @throws IllegalArgumentException if the motorcycle type is not valid.
   */
  @Override
  public void setMotorcycleType(String type) {
    if (!isValidMotorcycleType(type)) {
      throw new IllegalArgumentException("Invalid motorcycle type. Must be Sport, Cruiser, or Off-road.");
    }
    this.motorcycleType = type;
  }

  /**
   * Checks if the provided motorcycle type is valid.
   *
   * @param type The motorcycle type to check.
   * @return true if the motorcycle type is valid, false otherwise.
   */
  public boolean isValidMotorcycleType(String type) {
    return type.equals("Sport") || type.equals("Cruiser") || type.equals("Off-road");
  }

  /**
   * Returns a string representation of the motorcycle.
   *
   * @return A string representation of the motorcycle.
   */
  public String toString() {
    return "Motorcycle [Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture + ", Wheels: " + numberOfWheels + ", Type: " + motorcycleType + "]";
  }
}
