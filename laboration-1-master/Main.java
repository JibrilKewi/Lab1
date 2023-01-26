import java.awt.*;

public class Main {
    public static void main(String[] args){

        Volvo240 bettan = new Volvo240(1, 1, Direction.NORTH);

        Saab95 saabeN = new Saab95(1,1, Direction.NORTH);

        System.out.println(bettan.modelName);
        System.out.println(bettan.color);
        System.out.println(saabeN.currentSpeed);
        System.out.println(saabeN.modelName);
    }
}
