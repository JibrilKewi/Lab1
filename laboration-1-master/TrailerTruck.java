import java.awt.*;
/**
 * Truck holds the specifics for a car object.
 */

public abstract class TrailerTruck extends Vehicle{

    TrailerTruck(int nrDoors, double enginePower, Color color, String modelName,
          double xPos, double yPos, Direction dir, double currentSpeed){

        super(nrDoors, enginePower, color, modelName, xPos, yPos, dir, currentSpeed);

    }
    /**
     * isTrailerMovable() is a method for determening if a trailertruck-object is able to move.
     * @return Returns true if truck is movable otherwise false.
     */
    public abstract boolean isTrailerMovable();

    /**
     * speedFactor() calculates the speed-factor based on engine-power.
     * @return Returns the speed-factor.
     */
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }


    @Override
    public void incrementSpeed(double amount) {
        if(isTrailerMovable())
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

}
