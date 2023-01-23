import java.awt.*;

public class Main {
    public static void main(String[] args){

        Volvo240 bettan = new Volvo240(2, 100, Color.black, "Volvo240", 1.25);

        Saab95 saabeN = new Saab95(2, Color.black, 120, "Saab95", true);

        System.out.println(bettan.modelName);
        System.out.println(bettan.color);
        System.out.println(saabeN.currentSpeed);
        System.out.println(saabeN.modelName);
    }
}
