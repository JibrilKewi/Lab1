package model;

import model.Direction;
import model.MotorizedVehicle;

import java.awt.*;

/**
 * model.Car holds the specifics for a car object.
 */
public abstract class Car extends MotorizedVehicle {

    private final double weight;

    Car(int nrDoors, double enginePower, Color color, String modelName,
        double xPos, double yPos, Direction dir, double currentSpeed, double weight){

        super(nrDoors, enginePower, color, modelName, xPos, yPos, dir, currentSpeed);

        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}

