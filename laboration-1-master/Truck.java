import java.awt.*;

public abstract class Truck extends Vehicle{
    //ToDo Last-funktion

    Truck(int nrDoors, double enginePower, Color color, String modelName,
          double xPos, double yPos, Direction dir, double currentSpeed){

        super(nrDoors, enginePower, color, modelName, xPos, yPos, dir, currentSpeed);

    }

    public boolean isMoving(){
        return getCurrentSpeed() > 0;
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }



}
