import Control.*;
import View.*;
import model.*;


import javax.swing.*;
public class Application {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Carsim");
        World v = new World();
        ModelTimer t = new ModelTimer(v);
        VehicleView view = new VehicleView(v);
        VehicleController c = new VehicleController(v);
        v.addListener(view);
        view.addControlListener(c);
        frame.add(view);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        t.start();
    }
}