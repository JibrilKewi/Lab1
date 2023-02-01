import java.awt.*;
/**
 * Truck holds the specifics for a car object.
 */

public abstract class Truck extends Vehicle{

    Truck(int nrDoors, double enginePower, Color color, String modelName,
          double xPos, double yPos, Direction dir, double currentSpeed){

        super(nrDoors, enginePower, color, modelName, xPos, yPos, dir, currentSpeed);

    }
    /**
     * isMoving() is a method for determening if a truck-object is moving.
     * @return Returns true if truck is moving otherwise false.
     */
    public boolean isMoving(){
        return getCurrentSpeed() > 0;
    }

    /**
     * speedFactor() calculates the speed-factor based on engine-power.
     * @return Returns the speed-factor.
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }



}
