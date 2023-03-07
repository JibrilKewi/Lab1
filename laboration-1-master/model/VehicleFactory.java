package model;

import java.util.Random;

public class VehicleFactory {
    private static final int xBound = 500;
    private static final int yBound = 400;
    static Random rand = new Random();
    public static MotorizedVehicle addVehicle(VehicleType type) {
        MotorizedVehicle vehicle = null;
        switch (type){
            case SAAB95 -> vehicle = new Saab95(rand.nextInt(xBound), rand.nextInt(yBound), Direction.EAST);
            case VOLVO240 -> vehicle = new Volvo240(rand.nextInt(xBound), rand.nextInt(yBound), Direction.EAST);
            case SCANIA -> vehicle = new Scania(rand.nextInt(xBound), rand.nextInt(yBound), Direction.EAST);
        }
        return vehicle;
    }

}
