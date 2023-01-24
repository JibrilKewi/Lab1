import java.awt.*;

/**
 * Saab95 is used to create and initialize a Saab object.
 * A Saab contains all constructors from the super-class car, see {@link Car}.
 * The Saab object is unique to a car since it's speed factor is different and dependant upon the turbo,
 * and if the turbo is on or off.
 * Saab95 also contains a method for setting the turbo on and off.
 */
public class Saab95 extends Car {

    private boolean turboOn;

    Saab95(double xPos, double yPos, Direction dir, double currentSpeed) {

        super(2, 120, Color.RED, "Saab95", xPos, yPos, dir, currentSpeed);
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
