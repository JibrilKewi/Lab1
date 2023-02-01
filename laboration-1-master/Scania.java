import java.awt.*;

/**
 * Scania is used to create and initialize a Scania object.
 * A Scania object contains all attributes from the super-class Truck, see {@link Truck}.
 * A Scania object is initialized with position along the x- and y- coordinates.
 * The other characteristics are set by default.
 */
public class Scania extends Truck {
    private static final double MAX_TRAILER_ANGLE = 70;

    private double trailerAngle;

    Scania(double xPos, double yPos, Direction dir){
        super(2, 300, Color.black, "Scania", xPos, yPos, dir, 0);

        this.trailerAngle = 0;
    }

    /**
     * Sets trailer angle depending on if truck is moving
     * Check so that the truck is not moving
     * @param angle Desired angle
     */
    public void setSafeTrailerAngle(double angle){
        if(!isMoving()){
            trailerAngle = HelperMethods.amountInterval(angle, 0, MAX_TRAILER_ANGLE);
        }
    }

    /**
     * Raises trailer by desired amount
     * @param amount Amount to raise trailer angle by
     */
    public void raiseTrailer(double amount){
        setSafeTrailerAngle(trailerAngle + amount);
    }

    /**
     * Lowers trailer by desired amount
     * @param amount Amount to lower trailer angle by
     */
    public void lowerTrailer(double amount){
        setSafeTrailerAngle(trailerAngle - amount);
    }

    public double getTrailerAngle(){
        return trailerAngle;
    }

    @Override
    public void incrementSpeed(double amount) {
        if(getTrailerAngle() == 0)
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

}
