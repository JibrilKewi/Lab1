package model;

import java.awt.*;
/**
 * model.Vehicle collects and handles all common traits of vehicles. It stores the characteristics of a car such as:
 * number of doors, engine power, color, model name.
 * It also contains methods for getting and setting these characteristics along with methods for incrementing and
 * decrementing speed.
 */
public abstract class Vehicle extends AbstractMovable {
    private final int nrDoors; // The number of doors in the car.

    public Color color; // The color of the car.
    public final String modelName; // The model name of the car.

    Vehicle(int nrDoors, Color color, String modelName,
            double xPos, double yPos, Direction dir, double currentSpeed){

        super(xPos, yPos, dir, currentSpeed);

        this.nrDoors = nrDoors;
        this.color = color;
        this.modelName = modelName;
    }



    /**
     * Getter method that returns the number of doors
     * @return Returns the number of doors for a car
     */
    public int getNrDoors(){
        return nrDoors;
    }


    /**
     * Getter method that returns the color
     * @return Returns the color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * Setter method that sets given color
     * @param clr The color to set for the car
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Increment the current speed of the car by a given amount.
     * The new speed will not exceed the car's engine power.
     * @param amount The amount to increment the current speed by, measured in miles per hour.
     */
    public abstract void incrementSpeed(double amount);

    /**
     * Decrement the current speed of the car by a given amount, cannot be less than 0.
     * @param amount The amount to decrement the current speed by, measured in miles per hour.
     */
    public abstract void decrementSpeed(double amount);

    /**
     * speedfactor() is a contract for inheritors to implement a speed-factor method.
     * @return Returns the speed-factor.
     */
    public abstract double speedFactor();

}


