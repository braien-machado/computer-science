package programmingone.oopsparadigms;

/**
 * Represents a Truck object that implements the TruckVehicle interface.
 */
public class Truck implements TruckVehicle {
  private String make;
  private String model;
  private int yearOfManufacture;
  private double cargoCapacity;
  private String transmissionType;

  /**
   * Constructs a Truck object with the specified make, model, and year of manufacture.
   *
   * @param make The make of the truck.
   * @param model The model of the truck.
   * @param year The year of manufacture of the truck.
   */
  public Truck(String make, String model, int year) {
     setMake(make);
     setModel(model);
     setYearOfManufacture(year);
  }

  /**
   * Gets the make of the truck.
   *
   * @return The make of the truck.
   */
  @Override
  public String getMake() {
    return make;
  }

  /**
   * Gets the model of the truck.
   *
   * @return The model of the truck.
   */
  @Override
  public String getModel() {
    return model;
  }

  /**
   * Gets the year of manufacture of the truck.
   *
   * @return The year of manufacture of the truck.
   */
  @Override
  public int getYearOfManufacture() {
    return yearOfManufacture;
  }

  /**
   * Sets the make of the truck.
   *
   * @param make The make of the truck.
   * @throws IllegalArgumentException if make is an empty string.
   */
  public void setMake(String make) {
    if (make.length() == 0) {
      throw new IllegalArgumentException("`make` must be a non-empty String");
    }
    this.make = make;
  }

  /**
   * Sets the model of the truck.
   *
   * @param model The model of the truck.
   * @throws IllegalArgumentException if model is an empty string.
   */
  public void setModel(String model) {
    if (model.length() == 0) {
      throw new IllegalArgumentException("`model` must be a non-empty String");
    }
    this.model = model;
  }

  /**
   * Sets the year of manufacture of the truck.
   *
   * @param yearOfManufacture The year of manufacture of the truck.
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
   * Sets the cargo capacity of the truck.
   *
   * @param capacity The cargo capacity of the truck.
   * @throws IllegalArgumentException if the cargo capacity is less than or equal to 0.
   */
  @Override
  public void setCargoCapacity(double capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Cargo capacity must be greater than zero");
    }
    
    this.cargoCapacity = capacity;    
  }

  /**
   * Gets the cargo capacity of the truck.
   *
   * @return The cargo capacity of the truck.
   */
  @Override
  public double getCargoCapacity() {
    return cargoCapacity;
  }

  /**
   * Gets the transmission type of the truck.
   *
   * @return The transmission type of the truck.
   */
  @Override
  public String getTransmissionType() {
    return transmissionType;
  }
  
  /**
   * Sets the transmission type of the truck.
   *
   * @param type The transmission type of the truck.
   * @throws IllegalArgumentException if the transmission type is not valid.
   */
  @Override
  public void setTransmissionType(String type) {
    if (!isValidTransmissionType(type)) {
      throw new IllegalArgumentException("Invalid! Transmission type must be Manual or Automatic.");
    }
    this.transmissionType = type;
  }

  /**
   * Checks if the provided transmission type is valid.
   *
   * @param type The transmission type to check.
   * @return true if the transmission type is valid, false otherwise.
   */
  public boolean isValidTransmissionType(String type) {
    return type.equals("Manual") || type.equals("Automatic");
  }

  /**
   * Returns a string representation of the truck.
   *
   * @return A string representation of the truck.
   */
  public String toString() {
    return "Truck [Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture + ", Cargo Capacity: " + cargoCapacity + " tons, Transmission Type: " + transmissionType + "]";
  }
}
