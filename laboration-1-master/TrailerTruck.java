import java.awt.*;
/**
 * TrailerTruck holds the general characteristics and methods for a TrailerTruck object.
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

    /**
     * incrementSpeed() checks if the trailer is movable and increments the speed if isTrailerMovable returns true.
     * @param amount the amount to increase speed with.
     */
    @Override
    public void incrementSpeed(double amount) {
        if(isTrailerMovable())
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    /**
     * decrementSpeed() checks if the trailer is movable and decrements the speed if isTrailerMovable returns true.
     * @param amount the amount to decrease speed with.
     */
    @Override
    public void decrementSpeed(double amount){
        if(isTrailerMovable())
            setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    /**
     * raiseTrailer() is a method used to raise a trailer to its top position.
     */
    public abstract void raiseTrailer();

    /**
     * lowerTrailer() is a method used to lower a trailer to its bottom position.
     */
    public abstract void lowerTrailer();

}
