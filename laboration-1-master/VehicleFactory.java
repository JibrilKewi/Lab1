import java.util.Random;

public class VehicleFactory {
    static Random rand = new Random();
    public static Vehicle addVehicle(VehicleType type) {
        Vehicle vehicle = null;
        switch (type){
            case SAAB95 -> vehicle = new Saab95(rand.nextInt(700), rand.nextInt(400), Direction.EAST);
            case VOLVO240 -> vehicle = new Volvo240(rand.nextInt(700), rand.nextInt(400), Direction.EAST);
            case SCANIA -> vehicle = new Scania(rand.nextInt(700), rand.nextInt(400), Direction.EAST);
        }
        return vehicle;
    }

}







