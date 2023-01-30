import java.awt.*;

public class Scania extends Truck {
    private static final double MAX_TRAILER_ANGLE = 70;

    private double trailerAngle;

    Scania(double xPos, double yPos, Direction dir){
        super(2, 300, Color.black, "Scania", xPos, yPos, dir, 0);

        this.trailerAngle = 0;
    }

    public void setSafeTrailerAngle(double angle){
        if(!isMoving()){
            trailerAngle = HelperMethods.amountInterval(angle, 0, MAX_TRAILER_ANGLE);
        }
    }

    public void raiseTrailer(double amount){
        setSafeTrailerAngle(trailerAngle + amount);
    }

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
