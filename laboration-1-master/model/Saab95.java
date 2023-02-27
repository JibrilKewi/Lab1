package model;

import java.awt.*;

/**
 * model.Saab95 is used to create and initialize a Saab object.
 * A Saab contains all attributes from the super-class car, see {@link Car}.
 * A Saab object is initialized with position along the x- and y-coordinate, all other characteristics
 * are set by default.
 */
public class Saab95 extends Car {

    private boolean turboOn; // Turbo-sate of the saab object.

    public Saab95(double xPos, double yPos, Direction dir) {

        super(2, 120, Color.RED, "model.Saab95", xPos, yPos, dir, 0, 1495);
        this.turboOn = false;
    }

    /**
     * setTurboOn() sets the turbo to "True"
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * setTurboOff() sets the turbo to "false".
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * speedFactor() calculates the speed-factor based on engine-power and if the turbo is on or off.
     * @return Returns the speed-factor.
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.6;
        return getEnginePower() * 0.01 * turbo;
    }

}
