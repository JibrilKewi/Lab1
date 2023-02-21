import java.awt.*;

/**
 * Scania is used to create and initialize a Scania object.
 * A Scania object contains all attributes from the super-class Truck, see {@link TrailerTruck}.
 * A Scania object is initialized with position along the x- and y- coordinates.
 * The other characteristics are set by default.
 */
public class Scania extends TrailerTruck implements TrailerMethods{

    Scania(double xPos, double yPos, Direction dir){
        super(2, 100, Color.black, "Scania", xPos, yPos, dir, 0);
    }

    /**
     * isTrailerMovable() checks whether the trailer's angle is at its closed position.
     * @return True if the trailer's angle = 0.
     */
    @Override
    public boolean isTrailerMovable(){
        return getTrailerAngle() == 0;
    }

    /**
     * raiseTrailer() sets the trailer to its closed position.
     */
    @Override
    public void raiseTrailer() {
        trailer.raise();
    }

    /**
     * lowerTrailer() sets the ramp-angle to it's max positon.
     */
    @Override
    public void lowerTrailer() {
        trailer.lower();
    }


    /**
     * getTrailerAngle() is a getter method for the current angle of the trailer.
     * @return The current trailer angle.
     */
    public double getTrailerAngle(){
        return trailer.getAngle();
    }

    /**
     * Raises trailer by desired amount
     * @param amount Amount to raise trailer angle by
     */
    public void raiseTrailer(double amount){
        trailer.raise(amount);
    }

    /**
     * Lowers trailer by desired amount
     * @param amount Amount to lower trailer angle by
     */
    public void lowerTrailer(double amount){
        trailer.lower(amount);
    }
}
