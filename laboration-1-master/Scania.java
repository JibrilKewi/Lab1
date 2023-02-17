import java.awt.*;

/**
 * Scania is used to create and initialize a Scania object.
 * A Scania object contains all attributes from the super-class Truck, see {@link TrailerTruck}.
 * A Scania object is initialized with position along the x- and y- coordinates.
 * The other characteristics are set by default.
 */
public class Scania extends TrailerTruck {
    private static final double MAX_TRAILER_ANGLE = 70;

    private double trailerAngle;

    Scania(double xPos, double yPos, Direction dir){
        super(2, 100, Color.black, "Scania", xPos, yPos, dir, 0);

        this.trailerAngle = 0;
    }

    /**
     * isTrailerMovable() checks whether the trailer's angle is at its closed position.
     * @return True if the trailer's angle = 0.
     */
    @Override
    public boolean isTrailerMovable(){
        return trailerAngle == 0;
    }

    /**
     * raiseTrailer() sets the trailer to its closed position.
     */
    @Override
    public void raiseTrailer() {
        setSafeTrailerAngle(0);
    }

    /**
     * lowerTrailer() sets the ramp-angle to it's max positon.
     */
    @Override
    public void lowerTrailer() {
        setSafeTrailerAngle(MAX_TRAILER_ANGLE);
    }

    /**
     * Sets trailer angle depending on if truck is moving
     * Check so that the truck is not moving
     * @param angle Desired angle
     */
    public void setSafeTrailerAngle(double angle){
        if(getCurrentSpeed() == 0)
            trailerAngle = HelperMethods.amountInterval(angle, 0, MAX_TRAILER_ANGLE);
        }

    /**
     * getTrailerAngle() is a getter method for the current angle of the trailer.
     * @return The current trailer angle.
     */
    public double getTrailerAngle(){
        return trailerAngle;
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
}
