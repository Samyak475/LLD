package Entities;

import Enums.VehicleType;

public class Vehicle {
    private String VehicleId;
    VehicleType vehicleType;

    public Vehicle(String vehicleId, VehicleType vehicleType) {
        VehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(String vehicleId) {
        VehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
