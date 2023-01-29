import java.awt.*;

public abstract class Vehicle extends AbstractMovable {
    private final int nrDoors; // The number of doors in the car.
    private final double enginePower; // The engine power of the car.
    private Color color; // The color of the car.
    private final String modelName; // The model name of the car.

    Vehicle(int nrDoors, double enginePower, Color color, String modelName,
            double xPos, double yPos, Direction dir, double currentSpeed){

        super(xPos, yPos, dir, currentSpeed);

        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }


    /**
     * speedfactor() is a contract for inheritors to implement a speed-factor method.
     * @return Returns the speed-factor.
     */
    public abstract double speedFactor();

    /**
     * Getter method that returns the number of doors
     * @return Returns the number of doors for a car
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Getter method that returns the engine power
     * @return Returns the engine power of the car
     */
    public double getEnginePower(){
        return enginePower;
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
     *  Start the engine of the car and sets the current speed to 0.1 miles per hour.
     */
    public void startEngine(){ setCurrentSpeed(0.1); }

    /**
     * Stop the engine of the car and sets the current speed to 0.0 miles per hour.
     */
    public void stopEngine(){ setCurrentSpeed(0.0); }

    /**
     * Increment the current speed of the car by a given amount.
     * The new speed will not exceed the car's engine power.
     * @param amount The amount to increment the current speed by, measured in miles per hour.
     */
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * Decrement the current speed of the car by a given amount, cannot be less than 0.
     * @param amount The amount to decrement the current speed by, measured in miles per hour.
     */
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    /**
     * Increase the current speed of the car by a given amount, where the amount is normalized between 0 and 1.
     * @param amount A value between 0 and 1 representing the proportion of the engine power to increase the speed by.
     */
    public void gas(double amount){
        incrementSpeed(HelperMethods.amountInterval(amount, 0, 1));
    }

    /**
     * Decrease the current speed of the car by a given amount, where the amount is normalized between 0 and 1.
     * @param amount A value between 0 and 1 representing the proportion of the current speed to decrease the speed by.
     */
    public void brake(double amount){
        decrementSpeed(HelperMethods.amountInterval(amount, 0, 1));
    }
}


