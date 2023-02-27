package model;

import model.MotorizedVehicle;
import model.Saab95;
import model.Scania;

import java.util.ArrayList;

public class CarModel {

    ArrayList<MotorizedVehicle> cars = new ArrayList<>();

    public void addCar(MotorizedVehicle car) {
        if(cars.size() < 10) {
            cars.add(car);
        }
    }

    public void removeCar(){
        if(cars.size() > 0) {
            cars.remove(cars.size()-1);
        }
    }

    public void updatePos() {
        for (MotorizedVehicle vehicle : cars) {
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
        for (MotorizedVehicle vehicle : cars) {
            vehicle.gas(gas);
        }
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorizedVehicle vehicle : cars) {
            vehicle.brake(brake);
        }
    }

    public void stopEngine() {
        for (MotorizedVehicle vehicle : cars) {
            vehicle.stopEngine();
        }
    }

    public void startEngine() {
        for (MotorizedVehicle vehicle : cars) {
            vehicle.startEngine();
        }
    }

    // Calls setTurboOn for all saab objects once
    public void turboOn() {
        for (MotorizedVehicle car : cars) {
            if(car instanceof Saab95 saab95){
                saab95.setTurboOn();
            }
        }
    }

    // Calls setTurboOff for all saab objects once
    public void turboOff() {
        for (MotorizedVehicle car : cars) {
            if(car instanceof Saab95 saab){
                saab.setTurboOff();
            }
        }
    }
    public void liftBed() {
        for (MotorizedVehicle vehicle : cars) {
            if(vehicle instanceof Scania scan){
                scan.raiseTrailer();
            }
        }
    }
    public void lowerBed() {
        for (MotorizedVehicle vehicle : cars) {
            if(vehicle instanceof Scania scan){
                scan.lowerTrailer();
            }
        }
    }

    public ArrayList<MotorizedVehicle> getCars(){
        return cars;
    }

}