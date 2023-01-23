import java.awt.*;

public class Main {
    public static void main(String[] args){

        Volvo240 bettan = new Volvo240(2, 100, Color.black, "Volvo240", 1.25,
                0, 0, Direction.EAST, 0);

        Saab95 saabeN = new Saab95(4, Color.black, 120, "Saab95", true,
                10, 10, Direction.WEST, 1);

        System.out.println(bettan.modelName);
        System.out.println(bettan.color);
        System.out.println(saabeN.currentSpeed);
        System.out.println(saabeN.modelName);
    }
}
