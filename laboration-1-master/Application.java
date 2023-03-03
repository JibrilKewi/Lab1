import model.CarModel;
import model.VehicleController;

import javax.swing.*;
public class Application {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Carsim");
        CarModel carModel = new CarModel();
        VehicleView view = new VehicleView(carModel);
        MovementController vc = new MovementController(carModel, view);
        VehicleController c = new VehicleController(carModel);
        view.addControlListener(c);
        frame.add(view);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Timer(10, vc).start();
    }
}