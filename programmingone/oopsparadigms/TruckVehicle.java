package programmingone.oopsparadigms;

public interface TruckVehicle extends Vehicle {
  void setCargoCapacity(double capacity);
  double getCargoCapacity();
  void setTransmissionType(String type);
  String getTransmissionType();
}