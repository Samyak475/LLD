package entities;

import enums.VehicleStatus;
import enums.VehicleType;

public class Vehicle {
    int vehicleId;
    double dailyBasisRent;
    VehicleType vehicleType;
    VehicleStatus vehicleStatus;

    public Vehicle(int vehicleId,double dailyBasisRent,VehicleType vehicleType){
        this.vehicleId = vehicleId;
        this.dailyBasisRent = dailyBasisRent;
        this.vehicleType = vehicleType;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getDailyBasisRent() {
        return dailyBasisRent;
    }

    public void setDailyBasisRent(double dailyBasisRent) {
        this.dailyBasisRent = dailyBasisRent;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
