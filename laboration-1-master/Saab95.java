import java.awt.*;

/**
 * Saab95 is used to create and initialize a Saab object.
 * A Saab contains all attributes from the super-class car, see {@link Car}.
 * A Saab object is initialized with position along the x- and y-coordinate, all other characteristics
 * are set by default.
 */
public class Saab95 extends Car {

    private boolean turboOn;

    Saab95(double xPos, double yPos, Direction dir) {

        super(2, 120, Color.RED, "Saab95", xPos, yPos, dir, 0);
        this.turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}
