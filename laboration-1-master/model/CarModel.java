package model;

import java.util.ArrayList;
import java.util.List;


public class CarModel{


    ArrayList<MotorizedVehicle> vehicles = new ArrayList<>();

    public void addCar(MotorizedVehicle car) {
        if(vehicles.size() < 10) {
            vehicles.add(car);
        }
    }

    public void removeCar(){
        if(vehicles.size() > 0) {
            vehicles.remove(vehicles.size()-1);
        }
    }


    public void updatePos() {
        for (MotorizedVehicle vehicle : vehicles) {
            if (vehicle.getxPos() > 700 || vehicle.getxPos() < 0 || vehicle.getyPos() > 700 || vehicle.getyPos() < 0){
                vehicle.turnLeft();
                vehicle.turnLeft();
                vehicle.move();
            } else {
                vehicle.move();
            }
        }
    }
    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        System.out.println("Gas: " + gas);
        vehicles.forEach(v -> v.gas(gas));
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        vehicles.forEach(v -> v.brake(brake));
    }

    public void stopEngine() {
        vehicles.forEach(MotorizedVehicle::stopEngine);
    }

    public void startEngine() {
        vehicles.forEach(MotorizedVehicle::startEngine);
    }

    // Calls setTurboOn for all saab objects once
    public void turboOn() {
        for (MotorizedVehicle car : vehicles) {
            if(car instanceof Saab95 saab95){
                saab95.setTurboOn();
            }
        }
    }

    // Calls setTurboOff for all saab objects once
    public void turboOff() {
        for (MotorizedVehicle car : vehicles) {
            if(car instanceof Saab95 saab){
                saab.setTurboOff();
            }
        }
    }
    public void liftBed() {
        for (MotorizedVehicle vehicle : vehicles) {
            if(vehicle instanceof Scania scan){
                scan.raiseTrailer();
            }
        }
    }
    public void lowerBed() {
        for (MotorizedVehicle vehicle : vehicles) {
            if(vehicle instanceof Scania scan){
                scan.lowerTrailer();
            }
        }
    }

    public ArrayList<MotorizedVehicle> getVehicles(){
        return vehicles;
    }


}